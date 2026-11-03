package com.example.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FireEquipmentExcelParser.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0005HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/example/utils/ParsedExcelSheet;", "", "fileName", "", "headers", "", "rows", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getFileName", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/List;", "getRows", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final /* data */ class ParsedExcelSheet {
    public static final int $stable = 8;
    private final String fileName;
    private final List<String> headers;
    private final List<List<String>> rows;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParsedExcelSheet copy$default(ParsedExcelSheet parsedExcelSheet, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parsedExcelSheet.fileName;
        }
        if ((i & 2) != 0) {
            list = parsedExcelSheet.headers;
        }
        if ((i & 4) != 0) {
            list2 = parsedExcelSheet.rows;
        }
        return parsedExcelSheet.copy(str, list, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    public final List<String> component2() {
        return this.headers;
    }

    public final List<List<String>> component3() {
        return this.rows;
    }

    public final ParsedExcelSheet copy(String fileName, List<String> headers, List<? extends List<String>> rows) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(rows, "rows");
        return new ParsedExcelSheet(fileName, headers, rows);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedExcelSheet)) {
            return false;
        }
        ParsedExcelSheet parsedExcelSheet = (ParsedExcelSheet) other;
        return Intrinsics.areEqual(this.fileName, parsedExcelSheet.fileName) && Intrinsics.areEqual(this.headers, parsedExcelSheet.headers) && Intrinsics.areEqual(this.rows, parsedExcelSheet.rows);
    }

    public int hashCode() {
        return (((this.fileName.hashCode() * 31) + this.headers.hashCode()) * 31) + this.rows.hashCode();
    }

    public String toString() {
        return "ParsedExcelSheet(fileName=" + this.fileName + ", headers=" + this.headers + ", rows=" + this.rows + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ParsedExcelSheet(String fileName, List<String> list, List<? extends List<String>> list2) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(list, "headers");
        Intrinsics.checkNotNullParameter(list2, "rows");
        this.fileName = fileName;
        this.headers = list;
        this.rows = list2;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final List<String> getHeaders() {
        return this.headers;
    }

    public final List<List<String>> getRows() {
        return this.rows;
    }
}
