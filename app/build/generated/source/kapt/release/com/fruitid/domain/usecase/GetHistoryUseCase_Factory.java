package com.fruitid.domain.usecase;

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
public final class GetHistoryUseCase_Factory implements Factory<GetHistoryUseCase> {
  private final Provider<DetectionRepository> detectionRepositoryProvider;

  public GetHistoryUseCase_Factory(Provider<DetectionRepository> detectionRepositoryProvider) {
    this.detectionRepositoryProvider = detectionRepositoryProvider;
  }

  @Override
  public GetHistoryUseCase get() {
    return newInstance(detectionRepositoryProvider.get());
  }

  public static GetHistoryUseCase_Factory create(
      Provider<DetectionRepository> detectionRepositoryProvider) {
    return new GetHistoryUseCase_Factory(detectionRepositoryProvider);
  }

  public static GetHistoryUseCase newInstance(DetectionRepository detectionRepository) {
    return new GetHistoryUseCase(detectionRepository);
  }
}
