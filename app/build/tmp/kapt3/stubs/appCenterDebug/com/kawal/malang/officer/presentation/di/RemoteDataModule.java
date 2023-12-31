package com.kawal.malang.officer.presentation.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/kawal/malang/officer/presentation/di/RemoteDataModule;", "", "()V", "provideRemoteDataSource", "Lcom/kawal/malang/officer/data/repository/datasource/RemoteDataSource;", "service", "Lcom/kawal/malang/officer/data/api/ApiService;", "app_appCenterDebug"})
@dagger.Module()
public final class RemoteDataModule {
    
    public RemoteDataModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.data.repository.datasource.RemoteDataSource provideRemoteDataSource(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.data.api.ApiService service) {
        return null;
    }
}