package com.kawal.malang.officer.presentation.notification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J \u0010\u001b\u001a\u00020\u00182\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fH\u0002J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u001a\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010*\u001a\u00020\u0018H\u0002J\b\u0010+\u001a\u00020\u0018H\u0002J\b\u0010,\u001a\u00020\u0018H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/kawal/malang/officer/presentation/notification/NotificationFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/kawal/malang/officer/presentation/notification/NotificationAdapter;", "getAdapter", "()Lcom/kawal/malang/officer/presentation/notification/NotificationAdapter;", "setAdapter", "(Lcom/kawal/malang/officer/presentation/notification/NotificationAdapter;)V", "binding", "Lcom/kawal/malang/officer/databinding/FragmentNotificationBinding;", "dialog", "Landroid/app/Dialog;", "factory", "Lcom/kawal/malang/officer/presentation/viewmodels/notification/NotificationViewModelFactory;", "getFactory", "()Lcom/kawal/malang/officer/presentation/viewmodels/notification/NotificationViewModelFactory;", "setFactory", "(Lcom/kawal/malang/officer/presentation/viewmodels/notification/NotificationViewModelFactory;)V", "paging", "Lcom/kawal/malang/officer/core/util/PaginationListener;", "viewModel", "Lcom/kawal/malang/officer/presentation/viewmodels/notification/NotificationViewModel;", "getNotification", "", "hideLoading", "initRecyclerView", "loadContent", "list", "Ljava/util/ArrayList;", "Lcom/kawal/malang/officer/data/model/notification/NotificationData;", "Lkotlin/collections/ArrayList;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "paginate", "refresh", "showLoading", "app_appCenterDebug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class NotificationFragment extends androidx.fragment.app.Fragment {
    private com.kawal.malang.officer.databinding.FragmentNotificationBinding binding;
    private com.kawal.malang.officer.presentation.viewmodels.notification.NotificationViewModel viewModel;
    private android.app.Dialog dialog;
    private com.kawal.malang.officer.core.util.PaginationListener paging;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.notification.NotificationAdapter adapter;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.viewmodels.notification.NotificationViewModelFactory factory;
    
    public NotificationFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.notification.NotificationAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.notification.NotificationAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.viewmodels.notification.NotificationViewModelFactory getFactory() {
        return null;
    }
    
    public final void setFactory(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.viewmodels.notification.NotificationViewModelFactory p0) {
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
    
    private final void initRecyclerView() {
    }
    
    private final void getNotification() {
    }
    
    private final void refresh() {
    }
    
    private final void paginate() {
    }
    
    private final void loadContent(java.util.ArrayList<com.kawal.malang.officer.data.model.notification.NotificationData> list) {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
}