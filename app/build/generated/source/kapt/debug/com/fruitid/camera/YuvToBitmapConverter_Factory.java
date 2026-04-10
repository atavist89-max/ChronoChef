package com.fruitid.camera;

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
public final class YuvToBitmapConverter_Factory implements Factory<YuvToBitmapConverter> {
  @Override
  public YuvToBitmapConverter get() {
    return newInstance();
  }

  public static YuvToBitmapConverter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static YuvToBitmapConverter newInstance() {
    return new YuvToBitmapConverter();
  }

  private static final class InstanceHolder {
    private static final YuvToBitmapConverter_Factory INSTANCE = new YuvToBitmapConverter_Factory();
  }
}
