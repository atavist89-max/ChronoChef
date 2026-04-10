package com.fruitid.data.local.nutrition;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class NutritionData_Factory implements Factory<NutritionData> {
  @Override
  public NutritionData get() {
    return newInstance();
  }

  public static NutritionData_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NutritionData newInstance() {
    return new NutritionData();
  }

  private static final class InstanceHolder {
    private static final NutritionData_Factory INSTANCE = new NutritionData_Factory();
  }
}
