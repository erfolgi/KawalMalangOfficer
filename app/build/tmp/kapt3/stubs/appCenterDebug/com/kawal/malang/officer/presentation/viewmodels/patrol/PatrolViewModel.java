package com.kawal.malang.officer.presentation.viewmodels.patrol;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010\u001d\u001a\u00020\u001a2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR-\u0010\u000e\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\u000fj\b\u0012\u0004\u0012\u00020\u000b`\u00100\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR-\u0010\u0012\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u000fj\b\u0012\u0004\u0012\u00020\u0013`\u00100\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/kawal/malang/officer/presentation/viewmodels/patrol/PatrolViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "useCase", "Lcom/kawal/malang/officer/domain/usecase/patrol/PatrolUseCase;", "(Landroid/app/Application;Lcom/kawal/malang/officer/domain/usecase/patrol/PatrolUseCase;)V", "doPatrolData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/kawal/malang/officer/core/util/Resource;", "Lcom/kawal/malang/officer/data/model/BaseResponse;", "Lcom/kawal/malang/officer/data/model/panic/report/PatrolData;", "getDoPatrolData", "()Landroidx/lifecycle/MutableLiveData;", "history", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getHistory", "members", "Lcom/kawal/malang/officer/data/model/auth/MemberData;", "getMembers", "pref", "Lcom/kawal/malang/officer/core/util/AppPreference;", "record", "Lcom/kawal/malang/officer/data/model/patrol/history/LocationHistoryData;", "getRecord", "Lkotlinx/coroutines/Job;", "search", "", "recordPosition", "body", "", "app_appCenterDebug"})
public final class PatrolViewModel extends androidx.lifecycle.AndroidViewModel {
    private final android.app.Application app = null;
    private final com.kawal.malang.officer.domain.usecase.patrol.PatrolUseCase useCase = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.auth.MemberData>>> members = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PatrolData>>> doPatrolData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PatrolData>>> history = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData>>> record = null;
    private final com.kawal.malang.officer.core.util.AppPreference pref = null;
    
    public PatrolViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.usecase.patrol.PatrolUseCase useCase) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.auth.MemberData>>> getMembers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PatrolData>>> getDoPatrolData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PatrolData>>> getHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData>>> getRecord() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getMembers(@org.jetbrains.annotations.NotNull()
    java.lang.String search) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job recordPosition(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body) {
        return null;
    }
}