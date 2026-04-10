package com.fruitid.ui;

import com.fruitid.data.repository.ModelRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<ModelRepository> modelRepositoryProvider;

  public MainActivity_MembersInjector(Provider<ModelRepository> modelRepositoryProvider) {
    this.modelRepositoryProvider = modelRepositoryProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<ModelRepository> modelRepositoryProvider) {
    return new MainActivity_MembersInjector(modelRepositoryProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectModelRepository(instance, modelRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.fruitid.ui.MainActivity.modelRepository")
  public static void injectModelRepository(MainActivity instance, ModelRepository modelRepository) {
    instance.modelRepository = modelRepository;
  }
}
