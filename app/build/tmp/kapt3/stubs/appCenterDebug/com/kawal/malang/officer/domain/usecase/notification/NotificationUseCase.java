package com.kawal.malang.officer.domain.usecase.notification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J7\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/kawal/malang/officer/domain/usecase/notification/NotificationUseCase;", "", "repository", "Lcom/kawal/malang/officer/domain/repository/AppRepository;", "(Lcom/kawal/malang/officer/domain/repository/AppRepository;)V", "execGetNotification", "Lcom/kawal/malang/officer/core/util/Resource;", "Ljava/util/ArrayList;", "Lcom/kawal/malang/officer/data/model/notification/NotificationData;", "Lkotlin/collections/ArrayList;", "token", "", "lastId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_appCenterDebug"})
public final class NotificationUseCase {
    private final com.kawal.malang.officer.domain.repository.AppRepository repository = null;
    
    public NotificationUseCase(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.domain.repository.AppRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object execGetNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String lastId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kawal.malang.officer.core.util.Resource<java.util.ArrayList<com.kawal.malang.officer.data.model.notification.NotificationData>>> continuation) {
        return null;
    }
}