package com.kawal.malang.officer.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J<\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u00062\u001c\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u000bH\u0002J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0002J(\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000bH\u0002J-\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u000bH\u0002J(\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000bH\u0002J5\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ(\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u000bH\u0002J?\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u0007j\b\u0012\u0004\u0012\u00020\u0012`\t0\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ<\u0010 \u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\u0007j\b\u0012\u0004\u0012\u00020\r`\t0\u00062\u001c\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\u0007j\b\u0012\u0004\u0012\u00020\r`\t0\u000bH\u0002J7\u0010!\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\"0\u0007j\b\u0012\u0004\u0012\u00020\"`\t0\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J<\u0010$\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\"0\u0007j\b\u0012\u0004\u0012\u00020\"`\t0\u00062\u001c\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\"0\u0007j\b\u0012\u0004\u0012\u00020\"`\t0\u000bH\u0002J7\u0010%\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020&0\u0007j\b\u0012\u0004\u0012\u00020&`\t0\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\'\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J/\u0010(\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J\'\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\u0002JO\u0010-\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u0007j\b\u0012\u0004\u0012\u00020\u0012`\t0\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00142\u0006\u0010\'\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J<\u00102\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u0007j\b\u0012\u0004\u0012\u00020\u0012`\t0\u00062\u001c\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u0007j\b\u0012\u0004\u0012\u00020\u0012`\t0\u000bH\u0002J\u001f\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J\u001c\u00105\u001a\b\u0012\u0004\u0012\u0002040\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002040\u000bH\u0002J;\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000f0\u00062\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014082\b\u00109\u001a\u0004\u0018\u00010\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J(\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000f0\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000f0\u000bH\u0002J%\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000f0\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J(\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000f0\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000f0\u000bH\u0002J<\u0010>\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020&0\u0007j\b\u0012\u0004\u0012\u00020&`\t0\u00062\u001c\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020&0\u0007j\b\u0012\u0004\u0012\u00020&`\t0\u000bH\u0002J<\u0010?\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u00062\u001c\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u000bH\u0002J-\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\u000f0\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J(\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\u000f0\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\u000f0\u000bH\u0002J<\u0010C\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u0007j\b\u0012\u0004\u0012\u00020\u0010`\t0\u00062\u001c\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u0007j\b\u0012\u0004\u0012\u00020\u0010`\t0\u000bH\u0002J(\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000f0\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000f0\u000bH\u0002J9\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\u000f0\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001408H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010HJ(\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\u000f0\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\u000f0\u000bH\u0002J(\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\u000f0\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\u000f0\u000bH\u0002J9\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000f0\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001408H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010HJ(\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000f0\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000f0\u000bH\u0002J9\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000f0\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001408H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010HJ9\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000f0\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001408H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010HJ-\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u000f0\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020RH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010SR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006T"}, d2 = {"Lcom/kawal/malang/officer/data/repository/AppRepositoryImpl;", "Lcom/kawal/malang/officer/domain/repository/AppRepository;", "remoteDataSource", "Lcom/kawal/malang/officer/data/repository/datasource/RemoteDataSource;", "(Lcom/kawal/malang/officer/data/repository/datasource/RemoteDataSource;)V", "briefingCategoryToResponse", "Lcom/kawal/malang/officer/core/util/Resource;", "Ljava/util/ArrayList;", "Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;", "Lkotlin/collections/ArrayList;", "response", "Lretrofit2/Response;", "detailBriefingToResponse", "Lcom/kawal/malang/officer/data/model/briefing/BriefingData;", "doPatrolToResponse", "Lcom/kawal/malang/officer/data/model/BaseResponse;", "Lcom/kawal/malang/officer/data/model/panic/report/PatrolData;", "finishPanic", "Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;", "token", "", "panicId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finishPanicToResponse", "finishPatrolToResponse", "getActivatedPanic", "latitude", "", "longitude", "(Ljava/lang/String;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActivatedToResponse", "getAroundPanic", "getBriefingToResponse", "getMembers", "Lcom/kawal/malang/officer/data/model/auth/MemberData;", "search", "getMembersToResponse", "getNotification", "Lcom/kawal/malang/officer/data/model/notification/NotificationData;", "lastId", "getPanicCategory", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPanicDetail", "id", "getPanicDetailToResponse", "getPanicReport", "categoryId", "startDate", "endDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPanicToResponse", "getProfile", "Lcom/kawal/malang/officer/data/model/auth/LoginData;", "getProfileToResponse", "login", "map", "", "fcmToken", "(Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginToResponse", "logout", "logoutToResponse", "notificationToResponse", "panicCategoryToResponse", "panicRespond", "Lcom/kawal/malang/officer/data/model/panic/report/PanicCarData;", "panicRespondToResponse", "patrolHistoryToResponse", "postBriefingToResponse", "recordCarLocation", "Lcom/kawal/malang/officer/data/model/patrol/history/LocationHistoryData;", "body", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordCarToResponse", "statisticToResponse", "Lcom/kawal/malang/officer/data/model/statistic/StatisticData;", "updateCar", "updateCarToResponse", "updateMember", "updatePassword", "updatePhoto", "file", "Lokhttp3/MultipartBody$Part;", "(Ljava/lang/String;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_appCenterDebug"})
public final class AppRepositoryImpl implements com.kawal.malang.officer.domain.repository.AppRepository {
    private final com.kawal.malang.officer.data.repository.datasource.RemoteDataSource remoteDataSource = null;
    
    public AppRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.data.repository.datasource.RemoteDataSource remoteDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> map, @org.jetbrains.annotations.Nullable()
    java.lang.String fcmToken, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>> loginToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>> response) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>> logoutToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>> response) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.auth.LoginData>> continuation) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.auth.LoginData> getProfileToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.auth.LoginData> response) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.statistic.StatisticData>> statisticToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.statistic.StatisticData>> response) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updateCar(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updateMember(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updatePassword(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updatePhoto(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>>> continuation) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>> updateCarToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.auth.LoginData>> response) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getPanicCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData>>> continuation) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData>> panicCategoryToResponse(retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData>> response) {
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
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getAroundPanic(@org.jetbrains.annotations.NotNull()
    java.lang.String token, double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> continuation) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData>> getPanicToResponse(retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicReportData>> response) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getPanicDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.panic.report.PanicReportData>> continuation) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.panic.report.PanicReportData> getPanicDetailToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.panic.report.PanicReportData> response) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getActivatedPanic(@org.jetbrains.annotations.NotNull()
    java.lang.String token, double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> continuation) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicReportData>> getActivatedToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicReportData>> response) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object panicRespond(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String panicId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicCarData>>> continuation) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicCarData>> panicRespondToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicCarData>> response) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object finishPanic(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String panicId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicReportData>>> continuation) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicReportData>> finishPanicToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PanicReportData>> response) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getMembers(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String search, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.auth.MemberData>>> continuation) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.auth.MemberData>> getMembersToResponse(retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.auth.MemberData>> response) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PatrolData>> patrolHistoryToResponse(retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PatrolData>> response) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PatrolData>> doPatrolToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PatrolData>> response) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PatrolData>> finishPatrolToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.panic.report.PatrolData>> response) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object recordCarLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData>>> continuation) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData>> recordCarToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData>> response) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData>> briefingCategoryToResponse(retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.CategoryData>> response) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.briefing.BriefingData>> getBriefingToResponse(retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.briefing.BriefingData>> response) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.briefing.BriefingData> detailBriefingToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.briefing.BriefingData> response) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.briefing.BriefingData>> postBriefingToResponse(retrofit2.Response<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.briefing.BriefingData>> response) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String lastId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.notification.NotificationData>>> continuation) {
        return null;
    }
    
    private final com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.notification.NotificationData>> notificationToResponse(retrofit2.Response<java.util.ArrayList<com.kawal.malang.officer.data.model.notification.NotificationData>> response) {
        return null;
    }
}