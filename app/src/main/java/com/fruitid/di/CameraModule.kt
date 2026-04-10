package com.fruitid.di

import com.fruitid.camera.CameraManager
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CameraModule {
    // CameraManager is injected via constructor, no additional binding needed
}
