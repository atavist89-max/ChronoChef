package com.fruitid.di;

import com.fruitid.data.local.db.DetectionDao;
import com.fruitid.data.local.db.FruitDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideDetectionDaoFactory implements Factory<DetectionDao> {
  private final Provider<FruitDatabase> databaseProvider;

  public DatabaseModule_ProvideDetectionDaoFactory(Provider<FruitDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public DetectionDao get() {
    return provideDetectionDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideDetectionDaoFactory create(
      Provider<FruitDatabase> databaseProvider) {
    return new DatabaseModule_ProvideDetectionDaoFactory(databaseProvider);
  }

  public static DetectionDao provideDetectionDao(FruitDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideDetectionDao(database));
  }
}
