package com.fruitid.camera

import android.content.Context
import android.util.Size
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.fruitid.ml.GemmaInference
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CameraManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gemmaInference: GemmaInference,
    private val yuvConverter: YuvToBitmapConverter
) {
    companion object {
        val PREVIEW_SIZE = Size(1920, 1080)
        val ANALYSIS_SIZE = Size(448, 448)
    }

    private var cameraProvider: ProcessCameraProvider? = null
    private var imageAnalysis: ImageAnalysis? = null
    private var preview: Preview? = null
    private var cameraExecutor: ExecutorService? = null
    private var frameAnalyzer: FrameAnalyzer? = null

    var onDetections: ((List<com.fruitid.ml.DetectionResult>) -> Unit)? = null
    var onStandbyStateChange: ((Boolean) -> Unit)? = null

    suspend fun startCamera(
        lifecycleOwner: LifecycleOwner,
        previewView: PreviewView,
        onError: (Exception) -> Unit = {}
    ) = withContext(Dispatchers.Main) {
        try {
            val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
            cameraProvider = cameraProviderFuture.await()

            // Preview use case
            preview = Preview.Builder()
                .setTargetResolution(PREVIEW_SIZE)
                .build()
                .also {
                    it.surfaceProvider = previewView.surfaceProvider
                }

            // Image analysis use case
            imageAnalysis = ImageAnalysis.Builder()
                .setTargetResolution(ANALYSIS_SIZE)
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()

            // Create analyzer
            frameAnalyzer = FrameAnalyzer(gemmaInference, yuvConverter).apply {
                onDetections = this@CameraManager.onDetections
                onStandbyStateChange = this@CameraManager.onStandbyStateChange
            }

            imageAnalysis?.setAnalyzer(
                getCameraExecutor(),
                frameAnalyzer!!
            )

            // Select back camera
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            // Unbind all use cases before rebinding
            cameraProvider?.unbindAll()

            // Bind use cases to camera
            cameraProvider?.bindToLifecycle(
                lifecycleOwner,
                cameraSelector,
                preview,
                imageAnalysis
            )

        } catch (e: Exception) {
            onError(e)
        }
    }

    fun stopCamera() {
        frameAnalyzer?.destroy()
        frameAnalyzer = null
        cameraProvider?.unbindAll()
    }

    fun pauseAnalysis() {
        frameAnalyzer?.reset()
        imageAnalysis?.clearAnalyzer()
    }

    fun resumeAnalysis() {
        frameAnalyzer?.let { analyzer ->
            imageAnalysis?.setAnalyzer(getCameraExecutor(), analyzer)
        }
    }

    private fun getCameraExecutor(): ExecutorService {
        if (cameraExecutor == null || cameraExecutor?.isShutdown == true) {
            cameraExecutor = Executors.newSingleThreadExecutor()
        }
        return cameraExecutor!!
    }

    fun shutdown() {
        stopCamera()
        cameraExecutor?.shutdown()
        cameraExecutor = null
    }

    private suspend fun <T> com.google.common.util.concurrent.ListenableFuture<T>.await(): T {
        return withContext(Dispatchers.Default) {
            get()
        }
    }
}
