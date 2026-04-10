package com.fruitid.ml

import android.content.Context
import android.graphics.Bitmap
import com.fruitid.data.repository.ModelRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.gpu.GpuDelegate
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GemmaInference @Inject constructor(
    @ApplicationContext private val context: Context,
    private val modelRepository: ModelRepository,
    private val inputProcessor: GemmaInputProcessor,
    private val outputParser: GemmaOutputParser
) {
    private var interpreter: Interpreter? = null
    private var gpuDelegate: GpuDelegate? = null
    private val lock = Object()

    companion object {
        const val MAX_DETECTIONS = 10
        const val INPUT_SIZE = 448
    }

    fun initialize(): Boolean {
        synchronized(lock) {
            if (interpreter != null) return true

            val modelPath = modelRepository.getModelPath()
            val modelFile = java.io.File(modelPath)
            
            if (!modelFile.exists()) {
                return false
            }

            return try {
                // Memory map the model
                val mappedModel = loadModelFile(modelPath)
                
                // Configure interpreter options
                val options = Interpreter.Options().apply {
                    setNumThreads(4)
                    
                    // Try GPU delegate
                    try {
                        gpuDelegate = GpuDelegate()
                        addDelegate(gpuDelegate)
                    } catch (e: Exception) {
                        // GPU not available, use CPU
                    }
                    
                    setUseXNNPACK(true)
                }

                interpreter = Interpreter(mappedModel, options)
                true
            } catch (e: Exception) {
                e.printStackTrace()
                false
            }
        }
    }

    fun isInitialized(): Boolean {
        return interpreter != null
    }

    fun detect(bitmap: Bitmap): List<DetectionResult> {
        val interp = interpreter ?: return emptyList()

        return try {
            // Preprocess image
            val inputBuffer = inputProcessor.createInputBuffer(bitmap)

            // Run inference
            // Note: Actual output shape depends on Gemma model specification
            // This is a placeholder for the expected output format
            val outputMap = HashMap<Int, Any>()
            
            // Allocate output buffers based on model output spec
            // Gemma typically outputs text/tokens
            val outputBuffer = ByteBuffer.allocateDirect(4096) // Max output size
            
            outputMap[0] = outputBuffer

            interp.run(inputBuffer, outputMap)

            // Parse output as string (JSON)
            outputBuffer.rewind()
            val outputBytes = ByteArray(outputBuffer.remaining())
            outputBuffer.get(outputBytes)
            val outputString = String(outputBytes, Charsets.UTF_8).trim { it <= ' ' || it == '\u0000' }

            // Parse JSON output
            outputParser.parseOutput(outputString)

        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    fun detectFromProxy(imageProxy: androidx.camera.core.ImageProxy): List<DetectionResult> {
        return try {
            // Convert ImageProxy to Bitmap
            val bitmap = imageProxyToBitmap(imageProxy)
            detect(bitmap)
        } catch (e: Exception) {
            emptyList()
        }
    }

    private fun imageProxyToBitmap(imageProxy: androidx.camera.core.ImageProxy): Bitmap {
        val buffer = imageProxy.planes[0].buffer
        val bytes = ByteArray(buffer.remaining())
        buffer.get(bytes)
        
        // Use ImageProxy dimensions
        val width = imageProxy.width
        val height = imageProxy.height
        
        // Create bitmap from YUV if needed
        // Simplified: return empty bitmap for now
        return Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    }

    fun close() {
        synchronized(lock) {
            interpreter?.close()
            interpreter = null
            gpuDelegate?.close()
            gpuDelegate = null
        }
    }

    private fun loadModelFile(modelPath: String): MappedByteBuffer {
        FileInputStream(modelPath).use { inputStream ->
            val fileChannel = inputStream.channel
            val startOffset = 0L
            val declaredLength = fileChannel.size()
            return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
        }
    }

    fun getModelSize(): Long {
        return modelRepository.getModelSize()
    }
}
