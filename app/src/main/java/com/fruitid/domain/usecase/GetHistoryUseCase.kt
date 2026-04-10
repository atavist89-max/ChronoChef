package com.fruitid.domain.usecase


import com.fruitid.data.repository.DetectionRepository
import com.fruitid.domain.model.Detection
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(
    private val detectionRepository: DetectionRepository
) {
    operator fun invoke(): Flow<List<Detection>> {
        return detectionRepository.getDetectionHistory()
    }
}
