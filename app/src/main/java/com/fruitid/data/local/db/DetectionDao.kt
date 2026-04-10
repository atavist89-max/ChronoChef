package com.fruitid.data.local.db

import androidx.paging.PagingSource
import androidx.room.*

@Dao
interface DetectionDao {
    
    @Query("SELECT * FROM detections ORDER BY timestamp DESC")
    fun getAllPaged(): PagingSource<Int, DetectionEntity>
    
    @Query("SELECT * FROM detections ORDER BY timestamp DESC LIMIT :limit")
    suspend fun getRecent(limit: Int): List<DetectionEntity>
    
    @Query("SELECT * FROM detections WHERE id = :id")
    suspend fun getById(id: Long): DetectionEntity?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: DetectionEntity): Long
    
    @Delete
    suspend fun delete(entity: DetectionEntity)
    
    @Query("DELETE FROM detections WHERE id = :id")
    suspend fun deleteById(id: Long): Int
    
    @Query("DELETE FROM detections WHERE timestamp < :timestamp")
    suspend fun deleteOlderThan(timestamp: Long): Int
    
    @Query("SELECT COUNT(*) FROM detections")
    suspend fun getCount(): Int
    
    @Query("SELECT thumbnailPath FROM detections WHERE thumbnailPath IS NOT NULL AND timestamp < :timestamp")
    suspend fun getOldThumbnailPaths(timestamp: Long): List<String>
    
    @Query("DELETE FROM detections")
    suspend fun deleteAll()
    
    @Query("SELECT * FROM detections ORDER BY timestamp DESC")
    suspend fun getAll(): List<DetectionEntity>
}
