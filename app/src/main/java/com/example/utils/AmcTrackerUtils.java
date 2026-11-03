package com.example.utils;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AlarmKt;
import androidx.compose.material.icons.filled.CheckCircleKt;
import androidx.compose.material.icons.filled.ErrorKt;
import androidx.compose.material.icons.filled.NotificationsActiveKt;
import androidx.compose.material.icons.filled.SensorsKt;
import androidx.compose.material.icons.filled.WarningKt;
import androidx.compose.material.icons.filled.WaterDamageKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AmcTrackerUtils.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0005J\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020'J\u000e\u0010+\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010,\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0005J\u0018\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\"J\u0015\u00100\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b1\u0010\u0017J\u0015\u00102\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b3\u0010\u0017J\u0015\u00104\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b5\u0010\u0017J\u000e\u00106\u001a\u0002072\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0005J\u000e\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR#\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0!0\u001b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/example/utils/AmcTrackerUtils;", "", "<init>", "()V", "STATUS_ACTIVE", "", "STATUS_DUE_SOON", "STATUS_EXPIRED", "FILTER_ALL", "TYPE_FIRE_ALARM", "TYPE_SMOKE_DETECTORS", "TYPE_FIRE_HYDRANTS", "TYPE_HOSE_REELS", "FILTER_FIRE_ALARM", "FILTER_SMOKE_DETECTORS", "FILTER_FIRE_HYDRANTS", "FILTER_HOSE_REELS", "calculateAmcStatus", "nextServiceDueDate", "getStatusBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "status", "getStatusBackgroundColor-vNxB06k", "(Ljava/lang/String;)J", "getDaysUntilDue", "", "STANDARD_FILTERS", "", "getSTANDARD_FILTERS", "()Ljava/util/List;", "STANDARD_EQUIPMENT_TYPES", "getSTANDARD_EQUIPMENT_TYPES", "SERVICE_FREQUENCIES", "Lkotlin/Pair;", "", "getSERVICE_FREQUENCIES", "supportedDateFormats", "Ljava/text/SimpleDateFormat;", "parseDate", "Ljava/util/Date;", "dateStr", "formatDate", "date", "computeStatus", "getDaysDifference", "calculateNextDueDate", "lastServiceDate", "frequencyMonths", "getStatusColor", "getStatusColor-vNxB06k", "getStatusBgColor", "getStatusBgColor-vNxB06k", "getStatusBorderColor", "getStatusBorderColor-vNxB06k", "getStatusIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getEquipmentTypeIcon", "type", "categorizeTimeline", "daysDiff", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class AmcTrackerUtils {
    public static final String FILTER_ALL = "All";
    public static final String FILTER_FIRE_ALARM = "Fire Alarm";
    public static final String FILTER_FIRE_HYDRANTS = "Fire Hydrants";
    public static final String FILTER_HOSE_REELS = "Hose Reels";
    public static final String FILTER_SMOKE_DETECTORS = "Smoke Detectors";
    public static final String STATUS_ACTIVE = "Active";
    public static final String STATUS_DUE_SOON = "Due Soon";
    public static final String STATUS_EXPIRED = "Expired";
    public static final String TYPE_FIRE_ALARM = "Fire Alarm";
    public static final String TYPE_FIRE_HYDRANTS = "Fire Hydrants";
    public static final String TYPE_HOSE_REELS = "Hose Reels";
    public static final String TYPE_SMOKE_DETECTORS = "Smoke Detectors";
    public static final AmcTrackerUtils INSTANCE = new AmcTrackerUtils();
    private static final List<String> STANDARD_FILTERS = CollectionsKt.listOf(new String[]{"All", "Fire Alarm", "Smoke Detectors", "Fire Hydrants", "Hose Reels"});
    private static final List<String> STANDARD_EQUIPMENT_TYPES = CollectionsKt.listOf(new String[]{"Fire Alarm", "Smoke Detectors", "Fire Hydrants", "Hose Reels"});
    private static final List<Pair<String, Integer>> SERVICE_FREQUENCIES = CollectionsKt.listOf(new Pair[]{TuplesKt.to(MaterialFollowUpUtils.FREQ_QUARTERLY, 3), TuplesKt.to("Half-Yearly", 6), TuplesKt.to("Annual", 12), TuplesKt.to(MaterialFollowUpUtils.FREQ_MONTHLY, 1)});
    private static final List<SimpleDateFormat> supportedDateFormats = CollectionsKt.listOf(new SimpleDateFormat[]{new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()), new SimpleDateFormat(DateUtils.FORMAT_DD_MM_YYYY, Locale.getDefault()), new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()), new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())});
    public static final int $stable = 8;

    private AmcTrackerUtils() {
    }

    public final String calculateAmcStatus(String nextServiceDueDate) {
        Intrinsics.checkNotNullParameter(nextServiceDueDate, "nextServiceDueDate");
        return computeStatus(nextServiceDueDate);
    }

    /* renamed from: getStatusBackgroundColor-vNxB06k, reason: not valid java name */
    public final long m0getStatusBackgroundColorvNxB06k(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        return m1getStatusBgColorvNxB06k(status);
    }

    public final long getDaysUntilDue(String nextServiceDueDate) {
        Intrinsics.checkNotNullParameter(nextServiceDueDate, "nextServiceDueDate");
        return getDaysDifference(nextServiceDueDate);
    }

    public final List<String> getSTANDARD_FILTERS() {
        return STANDARD_FILTERS;
    }

    public final List<String> getSTANDARD_EQUIPMENT_TYPES() {
        return STANDARD_EQUIPMENT_TYPES;
    }

    public final List<Pair<String, Integer>> getSERVICE_FREQUENCIES() {
        return SERVICE_FREQUENCIES;
    }

    public final Date parseDate(String dateStr) {
        Date parsed;
        Intrinsics.checkNotNullParameter(dateStr, "dateStr");
        String trimmed = StringsKt.trim(dateStr).toString();
        if (StringsKt.isBlank(trimmed)) {
            return null;
        }
        for (SimpleDateFormat format : supportedDateFormats) {
            try {
                format.setLenient(false);
                parsed = format.parse(trimmed);
            } catch (Exception e) {
            }
            if (parsed != null) {
                return parsed;
            }
        }
        return null;
    }

    public final String formatDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String format2 = format.format(date);
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    public final String computeStatus(String nextServiceDueDate) {
        Intrinsics.checkNotNullParameter(nextServiceDueDate, "nextServiceDueDate");
        Date dueDate = parseDate(nextServiceDueDate);
        if (dueDate == null) {
            return STATUS_ACTIVE;
        }
        Calendar todayCal = Calendar.getInstance();
        boolean z = false;
        todayCal.set(11, 0);
        todayCal.set(12, 0);
        todayCal.set(13, 0);
        todayCal.set(14, 0);
        todayCal.getTime();
        Calendar dueCal = Calendar.getInstance();
        dueCal.setTime(dueDate);
        dueCal.set(11, 0);
        dueCal.set(12, 0);
        dueCal.set(13, 0);
        dueCal.set(14, 0);
        long diffMillis = dueCal.getTimeInMillis() - todayCal.getTimeInMillis();
        long diffDays = diffMillis / 86400000;
        if (diffDays < 0) {
            return "Expired";
        }
        if (0 <= diffDays && diffDays < 31) {
            z = true;
        }
        return z ? STATUS_DUE_SOON : STATUS_ACTIVE;
    }

    public final long getDaysDifference(String nextServiceDueDate) {
        Intrinsics.checkNotNullParameter(nextServiceDueDate, "nextServiceDueDate");
        Date dueDate = parseDate(nextServiceDueDate);
        if (dueDate == null) {
            return 999L;
        }
        Calendar todayCal = Calendar.getInstance();
        todayCal.set(11, 0);
        todayCal.set(12, 0);
        todayCal.set(13, 0);
        todayCal.set(14, 0);
        Calendar dueCal = Calendar.getInstance();
        dueCal.setTime(dueDate);
        dueCal.set(11, 0);
        dueCal.set(12, 0);
        dueCal.set(13, 0);
        dueCal.set(14, 0);
        return (dueCal.getTimeInMillis() - todayCal.getTimeInMillis()) / 86400000;
    }

    public static /* synthetic */ String calculateNextDueDate$default(AmcTrackerUtils amcTrackerUtils, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 3;
        }
        return amcTrackerUtils.calculateNextDueDate(str, i);
    }

    public final String calculateNextDueDate(String lastServiceDate, int frequencyMonths) {
        Intrinsics.checkNotNullParameter(lastServiceDate, "lastServiceDate");
        Date parsed = parseDate(lastServiceDate);
        if (parsed == null) {
            return "";
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(parsed);
        cal.add(2, frequencyMonths);
        Date time = cal.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
        return formatDate(time);
    }

    /* renamed from: getStatusColor-vNxB06k, reason: not valid java name */
    public final long m3getStatusColorvNxB06k(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = status.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = "Expired".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
            return ColorKt.Color(4292617766L);
        }
        String lowerCase3 = STATUS_DUE_SOON.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase, lowerCase3) ? ColorKt.Color(4292441862L) : ColorKt.Color(4279673674L);
    }

    /* renamed from: getStatusBgColor-vNxB06k, reason: not valid java name */
    public final long m1getStatusBgColorvNxB06k(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = status.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = "Expired".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
            return ColorKt.Color(4294894306L);
        }
        String lowerCase3 = STATUS_DUE_SOON.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase, lowerCase3) ? ColorKt.Color(4294898631L) : ColorKt.Color(4292672743L);
    }

    /* renamed from: getStatusBorderColor-vNxB06k, reason: not valid java name */
    public final long m2getStatusBorderColorvNxB06k(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = status.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = "Expired".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
            return ColorKt.Color(4294747557L);
        }
        String lowerCase3 = STATUS_DUE_SOON.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase, lowerCase3) ? ColorKt.Color(4294829706L) : ColorKt.Color(4287033260L);
    }

    public final ImageVector getStatusIcon(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = status.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = "Expired".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
            return ErrorKt.getError(Icons.INSTANCE.getDefault());
        }
        String lowerCase3 = STATUS_DUE_SOON.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase, lowerCase3) ? WarningKt.getWarning(Icons.INSTANCE.getDefault()) : CheckCircleKt.getCheckCircle(Icons.INSTANCE.getDefault());
    }

    public final ImageVector getEquipmentTypeIcon(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lower = type.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
        if (StringsKt.contains$default(lower, "alarm", false, 2, (Object) null)) {
            return NotificationsActiveKt.getNotificationsActive(Icons.INSTANCE.getDefault());
        }
        if (StringsKt.contains$default(lower, "smoke", false, 2, (Object) null) || StringsKt.contains$default(lower, "detector", false, 2, (Object) null)) {
            return SensorsKt.getSensors(Icons.INSTANCE.getDefault());
        }
        return StringsKt.contains$default(lower, "hydrant", false, 2, (Object) null) ? WaterDamageKt.getWaterDamage(Icons.INSTANCE.getDefault()) : StringsKt.contains$default(lower, "hose", false, 2, (Object) null) ? AlarmKt.getAlarm(Icons.INSTANCE.getDefault()) : NotificationsActiveKt.getNotificationsActive(Icons.INSTANCE.getDefault());
    }

    public final String categorizeTimeline(long daysDiff) {
        if (daysDiff < 0) {
            return "Overdue / Expired";
        }
        if (0 <= daysDiff && daysDiff < 31) {
            return "Due in 30 Days";
        }
        if (31 <= daysDiff && daysDiff < 91) {
            return "Due in 1 - 3 Months";
        }
        return 91 <= daysDiff && daysDiff < 181 ? "Due in 3 - 6 Months" : "Due Later (> 6 Months)";
    }
}
