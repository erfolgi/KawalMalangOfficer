package com.kawal.malang.officer.presentation.viewmodels.briefing;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001fJ.\u0010%\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020\u001f2\b\b\u0002\u0010\'\u001a\u00020\u001f2\b\b\u0002\u0010(\u001a\u00020\u001f2\b\b\u0002\u0010)\u001a\u00020\u001fJ\u0006\u0010*\u001a\u00020\u001cJ\u0006\u0010+\u001a\u00020\u001cJ\u000e\u0010,\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001fJ \u0010-\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010\'\u001a\u00020\u001f2\b\b\u0002\u0010.\u001a\u00020\u001fJ\u0006\u0010/\u001a\u00020\u001cJ.\u00100\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001f2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R-\u0010\u0007\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR-\u0010\u000f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\nj\b\u0012\u0004\u0012\u00020\u0010`\f0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR-\u0010\u0014\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR#\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00170\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/kawal/malang/officer/presentation/viewmodels/briefing/BriefingViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "useCase", "Lcom/kawal/malang/officer/domain/usecase/briefing/BriefingUseCase;", "(Landroid/app/Application;Lcom/kawal/malang/officer/domain/usecase/briefing/BriefingUseCase;)V", "briefingData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/kawal/malang/officer/core/util/Resource;", "Ljava/util/ArrayList;", "Lcom/kawal/malang/officer/data/model/briefing/BriefingData;", "Lkotlin/collections/ArrayList;", "getBriefingData", "()Landroidx/lifecycle/MutableLiveData;", "categories", "Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;", "getCategories", "detail", "getDetail", "paginate", "getPaginate", "postData", "Lcom/kawal/malang/officer/data/model/BaseResponse;", "getPostData", "pref", "Lcom/kawal/malang/officer/core/util/AppPreference;", "createBriefing", "Lkotlinx/coroutines/Job;", "body", "", "", "Lokhttp3/RequestBody;", "file", "Ljava/io/File;", "deleteBriefing", "id", "filterBriefingList", "lastId", "category", "tanggal", "judul", "getBriefingCategory", "getBriefingList", "getDetailBriefing", "paginateBriefingList", "title", "refreshBriefingList", "updateBriefing", "app_appCenterDebug"})
public final class BriefingViewModel extends androidx.lifecycle.AndroidViewModel {
    private final android.app.Application app = null;
    private final com.kawal.malang.officer.domain.usecase.briefing.BriefingUseCase useCase = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.briefing.BriefingData>>> briefingData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData>>> categories = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.briefing.BriefingData>>> paginate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.briefing.BriefingData>>> postData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.briefing.BriefingData>> detail = null;
    private final com.kawal.malang.officer.core.util.AppPreference pref = null;
    
    public BriefingViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.usecase.briefing.BriefingUseCase useCase) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.briefing.BriefingData>>> getBriefingData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData>>> getCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.briefing.BriefingData>>> getPaginate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.briefing.BriefingData>>> getPostData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.briefing.BriefingData>> getDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getBriefingCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job filterBriefingList(@org.jetbrains.annotations.NotNull()
    java.lang.String lastId, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String tanggal, @org.jetbrains.annotations.NotNull()
    java.lang.String judul) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getBriefingList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getDetailBriefing(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job refreshBriefingList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job paginateBriefingList(@org.jetbrains.annotations.NotNull()
    java.lang.String lastId, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job createBriefing(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends okhttp3.RequestBody> body, @org.jetbrains.annotations.NotNull()
    java.io.File file) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateBriefing(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends okhttp3.RequestBody> body, @org.jetbrains.annotations.Nullable()
    java.io.File file) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteBriefing(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
}