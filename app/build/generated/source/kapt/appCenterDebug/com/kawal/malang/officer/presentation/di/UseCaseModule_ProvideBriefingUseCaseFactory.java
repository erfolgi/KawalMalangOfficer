// Generated by Dagger (https://dagger.dev).
package com.kawal.malang.officer.presentation.di;

import com.kawal.malang.officer.domain.repository.AppRepository;
import com.kawal.malang.officer.domain.usecase.briefing.BriefingUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UseCaseModule_ProvideBriefingUseCaseFactory implements Factory<BriefingUseCase> {
  private final UseCaseModule module;

  private final Provider<AppRepository> repositoryProvider;

  public UseCaseModule_ProvideBriefingUseCaseFactory(UseCaseModule module,
      Provider<AppRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public BriefingUseCase get() {
    return provideBriefingUseCase(module, repositoryProvider.get());
  }

  public static UseCaseModule_ProvideBriefingUseCaseFactory create(UseCaseModule module,
      Provider<AppRepository> repositoryProvider) {
    return new UseCaseModule_ProvideBriefingUseCaseFactory(module, repositoryProvider);
  }

  public static BriefingUseCase provideBriefingUseCase(UseCaseModule instance,
      AppRepository repository) {
    return Preconditions.checkNotNullFromProvides(instance.provideBriefingUseCase(repository));
  }
}
