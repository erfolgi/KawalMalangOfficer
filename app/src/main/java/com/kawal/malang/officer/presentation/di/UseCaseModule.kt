package com.kawal.malang.officer.presentation.di

import com.kawal.malang.officer.domain.repository.AppRepository
import com.kawal.malang.officer.domain.usecase.account.AccountUseCase
import com.kawal.malang.officer.domain.usecase.auth.AuthUseCase
import com.kawal.malang.officer.domain.usecase.briefing.BriefingUseCase
import com.kawal.malang.officer.domain.usecase.notification.NotificationUseCase
import com.kawal.malang.officer.domain.usecase.panic.PanicUseCase
import com.kawal.malang.officer.domain.usecase.patrol.PatrolUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideAuthUseCase(repository: AppRepository): AuthUseCase = AuthUseCase(repository)

    @Provides
    @Singleton
    fun provideAccountUseCase(repository: AppRepository): AccountUseCase =
        AccountUseCase(repository)

    @Provides
    @Singleton
    fun providePanicUseCase(repository: AppRepository): PanicUseCase = PanicUseCase(repository)

    @Provides
    @Singleton
    fun providePatrolUseCase(repository: AppRepository): PatrolUseCase = PatrolUseCase(repository)

    @Provides
    @Singleton
    fun provideBriefingUseCase(repository: AppRepository): BriefingUseCase = BriefingUseCase(repository)

    @Provides
    @Singleton
    fun provideNotificationUseCase(repository: AppRepository): NotificationUseCase = NotificationUseCase(repository)
}