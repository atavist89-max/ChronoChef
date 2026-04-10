package com.fruitid.domain.model

data class NutritionInfo(
    val calories: Int,
    val sugarGrams: Float,
    val fiberGrams: Float,
    val proteinGrams: Float = 0f,
    val fatGrams: Float = 0f,
    val carbsGrams: Float = 0f
)
