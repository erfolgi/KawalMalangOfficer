package com.kawal.malang.officer.presentation.patrol.history;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0003J\b\u0010\u001f\u001a\u00020\u001cH\u0002J \u0010 \u001a\u00020\u001c2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$H\u0002J\u0012\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/kawal/malang/officer/presentation/patrol/history/PatrolHistoryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/kawal/malang/officer/databinding/ActivityPatrolHistoryBinding;", "dialog", "Landroid/app/Dialog;", "factory", "Lcom/kawal/malang/officer/presentation/viewmodels/patrol/PatrolViewModelFactory;", "getFactory", "()Lcom/kawal/malang/officer/presentation/viewmodels/patrol/PatrolViewModelFactory;", "setFactory", "(Lcom/kawal/malang/officer/presentation/viewmodels/patrol/PatrolViewModelFactory;)V", "officerAdapter", "Lcom/kawal/malang/officer/presentation/panicevent/PanicOfficerAdapter;", "getOfficerAdapter", "()Lcom/kawal/malang/officer/presentation/panicevent/PanicOfficerAdapter;", "setOfficerAdapter", "(Lcom/kawal/malang/officer/presentation/panicevent/PanicOfficerAdapter;)V", "patrolAdapter", "Lcom/kawal/malang/officer/presentation/patrol/history/PatrolHistoryAdapter;", "getPatrolAdapter", "()Lcom/kawal/malang/officer/presentation/patrol/history/PatrolHistoryAdapter;", "setPatrolAdapter", "(Lcom/kawal/malang/officer/presentation/patrol/history/PatrolHistoryAdapter;)V", "viewModel", "Lcom/kawal/malang/officer/presentation/viewmodels/patrol/PatrolViewModel;", "getPatrolHistory", "", "hideLoading", "initAppBar", "initRecyclerView", "loadContent", "list", "Ljava/util/ArrayList;", "Lcom/kawal/malang/officer/data/model/panic/report/PatrolData;", "Lkotlin/collections/ArrayList;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refresh", "showLoading", "app_appCenterDebug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class PatrolHistoryActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.kawal.malang.officer.databinding.ActivityPatrolHistoryBinding binding;
    private com.kawal.malang.officer.presentation.viewmodels.patrol.PatrolViewModel viewModel;
    private android.app.Dialog dialog;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.viewmodels.patrol.PatrolViewModelFactory factory;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.patrol.history.PatrolHistoryAdapter patrolAdapter;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.panicevent.PanicOfficerAdapter officerAdapter;
    
    public PatrolHistoryActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.viewmodels.patrol.PatrolViewModelFactory getFactory() {
        return null;
    }
    
    public final void setFactory(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.viewmodels.patrol.PatrolViewModelFactory p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.patrol.history.PatrolHistoryAdapter getPatrolAdapter() {
        return null;
    }
    
    public final void setPatrolAdapter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.patrol.history.PatrolHistoryAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.panicevent.PanicOfficerAdapter getOfficerAdapter() {
        return null;
    }
    
    public final void setOfficerAdapter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.panicevent.PanicOfficerAdapter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void initAppBar() {
    }
    
    private final void initRecyclerView() {
    }
    
    private final void getPatrolHistory() {
    }
    
    private final void refresh() {
    }
    
    private final void loadContent(java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PatrolData> list) {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
}