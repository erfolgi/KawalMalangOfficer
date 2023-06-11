package com.kawal.malang.officer.presentation.report.list;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J \u0010#\u001a\u00020 2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`\'H\u0002J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020 H\u0016J\u001a\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00103\u001a\u00020 H\u0002J\b\u00104\u001a\u00020 H\u0002J\b\u00105\u001a\u00020 H\u0002J\b\u00106\u001a\u00020 H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u00067"}, d2 = {"Lcom/kawal/malang/officer/presentation/report/list/ReportListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/kawal/malang/officer/presentation/report/list/ReportListAdapter;", "getAdapter", "()Lcom/kawal/malang/officer/presentation/report/list/ReportListAdapter;", "setAdapter", "(Lcom/kawal/malang/officer/presentation/report/list/ReportListAdapter;)V", "askPermission", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "binding", "Lcom/kawal/malang/officer/databinding/FragmentReportListBinding;", "categoryId", "dialog", "Landroid/app/Dialog;", "isFiltered", "", "lat", "", "lng", "viewModel", "Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModel;", "viewModelFactory", "Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModelFactory;", "getViewModelFactory", "()Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModelFactory;", "setViewModelFactory", "(Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModelFactory;)V", "getPanicReport", "", "hideLoading", "initRecyclerView", "loadReportContent", "list", "Ljava/util/ArrayList;", "Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;", "Lkotlin/collections/ArrayList;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "refresh", "requestLocation", "setUpPermission", "showLoading", "app_appCenterDebug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class ReportListFragment extends androidx.fragment.app.Fragment {
    private com.kawal.malang.officer.databinding.FragmentReportListBinding binding;
    private com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModel viewModel;
    private android.app.Dialog dialog;
    private androidx.activity.result.ActivityResultLauncher<java.lang.String[]> askPermission;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.report.list.ReportListAdapter adapter;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory viewModelFactory;
    private java.lang.String categoryId = "";
    private boolean isFiltered = false;
    private double lat = 0.0;
    private double lng = 0.0;
    
    public ReportListFragment() {
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
    public final com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory p0) {
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
    
    private final void getPanicReport() {
    }
    
    private final void refresh() {
    }
    
    private final void loadReportContent(java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData> list) {
    }
    
    private final void requestLocation() {
    }
    
    private final void setUpPermission() {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
}