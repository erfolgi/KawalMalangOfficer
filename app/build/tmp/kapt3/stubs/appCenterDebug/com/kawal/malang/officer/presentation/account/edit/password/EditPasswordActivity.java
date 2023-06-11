package com.kawal.malang.officer.presentation.account.edit.password;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0003J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/kawal/malang/officer/presentation/account/edit/password/EditPasswordActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/kawal/malang/officer/databinding/ActivityEditPasswordBinding;", "body", "Ljava/util/HashMap;", "", "dialog", "Landroid/app/Dialog;", "factory", "Lcom/kawal/malang/officer/presentation/viewmodels/account/AccountViewModelFactory;", "getFactory", "()Lcom/kawal/malang/officer/presentation/viewmodels/account/AccountViewModelFactory;", "setFactory", "(Lcom/kawal/malang/officer/presentation/viewmodels/account/AccountViewModelFactory;)V", "viewModel", "Lcom/kawal/malang/officer/presentation/viewmodels/account/AccountViewModel;", "doUpdatePassword", "", "hideLoading", "initAppBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showLoading", "app_appCenterDebug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class EditPasswordActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.kawal.malang.officer.databinding.ActivityEditPasswordBinding binding;
    private com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModel viewModel;
    private android.app.Dialog dialog;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModelFactory factory;
    private final java.util.HashMap<java.lang.String, java.lang.String> body = null;
    
    public EditPasswordActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModelFactory getFactory() {
        return null;
    }
    
    public final void setFactory(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModelFactory p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void initAppBar() {
    }
    
    private final void doUpdatePassword() {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
}