package com.fruitid.data.download;

import android.content.Context;
import com.fruitid.data.local.prefs.SettingsPrefs;
import com.fruitid.data.repository.ModelRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class ModelDownloadManager_Factory implements Factory<ModelDownloadManager> {
  private final Provider<Context> contextProvider;

  private final Provider<ResumableDownloader> downloaderProvider;

  private final Provider<ModelRepository> modelRepositoryProvider;

  private final Provider<SettingsPrefs> settingsPrefsProvider;

  public ModelDownloadManager_Factory(Provider<Context> contextProvider,
      Provider<ResumableDownloader> downloaderProvider,
      Provider<ModelRepository> modelRepositoryProvider,
      Provider<SettingsPrefs> settingsPrefsProvider) {
    this.contextProvider = contextProvider;
    this.downloaderProvider = downloaderProvider;
    this.modelRepositoryProvider = modelRepositoryProvider;
    this.settingsPrefsProvider = settingsPrefsProvider;
  }

  @Override
  public ModelDownloadManager get() {
    return newInstance(contextProvider.get(), downloaderProvider.get(), modelRepositoryProvider.get(), settingsPrefsProvider.get());
  }

  public static ModelDownloadManager_Factory create(Provider<Context> contextProvider,
      Provider<ResumableDownloader> downloaderProvider,
      Provider<ModelRepository> modelRepositoryProvider,
      Provider<SettingsPrefs> settingsPrefsProvider) {
    return new ModelDownloadManager_Factory(contextProvider, downloaderProvider, modelRepositoryProvider, settingsPrefsProvider);
  }

  public static ModelDownloadManager newInstance(Context context, ResumableDownloader downloader,
      ModelRepository modelRepository, SettingsPrefs settingsPrefs) {
    return new ModelDownloadManager(context, downloader, modelRepository, settingsPrefs);
  }
}
