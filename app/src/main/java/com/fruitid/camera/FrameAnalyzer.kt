package com.fruitid.camera

import android.graphics.Bitmap
import android.os.SystemClock
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.fruitid.ml.DetectionResult
import com.fruitid.ml.GemmaInference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.math.abs

class FrameAnalyzer @Inject constructor(
    private val inference: GemmaInference,
    private val converter: YuvToBitmapConverter
) : ImageAnalysis.Analyzer {

    companion object {
        const val FRAME_SKIP = 3 // Analyze every 3rd frame
        const val MOTION_THRESHOLD = 5000 // Pixel difference threshold
        const val STANDBY_TIMEOUT_MS = 2500L
        const val ANALYSIS_SIZE = 448
    }

    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    
    private var frameCount = 0
    private var lastAnalysisTime = 0L
    private var lastBitmap: Bitmap? = null
    private var lastMotionTime = SystemClock.elapsedRealtime()
    private var isStandby = false
    
    var onDetections: ((List<DetectionResult>) -> Unit)? = null
    var onStandbyStateChange: ((Boolean) -> Unit)? = null
    var onMotionDetected: (() -> Unit)? = null

    override fun analyze(imageProxy: ImageProxy) {
        frameCount++
        
        // Skip frames for performance
        if (frameCount % FRAME_SKIP != 0) {
            imageProxy.close()
            return
        }

        // Check if inference is ready
        if (!inference.isInitialized()) {
            imageProxy.close()
            return
        }

        scope.launch {
            try {
                // Convert to bitmap
                val bitmap = withContext(Dispatchers.Default) {
                    converter.convert(imageProxy.image!!, imageProxy.imageInfo.rotationDegrees)
                }

                // Check for motion
                val hasMotion = detectMotion(bitmap)
                
                if (hasMotion) {
                    lastMotionTime = SystemClock.elapsedRealtime()
                    if (isStandby) {
                        isStandby = false
                        onStandbyStateChange?.invoke(false)
                    }
                    onMotionDetected?.invoke()
                } else {
                    // Check for standby
                    val timeSinceMotion = SystemClock.elapsedRealtime() - lastMotionTime
                    if (timeSinceMotion > STANDBY_TIMEOUT_MS && !isStandby) {
                        isStandby = true
                        onStandbyStateChange?.invoke(true)
                    }
                }

                // Only run inference if not in standby
                if (!isStandby) {
                    // Resize for model input
                    val resizedBitmap = Bitmap.createScaledBitmap(
                        bitmap, 
                        ANALYSIS_SIZE, 
                        ANALYSIS_SIZE, 
                        true
                    )

                    // Run inference
                    val detections = inference.detect(resizedBitmap)

                    // Return results on main thread
                    withContext(Dispatchers.Main) {
                        onDetections?.invoke(detections)
                    }

                    resizedBitmap.recycle()
                }

                // Store for motion detection
                lastBitmap?.recycle()
                lastBitmap = bitmap

            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                imageProxy.close()
            }
        }
    }

    private fun detectMotion(current: Bitmap): Boolean {
        val previous = lastBitmap ?: return true // First frame has motion
        
        if (previous.width != current.width || previous.height != current.height) {
            return true
        }

        // Sample pixels for motion detection (performance optimization)
        var diffSum = 0L
        val sampleStep = 10
        var sampleCount = 0

        for (y in 0 until current.height step sampleStep) {
            for (x in 0 until current.width step sampleStep) {
                val currentPixel = current.getPixel(x, y)
                val previousPixel = previous.getPixel(x, y)
                
                val rDiff = abs(((currentPixel shr 16) and 0xFF) - ((previousPixel shr 16) and 0xFF))
                val gDiff = abs(((currentPixel shr 8) and 0xFF) - ((previousPixel shr 8) and 0xFF))
                val bDiff = abs((currentPixel and 0xFF) - (previousPixel and 0xFF))
                
                diffSum += (rDiff + gDiff + bDiff) / 3
                sampleCount++
            }
        }

        val avgDiff = if (sampleCount > 0) diffSum / sampleCount else 0
        return avgDiff > MOTION_THRESHOLD
    }

    fun reset() {
        frameCount = 0
        lastBitmap?.recycle()
        lastBitmap = null
        isStandby = false
        lastMotionTime = SystemClock.elapsedRealtime()
    }

    fun destroy() {
        scope.cancel()
        lastBitmap?.recycle()
        lastBitmap = null
    }
}
