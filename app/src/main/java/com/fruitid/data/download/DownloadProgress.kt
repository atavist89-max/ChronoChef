package com.fruitid.data.download

data class DownloadProgress(
    val bytesDownloaded: Long,
    val totalBytes: Long,
    val speedBytesPerSecond: Long,
    val state: DownloadState
) {
    val progressPercent: Float
        get() = if (totalBytes > 0) (bytesDownloaded.toFloat() / totalBytes) else 0f

    val isComplete: Boolean
        get() = state == DownloadState.COMPLETED

    val isFailed: Boolean
        get() = state == DownloadState.FAILED || 
                state == DownloadState.CORRUPTED || 
                state == DownloadState.STORAGE_FULL
}

enum class DownloadState {
    IDLE,
    DOWNLOADING,
    PAUSED,
    VERIFYING,
    MOVING,
    COMPLETED,
    FAILED,
    CANCELLED,
    CORRUPTED,
    STORAGE_FULL,
    NETWORK_ERROR
}

sealed class DownloadError(message: String) : Throwable(message) {
    object NetworkError : DownloadError("Network connection lost")
    object StorageFull : DownloadError("Storage full")
    object Corrupted : DownloadError("File corrupted")
    object Cancelled : DownloadError("Download cancelled")
    data class Generic(val error: String) : DownloadError(error)
}
