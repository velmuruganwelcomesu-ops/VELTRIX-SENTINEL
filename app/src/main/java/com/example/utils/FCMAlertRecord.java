package com.example.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafetyFCMManager.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jm\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006-"}, d2 = {"Lcom/example/utils/FCMAlertRecord;", "", "id", "", "title", "body", "type", "recipient", "sncNumber", "severity", "timestamp", "", "timeFormatted", "deliveryStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getBody", "getType", "getRecipient", "getSncNumber", "getSeverity", "getTimestamp", "()J", "getTimeFormatted", "getDeliveryStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final /* data */ class FCMAlertRecord {
    public static final int $stable = 0;
    private final String body;
    private final String deliveryStatus;
    private final String id;
    private final String recipient;
    private final String severity;
    private final String sncNumber;
    private final String timeFormatted;
    private final long timestamp;
    private final String title;
    private final String type;

    public static /* synthetic */ FCMAlertRecord copy$default(FCMAlertRecord fCMAlertRecord, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, String str8, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fCMAlertRecord.id;
        }
        if ((i & 2) != 0) {
            str2 = fCMAlertRecord.title;
        }
        if ((i & 4) != 0) {
            str3 = fCMAlertRecord.body;
        }
        if ((i & 8) != 0) {
            str4 = fCMAlertRecord.type;
        }
        if ((i & 16) != 0) {
            str5 = fCMAlertRecord.recipient;
        }
        if ((i & 32) != 0) {
            str6 = fCMAlertRecord.sncNumber;
        }
        if ((i & 64) != 0) {
            str7 = fCMAlertRecord.severity;
        }
        if ((i & 128) != 0) {
            j = fCMAlertRecord.timestamp;
        }
        if ((i & 256) != 0) {
            str8 = fCMAlertRecord.timeFormatted;
        }
        if ((i & 512) != 0) {
            str9 = fCMAlertRecord.deliveryStatus;
        }
        long j2 = j;
        String str10 = str6;
        String str11 = str7;
        String str12 = str4;
        String str13 = str5;
        String str14 = str3;
        return fCMAlertRecord.copy(str, str2, str14, str12, str13, str10, str11, j2, str8, str9);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDeliveryStatus() {
        return this.deliveryStatus;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    /* renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final String getRecipient() {
        return this.recipient;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSncNumber() {
        return this.sncNumber;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSeverity() {
        return this.severity;
    }

    /* renamed from: component8, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTimeFormatted() {
        return this.timeFormatted;
    }

    public final FCMAlertRecord copy(String id, String title, String body, String type, String recipient, String sncNumber, String severity, long timestamp, String timeFormatted, String deliveryStatus) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(recipient, "recipient");
        Intrinsics.checkNotNullParameter(sncNumber, "sncNumber");
        Intrinsics.checkNotNullParameter(severity, "severity");
        Intrinsics.checkNotNullParameter(timeFormatted, "timeFormatted");
        Intrinsics.checkNotNullParameter(deliveryStatus, "deliveryStatus");
        return new FCMAlertRecord(id, title, body, type, recipient, sncNumber, severity, timestamp, timeFormatted, deliveryStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FCMAlertRecord)) {
            return false;
        }
        FCMAlertRecord fCMAlertRecord = (FCMAlertRecord) other;
        return Intrinsics.areEqual(this.id, fCMAlertRecord.id) && Intrinsics.areEqual(this.title, fCMAlertRecord.title) && Intrinsics.areEqual(this.body, fCMAlertRecord.body) && Intrinsics.areEqual(this.type, fCMAlertRecord.type) && Intrinsics.areEqual(this.recipient, fCMAlertRecord.recipient) && Intrinsics.areEqual(this.sncNumber, fCMAlertRecord.sncNumber) && Intrinsics.areEqual(this.severity, fCMAlertRecord.severity) && this.timestamp == fCMAlertRecord.timestamp && Intrinsics.areEqual(this.timeFormatted, fCMAlertRecord.timeFormatted) && Intrinsics.areEqual(this.deliveryStatus, fCMAlertRecord.deliveryStatus);
    }

    public int hashCode() {
        return (((((((((((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.body.hashCode()) * 31) + this.type.hashCode()) * 31) + this.recipient.hashCode()) * 31) + this.sncNumber.hashCode()) * 31) + this.severity.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + this.timeFormatted.hashCode()) * 31) + this.deliveryStatus.hashCode();
    }

    public String toString() {
        return "FCMAlertRecord(id=" + this.id + ", title=" + this.title + ", body=" + this.body + ", type=" + this.type + ", recipient=" + this.recipient + ", sncNumber=" + this.sncNumber + ", severity=" + this.severity + ", timestamp=" + this.timestamp + ", timeFormatted=" + this.timeFormatted + ", deliveryStatus=" + this.deliveryStatus + ")";
    }

    public FCMAlertRecord(String id, String title, String body, String type, String recipient, String sncNumber, String severity, long timestamp, String timeFormatted, String deliveryStatus) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(recipient, "recipient");
        Intrinsics.checkNotNullParameter(sncNumber, "sncNumber");
        Intrinsics.checkNotNullParameter(severity, "severity");
        Intrinsics.checkNotNullParameter(timeFormatted, "timeFormatted");
        Intrinsics.checkNotNullParameter(deliveryStatus, "deliveryStatus");
        this.id = id;
        this.title = title;
        this.body = body;
        this.type = type;
        this.recipient = recipient;
        this.sncNumber = sncNumber;
        this.severity = severity;
        this.timestamp = timestamp;
        this.timeFormatted = timeFormatted;
        this.deliveryStatus = deliveryStatus;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ FCMAlertRecord(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, long r10, java.lang.String r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r2 = this;
            r15 = r14 & 1
            if (r15 == 0) goto Lc
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = java.lang.String.valueOf(r0)
        Lc:
            r15 = r14 & 128(0x80, float:1.8E-43)
            if (r15 == 0) goto L14
            long r10 = java.lang.System.currentTimeMillis()
        L14:
            r15 = r14 & 256(0x100, float:3.59E-43)
            if (r15 == 0) goto L31
            java.text.SimpleDateFormat r12 = new java.text.SimpleDateFormat
            java.lang.String r15 = "dd MMM yyyy, HH:mm:ss"
            java.util.Locale r0 = java.util.Locale.getDefault()
            r12.<init>(r15, r0)
            java.util.Date r15 = new java.util.Date
            r15.<init>()
            java.lang.String r12 = r12.format(r15)
            java.lang.String r15 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
        L31:
            r14 = r14 & 512(0x200, float:7.17E-43)
            if (r14 == 0) goto L39
            java.lang.String r13 = "DELIVERED_FCM"
            r15 = r13
            goto L3a
        L39:
            r15 = r13
        L3a:
            r14 = r12
            r12 = r10
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.FCMAlertRecord.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getType() {
        return this.type;
    }

    public final String getRecipient() {
        return this.recipient;
    }

    public final String getSncNumber() {
        return this.sncNumber;
    }

    public final String getSeverity() {
        return this.severity;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTimeFormatted() {
        return this.timeFormatted;
    }

    public final String getDeliveryStatus() {
        return this.deliveryStatus;
    }
}
