package com.fruitid.work;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class ModelDownloadWorker_AssistedFactory_Impl implements ModelDownloadWorker_AssistedFactory {
  private final ModelDownloadWorker_Factory delegateFactory;

  ModelDownloadWorker_AssistedFactory_Impl(ModelDownloadWorker_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public ModelDownloadWorker create(Context arg0, WorkerParameters arg1) {
    return delegateFactory.get(arg0, arg1);
  }

  public static Provider<ModelDownloadWorker_AssistedFactory> create(
      ModelDownloadWorker_Factory delegateFactory) {
    return InstanceFactory.create(new ModelDownloadWorker_AssistedFactory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<ModelDownloadWorker_AssistedFactory> createFactoryProvider(
      ModelDownloadWorker_Factory delegateFactory) {
    return InstanceFactory.create(new ModelDownloadWorker_AssistedFactory_Impl(delegateFactory));
  }
}
