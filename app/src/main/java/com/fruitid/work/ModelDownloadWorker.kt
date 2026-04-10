package com.fruitid.work

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.fruitid.data.download.ModelDownloadManager
import com.fruitid.data.local.prefs.SettingsPrefs
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext

@HiltWorker
class ModelDownloadWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val downloadManager: ModelDownloadManager,
    private val settingsPrefs: SettingsPrefs
) : CoroutineWorker(context, params) {

    companion object {
        const val WORK_NAME = "model_download"
        const val CHANNEL_ID = "model_download_channel"
        const val NOTIFICATION_ID = 1001
        
        const val KEY_URL = "url"
        const val KEY_SHA256 = "sha256"
        const val KEY_USE_MOBILE_DATA = "use_mobile_data"
        
        const val PROGRESS_BYTES = "progress_bytes"
        const val PROGRESS_TOTAL = "progress_total"
        const val PROGRESS_SPEED = "progress_speed"
        const val PROGRESS_STATE = "progress_state"

        fun createWorkRequest(
            url: String,
            sha256: String,
            useMobileData: Boolean
        ): OneTimeWorkRequest {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(
                    if (useMobileData) NetworkType.CONNECTED else NetworkType.UNMETERED
                )
                .setRequiresStorageNotLow(true)
                .build()

            val data = workDataOf(
                KEY_URL to url,
                KEY_SHA256 to sha256,
                KEY_USE_MOBILE_DATA to useMobileData
            )

            return OneTimeWorkRequestBuilder<ModelDownloadWorker>()
                .setConstraints(constraints)
                .setInputData(data)
                .addTag(WORK_NAME)
                .build()
        }
    }

    override suspend fun doWork(): Result {
        createNotificationChannel()
        
        val url = inputData.getString(KEY_URL) ?: return Result.failure()
        val sha256 = inputData.getString(KEY_SHA256) ?: return Result.failure()
        val useMobileData = inputData.getBoolean(KEY_USE_MOBILE_DATA, false)

        return try {
            setForeground(createForegroundInfo("Starting download..."))

            val result = downloadManager.startDownload(url, sha256, useMobileData)

            if (result.isSuccess) {
                settingsPrefs.setFirstDownloadComplete(true)
                Result.success()
            } else {
                val error = result.exceptionOrNull()
                when {
                    error?.message?.contains("Storage") == true -> {
                        Result.failure(workDataOf("error" to "storage_full"))
                    }
                    error?.message?.contains("Network") == true -> {
                        Result.retry()
                    }
                    else -> {
                        Result.failure(workDataOf("error" to (error?.message ?: "unknown")))
                    }
                }
            }
        } catch (e: Exception) {
            Result.failure(workDataOf("error" to e.message))
        }
    }

    private fun createForegroundInfo(progress: String): ForegroundInfo {
        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setContentTitle("Downloading Fruit Identifier Model")
            .setContentText(progress)
            .setSmallIcon(android.R.drawable.stat_sys_download)
            .setOngoing(true)
            .setProgress(100, 0, true)
            .build()

        return ForegroundInfo(NOTIFICATION_ID, notification)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Model Download",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Shows progress for model downloads"
            }

            val notificationManager = applicationContext.getSystemService(
                Context.NOTIFICATION_SERVICE
            ) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
