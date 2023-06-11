package com.kawal.malang.officer.core.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\n\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bJ6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0006J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019J*\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010H\u0007J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006J \u0010!\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\u0004J2\u0010$\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000e0\'\u00a8\u0006)"}, d2 = {"Lcom/kawal/malang/officer/core/util/AppUtil;", "", "()V", "checkLocationPermission", "", "context", "Landroid/content/Context;", "convertDateTime", "", "dateTime", "convertToTime", "errorMessage", "errorBody", "getLastLocation", "", "loc", "Lkotlin/Function2;", "", "askPermission", "Lkotlin/Function0;", "isLocationEnabled", "isNetworkAvailable", "loading", "Landroid/app/Dialog;", "reportStatus", "Ljava/util/ArrayList;", "requestNewLocationData", "requestPermissions", "activity", "Landroid/app/Activity;", "reverseGeocode", "lat", "lng", "snackBar", "message", "isError", "snackBarAction", "action", "listener", "Lkotlin/Function1;", "Landroid/view/View;", "app_appCenterDebug"})
public final class AppUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.kawal.malang.officer.core.util.AppUtil INSTANCE = null;
    
    private AppUtil() {
        super();
    }
    
    public final boolean isNetworkAvailable(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String errorMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String errorBody) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String convertDateTime(@org.jetbrains.annotations.Nullable()
    java.lang.String dateTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String convertToTime(@org.jetbrains.annotations.Nullable()
    java.lang.String dateTime) {
        return null;
    }
    
    private final boolean checkLocationPermission(android.content.Context context) {
        return false;
    }
    
    public final void requestPermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    public final void getLastLocation(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Double, ? super java.lang.Double, kotlin.Unit> loc, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> askPermission) {
    }
    
    private final boolean isLocationEnabled(android.content.Context context) {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void requestNewLocationData(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Double, ? super java.lang.Double, kotlin.Unit> loc) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> reportStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Dialog loading(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final void snackBar(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String message, boolean isError) {
    }
    
    public final void snackBarAction(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> listener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reverseGeocode(double lat, double lng, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}