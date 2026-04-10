package com.fruitid.ui.viewmodel;

import android.content.Context;
import com.fruitid.camera.CameraManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class CameraViewModel_Factory implements Factory<CameraViewModel> {
  private final Provider<Context> contextProvider;

  private final Provider<CameraManager> cameraManagerProvider;

  public CameraViewModel_Factory(Provider<Context> contextProvider,
      Provider<CameraManager> cameraManagerProvider) {
    this.contextProvider = contextProvider;
    this.cameraManagerProvider = cameraManagerProvider;
  }

  @Override
  public CameraViewModel get() {
    return newInstance(contextProvider.get(), cameraManagerProvider.get());
  }

  public static CameraViewModel_Factory create(Provider<Context> contextProvider,
      Provider<CameraManager> cameraManagerProvider) {
    return new CameraViewModel_Factory(contextProvider, cameraManagerProvider);
  }

  public static CameraViewModel newInstance(Context context, CameraManager cameraManager) {
    return new CameraViewModel(context, cameraManager);
  }
}
