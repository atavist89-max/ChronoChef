package com.fruitid.work;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.fruitid.data.local.prefs.SettingsPrefs;
import com.fruitid.data.repository.DetectionRepository;
import dagger.internal.DaggerGenerated;
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
public final class HistoryCleanupWorker_Factory {
  private final Provider<DetectionRepository> detectionRepositoryProvider;

  private final Provider<SettingsPrefs> settingsPrefsProvider;

  public HistoryCleanupWorker_Factory(Provider<DetectionRepository> detectionRepositoryProvider,
      Provider<SettingsPrefs> settingsPrefsProvider) {
    this.detectionRepositoryProvider = detectionRepositoryProvider;
    this.settingsPrefsProvider = settingsPrefsProvider;
  }

  public HistoryCleanupWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, detectionRepositoryProvider.get(), settingsPrefsProvider.get());
  }

  public static HistoryCleanupWorker_Factory create(
      Provider<DetectionRepository> detectionRepositoryProvider,
      Provider<SettingsPrefs> settingsPrefsProvider) {
    return new HistoryCleanupWorker_Factory(detectionRepositoryProvider, settingsPrefsProvider);
  }

  public static HistoryCleanupWorker newInstance(Context context, WorkerParameters params,
      DetectionRepository detectionRepository, SettingsPrefs settingsPrefs) {
    return new HistoryCleanupWorker(context, params, detectionRepository, settingsPrefs);
  }
}
