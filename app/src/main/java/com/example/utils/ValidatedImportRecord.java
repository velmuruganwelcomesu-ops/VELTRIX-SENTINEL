package com.example.utils;

import com.example.data.FireExtinguisher;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FireEquipmentExcelParser.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u000eHÆ\u0003J[\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010%\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001c¨\u0006)"}, d2 = {"Lcom/example/utils/ValidatedImportRecord;", "", "rowIndex", "", "originalRow", "", "", "record", "Lcom/example/data/FireExtinguisher;", "missingSparesList", "validationStatus", "Lcom/example/utils/RecordValidationStatus;", "issueDescription", "isSelectedForImport", "", "<init>", "(ILjava/util/List;Lcom/example/data/FireExtinguisher;Ljava/util/List;Lcom/example/utils/RecordValidationStatus;Ljava/lang/String;Z)V", "getRowIndex", "()I", "getOriginalRow", "()Ljava/util/List;", "getRecord", "()Lcom/example/data/FireExtinguisher;", "getMissingSparesList", "getValidationStatus", "()Lcom/example/utils/RecordValidationStatus;", "getIssueDescription", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final /* data */ class ValidatedImportRecord {
    public static final int $stable = 8;
    private final boolean isSelectedForImport;
    private final String issueDescription;
    private final List<String> missingSparesList;
    private final List<String> originalRow;
    private final FireExtinguisher record;
    private final int rowIndex;
    private final RecordValidationStatus validationStatus;

    public static /* synthetic */ ValidatedImportRecord copy$default(ValidatedImportRecord validatedImportRecord, int i, List list, FireExtinguisher fireExtinguisher, List list2, RecordValidationStatus recordValidationStatus, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = validatedImportRecord.rowIndex;
        }
        if ((i2 & 2) != 0) {
            list = validatedImportRecord.originalRow;
        }
        if ((i2 & 4) != 0) {
            fireExtinguisher = validatedImportRecord.record;
        }
        if ((i2 & 8) != 0) {
            list2 = validatedImportRecord.missingSparesList;
        }
        if ((i2 & 16) != 0) {
            recordValidationStatus = validatedImportRecord.validationStatus;
        }
        if ((i2 & 32) != 0) {
            str = validatedImportRecord.issueDescription;
        }
        if ((i2 & 64) != 0) {
            z = validatedImportRecord.isSelectedForImport;
        }
        String str2 = str;
        boolean z2 = z;
        RecordValidationStatus recordValidationStatus2 = recordValidationStatus;
        FireExtinguisher fireExtinguisher2 = fireExtinguisher;
        return validatedImportRecord.copy(i, list, fireExtinguisher2, list2, recordValidationStatus2, str2, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getRowIndex() {
        return this.rowIndex;
    }

    public final List<String> component2() {
        return this.originalRow;
    }

    /* renamed from: component3, reason: from getter */
    public final FireExtinguisher getRecord() {
        return this.record;
    }

    public final List<String> component4() {
        return this.missingSparesList;
    }

    /* renamed from: component5, reason: from getter */
    public final RecordValidationStatus getValidationStatus() {
        return this.validationStatus;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIssueDescription() {
        return this.issueDescription;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsSelectedForImport() {
        return this.isSelectedForImport;
    }

    public final ValidatedImportRecord copy(int rowIndex, List<String> originalRow, FireExtinguisher record, List<String> missingSparesList, RecordValidationStatus validationStatus, String issueDescription, boolean isSelectedForImport) {
        Intrinsics.checkNotNullParameter(originalRow, "originalRow");
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(missingSparesList, "missingSparesList");
        Intrinsics.checkNotNullParameter(validationStatus, "validationStatus");
        Intrinsics.checkNotNullParameter(issueDescription, "issueDescription");
        return new ValidatedImportRecord(rowIndex, originalRow, record, missingSparesList, validationStatus, issueDescription, isSelectedForImport);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ValidatedImportRecord)) {
            return false;
        }
        ValidatedImportRecord validatedImportRecord = (ValidatedImportRecord) other;
        return this.rowIndex == validatedImportRecord.rowIndex && Intrinsics.areEqual(this.originalRow, validatedImportRecord.originalRow) && Intrinsics.areEqual(this.record, validatedImportRecord.record) && Intrinsics.areEqual(this.missingSparesList, validatedImportRecord.missingSparesList) && this.validationStatus == validatedImportRecord.validationStatus && Intrinsics.areEqual(this.issueDescription, validatedImportRecord.issueDescription) && this.isSelectedForImport == validatedImportRecord.isSelectedForImport;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.rowIndex) * 31) + this.originalRow.hashCode()) * 31) + this.record.hashCode()) * 31) + this.missingSparesList.hashCode()) * 31) + this.validationStatus.hashCode()) * 31) + this.issueDescription.hashCode()) * 31) + Boolean.hashCode(this.isSelectedForImport);
    }

    public String toString() {
        return "ValidatedImportRecord(rowIndex=" + this.rowIndex + ", originalRow=" + this.originalRow + ", record=" + this.record + ", missingSparesList=" + this.missingSparesList + ", validationStatus=" + this.validationStatus + ", issueDescription=" + this.issueDescription + ", isSelectedForImport=" + this.isSelectedForImport + ")";
    }

    public ValidatedImportRecord(int rowIndex, List<String> list, FireExtinguisher record, List<String> list2, RecordValidationStatus validationStatus, String issueDescription, boolean isSelectedForImport) {
        Intrinsics.checkNotNullParameter(list, "originalRow");
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(list2, "missingSparesList");
        Intrinsics.checkNotNullParameter(validationStatus, "validationStatus");
        Intrinsics.checkNotNullParameter(issueDescription, "issueDescription");
        this.rowIndex = rowIndex;
        this.originalRow = list;
        this.record = record;
        this.missingSparesList = list2;
        this.validationStatus = validationStatus;
        this.issueDescription = issueDescription;
        this.isSelectedForImport = isSelectedForImport;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ValidatedImportRecord(int r9, java.util.List r10, com.example.data.FireExtinguisher r11, java.util.List r12, com.example.utils.RecordValidationStatus r13, java.lang.String r14, boolean r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r8 = this;
            r0 = r16 & 32
            if (r0 == 0) goto L8
            java.lang.String r14 = ""
            r6 = r14
            goto L9
        L8:
            r6 = r14
        L9:
            r14 = r16 & 64
            if (r14 == 0) goto L10
            r14 = 1
            r7 = r14
            goto L11
        L10:
            r7 = r15
        L11:
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.ValidatedImportRecord.<init>(int, java.util.List, com.example.data.FireExtinguisher, java.util.List, com.example.utils.RecordValidationStatus, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getRowIndex() {
        return this.rowIndex;
    }

    public final List<String> getOriginalRow() {
        return this.originalRow;
    }

    public final FireExtinguisher getRecord() {
        return this.record;
    }

    public final List<String> getMissingSparesList() {
        return this.missingSparesList;
    }

    public final RecordValidationStatus getValidationStatus() {
        return this.validationStatus;
    }

    public final String getIssueDescription() {
        return this.issueDescription;
    }

    public final boolean isSelectedForImport() {
        return this.isSelectedForImport;
    }
}
