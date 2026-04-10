package com.fruitid.camera

import android.graphics.Bitmap
import android.graphics.ImageFormat
import android.graphics.Rect
import android.graphics.YuvImage
import android.media.Image
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class YuvToBitmapConverter @Inject constructor() {

    private val outputStream = ByteArrayOutputStream()

    fun convert(image: Image, rotationDegrees: Int = 0): Bitmap {
        require(image.format == ImageFormat.YUV_420_888) { "Unsupported image format: ${image.format}" }

        val yBuffer = image.planes[0].buffer
        val uBuffer = image.planes[1].buffer
        val vBuffer = image.planes[2].buffer

        val ySize = yBuffer.remaining()
        val uSize = uBuffer.remaining()
        val vSize = vBuffer.remaining()

        val nv21 = ByteArray(ySize + uSize + vSize)

        yBuffer.get(nv21, 0, ySize)
        vBuffer.get(nv21, ySize, vSize)
        uBuffer.get(nv21, ySize + vSize, uSize)

        val yuvImage = YuvImage(nv21, ImageFormat.NV21, image.width, image.height, null)
        outputStream.reset()

        yuvImage.compressToJpeg(
            Rect(0, 0, image.width, image.height),
            100,
            outputStream
        )

        val jpegBytes = outputStream.toByteArray()
        val bitmap = android.graphics.BitmapFactory.decodeByteArray(jpegBytes, 0, jpegBytes.size)

        // Apply rotation if needed
        return if (rotationDegrees != 0) {
            rotateBitmap(bitmap, rotationDegrees)
        } else {
            bitmap
        }
    }

    private fun rotateBitmap(bitmap: Bitmap, degrees: Int): Bitmap {
        val matrix = android.graphics.Matrix().apply {
            postRotate(degrees.toFloat())
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
    }

    fun convertToRgbBytes(image: Image): ByteArray {
        val width = image.width
        val height = image.height
        val yBuffer = image.planes[0].buffer
        val uBuffer = image.planes[1].buffer
        val vBuffer = image.planes[2].buffer

        val yRowStride = image.planes[0].rowStride
        val uvRowStride = image.planes[1].rowStride
        val uvPixelStride = image.planes[1].pixelStride

        val rgbBytes = ByteArray(width * height * 3)

        var yPos = 0
        for (row in 0 until height) {
            var uvPos = (row shr 1) * uvRowStride

            for (col in 0 until width) {
                val y = (yBuffer[yPos].toInt() and 0xFF) - 16
                val v = (vBuffer[uvPos].toInt() and 0xFF) - 128
                val u = (uBuffer[uvPos].toInt() and 0xFF) - 128

                var r = (298 * y + 409 * v + 128 shr 8)
                var g = (298 * y - 100 * u - 208 * v + 128 shr 8)
                var b = (298 * y + 516 * u + 128 shr 8)

                r = r.coerceIn(0, 255)
                g = g.coerceIn(0, 255)
                b = b.coerceIn(0, 255)

                val idx = (row * width + col) * 3
                rgbBytes[idx] = r.toByte()
                rgbBytes[idx + 1] = g.toByte()
                rgbBytes[idx + 2] = b.toByte()

                yPos++
                if (col and 1 == 1) {
                    uvPos += uvPixelStride
                }
            }
            if (row and 1 == 0) {
                yPos += yRowStride - width
            }
        }

        return rgbBytes
    }
}
