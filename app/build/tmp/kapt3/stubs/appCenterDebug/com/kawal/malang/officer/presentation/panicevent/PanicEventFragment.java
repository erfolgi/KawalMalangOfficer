package com.kawal.malang.officer.presentation.panicevent;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020%H\u0003J\b\u0010&\u001a\u00020%H\u0002J\b\u0010\'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020%H\u0002J\b\u0010*\u001a\u00020%H\u0002J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020%H\u0016J\b\u00104\u001a\u00020%H\u0016J\u001a\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00107\u001a\u00020%H\u0002J\b\u00108\u001a\u00020%H\u0002J\b\u00109\u001a\u00020%H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/kawal/malang/officer/presentation/panicevent/PanicEventFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/kawal/malang/officer/presentation/panicevent/PanicOfficerAdapter;", "getAdapter", "()Lcom/kawal/malang/officer/presentation/panicevent/PanicOfficerAdapter;", "setAdapter", "(Lcom/kawal/malang/officer/presentation/panicevent/PanicOfficerAdapter;)V", "askPermission", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "binding", "Lcom/kawal/malang/officer/databinding/FragmentPanicEventBinding;", "data", "Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;", "dialog", "Landroid/app/Dialog;", "factory", "Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModelFactory;", "getFactory", "()Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModelFactory;", "setFactory", "(Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModelFactory;)V", "geoPoint", "Lorg/osmdroid/util/GeoPoint;", "lat", "", "lng", "mapController", "Lorg/osmdroid/views/MapController;", "pref", "Lcom/kawal/malang/officer/core/util/AppPreference;", "viewModel", "Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModel;", "checkIfCarIsOnPatrol", "", "getActivatedPanic", "hideLoading", "initMap", "initRecyclerView", "loadReporterMarker", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onViewCreated", "view", "requestLocation", "setUpPermission", "showLoading", "app_appCenterDebug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class PanicEventFragment extends androidx.fragment.app.Fragment {
    private com.kawal.malang.officer.databinding.FragmentPanicEventBinding binding;
    private org.osmdroid.views.MapController mapController;
    private org.osmdroid.util.GeoPoint geoPoint;
    private androidx.activity.result.ActivityResultLauncher<java.lang.String[]> askPermission;
    private com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModel viewModel;
    private com.kawal.malang.officer.core.util.AppPreference pref;
    private android.app.Dialog dialog;
    private double lat = -6.1554;
    private double lng = 106.8927;
    private com.kawal.malang.officer.data.model.panic.report.PanicReportData data;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.panicevent.PanicOfficerAdapter adapter;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory factory;
    
    public PanicEventFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.panicevent.PanicOfficerAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.panicevent.PanicOfficerAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory getFactory() {
        return null;
    }
    
    public final void setFactory(@org.jetbrains.annotations.NotNull()
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
    
    @java.lang.Override()
    public void onPause() {
    }
    
    private final void initRecyclerView() {
    }
    
    private final void initMap() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void checkIfCarIsOnPatrol() {
    }
    
    private final void loadReporterMarker() {
    }
    
    private final void getActivatedPanic() {
    }
    
    private final void setUpPermission() {
    }
    
    private final void requestLocation() {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
}