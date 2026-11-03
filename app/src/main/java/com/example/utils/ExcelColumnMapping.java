package com.example.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FireEquipmentExcelParser.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u00061"}, d2 = {"Lcom/example/utils/ExcelColumnMapping;", "", "feNoIndex", "", "categoryIndex", "locationIndex", "typeAndCapacityIndex", "classesOfFireUsedIndex", "refillingDateIndex", "refillDueDateIndex", "hptDateIndex", "hptDueDateIndex", "statusIndex", "remarksIndex", "missingSparesIndex", "<init>", "(IIIIIIIIIIII)V", "getFeNoIndex", "()I", "getCategoryIndex", "getLocationIndex", "getTypeAndCapacityIndex", "getClassesOfFireUsedIndex", "getRefillingDateIndex", "getRefillDueDateIndex", "getHptDateIndex", "getHptDueDateIndex", "getStatusIndex", "getRemarksIndex", "getMissingSparesIndex", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final /* data */ class ExcelColumnMapping {
    public static final int $stable = 0;
    private final int categoryIndex;
    private final int classesOfFireUsedIndex;
    private final int feNoIndex;
    private final int hptDateIndex;
    private final int hptDueDateIndex;
    private final int locationIndex;
    private final int missingSparesIndex;
    private final int refillDueDateIndex;
    private final int refillingDateIndex;
    private final int remarksIndex;
    private final int statusIndex;
    private final int typeAndCapacityIndex;

    public ExcelColumnMapping() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4095, null);
    }

    public static /* synthetic */ ExcelColumnMapping copy$default(ExcelColumnMapping excelColumnMapping, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i = excelColumnMapping.feNoIndex;
        }
        if ((i13 & 2) != 0) {
            i2 = excelColumnMapping.categoryIndex;
        }
        if ((i13 & 4) != 0) {
            i3 = excelColumnMapping.locationIndex;
        }
        if ((i13 & 8) != 0) {
            i4 = excelColumnMapping.typeAndCapacityIndex;
        }
        if ((i13 & 16) != 0) {
            i5 = excelColumnMapping.classesOfFireUsedIndex;
        }
        if ((i13 & 32) != 0) {
            i6 = excelColumnMapping.refillingDateIndex;
        }
        if ((i13 & 64) != 0) {
            i7 = excelColumnMapping.refillDueDateIndex;
        }
        if ((i13 & 128) != 0) {
            i8 = excelColumnMapping.hptDateIndex;
        }
        if ((i13 & 256) != 0) {
            i9 = excelColumnMapping.hptDueDateIndex;
        }
        if ((i13 & 512) != 0) {
            i10 = excelColumnMapping.statusIndex;
        }
        if ((i13 & 1024) != 0) {
            i11 = excelColumnMapping.remarksIndex;
        }
        if ((i13 & 2048) != 0) {
            i12 = excelColumnMapping.missingSparesIndex;
        }
        int i14 = i11;
        int i15 = i12;
        int i16 = i9;
        int i17 = i10;
        int i18 = i7;
        int i19 = i8;
        int i20 = i5;
        int i21 = i6;
        return excelColumnMapping.copy(i, i2, i3, i4, i20, i21, i18, i19, i16, i17, i14, i15);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFeNoIndex() {
        return this.feNoIndex;
    }

    /* renamed from: component10, reason: from getter */
    public final int getStatusIndex() {
        return this.statusIndex;
    }

    /* renamed from: component11, reason: from getter */
    public final int getRemarksIndex() {
        return this.remarksIndex;
    }

    /* renamed from: component12, reason: from getter */
    public final int getMissingSparesIndex() {
        return this.missingSparesIndex;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCategoryIndex() {
        return this.categoryIndex;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLocationIndex() {
        return this.locationIndex;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTypeAndCapacityIndex() {
        return this.typeAndCapacityIndex;
    }

    /* renamed from: component5, reason: from getter */
    public final int getClassesOfFireUsedIndex() {
        return this.classesOfFireUsedIndex;
    }

    /* renamed from: component6, reason: from getter */
    public final int getRefillingDateIndex() {
        return this.refillingDateIndex;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRefillDueDateIndex() {
        return this.refillDueDateIndex;
    }

    /* renamed from: component8, reason: from getter */
    public final int getHptDateIndex() {
        return this.hptDateIndex;
    }

    /* renamed from: component9, reason: from getter */
    public final int getHptDueDateIndex() {
        return this.hptDueDateIndex;
    }

    public final ExcelColumnMapping copy(int feNoIndex, int categoryIndex, int locationIndex, int typeAndCapacityIndex, int classesOfFireUsedIndex, int refillingDateIndex, int refillDueDateIndex, int hptDateIndex, int hptDueDateIndex, int statusIndex, int remarksIndex, int missingSparesIndex) {
        return new ExcelColumnMapping(feNoIndex, categoryIndex, locationIndex, typeAndCapacityIndex, classesOfFireUsedIndex, refillingDateIndex, refillDueDateIndex, hptDateIndex, hptDueDateIndex, statusIndex, remarksIndex, missingSparesIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExcelColumnMapping)) {
            return false;
        }
        ExcelColumnMapping excelColumnMapping = (ExcelColumnMapping) other;
        return this.feNoIndex == excelColumnMapping.feNoIndex && this.categoryIndex == excelColumnMapping.categoryIndex && this.locationIndex == excelColumnMapping.locationIndex && this.typeAndCapacityIndex == excelColumnMapping.typeAndCapacityIndex && this.classesOfFireUsedIndex == excelColumnMapping.classesOfFireUsedIndex && this.refillingDateIndex == excelColumnMapping.refillingDateIndex && this.refillDueDateIndex == excelColumnMapping.refillDueDateIndex && this.hptDateIndex == excelColumnMapping.hptDateIndex && this.hptDueDateIndex == excelColumnMapping.hptDueDateIndex && this.statusIndex == excelColumnMapping.statusIndex && this.remarksIndex == excelColumnMapping.remarksIndex && this.missingSparesIndex == excelColumnMapping.missingSparesIndex;
    }

    public int hashCode() {
        return (((((((((((((((((((((Integer.hashCode(this.feNoIndex) * 31) + Integer.hashCode(this.categoryIndex)) * 31) + Integer.hashCode(this.locationIndex)) * 31) + Integer.hashCode(this.typeAndCapacityIndex)) * 31) + Integer.hashCode(this.classesOfFireUsedIndex)) * 31) + Integer.hashCode(this.refillingDateIndex)) * 31) + Integer.hashCode(this.refillDueDateIndex)) * 31) + Integer.hashCode(this.hptDateIndex)) * 31) + Integer.hashCode(this.hptDueDateIndex)) * 31) + Integer.hashCode(this.statusIndex)) * 31) + Integer.hashCode(this.remarksIndex)) * 31) + Integer.hashCode(this.missingSparesIndex);
    }

    public String toString() {
        return "ExcelColumnMapping(feNoIndex=" + this.feNoIndex + ", categoryIndex=" + this.categoryIndex + ", locationIndex=" + this.locationIndex + ", typeAndCapacityIndex=" + this.typeAndCapacityIndex + ", classesOfFireUsedIndex=" + this.classesOfFireUsedIndex + ", refillingDateIndex=" + this.refillingDateIndex + ", refillDueDateIndex=" + this.refillDueDateIndex + ", hptDateIndex=" + this.hptDateIndex + ", hptDueDateIndex=" + this.hptDueDateIndex + ", statusIndex=" + this.statusIndex + ", remarksIndex=" + this.remarksIndex + ", missingSparesIndex=" + this.missingSparesIndex + ")";
    }

    public ExcelColumnMapping(int feNoIndex, int categoryIndex, int locationIndex, int typeAndCapacityIndex, int classesOfFireUsedIndex, int refillingDateIndex, int refillDueDateIndex, int hptDateIndex, int hptDueDateIndex, int statusIndex, int remarksIndex, int missingSparesIndex) {
        this.feNoIndex = feNoIndex;
        this.categoryIndex = categoryIndex;
        this.locationIndex = locationIndex;
        this.typeAndCapacityIndex = typeAndCapacityIndex;
        this.classesOfFireUsedIndex = classesOfFireUsedIndex;
        this.refillingDateIndex = refillingDateIndex;
        this.refillDueDateIndex = refillDueDateIndex;
        this.hptDateIndex = hptDateIndex;
        this.hptDueDateIndex = hptDueDateIndex;
        this.statusIndex = statusIndex;
        this.remarksIndex = remarksIndex;
        this.missingSparesIndex = missingSparesIndex;
    }

    public /* synthetic */ ExcelColumnMapping(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? -1 : i, (i13 & 2) != 0 ? -1 : i2, (i13 & 4) != 0 ? -1 : i3, (i13 & 8) != 0 ? -1 : i4, (i13 & 16) != 0 ? -1 : i5, (i13 & 32) != 0 ? -1 : i6, (i13 & 64) != 0 ? -1 : i7, (i13 & 128) != 0 ? -1 : i8, (i13 & 256) != 0 ? -1 : i9, (i13 & 512) != 0 ? -1 : i10, (i13 & 1024) != 0 ? -1 : i11, (i13 & 2048) != 0 ? -1 : i12);
    }

    public final int getFeNoIndex() {
        return this.feNoIndex;
    }

    public final int getCategoryIndex() {
        return this.categoryIndex;
    }

    public final int getLocationIndex() {
        return this.locationIndex;
    }

    public final int getTypeAndCapacityIndex() {
        return this.typeAndCapacityIndex;
    }

    public final int getClassesOfFireUsedIndex() {
        return this.classesOfFireUsedIndex;
    }

    public final int getRefillingDateIndex() {
        return this.refillingDateIndex;
    }

    public final int getRefillDueDateIndex() {
        return this.refillDueDateIndex;
    }

    public final int getHptDateIndex() {
        return this.hptDateIndex;
    }

    public final int getHptDueDateIndex() {
        return this.hptDueDateIndex;
    }

    public final int getStatusIndex() {
        return this.statusIndex;
    }

    public final int getRemarksIndex() {
        return this.remarksIndex;
    }

    public final int getMissingSparesIndex() {
        return this.missingSparesIndex;
    }
}
