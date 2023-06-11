package com.kawal.malang.officer.presentation.auth.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0014J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006 "}, d2 = {"Lcom/kawal/malang/officer/presentation/auth/login/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/kawal/malang/officer/databinding/ActivityLoginBinding;", "dialog", "Landroid/app/Dialog;", "pref", "Lcom/kawal/malang/officer/core/util/AppPreference;", "viewModel", "Lcom/kawal/malang/officer/presentation/viewmodels/auth/AuthViewModel;", "viewModelFactory", "Lcom/kawal/malang/officer/presentation/viewmodels/auth/AuthViewModelFactory;", "getViewModelFactory", "()Lcom/kawal/malang/officer/presentation/viewmodels/auth/AuthViewModelFactory;", "setViewModelFactory", "(Lcom/kawal/malang/officer/presentation/viewmodels/auth/AuthViewModelFactory;)V", "doLogin", "", "map", "", "", "editTextListener", "hideLoading", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showLoading", "successLogin", "loginData", "Lcom/kawal/malang/officer/data/model/auth/LoginData;", "app_appCenterDebug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.kawal.malang.officer.databinding.ActivityLoginBinding binding;
    private com.kawal.malang.officer.presentation.viewmodels.auth.AuthViewModel viewModel;
    private com.kawal.malang.officer.core.util.AppPreference pref;
    private android.app.Dialog dialog;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.viewmodels.auth.AuthViewModelFactory viewModelFactory;
    
    public LoginActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.viewmodels.auth.AuthViewModelFactory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.viewmodels.auth.AuthViewModelFactory p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void editTextListener() {
    }
    
    private final void doLogin(java.util.Map<java.lang.String, java.lang.String> map) {
    }
    
    private final void successLogin(com.kawal.malang.officer.data.model.auth.LoginData loginData) {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
}