package com.example.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import com.example.data.AmcRecord;
import com.example.data.Company;
import com.example.data.ComplianceItem;
import com.example.data.FireExtinguisher;
import com.example.data.IncidentRecord;
import com.example.data.MaterialFollowUpRecord;
import com.example.data.Observation;
import com.example.data.ResponsiblePerson;
import com.example.data.SafetyTraining;
import com.example.ui.CalendarHolidayEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: SectionReportGenerators.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JÈ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000e2\b\b\u0002\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"J¨\u0001\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\b\b\u0002\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"J>\u0010$\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0002J<\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"JJ\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u00100\u001a\u0002012\u0012\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u000eH\u0002J<\u00103\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"JJ\u00105\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u00100\u001a\u0002012\u0012\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u000eH\u0002J8\u00106\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010-\u001a\u00020.2\u0006\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020.2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0002JJ\u00109\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u00100\u001a\u0002012\u0012\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u000eH\u0002J(\u0010:\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010-\u001a\u00020.2\u0006\u0010;\u001a\u00020,2\u0006\u0010 \u001a\u00020\tH\u0002J>\u0010<\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0002J>\u0010=\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0002J>\u0010?\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0002J>\u0010@\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0002J6\u0010A\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0002J@\u0010C\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010-\u001a\u00020.2\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\tH\u0002J:\u0010I\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010-\u001a\u00020.2\u0006\u0010J\u001a\u00020,2\u0018\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0L0\u000eH\u0002JJ\u0010M\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u00100\u001a\u0002012\u0012\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u000eH\u0002JN\u0010N\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\tH\u0002J \u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\tH\u0002J\u0010\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020.H\u0002J\b\u0010\\\u001a\u00020\tH\u0002J\u0010\u0010]\u001a\u00020\t2\u0006\u0010[\u001a\u00020.H\u0002J\u0010\u0010^\u001a\u00020\t2\u0006\u0010[\u001a\u00020.H\u0002J\b\u0010_\u001a\u00020\tH\u0002J\b\u0010`\u001a\u00020\tH\u0002J\b\u0010a\u001a\u00020\tH\u0002J\b\u0010b\u001a\u00020\tH\u0002J\b\u0010c\u001a\u00020\tH\u0002¨\u0006d"}, d2 = {"Lcom/example/utils/SectionReportGenerators;", "", "<init>", "()V", "generateSectionPdfReport", "", "context", "Landroid/content/Context;", "sectionTitle", "", "company", "Lcom/example/data/Company;", "dateRangeText", "observations", "", "Lcom/example/data/Observation;", "incidents", "Lcom/example/data/IncidentRecord;", "trainings", "Lcom/example/data/SafetyTraining;", "complianceItems", "Lcom/example/data/ComplianceItem;", "personnel", "Lcom/example/data/ResponsiblePerson;", "calendarEvents", "Lcom/example/ui/CalendarHolidayEvent;", "fireExtinguishers", "Lcom/example/data/FireExtinguisher;", "amcRecords", "Lcom/example/data/AmcRecord;", "materialFollowUps", "Lcom/example/data/MaterialFollowUpRecord;", "presenterName", "outputFile", "Ljava/io/File;", "generateSectionPptReport", "generateFireEquipmentPdf", "extinguishers", "generateAmcPdf", "drawAmcTable", "", "canvas", "Landroid/graphics/Canvas;", "startY", "", "pageWidth", "", "headers", "colWidths", "", "rows", "generateMaterialFollowUpPdf", "records", "drawMaterialFollowUpTable", "drawVeltrixSentinelPageHeader", "pageNum", "totalPages", "drawFireTable", "drawFireSignoffFooter", "footerY", "generateIncidentsPdf", "generateCompliancePdf", "items", "generateDueDashboardPdf", "generatePersonnelPdf", "generateCalendarPdf", "events", "drawReportHeader", "title", "subtitle", "unitName", "period", "presenter", "drawKpiCards", "cardY", "kpis", "Lkotlin/Pair;", "drawTable", "generateGenericPpt", "companyName", "dateRange", "kpiSummary", "detailHeader", "sanitize", "text", "addZipEntry", "zos", "Ljava/util/zip/ZipOutputStream;", "path", "content", "buildContentTypesXml", "slideCount", "buildRelsXml", "buildPresentationXml", "buildPresentationRelsXml", "buildSlideMasterXml", "buildSlideLayoutXml", "buildSlideRelsXml", "buildSlideMasterRelsXml", "buildSlideLayoutRelsXml", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class SectionReportGenerators {
    public static final int $stable = 0;
    public static final SectionReportGenerators INSTANCE = new SectionReportGenerators();

    private SectionReportGenerators() {
    }

    public final boolean generateSectionPdfReport(Context context, String sectionTitle, Company company, String dateRangeText, List<Observation> observations, List<IncidentRecord> incidents, List<SafetyTraining> trainings, List<ComplianceItem> complianceItems, List<ResponsiblePerson> personnel, List<CalendarHolidayEvent> calendarEvents, List<FireExtinguisher> fireExtinguishers, List<AmcRecord> amcRecords, List<MaterialFollowUpRecord> materialFollowUps, String presenterName, File outputFile) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sectionTitle, "sectionTitle");
        Intrinsics.checkNotNullParameter(company, "company");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(observations, "observations");
        Intrinsics.checkNotNullParameter(incidents, "incidents");
        Intrinsics.checkNotNullParameter(trainings, "trainings");
        Intrinsics.checkNotNullParameter(complianceItems, "complianceItems");
        Intrinsics.checkNotNullParameter(personnel, "personnel");
        Intrinsics.checkNotNullParameter(calendarEvents, "calendarEvents");
        Intrinsics.checkNotNullParameter(fireExtinguishers, "fireExtinguishers");
        Intrinsics.checkNotNullParameter(amcRecords, "amcRecords");
        Intrinsics.checkNotNullParameter(materialFollowUps, "materialFollowUps");
        Intrinsics.checkNotNullParameter(presenterName, "presenterName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lower = sectionTitle.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
        if (StringsKt.contains$default(lower, "amc", false, 2, (Object) null) || StringsKt.contains$default(lower, "annual maintenance", false, 2, (Object) null)) {
            return generateAmcPdf(context, company, amcRecords, dateRangeText, presenterName, outputFile);
        }
        if (StringsKt.contains$default(lower, "material", false, 2, (Object) null) || StringsKt.contains$default(lower, "service", false, 2, (Object) null) || StringsKt.contains$default(lower, "follow-up", false, 2, (Object) null)) {
            return generateMaterialFollowUpPdf(context, company, materialFollowUps, dateRangeText, presenterName, outputFile);
        }
        if (StringsKt.contains$default(lower, "fire", false, 2, (Object) null) || StringsKt.contains$default(lower, "extinguisher", false, 2, (Object) null)) {
            return generateFireEquipmentPdf(context, company, fireExtinguishers, dateRangeText, presenterName, outputFile);
        }
        if (StringsKt.contains$default(lower, "finding", false, 2, (Object) null) || StringsKt.contains$default(lower, "observation", false, 2, (Object) null)) {
            return PdfReportGenerator.INSTANCE.generatePdfReport(context, company, observations, dateRangeText, presenterName, outputFile);
        }
        if (StringsKt.contains$default(lower, "training", false, 2, (Object) null)) {
            return PdfReportGenerator.INSTANCE.generateSafetyTrainingsPdfReport(context, company.getName(), trainings, dateRangeText, presenterName, outputFile);
        }
        if (StringsKt.contains$default(lower, "incident", false, 2, (Object) null)) {
            return generateIncidentsPdf(context, company, incidents, dateRangeText, presenterName, outputFile);
        }
        if (StringsKt.contains$default(lower, "statutory", false, 2, (Object) null) || StringsKt.contains$default(lower, "compliance", false, 2, (Object) null)) {
            return generateCompliancePdf(context, company, complianceItems, dateRangeText, presenterName, outputFile);
        }
        if (StringsKt.contains$default(lower, "due", false, 2, (Object) null)) {
            return generateDueDashboardPdf(context, company, observations, dateRangeText, presenterName, outputFile);
        }
        if (StringsKt.contains$default(lower, "personnel", false, 2, (Object) null) || StringsKt.contains$default(lower, "unit", false, 2, (Object) null)) {
            return generatePersonnelPdf(context, company, personnel, dateRangeText, presenterName, outputFile);
        }
        if (StringsKt.contains$default(lower, "esg", false, 2, (Object) null) || StringsKt.contains$default(lower, "calendar", false, 2, (Object) null)) {
            return generateCalendarPdf(context, calendarEvents, dateRangeText, presenterName, outputFile);
        }
        return PdfReportGenerator.INSTANCE.generatePdfReport(context, company, observations, dateRangeText, presenterName, outputFile);
    }

    public final boolean generateSectionPptReport(Context context, String sectionTitle, Company company, String dateRangeText, List<Observation> observations, List<IncidentRecord> incidents, List<SafetyTraining> trainings, List<ComplianceItem> complianceItems, List<ResponsiblePerson> personnel, List<CalendarHolidayEvent> calendarEvents, List<FireExtinguisher> fireExtinguishers, String presenterName, File outputFile) {
        int okCount;
        int i;
        int i2;
        int inComp;
        int holidays;
        int overdueCount;
        int resolvedCount;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sectionTitle, "sectionTitle");
        Intrinsics.checkNotNullParameter(company, "company");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(observations, "observations");
        Intrinsics.checkNotNullParameter(incidents, "incidents");
        Intrinsics.checkNotNullParameter(trainings, "trainings");
        Intrinsics.checkNotNullParameter(complianceItems, "complianceItems");
        Intrinsics.checkNotNullParameter(personnel, "personnel");
        Intrinsics.checkNotNullParameter(calendarEvents, "calendarEvents");
        Intrinsics.checkNotNullParameter(fireExtinguishers, "fireExtinguishers");
        Intrinsics.checkNotNullParameter(presenterName, "presenterName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lower = sectionTitle.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
        if (StringsKt.contains$default(lower, "fire", false, 2, (Object) null) || StringsKt.contains$default(lower, "extinguisher", false, 2, (Object) null)) {
            List<FireExtinguisher> list = fireExtinguishers;
            int i3 = 0;
            if ((list instanceof Collection) && list.isEmpty()) {
                okCount = 0;
            } else {
                int i4 = 0;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Iterable iterable = list;
                    int i5 = i3;
                    if (StringsKt.equals(((FireExtinguisher) it.next()).getStatus(), FireEquipmentUtils.STATUS_OK, true)) {
                        i4++;
                        if (i4 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        list = iterable;
                        i3 = i5;
                    } else {
                        list = iterable;
                        i3 = i5;
                    }
                }
                okCount = i4;
            }
            List<FireExtinguisher> list2 = fireExtinguishers;
            int i6 = 0;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                i = 0;
            } else {
                int i7 = 0;
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    Iterable iterable2 = list2;
                    int i8 = i6;
                    int i9 = i7;
                    if (StringsKt.equals(((FireExtinguisher) it2.next()).getStatus(), "Expired", true)) {
                        i7 = i9 + 1;
                        if (i7 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        list2 = iterable2;
                        i6 = i8;
                    } else {
                        list2 = iterable2;
                        i6 = i8;
                        i7 = i9;
                    }
                }
                i = i7;
            }
            int expCount = i;
            List<FireExtinguisher> list3 = fireExtinguishers;
            int i10 = 0;
            if ((list3 instanceof Collection) && list3.isEmpty()) {
                i2 = 0;
            } else {
                int i11 = 0;
                Iterator it3 = list3.iterator();
                while (it3.hasNext()) {
                    Iterable iterable3 = list3;
                    int i12 = i10;
                    int i13 = i11;
                    if (StringsKt.equals(((FireExtinguisher) it3.next()).getStatus(), FireEquipmentUtils.STATUS_EXPIRING_SOON, true)) {
                        int i14 = i13 + 1;
                        if (i14 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        i11 = i14;
                        list3 = iterable3;
                        i10 = i12;
                    } else {
                        list3 = iterable3;
                        i10 = i12;
                        i11 = i13;
                    }
                }
                i2 = i11;
            }
            int dueCount = i2;
            String name = company.getName();
            String str = "Total Units: " + fireExtinguishers.size() + " | Valid & In-Service: " + okCount + " | Expiring Soon: " + dueCount + " | Expired: " + expCount;
            List<FireExtinguisher> list4 = fireExtinguishers;
            int i15 = 0;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            for (FireExtinguisher fireExtinguisher : list4) {
                int expCount2 = expCount;
                int okCount2 = okCount;
                int dueCount2 = dueCount;
                arrayList.add("[" + fireExtinguisher.getFeNo() + "] " + fireExtinguisher.getLocation() + " • " + fireExtinguisher.getTypeAndCapacity() + " • Status: " + fireExtinguisher.getStatus() + " • Refill Due: " + fireExtinguisher.getRefillDueDate() + " • HPT Due: " + fireExtinguisher.getHptDueDate());
                expCount = expCount2;
                okCount = okCount2;
                dueCount = dueCount2;
                name = name;
                list4 = list4;
                i15 = i15;
            }
            return generateGenericPpt("FIRE EXTINGUISHER REGISTER & HPT COMPLIANCE", name, dateRangeText, presenterName, str, "Fire Extinguisher Fleet Status & Spares Tracking", (List) arrayList, outputFile);
        }
        if (StringsKt.contains$default(lower, "finding", false, 2, (Object) null) || StringsKt.contains$default(lower, "observation", false, 2, (Object) null)) {
            return PptReportGenerator.INSTANCE.generatePptReport(context, company, observations, dateRangeText, presenterName, outputFile);
        }
        if (StringsKt.contains$default(lower, "incident", false, 2, (Object) null)) {
            return PptReportGenerator.INSTANCE.generateInjurySummaryPpt(context, company, incidents, company.getName(), outputFile);
        }
        if (StringsKt.contains$default(lower, "training", false, 2, (Object) null)) {
            Iterator<T> it4 = trainings.iterator();
            int i16 = 0;
            while (it4.hasNext()) {
                i16 += ((SafetyTraining) it4.next()).getAttendeesCount();
            }
            int totalAttendees = i16;
            Iterator<T> it5 = trainings.iterator();
            double totalHours = 0.0d;
            while (it5.hasNext()) {
                totalHours += ((SafetyTraining) it5.next()).getManHoursTrained();
            }
            String name2 = company.getName();
            String str2 = "Total Sessions: " + trainings.size() + " | Attendees: " + totalAttendees + " | Man-Hours: " + totalHours;
            List<SafetyTraining> list5 = trainings;
            int i17 = 0;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
            for (SafetyTraining safetyTraining : list5) {
                int totalAttendees2 = totalAttendees;
                arrayList2.add(safetyTraining.getTrainingTopic() + " • Trainer: " + safetyTraining.getTrainerName() + " • Attendees: " + safetyTraining.getAttendeesCount() + " • Date: " + safetyTraining.getTrainingDate());
                list5 = list5;
                i17 = i17;
                totalAttendees = totalAttendees2;
                totalHours = totalHours;
            }
            return generateGenericPpt("SAFETY TRAINING & EDUCATION DOSSIER", name2, dateRangeText, presenterName, str2, "Training Modules & Attendance Log", (List) arrayList2, outputFile);
        }
        if (StringsKt.contains$default(lower, "statutory", false, 2, (Object) null) || StringsKt.contains$default(lower, "compliance", false, 2, (Object) null)) {
            List<ComplianceItem> list6 = complianceItems;
            if ((list6 instanceof Collection) && list6.isEmpty()) {
                inComp = 0;
            } else {
                int i18 = 0;
                for (ComplianceItem complianceItem : list6) {
                    if (StringsKt.equals(complianceItem.getStatus(), "Complied", true) || StringsKt.equals(complianceItem.getStatus(), "Valid", true)) {
                        i18++;
                        if (i18 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                inComp = i18;
            }
            String name3 = company.getName();
            String str3 = "Total Documents: " + complianceItems.size() + " | Valid: " + inComp + " | Critical Pending: " + (complianceItems.size() - inComp);
            List<ComplianceItem> list7 = complianceItems;
            int i19 = 0;
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
            Iterable<ComplianceItem> iterable4 = list7;
            for (ComplianceItem complianceItem2 : iterable4) {
                int inComp2 = inComp;
                arrayList3.add(complianceItem2.getDocumentName() + " • " + complianceItem2.getCategory() + " • Status: " + complianceItem2.getStatus() + " • Valid To: " + complianceItem2.getExpiryDate());
                name3 = name3;
                list7 = list7;
                i19 = i19;
                iterable4 = iterable4;
                inComp = inComp2;
            }
            return generateGenericPpt("STATUTORY COMPLIANCE & LEGAL REGISTER", name3, dateRangeText, presenterName, str3, "Key Statutory Approvals & Consent Orders", (List) arrayList3, outputFile);
        }
        if (StringsKt.contains$default(lower, "due", false, 2, (Object) null)) {
            List<Observation> list8 = observations;
            if ((list8 instanceof Collection) && list8.isEmpty()) {
                overdueCount = 0;
            } else {
                overdueCount = 0;
                for (Observation observation : list8) {
                    if ((DateUtils.INSTANCE.isDateOverdue(observation.getTargetDate()) && !observation.isResolved()) && (overdueCount = overdueCount + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            List<Observation> list9 = observations;
            if ((list9 instanceof Collection) && list9.isEmpty()) {
                resolvedCount = 0;
            } else {
                resolvedCount = 0;
                Iterator it6 = list9.iterator();
                while (it6.hasNext()) {
                    if (((Observation) it6.next()).isResolved() && (resolvedCount = resolvedCount + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            String name4 = company.getName();
            String str4 = "Total Action Items: " + observations.size() + " | Overdue: " + overdueCount + " | Closed: " + resolvedCount;
            List<Observation> list10 = observations;
            int i20 = 0;
            Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list10, 10));
            Iterable<Observation> iterable5 = list10;
            for (Observation observation2 : iterable5) {
                Iterable iterable6 = list10;
                int i21 = i20;
                int overdueCount2 = overdueCount;
                int resolvedCount2 = resolvedCount;
                arrayList4.add("[" + observation2.getSncNumber() + "] " + observation2.getLocation() + " • Severity: " + observation2.getSeverity() + " • Due: " + observation2.getTargetDate() + " • Resolved: " + (observation2.isResolved() ? "YES" : "PENDING"));
                list10 = iterable6;
                i20 = i21;
                overdueCount = overdueCount2;
                resolvedCount = resolvedCount2;
                iterable5 = iterable5;
            }
            return generateGenericPpt("DUE DASHBOARD & OVERDUE ACTION TRACKER", name4, dateRangeText, presenterName, str4, "CAPA Priority Due List", (List) arrayList4, outputFile);
        }
        if (StringsKt.contains$default(lower, "personnel", false, 2, (Object) null) || StringsKt.contains$default(lower, "unit", false, 2, (Object) null)) {
            String name5 = company.getName();
            int size = personnel.size();
            List<ResponsiblePerson> list11 = personnel;
            Collection arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list11, 10));
            Iterator it7 = list11.iterator();
            while (it7.hasNext()) {
                arrayList5.add(((ResponsiblePerson) it7.next()).getDepartment());
            }
            String str5 = "Total Key Plant Contacts: " + size + " | Departments Covered: " + CollectionsKt.distinct((List) arrayList5).size();
            List<ResponsiblePerson> list12 = personnel;
            int i22 = 0;
            Collection arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list12, 10));
            Iterable<ResponsiblePerson> iterable7 = list12;
            int i23 = 0;
            for (ResponsiblePerson responsiblePerson : iterable7) {
                arrayList6.add(responsiblePerson.getName() + " • " + responsiblePerson.getDesignation() + " • Dept: " + responsiblePerson.getDepartment() + " • WhatsApp: " + responsiblePerson.getWhatsappNumber());
                list12 = list12;
                i22 = i22;
                iterable7 = iterable7;
                i23 = i23;
            }
            return generateGenericPpt("UNIT PERSONNEL & RESPONSIBILITIES DIRECTORY", name5, dateRangeText, presenterName, str5, "Safety Incharges & Designated Officers", (List) arrayList6, outputFile);
        }
        if (StringsKt.contains$default(lower, "esg", false, 2, (Object) null) || StringsKt.contains$default(lower, "calendar", false, 2, (Object) null)) {
            List<CalendarHolidayEvent> list13 = calendarEvents;
            if ((list13 instanceof Collection) && list13.isEmpty()) {
                holidays = 0;
            } else {
                int i24 = 0;
                Iterator it8 = list13.iterator();
                while (it8.hasNext()) {
                    if (((CalendarHolidayEvent) it8.next()).isHoliday() && (i24 = i24 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
                holidays = i24;
            }
            String str6 = "Total Observances: " + calendarEvents.size() + " | Public Holidays: " + holidays + " | ESG Days: " + (calendarEvents.size() - holidays);
            List<CalendarHolidayEvent> list14 = calendarEvents;
            int i25 = 0;
            Collection arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list14, 10));
            Iterable<CalendarHolidayEvent> iterable8 = list14;
            for (CalendarHolidayEvent calendarHolidayEvent : iterable8) {
                int holidays2 = holidays;
                Iterable iterable9 = list14;
                arrayList7.add(calendarHolidayEvent.getDateStr() + " • " + calendarHolidayEvent.getTitle() + " (" + calendarHolidayEvent.getCategory() + ") - " + (calendarHolidayEvent.isHoliday() ? "Holiday" : "ESG Awareness"));
                list14 = iterable9;
                iterable8 = iterable8;
                i25 = i25;
                holidays = holidays2;
            }
            return generateGenericPpt("VELTRIX ESG & OBSERVANCES SCHEDULE", "Veltrix Global Sustainability", dateRangeText, presenterName, str6, "2026 Observances & Festival Milestones", (List) arrayList7, outputFile);
        }
        return PptReportGenerator.INSTANCE.generatePptReport(context, company, observations, dateRangeText, presenterName, outputFile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03f8 A[Catch: Exception -> 0x029f, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x029f, blocks: (B:19:0x00a8, B:22:0x0186, B:25:0x0199, B:35:0x02cd, B:84:0x033d, B:107:0x03c9, B:110:0x03f8, B:115:0x040d), top: B:18:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x040d A[Catch: Exception -> 0x029f, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x029f, blocks: (B:19:0x00a8, B:22:0x0186, B:25:0x0199, B:35:0x02cd, B:84:0x033d, B:107:0x03c9, B:110:0x03f8, B:115:0x040d), top: B:18:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x048d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean generateFireEquipmentPdf(android.content.Context r57, com.example.data.Company r58, java.util.List<com.example.data.FireExtinguisher> r59, java.lang.String r60, java.lang.String r61, java.io.File r62) {
        /*
            Method dump skipped, instructions count: 1416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.SectionReportGenerators.generateFireEquipmentPdf(android.content.Context, com.example.data.Company, java.util.List, java.lang.String, java.lang.String, java.io.File):boolean");
    }

    public final boolean generateAmcPdf(Context context, Company company, List<AmcRecord> amcRecords, String dateRangeText, String presenterName, File outputFile) {
        boolean z;
        boolean z2;
        int totalPages;
        int pageNum;
        List rows;
        int i;
        AmcRecord amcRecord;
        Iterable iterable;
        int pageNum2;
        String[] strArr;
        float currentY;
        int pageWidth;
        List headers;
        float[] colWidths;
        int pageNum3;
        int totalPages2;
        String str = presenterName;
        String str2 = "#38BDF8";
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(company, "company");
        Intrinsics.checkNotNullParameter(amcRecords, "amcRecords");
        String str3 = dateRangeText;
        Intrinsics.checkNotNullParameter(str3, "dateRangeText");
        Intrinsics.checkNotNullParameter(str, "presenterName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
            File parentFile = outputFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            PdfDocument doc = new PdfDocument();
            int pageWidth2 = 842;
            List headers2 = CollectionsKt.listOf(new String[]{"S.No", "Equipment Name", "Equipment Type", "Location", "Service Vendor", "Last Service", "Next Due", "Status", "Remarks"});
            float[] colWidths2 = {32.0f, 160.0f, 90.0f, 110.0f, 110.0f, 62.0f, 62.0f, 58.0f, 110.0f};
            int rowsPerPageFirst = 14;
            int totalItems = Math.max(1, amcRecords.size());
            int pageNum4 = 1;
            int totalPages3 = totalItems <= 14 ? 1 : ((((totalItems - 14) + 18) - 1) / 18) + 1;
            if (1 <= totalPages3) {
                int startIndex = 0;
                while (true) {
                    try {
                        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(pageWidth2, 595, pageNum4).create();
                        PdfDocument.Page page = doc.startPage(pageInfo);
                        Canvas canvas = page.getCanvas();
                        Intrinsics.checkNotNull(canvas);
                        String str4 = str2;
                        int rowsPerPageFirst2 = rowsPerPageFirst;
                        int totalItems2 = totalItems;
                        try {
                            drawVeltrixSentinelPageHeader(canvas, pageWidth2, pageNum4, totalPages3, str3, str);
                            int pageNum5 = pageNum4;
                            float currentY2 = 76.0f;
                            if (pageNum5 == 1) {
                                try {
                                    Paint paint = new Paint();
                                    paint.setAntiAlias(true);
                                    paint.setColor(Color.parseColor("#C2185B"));
                                    totalPages = totalPages3;
                                    float letterheadH = 76.0f + 46.0f;
                                    canvas.drawRoundRect(new RectF(24.0f, 76.0f, pageWidth2 - 24.0f, letterheadH), 4.0f, 4.0f, paint);
                                    paint.setColor(Color.parseColor(str4));
                                    canvas.drawRect(24.0f, 76.0f, 30.0f, 76.0f + 46.0f, paint);
                                    Paint lhCompPaint = new Paint();
                                    lhCompPaint.setAntiAlias(true);
                                    lhCompPaint.setTypeface(Typeface.create(Typeface.SERIF, 1));
                                    lhCompPaint.setTextSize(12.0f);
                                    lhCompPaint.setColor(-1);
                                    String name = company.getName();
                                    Locale locale = Locale.getDefault();
                                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                                    String upperCase = name.toUpperCase(locale);
                                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                                    canvas.drawText("FACILITY: " + upperCase, 36.0f, 76.0f + 18.0f, lhCompPaint);
                                    Paint lhAddrPaint = new Paint();
                                    lhAddrPaint.setAntiAlias(true);
                                    lhAddrPaint.setTypeface(Typeface.create(Typeface.SERIF, 0));
                                    lhAddrPaint.setTextSize(8.5f);
                                    lhAddrPaint.setColor(Color.parseColor("#CBD5E1"));
                                    String division = company.getDivision();
                                    if (StringsKt.isBlank(division)) {
                                        division = "Corporate HSE Operations";
                                    }
                                    String divText = division;
                                    String address = company.getAddress();
                                    if (StringsKt.isBlank(address)) {
                                        address = "Industrial Complex, Unit 01";
                                    }
                                    String addrText = address;
                                    canvas.drawText("DIVISION: " + divText + "   |   ADDRESS: " + addrText, 36.0f, 76.0f + 36.0f, lhAddrPaint);
                                    Paint paint2 = new Paint();
                                    paint2.setAntiAlias(true);
                                    paint2.setTypeface(Typeface.create(Typeface.SERIF, 1));
                                    paint2.setTextSize(8.5f);
                                    paint2.setTextAlign(Paint.Align.RIGHT);
                                    paint2.setColor(Color.parseColor(str4));
                                    canvas.drawText("AMC COMPLIANCE REGISTER", pageWidth2 - 36.0f, 76.0f + 20.0f, paint2);
                                    paint2.setColor(Color.parseColor("#94A3B8"));
                                    paint2.setTypeface(Typeface.create(Typeface.SERIF, 0));
                                    canvas.drawText("EQUIPMENT MAINTENANCE & SERVICE DUE LOG", pageWidth2 - 36.0f, 76.0f + 36.0f, paint2);
                                    float currentY3 = 76.0f + 46.0f + 10.0f;
                                    Paint paint3 = new Paint();
                                    paint3.setAntiAlias(true);
                                    paint3.setTypeface(Typeface.create(Typeface.SERIF, 1));
                                    paint3.setTextSize(13.0f);
                                    paint3.setTextAlign(Paint.Align.CENTER);
                                    paint3.setColor(Color.parseColor("#880E4F"));
                                    canvas.drawText("ANNUAL MAINTENANCE CONTRACT (AMC) REGISTER", pageWidth2 / 2.0f, currentY3 + 12.0f, paint3);
                                    Paint paint4 = new Paint();
                                    paint4.setAntiAlias(true);
                                    paint4.setTypeface(Typeface.create(Typeface.SERIF, 2));
                                    paint4.setTextSize(8.5f);
                                    paint4.setTextAlign(Paint.Align.CENTER);
                                    paint4.setColor(Color.parseColor("#64748B"));
                                    canvas.drawText("Periodic Service Tracking for Fire Alarm, Smoke Detectors, Hydrants & Hose Reels", pageWidth2 / 2.0f, currentY3 + 24.0f, paint4);
                                    currentY2 = currentY3 + 32.0f;
                                } catch (Exception e) {
                                    e = e;
                                    z = false;
                                    e.printStackTrace();
                                    return z;
                                }
                            } else {
                                totalPages = totalPages3;
                            }
                            int pageSize = pageNum5 == 1 ? rowsPerPageFirst2 : 18;
                            try {
                                Iterable pageItems = CollectionsKt.take(CollectionsKt.drop(amcRecords, startIndex), pageSize);
                                startIndex += pageSize;
                                if (amcRecords.isEmpty()) {
                                    pageNum = pageNum5;
                                    rows = CollectionsKt.listOf(CollectionsKt.listOf(new String[]{"1", "No AMC Records Registered", "-", "Main Facility", "-", "-", "-", AmcTrackerUtils.STATUS_ACTIVE, "Nil"}));
                                    z = false;
                                    z2 = true;
                                } else {
                                    Iterable iterable2 = pageItems;
                                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                                    Iterable iterable3 = iterable2;
                                    int i2 = 0;
                                    for (Object obj : iterable3) {
                                        try {
                                            i = i2 + 1;
                                            if (i2 < 0) {
                                                CollectionsKt.throwIndexOverflow();
                                            }
                                            amcRecord = (AmcRecord) obj;
                                            iterable = iterable3;
                                            pageNum2 = pageNum5;
                                            strArr = new String[9];
                                            z = false;
                                        } catch (Exception e2) {
                                            e = e2;
                                            z = false;
                                        }
                                        try {
                                            strArr[0] = String.valueOf(((pageNum2 - 1) * rowsPerPageFirst2) + i2 + 1);
                                            strArr[1] = amcRecord.getEquipmentName();
                                            strArr[2] = amcRecord.getEquipmentType();
                                            strArr[3] = amcRecord.getLocation();
                                            strArr[4] = amcRecord.getVendor();
                                            String lastServiceDate = amcRecord.getLastServiceDate();
                                            if (StringsKt.isBlank(lastServiceDate)) {
                                                lastServiceDate = "-";
                                            }
                                            strArr[5] = lastServiceDate;
                                            String nextServiceDueDate = amcRecord.getNextServiceDueDate();
                                            if (StringsKt.isBlank(nextServiceDueDate)) {
                                                nextServiceDueDate = "-";
                                            }
                                            strArr[6] = nextServiceDueDate;
                                            strArr[7] = amcRecord.getStatus();
                                            String remarks = amcRecord.getRemarks();
                                            if (StringsKt.isBlank(remarks)) {
                                                remarks = "In Service";
                                            }
                                            strArr[8] = remarks;
                                            arrayList.add(CollectionsKt.listOf(strArr));
                                            pageNum5 = pageNum2;
                                            i2 = i;
                                            iterable3 = iterable;
                                        } catch (Exception e3) {
                                            e = e3;
                                            e.printStackTrace();
                                            return z;
                                        }
                                    }
                                    pageNum = pageNum5;
                                    z = false;
                                    z2 = true;
                                    try {
                                        rows = (List) arrayList;
                                    } catch (Exception e4) {
                                        e = e4;
                                        e.printStackTrace();
                                        return z;
                                    }
                                }
                                currentY = currentY2;
                                pageWidth = pageWidth2;
                                headers = headers2;
                                colWidths = colWidths2;
                                pageNum3 = pageNum;
                                totalPages2 = totalPages;
                            } catch (Exception e5) {
                                e = e5;
                                z = false;
                            }
                            try {
                                drawAmcTable(canvas, currentY, pageWidth, headers, colWidths, rows);
                                pageWidth2 = pageWidth;
                                if (pageNum3 == totalPages2) {
                                    try {
                                        drawFireSignoffFooter(canvas, pageWidth2, 595 - 34.0f, presenterName);
                                    } catch (Exception e6) {
                                        e = e6;
                                        e.printStackTrace();
                                        return z;
                                    }
                                }
                                doc.finishPage(page);
                                if (pageNum3 == totalPages2) {
                                    break;
                                }
                                pageNum4 = pageNum3 + 1;
                                str = presenterName;
                                headers2 = headers;
                                colWidths2 = colWidths;
                                totalPages3 = totalPages2;
                                rowsPerPageFirst = rowsPerPageFirst2;
                                totalItems = totalItems2;
                                str2 = str4;
                                str3 = dateRangeText;
                            } catch (Exception e7) {
                                e = e7;
                                e.printStackTrace();
                                return z;
                            }
                        } catch (Exception e8) {
                            e = e8;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        z = false;
                    }
                }
            } else {
                z = false;
                z2 = true;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                doc.writeTo(fileOutputStream);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                doc.close();
                return z2;
            } finally {
            }
        } catch (Exception e10) {
            e = e10;
            z = false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0223, code lost:
    
        if (r2.length() <= r3) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0225, code lost:
    
        r4 = kotlin.text.StringsKt.take(r2, r3 - 2) + "..";
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0240, code lost:
    
        r0.drawText(r4, r1, r27 + 12.5f, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x023f, code lost:
    
        r4 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void drawAmcTable(android.graphics.Canvas r41, float r42, int r43, java.util.List<java.lang.String> r44, float[] r45, java.util.List<? extends java.util.List<java.lang.String>> r46) {
        /*
            Method dump skipped, instructions count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.SectionReportGenerators.drawAmcTable(android.graphics.Canvas, float, int, java.util.List, float[], java.util.List):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean generateMaterialFollowUpPdf(Context context, Company company, List<MaterialFollowUpRecord> records, String dateRangeText, String presenterName, File outputFile) {
        boolean z;
        int totalPages;
        String str;
        int startIndex;
        int i;
        List rows;
        Iterable iterable;
        int i2;
        String str2;
        Object[] objArr;
        int openCount;
        int i3;
        int i4;
        String str3 = presenterName;
        String str4 = "#C2185B";
        Intrinsics.checkNotNullParameter(context, "context");
        Company company2 = company;
        Intrinsics.checkNotNullParameter(company2, "company");
        Intrinsics.checkNotNullParameter(records, "records");
        String str5 = dateRangeText;
        Intrinsics.checkNotNullParameter(str5, "dateRangeText");
        Intrinsics.checkNotNullParameter(str3, "presenterName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
            File parentFile = outputFile.getParentFile();
            if (parentFile != null) {
                Boolean.valueOf(parentFile.mkdirs());
            }
            PdfDocument doc = new PdfDocument();
            int pageWidth = 842;
            int totalItems = records.size();
            int totalPages2 = totalItems <= 13 ? 1 : RangesKt.coerceAtLeast((((totalItems - 13) + 18) - 1) / 18, 1) + 1;
            int totalItems2 = 1;
            List headers = CollectionsKt.listOf(new String[]{"S.No", "Material / Service", "Category", "Vendor / Provider", "Responsible", "Due Date", "Priority", "Status", "Reminder", "Remarks"});
            float[] colWidths = {28.0f, 125.0f, 95.0f, 95.0f, 75.0f, 65.0f, 55.0f, 56.0f, 80.0f, 120.0f};
            int startIndex2 = 0;
            int pageNum = 1;
            if (1 <= totalPages2) {
                while (true) {
                    try {
                        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(pageWidth, 595, pageNum).create();
                        PdfDocument.Page page = doc.startPage(pageInfo);
                        Canvas canvas = page.getCanvas();
                        Intrinsics.checkNotNull(canvas);
                        String str6 = str4;
                        int startIndex3 = startIndex2;
                        int i5 = totalItems2;
                        int totalItems3 = totalItems;
                        try {
                            drawVeltrixSentinelPageHeader(canvas, pageWidth, pageNum, totalPages2, str5, str3);
                            int pageNum2 = pageNum;
                            float currentY = 76.0f;
                            String str7 = MaterialFollowUpUtils.STATUS_OPEN;
                            if (pageNum2 == i5) {
                                float tableWidth = pageWidth - 48.0f;
                                try {
                                    totalPages = totalPages2;
                                    float letterheadH = tableWidth + 24.0f;
                                    RectF letterheadRect = new RectF(24.0f, 76.0f, letterheadH, 76.0f + 46.0f);
                                    Paint lhBgPaint = new Paint();
                                    lhBgPaint.setAntiAlias(true);
                                    lhBgPaint.setColor(Color.parseColor(str6));
                                    canvas.drawRoundRect(letterheadRect, 6.0f, 6.0f, lhBgPaint);
                                    Paint lhBorderPaint = new Paint();
                                    lhBorderPaint.setAntiAlias(true);
                                    lhBorderPaint.setStyle(Paint.Style.STROKE);
                                    lhBorderPaint.setStrokeWidth(1.5f);
                                    lhBorderPaint.setColor(Color.parseColor("#D97706"));
                                    canvas.drawRoundRect(letterheadRect, 6.0f, 6.0f, lhBorderPaint);
                                    Paint paint = new Paint();
                                    paint.setAntiAlias(true);
                                    paint.setTypeface(Typeface.create(Typeface.SERIF, 1));
                                    paint.setTextSize(13.5f);
                                    paint.setColor(Color.parseColor("#FACC15"));
                                    String name = company2.getName();
                                    Locale locale = Locale.getDefault();
                                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                                    String upperCase = name.toUpperCase(locale);
                                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                                    canvas.drawText(upperCase, 36.0f, 76.0f + 20.0f, paint);
                                    Paint lhAddrPaint = new Paint();
                                    lhAddrPaint.setAntiAlias(true);
                                    lhAddrPaint.setTypeface(Typeface.create(Typeface.SERIF, 0));
                                    lhAddrPaint.setTextSize(8.5f);
                                    lhAddrPaint.setColor(Color.parseColor("#E2E8F0"));
                                    String divText = !StringsKt.isBlank(company2.getDivision()) ? "Division: " + company2.getDivision() + "  •  " : "";
                                    String addrText = StringsKt.isBlank(company2.getAddress()) ? "" : "Unit Address: " + company2.getAddress() + "  •  ";
                                    canvas.drawText(divText + addrText + "Official Materials & Services Follow-up Register", 36.0f, 76.0f + 35.0f, lhAddrPaint);
                                    float currentY2 = 76.0f + 46.0f + 10.0f;
                                    Paint titlePaint = new Paint();
                                    titlePaint.setAntiAlias(true);
                                    titlePaint.setTypeface(Typeface.create(Typeface.SERIF, 1));
                                    titlePaint.setTextSize(13.0f);
                                    titlePaint.setColor(Color.parseColor(str6));
                                    canvas.drawText("MATERIALS & SERVICES FOLLOW-UP REGISTER", 24.0f, currentY2 + 12.0f, titlePaint);
                                    List<MaterialFollowUpRecord> list = records;
                                    int i6 = 0;
                                    if ((list instanceof Collection) && list.isEmpty()) {
                                        openCount = 0;
                                    } else {
                                        openCount = 0;
                                        Iterator it = list.iterator();
                                        while (it.hasNext()) {
                                            Iterable iterable2 = list;
                                            int i7 = i6;
                                            if (StringsKt.equals(((MaterialFollowUpRecord) it.next()).getStatus(), MaterialFollowUpUtils.STATUS_OPEN, true)) {
                                                openCount++;
                                                if (openCount < 0) {
                                                    CollectionsKt.throwCountOverflow();
                                                }
                                                list = iterable2;
                                                i6 = i7;
                                            } else {
                                                list = iterable2;
                                                i6 = i7;
                                            }
                                        }
                                    }
                                    List<MaterialFollowUpRecord> list2 = records;
                                    if ((list2 instanceof Collection) && list2.isEmpty()) {
                                        i3 = 0;
                                    } else {
                                        int i8 = 0;
                                        Iterator it2 = list2.iterator();
                                        while (it2.hasNext()) {
                                            Iterable iterable3 = list2;
                                            int i9 = i8;
                                            String addrText2 = addrText;
                                            if (StringsKt.equals(((MaterialFollowUpRecord) it2.next()).getStatus(), MaterialFollowUpUtils.STATUS_IN_PROGRESS, true)) {
                                                i8 = i9 + 1;
                                                if (i8 < 0) {
                                                    CollectionsKt.throwCountOverflow();
                                                }
                                                list2 = iterable3;
                                                addrText = addrText2;
                                            } else {
                                                list2 = iterable3;
                                                i8 = i9;
                                                addrText = addrText2;
                                            }
                                        }
                                        i3 = i8;
                                    }
                                    int inProgressCount = i3;
                                    List<MaterialFollowUpRecord> list3 = records;
                                    if ((list3 instanceof Collection) && list3.isEmpty()) {
                                        str = MaterialFollowUpUtils.STATUS_OPEN;
                                        i4 = 0;
                                    } else {
                                        int i10 = 0;
                                        Iterator it3 = list3.iterator();
                                        while (it3.hasNext()) {
                                            Iterable iterable4 = list3;
                                            int i11 = i10;
                                            String str8 = str7;
                                            if (StringsKt.equals(((MaterialFollowUpRecord) it3.next()).getStatus(), MaterialFollowUpUtils.STATUS_CLOSED, true)) {
                                                i10 = i11 + 1;
                                                if (i10 < 0) {
                                                    CollectionsKt.throwCountOverflow();
                                                }
                                                list3 = iterable4;
                                                str7 = str8;
                                            } else {
                                                list3 = iterable4;
                                                i10 = i11;
                                                str7 = str8;
                                            }
                                        }
                                        i4 = i10;
                                        str = str7;
                                    }
                                    int closedCount = i4;
                                    Paint paint2 = new Paint();
                                    paint2.setAntiAlias(true);
                                    paint2.setTypeface(Typeface.create(Typeface.SERIF, 0));
                                    paint2.setTextSize(8.5f);
                                    paint2.setColor(Color.parseColor("#475569"));
                                    canvas.drawText("Total Items: " + records.size() + "   |   Open: " + openCount + "   |   In Progress: " + inProgressCount + "   |   Closed: " + closedCount, (pageWidth - 24.0f) - 300.0f, currentY2 + 12.0f, paint2);
                                    currentY = currentY2 + 26.0f;
                                } catch (Exception e) {
                                    e = e;
                                    z = false;
                                    e.printStackTrace();
                                    return z;
                                }
                            } else {
                                totalPages = totalPages2;
                                str = MaterialFollowUpUtils.STATUS_OPEN;
                            }
                            int pageSize = pageNum2 == 1 ? 13 : 18;
                            try {
                                Iterable pageItems = CollectionsKt.take(CollectionsKt.drop(records, startIndex3), pageSize);
                                int startIndex4 = startIndex3 + pageSize;
                                if (records.isEmpty()) {
                                    startIndex = startIndex4;
                                    rows = CollectionsKt.listOf(CollectionsKt.listOf(new String[]{"1", "No Materials/Services Logged", "-", "-", "-", "-", MaterialFollowUpUtils.PRIORITY_MEDIUM, str, MaterialFollowUpUtils.FREQ_ONCE, "Nil"}));
                                    z = false;
                                    i = 1;
                                } else {
                                    Iterable iterable5 = pageItems;
                                    startIndex = startIndex4;
                                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable5, 10));
                                    Iterable iterable6 = iterable5;
                                    int i12 = 0;
                                    int i13 = 0;
                                    for (Object obj : iterable6) {
                                        try {
                                            int i14 = i13 + 1;
                                            if (i13 < 0) {
                                                CollectionsKt.throwIndexOverflow();
                                            }
                                            MaterialFollowUpRecord materialFollowUpRecord = (MaterialFollowUpRecord) obj;
                                            if (!materialFollowUpRecord.isReminderEnabled()) {
                                                iterable = iterable6;
                                                i2 = i12;
                                                str2 = "Disabled";
                                            } else if (materialFollowUpRecord.getRepeatUntilClosed()) {
                                                iterable = iterable6;
                                                i2 = i12;
                                                str2 = materialFollowUpRecord.getReminderFrequency() + " (Recurring)";
                                            } else {
                                                iterable = iterable6;
                                                i2 = i12;
                                                str2 = materialFollowUpRecord.getReminderFrequency();
                                            }
                                            String str9 = str2;
                                            Object[] objArr2 = new String[10];
                                            z = false;
                                            try {
                                                objArr2[0] = String.valueOf(((pageNum2 - 1) * 13) + i13 + 1);
                                                objArr2[1] = materialFollowUpRecord.getTitle();
                                                objArr2[2] = materialFollowUpRecord.getCategory();
                                                String vendor = materialFollowUpRecord.getVendor();
                                                if (StringsKt.isBlank(vendor)) {
                                                    vendor = "-";
                                                }
                                                objArr2[3] = vendor;
                                                String responsiblePerson = materialFollowUpRecord.getResponsiblePerson();
                                                if (StringsKt.isBlank(responsiblePerson)) {
                                                    responsiblePerson = "-";
                                                }
                                                objArr2[4] = responsiblePerson;
                                                String dueDate = materialFollowUpRecord.getDueDate();
                                                if (StringsKt.isBlank(dueDate)) {
                                                    dueDate = "-";
                                                }
                                                objArr2[5] = dueDate;
                                                objArr2[6] = materialFollowUpRecord.getPriority();
                                                objArr2[7] = materialFollowUpRecord.getStatus();
                                                objArr2[8] = str9;
                                                String remarks = materialFollowUpRecord.getRemarks();
                                                if (StringsKt.isBlank(remarks)) {
                                                    objArr = objArr2;
                                                    remarks = StringsKt.take(materialFollowUpRecord.getDescription(), 30);
                                                } else {
                                                    objArr = objArr2;
                                                }
                                                String str10 = remarks;
                                                if (StringsKt.isBlank(str10)) {
                                                    str10 = "-";
                                                }
                                                objArr[9] = str10;
                                                arrayList.add(CollectionsKt.listOf(objArr));
                                                i13 = i14;
                                                iterable6 = iterable;
                                                i12 = i2;
                                            } catch (Exception e2) {
                                                e = e2;
                                                e.printStackTrace();
                                                return z;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            z = false;
                                        }
                                    }
                                    z = false;
                                    i = 1;
                                    try {
                                        rows = (List) arrayList;
                                    } catch (Exception e4) {
                                        e = e4;
                                        e.printStackTrace();
                                        return z;
                                    }
                                }
                                float currentY3 = currentY;
                                int pageWidth2 = pageWidth;
                                List headers2 = headers;
                                float[] colWidths2 = colWidths;
                                int totalPages3 = totalPages;
                                try {
                                    drawMaterialFollowUpTable(canvas, currentY3, pageWidth2, headers2, colWidths2, rows);
                                    pageWidth = pageWidth2;
                                    if (pageNum2 == totalPages3) {
                                        try {
                                            drawFireSignoffFooter(canvas, pageWidth, 595 - 34.0f, presenterName);
                                        } catch (Exception e5) {
                                            e = e5;
                                            e.printStackTrace();
                                            return z;
                                        }
                                    }
                                    doc.finishPage(page);
                                    if (pageNum2 == totalPages3) {
                                        break;
                                    }
                                    pageNum = pageNum2 + 1;
                                    str3 = presenterName;
                                    headers = headers2;
                                    colWidths = colWidths2;
                                    totalPages2 = totalPages3;
                                    totalItems = totalItems3;
                                    str4 = str6;
                                    totalItems2 = i;
                                    startIndex2 = startIndex;
                                    company2 = company;
                                    str5 = dateRangeText;
                                } catch (Exception e6) {
                                    e = e6;
                                    e.printStackTrace();
                                    return z;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                z = false;
                            }
                        } catch (Exception e8) {
                            e = e8;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        z = false;
                    }
                }
            } else {
                z = false;
                i = 1;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                doc.writeTo(fileOutputStream);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                doc.close();
                return i;
            } finally {
            }
        } catch (Exception e10) {
            e = e10;
            z = false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0365, code lost:
    
        if (r13.length() <= r1) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0367, code lost:
    
        r2 = kotlin.text.StringsKt.take(r13, r1 - 2) + "..";
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0382, code lost:
    
        r0.drawText(r2, r34 + 4.0f, r41 + 13.5f, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0381, code lost:
    
        r2 = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void drawMaterialFollowUpTable(android.graphics.Canvas r50, float r51, int r52, java.util.List<java.lang.String> r53, float[] r54, java.util.List<? extends java.util.List<java.lang.String>> r55) {
        /*
            Method dump skipped, instructions count: 1030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.SectionReportGenerators.drawMaterialFollowUpTable(android.graphics.Canvas, float, int, java.util.List, float[], java.util.List):void");
    }

    private final void drawVeltrixSentinelPageHeader(Canvas canvas, int pageWidth, int pageNum, int totalPages, String dateRangeText, String presenterName) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setTypeface(Typeface.create(Typeface.SERIF, 1));
        paint.setColor(Color.parseColor("#880E4F"));
        canvas.drawRect(0.0f, 0.0f, pageWidth, 66.0f, paint);
        paint2.setColor(Color.parseColor("#FACC15"));
        paint2.setTextSize(14.0f);
        paint2.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("VELTRIX SENTINEL", 24.0f, 25.0f, paint2);
        paint2.setColor(Color.parseColor("#93C5FD"));
        paint2.setTextSize(8.5f);
        paint2.setTypeface(Typeface.create(Typeface.SERIF, 0));
        canvas.drawText("Operational HSE & Industrial Loss Prevention Management System", 24.0f, 41.0f, paint2);
        paint2.setColor(Color.parseColor("#CBD5E1"));
        paint2.setTextSize(7.5f);
        canvas.drawText("Life Safety & Industrial Fire Protection Assurance Record", 24.0f, 55.0f, paint2);
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setTypeface(Typeface.create(Typeface.SERIF, 1));
        paint3.setTextAlign(Paint.Align.RIGHT);
        paint3.setTextSize(9.0f);
        paint3.setColor(Color.parseColor("#38BDF8"));
        canvas.drawText("PERIOD: " + dateRangeText, pageWidth - 24.0f, 25.0f, paint3);
        paint3.setTypeface(Typeface.create(Typeface.SERIF, 0));
        paint3.setColor(-1);
        paint3.setTextSize(8.0f);
        canvas.drawText("LEAD AUDITOR: " + presenterName + "  |  PAGE " + pageNum + " OF " + totalPages, pageWidth - 24.0f, 42.0f, paint3);
        paint.setColor(Color.parseColor("#F59E0B"));
        canvas.drawRect(0.0f, 66.0f, pageWidth, 69.0f, paint);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void drawFireTable(android.graphics.Canvas r40, float r41, int r42, java.util.List<java.lang.String> r43, float[] r44, java.util.List<? extends java.util.List<java.lang.String>> r45) {
        /*
            Method dump skipped, instructions count: 647
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.SectionReportGenerators.drawFireTable(android.graphics.Canvas, float, int, java.util.List, float[], java.util.List):void");
    }

    private final void drawFireSignoffFooter(Canvas canvas, int pageWidth, float footerY, String presenterName) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTypeface(Typeface.create(Typeface.SERIF, 0));
        paint.setTextSize(8.0f);
        paint.setColor(Color.parseColor("#64748B"));
        Paint boldPaint = new Paint();
        boldPaint.setAntiAlias(true);
        boldPaint.setTypeface(Typeface.create(Typeface.SERIF, 1));
        boldPaint.setTextSize(8.0f);
        boldPaint.setColor(Color.parseColor("#C2185B"));
        canvas.drawText("Certified that all listed fire extinguishers have been physically inspected per NFPA 10 / IS 2190 standards.", 24.0f, footerY, paint);
        canvas.drawText("EHS Head Sign-off: ___________________    |   Inspector / Auditor: " + presenterName, pageWidth - 420.0f, footerY, boldPaint);
    }

    private final boolean generateIncidentsPdf(Context context, Company company, List<IncidentRecord> incidents, String dateRangeText, String presenterName, File outputFile) {
        boolean z;
        PdfDocument pdfDocument;
        int i;
        int i2;
        Canvas canvas;
        boolean z2;
        ArrayList arrayList;
        Object[] objArr;
        List<Pair<String, String>> list;
        Canvas canvas2;
        try {
            pdfDocument = new PdfDocument();
            PdfDocument.Page startPage = pdfDocument.startPage(new PdfDocument.PageInfo.Builder(842, 595, 1).create());
            Canvas canvas3 = startPage.getCanvas();
            Intrinsics.checkNotNull(canvas3);
            drawReportHeader(canvas3, 842, "INCIDENT MANAGEMENT & ACCIDENT REGISTER", "Lost Time Injuries (LTI), Medical Treatment, First Aid & Near Miss Logs", company.getName(), dateRangeText, presenterName);
            List<IncidentRecord> list2 = incidents;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                i = 0;
            } else {
                i = 0;
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (((IncidentRecord) it.next()).isReportable() && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            int i3 = i;
            List<IncidentRecord> list3 = incidents;
            if ((list3 instanceof Collection) && list3.isEmpty()) {
                i2 = 0;
                z = false;
            } else {
                i2 = 0;
                Iterator<T> it2 = list3.iterator();
                while (it2.hasNext()) {
                    try {
                        z = false;
                    } catch (Exception e) {
                        e = e;
                        z = false;
                        e.printStackTrace();
                        return z;
                    }
                    try {
                        List<IncidentRecord> list4 = list3;
                        if (StringsKt.contains(((IncidentRecord) it2.next()).getIncidentType(), "Near Miss", true)) {
                            i2++;
                            if (i2 < 0) {
                                CollectionsKt.throwCountOverflow();
                            }
                            list3 = list4;
                        } else {
                            list3 = list4;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        return z;
                    }
                }
                z = false;
            }
            int i4 = i2;
            int size = incidents.size() - i3;
            Iterator<T> it3 = incidents.iterator();
            int i5 = z ? 1 : 0;
            while (it3.hasNext()) {
                i5 += ((IncidentRecord) it3.next()).getLostDays();
            }
            int i6 = i5;
            Pair[] pairArr = new Pair[5];
            pairArr[z ? 1 : 0] = new Pair("TOTAL INCIDENTS", String.valueOf(incidents.size()));
            pairArr[1] = new Pair("REPORTABLE LTIs", String.valueOf(i3));
            pairArr[2] = new Pair("NON-REPORTABLE", String.valueOf(size));
            pairArr[3] = new Pair("NEAR MISSES", String.valueOf(i4));
            pairArr[4] = new Pair("TOTAL DAYS LOST", i6 + " Days");
            List<Pair<String, String>> listOf = CollectionsKt.listOf(pairArr);
            drawKpiCards(canvas3, 842, 78.0f, listOf);
            String[] strArr = new String[8];
            strArr[z ? 1 : 0] = "Ref #";
            strArr[1] = "Date";
            strArr[2] = "Classification";
            strArr[3] = "Department";
            strArr[4] = "Injured Person";
            strArr[5] = "Injury / Part";
            strArr[6] = "Severity";
            strArr[7] = "Status";
            List<String> listOf2 = CollectionsKt.listOf(strArr);
            float[] fArr = {60.0f, 75.0f, 100.0f, 100.0f, 110.0f, 130.0f, 100.0f, 119.0f};
            if (incidents.isEmpty()) {
                String[] strArr2 = new String[8];
                strArr2[z ? 1 : 0] = "N/A";
                strArr2[1] = dateRangeText;
                strArr2[2] = "Zero Incidents";
                strArr2[3] = "All Units";
                strArr2[4] = "None";
                strArr2[5] = "Zero Injuries Reported (100% Safe)";
                strArr2[6] = "Safe";
                strArr2[7] = MaterialFollowUpUtils.STATUS_CLOSED;
                arrayList = CollectionsKt.listOf(CollectionsKt.listOf(strArr2));
                canvas = canvas3;
                z2 = true;
            } else {
                List<IncidentRecord> list5 = incidents;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                for (IncidentRecord incidentRecord : list5) {
                    List<IncidentRecord> list6 = list5;
                    int i7 = i4;
                    String[] strArr3 = new String[8];
                    String incidentNumber = incidentRecord.getIncidentNumber();
                    if (StringsKt.isBlank(incidentNumber)) {
                        objArr = strArr3;
                        list = listOf;
                        canvas2 = canvas3;
                        incidentNumber = "INC-" + incidentRecord.getId();
                    } else {
                        objArr = strArr3;
                        list = listOf;
                        canvas2 = canvas3;
                    }
                    objArr[z ? 1 : 0] = incidentNumber;
                    objArr[1] = incidentRecord.getIncidentDate();
                    String incidentType = incidentRecord.getIncidentType();
                    if (StringsKt.isBlank(incidentType)) {
                        incidentType = "Unspecified";
                    }
                    objArr[2] = incidentType;
                    String department = incidentRecord.getDepartment();
                    if (StringsKt.isBlank(department)) {
                        department = "Plant Wide";
                    }
                    objArr[3] = department;
                    String affectedEmployeeName = incidentRecord.getAffectedEmployeeName();
                    if (StringsKt.isBlank(affectedEmployeeName)) {
                        affectedEmployeeName = "N/A";
                    }
                    objArr[4] = affectedEmployeeName;
                    String injuryType = incidentRecord.getInjuryType();
                    if (StringsKt.isBlank(injuryType)) {
                        injuryType = "No physical injury";
                    }
                    String affectedBodyPart = incidentRecord.getAffectedBodyPart();
                    if (StringsKt.isBlank(affectedBodyPart)) {
                        affectedBodyPart = "N/A";
                    }
                    objArr[5] = ((Object) injuryType) + " (" + ((Object) affectedBodyPart) + ")";
                    String severity = incidentRecord.getSeverity();
                    if (StringsKt.isBlank(severity)) {
                        severity = MaterialFollowUpUtils.PRIORITY_LOW;
                    }
                    objArr[6] = severity;
                    objArr[7] = incidentRecord.isReportable() ? "REPORTABLE" : "Resolved";
                    arrayList2.add(CollectionsKt.listOf(objArr));
                    i4 = i7;
                    list5 = list6;
                    listOf = list;
                    canvas3 = canvas2;
                }
                canvas = canvas3;
                z2 = true;
                arrayList = arrayList2;
            }
            drawTable(canvas, 155.0f, 842, listOf2, fArr, arrayList);
            pdfDocument.finishPage(startPage);
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                pdfDocument.writeTo(fileOutputStream);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                pdfDocument.close();
                return z2;
            } finally {
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            return z;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean generateCompliancePdf(Context context, Company company, List<ComplianceItem> items, String dateRangeText, String presenterName, File outputFile) {
        boolean z;
        PdfDocument pdfDocument;
        int i;
        Object[] objArr;
        int i2;
        char c;
        String str;
        Canvas canvas;
        boolean z2;
        List<? extends List<String>> list;
        Object[] objArr2;
        int i3;
        Canvas canvas2;
        try {
            pdfDocument = new PdfDocument();
            PdfDocument.Page startPage = pdfDocument.startPage(new PdfDocument.PageInfo.Builder(842, 595, 1).create());
            Canvas canvas3 = startPage.getCanvas();
            Intrinsics.checkNotNull(canvas3);
            drawReportHeader(canvas3, 842, "STATUTORY COMPLIANCE & LEGAL REGISTER", "Factories Act, PCB Consent Orders, Fire NOC, PESO & Hazardous Waste Clearances", company.getName(), dateRangeText, presenterName);
            List<ComplianceItem> list2 = items;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                i = 0;
                z = false;
            } else {
                i = 0;
                for (ComplianceItem complianceItem : list2) {
                    try {
                        z = false;
                    } catch (Exception e) {
                        e = e;
                        z = false;
                        e.printStackTrace();
                        return z;
                    }
                    try {
                        if (!StringsKt.equals(complianceItem.getStatus(), "Complied", true) && !StringsKt.equals(complianceItem.getStatus(), "Valid", true)) {
                            objArr = false;
                            if (objArr != false && (i = i + 1) < 0) {
                                CollectionsKt.throwCountOverflow();
                            }
                        }
                        objArr = true;
                        if (objArr != false) {
                            CollectionsKt.throwCountOverflow();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        return z;
                    }
                }
                z = false;
            }
            int i4 = i;
            List<ComplianceItem> list3 = items;
            if ((list3 instanceof Collection) && list3.isEmpty()) {
                i2 = z ? 1 : 0;
            } else {
                i2 = 0;
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    List<ComplianceItem> list4 = list3;
                    if (StringsKt.equals(((ComplianceItem) it.next()).getStatus(), "Expired", true)) {
                        i2++;
                        if (i2 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        list3 = list4;
                    } else {
                        list3 = list4;
                    }
                }
            }
            int i5 = i2;
            int size = (items.size() - i4) - i5;
            Pair[] pairArr = new Pair[5];
            pairArr[z ? 1 : 0] = new Pair("TOTAL LICENSES", String.valueOf(items.size()));
            pairArr[1] = new Pair("COMPLIED / VALID", String.valueOf(i4));
            pairArr[2] = new Pair("IN PROGRESS", String.valueOf(size));
            pairArr[3] = new Pair("EXPIRED / ACTION", String.valueOf(i5));
            if (items.isEmpty()) {
                c = 5;
                str = "100%";
            } else {
                c = 5;
                str = ((i4 * 100) / items.size()) + "%";
            }
            pairArr[4] = new Pair("COMPLIANCE RATE", str);
            drawKpiCards(canvas3, 842, 78.0f, CollectionsKt.listOf(pairArr));
            int i6 = 8;
            String[] strArr = new String[8];
            strArr[z ? 1 : 0] = "Document Name";
            strArr[1] = "Category / Authority";
            strArr[2] = "Issuing Body";
            strArr[3] = "Ref / Document #";
            strArr[4] = "Valid To";
            strArr[c] = "Apply By";
            strArr[6] = "Status";
            strArr[7] = "Responsible";
            List<String> listOf = CollectionsKt.listOf(strArr);
            float[] fArr = {130.0f, 110.0f, 100.0f, 100.0f, 80.0f, 80.0f, 80.0f, 114.0f};
            if (items.isEmpty()) {
                String[] strArr2 = new String[8];
                strArr2[z ? 1 : 0] = "Statutory Register Up to Date";
                strArr2[1] = "Statutory & Factory";
                strArr2[2] = "Labor Inspectorate";
                strArr2[3] = "FULL-COMP-2026";
                strArr2[4] = "2026-12-31";
                strArr2[c] = "N/A";
                strArr2[6] = "Valid";
                strArr2[7] = "EHS Lead";
                canvas = canvas3;
                z2 = true;
                list = CollectionsKt.listOf(CollectionsKt.listOf(strArr2));
            } else {
                List<ComplianceItem> list5 = items;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                for (ComplianceItem complianceItem2 : list5) {
                    List<ComplianceItem> list6 = list5;
                    Object[] objArr3 = new String[i6];
                    objArr3[z ? 1 : 0] = complianceItem2.getDocumentName();
                    String category = complianceItem2.getCategory();
                    if (StringsKt.isBlank(category)) {
                        category = "Statutory Norm";
                    }
                    objArr3[1] = category;
                    String issuingAuthority = complianceItem2.getIssuingAuthority();
                    if (StringsKt.isBlank(issuingAuthority)) {
                        issuingAuthority = "Competent Authority";
                    }
                    objArr3[2] = issuingAuthority;
                    String documentNumber = complianceItem2.getDocumentNumber();
                    if (StringsKt.isBlank(documentNumber)) {
                        canvas2 = canvas3;
                        objArr2 = objArr3;
                        i3 = i4;
                        documentNumber = "REG-" + complianceItem2.getId();
                    } else {
                        objArr2 = objArr3;
                        i3 = i4;
                        canvas2 = canvas3;
                    }
                    objArr2[3] = documentNumber;
                    String expiryDate = complianceItem2.getExpiryDate();
                    if (StringsKt.isBlank(expiryDate)) {
                        expiryDate = "Perpetual";
                    }
                    objArr2[4] = expiryDate;
                    String applyByDate = complianceItem2.getApplyByDate();
                    if (StringsKt.isBlank(applyByDate)) {
                        applyByDate = "N/A";
                    }
                    objArr2[c] = applyByDate;
                    String status = complianceItem2.getStatus();
                    if (StringsKt.isBlank(status)) {
                        status = "Pending";
                    }
                    objArr2[6] = status;
                    String responsiblePerson = complianceItem2.getResponsiblePerson();
                    if (StringsKt.isBlank(responsiblePerson)) {
                        responsiblePerson = "Safety Manager";
                    }
                    objArr2[7] = responsiblePerson;
                    arrayList.add(CollectionsKt.listOf(objArr2));
                    list5 = list6;
                    canvas3 = canvas2;
                    i4 = i3;
                    i6 = 8;
                }
                canvas = canvas3;
                z2 = true;
                list = arrayList;
            }
            drawTable(canvas, 155.0f, 842, listOf, fArr, list);
            pdfDocument.finishPage(startPage);
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                pdfDocument.writeTo(fileOutputStream);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                pdfDocument.close();
                return z2;
            } finally {
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            return z;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean generateDueDashboardPdf(Context context, Company company, List<Observation> observations, String dateRangeText, String presenterName, File outputFile) {
        boolean z;
        PdfDocument pdfDocument;
        int i;
        int i2;
        char c;
        String str;
        boolean z2;
        ArrayList arrayList;
        try {
            pdfDocument = new PdfDocument();
            boolean z3 = true;
            PdfDocument.Page startPage = pdfDocument.startPage(new PdfDocument.PageInfo.Builder(842, 595, 1).create());
            Canvas canvas = startPage.getCanvas();
            Intrinsics.checkNotNull(canvas);
            drawReportHeader(canvas, 842, "DUE ACTION ITEMS & OVERDUE TIMELINE DOSSIER", "SLA Compliance Velocity, Open Non-Conformances & Corrective Action Performance", company.getName(), dateRangeText, presenterName);
            List<Observation> list = observations;
            if ((list instanceof Collection) && list.isEmpty()) {
                i = 0;
            } else {
                i = 0;
                for (Observation observation : list) {
                    if (((!DateUtils.INSTANCE.isDateOverdue(observation.getTargetDate()) || observation.isResolved()) ? null : 1) != null && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            int i3 = i;
            List<Observation> list2 = observations;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                i2 = 0;
            } else {
                i2 = 0;
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (((Observation) it.next()).isResolved() && (i2 = i2 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            int i4 = i2;
            int size = observations.size() - i4;
            Pair[] pairArr = new Pair[5];
            pairArr[0] = new Pair("TOTAL ACTION ITEMS", String.valueOf(observations.size()));
            pairArr[1] = new Pair("CLOSED ON TIME", String.valueOf(i4));
            pairArr[2] = new Pair("OPEN CAPA", String.valueOf(size));
            pairArr[3] = new Pair("OVERDUE / BREACHED", String.valueOf(i3));
            if (observations.isEmpty()) {
                c = 5;
                z = false;
                str = "100%";
            } else {
                c = 5;
                z = false;
                try {
                    str = ((i4 * 100) / observations.size()) + "%";
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return z;
                }
            }
            pairArr[4] = new Pair("CLOSURE RATE", str);
            List<Pair<String, String>> listOf = CollectionsKt.listOf(pairArr);
            drawKpiCards(canvas, 842, 78.0f, listOf);
            String[] strArr = new String[8];
            strArr[z ? 1 : 0] = "SNC #";
            strArr[1] = "Location / Area";
            strArr[2] = "Severity";
            strArr[3] = "Issue Details";
            strArr[4] = "Target Date";
            strArr[c] = "SLA Status";
            strArr[6] = "Assigned Person";
            strArr[7] = "Resolution";
            List<String> listOf2 = CollectionsKt.listOf(strArr);
            float[] fArr = {65.0f, 95.0f, 80.0f, 190.0f, 75.0f, 85.0f, 95.0f, 109.0f};
            if (observations.isEmpty()) {
                String[] strArr2 = new String[8];
                strArr2[z ? 1 : 0] = "SNC-NONE";
                strArr2[1] = "Entire Facility";
                strArr2[2] = "Safe";
                strArr2[3] = "No overdue or open non-conformances for this period.";
                strArr2[4] = "N/A";
                strArr2[c] = "COMPLIED";
                strArr2[6] = "All Leads";
                strArr2[7] = "Maintained";
                arrayList = CollectionsKt.listOf(CollectionsKt.listOf(strArr2));
                z2 = true;
            } else {
                List<Observation> list3 = observations;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                for (Observation observation2 : list3) {
                    boolean z4 = z3;
                    Object[] objArr = (!DateUtils.INSTANCE.isDateOverdue(observation2.getTargetDate()) || observation2.isResolved()) ? z ? 1 : 0 : z4 ? 1 : 0;
                    List<Observation> list4 = list3;
                    String[] strArr3 = new String[8];
                    strArr3[z ? 1 : 0] = observation2.getSncNumber();
                    String location = observation2.getLocation();
                    if (StringsKt.isBlank(location)) {
                        location = "General Plant";
                    }
                    strArr3[z4 ? 1 : 0] = location;
                    strArr3[2] = observation2.getSeverity();
                    List<Pair<String, String>> list5 = listOf;
                    strArr3[3] = StringsKt.take(observation2.getIssueDetails(), 50) + (observation2.getIssueDetails().length() > 50 ? "..." : "");
                    String targetDate = observation2.getTargetDate();
                    if (StringsKt.isBlank(targetDate)) {
                        targetDate = "N/A";
                    }
                    strArr3[4] = targetDate;
                    strArr3[c] = observation2.isResolved() ? "RESOLVED" : objArr != false ? "OVERDUE" : "IN SLA";
                    String responsiblePerson = observation2.getResponsiblePerson();
                    if (StringsKt.isBlank(responsiblePerson)) {
                        responsiblePerson = "EHS Officer";
                    }
                    strArr3[6] = responsiblePerson;
                    strArr3[7] = observation2.isResolved() ? MaterialFollowUpUtils.STATUS_CLOSED : MaterialFollowUpUtils.STATUS_IN_PROGRESS;
                    arrayList2.add(CollectionsKt.listOf(strArr3));
                    z3 = z4 ? 1 : 0;
                    list3 = list4;
                    listOf = list5;
                }
                z2 = z3;
                arrayList = arrayList2;
            }
            drawTable(canvas, 155.0f, 842, listOf2, fArr, arrayList);
            pdfDocument.finishPage(startPage);
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                pdfDocument.writeTo(fileOutputStream);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                pdfDocument.close();
                return z2;
            } finally {
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return z;
        }
    }

    private final boolean generatePersonnelPdf(Context context, Company company, List<ResponsiblePerson> personnel, String dateRangeText, String presenterName, File outputFile) {
        boolean z;
        PdfDocument doc;
        int i;
        List list;
        try {
            doc = new PdfDocument();
            PdfDocument.Page page = doc.startPage(new PdfDocument.PageInfo.Builder(842, 595, 1).create());
            Canvas canvas = page.getCanvas();
            Intrinsics.checkNotNull(canvas);
            drawReportHeader(canvas, 842, "UNIT PERSONNEL & SAFETY RESPONSIBILITIES DIRECTORY", "Official EHS Plant Contacts, Designated Safety Incharges & Shift Officers", company.getName(), dateRangeText, presenterName);
            List<ResponsiblePerson> list2 = personnel;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                try {
                    z = false;
                    try {
                        arrayList.add(((ResponsiblePerson) it.next()).getDepartment());
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        return z;
                    }
                } catch (Exception e2) {
                    e = e2;
                    z = false;
                    e.printStackTrace();
                    return z;
                }
            }
            z = false;
            int deptCount = CollectionsKt.distinct((List) arrayList).size();
            Pair[] pairArr = new Pair[5];
            pairArr[0] = new Pair("REGISTERED OFFICERS", String.valueOf(personnel.size()));
            pairArr[1] = new Pair("DEPARTMENTS", String.valueOf(deptCount));
            String division = company.getDivision();
            if (StringsKt.isBlank(division)) {
                division = company.getName();
            }
            pairArr[2] = new Pair("FACILITY UNIT", division);
            List<ResponsiblePerson> list3 = personnel;
            if ((list3 instanceof Collection) && list3.isEmpty()) {
                i = 0;
            } else {
                i = 0;
                Iterator it2 = list3.iterator();
                while (it2.hasNext()) {
                    if (!StringsKt.isBlank(((ResponsiblePerson) it2.next()).getWhatsappNumber()) && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            char c = 3;
            pairArr[3] = new Pair("WHATSAPP INTEGRATED", String.valueOf(i));
            pairArr[4] = new Pair("ROSTER STATUS", "Active Valid");
            List kpis = CollectionsKt.listOf(pairArr);
            drawKpiCards(canvas, 842, 78.0f, kpis);
            List headers = CollectionsKt.listOf(new String[]{"S.No", "Employee Name", "Designation / Safety Role", "Department", "WhatsApp Contact", "Emergency Status"});
            float[] colWidths = {40.0f, 170.0f, 180.0f, 150.0f, 130.0f, 124.0f};
            if (personnel.isEmpty()) {
                list = CollectionsKt.listOf(CollectionsKt.listOf(new String[]{"1", "Plant Safety Officer", "EHS Lead Manager", "Safety & Environment", "+91 97381 54697", "Available 24/7"}));
            } else {
                List<ResponsiblePerson> list4 = personnel;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                int i2 = 0;
                for (Object obj : list4) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ResponsiblePerson responsiblePerson = (ResponsiblePerson) obj;
                    char c2 = c;
                    String[] strArr = new String[6];
                    strArr[0] = String.valueOf(i2 + 1);
                    strArr[1] = responsiblePerson.getName();
                    String designation = responsiblePerson.getDesignation();
                    if (StringsKt.isBlank(designation)) {
                        designation = "Safety Representative";
                    }
                    strArr[2] = designation;
                    String department = responsiblePerson.getDepartment();
                    if (StringsKt.isBlank(department)) {
                        department = "Operations";
                    }
                    strArr[c2] = department;
                    String whatsappNumber = responsiblePerson.getWhatsappNumber();
                    if (StringsKt.isBlank(whatsappNumber)) {
                        whatsappNumber = "+91 (Registered on file)";
                    }
                    strArr[4] = whatsappNumber;
                    strArr[5] = "Authorized Incharge";
                    arrayList2.add(CollectionsKt.listOf(strArr));
                    i2 = i3;
                    c = c2;
                }
                list = (List) arrayList2;
            }
            List rows = list;
            drawTable(canvas, 155.0f, 842, headers, colWidths, rows);
            doc.finishPage(page);
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                doc.writeTo(fileOutputStream);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                doc.close();
                return true;
            } finally {
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            return z;
        }
    }

    private final boolean generateCalendarPdf(Context context, List<CalendarHolidayEvent> events, String dateRangeText, String presenterName, File outputFile) {
        boolean z;
        PdfDocument pdfDocument;
        int i;
        int i2;
        boolean z2;
        List<? extends List<String>> list;
        try {
            pdfDocument = new PdfDocument();
            PdfDocument.Page startPage = pdfDocument.startPage(new PdfDocument.PageInfo.Builder(842, 595, 1).create());
            Canvas canvas = startPage.getCanvas();
            Intrinsics.checkNotNull(canvas);
            drawReportHeader(canvas, 842, "VELTRIX ESG & OBSERVANCES CALENDAR (2026)", "Sunday-First Yearly Roster • National, Hindu, Muslim, Christian & ESG Sustainability Days", "Veltrix Global Sustainability", dateRangeText, presenterName);
            List<CalendarHolidayEvent> list2 = events;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                i = 0;
            } else {
                i = 0;
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (((CalendarHolidayEvent) it.next()).isHoliday() && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            int i3 = i;
            List<CalendarHolidayEvent> list3 = events;
            if ((list3 instanceof Collection) && list3.isEmpty()) {
                i2 = 0;
                z = false;
            } else {
                i2 = 0;
                Iterator<T> it2 = list3.iterator();
                while (it2.hasNext()) {
                    try {
                        z = false;
                    } catch (Exception e) {
                        e = e;
                        z = false;
                        e.printStackTrace();
                        return z;
                    }
                    try {
                        List<CalendarHolidayEvent> list4 = list3;
                        if (StringsKt.contains(((CalendarHolidayEvent) it2.next()).getCategory(), "ESG", true)) {
                            i2++;
                            if (i2 < 0) {
                                CollectionsKt.throwCountOverflow();
                            }
                            list3 = list4;
                        } else {
                            list3 = list4;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        return z;
                    }
                }
                z = false;
            }
            int i4 = i2;
            Pair[] pairArr = new Pair[5];
            pairArr[z ? 1 : 0] = new Pair("TOTAL OBSERVANCES", String.valueOf(events.size()));
            pairArr[1] = new Pair("PUBLIC HOLIDAYS", i3 + " Days");
            pairArr[2] = new Pair("ESG / SAFETY DAYS", i4 + " Days");
            pairArr[3] = new Pair("CALENDAR YEAR", "2026");
            char c = 4;
            pairArr[4] = new Pair("ROSTER ALIGNMENT", "Sunday-First Roster");
            drawKpiCards(canvas, 842, 78.0f, CollectionsKt.listOf(pairArr));
            int i5 = 6;
            String[] strArr = new String[6];
            strArr[z ? 1 : 0] = "Date";
            strArr[1] = "Observance / Festival";
            strArr[2] = "Category";
            strArr[3] = "Type";
            strArr[4] = "Observed Since";
            strArr[5] = "Significance & EHS Focus";
            List<String> listOf = CollectionsKt.listOf(strArr);
            float[] fArr = {80.0f, 170.0f, 100.0f, 90.0f, 100.0f, 254.0f};
            if (events.isEmpty()) {
                String[] strArr2 = new String[6];
                strArr2[z ? 1 : 0] = "2026-01-01";
                strArr2[1] = "New Year's Day";
                strArr2[2] = "National";
                strArr2[3] = "Public Holiday";
                strArr2[4] = "Ancient";
                strArr2[5] = "Plant annual kickoff";
                z2 = true;
                list = CollectionsKt.listOf(CollectionsKt.listOf(strArr2));
            } else {
                List<CalendarHolidayEvent> list5 = events;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                List<CalendarHolidayEvent> list6 = list5;
                for (CalendarHolidayEvent calendarHolidayEvent : list6) {
                    char c2 = c;
                    String[] strArr3 = new String[i5];
                    strArr3[z ? 1 : 0] = calendarHolidayEvent.getDateStr();
                    strArr3[1] = calendarHolidayEvent.getTitle();
                    strArr3[2] = calendarHolidayEvent.getCategory();
                    strArr3[3] = calendarHolidayEvent.isHoliday() ? "Public Holiday" : "ESG Observance";
                    strArr3[c2] = calendarHolidayEvent.getObservedSince();
                    int i6 = i4;
                    List<CalendarHolidayEvent> list7 = list6;
                    strArr3[5] = StringsKt.take(calendarHolidayEvent.getSignificance(), 65) + (calendarHolidayEvent.getSignificance().length() > 65 ? "..." : "");
                    arrayList.add(CollectionsKt.listOf(strArr3));
                    c = c2;
                    i4 = i6;
                    list6 = list7;
                    i5 = 6;
                }
                z2 = true;
                list = arrayList;
            }
            drawTable(canvas, 155.0f, 842, listOf, fArr, list);
            pdfDocument.finishPage(startPage);
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            try {
                pdfDocument.writeTo(fileOutputStream);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                pdfDocument.close();
                return z2;
            } finally {
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            return z;
        }
    }

    private final void drawReportHeader(Canvas canvas, int pageWidth, String title, String subtitle, String unitName, String period, String presenter) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        paint.setColor(Color.parseColor("#880E4F"));
        canvas.drawRect(0.0f, 0.0f, pageWidth, 72.0f, paint);
        paint2.setColor(Color.parseColor("#FACC15"));
        paint2.setTextSize(10.0f);
        paint2.setTextAlign(Paint.Align.LEFT);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = unitName.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        canvas.drawText("COMPANY / UNIT: " + upperCase, 24.0f, 20.0f, paint2);
        paint2.setColor(Color.parseColor("#38BDF8"));
        paint2.setTextSize(9.0f);
        paint2.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("PERIOD: " + period, pageWidth - 24.0f, 20.0f, paint2);
        paint2.setColor(-1);
        paint2.setTextSize(13.5f);
        paint2.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(title, 24.0f, 40.0f, paint2);
        paint.setColor(Color.parseColor("#E2E8F0"));
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setTextSize(8.0f);
        canvas.drawText("PRESENTER: " + presenter + "  |  DATE: " + new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(new Date()), pageWidth - 24.0f, 40.0f, paint);
        paint.setColor(Color.parseColor("#93C5FD"));
        paint.setTextSize(8.5f);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(subtitle, 24.0f, 58.0f, paint);
        paint.setColor(Color.parseColor("#F59E0B"));
        canvas.drawRect(0.0f, 72.0f, pageWidth, 75.0f, paint);
    }

    private final void drawKpiCards(Canvas canvas, int pageWidth, float cardY, List<Pair<String, String>> kpis) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Paint textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        textPaint.setTextAlign(Paint.Align.CENTER);
        float cardH = 58.0f;
        float gap = 10.0f;
        float cardW = ((pageWidth - 48.0f) - ((kpis.size() - 1) * 10.0f)) / kpis.size();
        List accentColors = CollectionsKt.listOf(new Integer[]{Integer.valueOf(Color.parseColor("#3B82F6")), Integer.valueOf(Color.parseColor("#10B981")), Integer.valueOf(Color.parseColor("#8B5CF6")), Integer.valueOf(Color.parseColor("#F59E0B")), Integer.valueOf(Color.parseColor("#EF4444"))});
        int i = 0;
        for (Object obj : kpis) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            float cardH2 = cardH;
            float cardH3 = i;
            float f = (cardH3 * (cardW + gap)) + 24.0f;
            float gap2 = gap;
            float f2 = f + cardW;
            float cardW2 = cardW;
            float cardW3 = cardY + cardH2;
            RectF rectF = new RectF(f, cardY, f2, cardW3);
            paint.setColor(Color.parseColor("#F8FAFC"));
            canvas.drawRoundRect(rectF, 6.0f, 6.0f, paint);
            paint.setColor(Color.parseColor("#CBD5E1"));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(1.0f);
            canvas.drawRoundRect(rectF, 6.0f, 6.0f, paint);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(((Number) accentColors.get(i % accentColors.size())).intValue());
            canvas.drawRoundRect(new RectF(f, cardY, f + cardW2, cardY + 4.0f), 6.0f, 6.0f, paint);
            textPaint.setColor(Color.parseColor("#64748B"));
            textPaint.setTextSize(8.0f);
            canvas.drawText((String) pair.getFirst(), (cardW2 / 2.0f) + f, cardY + 22.0f, textPaint);
            textPaint.setColor(Color.parseColor("#880E4F"));
            textPaint.setTextSize(12.0f);
            canvas.drawText((String) pair.getSecond(), (cardW2 / 2.0f) + f, 44.0f + cardY, textPaint);
            i = i2;
            cardH = cardH2;
            gap = gap2;
            cardW = cardW2;
            accentColors = accentColors;
        }
    }

    private final void drawTable(Canvas canvas, float startY, int pageWidth, List<String> headers, float[] colWidths, List<? extends List<String>> rows) {
        Iterable iterable;
        int i;
        int i2;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(-1);
        paint2.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        paint2.setTextSize(9.0f);
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setColor(Color.parseColor("#1E293B"));
        paint3.setTextSize(8.5f);
        paint.setColor(Color.parseColor("#880E4F"));
        float f = 24.0f;
        Canvas canvas2 = canvas;
        canvas2.drawRect(24.0f, startY, pageWidth - 24.0f, startY + 22.0f, paint);
        float curX = 28.0f;
        int i3 = 0;
        for (Object obj : headers) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            float f2 = colWidths[i3];
            canvas2.drawText((String) obj, curX, startY + 14.0f, paint2);
            curX += f2;
            i3 = i4;
            f = f;
        }
        float f3 = f;
        float curY = startY + 22.0f;
        List maxRows = CollectionsKt.take(rows, 18);
        int i5 = 0;
        for (Object obj2 : maxRows) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Iterable iterable2 = (List) obj2;
            paint.setColor(Color.parseColor(i5 % 2 == 0 ? "#FFFFFF" : "#F1F5F9"));
            canvas2.drawRect(24.0f, curY, pageWidth - f3, curY + 20.0f, paint);
            paint.setColor(Color.parseColor("#E2E8F0"));
            paint.setStrokeWidth(0.5f);
            paint.setStyle(Paint.Style.STROKE);
            canvas2 = canvas;
            canvas2.drawRect(24.0f, curY, pageWidth - f3, curY + 20.0f, paint);
            paint.setStyle(Paint.Style.FILL);
            curX = 28.0f;
            Iterable iterable3 = iterable2;
            int i7 = 0;
            int i8 = 0;
            for (Object obj3 : iterable3) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                float curY2 = curY;
                String str = (String) obj3;
                int i10 = i8;
                boolean z = false;
                if (i10 >= 0) {
                    iterable = iterable3;
                    i = i7;
                    i2 = i10;
                    if (i2 < colWidths.length) {
                        z = true;
                    }
                } else {
                    iterable = iterable3;
                    i = i7;
                    i2 = i10;
                }
                float f4 = z ? colWidths[i2] : 80.0f;
                canvas2.drawText(StringsKt.take(str, (int) (f4 / 5.5f)), curX, curY2 + 14.0f, paint3);
                curX += f4;
                i8 = i9;
                curY = curY2;
                iterable3 = iterable;
                i7 = i;
            }
            curY += 20.0f;
            i5 = i6;
        }
        paint.setColor(Color.parseColor("#64748B"));
        paint.setTextSize(8.0f);
        canvas2.drawText("Showing " + maxRows.size() + " of " + rows.size() + " registered items. Certified accurate by Plant EHS Incharge.", f3, curY + 16.0f, paint);
    }

    private final boolean generateGenericPpt(String title, String companyName, String dateRange, String presenter, String kpiSummary, String detailHeader, List<String> items, File outputFile) {
        String safeDate;
        String safePres;
        String maxList;
        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outputFile));
            addZipEntry(zos, "[Content_Types].xml", buildContentTypesXml(3));
            addZipEntry(zos, "_rels/.rels", buildRelsXml());
            addZipEntry(zos, "ppt/presentation.xml", buildPresentationXml(3));
            addZipEntry(zos, "ppt/_rels/presentation.xml.rels", buildPresentationRelsXml(3));
            addZipEntry(zos, "ppt/slideMasters/slideMaster1.xml", buildSlideMasterXml());
            addZipEntry(zos, "ppt/slideMasters/_rels/slideMaster1.xml.rels", buildSlideMasterRelsXml());
            addZipEntry(zos, "ppt/slideLayouts/slideLayout1.xml", buildSlideLayoutXml());
            addZipEntry(zos, "ppt/slideLayouts/_rels/slideLayout1.xml.rels", buildSlideLayoutRelsXml());
            int i = 1;
            while (true) {
                addZipEntry(zos, "ppt/slides/_rels/slide" + i + ".xml.rels", buildSlideRelsXml());
                if (i == 3) {
                    String safeTitle = sanitize(title);
                    String safeComp = sanitize(companyName);
                    try {
                        safeDate = sanitize(dateRange);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        return false;
                    }
                    try {
                        safePres = sanitize(presenter);
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        return false;
                    }
                    try {
                        String safeKpi = sanitize(kpiSummary);
                        String s1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\"\n       xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"\n       xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr><a:xfrm><a:off x=\"0\" y=\"0\"/><a:ext cx=\"0\" cy=\"0\"/><a:chOff x=\"0\" y=\"0\"/><a:chExt cx=\"0\" cy=\"0\"/></a:xfrm></p:grpSpPr>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"1\" name=\"Bg\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"0\" y=\"0\"/><a:ext cx=\"11887200\" cy=\"8409600\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"55051B\"/></a:solidFill></p:spPr>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"2\" name=\"Cover\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"1000000\" y=\"1600000\"/><a:ext cx=\"9887200\" cy=\"5200000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 2000\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill><a:ln w=\"25400\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill></a:ln></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"3400\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + safeTitle + "</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"2400\" b=\"1\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + safeComp + "</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1600\"><a:solidFill><a:srgbClr val=\"FCE7F3\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Period: " + safeDate + " | Presenter: " + safePres + "</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n    </p:spTree>\n  </p:cSld>\n</p:sld>";
                        addZipEntry(zos, "ppt/slides/slide1.xml", s1);
                        String s2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\"\n       xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"\n       xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr><a:xfrm><a:off x=\"0\" y=\"0\"/><a:ext cx=\"0\" cy=\"0\"/><a:chOff x=\"0\" y=\"0\"/><a:chExt cx=\"0\" cy=\"0\"/></a:xfrm></p:grpSpPr>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"1\" name=\"Bg\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"0\" y=\"0\"/><a:ext cx=\"11887200\" cy=\"8409600\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"55051B\"/></a:solidFill></p:spPr>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"2\" name=\"Title\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"500000\"/><a:ext cx=\"10687200\" cy=\"800000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"55051B\"/></a:solidFill></p:spPr>\n        <p:txBody><a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:r><a:rPr sz=\"2200\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>EXECUTIVE KEY PERFORMANCE INDICATORS</a:t></a:r></p>\n          <a:p><a:r><a:rPr sz=\"1300\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Unit: " + safeComp + " | Period: " + safeDate + "</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"3\" name=\"Content\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"1600000\"/><a:ext cx=\"10687200\" cy=\"5800000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 1000\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill><a:ln w=\"12700\"><a:solidFill><a:srgbClr val=\"BE185D\"/></a:solidFill></a:ln></p:spPr>\n        <p:txBody>\n          <a:bodyPr/>\n          <a:p><a:r><a:rPr sz=\"1800\" b=\"1\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Summary Metrics:</a:t></a:r></p>\n          <a:p><a:r><a:rPr sz=\"1600\"><a:solidFill><a:srgbClr val=\"FCE7F3\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + safeKpi + "</a:t></a:r></p>\n          <a:p><a:pPr><a:spcBfr><a:spcPts val=\"1200\"/></a:spcBfr></a:pPr><a:r><a:rPr sz=\"1600\" b=\"1\"><a:solidFill><a:srgbClr val=\"38BDF8\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Facility Scope:</a:t></a:r></p>\n          <a:p><a:r><a:rPr sz=\"1500\"><a:solidFill><a:srgbClr val=\"FDA4AF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Unit: " + safeComp + " • Period: " + safeDate + " • Verified: 100% Complete</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n    </p:spTree>\n  </p:cSld>\n</p:sld>";
                        addZipEntry(zos, "ppt/slides/slide2.xml", s2);
                        maxList = CollectionsKt.joinToString$default(CollectionsKt.take(items, 10), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.example.utils.SectionReportGenerators$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return SectionReportGenerators.generateGenericPpt$lambda$149((String) obj);
                            }
                        }, 30, (Object) null);
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        return false;
                    }
                    try {
                        String s3 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\"\n       xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"\n       xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr><a:xfrm><a:off x=\"0\" y=\"0\"/><a:ext cx=\"0\" cy=\"0\"/><a:chOff x=\"0\" y=\"0\"/><a:chExt cx=\"0\" cy=\"0\"/></a:xfrm></p:grpSpPr>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"1\" name=\"Bg\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"0\" y=\"0\"/><a:ext cx=\"11887200\" cy=\"8409600\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"55051B\"/></a:solidFill></p:spPr>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"2\" name=\"Title\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"500000\"/><a:ext cx=\"10687200\" cy=\"800000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"55051B\"/></a:solidFill></p:spPr>\n        <p:txBody><a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:r><a:rPr sz=\"2200\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + sanitize(detailHeader) + "</a:t></a:r></p>\n          <a:p><a:r><a:rPr sz=\"1300\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Unit: " + safeComp + " | Period: " + safeDate + "</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"3\" name=\"Content\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"1600000\"/><a:ext cx=\"10687200\" cy=\"5800000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 1000\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill><a:ln w=\"12700\"><a:solidFill><a:srgbClr val=\"BE185D\"/></a:solidFill></a:ln></p:spPr>\n        <p:txBody>\n          <a:bodyPr/>\n          " + maxList + "\n        </p:txBody>\n      </p:sp>\n    </p:spTree>\n  </p:cSld>\n</p:sld>";
                        addZipEntry(zos, "ppt/slides/slide3.xml", s3);
                        zos.close();
                        return true;
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        return false;
                    }
                }
                i++;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence generateGenericPpt$lambda$149(String item) {
        Intrinsics.checkNotNullParameter(item, "item");
        String clean = INSTANCE.sanitize(item);
        return "<a:p><a:pPr marL=\"288000\"><a:buFont typeface=\"Cambria\"/><a:buChar char=\"•\"/></a:pPr><a:r><a:rPr sz=\"1400\"><a:solidFill><a:srgbClr val=\"FCE7F3\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + clean + "</a:t></a:r></p>";
    }

    private final String sanitize(String text) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(text, "&", "&amp;", false, 4, (Object) null), "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null), "\"", "&quot;", false, 4, (Object) null), "'", "&apos;", false, 4, (Object) null);
    }

    private final void addZipEntry(ZipOutputStream zos, String path, String content) {
        ZipEntry entry = new ZipEntry(path);
        zos.putNextEntry(entry);
        byte[] bytes = content.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        zos.write(bytes);
        zos.closeEntry();
    }

    private final String buildContentTypesXml(int slideCount) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        sb.append("<Types xmlns=\"http://schemas.openxmlformats.org/package/2006/content-types\">");
        sb.append("<Default Extension=\"rels\" ContentType=\"application/vnd.openxmlformats-package.relationships+xml\"/>");
        sb.append("<Default Extension=\"xml\" ContentType=\"application/xml\"/>");
        sb.append("<Override PartName=\"/ppt/presentation.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.presentationml.presentation.main+xml\"/>");
        sb.append("<Override PartName=\"/ppt/slideMasters/slideMaster1.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.presentationml.slideMaster+xml\"/>");
        sb.append("<Override PartName=\"/ppt/slideLayouts/slideLayout1.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.presentationml.slideLayout+xml\"/>");
        int i = 1;
        if (1 <= slideCount) {
            while (true) {
                sb.append("<Override PartName=\"/ppt/slides/slide" + i + ".xml\" ContentType=\"application/vnd.openxmlformats-officedocument.presentationml.slide+xml\"/>");
                if (i == slideCount) {
                    break;
                }
                i++;
            }
        }
        sb.append("</Types>");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final String buildRelsXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">\n  <Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument\" Target=\"ppt/presentation.xml\"/>\n</Relationships>";
    }

    private final String buildPresentationXml(int slideCount) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        sb.append("<p:presentation xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">");
        sb.append("<p:sldMasterIdLst><p:sldMasterId id=\"2147483648\" r:id=\"rId1\"/></p:sldMasterIdLst>");
        sb.append("<p:sldIdLst>");
        int i = 1;
        if (1 <= slideCount) {
            while (true) {
                sb.append("<p:sldId id=\"" + (i + 255) + "\" r:id=\"rId" + (i + 1) + "\"/>");
                if (i == slideCount) {
                    break;
                }
                i++;
            }
        }
        sb.append("</p:sldIdLst>");
        sb.append("<p:sldSz cx=\"11887200\" cy=\"8409600\" type=\"A4\"/>");
        sb.append("<p:notesSz cx=\"8409600\" cy=\"11887200\"/>");
        sb.append("</p:presentation>");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final String buildPresentationRelsXml(int slideCount) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        sb.append("<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">");
        sb.append("<Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideMaster\" Target=\"slideMasters/slideMaster1.xml\"/>");
        int i = 1;
        if (1 <= slideCount) {
            while (true) {
                sb.append("<Relationship Id=\"rId" + (i + 1) + "\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/slide\" Target=\"slides/slide" + i + ".xml\"/>");
                if (i == slideCount) {
                    break;
                }
                i++;
            }
        }
        sb.append("</Relationships>");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final String buildSlideMasterXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sldMaster xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld><p:spTree><p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr><p:grpSpPr><a:xfrm><a:off x=\"0\" y=\"0\"/><a:ext cx=\"0\" cy=\"0\"/><a:chOff x=\"0\" y=\"0\"/><a:chExt cx=\"0\" cy=\"0\"/></a:xfrm></p:grpSpPr></p:spTree></p:cSld>\n  <p:clrMap bg1=\"lt1\" tx1=\"dk1\" bg2=\"lt2\" tx2=\"dk2\" accent1=\"accent1\" accent2=\"accent2\" accent3=\"accent3\" accent4=\"accent4\" accent5=\"accent5\" accent6=\"accent6\" hlink=\"hlink\" folHlink=\"folHlink\"/>\n  <p:sldLayoutIdLst><p:sldLayoutId id=\"2147483649\" r:id=\"rId1\"/></p:sldLayoutIdLst>\n  <p:txStyles>\n    <p:titleStyle><a:lvl1pPr><a:defRPr><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:defRPr></a:lvl1pPr></p:titleStyle>\n    <p:bodyStyle><a:lvl1pPr><a:defRPr><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:defRPr></a:lvl1pPr></p:bodyStyle>\n    <p:otherStyle><a:defPPr><a:defRPr><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:defRPr></a:defPPr></p:otherStyle>\n  </p:txStyles>\n</p:sldMaster>";
    }

    private final String buildSlideLayoutXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sldLayout xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\" type=\"blank\">\n  <p:cSld><p:spTree><p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr><p:grpSpPr><a:xfrm><a:off x=\"0\" y=\"0\"/><a:ext cx=\"0\" cy=\"0\"/><a:chOff x=\"0\" y=\"0\"/><a:chExt cx=\"0\" cy=\"0\"/></a:xfrm></p:grpSpPr></p:spTree></p:cSld>\n  <p:clrMapOvr><a:masterClrMapping/></p:clrMapOvr>\n</p:sldLayout>";
    }

    private final String buildSlideRelsXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">\n  <Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideLayout\" Target=\"../slideLayouts/slideLayout1.xml\"/>\n</Relationships>";
    }

    private final String buildSlideMasterRelsXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">\n  <Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideLayout\" Target=\"../slideLayouts/slideLayout1.xml\"/>\n</Relationships>";
    }

    private final String buildSlideLayoutRelsXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">\n  <Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideMaster\" Target=\"../slideMasters/slideMaster1.xml\"/>\n</Relationships>";
    }
}
