package com.fruitid.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [DetectionEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class FruitDatabase : RoomDatabase() {
    abstract fun detectionDao(): DetectionDao
}
