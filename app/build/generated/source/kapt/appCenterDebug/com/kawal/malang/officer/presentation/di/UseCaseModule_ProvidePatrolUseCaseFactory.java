// Generated by Dagger (https://dagger.dev).
package com.kawal.malang.officer.presentation.di;

import com.kawal.malang.officer.domain.repository.AppRepository;
import com.kawal.malang.officer.domain.usecase.patrol.PatrolUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UseCaseModule_ProvidePatrolUseCaseFactory implements Factory<PatrolUseCase> {
  private final UseCaseModule module;

  private final Provider<AppRepository> repositoryProvider;

  public UseCaseModule_ProvidePatrolUseCaseFactory(UseCaseModule module,
      Provider<AppRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PatrolUseCase get() {
    return providePatrolUseCase(module, repositoryProvider.get());
  }

  public static UseCaseModule_ProvidePatrolUseCaseFactory create(UseCaseModule module,
      Provider<AppRepository> repositoryProvider) {
    return new UseCaseModule_ProvidePatrolUseCaseFactory(module, repositoryProvider);
  }

  public static PatrolUseCase providePatrolUseCase(UseCaseModule instance,
      AppRepository repository) {
    return Preconditions.checkNotNullFromProvides(instance.providePatrolUseCase(repository));
  }
}
