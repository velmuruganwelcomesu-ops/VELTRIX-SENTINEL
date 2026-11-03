package com.example.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.data.Company;
import com.example.data.IncidentRecord;
import com.example.data.Observation;
import com.example.data.ResponsiblePerson;
import java.io.File;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DataPreservationManager.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJH\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/example/utils/DataPreservationManager;", "", "<init>", "()V", "PREFS_NAME", "", "KEY_LAST_REMINDER_TIME", "KEY_DATA_PRESERVED", "ONE_HOUR_MS", "", "getPrefs", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "shouldShowReminder", "", "totalDataCount", "", "markReminderShown", "", "markDataPreserved", "postponeOneHour", "checkAndPromptOnStartupOrInterval", "dismissUntilNextLogin", "postponeReminder", "createBackupSnapshot", "Ljava/io/File;", "companies", "", "Lcom/example/data/Company;", "observations", "Lcom/example/data/Observation;", "incidents", "Lcom/example/data/IncidentRecord;", "responsiblePersons", "Lcom/example/data/ResponsiblePerson;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class DataPreservationManager {
    public static final int $stable = 0;
    public static final DataPreservationManager INSTANCE = new DataPreservationManager();
    private static final String KEY_DATA_PRESERVED = "has_user_confirmed_preservation";
    private static final String KEY_LAST_REMINDER_TIME = "last_data_preservation_reminder_time";
    private static final long ONE_HOUR_MS = 3600000;
    private static final String PREFS_NAME = "veltrix_data_preservation_prefs";

    private DataPreservationManager() {
    }

    private final SharedPreferences getPrefs(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    public final boolean shouldShowReminder(Context context, int totalDataCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (totalDataCount == 0) {
            return false;
        }
        SharedPreferences prefs = getPrefs(context);
        long lastTime = prefs.getLong(KEY_LAST_REMINDER_TIME, 0L);
        long now = System.currentTimeMillis();
        return now - lastTime >= ONE_HOUR_MS;
    }

    public final void markReminderShown(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getPrefs(context).edit().putLong(KEY_LAST_REMINDER_TIME, System.currentTimeMillis()).apply();
    }

    public final void markDataPreserved(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getPrefs(context).edit().putBoolean(KEY_DATA_PRESERVED, true).putLong(KEY_LAST_REMINDER_TIME, System.currentTimeMillis()).apply();
    }

    public final void postponeOneHour(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getPrefs(context).edit().putLong(KEY_LAST_REMINDER_TIME, System.currentTimeMillis()).apply();
    }

    public final boolean checkAndPromptOnStartupOrInterval(Context context, int totalDataCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (totalDataCount == 0) {
            return false;
        }
        SharedPreferences prefs = getPrefs(context);
        long lastTime = prefs.getLong(KEY_LAST_REMINDER_TIME, 0L);
        long now = System.currentTimeMillis();
        if (lastTime != 0 && now - lastTime < ONE_HOUR_MS) {
            return false;
        }
        markReminderShown(context);
        return true;
    }

    public final void dismissUntilNextLogin(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        markDataPreserved(context);
    }

    public final void postponeReminder(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        postponeOneHour(context);
    }

    public final File createBackupSnapshot(Context context, List<Company> companies, List<Observation> observations, List<IncidentRecord> incidents, List<ResponsiblePerson> responsiblePersons) {
        File file;
        File backupFile;
        String jSONObject;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(companies, "companies");
        Intrinsics.checkNotNullParameter(observations, "observations");
        Intrinsics.checkNotNullParameter(incidents, "incidents");
        Intrinsics.checkNotNullParameter(responsiblePersons, "responsiblePersons");
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app", "Veltrix Sentinel");
            jSONObject2.put("backupVersion", 1);
            jSONObject2.put("createdAt", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
            jSONObject2.put("timestamp", System.currentTimeMillis());
            JSONArray compArray = new JSONArray();
            for (Company company : companies) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", company.getId());
                jSONObject3.put("name", company.getName());
                jSONObject3.put("address", company.getAddress());
                jSONObject3.put("division", company.getDivision());
                jSONObject3.put("assignedSafetyOfficer", company.getAssignedSafetyOfficer());
                compArray.put(jSONObject3);
            }
            jSONObject2.put("companies", compArray);
            JSONArray obsArray = new JSONArray();
            List<Observation> list = observations;
            for (Observation observation : list) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("id", observation.getId());
                jSONObject4.put("companyId", observation.getCompanyId());
                jSONObject4.put("sncNumber", observation.getSncNumber());
                jSONObject4.put("location", observation.getLocation());
                jSONObject4.put("severity", observation.getSeverity());
                jSONObject4.put("issueDetails", observation.getIssueDetails());
                jSONObject4.put("suggestion", observation.getSuggestion());
                jSONObject4.put("responsiblePerson", observation.getResponsiblePerson());
                jSONObject4.put("targetDate", observation.getTargetDate());
                jSONObject4.put("dateAdded", observation.getDateAdded());
                jSONObject4.put("isResolved", observation.isResolved());
                jSONObject4.put("findingType", observation.getFindingType());
                jSONObject4.put("employeeName", observation.getEmployeeName());
                jSONObject4.put("employeeId", observation.getEmployeeId());
                obsArray.put(jSONObject4);
                list = list;
            }
            jSONObject2.put("observations", obsArray);
            JSONArray incArray = new JSONArray();
            List<IncidentRecord> list2 = incidents;
            int i = 0;
            for (IncidentRecord incidentRecord : list2) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("id", incidentRecord.getId());
                jSONObject5.put("companyId", incidentRecord.getCompanyId());
                jSONObject5.put("incidentNumber", incidentRecord.getIncidentNumber());
                jSONObject5.put("incidentDate", incidentRecord.getIncidentDate());
                jSONObject5.put("incidentTime", incidentRecord.getIncidentTime());
                jSONObject5.put("reportTypeCategory", incidentRecord.getReportTypeCategory());
                jSONObject5.put("department", incidentRecord.getDepartment());
                jSONObject5.put("location", incidentRecord.getLocation());
                jSONObject5.put("description", incidentRecord.getDescription());
                jSONObject5.put("severity", incidentRecord.getSeverity());
                jSONObject5.put("status", incidentRecord.getStatus());
                incArray.put(jSONObject5);
                list2 = list2;
                i = i;
                obsArray = obsArray;
            }
            jSONObject2.put("incidents", incArray);
            backupFile = new File(context.getFilesDir(), "veltrix_safety_backup_latest.json");
            jSONObject = jSONObject2.toString(2);
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
            file = null;
        } catch (Exception e) {
            e = e;
            file = null;
        }
        try {
            FilesKt.writeText$default(backupFile, jSONObject, (Charset) null, 2, (Object) null);
            markDataPreserved(context);
            return backupFile;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return file;
        }
    }
}
