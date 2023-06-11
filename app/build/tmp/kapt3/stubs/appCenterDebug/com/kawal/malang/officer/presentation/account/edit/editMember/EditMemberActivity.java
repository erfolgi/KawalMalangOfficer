package com.kawal.malang.officer.presentation.account.edit.editMember;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0003J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/kawal/malang/officer/presentation/account/edit/editMember/EditMemberActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/kawal/malang/officer/databinding/ActivityEditMemberBinding;", "body", "Ljava/util/HashMap;", "", "data", "Lcom/kawal/malang/officer/data/model/auth/LoginData;", "dialog", "Landroid/app/Dialog;", "factory", "Lcom/kawal/malang/officer/presentation/viewmodels/account/AccountViewModelFactory;", "getFactory", "()Lcom/kawal/malang/officer/presentation/viewmodels/account/AccountViewModelFactory;", "setFactory", "(Lcom/kawal/malang/officer/presentation/viewmodels/account/AccountViewModelFactory;)V", "viewModel", "Lcom/kawal/malang/officer/presentation/viewmodels/account/AccountViewModel;", "doUpdateMember", "", "hideLoading", "initAppBar", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showLoading", "Companion", "app_appCenterDebug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class EditMemberActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.kawal.malang.officer.presentation.account.edit.editMember.EditMemberActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATA = "DATA";
    private com.kawal.malang.officer.databinding.ActivityEditMemberBinding binding;
    private com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModel viewModel;
    private android.app.Dialog dialog;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModelFactory factory;
    private com.kawal.malang.officer.data.model.auth.LoginData data;
    private final java.util.HashMap<java.lang.String, java.lang.String> body = null;
    
    public EditMemberActivity() {
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
    
    private final void loadData() {
    }
    
    private final void doUpdateMember() {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/kawal/malang/officer/presentation/account/edit/editMember/EditMemberActivity$Companion;", "", "()V", "DATA", "", "app_appCenterDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}