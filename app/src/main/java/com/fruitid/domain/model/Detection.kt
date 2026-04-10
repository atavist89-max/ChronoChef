package com.fruitid.domain.model

data class Detection(
    val id: Long = 0,
    val timestamp: Long,
    val commonName: String,
    val scientificName: String,
    val confidence: Float,
    val boundingBox: BoundingBox,
    val category: FruitCategory,
    val thumbnailPath: String? = null,
    val nutritionInfo: NutritionInfo? = null,
    val taxonomy: String? = null,
    val ripenessDescription: String? = null
) {
    fun isHighConfidence(): Boolean = confidence >= 0.9f
}
