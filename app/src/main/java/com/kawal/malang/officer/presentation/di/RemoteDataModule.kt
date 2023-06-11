package com.kawal.malang.officer.presentation.di

import com.kawal.malang.officer.data.api.ApiService
import com.kawal.malang.officer.data.repository.datasource.RemoteDataSource
import com.kawal.malang.officer.data.repository.datasourceimpl.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(service: ApiService): RemoteDataSource =
        RemoteDataSourceImpl(service)
}