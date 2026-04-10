package com.fruitid.ml;

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
public final class GemmaInputProcessor_Factory implements Factory<GemmaInputProcessor> {
  @Override
  public GemmaInputProcessor get() {
    return newInstance();
  }

  public static GemmaInputProcessor_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GemmaInputProcessor newInstance() {
    return new GemmaInputProcessor();
  }

  private static final class InstanceHolder {
    private static final GemmaInputProcessor_Factory INSTANCE = new GemmaInputProcessor_Factory();
  }
}
