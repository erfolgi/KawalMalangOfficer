package com.kawal.malang.officer.data.repository.datasource;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ5\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ?\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0010j\b\u0012\u0004\u0012\u00020\u0005`\u00110\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ9\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u0010j\b\u0012\u0004\u0012\u00020\u0013`\u00110\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ7\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00160\u0010j\b\u0012\u0004\u0012\u00020\u0016`\u00110\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ/\u0010\u0018\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00190\u0010j\b\u0012\u0004\u0012\u00020\u0019`\u00110\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\'\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJS\u0010\u001d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0010j\b\u0012\u0004\u0012\u00020\u0005`\u00110\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ=\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00040\u00032\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070&2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(J%\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ-\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ9\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070&H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J9\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070&H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J9\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070&H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J9\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070&H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J-\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00104\u001a\u000205H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00106\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00067"}, d2 = {"Lcom/kawal/malang/officer/data/repository/datasource/RemoteDataSource;", "", "finishPanic", "Lretrofit2/Response;", "Lcom/kawal/malang/officer/data/model/BaseResponse;", "Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;", "token", "", "panicId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActivatedPanic", "latitude", "", "longitude", "(Ljava/lang/String;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAroundPanic", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMembers", "Lcom/kawal/malang/officer/data/model/auth/MemberData;", "search", "getNotification", "Lcom/kawal/malang/officer/data/model/notification/NotificationData;", "lastId", "getPanicCategory", "Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPanicDetail", "id", "getPanicReport", "categoryId", "startDate", "endDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProfile", "Lcom/kawal/malang/officer/data/model/auth/LoginData;", "login", "map", "", "fcmToken", "(Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "panicRespond", "Lcom/kawal/malang/officer/data/model/panic/report/PanicCarData;", "recordCarPosition", "Lcom/kawal/malang/officer/data/model/patrol/history/LocationHistoryData;", "body", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCar", "updateMember", "updatePassword", "updatePhoto", "file", "Lokhttp3/MultipartBody$Part;", "(Ljava/lang/String;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_appCenterDebug"})
public abstract interface RemoteDataSource {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> map, @org.jetbrains.annotations.Nullable()
    java.lang.String fcmToken, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.auth.LoginData>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateCar(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updatePassword(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateMember(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updatePhoto(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPanicCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPanicReport(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull()
    java.lang.String lastId, @org.jetbrains.annotations.NotNull()
    java.lang.String startDate, @org.jetbrains.annotations.NotNull()
    java.lang.String endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAroundPanic(@org.jetbrains.annotations.NotNull()
    java.lang.String token, double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getActivatedPanic(@org.jetbrains.annotations.NotNull()
    java.lang.String token, double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPanicDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.panic.report.PanicReportData>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object panicRespond(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String panicId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicCarData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object finishPanic(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String panicId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMembers(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String search, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.auth.MemberData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object recordCarPosition(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String lastId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.notification.NotificationData>>> continuation);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}