package com.example.utils;

import android.content.Context;
import com.example.data.Company;
import com.example.data.IncidentRecord;
import com.example.data.Observation;
import com.example.data.ResponsiblePerson;
import com.example.data.SafetyTraining;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: CsvReportGenerator.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J8\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J,\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J,\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J:\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012JV\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J,\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000e2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J,\u0010#\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005JÂ\u0001\u0010(\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J.\u0010.\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u000e2\b\b\u0002\u0010-\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012¨\u00061"}, d2 = {"Lcom/example/utils/CsvReportGenerator;", "", "<init>", "()V", "escapeCsv", "", "value", "generateCsvReport", "", "context", "Landroid/content/Context;", "company", "Lcom/example/data/Company;", "observations", "", "Lcom/example/data/Observation;", "dateRangeText", "outputFile", "Ljava/io/File;", "generateUnsafeActsCsv", "companyName", "generateUnsafeConditionsCsv", "generateSafetyStarAndRosterCsv", "rosterList", "Lcom/example/data/ResponsiblePerson;", "generateExecutiveComparisonCsv", "currentObs", "previousObs", "currentIncidents", "Lcom/example/data/IncidentRecord;", "previousIncidents", "generateSafetyTrainingsCsv", "trainings", "Lcom/example/data/SafetyTraining;", "monthYearText", "generateIncidentsCsv", "incidents", "determineHazardParameter", "issue", "location", "generateUnifiedMasterCsv", "selectedReportKeys", "unsafeActObservations", "unsafeConditionObservations", "safetyStarObservations", "presenterName", "generateComplianceRegisterCsv", "complianceItems", "Lcom/example/data/ComplianceItem;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class CsvReportGenerator {
    public static final int $stable = 0;
    public static final CsvReportGenerator INSTANCE = new CsvReportGenerator();

    private CsvReportGenerator() {
    }

    private final String escapeCsv(String value) {
        String str = StringsKt.replace$default(value, "\"", "\"\"", false, 4, (Object) null);
        if (StringsKt.contains$default(str, ",", false, 2, (Object) null) || StringsKt.contains$default(str, "\n", false, 2, (Object) null) || StringsKt.contains$default(str, "\"", false, 2, (Object) null)) {
            return "\"" + str + "\"";
        }
        return str;
    }

    public static /* synthetic */ boolean generateCsvReport$default(CsvReportGenerator csvReportGenerator, Context context, Company company, List list, String str, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        return csvReportGenerator.generateCsvReport(context, company, list, str, file);
    }

    public final boolean generateCsvReport(Context context, Company company, List<Observation> observations, String dateRangeText, File outputFile) {
        Intrinsics.checkNotNullParameter(company, "company");
        Intrinsics.checkNotNullParameter(observations, "observations");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
            StringBuilder sb = new StringBuilder();
            String compName = StringsKt.isBlank(company.getDivision()) ? company.getName() : company.getName() + " - " + company.getDivision();
            sb.append("VELTRIX SENTINEL SAFETY AUDIT REPORT\n");
            sb.append("TAGLINE,Safety, Compliance & Sustainability – Managed Right.\n");
            sb.append("UNIT / COMPANY," + escapeCsv(compName) + "\n");
            sb.append("PERIOD," + escapeCsv(dateRangeText) + "\n");
            sb.append("GENERATED ON," + new SimpleDateFormat("dd-MMM-yyyy HH:mm", Locale.getDefault()).format(new Date()) + "\n");
            sb.append("TOTAL FINDINGS," + observations.size() + "\n\n");
            sb.append("S.No,SNC Number,Finding Type,Department,Location,Severity,Risk Level,Details,Action Taken / CAPA,Suggestion,Assigned Person,Target Date,Status,Completed Date,Closed By\n");
            int i = 0;
            for (Object obj : observations) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Observation observation = (Observation) obj;
                sb.append((i + 1) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getSncNumber()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getFindingType()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getDepartment()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getLocation()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getSeverity()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getRiskLevel()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getIssueDetails()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getActionTaken()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getSuggestion()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getResponsiblePerson()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getTargetDate()) + ",");
                sb.append((observation.isResolved() ? "RESOLVED" : "OPEN") + ",");
                sb.append(INSTANCE.escapeCsv(observation.getCompletedDate()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getClosedBy()) + "\n");
                i = i2;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                byte[] bytes = sb2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                fileOutputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                return true;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean generateUnsafeActsCsv(String companyName, List<Observation> observations, String dateRangeText, File outputFile) {
        int i;
        int i2;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        Intrinsics.checkNotNullParameter(observations, "observations");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
            Collection arrayList = new ArrayList();
            for (Object obj : observations) {
                if (StringsKt.equals(((Observation) obj).getFindingType(), "Unsafe Act", true)) {
                    arrayList.add(obj);
                }
            }
            List acts = (List) arrayList;
            StringBuilder sb = new StringBuilder();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = companyName.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            sb.append(escapeCsv(upperCase) + " - EHS AUDIT & COMPLIANCE\n");
            sb.append("UNSAFE ACTS & EMPLOYEE DETAILS AUDIT DOSSIER\n");
            sb.append("UNIT / COMPANY," + escapeCsv(companyName) + "\n");
            sb.append("PERIOD," + escapeCsv(dateRangeText) + "\n");
            sb.append("GENERATED ON," + new SimpleDateFormat("dd-MMM-yyyy HH:mm", Locale.getDefault()).format(new Date()) + "\n");
            sb.append("TOTAL UNSAFE ACTS RECORDED," + acts.size() + "\n");
            List list = acts;
            if ((list instanceof Collection) && list.isEmpty()) {
                i = 0;
            } else {
                i = 0;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!((Observation) it.next()).isResolved() && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            sb.append("OPEN VIOLATIONS," + i + "\n");
            List list2 = acts;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                i2 = 0;
            } else {
                i2 = 0;
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (((Observation) it2.next()).isResolved() && (i2 = i2 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            sb.append("RESOLVED / COACHED," + i2 + "\n\n");
            sb.append("S.No,SNC Number,Date Added,Department,Location,Employee ID,Employee Name,Designation,Severity,Risk Level,Unsafe Act Description,Corrective Coaching / Suggestion,Action Taken / CAPA,Supervisor / Responsible Person,Status,Resolved Date,Closed By\n");
            int i3 = 0;
            for (Object obj2 : acts) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Observation observation = (Observation) obj2;
                String employeeId = !StringsKt.isBlank(observation.getEmployeeId()) ? observation.getEmployeeId() : "N/A";
                if (StringsKt.isBlank(observation.getEmployeeName())) {
                    String responsiblePerson = observation.getResponsiblePerson();
                    if (StringsKt.isBlank(responsiblePerson)) {
                        responsiblePerson = "Unassigned";
                    }
                    str = responsiblePerson;
                } else {
                    str = observation.getEmployeeName();
                }
                String str3 = str;
                if (StringsKt.isBlank(observation.getEmployeeDepartment())) {
                    String department = observation.getDepartment();
                    if (StringsKt.isBlank(department)) {
                        department = observation.getLocation();
                    }
                    str2 = department;
                } else {
                    str2 = observation.getEmployeeDepartment();
                }
                String str4 = str2;
                String employeeDesignation = !StringsKt.isBlank(observation.getEmployeeDesignation()) ? observation.getEmployeeDesignation() : "Operator";
                sb.append((i3 + 1) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getSncNumber()) + ",");
                CsvReportGenerator csvReportGenerator = INSTANCE;
                String dateAdded = observation.getDateAdded();
                if (StringsKt.isBlank(dateAdded)) {
                    dateAdded = observation.getTargetDate();
                }
                sb.append(csvReportGenerator.escapeCsv(dateAdded) + ",");
                sb.append(INSTANCE.escapeCsv(str4) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getLocation()) + ",");
                sb.append(INSTANCE.escapeCsv(employeeId) + ",");
                sb.append(INSTANCE.escapeCsv(str3) + ",");
                sb.append(INSTANCE.escapeCsv(employeeDesignation) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getSeverity()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getRiskLevel()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getIssueDetails()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getSuggestion()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getActionTaken()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getResponsiblePerson()) + ",");
                sb.append((observation.isResolved() ? "RESOLVED" : "OPEN") + ",");
                sb.append(INSTANCE.escapeCsv(observation.getCompletedDate()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getClosedBy()) + "\n");
                i3 = i4;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                byte[] bytes = sb2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                fileOutputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                return true;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean generateUnsafeConditionsCsv(String companyName, List<Observation> observations, String dateRangeText, File outputFile) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        Intrinsics.checkNotNullParameter(observations, "observations");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
            Collection arrayList = new ArrayList();
            for (Object obj : observations) {
                if (!StringsKt.equals(((Observation) obj).getFindingType(), "Unsafe Act", true)) {
                    arrayList.add(obj);
                }
            }
            List conditions = (List) arrayList;
            StringBuilder sb = new StringBuilder();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = companyName.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            sb.append(escapeCsv(upperCase) + " - EHS AUDIT & COMPLIANCE\n");
            sb.append("UNSAFE CONDITIONS & ENVIRONMENTAL PARAMETERS REPORT\n");
            sb.append("UNIT / COMPANY," + escapeCsv(companyName) + "\n");
            sb.append("PERIOD," + escapeCsv(dateRangeText) + "\n");
            sb.append("GENERATED ON," + new SimpleDateFormat("dd-MMM-yyyy HH:mm", Locale.getDefault()).format(new Date()) + "\n");
            sb.append("TOTAL HAZARDS IDENTIFIED," + conditions.size() + "\n");
            List list = conditions;
            if ((list instanceof Collection) && list.isEmpty()) {
                i = 0;
            } else {
                i = 0;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!((Observation) it.next()).isResolved() && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            sb.append("PENDING HAZARDS," + i + "\n");
            List list2 = conditions;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                i2 = 0;
            } else {
                i2 = 0;
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (((Observation) it2.next()).isResolved() && (i2 = i2 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            sb.append("RECTIFIED HAZARDS," + i2 + "\n\n");
            sb.append("S.No,SNC Number,Date Logged,Department,Specific Location,Hazard Category / Parameter,Severity,Risk Rating,Unsafe Condition Details,Mandated Preventive Control,Corrective Action Taken,Responsible In-Charge,Target Date,Status,Closure Date,Closed By\n");
            int i3 = 0;
            for (Object obj2 : conditions) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Observation observation = (Observation) obj2;
                String determineHazardParameter = INSTANCE.determineHazardParameter(observation.getIssueDetails(), observation.getLocation());
                sb.append((i3 + 1) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getSncNumber()) + ",");
                CsvReportGenerator csvReportGenerator = INSTANCE;
                String dateAdded = observation.getDateAdded();
                if (StringsKt.isBlank(dateAdded)) {
                    dateAdded = observation.getTargetDate();
                }
                sb.append(csvReportGenerator.escapeCsv(dateAdded) + ",");
                CsvReportGenerator csvReportGenerator2 = INSTANCE;
                String department = observation.getDepartment();
                if (StringsKt.isBlank(department)) {
                    department = observation.getLocation();
                }
                sb.append(csvReportGenerator2.escapeCsv(department) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getLocation()) + ",");
                sb.append(INSTANCE.escapeCsv(determineHazardParameter) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getSeverity()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getRiskLevel()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getIssueDetails()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getSuggestion()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getActionTaken()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getResponsiblePerson()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getTargetDate()) + ",");
                sb.append((observation.isResolved() ? "RESOLVED" : "OPEN") + ",");
                sb.append(INSTANCE.escapeCsv(observation.getCompletedDate()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getClosedBy()) + "\n");
                i3 = i4;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                byte[] bytes = sb2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                fileOutputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                return true;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x02e8 A[Catch: Exception -> 0x0499, TryCatch #2 {Exception -> 0x0499, blocks: (B:3:0x002a, B:4:0x00fd, B:7:0x0105, B:9:0x010d, B:10:0x0110, B:11:0x012d, B:13:0x0133, B:15:0x014e, B:21:0x0163, B:23:0x0178, B:27:0x01aa, B:29:0x01b0, B:32:0x0183, B:33:0x0188, B:35:0x018e, B:38:0x019e, B:41:0x01a2, B:48:0x0289, B:49:0x029c, B:51:0x02a2, B:53:0x02b7, B:55:0x02c6, B:57:0x02d7, B:62:0x02e8, B:70:0x02f0, B:71:0x0313, B:73:0x0319, B:75:0x0321, B:76:0x0324, B:79:0x0333, B:81:0x0377, B:82:0x037e, B:84:0x03a6, B:87:0x03b9, B:88:0x03bd, B:90:0x03e5, B:92:0x03ec, B:96:0x0463, B:100:0x048c, B:110:0x0495, B:111:0x0498, B:98:0x046d, B:107:0x0493), top: B:2:0x002a, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02eb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean generateSafetyStarAndRosterCsv(java.lang.String r29, java.util.List<com.example.data.Observation> r30, java.util.List<com.example.data.ResponsiblePerson> r31, java.lang.String r32, java.io.File r33) {
        /*
            Method dump skipped, instructions count: 1183
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.CsvReportGenerator.generateSafetyStarAndRosterCsv(java.lang.String, java.util.List, java.util.List, java.lang.String, java.io.File):boolean");
    }

    public final boolean generateExecutiveComparisonCsv(String companyName, List<Observation> currentObs, List<Observation> previousObs, List<IncidentRecord> currentIncidents, List<IncidentRecord> previousIncidents, String dateRangeText, File outputFile) {
        int curOpenObs;
        int prevOpenObs;
        int curResolvedObs;
        int prevResolvedObs;
        double d;
        double curResolutionRate;
        double curResolutionRate2;
        double prevResolutionRate;
        StringBuilder append;
        int curUA;
        int prevUA;
        int curUC;
        int prevUC;
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        Intrinsics.checkNotNullParameter(currentObs, "currentObs");
        Intrinsics.checkNotNullParameter(previousObs, "previousObs");
        Intrinsics.checkNotNullParameter(currentIncidents, "currentIncidents");
        Intrinsics.checkNotNullParameter(previousIncidents, "previousIncidents");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
            StringBuilder sb = new StringBuilder();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = companyName.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            sb.append(escapeCsv(upperCase) + " - EHS AUDIT & COMPLIANCE\n");
            sb.append("EXECUTIVE DASHBOARD & MONTH-OVER-MONTH (MoM) COMPARISON MATRIX\n");
            sb.append("UNIT / COMPANY," + escapeCsv(companyName) + "\n");
            sb.append("PERIOD," + escapeCsv(dateRangeText) + "\n");
            sb.append("GENERATED ON," + new SimpleDateFormat("dd-MMM-yyyy HH:mm", Locale.getDefault()).format(new Date()) + "\n\n");
            sb.append("--- EXECUTIVE SAFETY KPI COMPARISON ---\n");
            sb.append("Safety KPI Metric,Current Period,Previous Period,Variance (Delta),Trend Status\n");
            int curTotalObs = currentObs.size();
            int prevTotalObs = previousObs.size();
            int obsDelta = curTotalObs - prevTotalObs;
            String obsTrend = (obsDelta <= 0 ? new StringBuilder().append("✅ IMPROVED (").append(obsDelta == 0 ? "Stable" : obsDelta + " findings").append(")") : new StringBuilder().append("⚠️ INCREASED (+").append(obsDelta).append(")")).toString();
            sb.append("Total Non-Conformances Logged," + curTotalObs + "," + prevTotalObs + "," + obsDelta + "," + obsTrend + "\n");
            List<Observation> list = currentObs;
            if ((list instanceof Collection) && list.isEmpty()) {
                curOpenObs = 0;
            } else {
                curOpenObs = 0;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!((Observation) it.next()).isResolved() && (curOpenObs = curOpenObs + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            List<Observation> list2 = previousObs;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                prevOpenObs = 0;
            } else {
                prevOpenObs = 0;
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (!((Observation) it2.next()).isResolved() && (prevOpenObs = prevOpenObs + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            int openDelta = curOpenObs - prevOpenObs;
            String openTrend = openDelta <= 0 ? "✅ REDUCED RISK" : "⚠️ ATTENTION REQUIRED";
            sb.append("Open / Pending NCs," + curOpenObs + "," + prevOpenObs + "," + openDelta + "," + openTrend + "\n");
            List<Observation> list3 = currentObs;
            if ((list3 instanceof Collection) && list3.isEmpty()) {
                curResolvedObs = 0;
            } else {
                curResolvedObs = 0;
                Iterator it3 = list3.iterator();
                while (it3.hasNext()) {
                    if (((Observation) it3.next()).isResolved() && (curResolvedObs = curResolvedObs + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            List<Observation> list4 = previousObs;
            if ((list4 instanceof Collection) && list4.isEmpty()) {
                prevResolvedObs = 0;
            } else {
                prevResolvedObs = 0;
                Iterator it4 = list4.iterator();
                while (it4.hasNext()) {
                    if (((Observation) it4.next()).isResolved() && (prevResolvedObs = prevResolvedObs + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            int resDelta = curResolvedObs - prevResolvedObs;
            String resTrend = resDelta >= 0 ? "✅ IMPROVED RESOLUTION VELOCITY" : "⚠️ SLOWER RESOLUTION";
            sb.append("Resolved & Closed Actions," + curResolvedObs + "," + prevResolvedObs + "," + resDelta + "," + resTrend + "\n");
            if (curTotalObs > 0) {
                d = 100.0d;
                curResolutionRate = (curResolvedObs * 100.0d) / curTotalObs;
            } else {
                d = 100.0d;
                curResolutionRate = 100.0d;
            }
            if (prevTotalObs > 0) {
                curResolutionRate2 = curResolutionRate;
                double curResolutionRate3 = prevResolvedObs;
                prevResolutionRate = (curResolutionRate3 * d) / prevTotalObs;
            } else {
                curResolutionRate2 = curResolutionRate;
                prevResolutionRate = d;
            }
            double rateDelta = curResolutionRate2 - prevResolutionRate;
            double prevResolutionRate2 = prevResolutionRate;
            if (rateDelta >= 0.0d) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(rateDelta)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                append = new StringBuilder().append("✅ +").append(format).append("% Gain");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(rateDelta)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                append = new StringBuilder().append("⚠️ ").append(format2).append("% Drop");
            }
            String rateTrend = append.toString();
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format(Locale.getDefault(), "%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf(curResolutionRate2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            String format4 = String.format(Locale.getDefault(), "%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf(prevResolutionRate2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
            StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
            String format5 = String.format(Locale.getDefault(), "%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf(rateDelta)}, 1));
            Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
            sb.append("Resolution Compliance Rate %," + format3 + "," + format4 + "," + format5 + "," + rateTrend + "\n");
            List<Observation> list5 = currentObs;
            if ((list5 instanceof Collection) && list5.isEmpty()) {
                curUA = 0;
            } else {
                curUA = 0;
                Iterator it5 = list5.iterator();
                while (it5.hasNext()) {
                    String rateTrend2 = rateTrend;
                    Iterable iterable = list5;
                    if (StringsKt.equals(((Observation) it5.next()).getFindingType(), "Unsafe Act", true)) {
                        curUA++;
                        if (curUA < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        rateTrend = rateTrend2;
                        list5 = iterable;
                    } else {
                        rateTrend = rateTrend2;
                        list5 = iterable;
                    }
                }
            }
            List<Observation> list6 = previousObs;
            int i = 0;
            if ((list6 instanceof Collection) && list6.isEmpty()) {
                prevUA = 0;
            } else {
                prevUA = 0;
                Iterator it6 = list6.iterator();
                while (it6.hasNext()) {
                    Iterable iterable2 = list6;
                    int i2 = i;
                    if (StringsKt.equals(((Observation) it6.next()).getFindingType(), "Unsafe Act", true)) {
                        prevUA++;
                        if (prevUA < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        list6 = iterable2;
                        i = i2;
                    } else {
                        list6 = iterable2;
                        i = i2;
                    }
                }
            }
            sb.append("Unsafe Acts Recorded," + curUA + "," + prevUA + "," + (curUA - prevUA) + "," + (curUA <= prevUA ? "✅ Better Behavior" : "⚠️ More Acts Logged") + "\n");
            List<Observation> list7 = currentObs;
            int i3 = 0;
            if ((list7 instanceof Collection) && list7.isEmpty()) {
                curUC = 0;
            } else {
                curUC = 0;
                Iterator it7 = list7.iterator();
                while (it7.hasNext()) {
                    Iterable iterable3 = list7;
                    int i4 = i3;
                    if (StringsKt.equals(((Observation) it7.next()).getFindingType(), "Unsafe Act", true)) {
                        list7 = iterable3;
                        i3 = i4;
                    } else {
                        curUC++;
                        if (curUC < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        list7 = iterable3;
                        i3 = i4;
                    }
                }
            }
            List<Observation> list8 = previousObs;
            int i5 = 0;
            if ((list8 instanceof Collection) && list8.isEmpty()) {
                prevUC = 0;
            } else {
                prevUC = 0;
                Iterator it8 = list8.iterator();
                while (it8.hasNext()) {
                    Iterable iterable4 = list8;
                    int i6 = i5;
                    if (StringsKt.equals(((Observation) it8.next()).getFindingType(), "Unsafe Act", true)) {
                        list8 = iterable4;
                        i5 = i6;
                    } else {
                        prevUC++;
                        if (prevUC < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        list8 = iterable4;
                        i5 = i6;
                    }
                }
            }
            sb.append("Unsafe Conditions (Physical)," + curUC + "," + prevUC + "," + (curUC - prevUC) + "," + (curUC <= prevUC ? "✅ Safer Work Environment" : "⚠️ Conditions Identified") + "\n");
            int curInc = currentIncidents.size();
            int prevInc = previousIncidents.size();
            sb.append("Total Incidents / Near Misses," + curInc + "," + prevInc + "," + (curInc - prevInc) + "," + (curInc <= prevInc ? "✅ Safe Zero Incident Goal" : "⚠️ Incident Logged") + "\n\n");
            sb.append("--- CURRENT PERIOD DETAILED AUDIT FINDINGS ---\n");
            sb.append("S.No,SNC Number,Type,Location,Severity,Risk Level,Details,Mandated Corrective Action,In-Charge,Status\n");
            List<Observation> list9 = currentObs;
            int i7 = 0;
            for (Object obj : list9) {
                int i8 = i7 + 1;
                if (i7 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Observation observation = (Observation) obj;
                Iterable iterable5 = list9;
                int curInc2 = curInc;
                sb.append((i7 + 1) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getSncNumber()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getFindingType()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getLocation()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getSeverity()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getRiskLevel()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getIssueDetails()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getSuggestion()) + ",");
                sb.append(INSTANCE.escapeCsv(observation.getResponsiblePerson()) + ",");
                sb.append((observation.isResolved() ? "RESOLVED" : "OPEN") + "\n");
                i7 = i8;
                list9 = iterable5;
                curInc = curInc2;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                byte[] bytes = sb2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                fileOutputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                return true;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean generateSafetyTrainingsCsv(String companyName, List<SafetyTraining> trainings, String monthYearText, File outputFile) {
        StringBuilder sb;
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        Intrinsics.checkNotNullParameter(trainings, "trainings");
        Intrinsics.checkNotNullParameter(monthYearText, "monthYearText");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
            sb = new StringBuilder();
            sb.append("SAFETY TRAINING & COMPETENCY REGISTER\n");
            sb.append("Enterprise: ," + escapeCsv(companyName) + "\n");
        } catch (Exception e) {
            e = e;
        }
        try {
            sb.append("Period: ," + escapeCsv(monthYearText) + "\n");
            sb.append("Generated On: ," + new SimpleDateFormat("dd-MMM-yyyy HH:mm", Locale.getDefault()).format(new Date()) + "\n\n");
            sb.append("S.No,Training Topic,Target Department,Trainer Name,Venue,Date,Attendees Count,Duration (Hours),Total Man-Hours,Evaluation / Status\n");
            int i = 0;
            for (Object obj : trainings) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SafetyTraining safetyTraining = (SafetyTraining) obj;
                sb.append((i + 1) + ",");
                sb.append(INSTANCE.escapeCsv(safetyTraining.getTrainingTopic()) + ",");
                sb.append(INSTANCE.escapeCsv(safetyTraining.getTargetDepartment()) + ",");
                sb.append(INSTANCE.escapeCsv(safetyTraining.getTrainerName()) + ",");
                sb.append(INSTANCE.escapeCsv(safetyTraining.getVenue()) + ",");
                sb.append(INSTANCE.escapeCsv(safetyTraining.getTrainingDate()) + ",");
                sb.append(safetyTraining.getAttendeesCount() + ",");
                sb.append(safetyTraining.getDurationHours() + ",");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(safetyTraining.getManHoursTrained())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                sb.append(format + ",");
                CsvReportGenerator csvReportGenerator = INSTANCE;
                String effectivenessRating = safetyTraining.getEffectivenessRating();
                if (StringsKt.isBlank(effectivenessRating)) {
                    effectivenessRating = "Completed";
                }
                sb.append(csvReportGenerator.escapeCsv(effectivenessRating) + "\n");
                i = i2;
            }
            Iterator<T> it = trainings.iterator();
            int totalPax = 0;
            while (it.hasNext()) {
                totalPax += ((SafetyTraining) it.next()).getAttendeesCount();
            }
            Iterator<T> it2 = trainings.iterator();
            double totalHours = 0.0d;
            while (it2.hasNext()) {
                totalHours += ((SafetyTraining) it2.next()).getManHoursTrained();
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(totalHours)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            sb.append("\nTOTALS,,,,, ," + totalPax + ", ," + format2 + ",COMPLETED SESSIONS: " + trainings.size() + "\n");
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                byte[] bytes = sb2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                fileOutputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                return true;
            } finally {
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return false;
        }
    }

    public final boolean generateIncidentsCsv(String companyName, List<IncidentRecord> incidents, String dateRangeText, File outputFile) {
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        Intrinsics.checkNotNullParameter(incidents, "incidents");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("INCIDENT & NEAR MISS INVESTIGATION LOGBOOK\n");
            sb.append("Enterprise: ," + escapeCsv(companyName) + "\n");
            sb.append("Period: ," + escapeCsv(dateRangeText) + "\n");
            sb.append("Generated On: ," + new SimpleDateFormat("dd-MMM-yyyy HH:mm", Locale.getDefault()).format(new Date()) + "\n\n");
            sb.append("S.No,Incident No,Type,Severity,Date & Time,Location,Department,Injured Person / ID,Body Part Affected,Description,Root Cause,Corrective Action (CAPA),Reportable to Govt,Status\n");
            int i = 0;
            for (Object obj : incidents) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                IncidentRecord incidentRecord = (IncidentRecord) obj;
                sb.append((i + 1) + ",");
                sb.append(INSTANCE.escapeCsv(incidentRecord.getIncidentNumber()) + ",");
                sb.append(INSTANCE.escapeCsv(incidentRecord.getIncidentType()) + ",");
                sb.append(INSTANCE.escapeCsv(incidentRecord.getSeverity()) + ",");
                sb.append(INSTANCE.escapeCsv(incidentRecord.getIncidentDate() + " " + incidentRecord.getIncidentTime()) + ",");
                sb.append(INSTANCE.escapeCsv(incidentRecord.getLocation()) + ",");
                sb.append(INSTANCE.escapeCsv(incidentRecord.getDepartment()) + ",");
                sb.append(INSTANCE.escapeCsv(incidentRecord.getAffectedEmployeeName() + " (" + incidentRecord.getAffectedEmployeeId() + ")") + ",");
                sb.append(INSTANCE.escapeCsv(incidentRecord.getAffectedBodyPart()) + ",");
                sb.append(INSTANCE.escapeCsv(incidentRecord.getDescription()) + ",");
                sb.append(INSTANCE.escapeCsv(incidentRecord.getRootCause()) + ",");
                sb.append(INSTANCE.escapeCsv(incidentRecord.getCorrectiveMeasures()) + ",");
                sb.append((incidentRecord.isReportable() ? "YES (Statutory)" : "NO (Internal)") + ",");
                sb.append(INSTANCE.escapeCsv(incidentRecord.getStatus()) + "\n");
                i = i2;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                byte[] bytes = sb2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                fileOutputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                return true;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final String determineHazardParameter(String issue, String location) {
        Intrinsics.checkNotNullParameter(issue, "issue");
        Intrinsics.checkNotNullParameter(location, "location");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lower = (issue + " " + location).toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
        if (StringsKt.contains$default(lower, "machine", false, 2, (Object) null) || StringsKt.contains$default(lower, "guard", false, 2, (Object) null) || StringsKt.contains$default(lower, "blade", false, 2, (Object) null) || StringsKt.contains$default(lower, "roller", false, 2, (Object) null) || StringsKt.contains$default(lower, "pinch", false, 2, (Object) null)) {
            return "Machinery & Machine Guarding";
        }
        if (StringsKt.contains$default(lower, "electric", false, 2, (Object) null) || StringsKt.contains$default(lower, "wire", false, 2, (Object) null) || StringsKt.contains$default(lower, "socket", false, 2, (Object) null) || StringsKt.contains$default(lower, "panel", false, 2, (Object) null) || StringsKt.contains$default(lower, "cable", false, 2, (Object) null) || StringsKt.contains$default(lower, "earthing", false, 2, (Object) null)) {
            return "Electrical Safety";
        }
        if (StringsKt.contains$default(lower, "chemical", false, 2, (Object) null) || StringsKt.contains$default(lower, "acid", false, 2, (Object) null) || StringsKt.contains$default(lower, "solvent", false, 2, (Object) null) || StringsKt.contains$default(lower, "msds", false, 2, (Object) null) || StringsKt.contains$default(lower, "spill", false, 2, (Object) null) || StringsKt.contains$default(lower, "fume", false, 2, (Object) null)) {
            return "Chemical & HAZMAT Management";
        }
        if (StringsKt.contains$default(lower, "fire", false, 2, (Object) null) || StringsKt.contains$default(lower, "extinguisher", false, 2, (Object) null) || StringsKt.contains$default(lower, "hydrant", false, 2, (Object) null) || StringsKt.contains$default(lower, "exit", false, 2, (Object) null) || StringsKt.contains$default(lower, "smoke", false, 2, (Object) null)) {
            return "Fire Protection & Emergency Exits";
        }
        if (StringsKt.contains$default(lower, "housekeep", false, 2, (Object) null) || StringsKt.contains$default(lower, "floor", false, 2, (Object) null) || StringsKt.contains$default(lower, "aisle", false, 2, (Object) null) || StringsKt.contains$default(lower, "clutter", false, 2, (Object) null) || StringsKt.contains$default(lower, "waste", false, 2, (Object) null) || StringsKt.contains$default(lower, "oil", false, 2, (Object) null)) {
            return "Housekeeping & 5S";
        }
        if (StringsKt.contains$default(lower, "height", false, 2, (Object) null) || StringsKt.contains$default(lower, "ladder", false, 2, (Object) null) || StringsKt.contains$default(lower, "scaffold", false, 2, (Object) null) || StringsKt.contains$default(lower, "roof", false, 2, (Object) null) || StringsKt.contains$default(lower, "fall", false, 2, (Object) null)) {
            return "Working at Heights & Fall Prevention";
        }
        if (StringsKt.contains$default(lower, "ppe", false, 2, (Object) null) || StringsKt.contains$default(lower, "glove", false, 2, (Object) null) || StringsKt.contains$default(lower, "mask", false, 2, (Object) null) || StringsKt.contains$default(lower, "helmet", false, 2, (Object) null) || StringsKt.contains$default(lower, "goggle", false, 2, (Object) null) || StringsKt.contains$default(lower, "shoe", false, 2, (Object) null)) {
            return "Personal Protective Equipment (PPE)";
        }
        if (StringsKt.contains$default(lower, "ergonomic", false, 2, (Object) null) || StringsKt.contains$default(lower, "posture", false, 2, (Object) null) || StringsKt.contains$default(lower, "lifting", false, 2, (Object) null) || StringsKt.contains$default(lower, "chair", false, 2, (Object) null) || StringsKt.contains$default(lower, "lighting", false, 2, (Object) null)) {
            return "Ergonomics & Work Environment";
        }
        return "General Industrial Safety";
    }

    public static /* synthetic */ boolean generateUnifiedMasterCsv$default(CsvReportGenerator csvReportGenerator, String str, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, List list10, List list11, String str2, String str3, File file, int i, Object obj) {
        String str4;
        if ((i & 8192) == 0) {
            str4 = str3;
        } else {
            str4 = "J. VELMURUGAN";
        }
        return csvReportGenerator.generateUnifiedMasterCsv(str, list, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, str2, str4, file);
    }

    public final boolean generateUnifiedMasterCsv(String companyName, List<String> selectedReportKeys, List<Observation> unsafeActObservations, List<Observation> unsafeConditionObservations, List<Observation> safetyStarObservations, List<ResponsiblePerson> rosterList, List<IncidentRecord> incidents, List<SafetyTraining> trainings, List<Observation> currentObs, List<Observation> previousObs, List<IncidentRecord> currentIncidents, List<IncidentRecord> previousIncidents, String dateRangeText, String presenterName, File outputFile) {
        int openObs;
        int closedObs;
        int curClosed;
        int prevClosed;
        String str;
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        Intrinsics.checkNotNullParameter(selectedReportKeys, "selectedReportKeys");
        Intrinsics.checkNotNullParameter(unsafeActObservations, "unsafeActObservations");
        Intrinsics.checkNotNullParameter(unsafeConditionObservations, "unsafeConditionObservations");
        Intrinsics.checkNotNullParameter(safetyStarObservations, "safetyStarObservations");
        Intrinsics.checkNotNullParameter(rosterList, "rosterList");
        Intrinsics.checkNotNullParameter(incidents, "incidents");
        Intrinsics.checkNotNullParameter(trainings, "trainings");
        Intrinsics.checkNotNullParameter(currentObs, "currentObs");
        Intrinsics.checkNotNullParameter(previousObs, "previousObs");
        Intrinsics.checkNotNullParameter(currentIncidents, "currentIncidents");
        Intrinsics.checkNotNullParameter(previousIncidents, "previousIncidents");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(presenterName, "presenterName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
            StringBuilder sb = new StringBuilder();
            String todayStr = new SimpleDateFormat("dd-MMM-yyyy HH:mm", Locale.getDefault()).format(new Date());
            sb.append("VELTRIX SENTINEL SAFETY PORTAL\n");
            sb.append("Safety, Compliance & Sustainability – Managed Right.\n");
            sb.append("COMPREHENSIVE MASTER EHS AUDIT & COMPLIANCE DOSSIER\n");
            sb.append("Company / Facility Unit:," + escapeCsv(companyName) + "\n");
            sb.append("Audit Period:," + escapeCsv(dateRangeText) + "\n");
            sb.append("Lead EHS Auditor:," + escapeCsv(presenterName) + "\n");
            Intrinsics.checkNotNull(todayStr);
            sb.append("Generated Timestamp:," + escapeCsv(todayStr) + "\n\n");
            List allObs = CollectionsKt.plus(CollectionsKt.plus(unsafeActObservations, unsafeConditionObservations), safetyStarObservations);
            int totalObs = allObs.size();
            List list = allObs;
            if ((list instanceof Collection) && list.isEmpty()) {
                openObs = 0;
            } else {
                openObs = 0;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!((Observation) it.next()).isResolved() && (openObs = openObs + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            List list2 = allObs;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                closedObs = 0;
            } else {
                closedObs = 0;
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (((Observation) it2.next()).isResolved() && (closedObs = closedObs + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            int complianceRate = totalObs > 0 ? (int) ((closedObs / totalObs) * 100.0f) : 100;
            sb.append("--- SECTION 1: EXECUTIVE KPI SCORECARD ---\n");
            sb.append("KPI Metric,Value,Status\n");
            sb.append("Total Non-Conformance Observations (SNC)," + totalObs + ",Recorded\n");
            sb.append("Closed / Rectified Actions," + closedObs + ",Verified\n");
            sb.append("Open / Pending Actions," + openObs + ",Pending\n");
            sb.append("Overall Compliance Rate," + complianceRate + "%," + (complianceRate >= 80 ? "Optimal" : "Requires Attention") + "\n");
            sb.append("Total Incidents / Near Misses," + incidents.size() + "," + (incidents.isEmpty() ? "Zero Harm" : "Under CAPA") + "\n");
            int size = trainings.size();
            Iterator<T> it3 = trainings.iterator();
            int i = 0;
            while (it3.hasNext()) {
                i += ((SafetyTraining) it3.next()).getAttendeesCount();
            }
            sb.append("Safety Training Sessions," + size + "," + i + " Staff Trained\n");
            sb.append("Safety Stars Recognitions," + safetyStarObservations.size() + ",Awarded\n\n");
            int curObsSize = currentObs.size();
            int prevObsSize = previousObs.size();
            int curIncSize = currentIncidents.size();
            int prevIncSize = previousIncidents.size();
            List<Observation> list3 = currentObs;
            if ((list3 instanceof Collection) && list3.isEmpty()) {
                curClosed = 0;
            } else {
                curClosed = 0;
                Iterator it4 = list3.iterator();
                while (it4.hasNext()) {
                    if (((Observation) it4.next()).isResolved() && (curClosed = curClosed + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            List<Observation> list4 = previousObs;
            if ((list4 instanceof Collection) && list4.isEmpty()) {
                prevClosed = 0;
            } else {
                prevClosed = 0;
                Iterator it5 = list4.iterator();
                while (it5.hasNext()) {
                    if (((Observation) it5.next()).isResolved() && (prevClosed = prevClosed + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            sb.append("--- SECTION 2: MONTH-OVER-MONTH (MoM) SAFETY PERFORMANCE MATRIX ---\n");
            sb.append("Performance Indicator,Current Period,Previous Period,Variance,Status\n");
            String str2 = "Improved";
            sb.append("Total Observations," + curObsSize + "," + prevObsSize + "," + (curObsSize - prevObsSize) + "," + (curObsSize <= prevObsSize ? "Improved" : "Increased") + "\n");
            int i2 = curClosed - prevClosed;
            if (curClosed < prevClosed) {
                str2 = "Pending";
            }
            sb.append("Closed Actions," + curClosed + "," + prevClosed + "," + i2 + "," + str2 + "\n");
            sb.append("Workplace Incidents," + curIncSize + "," + prevIncSize + "," + (curIncSize - prevIncSize) + "," + (curIncSize <= prevIncSize ? "Safer" : "Elevated") + "\n\n");
            sb.append("--- SECTION 3: INCIDENT & NEAR MISS INVESTIGATION LOG ---\n");
            sb.append("Incident #,Type,Severity,Date & Time,Location,Department,Affected Employee,Body Part,Root Cause,CAPA,Statutory Reportable,Status\n");
            if (incidents.isEmpty()) {
                sb.append("Zero accidents/incidents recorded,,,,,,,,,,,\n");
            } else {
                int i3 = 0;
                for (IncidentRecord incidentRecord : incidents) {
                    int curObsSize2 = curObsSize;
                    int prevObsSize2 = prevObsSize;
                    sb.append(INSTANCE.escapeCsv(incidentRecord.getIncidentNumber()) + ",");
                    sb.append(INSTANCE.escapeCsv(incidentRecord.getIncidentType()) + ",");
                    sb.append(INSTANCE.escapeCsv(incidentRecord.getSeverity()) + ",");
                    int i4 = i3;
                    int curIncSize2 = curIncSize;
                    sb.append(INSTANCE.escapeCsv(incidentRecord.getIncidentDate() + " " + incidentRecord.getIncidentTime()) + ",");
                    sb.append(INSTANCE.escapeCsv(incidentRecord.getLocation()) + ",");
                    sb.append(INSTANCE.escapeCsv(incidentRecord.getDepartment()) + ",");
                    sb.append(INSTANCE.escapeCsv(incidentRecord.getAffectedEmployeeName() + " (" + incidentRecord.getAffectedEmployeeId() + ")") + ",");
                    sb.append(INSTANCE.escapeCsv(incidentRecord.getAffectedBodyPart()) + ",");
                    sb.append(INSTANCE.escapeCsv(incidentRecord.getRootCause()) + ",");
                    sb.append(INSTANCE.escapeCsv(incidentRecord.getCorrectiveMeasures()) + ",");
                    sb.append((incidentRecord.isReportable() ? "YES" : "NO") + ",");
                    sb.append(INSTANCE.escapeCsv(incidentRecord.getStatus()) + "\n");
                    curObsSize = curObsSize2;
                    prevObsSize = prevObsSize2;
                    i3 = i4;
                    curIncSize = curIncSize2;
                }
                Unit unit = Unit.INSTANCE;
            }
            sb.append("\n");
            sb.append("--- SECTION 4: SAFETY TRAININGS & COMPETENCY REGISTER ---\n");
            sb.append("Topic,Category,Date,Trainer,Trainer Type,Venue,Attendees Count,Duration (Hrs),Man-Hours,Pre Score,Post Score,Rating,Status\n");
            if (trainings.isEmpty()) {
                sb.append("No training records logged,,,,,,,,,,,,\n");
            } else {
                int i5 = 0;
                Iterator it6 = trainings.iterator();
                while (it6.hasNext()) {
                    SafetyTraining safetyTraining = (SafetyTraining) it6.next();
                    sb.append(INSTANCE.escapeCsv(safetyTraining.getTrainingTopic()) + ",");
                    sb.append(INSTANCE.escapeCsv(safetyTraining.getTrainingCategory()) + ",");
                    sb.append(INSTANCE.escapeCsv(safetyTraining.getTrainingDate()) + ",");
                    sb.append(INSTANCE.escapeCsv(safetyTraining.getTrainerName()) + ",");
                    sb.append(INSTANCE.escapeCsv(safetyTraining.getTrainerType()) + ",");
                    sb.append(INSTANCE.escapeCsv(safetyTraining.getVenue()) + ",");
                    sb.append(safetyTraining.getAttendeesCount() + ",");
                    sb.append(safetyTraining.getDurationHours() + ",");
                    sb.append(safetyTraining.getManHoursTrained() + ",");
                    sb.append(safetyTraining.getPreAssessmentScoreAvg() + "%,");
                    sb.append(safetyTraining.getPostAssessmentScoreAvg() + "%,");
                    sb.append(INSTANCE.escapeCsv(safetyTraining.getEffectivenessRating()) + ",");
                    sb.append(INSTANCE.escapeCsv(safetyTraining.getStatus()) + "\n");
                    it6 = it6;
                    i5 = i5;
                }
                Unit unit2 = Unit.INSTANCE;
            }
            sb.append("\n");
            sb.append("--- SECTION 5: SAFETY STARS & RECOGNITION ROSTER ---\n");
            sb.append("Safety Champion,Employee ID,Location,Department,Good Practice Details,Award Status\n");
            if (safetyStarObservations.isEmpty()) {
                sb.append("No safety star records logged,,,,,\n");
            } else {
                for (Observation observation : safetyStarObservations) {
                    sb.append(INSTANCE.escapeCsv(observation.getResponsiblePerson()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation.getEmployeeId()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation.getLocation()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation.getDepartment()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation.getIssueDetails()) + ",");
                    sb.append("Awarded\n");
                }
                Unit unit3 = Unit.INSTANCE;
            }
            sb.append("\n");
            sb.append("--- SECTION 6: UNSAFE ACTS (BEHAVIORAL OBSERVATIONS) ---\n");
            sb.append("SNC #,Worker / Responsible,Department,Location,Severity,Unsafe Behavior,Corrective Coaching,Target Date,Status\n");
            String str3 = "RESOLVED";
            if (unsafeActObservations.isEmpty()) {
                sb.append("Zero unsafe acts recorded,,,,,,,,\n");
                str = "RESOLVED";
            } else {
                for (Observation observation2 : unsafeActObservations) {
                    String str4 = str3;
                    sb.append(INSTANCE.escapeCsv(observation2.getSncNumber()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation2.getResponsiblePerson()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation2.getDepartment()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation2.getLocation()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation2.getSeverity()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation2.getIssueDetails()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation2.getSuggestion()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation2.getTargetDate()) + ",");
                    sb.append((observation2.isResolved() ? str4 : "OPEN") + "\n");
                    str3 = str4;
                }
                str = str3;
                Unit unit4 = Unit.INSTANCE;
            }
            sb.append("\n");
            sb.append("--- SECTION 7: UNSAFE CONDITIONS (8 SAFETY PARAMETERS) ---\n");
            sb.append("SNC #,Safety Parameter,Location,Severity,Unsafe Condition Details,Recommendation / CAPA,Responsible Person,Target Date,Status\n");
            if (unsafeConditionObservations.isEmpty()) {
                sb.append("Zero unsafe conditions recorded,,,,,,,,\n");
            } else {
                int i6 = 0;
                for (Observation observation3 : unsafeConditionObservations) {
                    int i7 = i6;
                    String determineHazardParameter = INSTANCE.determineHazardParameter(observation3.getIssueDetails(), observation3.getLocation());
                    sb.append(INSTANCE.escapeCsv(observation3.getSncNumber()) + ",");
                    sb.append(INSTANCE.escapeCsv(determineHazardParameter) + ",");
                    sb.append(INSTANCE.escapeCsv(observation3.getLocation()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation3.getSeverity()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation3.getIssueDetails()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation3.getSuggestion()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation3.getResponsiblePerson()) + ",");
                    sb.append(INSTANCE.escapeCsv(observation3.getTargetDate()) + ",");
                    sb.append((observation3.isResolved() ? str : "OPEN") + "\n");
                    i6 = i7;
                }
                Unit unit5 = Unit.INSTANCE;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                byte[] bytes = sb2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                fileOutputStream.write(bytes);
                Unit unit6 = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                return true;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static /* synthetic */ boolean generateComplianceRegisterCsv$default(CsvReportGenerator csvReportGenerator, String str, List list, String str2, File file, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "Safety Officer";
        }
        return csvReportGenerator.generateComplianceRegisterCsv(str, list, str2, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x018d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0183 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean generateComplianceRegisterCsv(java.lang.String r28, java.util.List<com.example.data.ComplianceItem> r29, java.lang.String r30, java.io.File r31) {
        /*
            Method dump skipped, instructions count: 1446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.CsvReportGenerator.generateComplianceRegisterCsv(java.lang.String, java.util.List, java.lang.String, java.io.File):boolean");
    }
}
