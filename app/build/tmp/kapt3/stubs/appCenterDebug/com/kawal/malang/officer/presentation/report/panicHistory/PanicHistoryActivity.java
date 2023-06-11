package com.kawal.malang.officer.presentation.report.panicHistory;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\t\u001a\u00020\u0016H\u0002J\u0010\u0010\'\u001a\u00020&2\u0006\u0010\t\u001a\u00020\u0016H\u0003J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J \u0010.\u001a\u00020&2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020100j\b\u0012\u0004\u0012\u000201`2H\u0002J \u00103\u001a\u00020&2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020400j\b\u0012\u0004\u0012\u000204`2H\u0002J\u0012\u00105\u001a\u00020&2\b\u00106\u001a\u0004\u0018\u000107H\u0014J\b\u00108\u001a\u00020&H\u0014J\b\u00109\u001a\u00020&H\u0002J\b\u0010:\u001a\u00020&H\u0002J\b\u0010;\u001a\u00020&H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006<"}, d2 = {"Lcom/kawal/malang/officer/presentation/report/panicHistory/PanicHistoryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/kawal/malang/officer/presentation/report/list/ReportListAdapter;", "getAdapter", "()Lcom/kawal/malang/officer/presentation/report/list/ReportListAdapter;", "setAdapter", "(Lcom/kawal/malang/officer/presentation/report/list/ReportListAdapter;)V", "binding", "Lcom/kawal/malang/officer/databinding/ActivityPanicHistoryBinding;", "bsd", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "categoryId", "", "dialog", "Landroid/app/Dialog;", "isFiltered", "", "paging", "Lcom/kawal/malang/officer/core/util/PaginationListener;", "panicFilterBinding", "Lcom/kawal/malang/officer/databinding/PanicFilterBinding;", "reportCategoryAdapter", "Lcom/kawal/malang/officer/presentation/adapter/ReportCategoryAdapter;", "getReportCategoryAdapter", "()Lcom/kawal/malang/officer/presentation/adapter/ReportCategoryAdapter;", "setReportCategoryAdapter", "(Lcom/kawal/malang/officer/presentation/adapter/ReportCategoryAdapter;)V", "viewModel", "Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModel;", "viewModelFactory", "Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModelFactory;", "getViewModelFactory", "()Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModelFactory;", "setViewModelFactory", "(Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModelFactory;)V", "adapterEventHandler", "", "filterDismissed", "filterPanicReport", "getCategories", "getPanicReport", "hideLoading", "initFilterDialog", "initRecyclerView", "loadCategories", "list", "Ljava/util/ArrayList;", "Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;", "Lkotlin/collections/ArrayList;", "loadReportContent", "Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "paginate", "refresh", "showLoading", "app_appCenterDebug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class PanicHistoryActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.kawal.malang.officer.databinding.ActivityPanicHistoryBinding binding;
    private com.kawal.malang.officer.databinding.PanicFilterBinding panicFilterBinding;
    private com.google.android.material.bottomsheet.BottomSheetDialog bsd;
    private com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModel viewModel;
    private android.app.Dialog dialog;
    private com.kawal.malang.officer.core.util.PaginationListener paging;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.report.list.ReportListAdapter adapter;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter reportCategoryAdapter;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory viewModelFactory;
    private java.lang.String categoryId = "";
    private boolean isFiltered = false;
    
    public PanicHistoryActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.report.list.ReportListAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.report.list.ReportListAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter getReportCategoryAdapter() {
        return null;
    }
    
    public final void setReportCategoryAdapter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void initRecyclerView() {
    }
    
    private final void initFilterDialog() {
    }
    
    private final void getPanicReport() {
    }
    
    private final void getCategories() {
    }
    
    private final void filterPanicReport() {
    }
    
    private final void refresh() {
    }
    
    private final void paginate() {
    }
    
    private final void adapterEventHandler(com.kawal.malang.officer.databinding.PanicFilterBinding binding) {
    }
    
    private final void loadReportContent(java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData> list) {
    }
    
    private final void loadCategories(java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData> list) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void filterDismissed(com.kawal.malang.officer.databinding.PanicFilterBinding binding) {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
}