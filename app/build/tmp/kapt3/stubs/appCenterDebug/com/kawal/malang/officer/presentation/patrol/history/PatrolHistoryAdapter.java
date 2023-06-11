package com.kawal.malang.officer.presentation.patrol.history;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u0012\u001a\u00020\u00112\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00060\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/kawal/malang/officer/presentation/patrol/history/PatrolHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/kawal/malang/officer/presentation/patrol/history/PatrolHistoryAdapter$ViewHolder;", "()V", "callback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/kawal/malang/officer/data/model/panic/report/PatrolData;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "getDiffer", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "listener", "Lcom/kawal/malang/officer/presentation/patrol/history/PatrolHistoryAdapter$InitOfficerAdapterListener;", "getItemCount", "", "initOfficerAdapter", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "InitOfficerAdapterListener", "ViewHolder", "app_appCenterDebug"})
public final class PatrolHistoryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.kawal.malang.officer.presentation.patrol.history.PatrolHistoryAdapter.ViewHolder> {
    private com.kawal.malang.officer.presentation.patrol.history.PatrolHistoryAdapter.InitOfficerAdapterListener listener;
    private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.kawal.malang.officer.data.model.panic.report.PatrolData> callback = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.recyclerview.widget.AsyncListDiffer<com.kawal.malang.officer.data.model.panic.report.PatrolData> differ = null;
    
    public PatrolHistoryAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.AsyncListDiffer<com.kawal.malang.officer.data.model.panic.report.PatrolData> getDiffer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kawal.malang.officer.presentation.patrol.history.PatrolHistoryAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.patrol.history.PatrolHistoryAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void initOfficerAdapter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.patrol.history.PatrolHistoryAdapter.InitOfficerAdapterListener listener) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/kawal/malang/officer/presentation/patrol/history/PatrolHistoryAdapter$InitOfficerAdapterListener;", "", "init", "", "binding", "Lcom/kawal/malang/officer/databinding/PatrolHistoryItemBinding;", "data", "Lcom/kawal/malang/officer/data/model/panic/report/PatrolData;", "app_appCenterDebug"})
    public static abstract interface InitOfficerAdapterListener {
        
        public abstract void init(@org.jetbrains.annotations.NotNull()
        com.kawal.malang.officer.databinding.PatrolHistoryItemBinding binding, @org.jetbrains.annotations.NotNull()
        com.kawal.malang.officer.data.model.panic.report.PatrolData data);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/kawal/malang/officer/presentation/patrol/history/PatrolHistoryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/kawal/malang/officer/databinding/PatrolHistoryItemBinding;", "(Lcom/kawal/malang/officer/presentation/patrol/history/PatrolHistoryAdapter;Lcom/kawal/malang/officer/databinding/PatrolHistoryItemBinding;)V", "getBinding", "()Lcom/kawal/malang/officer/databinding/PatrolHistoryItemBinding;", "bind", "", "data", "Lcom/kawal/malang/officer/data/model/panic/report/PatrolData;", "app_appCenterDebug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.kawal.malang.officer.databinding.PatrolHistoryItemBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.kawal.malang.officer.databinding.PatrolHistoryItemBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.kawal.malang.officer.databinding.PatrolHistoryItemBinding getBinding() {
            return null;
        }
        
        @android.annotation.SuppressLint(value = {"SetTextI18n"})
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.kawal.malang.officer.data.model.panic.report.PatrolData data) {
        }
    }
}