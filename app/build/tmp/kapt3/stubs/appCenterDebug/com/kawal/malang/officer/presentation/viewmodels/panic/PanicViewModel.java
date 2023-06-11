package com.kawal.malang.officer.presentation.viewmodels.panic;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!J\u000e\u0010\u000f\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020!J\u0016\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\'J\u0016\u0010)\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\'J\u0006\u0010*\u001a\u00020\u001fJ\u0006\u0010+\u001a\u00020\u001fJ.\u0010,\u001a\u00020\u001f2\b\b\u0002\u0010-\u001a\u00020!2\b\b\u0002\u0010.\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!J\u0016\u0010/\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\'J\u000e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020!J\u0006\u00102\u001a\u00020\u001fJ\u000e\u00103\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R-\u0010\u0007\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR-\u0010\u0013\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\nj\b\u0012\u0004\u0012\u00020\u0011`\f0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR-\u0010\u0017\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\nj\b\u0012\u0004\u0012\u00020\u0011`\f0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00100\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/kawal/malang/officer/presentation/viewmodels/panic/PanicViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "useCase", "Lcom/kawal/malang/officer/domain/usecase/panic/PanicUseCase;", "(Landroid/app/Application;Lcom/kawal/malang/officer/domain/usecase/panic/PanicUseCase;)V", "categories", "Landroidx/lifecycle/MutableLiveData;", "Lcom/kawal/malang/officer/core/util/Resource;", "Ljava/util/ArrayList;", "Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;", "Lkotlin/collections/ArrayList;", "getCategories", "()Landroidx/lifecycle/MutableLiveData;", "finishPanic", "Lcom/kawal/malang/officer/data/model/BaseResponse;", "Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;", "getFinishPanic", "paginate", "getPaginate", "panicDetail", "getPanicDetail", "panicReportData", "getPanicReportData", "pref", "Lcom/kawal/malang/officer/core/util/AppPreference;", "respond", "Lcom/kawal/malang/officer/data/model/panic/report/PanicCarData;", "getRespond", "filterPanicReport", "Lkotlinx/coroutines/Job;", "category", "", "startDate", "endDate", "panicId", "getActivatedPanic", "latitude", "", "longitude", "getAroundPanic", "getPanicCategory", "getPanicReport", "paginatePanicReport", "categoryId", "lastId", "refreshAroundPanic", "refreshPanicDetail", "id", "refreshPanicReport", "respondToPanic", "app_appCenterDebug"})
public final class PanicViewModel extends androidx.lifecycle.AndroidViewModel {
    private final android.app.Application app = null;
    private final com.kawal.malang.officer.domain.usecase.panic.PanicUseCase useCase = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> panicReportData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> paginate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData>>> categories = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.panic.report.PanicReportData>> panicDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicCarData>>> respond = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> finishPanic = null;
    private final com.kawal.malang.officer.core.util.AppPreference pref = null;
    
    public PanicViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.usecase.panic.PanicUseCase useCase) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> getPanicReportData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> getPaginate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData>>> getCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.panic.report.PanicReportData>> getPanicDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicCarData>>> getRespond() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> getFinishPanic() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getPanicReport() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getAroundPanic(double latitude, double longitude) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job refreshAroundPanic(double latitude, double longitude) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getPanicCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getActivatedPanic(double latitude, double longitude) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job filterPanicReport(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String startDate, @org.jetbrains.annotations.NotNull()
    java.lang.String endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job refreshPanicReport() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job paginatePanicReport(@org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull()
    java.lang.String lastId, @org.jetbrains.annotations.NotNull()
    java.lang.String startDate, @org.jetbrains.annotations.NotNull()
    java.lang.String endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job refreshPanicDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job respondToPanic(@org.jetbrains.annotations.NotNull()
    java.lang.String panicId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job finishPanic(@org.jetbrains.annotations.NotNull()
    java.lang.String panicId) {
        return null;
    }
}