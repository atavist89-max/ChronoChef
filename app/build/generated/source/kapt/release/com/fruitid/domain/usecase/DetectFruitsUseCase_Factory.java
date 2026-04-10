package com.fruitid.domain.usecase;

import com.fruitid.ml.GemmaInference;
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
public final class DetectFruitsUseCase_Factory implements Factory<DetectFruitsUseCase> {
  private final Provider<GemmaInference> gemmaInferenceProvider;

  public DetectFruitsUseCase_Factory(Provider<GemmaInference> gemmaInferenceProvider) {
    this.gemmaInferenceProvider = gemmaInferenceProvider;
  }

  @Override
  public DetectFruitsUseCase get() {
    return newInstance(gemmaInferenceProvider.get());
  }

  public static DetectFruitsUseCase_Factory create(
      Provider<GemmaInference> gemmaInferenceProvider) {
    return new DetectFruitsUseCase_Factory(gemmaInferenceProvider);
  }

  public static DetectFruitsUseCase newInstance(GemmaInference gemmaInference) {
    return new DetectFruitsUseCase(gemmaInference);
  }
}
