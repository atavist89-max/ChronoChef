package com.fruitid.ml

import com.fruitid.domain.model.BoundingBox
import com.fruitid.domain.model.FruitCategory

data class DetectionResult(
    val label: String,
    val scientificName: String,
    val boundingBox: BoundingBox,
    val confidence: Float,
    val category: FruitCategory
) {
    fun isHighConfidence(): Boolean = confidence >= 0.9f
}
