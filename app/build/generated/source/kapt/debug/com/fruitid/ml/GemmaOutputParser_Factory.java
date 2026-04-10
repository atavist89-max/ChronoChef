package com.fruitid.ml;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class GemmaOutputParser_Factory implements Factory<GemmaOutputParser> {
  private final Provider<Gson> gsonProvider;

  public GemmaOutputParser_Factory(Provider<Gson> gsonProvider) {
    this.gsonProvider = gsonProvider;
  }

  @Override
  public GemmaOutputParser get() {
    return newInstance(gsonProvider.get());
  }

  public static GemmaOutputParser_Factory create(Provider<Gson> gsonProvider) {
    return new GemmaOutputParser_Factory(gsonProvider);
  }

  public static GemmaOutputParser newInstance(Gson gson) {
    return new GemmaOutputParser(gson);
  }
}
