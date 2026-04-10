package com.fruitid.ui.viewmodel;

import android.app.Application;
import com.fruitid.data.download.ModelDownloadManager;
import com.fruitid.data.local.prefs.SettingsPrefs;
import com.fruitid.data.repository.ModelRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class DownloadViewModel_Factory implements Factory<DownloadViewModel> {
  private final Provider<Application> applicationProvider;

  private final Provider<ModelDownloadManager> downloadManagerProvider;

  private final Provider<ModelRepository> modelRepositoryProvider;

  private final Provider<SettingsPrefs> settingsPrefsProvider;

  public DownloadViewModel_Factory(Provider<Application> applicationProvider,
      Provider<ModelDownloadManager> downloadManagerProvider,
      Provider<ModelRepository> modelRepositoryProvider,
      Provider<SettingsPrefs> settingsPrefsProvider) {
    this.applicationProvider = applicationProvider;
    this.downloadManagerProvider = downloadManagerProvider;
    this.modelRepositoryProvider = modelRepositoryProvider;
    this.settingsPrefsProvider = settingsPrefsProvider;
  }

  @Override
  public DownloadViewModel get() {
    return newInstance(applicationProvider.get(), downloadManagerProvider.get(), modelRepositoryProvider.get(), settingsPrefsProvider.get());
  }

  public static DownloadViewModel_Factory create(Provider<Application> applicationProvider,
      Provider<ModelDownloadManager> downloadManagerProvider,
      Provider<ModelRepository> modelRepositoryProvider,
      Provider<SettingsPrefs> settingsPrefsProvider) {
    return new DownloadViewModel_Factory(applicationProvider, downloadManagerProvider, modelRepositoryProvider, settingsPrefsProvider);
  }

  public static DownloadViewModel newInstance(Application application,
      ModelDownloadManager downloadManager, ModelRepository modelRepository,
      SettingsPrefs settingsPrefs) {
    return new DownloadViewModel(application, downloadManager, modelRepository, settingsPrefs);
  }
}
