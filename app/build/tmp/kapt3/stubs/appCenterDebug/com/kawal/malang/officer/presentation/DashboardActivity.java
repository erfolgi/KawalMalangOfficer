package com.kawal.malang.officer.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0014J\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/kawal/malang/officer/presentation/DashboardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/kawal/malang/officer/databinding/ActivityDashboardBinding;", "bindingOfficer", "Lcom/kawal/malang/officer/databinding/ActivityOfficerBinding;", "locService", "Lcom/kawal/malang/officer/core/service/SendLocationService;", "preference", "Lcom/kawal/malang/officer/core/util/AppPreference;", "checkLocationService", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "startPatrol", "stopPatrol", "app_appCenterDebug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class DashboardActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.kawal.malang.officer.databinding.ActivityDashboardBinding binding;
    private com.kawal.malang.officer.databinding.ActivityOfficerBinding bindingOfficer;
    private com.kawal.malang.officer.core.util.AppPreference preference;
    private com.kawal.malang.officer.core.service.SendLocationService locService;
    
    public DashboardActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void checkLocationService() {
    }
    
    public final void startPatrol() {
    }
    
    public final void stopPatrol() {
    }
}