package com.kawal.malang.officer.presentation.di

import com.kawal.malang.officer.data.repository.AppRepositoryImpl
import com.kawal.malang.officer.data.repository.datasource.RemoteDataSource
import com.kawal.malang.officer.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAppRepository(remoteDataSource: RemoteDataSource): AppRepository =
        AppRepositoryImpl(remoteDataSource)
}