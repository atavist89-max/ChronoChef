package com.fruitid.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.fruitid.data.local.db.DetectionDao
import com.fruitid.data.local.db.DetectionEntity
import com.fruitid.data.local.nutrition.NutritionData
import com.fruitid.domain.model.BoundingBox
import com.fruitid.domain.model.Detection
import com.fruitid.domain.model.FruitCategory
import com.fruitid.domain.model.NutritionInfo
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetectionRepository @Inject constructor(
    private val detectionDao: DetectionDao,
    private val nutritionData: NutritionData,
    private val gson: Gson
) {
    fun getDetectionHistory(): Flow<List<Detection>> {
        return detectionDao.getAllFlow().map { entities ->
            entities.map { it.toDomainModel() }
        }
    }

    suspend fun getRecentDetections(limit: Int): List<Detection> {
        return detectionDao.getRecent(limit).map { it.toDomainModel() }
    }

    suspend fun getDetectionById(id: Long): Detection? {
        return detectionDao.getById(id)?.toDomainModel()
    }

    suspend fun saveDetection(detection: Detection): Long {
        val entity = detection.toEntity()
        return detectionDao.insert(entity)
    }

    suspend fun deleteDetection(id: Long) {
        val detection = detectionDao.getById(id)
        detection?.let {
            detection.thumbnailPath?.let { path ->
                File(path).delete()
            }
            detectionDao.delete(it)
        }
    }

    suspend fun deleteOldDetections(days: Int): List<String> {
        val cutoffTime = System.currentTimeMillis() - (days * 24 * 60 * 60 * 1000)
        val oldThumbnailPaths = detectionDao.getOldThumbnailPaths(cutoffTime)
        detectionDao.deleteOlderThan(cutoffTime)
        return oldThumbnailPaths
    }

    suspend fun clearAllHistory() {
        detectionDao.getAll().forEach { entity ->
            entity.thumbnailPath?.let { path ->
                File(path).delete()
            }
        }
        detectionDao.deleteAll()
    }

    suspend fun getHistoryCount(): Int {
        return detectionDao.getCount()
    }

    private fun DetectionEntity.toDomainModel(): Detection {
        return Detection(
            id = id,
            timestamp = timestamp,
            commonName = commonName,
            scientificName = scientificName,
            confidence = confidence,
            boundingBox = BoundingBox(bboxX1, bboxY1, bboxX2, bboxY2),
            category = FruitCategory.values().find { it.color.hashCode() == categoryColor } ?: FruitCategory.UNKNOWN,
            thumbnailPath = thumbnailPath,
            nutritionInfo = nutritionJson?.let { gson.fromJson(it, NutritionInfo::class.java) },
            taxonomy = taxonomy,
            ripenessDescription = ripenessDescription
        )
    }

    private fun Detection.toEntity(): DetectionEntity {
        return DetectionEntity(
            id = id,
            timestamp = timestamp,
            commonName = commonName,
            scientificName = scientificName,
            confidence = confidence,
            bboxX1 = boundingBox.x1,
            bboxY1 = boundingBox.y1,
            bboxX2 = boundingBox.x2,
            bboxY2 = boundingBox.y2,
            categoryColor = category.color.hashCode(),
            thumbnailPath = thumbnailPath,
            nutritionJson = nutritionInfo?.let { gson.toJson(it) },
            taxonomy = taxonomy,
            ripenessDescription = ripenessDescription
        )
    }
}
