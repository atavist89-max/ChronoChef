package com.fruitid.data.download

import android.content.Context
import com.fruitid.data.local.prefs.SettingsPrefs
import com.fruitid.data.repository.ModelRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ModelDownloadManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val downloader: ResumableDownloader,
    private val modelRepository: ModelRepository,
    private val settingsPrefs: SettingsPrefs
) {
    private val _downloadState = MutableStateFlow(DownloadState.IDLE)
    val downloadState: StateFlow<DownloadState> = _downloadState.asStateFlow()

    private val _progress = MutableStateFlow(
        DownloadProgress(0L, 0L, 0L, DownloadState.IDLE)
    )
    val progress: StateFlow<DownloadProgress> = _progress.asStateFlow()

    private var isCancelled = false

    suspend fun startDownload(
        url: String,
        expectedSha256: String,
        useMobileData: Boolean = false,
        authToken: String? = null
    ): Result<Unit> = withContext(Dispatchers.IO) {
        isCancelled = false
        _downloadState.value = DownloadState.DOWNLOADING

        try {
            // Check storage
            if (!modelRepository.hasEnoughStorage()) {
                _downloadState.value = DownloadState.STORAGE_FULL
                _progress.value = _progress.value.copy(state = DownloadState.STORAGE_FULL)
                return@withContext Result.failure(DownloadError.StorageFull)
            }

            val tempFile = File(modelRepository.getTempModelPath())
            val startByte = modelRepository.getDownloadedBytes()

            // Save progress for resume
            settingsPrefs.setDownloadProgressBytes(startByte)

            val result = downloader.download(
                url = url,
                destinationFile = tempFile,
                startByte = startByte,
                authToken = authToken
            ) { progress ->
                _progress.value = progress
                settingsPrefs.setDownloadProgressBytes(progress.bytesDownloaded)
            }

            if (isCancelled) {
                _downloadState.value = DownloadState.CANCELLED
                return@withContext Result.failure(DownloadError.Cancelled)
            }

            if (result.isFailure) {
                val error = result.exceptionOrNull()
                _downloadState.value = if (error is java.net.UnknownHostException || 
                                          error is java.net.SocketTimeoutException) {
                    DownloadState.NETWORK_ERROR
                } else {
                    DownloadState.FAILED
                }
                return@withContext Result.failure(
                    error ?: Exception("Download failed")
                )
            }

            // Verify checksum
            _downloadState.value = DownloadState.VERIFYING
            _progress.value = _progress.value.copy(state = DownloadState.VERIFYING)

            val isValid = modelRepository.verifyModelChecksum(expectedSha256)
            
            if (!isValid) {
                _downloadState.value = DownloadState.CORRUPTED
                _progress.value = _progress.value.copy(state = DownloadState.CORRUPTED)
                modelRepository.deleteTempFile()
                settingsPrefs.clearDownloadProgress()
                return@withContext Result.failure(DownloadError.Corrupted)
            }

            // Move to final location
            _downloadState.value = DownloadState.MOVING
            _progress.value = _progress.value.copy(state = DownloadState.MOVING)

            val moveSuccess = modelRepository.moveTempToFinal()
            
            if (!moveSuccess) {
                _downloadState.value = DownloadState.FAILED
                return@withContext Result.failure(Exception("Failed to move model file"))
            }

            // Clear progress
            settingsPrefs.clearDownloadProgress()
            settingsPrefs.setFirstDownloadComplete(true)
            settingsPrefs.setAllowMobileData(true)

            _downloadState.value = DownloadState.COMPLETED
            _progress.value = _progress.value.copy(state = DownloadState.COMPLETED)

            Result.success(Unit)

        } catch (e: Exception) {
            _downloadState.value = DownloadState.FAILED
            Result.failure(e)
        }
    }

    fun cancelDownload() {
        isCancelled = true
        downloader.cancel()
        _downloadState.value = DownloadState.CANCELLED
    }

    fun resumeDownload() {
        _downloadState.value = DownloadState.IDLE
        _progress.value = DownloadProgress(0L, 0L, 0L, DownloadState.IDLE)
    }

    fun getStorageRequiredMB(): Long {
        val available = modelRepository.getAvailableStorageMB()
        val required = ModelRepository.REQUIRED_FREE_SPACE_MB
        return if (available < required) required - available else 0
    }

    fun reset() {
        isCancelled = false
        _downloadState.value = DownloadState.IDLE
        _progress.value = DownloadProgress(0L, 0L, 0L, DownloadState.IDLE)
        modelRepository.deleteTempFile()
    }
}
