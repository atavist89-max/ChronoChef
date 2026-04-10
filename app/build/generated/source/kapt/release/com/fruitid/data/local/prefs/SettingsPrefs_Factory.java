package com.fruitid.data.local.prefs;

import android.content.Context;
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
public final class SettingsPrefs_Factory implements Factory<SettingsPrefs> {
  private final Provider<Context> contextProvider;

  public SettingsPrefs_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SettingsPrefs get() {
    return newInstance(contextProvider.get());
  }

  public static SettingsPrefs_Factory create(Provider<Context> contextProvider) {
    return new SettingsPrefs_Factory(contextProvider);
  }

  public static SettingsPrefs newInstance(Context context) {
    return new SettingsPrefs(context);
  }
}
