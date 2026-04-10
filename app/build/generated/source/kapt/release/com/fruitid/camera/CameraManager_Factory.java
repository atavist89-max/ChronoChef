package com.fruitid.camera;

import android.content.Context;
import com.fruitid.ml.GemmaInference;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class CameraManager_Factory implements Factory<CameraManager> {
  private final Provider<Context> contextProvider;

  private final Provider<GemmaInference> gemmaInferenceProvider;

  private final Provider<YuvToBitmapConverter> yuvConverterProvider;

  public CameraManager_Factory(Provider<Context> contextProvider,
      Provider<GemmaInference> gemmaInferenceProvider,
      Provider<YuvToBitmapConverter> yuvConverterProvider) {
    this.contextProvider = contextProvider;
    this.gemmaInferenceProvider = gemmaInferenceProvider;
    this.yuvConverterProvider = yuvConverterProvider;
  }

  @Override
  public CameraManager get() {
    return newInstance(contextProvider.get(), gemmaInferenceProvider.get(), yuvConverterProvider.get());
  }

  public static CameraManager_Factory create(Provider<Context> contextProvider,
      Provider<GemmaInference> gemmaInferenceProvider,
      Provider<YuvToBitmapConverter> yuvConverterProvider) {
    return new CameraManager_Factory(contextProvider, gemmaInferenceProvider, yuvConverterProvider);
  }

  public static CameraManager newInstance(Context context, GemmaInference gemmaInference,
      YuvToBitmapConverter yuvConverter) {
    return new CameraManager(context, gemmaInference, yuvConverter);
  }
}
