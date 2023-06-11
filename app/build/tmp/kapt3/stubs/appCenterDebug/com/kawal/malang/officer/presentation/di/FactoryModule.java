package com.kawal.malang.officer.presentation.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0017H\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/kawal/malang/officer/presentation/di/FactoryModule;", "", "()V", "provideAccountFactory", "Lcom/kawal/malang/officer/presentation/viewmodels/account/AccountViewModelFactory;", "app", "Landroid/app/Application;", "useCase", "Lcom/kawal/malang/officer/domain/usecase/account/AccountUseCase;", "provideAuthFactory", "Lcom/kawal/malang/officer/presentation/viewmodels/auth/AuthViewModelFactory;", "Lcom/kawal/malang/officer/domain/usecase/auth/AuthUseCase;", "provideBriefingFactory", "Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModelFactory;", "Lcom/kawal/malang/officer/domain/usecase/briefing/BriefingUseCase;", "provideNotificationFactory", "Lcom/kawal/malang/officer/presentation/viewmodels/notification/NotificationViewModelFactory;", "Lcom/kawal/malang/officer/domain/usecase/notification/NotificationUseCase;", "providePanicFactory", "Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModelFactory;", "Lcom/kawal/malang/officer/domain/usecase/panic/PanicUseCase;", "providePatrolFactory", "Lcom/kawal/malang/officer/presentation/viewmodels/patrol/PatrolViewModelFactory;", "Lcom/kawal/malang/officer/domain/usecase/patrol/PatrolUseCase;", "app_appCenterDebug"})
@dagger.Module()
public final class FactoryModule {
    
    public FactoryModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.viewmodels.auth.AuthViewModelFactory provideAuthFactory(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.usecase.auth.AuthUseCase useCase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModelFactory provideAccountFactory(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.usecase.account.AccountUseCase useCase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory providePanicFactory(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.usecase.panic.PanicUseCase useCase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.viewmodels.patrol.PatrolViewModelFactory providePatrolFactory(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.usecase.patrol.PatrolUseCase useCase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory provideBriefingFactory(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.usecase.briefing.BriefingUseCase useCase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.viewmodels.notification.NotificationViewModelFactory provideNotificationFactory(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.usecase.notification.NotificationUseCase useCase) {
        return null;
    }
}