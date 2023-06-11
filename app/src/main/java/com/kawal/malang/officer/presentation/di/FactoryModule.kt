package com.kawal.malang.officer.presentation.di

import android.app.Application
import com.kawal.malang.officer.domain.usecase.account.AccountUseCase
import com.kawal.malang.officer.domain.usecase.auth.AuthUseCase
import com.kawal.malang.officer.domain.usecase.briefing.BriefingUseCase
import com.kawal.malang.officer.domain.usecase.notification.NotificationUseCase
import com.kawal.malang.officer.domain.usecase.panic.PanicUseCase
import com.kawal.malang.officer.domain.usecase.patrol.PatrolUseCase
import com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModelFactory
import com.kawal.malang.officer.presentation.viewmodels.auth.AuthViewModelFactory
import com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory
import com.kawal.malang.officer.presentation.viewmodels.notification.NotificationViewModelFactory
import com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory
import com.kawal.malang.officer.presentation.viewmodels.patrol.PatrolViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun provideAuthFactory(app: Application, useCase: AuthUseCase): AuthViewModelFactory =
        AuthViewModelFactory(app, useCase)

    @Provides
    @Singleton
    fun provideAccountFactory(app: Application, useCase: AccountUseCase): AccountViewModelFactory =
        AccountViewModelFactory(app, useCase)

    @Provides
    @Singleton
    fun providePanicFactory(app: Application, useCase: PanicUseCase): PanicViewModelFactory =
        PanicViewModelFactory(app, useCase)

    @Provides
    @Singleton
    fun providePatrolFactory(app: Application, useCase: PatrolUseCase): PatrolViewModelFactory =
        PatrolViewModelFactory(app, useCase)

    @Provides
    @Singleton
    fun provideBriefingFactory(app: Application, useCase: BriefingUseCase): BriefingViewModelFactory =
        BriefingViewModelFactory(app, useCase)

    @Provides
    @Singleton
    fun provideNotificationFactory(app: Application, useCase: NotificationUseCase): NotificationViewModelFactory =
        NotificationViewModelFactory(app, useCase)
}