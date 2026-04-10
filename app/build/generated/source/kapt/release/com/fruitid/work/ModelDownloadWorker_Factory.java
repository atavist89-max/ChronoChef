package com.fruitid.work;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.fruitid.data.download.ModelDownloadManager;
import com.fruitid.data.local.prefs.SettingsPrefs;
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
public final class ModelDownloadWorker_Factory {
  private final Provider<ModelDownloadManager> downloadManagerProvider;

  private final Provider<SettingsPrefs> settingsPrefsProvider;

  public ModelDownloadWorker_Factory(Provider<ModelDownloadManager> downloadManagerProvider,
      Provider<SettingsPrefs> settingsPrefsProvider) {
    this.downloadManagerProvider = downloadManagerProvider;
    this.settingsPrefsProvider = settingsPrefsProvider;
  }

  public ModelDownloadWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, downloadManagerProvider.get(), settingsPrefsProvider.get());
  }

  public static ModelDownloadWorker_Factory create(
      Provider<ModelDownloadManager> downloadManagerProvider,
      Provider<SettingsPrefs> settingsPrefsProvider) {
    return new ModelDownloadWorker_Factory(downloadManagerProvider, settingsPrefsProvider);
  }

  public static ModelDownloadWorker newInstance(Context context, WorkerParameters params,
      ModelDownloadManager downloadManager, SettingsPrefs settingsPrefs) {
    return new ModelDownloadWorker(context, params, downloadManager, settingsPrefs);
  }
}
