package com.kawal.malang.officer.presentation.viewmodels.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015J\u0006\u0010\u0017\u001a\u00020\u0013J\b\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR#\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/kawal/malang/officer/presentation/viewmodels/auth/AuthViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "authUseCase", "Lcom/kawal/malang/officer/domain/usecase/auth/AuthUseCase;", "(Landroid/app/Application;Lcom/kawal/malang/officer/domain/usecase/auth/AuthUseCase;)V", "loginData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/kawal/malang/officer/core/util/Resource;", "Lcom/kawal/malang/officer/data/model/BaseResponse;", "Lcom/kawal/malang/officer/data/model/auth/LoginData;", "getLoginData", "()Landroidx/lifecycle/MutableLiveData;", "logoutData", "getLogoutData", "pref", "Lcom/kawal/malang/officer/core/util/AppPreference;", "doLogin", "Lkotlinx/coroutines/Job;", "map", "", "", "doLogout", "getFcmToken", "", "app_appCenterDebug"})
public final class AuthViewModel extends androidx.lifecycle.AndroidViewModel {
    private final android.app.Application app = null;
    private final com.kawal.malang.officer.domain.usecase.auth.AuthUseCase authUseCase = null;
    private final com.kawal.malang.officer.core.util.AppPreference pref = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> loginData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> logoutData = null;
    
    public AuthViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.usecase.auth.AuthUseCase authUseCase) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> getLoginData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> getLogoutData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job doLogin(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> map) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job doLogout() {
        return null;
    }
    
    private final void getFcmToken() {
    }
}