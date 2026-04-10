package com.fruitid.ml

import android.graphics.Bitmap
import android.graphics.ImageFormat
import android.graphics.Matrix
import android.media.Image
import android.util.Size
import androidx.camera.core.ImageProxy
import java.nio.ByteBuffer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GemmaInputProcessor @Inject constructor() {

    companion object {
        const val INPUT_SIZE = 448
        const val NORMALIZATION_MEAN = 127.5f
        const val NORMALIZATION_STD = 127.5f
    }

    private val yuvBuffer = ByteArray(INPUT_SIZE * INPUT_SIZE * 3 / 2)

    fun preprocessImage(imageProxy: ImageProxy): FloatArray {
        val bitmap = imageProxyToBitmap(imageProxy)
        return bitmapToFloatArray(bitmap)
    }

    fun preprocessBitmap(bitmap: Bitmap): FloatArray {
        val resized = resizeBitmap(bitmap, INPUT_SIZE, INPUT_SIZE)
        return bitmapToFloatArray(resized)
    }

    private fun imageProxyToBitmap(imageProxy: ImageProxy): Bitmap {
        val image = imageProxy.image ?: throw IllegalStateException("ImageProxy has no image")
        
        val rotationDegrees = imageProxy.imageInfo.rotationDegrees
        val bitmap = yuvToRgb(image, rotationDegrees)
        
        return bitmap
    }

    private fun yuvToRgb(image: Image, rotationDegrees: Int): Bitmap {
        val yBuffer = image.planes[0].buffer
        val uBuffer = image.planes[1].buffer
        val vBuffer = image.planes[2].buffer

        val ySize = yBuffer.remaining()
        val uSize = uBuffer.remaining()
        val vSize = vBuffer.remaining()

        yBuffer.get(yuvBuffer, 0, ySize)
        vBuffer.get(yuvBuffer, ySize, vSize)
        uBuffer.get(yuvBuffer, ySize + vSize, uSize)

        val width = image.width
        val height = image.height

        val rgbBuffer = IntArray(width * height)
        yuvToRgbNative(yuvBuffer, rgbBuffer, width, height)

        var bitmap = Bitmap.createBitmap(rgbBuffer, width, height, Bitmap.Config.ARGB_8888)
        
        // Rotate if needed
        if (rotationDegrees != 0) {
            bitmap = rotateBitmap(bitmap, rotationDegrees.toFloat())
        }

        return bitmap
    }

    private fun yuvToRgbNative(yuv: ByteArray, rgb: IntArray, width: Int, height: Int) {
        val frameSize = width * height
        var j = 0
        var yp = 0

        for (i in 0 until height) {
            var uvp = frameSize + (i shr 1) * width
            var u = 0
            var v = 0

            for (j in 0 until width) {
                var y = (0xff and yuv[yp].toInt()) - 16
                if (y < 0) y = 0

                if ((j and 1) == 0) {
                    v = (0xff and yuv[uvp++].toInt()) - 128
                    u = (0xff and yuv[uvp++].toInt()) - 128
                }

                val y1192 = 1192 * y
                var r = (y1192 + 1634 * v)
                var g = (y1192 - 833 * v - 400 * u)
                var b = (y1192 + 2066 * u)

                if (r < 0) r = 0 else if (r > 262143) r = 262143
                if (g < 0) g = 0 else if (g > 262143) g = 262143
                if (b < 0) b = 0 else if (b > 262143) b = 262143

                rgb[yp] = -0x1000000 or (r shl 6 and 0xff0000) or (g shr 2 and 0xff00) or (b shr 10 and 0xff)
                yp++
            }
        }
    }

    private fun resizeBitmap(bitmap: Bitmap, width: Int, height: Int): Bitmap {
        return Bitmap.createScaledBitmap(bitmap, width, height, true)
    }

    private fun rotateBitmap(bitmap: Bitmap, degrees: Float): Bitmap {
        val matrix = Matrix().apply { postRotate(degrees) }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
    }

    private fun bitmapToFloatArray(bitmap: Bitmap): FloatArray {
        val width = bitmap.width
        val height = bitmap.height
        val pixels = IntArray(width * height)
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height)

        val floatArray = FloatArray(width * height * 3)
        var idx = 0

        for (i in 0 until height) {
            for (j in 0 until width) {
                val pixel = pixels[i * width + j]
                
                // Extract RGB
                val r = ((pixel shr 16) and 0xFF).toFloat()
                val g = ((pixel shr 8) and 0xFF).toFloat()
                val b = (pixel and 0xFF).toFloat()

                // Normalize to [-1, 1]
                floatArray[idx++] = (r - NORMALIZATION_MEAN) / NORMALIZATION_STD
                floatArray[idx++] = (g - NORMALIZATION_MEAN) / NORMALIZATION_STD
                floatArray[idx++] = (b - NORMALIZATION_MEAN) / NORMALIZATION_STD
            }
        }

        return floatArray
    }

    fun createInputBuffer(bitmap: Bitmap): ByteBuffer {
        val floatArray = preprocessBitmap(bitmap)
        val buffer = ByteBuffer.allocateDirect(floatArray.size * 4)
        buffer.asFloatBuffer().put(floatArray)
        buffer.rewind()
        return buffer
    }
}
