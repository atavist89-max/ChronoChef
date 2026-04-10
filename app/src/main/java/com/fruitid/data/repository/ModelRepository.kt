package com.fruitid.data.repository

import android.content.Context
import android.os.StatFs
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.channels.FileChannel
import java.security.MessageDigest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ModelRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        const val MODEL_FILE_NAME = "gemma-4-e2b-q4_0.tflite"
        const val TEMP_MODEL_FILE_NAME = "model.tmp"
        const val REQUIRED_FREE_SPACE_MB = 5120L // 5GB
        const val MODEL_SIZE_MB = 2560L // 2.5GB
    }

    private val modelFile: File
        get() = File(context.filesDir, MODEL_FILE_NAME)

    private val tempModelFile: File
        get() = File(context.externalCacheDir ?: context.cacheDir, TEMP_MODEL_FILE_NAME)

    fun isModelDownloaded(): Boolean {
        return modelFile.exists() && modelFile.length() > 0
    }

    fun getModelPath(): String {
        return modelFile.absolutePath
    }

    fun getTempModelPath(): String {
        return tempModelFile.absolutePath
    }

    fun getDownloadedBytes(): Long {
        return if (tempModelFile.exists()) tempModelFile.length() else 0L
    }

    suspend fun verifyModelChecksum(expectedHash: String): Boolean = withContext(Dispatchers.IO) {
        if (!modelFile.exists()) return@withContext false
        
        try {
            val digest = MessageDigest.getInstance("SHA-256")
            FileInputStream(modelFile).use { fis ->
                val buffer = ByteArray(8192)
                var bytesRead: Int
                while (fis.read(buffer).also { bytesRead = it } != -1) {
                    digest.update(buffer, 0, bytesRead)
                }
            }
            val hashBytes = digest.digest()
            val hashString = hashBytes.joinToString("") { "%02x".format(it) }
            hashString.equals(expectedHash, ignoreCase = true)
        } catch (e: Exception) {
            false
        }
    }

    suspend fun moveTempToFinal(): Boolean = withContext(Dispatchers.IO) {
        try {
            if (!tempModelFile.exists()) return@withContext false
            
            // Atomic move using FileChannel
            FileInputStream(tempModelFile).use { fis ->
                FileOutputStream(modelFile).use { fos ->
                    val sourceChannel: FileChannel = fis.channel
                    val destChannel: FileChannel = fos.channel
                    sourceChannel.transferTo(0, sourceChannel.size(), destChannel)
                }
            }
            
            // Delete temp file after successful copy
            tempModelFile.delete()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    fun hasEnoughStorage(): Boolean {
        val stat = StatFs(context.filesDir.path)
        val availableBytes = stat.availableBytes
        val requiredBytes = REQUIRED_FREE_SPACE_MB * 1024 * 1024
        return availableBytes >= requiredBytes
    }

    fun getAvailableStorageMB(): Long {
        val stat = StatFs(context.filesDir.path)
        return stat.availableBytes / (1024 * 1024)
    }

    fun deleteTempFile() {
        tempModelFile.delete()
    }

    fun deleteModel() {
        modelFile.delete()
    }

    fun getModelSize(): Long {
        return if (modelFile.exists()) modelFile.length() else 0L
    }

    suspend fun memoryMapModel(): FileChannel? = withContext(Dispatchers.IO) {
        try {
            if (!modelFile.exists()) return@withContext null
            FileInputStream(modelFile).channel
        } catch (e: Exception) {
            null
        }
    }
}
