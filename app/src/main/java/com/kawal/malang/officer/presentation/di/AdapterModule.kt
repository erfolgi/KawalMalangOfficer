package com.kawal.malang.officer.presentation.di

import com.kawal.malang.officer.presentation.account.profile.PatrolOfficerAdapter
import com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter
import com.kawal.malang.officer.presentation.adapter.ReportStatusAdapter
import com.kawal.malang.officer.presentation.briefing.list.BriefingListAdapter
import com.kawal.malang.officer.presentation.notification.NotificationAdapter
import com.kawal.malang.officer.presentation.panicevent.PanicOfficerAdapter
import com.kawal.malang.officer.presentation.panicevent.TimelineAdapter
import com.kawal.malang.officer.presentation.patrol.history.PatrolHistoryAdapter
import com.kawal.malang.officer.presentation.report.detail.DetailOfficerAdapter
import com.kawal.malang.officer.presentation.report.detail.PoliceCarAdapter
import com.kawal.malang.officer.presentation.report.list.ReportListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    @Singleton
    fun provideReportListAdapter(): ReportListAdapter = ReportListAdapter()

    @Provides
    @Singleton
    fun provideReportStatusAdapter(): ReportStatusAdapter = ReportStatusAdapter()

    @Provides
    @Singleton
    fun provideReportCategoryAdapter(): ReportCategoryAdapter = ReportCategoryAdapter()

    @Provides
    @Singleton
    fun provideBriefingListAdapter(): BriefingListAdapter = BriefingListAdapter()

    @Provides
    @Singleton
    fun provideNotificationAdapter(): NotificationAdapter = NotificationAdapter()

    @Provides
    @Singleton
    fun providePoliceCarAdapter(): PoliceCarAdapter = PoliceCarAdapter()

    @Provides
    @Singleton
    fun provideDetailOfficerAdapter(): DetailOfficerAdapter = DetailOfficerAdapter()

    @Provides
    @Singleton
    fun providePatrolOfficerAdapter(): PatrolOfficerAdapter = PatrolOfficerAdapter()

    @Provides
    @Singleton
    fun providePanicOfficerAdapter(): PanicOfficerAdapter = PanicOfficerAdapter()

    @Provides
    @Singleton
    fun providePatrolHistoryAdapter(): PatrolHistoryAdapter = PatrolHistoryAdapter()

    @Provides
    @Singleton
    fun provideTimelineAdapter(): TimelineAdapter = TimelineAdapter()

}