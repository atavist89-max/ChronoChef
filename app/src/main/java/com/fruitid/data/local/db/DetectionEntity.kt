package com.fruitid.data.local.db

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "detections",
    indices = [
        Index(value = ["timestamp"]),
        Index(value = ["commonName"])
    ]
)
data class DetectionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val timestamp: Long,
    val commonName: String,
    val scientificName: String,
    val confidence: Float,
    val bboxX1: Float,
    val bboxY1: Float,
    val bboxX2: Float,
    val bboxY2: Float,
    val categoryColor: Int,
    val thumbnailPath: String?,
    val nutritionJson: String?,
    val taxonomy: String?,
    val ripenessDescription: String?
)
