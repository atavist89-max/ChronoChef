package com.fruitid.work;

import androidx.hilt.work.WorkerAssistedFactory;
import androidx.work.ListenableWorker;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import javax.annotation.processing.Generated;

@Generated("androidx.hilt.AndroidXHiltProcessor")
@Module
@InstallIn(SingletonComponent.class)
@OriginatingElement(
    topLevelClass = ModelDownloadWorker.class
)
public interface ModelDownloadWorker_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.fruitid.work.ModelDownloadWorker")
  WorkerAssistedFactory<? extends ListenableWorker> bind(
      ModelDownloadWorker_AssistedFactory factory);
}
