package com.fruitid.di

import android.content.Context
import androidx.room.Room
import com.fruitid.data.local.db.DetectionDao
import com.fruitid.data.local.db.FruitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FruitDatabase {
        return Room.databaseBuilder(
            context,
            FruitDatabase::class.java,
            "fruit_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideDetectionDao(database: FruitDatabase): DetectionDao {
        return database.detectionDao()
    }
}
