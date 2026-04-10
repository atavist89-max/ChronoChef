package com.fruitid.domain.usecase

import android.graphics.Bitmap
import com.fruitid.ml.DetectionResult
import com.fruitid.ml.GemmaInference
import javax.inject.Inject

class DetectFruitsUseCase @Inject constructor(
    private val gemmaInference: GemmaInference
) {
    operator fun invoke(bitmap: Bitmap): List<DetectionResult> {
        if (!gemmaInference.isInitialized()) {
            return emptyList()
        }
        return gemmaInference.detect(bitmap)
    }
}
