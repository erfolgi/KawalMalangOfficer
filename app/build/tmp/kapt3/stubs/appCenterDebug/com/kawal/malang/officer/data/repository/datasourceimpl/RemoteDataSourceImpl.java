package com.kawal.malang.officer.data.repository.datasourceimpl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J-\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ5\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J?\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0013j\b\u0012\u0004\u0012\u00020\b`\u00140\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J7\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00160\u0013j\b\u0012\u0004\u0012\u00020\u0016`\u00140\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ7\u0010\u0018\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00190\u0013j\b\u0012\u0004\u0012\u00020\u0019`\u00140\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ/\u0010\u001b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001c0\u0013j\b\u0012\u0004\u0012\u00020\u001c`\u00140\u00062\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\'\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJO\u0010 \u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0013j\b\u0012\u0004\u0012\u00020\b`\u00140\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00062\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ;\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00070\u00062\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0)2\b\u0010*\u001a\u0004\u0018\u00010\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J%\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ-\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ9\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0)H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J9\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0)H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J9\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0)H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J9\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0)H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J-\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u00107\u001a\u000208H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00109R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006:"}, d2 = {"Lcom/kawal/malang/officer/data/repository/datasourceimpl/RemoteDataSourceImpl;", "Lcom/kawal/malang/officer/data/repository/datasource/RemoteDataSource;", "service", "Lcom/kawal/malang/officer/data/api/ApiService;", "(Lcom/kawal/malang/officer/data/api/ApiService;)V", "finishPanic", "Lretrofit2/Response;", "Lcom/kawal/malang/officer/data/model/BaseResponse;", "Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;", "token", "", "panicId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActivatedPanic", "latitude", "", "longitude", "(Ljava/lang/String;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAroundPanic", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMembers", "Lcom/kawal/malang/officer/data/model/auth/MemberData;", "search", "getNotification", "Lcom/kawal/malang/officer/data/model/notification/NotificationData;", "lastId", "getPanicCategory", "Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPanicDetail", "id", "getPanicReport", "categoryId", "startDate", "endDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProfile", "Lcom/kawal/malang/officer/data/model/auth/LoginData;", "login", "map", "", "fcmToken", "(Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "panicRespond", "Lcom/kawal/malang/officer/data/model/panic/report/PanicCarData;", "recordCarPosition", "Lcom/kawal/malang/officer/data/model/patrol/history/LocationHistoryData;", "body", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCar", "updateMember", "updatePassword", "updatePhoto", "file", "Lokhttp3/MultipartBody$Part;", "(Ljava/lang/String;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_appCenterDebug"})
public final class RemoteDataSourceImpl implements com.kawal.malang.officer.data.repository.datasource.RemoteDataSource {
    private final com.kawal.malang.officer.data.api.ApiService service = null;
    
    public RemoteDataSourceImpl(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.data.api.ApiService service) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> map, @org.jetbrains.annotations.Nullable()
    java.lang.String fcmToken, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.auth.LoginData>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updateCar(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updatePassword(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updateMember(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updatePhoto(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getPanicCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getPanicReport(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull()
    java.lang.String lastId, @org.jetbrains.annotations.NotNull()
    java.lang.String startDate, @org.jetbrains.annotations.NotNull()
    java.lang.String endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getAroundPanic(@org.jetbrains.annotations.NotNull()
    java.lang.String token, double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getActivatedPanic(@org.jetbrains.annotations.NotNull()
    java.lang.String token, double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getPanicDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.panic.report.PanicReportData>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object panicRespond(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String panicId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicCarData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object finishPanic(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String panicId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getMembers(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String search, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.auth.MemberData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object recordCarPosition(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String lastId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.notification.NotificationData>>> continuation) {
        return null;
    }
}