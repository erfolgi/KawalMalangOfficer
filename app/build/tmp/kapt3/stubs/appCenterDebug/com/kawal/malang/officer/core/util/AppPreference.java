package com.kawal.malang.officer.core.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0010J\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/kawal/malang/officer/core/util/AppPreference;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "prefs", "Landroid/content/SharedPreferences;", "deleteAuth", "", "destroyStoredSurat", "getAuth", "", "getFcmToken", "getPatrolStatus", "", "getRole", "getStoredBriefing", "Lcom/kawal/malang/officer/data/model/briefing/BriefingData;", "isOfficer", "setAuth", "input", "setFcmToken", "token", "setPatrolStatus", "status", "setRole", "loginData", "Lcom/kawal/malang/officer/data/model/auth/LoginData;", "setStoredBriefing", "app_appCenterDebug"})
public final class AppPreference {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private android.content.SharedPreferences prefs;
    
    public AppPreference(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setAuth(@org.jetbrains.annotations.NotNull()
    java.lang.String input) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuth() {
        return null;
    }
    
    public final void deleteAuth() {
    }
    
    public final void setRole(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.data.model.auth.LoginData loginData) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRole() {
        return null;
    }
    
    public final boolean isOfficer() {
        return false;
    }
    
    public final void setPatrolStatus(boolean status) {
    }
    
    public final boolean getPatrolStatus() {
        return false;
    }
    
    public final void setFcmToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFcmToken() {
        return null;
    }
    
    public final void setStoredBriefing(@org.jetbrains.annotations.NotNull()
    com.kawal.malang.officer.data.model.briefing.BriefingData input) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.data.model.briefing.BriefingData getStoredBriefing() {
        return null;
    }
    
    private final void destroyStoredSurat() {
    }
}