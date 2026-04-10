package com.fruitid.camera;

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
public final class FrameAnalyzer_Factory implements Factory<FrameAnalyzer> {
  private final Provider<GemmaInference> inferenceProvider;

  private final Provider<YuvToBitmapConverter> converterProvider;

  public FrameAnalyzer_Factory(Provider<GemmaInference> inferenceProvider,
      Provider<YuvToBitmapConverter> converterProvider) {
    this.inferenceProvider = inferenceProvider;
    this.converterProvider = converterProvider;
  }

  @Override
  public FrameAnalyzer get() {
    return newInstance(inferenceProvider.get(), converterProvider.get());
  }

  public static FrameAnalyzer_Factory create(Provider<GemmaInference> inferenceProvider,
      Provider<YuvToBitmapConverter> converterProvider) {
    return new FrameAnalyzer_Factory(inferenceProvider, converterProvider);
  }

  public static FrameAnalyzer newInstance(GemmaInference inference,
      YuvToBitmapConverter converter) {
    return new FrameAnalyzer(inference, converter);
  }
}
