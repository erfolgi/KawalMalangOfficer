package com.kawal.malang.officer.presentation.briefing.list;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010\t\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020*2\u0006\u0010\t\u001a\u00020\fH\u0003J\b\u0010,\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020*H\u0002J \u0010/\u001a\u00020*2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`1H\u0002J \u00102\u001a\u00020*2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u0002030\u0010j\b\u0012\u0004\u0012\u000203`1H\u0002J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020*H\u0016J\u001a\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u0002052\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010?\u001a\u00020*H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(\u00a8\u0006@"}, d2 = {"Lcom/kawal/malang/officer/presentation/briefing/list/BriefingListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/kawal/malang/officer/presentation/briefing/list/BriefingListAdapter;", "getAdapter", "()Lcom/kawal/malang/officer/presentation/briefing/list/BriefingListAdapter;", "setAdapter", "(Lcom/kawal/malang/officer/presentation/briefing/list/BriefingListAdapter;)V", "binding", "Lcom/kawal/malang/officer/databinding/FragmentBriefingListBinding;", "briefingFilterBinding", "Lcom/kawal/malang/officer/databinding/BriefingFilterBinding;", "bsd", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "categories", "Ljava/util/ArrayList;", "Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;", "categoryId", "", "dialog", "Landroid/app/Dialog;", "isFiltered", "", "paging", "Lcom/kawal/malang/officer/core/util/PaginationListener;", "reportCategoryAdapter", "Lcom/kawal/malang/officer/presentation/adapter/ReportCategoryAdapter;", "getReportCategoryAdapter", "()Lcom/kawal/malang/officer/presentation/adapter/ReportCategoryAdapter;", "setReportCategoryAdapter", "(Lcom/kawal/malang/officer/presentation/adapter/ReportCategoryAdapter;)V", "title", "viewModel", "Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModel;", "viewModelFactory", "Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModelFactory;", "getViewModelFactory", "()Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModelFactory;", "setViewModelFactory", "(Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModelFactory;)V", "adapterEventHandler", "", "filterDismissed", "hideLoading", "initFilterDialog", "initRecyclerView", "loadCategories", "list", "Lkotlin/collections/ArrayList;", "loadReportContent", "Lcom/kawal/malang/officer/data/model/briefing/BriefingData;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "showLoading", "app_appCenterDebug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class BriefingListFragment extends androidx.fragment.app.Fragment {
    private com.kawal.malang.officer.databinding.FragmentBriefingListBinding binding;
    private com.kawal.malang.officer.databinding.BriefingFilterBinding briefingFilterBinding;
    private com.google.android.material.bottomsheet.BottomSheetDialog bsd;
    private com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModel viewModel;
    private android.app.Dialog dialog;
    private com.kawal.malang.officer.core.util.PaginationListener paging;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.briefing.list.BriefingListAdapter adapter;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter reportCategoryAdapter;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory viewModelFactory;
    private java.lang.String categoryId = "";
    private boolean isFiltered = false;
    private java.lang.String title = "";
    private java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData> categories;
    
    public BriefingListFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.briefing.list.BriefingListAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.briefing.list.BriefingListAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter getReportCategoryAdapter() {
        return null;
    }
    
    public final void setReportCategoryAdapter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void initRecyclerView() {
    }
    
    private final void initFilterDialog() {
    }
    
    private final void adapterEventHandler(com.kawal.malang.officer.databinding.BriefingFilterBinding binding) {
    }
    
    private final void loadReportContent(java.util.ArrayList<com.kawal.malang.officer.data.model.briefing.BriefingData> list) {
    }
    
    private final void loadCategories(java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData> list) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void filterDismissed(com.kawal.malang.officer.databinding.BriefingFilterBinding binding) {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
}