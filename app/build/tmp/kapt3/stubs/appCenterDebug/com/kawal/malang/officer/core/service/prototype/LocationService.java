package com.kawal.malang.officer.core.service.prototype;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001AB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00105\u001a\u000206H\u0003J\u0014\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u000206H\u0016J\"\u0010<\u001a\u00020\u00142\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010=\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u0014H\u0016J\b\u0010?\u001a\u000206H\u0002J\u0006\u0010@\u001a\u000206R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/kawal/malang/officer/core/service/prototype/LocationService;", "Landroid/app/Service;", "()V", "HOUR", "", "MINUTE", "SECOND", "TAG", "auth", "getAuth", "()Ljava/lang/String;", "setAuth", "(Ljava/lang/String;)V", "client", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "setClient", "(Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "id", "getId", "setId", "latitude", "", "getLatitude", "()D", "setLatitude", "(D)V", "longitude", "getLongitude", "setLongitude", "mLocationCallback", "Lcom/google/android/gms/location/LocationCallback;", "getMLocationCallback", "()Lcom/google/android/gms/location/LocationCallback;", "setMLocationCallback", "(Lcom/google/android/gms/location/LocationCallback;)V", "presenter", "Lcom/kawal/malang/officer/core/service/prototype/LocationPresenter;", "getPresenter", "()Lcom/kawal/malang/officer/core/service/prototype/LocationPresenter;", "setPresenter", "(Lcom/kawal/malang/officer/core/service/prototype/LocationPresenter;)V", "timer", "Ljava/util/Timer;", "timerTask", "Ljava/util/TimerTask;", "createNotificationChanel", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onStartCommand", "flags", "startId", "requestLocationUpdates", "startTimer", "Companion", "app_appCenterDebug"})
public final class LocationService extends android.app.Service {
    private int counter = 0;
    private double latitude = 0.0;
    private double longitude = 0.0;
    private final java.lang.String TAG = "LocationServiceX";
    private final java.lang.String SECOND = null;
    private final java.lang.String MINUTE = null;
    private final java.lang.String HOUR = null;
    private int id = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String auth = "";
    @org.jetbrains.annotations.NotNull()
    private com.kawal.malang.officer.core.service.prototype.LocationPresenter presenter;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.location.FusedLocationProviderClient client;
    @org.jetbrains.annotations.NotNull()
    public static final com.kawal.malang.officer.core.service.prototype.LocationService.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String STARTFOREGROUND_ACTION = "com.kawal.malang.officer.core.service.start";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String STOPFOREGROUND_ACTION = "com.kawal.malang.officer.core.service.stop";
    private java.util.Timer timer;
    private java.util.TimerTask timerTask;
    @org.jetbrains.annotations.NotNull()
    private com.google.android.gms.location.LocationCallback mLocationCallback;
    
    public LocationService() {
        super();
    }
    
    public final int getCounter() {
        return 0;
    }
    
    public final void setCounter(int p0) {
    }
    
    public final double getLatitude() {
        return 0.0;
    }
    
    public final void setLatitude(double p0) {
    }
    
    public final double getLongitude() {
        return 0.0;
    }
    
    public final void setLongitude(double p0) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuth() {
        return null;
    }
    
    public final void setAuth(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.core.service.prototype.LocationPresenter getPresenter() {
        return null;
    }
    
    public final void setPresenter(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.core.service.prototype.LocationPresenter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.location.FusedLocationProviderClient getClient() {
        return null;
    }
    
    public final void setClient(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.location.FusedLocationProviderClient p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void createNotificationChanel() {
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    public final void startTimer() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return null;
    }
    
    private final void requestLocationUpdates() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.location.LocationCallback getMLocationCallback() {
        return null;
    }
    
    public final void setMLocationCallback(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.LocationCallback p0) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/kawal/malang/officer/core/service/prototype/LocationService$Companion;", "", "()V", "STARTFOREGROUND_ACTION", "", "getSTARTFOREGROUND_ACTION", "()Ljava/lang/String;", "setSTARTFOREGROUND_ACTION", "(Ljava/lang/String;)V", "STOPFOREGROUND_ACTION", "getSTOPFOREGROUND_ACTION", "setSTOPFOREGROUND_ACTION", "app_appCenterDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSTARTFOREGROUND_ACTION() {
            return null;
        }
        
        public final void setSTARTFOREGROUND_ACTION(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSTOPFOREGROUND_ACTION() {
            return null;
        }
        
        public final void setSTOPFOREGROUND_ACTION(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
    }
}