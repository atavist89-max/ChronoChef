package com.fruitid.ml;

import android.content.Context;
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
public final class GemmaInference_Factory implements Factory<GemmaInference> {
  private final Provider<Context> contextProvider;

  private final Provider<ModelRepository> modelRepositoryProvider;

  private final Provider<GemmaInputProcessor> inputProcessorProvider;

  private final Provider<GemmaOutputParser> outputParserProvider;

  public GemmaInference_Factory(Provider<Context> contextProvider,
      Provider<ModelRepository> modelRepositoryProvider,
      Provider<GemmaInputProcessor> inputProcessorProvider,
      Provider<GemmaOutputParser> outputParserProvider) {
    this.contextProvider = contextProvider;
    this.modelRepositoryProvider = modelRepositoryProvider;
    this.inputProcessorProvider = inputProcessorProvider;
    this.outputParserProvider = outputParserProvider;
  }

  @Override
  public GemmaInference get() {
    return newInstance(contextProvider.get(), modelRepositoryProvider.get(), inputProcessorProvider.get(), outputParserProvider.get());
  }

  public static GemmaInference_Factory create(Provider<Context> contextProvider,
      Provider<ModelRepository> modelRepositoryProvider,
      Provider<GemmaInputProcessor> inputProcessorProvider,
      Provider<GemmaOutputParser> outputParserProvider) {
    return new GemmaInference_Factory(contextProvider, modelRepositoryProvider, inputProcessorProvider, outputParserProvider);
  }

  public static GemmaInference newInstance(Context context, ModelRepository modelRepository,
      GemmaInputProcessor inputProcessor, GemmaOutputParser outputParser) {
    return new GemmaInference(context, modelRepository, inputProcessor, outputParser);
  }
}
