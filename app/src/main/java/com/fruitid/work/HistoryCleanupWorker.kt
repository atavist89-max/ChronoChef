package com.fruitid.work

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.fruitid.data.local.prefs.SettingsPrefs
import com.fruitid.data.repository.DetectionRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.util.concurrent.TimeUnit

@HiltWorker
class HistoryCleanupWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val detectionRepository: DetectionRepository,
    private val settingsPrefs: SettingsPrefs
) : CoroutineWorker(context, params) {

    companion object {
        const val WORK_NAME = "history_cleanup"
        const val DAYS_TO_KEEP = 30L

        fun createPeriodicWorkRequest(): PeriodicWorkRequest {
            return PeriodicWorkRequestBuilder<HistoryCleanupWorker>(1, TimeUnit.DAYS)
                .addTag(WORK_NAME)
                .build()
        }
    }

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            // Delete old detections and get thumbnail paths
            val oldThumbnailPaths = detectionRepository.deleteOldDetections(DAYS_TO_KEEP.toInt())

            // Delete associated thumbnail files
            oldThumbnailPaths.forEach { path ->
                try {
                    File(path).delete()
                } catch (e: Exception) {
                    // Ignore deletion errors
                }
            }

            // Update last cleanup timestamp
            settingsPrefs.setLastCleanupTimestamp(System.currentTimeMillis())

            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}
