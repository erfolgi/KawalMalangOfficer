package com.kawal.malang.officer.presentation.briefing.detail;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0012\u0010\u001f\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0015J\b\u0010\"\u001a\u00020\u001bH\u0014J\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/kawal/malang/officer/presentation/briefing/detail/DetailBriefingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/kawal/malang/officer/databinding/ActivityDetailBriefingBinding;", "categories", "Ljava/util/ArrayList;", "Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;", "Lkotlin/collections/ArrayList;", "confirmBinding", "Lcom/kawal/malang/officer/databinding/ConfirmDialogBinding;", "confirmDialog", "Landroid/app/Dialog;", "data", "Lcom/kawal/malang/officer/data/model/briefing/BriefingData;", "dialog", "factory", "Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModelFactory;", "getFactory", "()Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModelFactory;", "setFactory", "(Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModelFactory;)V", "preference", "Lcom/kawal/malang/officer/core/util/AppPreference;", "viewModel", "Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModel;", "bind", "", "deleteBriefing", "hideLoading", "initConfirmDialog", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "refresh", "showLoading", "Companion", "app_appCenterDebug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class DetailBriefingActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.kawal.malang.officer.presentation.briefing.detail.DetailBriefingActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CATEGORIES = "CATEGORIES";
    private com.kawal.malang.officer.databinding.ActivityDetailBriefingBinding binding;
    private com.kawal.malang.officer.databinding.ConfirmDialogBinding confirmBinding;
    private com.kawal.malang.officer.core.util.AppPreference preference;
    private com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModel viewModel;
    private android.app.Dialog dialog;
    private android.app.Dialog confirmDialog;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory factory;
    private com.kawal.malang.officer.data.model.briefing.BriefingData data;
    private java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData> categories;
    
    public DetailBriefingActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory getFactory() {
        return null;
    }
    
    public final void setFactory(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory p0) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void bind() {
    }
    
    private final void initConfirmDialog() {
    }
    
    private final void refresh() {
    }
    
    private final void deleteBriefing() {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/kawal/malang/officer/presentation/briefing/detail/DetailBriefingActivity$Companion;", "", "()V", "CATEGORIES", "", "app_appCenterDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}