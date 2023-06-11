package com.kawal.malang.officer.presentation.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/kawal/malang/officer/presentation/di/UseCaseModule;", "", "()V", "provideAccountUseCase", "Lcom/kawal/malang/officer/domain/usecase/account/AccountUseCase;", "repository", "Lcom/kawal/malang/officer/domain/repository/AppRepository;", "provideAuthUseCase", "Lcom/kawal/malang/officer/domain/usecase/auth/AuthUseCase;", "provideBriefingUseCase", "Lcom/kawal/malang/officer/domain/usecase/briefing/BriefingUseCase;", "provideNotificationUseCase", "Lcom/kawal/malang/officer/domain/usecase/notification/NotificationUseCase;", "providePanicUseCase", "Lcom/kawal/malang/officer/domain/usecase/panic/PanicUseCase;", "providePatrolUseCase", "Lcom/kawal/malang/officer/domain/usecase/patrol/PatrolUseCase;", "app_appCenterDebug"})
@dagger.Module()
public final class UseCaseModule {
    
    public UseCaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.domain.usecase.auth.AuthUseCase provideAuthUseCase(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.repository.AppRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.domain.usecase.account.AccountUseCase provideAccountUseCase(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.repository.AppRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.domain.usecase.panic.PanicUseCase providePanicUseCase(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.repository.AppRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.domain.usecase.patrol.PatrolUseCase providePatrolUseCase(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.repository.AppRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.domain.usecase.briefing.BriefingUseCase provideBriefingUseCase(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.repository.AppRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.domain.usecase.notification.NotificationUseCase provideNotificationUseCase(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.repository.AppRepository repository) {
        return null;
    }
}