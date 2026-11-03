package com.example.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DateUtils.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u0010\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J$\u0010\u0013\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u0016\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u0018J\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\"\u0010\u001e\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/example/utils/DateUtils;", "", "<init>", "()V", "FORMAT_DD_MM_YYYY", "", "supportedFormats", "", "getTodayFormatted", "parseDate", "Ljava/util/Date;", "dateStr", "formatToDdMmYyyy", "date", "isDateOverdue", "", "targetDateStr", "isDateDueToday", "isDateDueSoon", "isDateInRange", "fromDateStr", "toDateStr", "isDateWithinDays", "days", "", "calculateApplyByDate", "expiryDateStr", "leadTimeDays", "getDaysUntil", "", "evaluateComplianceStatus", "applyByDateStr", "currentStatus", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class DateUtils {
    public static final DateUtils INSTANCE = new DateUtils();
    public static final String FORMAT_DD_MM_YYYY = "dd-MM-yyyy";
    private static final List<String> supportedFormats = CollectionsKt.listOf(new String[]{FORMAT_DD_MM_YYYY, "dd/MM/yyyy", "yyyy-MM-dd", "yyyy/MM/dd", "dd-MM-yy", "dd/MM/yy", "dd-MMM-yyyy", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss"});
    public static final int $stable = 8;

    private DateUtils() {
    }

    public final String getTodayFormatted() {
        String format = new SimpleDateFormat(FORMAT_DD_MM_YYYY, Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final Date parseDate(String dateStr) {
        Date parsed;
        String str = dateStr;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        String clean = StringsKt.trim(dateStr).toString();
        for (String pattern : supportedFormats) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
                sdf.setLenient(false);
                parsed = sdf.parse(clean);
            } catch (Exception e) {
            }
            if (parsed != null) {
                return parsed;
            }
        }
        return null;
    }

    public final String formatToDdMmYyyy(Date date) {
        if (date == null) {
            return "";
        }
        String format = new SimpleDateFormat(FORMAT_DD_MM_YYYY, Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final String formatToDdMmYyyy(String dateStr) {
        String str = dateStr;
        if (str == null || StringsKt.isBlank(str)) {
            return "";
        }
        Date parsed = parseDate(dateStr);
        return parsed == null ? StringsKt.trim(dateStr).toString() : formatToDdMmYyyy(parsed);
    }

    public final boolean isDateOverdue(String targetDateStr) {
        Date target = parseDate(targetDateStr);
        if (target == null) {
            return false;
        }
        Calendar calNow = Calendar.getInstance();
        calNow.set(11, 0);
        calNow.set(12, 0);
        calNow.set(13, 0);
        calNow.set(14, 0);
        Calendar calTarget = Calendar.getInstance();
        calTarget.setTime(target);
        calTarget.set(11, 0);
        calTarget.set(12, 0);
        calTarget.set(13, 0);
        calTarget.set(14, 0);
        return calTarget.before(calNow);
    }

    public final boolean isDateDueToday(String targetDateStr) {
        Date target = parseDate(targetDateStr);
        if (target == null) {
            return false;
        }
        Calendar calNow = Calendar.getInstance();
        Calendar calTarget = Calendar.getInstance();
        calTarget.setTime(target);
        return calNow.get(1) == calTarget.get(1) && calNow.get(6) == calTarget.get(6);
    }

    public final boolean isDateDueSoon(String targetDateStr) {
        Date target = parseDate(targetDateStr);
        if (target == null) {
            return false;
        }
        Calendar calNow = Calendar.getInstance();
        calNow.set(11, 23);
        calNow.set(12, 59);
        calNow.set(13, 59);
        calNow.set(14, 999);
        Calendar calTarget = Calendar.getInstance();
        calTarget.setTime(target);
        return calTarget.after(calNow);
    }

    public final boolean isDateInRange(String dateStr, String fromDateStr, String toDateStr) {
        Date date = parseDate(dateStr);
        if (date == null) {
            return true;
        }
        Date fromDate = parseDate(fromDateStr);
        Date toDate = parseDate(toDateStr);
        if (fromDate != null) {
            Calendar calFrom = Calendar.getInstance();
            calFrom.setTime(fromDate);
            calFrom.set(11, 0);
            calFrom.set(12, 0);
            calFrom.set(13, 0);
            calFrom.set(14, 0);
            Calendar calDate = Calendar.getInstance();
            calDate.setTime(date);
            calDate.set(11, 0);
            calDate.set(12, 0);
            calDate.set(13, 0);
            calDate.set(14, 0);
            if (calDate.before(calFrom)) {
                return false;
            }
        }
        if (toDate == null) {
            return true;
        }
        Calendar calTo = Calendar.getInstance();
        calTo.setTime(toDate);
        calTo.set(11, 23);
        calTo.set(12, 59);
        calTo.set(13, 59);
        calTo.set(14, 999);
        Calendar calDate2 = Calendar.getInstance();
        calDate2.setTime(date);
        calDate2.set(11, 23);
        calDate2.set(12, 59);
        calDate2.set(13, 59);
        calDate2.set(14, 999);
        return !calDate2.after(calTo);
    }

    public final boolean isDateWithinDays(String dateStr, int days) {
        Date date = parseDate(dateStr);
        if (date == null) {
            return false;
        }
        Calendar calStart = Calendar.getInstance();
        calStart.add(6, -days);
        calStart.set(11, 0);
        calStart.set(12, 0);
        calStart.set(13, 0);
        calStart.set(14, 0);
        Calendar calEnd = Calendar.getInstance();
        calEnd.set(11, 23);
        calEnd.set(12, 59);
        calEnd.set(13, 59);
        calEnd.set(14, 999);
        Calendar calDate = Calendar.getInstance();
        calDate.setTime(date);
        return (calDate.before(calStart) || calDate.after(calEnd)) ? false : true;
    }

    public final String calculateApplyByDate(String expiryDateStr, int leadTimeDays) {
        Date expiry;
        String str = expiryDateStr;
        if ((str == null || StringsKt.isBlank(str)) || (expiry = parseDate(expiryDateStr)) == null) {
            return "";
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(expiry);
        cal.add(6, -leadTimeDays);
        return formatToDdMmYyyy(cal.getTime());
    }

    public final long getDaysUntil(String dateStr) {
        Date target = parseDate(dateStr);
        if (target == null) {
            return 0L;
        }
        Calendar calToday = Calendar.getInstance();
        calToday.set(11, 0);
        calToday.set(12, 0);
        calToday.set(13, 0);
        calToday.set(14, 0);
        Calendar calTarget = Calendar.getInstance();
        calTarget.setTime(target);
        calTarget.set(11, 0);
        calTarget.set(12, 0);
        calTarget.set(13, 0);
        calTarget.set(14, 0);
        long diffMs = calTarget.getTimeInMillis() - calToday.getTimeInMillis();
        return diffMs / 86400000;
    }

    public final String evaluateComplianceStatus(String expiryDateStr, String applyByDateStr, String currentStatus) {
        Intrinsics.checkNotNullParameter(currentStatus, "currentStatus");
        String str = expiryDateStr;
        String str2 = "Valid";
        if (str == null || StringsKt.isBlank(str)) {
            String str3 = currentStatus;
            if (!StringsKt.isBlank(str3)) {
                str2 = str3;
            }
            return str2;
        }
        long daysUntilExpiry = getDaysUntil(expiryDateStr);
        String str4 = applyByDateStr;
        long daysUntilApplyBy = !(str4 == null || StringsKt.isBlank(str4)) ? getDaysUntil(applyByDateStr) : daysUntilExpiry - 60;
        return (Intrinsics.areEqual(currentStatus, "Application Submitted") || Intrinsics.areEqual(currentStatus, "Under Renewal")) ? daysUntilExpiry < 0 ? "Under Renewal (Expired)" : currentStatus : daysUntilExpiry < 0 ? "Expired" : daysUntilApplyBy <= 0 ? "Apply Soon" : "Valid";
    }
}
