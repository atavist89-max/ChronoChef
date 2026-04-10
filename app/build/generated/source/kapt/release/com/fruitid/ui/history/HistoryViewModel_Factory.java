package com.fruitid.ui.history;

import android.content.Context;
import com.fruitid.data.local.prefs.SettingsPrefs;
import com.fruitid.data.repository.DetectionRepository;
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
public final class HistoryViewModel_Factory implements Factory<HistoryViewModel> {
  private final Provider<Context> contextProvider;

  private final Provider<DetectionRepository> detectionRepositoryProvider;

  private final Provider<SettingsPrefs> settingsPrefsProvider;

  public HistoryViewModel_Factory(Provider<Context> contextProvider,
      Provider<DetectionRepository> detectionRepositoryProvider,
      Provider<SettingsPrefs> settingsPrefsProvider) {
    this.contextProvider = contextProvider;
    this.detectionRepositoryProvider = detectionRepositoryProvider;
    this.settingsPrefsProvider = settingsPrefsProvider;
  }

  @Override
  public HistoryViewModel get() {
    return newInstance(contextProvider.get(), detectionRepositoryProvider.get(), settingsPrefsProvider.get());
  }

  public static HistoryViewModel_Factory create(Provider<Context> contextProvider,
      Provider<DetectionRepository> detectionRepositoryProvider,
      Provider<SettingsPrefs> settingsPrefsProvider) {
    return new HistoryViewModel_Factory(contextProvider, detectionRepositoryProvider, settingsPrefsProvider);
  }

  public static HistoryViewModel newInstance(Context context,
      DetectionRepository detectionRepository, SettingsPrefs settingsPrefs) {
    return new HistoryViewModel(context, detectionRepository, settingsPrefs);
  }
}
