package com.kawal.malang.officer.presentation.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0013\u0014B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\u0005H\u0016J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/kawal/malang/officer/presentation/adapter/ReportStatusAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/kawal/malang/officer/presentation/adapter/ReportStatusAdapter$ViewHolder;", "()V", "index", "", "Ljava/lang/Integer;", "onClickListener", "Lcom/kawal/malang/officer/presentation/adapter/ReportStatusAdapter$OnClickListener;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnClickListener", "OnClickListener", "ViewHolder", "app_appCenterDebug"})
public final class ReportStatusAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.kawal.malang.officer.presentation.adapter.ReportStatusAdapter.ViewHolder> {
    private com.kawal.malang.officer.presentation.adapter.ReportStatusAdapter.OnClickListener onClickListener;
    private java.lang.Integer index;
    
    public ReportStatusAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.kawal.malang.officer.presentation.adapter.ReportStatusAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.adapter.ReportStatusAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void setOnClickListener(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.adapter.ReportStatusAdapter.OnClickListener onClickListener) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/kawal/malang/officer/presentation/adapter/ReportStatusAdapter$OnClickListener;", "", "tapStatus", "", "status", "", "app_appCenterDebug"})
    public static abstract interface OnClickListener {
        
        public abstract void tapStatus(@org.jetbrains.annotations.NotNull()
        java.lang.String status);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/kawal/malang/officer/presentation/adapter/ReportStatusAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/kawal/malang/officer/databinding/StatusItemBinding;", "(Lcom/kawal/malang/officer/presentation/adapter/ReportStatusAdapter;Lcom/kawal/malang/officer/databinding/StatusItemBinding;)V", "bind", "", "status", "", "pos", "", "app_appCenterDebug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.kawal.malang.officer.databinding.StatusItemBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.kawal.malang.officer.databinding.StatusItemBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        java.lang.String status, int pos) {
        }
    }
}