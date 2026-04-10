package com.fruitid.data.local.nutrition

import com.fruitid.domain.model.NutritionInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NutritionData @Inject constructor() {

    private val nutritionDatabase = mapOf(
        // Pome Fruits
        "apple" to NutritionInfo(
            calories = 52,
            sugarGrams = 10.4f,
            fiberGrams = 2.4f,
            proteinGrams = 0.3f,
            fatGrams = 0.2f,
            carbsGrams = 13.8f
        ),
        "granny smith apple" to NutritionInfo(
            calories = 52,
            sugarGrams = 9.6f,
            fiberGrams = 2.8f,
            proteinGrams = 0.3f,
            fatGrams = 0.2f,
            carbsGrams = 13.6f
        ),
        "pear" to NutritionInfo(
            calories = 57,
            sugarGrams = 9.8f,
            fiberGrams = 3.1f,
            proteinGrams = 0.4f,
            fatGrams = 0.1f,
            carbsGrams = 15.2f
        ),
        
        // Citrus Fruits
        "orange" to NutritionInfo(
            calories = 47,
            sugarGrams = 9.4f,
            fiberGrams = 2.4f,
            proteinGrams = 0.9f,
            fatGrams = 0.1f,
            carbsGrams = 11.8f
        ),
        "navel orange" to NutritionInfo(
            calories = 49,
            sugarGrams = 9.1f,
            fiberGrams = 2.3f,
            proteinGrams = 0.9f,
            fatGrams = 0.1f,
            carbsGrams = 12.0f
        ),
        "lemon" to NutritionInfo(
            calories = 29,
            sugarGrams = 2.5f,
            fiberGrams = 2.8f,
            proteinGrams = 1.1f,
            fatGrams = 0.3f,
            carbsGrams = 9.3f
        ),
        "lime" to NutritionInfo(
            calories = 30,
            sugarGrams = 1.7f,
            fiberGrams = 2.8f,
            proteinGrams = 0.7f,
            fatGrams = 0.2f,
            carbsGrams = 10.5f
        ),
        "grapefruit" to NutritionInfo(
            calories = 42,
            sugarGrams = 6.9f,
            fiberGrams = 1.6f,
            proteinGrams = 0.8f,
            fatGrams = 0.1f,
            carbsGrams = 10.7f
        ),
        "tangerine" to NutritionInfo(
            calories = 53,
            sugarGrams = 10.6f,
            fiberGrams = 1.8f,
            proteinGrams = 0.8f,
            fatGrams = 0.3f,
            carbsGrams = 13.3f
        ),
        
        // Tropical Fruits
        "banana" to NutritionInfo(
            calories = 89,
            sugarGrams = 12.2f,
            fiberGrams = 2.6f,
            proteinGrams = 1.1f,
            fatGrams = 0.3f,
            carbsGrams = 22.8f
        ),
        "mango" to NutritionInfo(
            calories = 60,
            sugarGrams = 13.7f,
            fiberGrams = 1.6f,
            proteinGrams = 0.8f,
            fatGrams = 0.4f,
            carbsGrams = 14.9f
        ),
        "pineapple" to NutritionInfo(
            calories = 50,
            sugarGrams = 9.9f,
            fiberGrams = 1.4f,
            proteinGrams = 0.5f,
            fatGrams = 0.1f,
            carbsGrams = 13.1f
        ),
        "papaya" to NutritionInfo(
            calories = 43,
            sugarGrams = 7.8f,
            fiberGrams = 1.7f,
            proteinGrams = 0.5f,
            fatGrams = 0.3f,
            carbsGrams = 10.8f
        ),
        "dragon fruit" to NutritionInfo(
            calories = 57,
            sugarGrams = 8.0f,
            fiberGrams = 3.0f,
            proteinGrams = 1.1f,
            fatGrams = 0.4f,
            carbsGrams = 12.4f
        ),
        "passion fruit" to NutritionInfo(
            calories = 97,
            sugarGrams = 11.2f,
            fiberGrams = 10.4f,
            proteinGrams = 2.2f,
            fatGrams = 0.7f,
            carbsGrams = 23.4f
        ),
        "lychee" to NutritionInfo(
            calories = 66,
            sugarGrams = 15.2f,
            fiberGrams = 1.3f,
            proteinGrams = 0.8f,
            fatGrams = 0.4f,
            carbsGrams = 16.5f
        ),
        
        // Berries
        "strawberry" to NutritionInfo(
            calories = 32,
            sugarGrams = 4.9f,
            fiberGrams = 2.0f,
            proteinGrams = 0.7f,
            fatGrams = 0.3f,
            carbsGrams = 7.7f
        ),
        "blueberry" to NutritionInfo(
            calories = 57,
            sugarGrams = 10.0f,
            fiberGrams = 2.4f,
            proteinGrams = 0.7f,
            fatGrams = 0.3f,
            carbsGrams = 14.5f
        ),
        "raspberry" to NutritionInfo(
            calories = 52,
            sugarGrams = 4.4f,
            fiberGrams = 6.5f,
            proteinGrams = 1.2f,
            fatGrams = 0.7f,
            carbsGrams = 11.9f
        ),
        "blackberry" to NutritionInfo(
            calories = 43,
            sugarGrams = 4.9f,
            fiberGrams = 5.3f,
            proteinGrams = 1.4f,
            fatGrams = 0.5f,
            carbsGrams = 9.6f
        ),
        "grape" to NutritionInfo(
            calories = 69,
            sugarGrams = 15.5f,
            fiberGrams = 0.9f,
            proteinGrams = 0.7f,
            fatGrams = 0.2f,
            carbsGrams = 18.1f
        ),
        
        // Stone Fruits
        "peach" to NutritionInfo(
            calories = 39,
            sugarGrams = 8.4f,
            fiberGrams = 1.5f,
            proteinGrams = 0.9f,
            fatGrams = 0.3f,
            carbsGrams = 9.5f
        ),
        "plum" to NutritionInfo(
            calories = 46,
            sugarGrams = 9.9f,
            fiberGrams = 1.4f,
            proteinGrams = 0.7f,
            fatGrams = 0.3f,
            carbsGrams = 11.4f
        ),
        "cherry" to NutritionInfo(
            calories = 50,
            sugarGrams = 8.5f,
            fiberGrams = 1.6f,
            proteinGrams = 1.0f,
            fatGrams = 0.3f,
            carbsGrams = 12.2f
        ),
        "apricot" to NutritionInfo(
            calories = 48,
            sugarGrams = 9.2f,
            fiberGrams = 2.0f,
            proteinGrams = 1.4f,
            fatGrams = 0.4f,
            carbsGrams = 11.1f
        ),
        "nectarine" to NutritionInfo(
            calories = 44,
            sugarGrams = 7.9f,
            fiberGrams = 1.7f,
            proteinGrams = 1.1f,
            fatGrams = 0.3f,
            carbsGrams = 10.5f
        ),
        
        // Melons
        "watermelon" to NutritionInfo(
            calories = 30,
            sugarGrams = 6.2f,
            fiberGrams = 0.4f,
            proteinGrams = 0.6f,
            fatGrams = 0.2f,
            carbsGrams = 7.6f
        ),
        "cantaloupe" to NutritionInfo(
            calories = 34,
            sugarGrams = 7.9f,
            fiberGrams = 0.9f,
            proteinGrams = 0.8f,
            fatGrams = 0.2f,
            carbsGrams = 8.2f
        ),
        "honeydew" to NutritionInfo(
            calories = 36,
            sugarGrams = 8.1f,
            fiberGrams = 0.8f,
            proteinGrams = 0.5f,
            fatGrams = 0.1f,
            carbsGrams = 9.1f
        )
    )

    fun getNutrition(fruitName: String): NutritionInfo? {
        val normalized = fruitName.lowercase().trim()
        return nutritionDatabase[normalized]
    }

    fun getGenericNutrition(): NutritionInfo {
        return NutritionInfo(
            calories = 50,
            sugarGrams = 9.0f,
            fiberGrams = 2.0f,
            proteinGrams = 0.5f,
            fatGrams = 0.2f,
            carbsGrams = 12.0f
        )
    }
}
