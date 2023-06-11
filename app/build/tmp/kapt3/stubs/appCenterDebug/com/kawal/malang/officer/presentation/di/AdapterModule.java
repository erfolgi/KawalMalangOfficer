package com.kawal.malang.officer.presentation.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0007\u00a8\u0006\u0019"}, d2 = {"Lcom/kawal/malang/officer/presentation/di/AdapterModule;", "", "()V", "provideBriefingListAdapter", "Lcom/kawal/malang/officer/presentation/briefing/list/BriefingListAdapter;", "provideDetailOfficerAdapter", "Lcom/kawal/malang/officer/presentation/report/detail/DetailOfficerAdapter;", "provideNotificationAdapter", "Lcom/kawal/malang/officer/presentation/notification/NotificationAdapter;", "providePanicOfficerAdapter", "Lcom/kawal/malang/officer/presentation/panicevent/PanicOfficerAdapter;", "providePatrolHistoryAdapter", "Lcom/kawal/malang/officer/presentation/patrol/history/PatrolHistoryAdapter;", "providePatrolOfficerAdapter", "Lcom/kawal/malang/officer/presentation/account/profile/PatrolOfficerAdapter;", "providePoliceCarAdapter", "Lcom/kawal/malang/officer/presentation/report/detail/PoliceCarAdapter;", "provideReportCategoryAdapter", "Lcom/kawal/malang/officer/presentation/adapter/ReportCategoryAdapter;", "provideReportListAdapter", "Lcom/kawal/malang/officer/presentation/report/list/ReportListAdapter;", "provideReportStatusAdapter", "Lcom/kawal/malang/officer/presentation/adapter/ReportStatusAdapter;", "provideTimelineAdapter", "Lcom/kawal/malang/officer/presentation/panicevent/TimelineAdapter;", "app_appCenterDebug"})
@dagger.Module()
public final class AdapterModule {
    
    public AdapterModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.report.list.ReportListAdapter provideReportListAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.adapter.ReportStatusAdapter provideReportStatusAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter provideReportCategoryAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.briefing.list.BriefingListAdapter provideBriefingListAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.notification.NotificationAdapter provideNotificationAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.report.detail.PoliceCarAdapter providePoliceCarAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.report.detail.DetailOfficerAdapter provideDetailOfficerAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.account.profile.PatrolOfficerAdapter providePatrolOfficerAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.panicevent.PanicOfficerAdapter providePanicOfficerAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.patrol.history.PatrolHistoryAdapter providePatrolHistoryAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.kawal.malang.officer.presentation.panicevent.TimelineAdapter provideTimelineAdapter() {
        return null;
    }
}