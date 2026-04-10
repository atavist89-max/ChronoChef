package com.fruitid.domain.usecase;

import com.fruitid.data.local.nutrition.NutritionData;
import com.fruitid.data.repository.DetectionRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SaveDetectionUseCase_Factory implements Factory<SaveDetectionUseCase> {
  private final Provider<DetectionRepository> detectionRepositoryProvider;

  private final Provider<NutritionData> nutritionDataProvider;

  public SaveDetectionUseCase_Factory(Provider<DetectionRepository> detectionRepositoryProvider,
      Provider<NutritionData> nutritionDataProvider) {
    this.detectionRepositoryProvider = detectionRepositoryProvider;
    this.nutritionDataProvider = nutritionDataProvider;
  }

  @Override
  public SaveDetectionUseCase get() {
    return newInstance(detectionRepositoryProvider.get(), nutritionDataProvider.get());
  }

  public static SaveDetectionUseCase_Factory create(
      Provider<DetectionRepository> detectionRepositoryProvider,
      Provider<NutritionData> nutritionDataProvider) {
    return new SaveDetectionUseCase_Factory(detectionRepositoryProvider, nutritionDataProvider);
  }

  public static SaveDetectionUseCase newInstance(DetectionRepository detectionRepository,
      NutritionData nutritionData) {
    return new SaveDetectionUseCase(detectionRepository, nutritionData);
  }
}
