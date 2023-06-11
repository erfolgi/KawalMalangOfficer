package com.kawal.malang.officer.data.model.panic.report;

import java.lang.System;

@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b_\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00c9\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\r\u0012\u001c\b\u0002\u0010 \u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020!\u0018\u0001`\u001d\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010$J\u0010\u0010e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u000b\u0010f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u000b\u0010l\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u001d\u0010o\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dH\u00c6\u0003J\u0010\u0010p\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u0010\u0010q\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u00109J\u0010\u0010r\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u00109J\u001d\u0010s\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020!\u0018\u0001`\u001dH\u00c6\u0003J\u0010\u0010t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u000b\u0010u\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0010\u0010w\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u000b\u0010x\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u0010\u0010z\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u00109J\u0010\u0010{\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u00109J\u000b\u0010|\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u00d2\u0002\u0010}\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\r2\u001c\b\u0002\u0010 \u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020!\u0018\u0001`\u001d2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001\u00a2\u0006\u0002\u0010~J\t\u0010\u007f\u001a\u00020\u0003H\u00d6\u0001J\u0017\u0010\u0080\u0001\u001a\u00030\u0081\u00012\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u00d6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0003H\u00d6\u0001J\n\u0010\u0085\u0001\u001a\u00020\u000bH\u00d6\u0001J\u001e\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u0003H\u00d6\u0001R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010-\u001a\u0004\b2\u0010*\"\u0004\b3\u0010,R \u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010\u001e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R \u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u00105\"\u0004\b>\u00107R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010-\u001a\u0004\b?\u0010*\"\u0004\b@\u0010,R \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u00105\"\u0004\bB\u00107R\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010<\u001a\u0004\bC\u00109\"\u0004\bD\u0010;R\"\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010<\u001a\u0004\bE\u00109\"\u0004\bF\u0010;R \u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u00105\"\u0004\bH\u00107R \u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u00105\"\u0004\bJ\u00107R \u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u00105\"\u0004\bL\u00107R2\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR \u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u00105\"\u0004\bR\u00107R\"\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010-\u001a\u0004\bS\u0010*\"\u0004\bT\u0010,R \u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u00105\"\u0004\bV\u00107R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010-\u001a\u0004\b[\u0010*\"\u0004\b\\\u0010,R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u00105\"\u0004\b^\u00107R\"\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010<\u001a\u0004\b_\u00109\"\u0004\b`\u0010;R2\u0010 \u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020!\u0018\u0001`\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010N\"\u0004\bb\u0010PR \u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u00105\"\u0004\bd\u00107\u00a8\u0006\u008b\u0001"}, d2 = {"Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;", "Landroid/os/Parcelable;", "id", "", "reporterId", "reporter", "Lcom/kawal/malang/officer/data/model/panic/report/ReporterData;", "categoryId", "category", "Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;", "status", "", "latitude", "", "longitude", "photo", "information", "note", "eventDescription", "officerReport", "officerPhoto", "carFinisherId", "carFinisher", "Lcom/kawal/malang/officer/data/model/auth/CarData;", "createdAt", "updatedAt", "panicCar", "Ljava/util/ArrayList;", "Lcom/kawal/malang/officer/data/model/panic/report/PanicCarData;", "Lkotlin/collections/ArrayList;", "distance", "time", "timeline", "Lcom/kawal/malang/officer/data/model/panic/report/TimelineData;", "rating", "ratingDesc", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kawal/malang/officer/data/model/panic/report/ReporterData;Ljava/lang/Integer;Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/kawal/malang/officer/data/model/auth/CarData;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/String;)V", "getCarFinisher", "()Lcom/kawal/malang/officer/data/model/auth/CarData;", "setCarFinisher", "(Lcom/kawal/malang/officer/data/model/auth/CarData;)V", "getCarFinisherId", "()Ljava/lang/Integer;", "setCarFinisherId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCategory", "()Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;", "setCategory", "(Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;)V", "getCategoryId", "setCategoryId", "getCreatedAt", "()Ljava/lang/String;", "setCreatedAt", "(Ljava/lang/String;)V", "getDistance", "()Ljava/lang/Double;", "setDistance", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getEventDescription", "setEventDescription", "getId", "setId", "getInformation", "setInformation", "getLatitude", "setLatitude", "getLongitude", "setLongitude", "getNote", "setNote", "getOfficerPhoto", "setOfficerPhoto", "getOfficerReport", "setOfficerReport", "getPanicCar", "()Ljava/util/ArrayList;", "setPanicCar", "(Ljava/util/ArrayList;)V", "getPhoto", "setPhoto", "getRating", "setRating", "getRatingDesc", "setRatingDesc", "getReporter", "()Lcom/kawal/malang/officer/data/model/panic/report/ReporterData;", "setReporter", "(Lcom/kawal/malang/officer/data/model/panic/report/ReporterData;)V", "getReporterId", "setReporterId", "getStatus", "setStatus", "getTime", "setTime", "getTimeline", "setTimeline", "getUpdatedAt", "setUpdatedAt", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kawal/malang/officer/data/model/panic/report/ReporterData;Ljava/lang/Integer;Lcom/kawal/malang/officer/data/model/panic/report/CategoryData;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/kawal/malang/officer/data/model/auth/CarData;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/String;)Lcom/kawal/malang/officer/data/model/panic/report/PanicReportData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_appCenterDebug"})
public final class PanicReportData implements android.os.Parcelable {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "id")
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "pelapor_id")
    private java.lang.Integer reporterId;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "pelapor")
    private com.kawal.malang.officer.data.model.panic.report.ReporterData reporter;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "kategori_id")
    private java.lang.Integer categoryId;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "kategori")
    private com.kawal.malang.officer.data.model.panic.report.CategoryData category;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "status")
    private java.lang.String status;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "latitude")
    private java.lang.Double latitude;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "longitude")
    private java.lang.Double longitude;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "foto")
    private java.lang.String photo;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "keterangan")
    private java.lang.String information;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "catatan")
    private java.lang.String note;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "deskripsi_kejadian")
    private java.lang.String eventDescription;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "laporan_petugas")
    private java.lang.String officerReport;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "foto_petugas")
    private java.lang.String officerPhoto;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "mobil_penyelesai_id")
    private java.lang.Integer carFinisherId;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "mobil_penyelesai")
    private com.kawal.malang.officer.data.model.auth.CarData carFinisher;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "created_at")
    private java.lang.String createdAt;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "updated_at")
    private java.lang.String updatedAt;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "mobil_panic")
    private java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicCarData> panicCar;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "distance")
    private java.lang.Double distance;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "waktu")
    private java.lang.Double time;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "timeline")
    private java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.TimelineData> timeline;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "rating")
    private java.lang.Integer rating;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "keterangan_rating")
    private java.lang.String ratingDesc;
    public static final android.os.Parcelable.Creator<com.kawal.malang.officer.data.model.panic.report.PanicReportData> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.kawal.malang.officer.data.model.panic.report.PanicReportData copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.Integer reporterId, @org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.panic.report.ReporterData reporter, @org.jetbrains.annotations.Nullable()
    java.lang.Integer categoryId, @org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.panic.report.CategoryData category, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.Double latitude, @org.jetbrains.annotations.Nullable()
    java.lang.Double longitude, @org.jetbrains.annotations.Nullable()
    java.lang.String photo, @org.jetbrains.annotations.Nullable()
    java.lang.String information, @org.jetbrains.annotations.Nullable()
    java.lang.String note, @org.jetbrains.annotations.Nullable()
    java.lang.String eventDescription, @org.jetbrains.annotations.Nullable()
    java.lang.String officerReport, @org.jetbrains.annotations.Nullable()
    java.lang.String officerPhoto, @org.jetbrains.annotations.Nullable()
    java.lang.Integer carFinisherId, @org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.auth.CarData carFinisher, @org.jetbrains.annotations.Nullable()
    java.lang.String createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedAt, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicCarData> panicCar, @org.jetbrains.annotations.Nullable()
    java.lang.Double distance, @org.jetbrains.annotations.Nullable()
    java.lang.Double time, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.TimelineData> timeline, @org.jetbrains.annotations.Nullable()
    java.lang.Integer rating, @org.jetbrains.annotations.Nullable()
    java.lang.String ratingDesc) {
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
    
    public PanicReportData() {
        super();
    }
    
    public PanicReportData(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.Integer reporterId, @org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.panic.report.ReporterData reporter, @org.jetbrains.annotations.Nullable()
    java.lang.Integer categoryId, @org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.panic.report.CategoryData category, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.Double latitude, @org.jetbrains.annotations.Nullable()
    java.lang.Double longitude, @org.jetbrains.annotations.Nullable()
    java.lang.String photo, @org.jetbrains.annotations.Nullable()
    java.lang.String information, @org.jetbrains.annotations.Nullable()
    java.lang.String note, @org.jetbrains.annotations.Nullable()
    java.lang.String eventDescription, @org.jetbrains.annotations.Nullable()
    java.lang.String officerReport, @org.jetbrains.annotations.Nullable()
    java.lang.String officerPhoto, @org.jetbrains.annotations.Nullable()
    java.lang.Integer carFinisherId, @org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.auth.CarData carFinisher, @org.jetbrains.annotations.Nullable()
    java.lang.String createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedAt, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicCarData> panicCar, @org.jetbrains.annotations.Nullable()
    java.lang.Double distance, @org.jetbrains.annotations.Nullable()
    java.lang.Double time, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.TimelineData> timeline, @org.jetbrains.annotations.Nullable()
    java.lang.Integer rating, @org.jetbrains.annotations.Nullable()
    java.lang.String ratingDesc) {
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
    public final java.lang.Integer getReporterId() {
        return null;
    }
    
    public final void setReporterId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.kawal.malang.officer.data.model.panic.report.ReporterData component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.kawal.malang.officer.data.model.panic.report.ReporterData getReporter() {
        return null;
    }
    
    public final void setReporter(@org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.panic.report.ReporterData p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCategoryId() {
        return null;
    }
    
    public final void setCategoryId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.kawal.malang.officer.data.model.panic.report.CategoryData component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.kawal.malang.officer.data.model.panic.report.CategoryData getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.panic.report.CategoryData p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
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
    public final java.lang.Double component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getLatitude() {
        return null;
    }
    
    public final void setLatitude(@org.jetbrains.annotations.Nullable()
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getLongitude() {
        return null;
    }
    
    public final void setLongitude(@org.jetbrains.annotations.Nullable()
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPhoto() {
        return null;
    }
    
    public final void setPhoto(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getInformation() {
        return null;
    }
    
    public final void setInformation(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNote() {
        return null;
    }
    
    public final void setNote(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEventDescription() {
        return null;
    }
    
    public final void setEventDescription(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOfficerReport() {
        return null;
    }
    
    public final void setOfficerReport(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOfficerPhoto() {
        return null;
    }
    
    public final void setOfficerPhoto(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCarFinisherId() {
        return null;
    }
    
    public final void setCarFinisherId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.kawal.malang.officer.data.model.auth.CarData component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.kawal.malang.officer.data.model.auth.CarData getCarFinisher() {
        return null;
    }
    
    public final void setCarFinisher(@org.jetbrains.annotations.Nullable()
    com.kawal.malang.officer.data.model.auth.CarData p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
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
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUpdatedAt() {
        return null;
    }
    
    public final void setUpdatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicCarData> component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicCarData> getPanicCar() {
        return null;
    }
    
    public final void setPanicCar(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.PanicCarData> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getDistance() {
        return null;
    }
    
    public final void setDistance(@org.jetbrains.annotations.Nullable()
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getTime() {
        return null;
    }
    
    public final void setTime(@org.jetbrains.annotations.Nullable()
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.TimelineData> component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.TimelineData> getTimeline() {
        return null;
    }
    
    public final void setTimeline(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.kawal.malang.officer.data.model.panic.report.TimelineData> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRating() {
        return null;
    }
    
    public final void setRating(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRatingDesc() {
        return null;
    }
    
    public final void setRatingDesc(@org.jetbrains.annotations.Nullable()
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
    public static final class Creator implements android.os.Parcelable.Creator<com.kawal.malang.officer.data.model.panic.report.PanicReportData> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.kawal.malang.officer.data.model.panic.report.PanicReportData createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.kawal.malang.officer.data.model.panic.report.PanicReportData[] newArray(int size) {
            return null;
        }
    }
}