package com.fruitid.domain.model

data class BoundingBox(
    val x1: Float,
    val y1: Float,
    val x2: Float,
    val y2: Float
) {
    val width: Float get() = x2 - x1
    val height: Float get() = y2 - y1
    val centerX: Float get() = (x1 + x2) / 2
    val centerY: Float get() = (y1 + y2) / 2
    val area: Float get() = width * height

    fun isValid(): Boolean = x1 >= 0 && y1 >= 0 && x2 > x1 && y2 > y1 && 
                            x2 <= 1 && y2 <= 1

    fun intersects(other: BoundingBox, threshold: Float = 0.5f): Boolean {
        val intersectionX1 = maxOf(x1, other.x1)
        val intersectionY1 = maxOf(y1, other.y1)
        val intersectionX2 = minOf(x2, other.x2)
        val intersectionY2 = minOf(y2, other.y2)

        if (intersectionX2 <= intersectionX1 || intersectionY2 <= intersectionY1) {
            return false
        }

        val intersectionArea = (intersectionX2 - intersectionX1) * (intersectionY2 - intersectionY1)
        val unionArea = area + other.area - intersectionArea
        val iou = intersectionArea / unionArea

        return iou > threshold
    }

    fun toCanvasCoordinates(canvasWidth: Float, canvasHeight: Float): BoundingBox {
        return BoundingBox(
            x1 = x1 * canvasWidth,
            y1 = y1 * canvasHeight,
            x2 = x2 * canvasWidth,
            y2 = y2 * canvasHeight
        )
    }
}
