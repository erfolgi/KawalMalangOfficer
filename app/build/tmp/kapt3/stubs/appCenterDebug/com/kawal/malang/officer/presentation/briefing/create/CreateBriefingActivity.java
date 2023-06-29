package com.kawal.malang.officer.presentation.briefing.create;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020*H\u0003J\b\u0010-\u001a\u00020*H\u0002J\u0012\u0010.\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u00020*H\u0014J\b\u00102\u001a\u00020*H\u0003J\b\u00103\u001a\u00020*H\u0003J\b\u00104\u001a\u00020*H\u0002J\b\u00105\u001a\u00020*H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e0\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/kawal/malang/officer/presentation/briefing/create/CreateBriefingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/kawal/malang/officer/databinding/ActivityCreateBriefingBinding;", "body", "Ljava/util/HashMap;", "", "Lokhttp3/RequestBody;", "categories", "Ljava/util/ArrayList;", "Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;", "Lkotlin/collections/ArrayList;", "categoryId", "data", "Lcom/kawal/malang/officer/data/model/briefing/BriefingData;", "dialog", "Landroid/app/Dialog;", "factory", "Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModelFactory;", "getFactory", "()Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModelFactory;", "setFactory", "(Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModelFactory;)V", "file", "Ljava/io/File;", "isEdit", "", "launchResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "reportCategoryAdapter", "Lcom/kawal/malang/officer/presentation/adapter/ReportCategoryAdapter;", "getReportCategoryAdapter", "()Lcom/kawal/malang/officer/presentation/adapter/ReportCategoryAdapter;", "setReportCategoryAdapter", "(Lcom/kawal/malang/officer/presentation/adapter/ReportCategoryAdapter;)V", "tanggal", "viewModel", "Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModel;", "adapterEventHandler", "", "hideLoading", "initAppBar", "initRecyclerView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "pickDate", "setData", "showLoading", "takeImage", "Companion", "app_appCenterDebug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class CreateBriefingActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.kawal.malang.officer.presentation.briefing.create.CreateBriefingActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_EDIT = "IS_EDIT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATA = "DATA";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CATEGORY = "CATEGORY";
    private com.kawal.malang.officer.databinding.ActivityCreateBriefingBinding binding;
    private com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModel viewModel;
    private android.app.Dialog dialog;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory factory;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter reportCategoryAdapter;
    private boolean isEdit = false;
    private com.kawal.malang.officer.data.model.briefing.BriefingData data;
    private java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData> categories;
    private java.lang.String categoryId = "";
    private java.lang.String tanggal = "";
    private java.io.File file;
    private final java.util.HashMap<java.lang.String, okhttp3.RequestBody> body = null;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> launchResult;
    
    public CreateBriefingActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory getFactory() {
        return null;
    }
    
    public final void setFactory(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter getReportCategoryAdapter() {
        return null;
    }
    
    public final void setReportCategoryAdapter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void initAppBar() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void setData() {
    }
    
    private final void initRecyclerView() {
    }
    
    private final void adapterEventHandler() {
    }
    
    private final void takeImage() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void pickDate() {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/kawal/malang/officer/presentation/briefing/create/CreateBriefingActivity$Companion;", "", "()V", "CATEGORY", "", "DATA", "IS_EDIT", "app_appCenterDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}