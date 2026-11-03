package com.example.utils;

import androidx.compose.ui.graphics.ColorKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MaterialFollowUpUtils.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0005¢\u0006\u0004\b4\u00105J\u0015\u00106\u001a\u0002022\u0006\u00103\u001a\u00020\u0005¢\u0006\u0004\b7\u00105J\u0015\u00108\u001a\u0002022\u0006\u00109\u001a\u00020\u0005¢\u0006\u0004\b:\u00105J\u0015\u0010;\u001a\u0002022\u0006\u00109\u001a\u00020\u0005¢\u0006\u0004\b<\u00105J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005J\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0005J\u0016\u0010C\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005J\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010E\u001a\u00020\u0005J\u0014\u0010F\u001a\u00020\u00052\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\fR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\fR\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\f¨\u0006H"}, d2 = {"Lcom/example/utils/MaterialFollowUpUtils;", "", "<init>", "()V", "STATUS_ALL", "", "STATUS_OPEN", "STATUS_IN_PROGRESS", "STATUS_CLOSED", "ALL_STATUSES", "", "getALL_STATUSES", "()Ljava/util/List;", "STATUS_FILTER_OPTIONS", "getSTATUS_FILTER_OPTIONS", "PRIORITY_LOW", "PRIORITY_MEDIUM", "PRIORITY_HIGH", "PRIORITY_CRITICAL", "ALL_PRIORITIES", "getALL_PRIORITIES", "CAT_ALL", "CAT_RAW_MATERIALS", "CAT_SAFETY_PPE", "CAT_MACHINERY_SPARES", "CAT_FACILITY_MAINT", "CAT_CALIBRATION_SERVICE", "CAT_WASTE_MANAGEMENT", "CAT_ENVIRONMENTAL_TESTING", "CAT_IT_SECURITY", "CAT_CHEMICAL_CONSUMABLES", "CAT_SUBCONTRACTOR_LABOR", "CAT_OTHER", "ALL_CATEGORIES", "getALL_CATEGORIES", "CATEGORY_FILTER_OPTIONS", "getCATEGORY_FILTER_OPTIONS", "FREQ_ONCE", "FREQ_REPEAT", "FREQ_HOURLY", "FREQ_DAILY", "FREQ_WEEKLY", "FREQ_MONTHLY", "FREQ_BIMONTHLY", "FREQ_QUARTERLY", "FREQ_YEARLY", "FREQ_CUSTOM", "ALL_REMINDER_FREQUENCIES", "getALL_REMINDER_FREQUENCIES", "getStatusColor", "Landroidx/compose/ui/graphics/Color;", "status", "getStatusColor-vNxB06k", "(Ljava/lang/String;)J", "getStatusBgColor", "getStatusBgColor-vNxB06k", "getPriorityColor", "priority", "getPriorityColor-vNxB06k", "getPriorityBgColor", "getPriorityBgColor-vNxB06k", "isOverdue", "", "dueDate", "getDaysDifference", "", "targetDate", "formatDueDateBadge", "parseAttachments", "attachmentsStr", "formatAttachments", "list", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class MaterialFollowUpUtils {
    public static final String STATUS_ALL = "All";
    public static final MaterialFollowUpUtils INSTANCE = new MaterialFollowUpUtils();
    public static final String STATUS_OPEN = "Open";
    public static final String STATUS_IN_PROGRESS = "In Progress";
    public static final String STATUS_CLOSED = "Closed";
    private static final List<String> ALL_STATUSES = CollectionsKt.listOf(new String[]{STATUS_OPEN, STATUS_IN_PROGRESS, STATUS_CLOSED});
    private static final List<String> STATUS_FILTER_OPTIONS = CollectionsKt.listOf(new String[]{"All", STATUS_OPEN, STATUS_IN_PROGRESS, STATUS_CLOSED});
    public static final String PRIORITY_LOW = "Low";
    public static final String PRIORITY_MEDIUM = "Medium";
    public static final String PRIORITY_HIGH = "High";
    public static final String PRIORITY_CRITICAL = "Critical";
    private static final List<String> ALL_PRIORITIES = CollectionsKt.listOf(new String[]{PRIORITY_LOW, PRIORITY_MEDIUM, PRIORITY_HIGH, PRIORITY_CRITICAL});
    public static final String CAT_RAW_MATERIALS = "Raw Materials";
    public static final String CAT_SAFETY_PPE = "Safety PPE & Equipment";
    public static final String CAT_MACHINERY_SPARES = "Machinery & Spare Parts";
    public static final String CAT_FACILITY_MAINT = "Facility Maintenance";
    public static final String CAT_CALIBRATION_SERVICE = "Calibration Service";
    public static final String CAT_WASTE_MANAGEMENT = "Waste Management & Disposal";
    public static final String CAT_ENVIRONMENTAL_TESTING = "Environmental Testing";
    public static final String CAT_IT_SECURITY = "IT, Telecom & Security";
    public static final String CAT_CHEMICAL_CONSUMABLES = "Chemical & Consumables";
    public static final String CAT_SUBCONTRACTOR_LABOR = "Subcontractor Labor";
    public static final String CAT_OTHER = "Other Services";
    private static final List<String> ALL_CATEGORIES = CollectionsKt.listOf(new String[]{CAT_RAW_MATERIALS, CAT_SAFETY_PPE, CAT_MACHINERY_SPARES, CAT_FACILITY_MAINT, CAT_CALIBRATION_SERVICE, CAT_WASTE_MANAGEMENT, CAT_ENVIRONMENTAL_TESTING, CAT_IT_SECURITY, CAT_CHEMICAL_CONSUMABLES, CAT_SUBCONTRACTOR_LABOR, CAT_OTHER});
    public static final String CAT_ALL = "All Categories";
    private static final List<String> CATEGORY_FILTER_OPTIONS = CollectionsKt.plus(CollectionsKt.listOf(CAT_ALL), ALL_CATEGORIES);
    public static final String FREQ_ONCE = "Once";
    public static final String FREQ_REPEAT = "Repeat";
    public static final String FREQ_HOURLY = "Hourly";
    public static final String FREQ_DAILY = "Daily";
    public static final String FREQ_WEEKLY = "Weekly";
    public static final String FREQ_MONTHLY = "Monthly";
    public static final String FREQ_BIMONTHLY = "Bimonthly";
    public static final String FREQ_QUARTERLY = "Quarterly";
    public static final String FREQ_YEARLY = "Yearly";
    public static final String FREQ_CUSTOM = "Custom Date & Time";
    private static final List<String> ALL_REMINDER_FREQUENCIES = CollectionsKt.listOf(new String[]{FREQ_ONCE, FREQ_REPEAT, FREQ_HOURLY, FREQ_DAILY, FREQ_WEEKLY, FREQ_MONTHLY, FREQ_BIMONTHLY, FREQ_QUARTERLY, FREQ_YEARLY, FREQ_CUSTOM});
    public static final int $stable = 8;

    private MaterialFollowUpUtils() {
    }

    public final List<String> getALL_STATUSES() {
        return ALL_STATUSES;
    }

    public final List<String> getSTATUS_FILTER_OPTIONS() {
        return STATUS_FILTER_OPTIONS;
    }

    public final List<String> getALL_PRIORITIES() {
        return ALL_PRIORITIES;
    }

    public final List<String> getALL_CATEGORIES() {
        return ALL_CATEGORIES;
    }

    public final List<String> getCATEGORY_FILTER_OPTIONS() {
        return CATEGORY_FILTER_OPTIONS;
    }

    public final List<String> getALL_REMINDER_FREQUENCIES() {
        return ALL_REMINDER_FREQUENCIES;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
    
        if (r0.equals("closed") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return androidx.compose.ui.graphics.ColorKt.Color(4279673674L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
    
        if (r0.equals("completed") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
    
        if (r0.equals("inprogress") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0029, code lost:
    
        if (r0.equals("in progress") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return androidx.compose.ui.graphics.ColorKt.Color(4278355143L);
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001f. Please report as an issue. */
    /* renamed from: getStatusColor-vNxB06k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long m10getStatusColorvNxB06k(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "status"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r0)
            java.lang.String r0 = r0.toString()
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.hashCode()
            switch(r1) {
                case -1411655086: goto L5a;
                case -1402931637: goto L47;
                case -1357520532: goto L3e;
                case 3417674: goto L2c;
                case 1446940360: goto L23;
                default: goto L22;
            }
        L22:
            goto L6d
        L23:
            java.lang.String r1 = "in progress"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L63
            goto L22
        L2c:
            java.lang.String r1 = "open"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L22
            r0 = 4292441862(0xffd97706, double:2.120748061E-314)
            long r0 = androidx.compose.ui.graphics.ColorKt.Color(r0)
            goto L76
        L3e:
            java.lang.String r1 = "closed"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L50
            goto L22
        L47:
            java.lang.String r1 = "completed"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L50
            goto L22
        L50:
            r0 = 4279673674(0xff16a34a, double:2.1144397377E-314)
            long r0 = androidx.compose.ui.graphics.ColorKt.Color(r0)
            goto L76
        L5a:
            java.lang.String r1 = "inprogress"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L63
            goto L22
        L63:
            r0 = 4278355143(0xff0284c7, double:2.113788297E-314)
            long r0 = androidx.compose.ui.graphics.ColorKt.Color(r0)
            goto L76
        L6d:
            r0 = 4284773515(0xff64748b, double:2.116959394E-314)
            long r0 = androidx.compose.ui.graphics.ColorKt.Color(r0)
        L76:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.MaterialFollowUpUtils.m10getStatusColorvNxB06k(java.lang.String):long");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
    
        if (r0.equals("closed") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return androidx.compose.ui.graphics.ColorKt.Color(4292672743L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
    
        if (r0.equals("completed") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
    
        if (r0.equals("inprogress") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0029, code lost:
    
        if (r0.equals("in progress") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return androidx.compose.ui.graphics.ColorKt.Color(4292932350L);
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001f. Please report as an issue. */
    /* renamed from: getStatusBgColor-vNxB06k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long m9getStatusBgColorvNxB06k(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "status"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r0)
            java.lang.String r0 = r0.toString()
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.hashCode()
            switch(r1) {
                case -1411655086: goto L5a;
                case -1402931637: goto L47;
                case -1357520532: goto L3e;
                case 3417674: goto L2c;
                case 1446940360: goto L23;
                default: goto L22;
            }
        L22:
            goto L6d
        L23:
            java.lang.String r1 = "in progress"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L63
            goto L22
        L2c:
            java.lang.String r1 = "open"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L22
            r0 = 4294898631(0xfffef3c7, double:2.121961866E-314)
            long r0 = androidx.compose.ui.graphics.ColorKt.Color(r0)
            goto L76
        L3e:
            java.lang.String r1 = "closed"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L50
            goto L22
        L47:
            java.lang.String r1 = "completed"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L50
            goto L22
        L50:
            r0 = 4292672743(0xffdcfce7, double:2.120862131E-314)
            long r0 = androidx.compose.ui.graphics.ColorKt.Color(r0)
            goto L76
        L5a:
            java.lang.String r1 = "inprogress"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L63
            goto L22
        L63:
            r0 = 4292932350(0xffe0f2fe, double:2.120990394E-314)
            long r0 = androidx.compose.ui.graphics.ColorKt.Color(r0)
            goto L76
        L6d:
            r0 = 4294047225(0xfff1f5f9, double:2.1215412155E-314)
            long r0 = androidx.compose.ui.graphics.ColorKt.Color(r0)
        L76:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.MaterialFollowUpUtils.m9getStatusBgColorvNxB06k(java.lang.String):long");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0024. Please report as an issue. */
    /* renamed from: getPriorityColor-vNxB06k, reason: not valid java name */
    public final long m8getPriorityColorvNxB06k(String priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        String lowerCase = StringsKt.trim(priority).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -1078030475:
                if (lowerCase.equals("medium")) {
                    return ColorKt.Color(4280640491L);
                }
                return ColorKt.Color(4284773515L);
            case 107348:
                if (lowerCase.equals("low")) {
                    return ColorKt.Color(4284773515L);
                }
                return ColorKt.Color(4284773515L);
            case 3202466:
                if (lowerCase.equals("high")) {
                    return ColorKt.Color(4293548044L);
                }
                return ColorKt.Color(4284773515L);
            case 1952151455:
                if (lowerCase.equals("critical")) {
                    return ColorKt.Color(4292617766L);
                }
                return ColorKt.Color(4284773515L);
            default:
                return ColorKt.Color(4284773515L);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001f. Please report as an issue. */
    /* renamed from: getPriorityBgColor-vNxB06k, reason: not valid java name */
    public final long m7getPriorityBgColorvNxB06k(String priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        String lowerCase = StringsKt.trim(priority).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -1078030475:
                if (lowerCase.equals("medium")) {
                    return ColorKt.Color(4292602622L);
                }
                return ColorKt.Color(4294507260L);
            case 107348:
                if (lowerCase.equals("low")) {
                    return ColorKt.Color(4294047225L);
                }
                return ColorKt.Color(4294507260L);
            case 3202466:
                if (lowerCase.equals("high")) {
                    return ColorKt.Color(4294962645L);
                }
                return ColorKt.Color(4294507260L);
            case 1952151455:
                if (lowerCase.equals("critical")) {
                    return ColorKt.Color(4294894306L);
                }
                return ColorKt.Color(4294507260L);
            default:
                return ColorKt.Color(4294507260L);
        }
    }

    public final boolean isOverdue(String dueDate, String status) {
        Intrinsics.checkNotNullParameter(dueDate, "dueDate");
        Intrinsics.checkNotNullParameter(status, "status");
        if (StringsKt.equals(status, STATUS_CLOSED, true) || StringsKt.isBlank(dueDate)) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date due = sdf.parse(StringsKt.trim(dueDate).toString());
            if (due == null) {
                return false;
            }
            Calendar calToday = Calendar.getInstance();
            calToday.set(11, 0);
            calToday.set(12, 0);
            calToday.set(13, 0);
            calToday.set(14, 0);
            return due.before(calToday.getTime());
        } catch (Exception e) {
            return false;
        }
    }

    public final long getDaysDifference(String targetDate) {
        Intrinsics.checkNotNullParameter(targetDate, "targetDate");
        if (StringsKt.isBlank(targetDate)) {
            return 0L;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date target = sdf.parse(StringsKt.trim(targetDate).toString());
            if (target == null) {
                return 0L;
            }
            Calendar calToday = Calendar.getInstance();
            calToday.set(11, 0);
            calToday.set(12, 0);
            calToday.set(13, 0);
            calToday.set(14, 0);
            long diffMs = target.getTime() - calToday.getTimeInMillis();
            return diffMs / 86400000;
        } catch (Exception e) {
            return 0L;
        }
    }

    public final String formatDueDateBadge(String dueDate, String status) {
        Intrinsics.checkNotNullParameter(dueDate, "dueDate");
        Intrinsics.checkNotNullParameter(status, "status");
        if (StringsKt.isBlank(dueDate)) {
            return "No due date";
        }
        if (StringsKt.equals(status, STATUS_CLOSED, true)) {
            return "Completed";
        }
        long diff = getDaysDifference(dueDate);
        if (diff < 0) {
            return "Overdue by " + (-diff) + "d";
        }
        return diff == 0 ? "Due Today" : diff == 1 ? "Due Tomorrow" : "Due in " + diff + "d";
    }

    public final List<String> parseAttachments(String attachmentsStr) {
        Intrinsics.checkNotNullParameter(attachmentsStr, "attachmentsStr");
        if (StringsKt.isBlank(attachmentsStr)) {
            return CollectionsKt.emptyList();
        }
        Iterable split$default = StringsKt.split$default(attachmentsStr, new String[]{","}, false, 0, 6, (Object) null);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((String) it.next()).toString());
        }
        Collection arrayList2 = new ArrayList();
        for (Object obj : (List) arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        return (List) arrayList2;
    }

    public final String formatAttachments(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List<String> list2 = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((String) it.next()).toString());
        }
        Collection arrayList2 = new ArrayList();
        for (Object obj : (List) arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt.joinToString$default((List) arrayList2, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
