package com.fruitid.data.download

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.RandomAccessFile
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.coroutineContext

@Singleton
class ResumableDownloader @Inject constructor() {

    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .pingInterval(10, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .followRedirects(true)
        .followSslRedirects(true)
        .build()

    suspend fun download(
        url: String,
        destinationFile: File,
        startByte: Long = 0,
        authToken: String? = null,
        onProgress: suspend (DownloadProgress) -> Unit
    ): Result<Long> = withContext(Dispatchers.IO) {
        try {
            // Create parent directories if needed
            destinationFile.parentFile?.mkdirs()

            // Get file size
            val fileSize = getFileSize(url, authToken) ?: return@withContext Result.failure(
                IOException("Failed to get file size")
            )

            // Determine start position
            val resumePosition = if (startByte > 0 && destinationFile.exists()) {
                minOf(startByte, destinationFile.length())
            } else 0L

            // Build request with Range header if resuming
            val requestBuilder = Request.Builder()
                .url(url)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "identity")

            // Add HuggingFace auth token if provided
            if (!authToken.isNullOrBlank()) {
                requestBuilder.header("Authorization", "Bearer $authToken")
            }

            if (resumePosition > 0) {
                requestBuilder.header("Range", "bytes=$resumePosition-")
            }

            val request = requestBuilder.build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful && response.code != 206) {
                    return@withContext Result.failure(
                        IOException("HTTP ${response.code}: ${response.message}")
                    )
                }

                val body = response.body ?: return@withContext Result.failure(
                    IOException("Empty response body")
                )

                // Open file for appending or writing
                val appendMode = resumePosition > 0 && response.code == 206
                val outputStream = FileOutputStream(destinationFile, appendMode)
                val inputStream = body.byteStream()

                var bytesDownloaded = resumePosition
                val buffer = ByteArray(8192)
                var lastProgressUpdate = System.currentTimeMillis()
                var bytesSinceLastUpdate = 0L

                outputStream.use { output ->
                    inputStream.use { input ->
                        while (coroutineContext.isActive) {
                            val bytesRead = input.read(buffer)
                            if (bytesRead == -1) break

                            output.write(buffer, 0, bytesRead)
                            bytesDownloaded += bytesRead
                            bytesSinceLastUpdate += bytesRead

                            // Update progress every 500ms
                            val now = System.currentTimeMillis()
                            if (now - lastProgressUpdate >= 500) {
                                val speed = bytesSinceLastUpdate * 1000 / (now - lastProgressUpdate)
                                onProgress(
                                    DownloadProgress(
                                        bytesDownloaded = bytesDownloaded,
                                        totalBytes = fileSize,
                                        speedBytesPerSecond = speed,
                                        state = DownloadState.DOWNLOADING
                                    )
                                )
                                lastProgressUpdate = now
                                bytesSinceLastUpdate = 0
                            }
                        }
                    }
                }

                // Final progress update
                onProgress(
                    DownloadProgress(
                        bytesDownloaded = bytesDownloaded,
                        totalBytes = fileSize,
                        speedBytesPerSecond = 0,
                        state = DownloadState.COMPLETED
                    )
                )

                Result.success(bytesDownloaded)
            }
        } catch (e: IOException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private suspend fun getFileSize(url: String, authToken: String? = null): Long? = withContext(Dispatchers.IO) {
        try {
            val requestBuilder = Request.Builder()
                .url(url)
                .head()
            
            if (!authToken.isNullOrBlank()) {
                requestBuilder.header("Authorization", "Bearer $authToken")
            }
            
            val request = requestBuilder.build()

            client.newCall(request).execute().use { response ->
                if (response.isSuccessful) {
                    response.header("Content-Length")?.toLongOrNull()
                } else null
            }
        } catch (e: Exception) {
            null
        }
    }

    fun cancel() {
        // Cancel all ongoing calls
        client.dispatcher.cancelAll()
    }

    fun cleanup() {
        client.dispatcher.executorService.shutdown()
        client.connectionPool.evictAll()
    }
}
