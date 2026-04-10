package com.fruitid.domain.usecase

import com.fruitid.data.local.nutrition.NutritionData
import com.fruitid.data.repository.DetectionRepository
import com.fruitid.domain.model.Detection
import javax.inject.Inject

class SaveDetectionUseCase @Inject constructor(
    private val detectionRepository: DetectionRepository,
    private val nutritionData: NutritionData
) {
    suspend operator fun invoke(detection: Detection): Long {
        // Enrich with nutrition data if not present
        val enrichedDetection = if (detection.nutritionInfo == null) {
            val nutrition = nutritionData.getNutrition(detection.commonName)
                ?: nutritionData.getGenericNutrition()
            detection.copy(nutritionInfo = nutrition)
        } else {
            detection
        }
        
        return detectionRepository.saveDetection(enrichedDetection)
    }
}
