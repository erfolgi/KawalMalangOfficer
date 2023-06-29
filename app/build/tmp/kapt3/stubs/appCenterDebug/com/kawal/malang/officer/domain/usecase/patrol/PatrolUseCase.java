package com.kawal.malang.officer.domain.usecase.patrol;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J9\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ9\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/kawal/malang/officer/domain/usecase/patrol/PatrolUseCase;", "", "repository", "Lcom/kawal/malang/officer/domain/repository/AppRepository;", "(Lcom/kawal/malang/officer/domain/repository/AppRepository;)V", "execGetMembers", "Lcom/kawal/malang/officer/core/util/Resource;", "Ljava/util/ArrayList;", "Lcom/kawal/malang/officer/data/model/auth/MemberData;", "Lkotlin/collections/ArrayList;", "token", "", "search", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execRecordPosition", "Lcom/kawal/malang/officer/data/model/BaseResponse;", "Lcom/kawal/malang/officer/data/model/patrol/history/LocationHistoryData;", "body", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_appCenterDebug"})
public final class PatrolUseCase {
    private final com.kawal.malang.officer.domain.repository.AppRepository repository = null;
    
    public PatrolUseCase(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.repository.AppRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object execGetMembers(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String search, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.auth.MemberData>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object execRecordPosition(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<com.kawal.malang.officer.data.model.BaseResponse<com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData>>> continuation) {
        return null;
    }
}