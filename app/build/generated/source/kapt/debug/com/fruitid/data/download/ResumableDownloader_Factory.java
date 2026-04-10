package com.fruitid.data.download;

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
public final class ResumableDownloader_Factory implements Factory<ResumableDownloader> {
  @Override
  public ResumableDownloader get() {
    return newInstance();
  }

  public static ResumableDownloader_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ResumableDownloader newInstance() {
    return new ResumableDownloader();
  }

  private static final class InstanceHolder {
    private static final ResumableDownloader_Factory INSTANCE = new ResumableDownloader_Factory();
  }
}
