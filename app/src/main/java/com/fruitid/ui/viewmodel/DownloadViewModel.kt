package com.fruitid.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.fruitid.BuildConfig
import com.fruitid.data.download.DownloadProgress
import com.fruitid.data.download.DownloadState
import com.fruitid.data.download.ModelDownloadManager
import com.fruitid.data.local.prefs.SettingsPrefs
import com.fruitid.data.repository.ModelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DownloadViewModel @Inject constructor(
    application: Application,
    private val downloadManager: ModelDownloadManager,
    private val modelRepository: ModelRepository,
    private val settingsPrefs: SettingsPrefs
) : AndroidViewModel(application) {

    val uiState: StateFlow<DownloadState> = downloadManager.downloadState
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), DownloadState.IDLE)

    val downloadProgress: StateFlow<DownloadProgress> = downloadManager.progress
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 
            DownloadProgress(0L, 0L, 0L, DownloadState.IDLE))

    init {
        viewModelScope.launch {
            // Check if model already downloaded
            if (modelRepository.isModelDownloaded()) {
                downloadManager.resumeDownload()
            }
        }
    }

    fun startDownload(useMobileData: Boolean) {
        viewModelScope.launch {
            // TODO: Get HuggingFace token from user input or secure storage
            val hfToken = BuildConfig.HF_TOKEN.takeIf { it.isNotBlank() }
            downloadManager.startDownload(
                url = BuildConfig.MODEL_URL,
                expectedSha256 = BuildConfig.MODEL_SHA256,
                useMobileData = useMobileData,
                authToken = hfToken
            )
        }
    }

    fun cancelDownload() {
        downloadManager.cancelDownload()
    }

    fun resumeDownload() {
        viewModelScope.launch {
            val useMobileData = settingsPrefs.allowMobileData.first()
            startDownload(useMobileData)
        }
    }

    fun retryDownload() {
        viewModelScope.launch {
            val useMobileData = settingsPrefs.allowMobileData.first()
            startDownload(useMobileData)
        }
    }

    fun retryFromBeginning() {
        viewModelScope.launch {
            downloadManager.reset()
            val useMobileData = settingsPrefs.allowMobileData.first()
            startDownload(useMobileData)
        }
    }

    fun canResume(): Boolean {
        return modelRepository.getDownloadedBytes() > 0
    }

    fun getRequiredStorage(): Long {
        return downloadManager.getStorageRequiredMB()
    }
}
