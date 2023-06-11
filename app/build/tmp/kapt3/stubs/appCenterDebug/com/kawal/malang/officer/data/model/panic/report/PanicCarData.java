package com.kawal.malang.officer.data.model.panic.report;

import java.lang.System;

@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u0011J\u0010\u00101\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u000b\u00102\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u000b\u00104\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u000b\u00106\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u000b\u00108\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u0086\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001\u00a2\u0006\u0002\u0010<J\t\u0010=\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u00d6\u0003J\t\u0010B\u001a\u00020\u0003H\u00d6\u0001J\t\u0010C\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0003H\u00d6\u0001R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\"\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR \u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001e\u00a8\u0006I"}, d2 = {"Lcom/kawal/malang/officer/data/model/panic/report/PanicCarData;", "Landroid/os/Parcelable;", "id", "", "panicId", "panic", "Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;", "carId", "car", "Lcom/kawal/malang/officer/data/model/auth/CarData;", "patrolId", "patrol", "Lcom/kawal/malang/officer/data/model/panic/report/PatrolData;", "status", "", "createdAt", "updatedAt", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;Ljava/lang/Integer;Lcom/kawal/malang/officer/data/model/auth/CarData;Ljava/lang/Integer;Lcom/kawal/malang/officer/data/model/panic/report/PatrolData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCar", "()Lcom/kawal/malang/officer/data/model/auth/CarData;", "setCar", "(Lcom/kawal/malang/officer/data/model/auth/CarData;)V", "getCarId", "()Ljava/lang/Integer;", "setCarId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCreatedAt", "()Ljava/lang/String;", "setCreatedAt", "(Ljava/lang/String;)V", "getId", "setId", "getPanic", "()Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;", "setPanic", "(Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;)V", "getPanicId", "setPanicId", "getPatrol", "()Lcom/kawal/malang/officer/data/model/panic/report/PatrolData;", "setPatrol", "(Lcom/kawal/malang/officer/data/model/panic/report/PatrolData;)V", "getPatrolId", "setPatrolId", "getStatus", "setStatus", "getUpdatedAt", "setUpdatedAt", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;Ljava/lang/Integer;Lcom/kawal/malang/officer/data/model/auth/CarData;Ljava/lang/Integer;Lcom/kawal/malang/officer/data/model/panic/report/PatrolData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/kawal/malang/officer/data/model/panic/report/PanicCarData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_appCenterDebug"})
public final class PanicCarData implements android.os.Parcelable {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "id")
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "panic_id")
    private java.lang.Integer panicId;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "panic")
    private com.kawal.malang.officer.data.model.panic.report.PanicReportData panic;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "mobil_id")
    private java.lang.Integer carId;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "mobil")
    private com.kawal.malang.officer.data.model.auth.CarData car;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "patroli_id")
    private java.lang.Integer patrolId;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "patroli")
    private com.kawal.malang.officer.data.model.panic.report.PatrolData patrol;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "status")
    private java.lang.String status;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "created_at")
    private java.lang.String createdAt;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "updated_at")
    private java.lang.String updatedAt;
    public static final android.os.Parcelable.Creator<com.kawal.malang.officer.data.model.panic.report.PanicCarData> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.data.model.panic.report.PanicCarData copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.Integer panicId, @org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.panic.report.PanicReportData panic, @org.jetbrains.annotations.Nullable()
    java.lang.Integer carId, @org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.auth.CarData car, @org.jetbrains.annotations.Nullable()
    java.lang.Integer patrolId, @org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.panic.report.PatrolData patrol, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedAt) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public PanicCarData() {
        super();
    }
    
    public PanicCarData(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.Integer panicId, @org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.panic.report.PanicReportData panic, @org.jetbrains.annotations.Nullable()
    java.lang.Integer carId, @org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.auth.CarData car, @org.jetbrains.annotations.Nullable()
    java.lang.Integer patrolId, @org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.panic.report.PatrolData patrol, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedAt) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getPanicId() {
        return null;
    }
    
    public final void setPanicId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.kawal.malang.officer.data.model.panic.report.PanicReportData component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.kawal.malang.officer.data.model.panic.report.PanicReportData getPanic() {
        return null;
    }
    
    public final void setPanic(@org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.panic.report.PanicReportData p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCarId() {
        return null;
    }
    
    public final void setCarId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.kawal.malang.officer.data.model.auth.CarData component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.kawal.malang.officer.data.model.auth.CarData getCar() {
        return null;
    }
    
    public final void setCar(@org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.auth.CarData p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getPatrolId() {
        return null;
    }
    
    public final void setPatrolId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.kawal.malang.officer.data.model.panic.report.PatrolData component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.kawal.malang.officer.data.model.panic.report.PatrolData getPatrol() {
        return null;
    }
    
    public final void setPatrol(@org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.panic.report.PatrolData p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUpdatedAt() {
        return null;
    }
    
    public final void setUpdatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.kawal.malang.officer.data.model.panic.report.PanicCarData> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.kawal.malang.officer.data.model.panic.report.PanicCarData createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.kawal.malang.officer.data.model.panic.report.PanicCarData[] newArray(int size) {
            return null;
        }
    }
}