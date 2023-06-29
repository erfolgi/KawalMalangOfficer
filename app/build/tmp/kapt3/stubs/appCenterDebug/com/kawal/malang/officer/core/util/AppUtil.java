package com.kawal.malang.officer.core.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005J6\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u001b2\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\"0$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0\'J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010)\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010*\u001a\u00020+2\u0006\u0010\u001a\u001a\u00020\u001bJ\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J*\u0010-\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u001b2\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\"0$H\u0007J\u000e\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u000200J\u001e\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u001bJ \u00104\u001a\u00020\"2\u0006\u0010/\u001a\u0002002\u0006\u00105\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u00020\u0019J2\u00107\u001a\u00020\"2\u0006\u0010/\u001a\u0002002\u0006\u00105\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00052\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\"0:J\u001c\u0010<\u001a\u00020\"*\u00020=2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010>\u001a\u0004\u0018\u00010\u0005R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e\u00a8\u0006?"}, d2 = {"Lcom/kawal/malang/officer/core/util/AppUtil;", "", "()V", "STATUS", "Ljava/util/ArrayList;", "", "getSTATUS", "()Ljava/util/ArrayList;", "setSTATUS", "(Ljava/util/ArrayList;)V", "STATUS_BARU", "getSTATUS_BARU", "()Ljava/lang/String;", "setSTATUS_BARU", "(Ljava/lang/String;)V", "STATUS_DITANGANI", "getSTATUS_DITANGANI", "setSTATUS_DITANGANI", "STATUS_DITOLAK", "getSTATUS_DITOLAK", "setSTATUS_DITOLAK", "STATUS_SELESAI", "getSTATUS_SELESAI", "setSTATUS_SELESAI", "checkLocationPermission", "", "context", "Landroid/content/Context;", "convertDateTime", "dateTime", "convertToTime", "errorMessage", "errorBody", "getLastLocation", "", "loc", "Lkotlin/Function2;", "", "askPermission", "Lkotlin/Function0;", "isLocationEnabled", "isNetworkAvailable", "loading", "Landroid/app/Dialog;", "reportStatus", "requestNewLocationData", "requestPermissions", "activity", "Landroid/app/Activity;", "reverseGeocode", "lat", "lng", "snackBar", "message", "isError", "snackBarAction", "action", "listener", "Lkotlin/Function1;", "Landroid/view/View;", "setStatus", "Landroid/widget/TextView;", "status", "app_appCenterDebug"})
public final class AppUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.kawal.malang.officer.core.util.AppUtil INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String STATUS_BARU = "baru";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String STATUS_DITANGANI = "ditangani";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String STATUS_SELESAI = "selesai";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String STATUS_DITOLAK = "ditolak";
    @org.jetbrains.annotations.NotNull()
    private static java.util.ArrayList<java.lang.String> STATUS;
    
    private AppUtil() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSTATUS_BARU() {
        return null;
    }
    
    public final void setSTATUS_BARU(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSTATUS_DITANGANI() {
        return null;
    }
    
    public final void setSTATUS_DITANGANI(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSTATUS_SELESAI() {
        return null;
    }
    
    public final void setSTATUS_SELESAI(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSTATUS_DITOLAK() {
        return null;
    }
    
    public final void setSTATUS_DITOLAK(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getSTATUS() {
        return null;
    }
    
    public final void setSTATUS(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$setStatus, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String status) {
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