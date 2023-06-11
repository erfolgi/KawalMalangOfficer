// Generated by Dagger (https://dagger.dev).
package com.kawal.malang.officer.presentation.di;

import android.app.Application;
import com.kawal.malang.officer.domain.usecase.auth.AuthUseCase;
import com.kawal.malang.officer.presentation.viewmodels.auth.AuthViewModelFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class FactoryModule_ProvideAuthFactoryFactory implements Factory<AuthViewModelFactory> {
  private final FactoryModule module;

  private final Provider<Application> appProvider;

  private final Provider<AuthUseCase> useCaseProvider;

  public FactoryModule_ProvideAuthFactoryFactory(FactoryModule module,
      Provider<Application> appProvider, Provider<AuthUseCase> useCaseProvider) {
    this.module = module;
    this.appProvider = appProvider;
    this.useCaseProvider = useCaseProvider;
  }

  @Override
  public AuthViewModelFactory get() {
    return provideAuthFactory(module, appProvider.get(), useCaseProvider.get());
  }

  public static FactoryModule_ProvideAuthFactoryFactory create(FactoryModule module,
      Provider<Application> appProvider, Provider<AuthUseCase> useCaseProvider) {
    return new FactoryModule_ProvideAuthFactoryFactory(module, appProvider, useCaseProvider);
  }

  public static AuthViewModelFactory provideAuthFactory(FactoryModule instance, Application app,
      AuthUseCase useCase) {
    return Preconditions.checkNotNullFromProvides(instance.provideAuthFactory(app, useCase));
  }
}
