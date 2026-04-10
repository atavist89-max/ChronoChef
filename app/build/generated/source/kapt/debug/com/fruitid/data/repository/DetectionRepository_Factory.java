package com.fruitid.data.repository;

import com.fruitid.data.local.db.DetectionDao;
import com.fruitid.data.local.nutrition.NutritionData;
import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DetectionRepository_Factory implements Factory<DetectionRepository> {
  private final Provider<DetectionDao> detectionDaoProvider;

  private final Provider<NutritionData> nutritionDataProvider;

  private final Provider<Gson> gsonProvider;

  public DetectionRepository_Factory(Provider<DetectionDao> detectionDaoProvider,
      Provider<NutritionData> nutritionDataProvider, Provider<Gson> gsonProvider) {
    this.detectionDaoProvider = detectionDaoProvider;
    this.nutritionDataProvider = nutritionDataProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public DetectionRepository get() {
    return newInstance(detectionDaoProvider.get(), nutritionDataProvider.get(), gsonProvider.get());
  }

  public static DetectionRepository_Factory create(Provider<DetectionDao> detectionDaoProvider,
      Provider<NutritionData> nutritionDataProvider, Provider<Gson> gsonProvider) {
    return new DetectionRepository_Factory(detectionDaoProvider, nutritionDataProvider, gsonProvider);
  }

  public static DetectionRepository newInstance(DetectionDao detectionDao,
      NutritionData nutritionData, Gson gson) {
    return new DetectionRepository(detectionDao, nutritionData, gson);
  }
}
