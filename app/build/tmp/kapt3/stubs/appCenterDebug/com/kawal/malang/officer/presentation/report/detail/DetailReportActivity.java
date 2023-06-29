package com.kawal.malang.officer.presentation.report.detail;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 W2\u00020\u0001:\u0001WB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020?H\u0002J\b\u0010A\u001a\u00020?H\u0002J\b\u0010B\u001a\u00020?H\u0002J\b\u0010C\u001a\u00020?H\u0002J\b\u0010D\u001a\u00020?H\u0003J\b\u0010E\u001a\u00020?H\u0002J\u0010\u0010F\u001a\u00020?2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020?H\u0002J\b\u0010J\u001a\u00020?H\u0002J\b\u0010K\u001a\u00020?H\u0002J\b\u0010L\u001a\u00020?H\u0002J\b\u0010M\u001a\u00020?H\u0002J\u0012\u0010N\u001a\u00020?2\b\u0010O\u001a\u0004\u0018\u00010PH\u0014J\u0010\u0010Q\u001a\u00020?2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010R\u001a\u00020?H\u0002J\b\u0010S\u001a\u00020?H\u0002J\u0006\u0010T\u001a\u00020?J\u0006\u0010U\u001a\u00020?J\b\u0010V\u001a\u00020?H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u00108\u001a\u0002098\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006X"}, d2 = {"Lcom/kawal/malang/officer/presentation/report/detail/DetailReportActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/kawal/malang/officer/databinding/ActivityDetailReportBinding;", "body", "Ljava/util/HashMap;", "", "Lokhttp3/RequestBody;", "bsdTimeline", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "data", "Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;", "detailOfficerAdapter", "Lcom/kawal/malang/officer/presentation/report/detail/DetailOfficerAdapter;", "getDetailOfficerAdapter", "()Lcom/kawal/malang/officer/presentation/report/detail/DetailOfficerAdapter;", "setDetailOfficerAdapter", "(Lcom/kawal/malang/officer/presentation/report/detail/DetailOfficerAdapter;)V", "dialog", "Landroid/app/Dialog;", "file", "Ljava/io/File;", "finishDialog", "finishPanicBinding", "Lcom/kawal/malang/officer/databinding/FinishPanicDialogBinding;", "geoPoint", "Lorg/osmdroid/util/GeoPoint;", "id", "", "launchResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mapController", "Lorg/osmdroid/views/MapController;", "policeCarAdapter", "Lcom/kawal/malang/officer/presentation/report/detail/PoliceCarAdapter;", "getPoliceCarAdapter", "()Lcom/kawal/malang/officer/presentation/report/detail/PoliceCarAdapter;", "setPoliceCarAdapter", "(Lcom/kawal/malang/officer/presentation/report/detail/PoliceCarAdapter;)V", "preference", "Lcom/kawal/malang/officer/core/util/AppPreference;", "ratingBsdBinding", "Lcom/kawal/malang/officer/databinding/RatingBsdBinding;", "timelineAdapter", "Lcom/kawal/malang/officer/presentation/panicevent/TimelineAdapter;", "getTimelineAdapter", "()Lcom/kawal/malang/officer/presentation/panicevent/TimelineAdapter;", "setTimelineAdapter", "(Lcom/kawal/malang/officer/presentation/panicevent/TimelineAdapter;)V", "timelineBsdBinding", "Lcom/kawal/malang/officer/databinding/PanicTimelineBsdBinding;", "viewModel", "Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModel;", "viewModelFactory", "Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModelFactory;", "getViewModelFactory", "()Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModelFactory;", "setViewModelFactory", "(Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModelFactory;)V", "checkButtonCondition", "", "checkIfPanicIsDone", "finishPanic", "handleTab", "hideLoading", "initAppBar", "initFinishPanicDialog", "initMap", "marker", "Lorg/osmdroid/views/overlay/Marker;", "initRatingDialog", "initRecyclerView", "initTimelineDialog", "loadContent", "loadReporterMarker", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshDetail", "respondToPanic", "showLoading", "startPatrol", "stopPatrol", "takeImage", "Companion", "app_appCenterDebug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class DetailReportActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.kawal.malang.officer.presentation.report.detail.DetailReportActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DETAIL_DATA = "DETAIL_DATA";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "ID";
    private com.kawal.malang.officer.databinding.ActivityDetailReportBinding binding;
    private com.kawal.malang.officer.databinding.FinishPanicDialogBinding finishPanicBinding;
    private com.kawal.malang.officer.databinding.PanicTimelineBsdBinding timelineBsdBinding;
    private com.kawal.malang.officer.databinding.RatingBsdBinding ratingBsdBinding;
    private com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModel viewModel;
    private android.app.Dialog dialog;
    private android.app.Dialog finishDialog;
    private org.osmdroid.views.MapController mapController;
    private org.osmdroid.util.GeoPoint geoPoint;
    private com.google.android.material.bottomsheet.BottomSheetDialog bsdTimeline;
    private com.kawal.malang.officer.core.util.AppPreference preference;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.report.detail.PoliceCarAdapter policeCarAdapter;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.report.detail.DetailOfficerAdapter detailOfficerAdapter;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory viewModelFactory;
    @javax.inject.Inject()
    public com.kawal.malang.officer.presentation.panicevent.TimelineAdapter timelineAdapter;
    private com.kawal.malang.officer.data.model.panic.report.PanicReportData data;
    private java.io.File file;
    private final java.util.HashMap<java.lang.String, okhttp3.RequestBody> body = null;
    private int id = 0;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> launchResult;
    
    public DetailReportActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.report.detail.PoliceCarAdapter getPoliceCarAdapter() {
        return null;
    }
    
    public final void setPoliceCarAdapter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.report.detail.PoliceCarAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.report.detail.DetailOfficerAdapter getDetailOfficerAdapter() {
        return null;
    }
    
    public final void setDetailOfficerAdapter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.report.detail.DetailOfficerAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.viewmodels.panic.PanicViewModelFactory p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.presentation.panicevent.TimelineAdapter getTimelineAdapter() {
        return null;
    }
    
    public final void setTimelineAdapter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.presentation.panicevent.TimelineAdapter p0) {
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
    
    private final void initFinishPanicDialog() {
    }
    
    private final void initTimelineDialog() {
    }
    
    private final void initRatingDialog() {
    }
    
    private final void initMap(org.osmdroid.views.overlay.Marker marker) {
    }
    
    private final void loadReporterMarker() {
    }
    
    private final void loadContent() {
    }
    
    private final void handleTab() {
    }
    
    private final void checkButtonCondition() {
    }
    
    private final void checkIfPanicIsDone() {
    }
    
    private final void takeImage() {
    }
    
    private final void refreshDetail(int id) {
    }
    
    private final void respondToPanic() {
    }
    
    private final void finishPanic() {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
    
    public final void startPatrol() {
    }
    
    public final void stopPatrol() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/kawal/malang/officer/presentation/report/detail/DetailReportActivity$Companion;", "", "()V", "DETAIL_DATA", "", "ID", "app_appCenterDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}