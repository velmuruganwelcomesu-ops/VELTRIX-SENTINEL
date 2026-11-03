package com.example.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.example.data.EhsActivityRecord;
import com.example.data.EhsGovernanceCategories;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: EhsReportExporter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ6\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ>\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ6\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fJ\u001e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\f¨\u0006\u001a"}, d2 = {"Lcom/example/utils/EhsReportExporter;", "", "<init>", "()V", "generatePdfReport", "Ljava/io/File;", "context", "Landroid/content/Context;", "activities", "", "Lcom/example/data/EhsActivityRecord;", "preparerName", "", "preparerDesignation", "fromDate", "toDate", "reportingPeriodTitle", "generateExcelReport", "xmlEscape", "str", "shareGeneratedFile", "", "file", "mimeType", "chooserTitle", "viewGeneratedFile", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class EhsReportExporter {
    public static final int $stable = 0;
    public static final EhsReportExporter INSTANCE = new EhsReportExporter();

    private EhsReportExporter() {
    }

    public final File generatePdfReport(Context context, List<EhsActivityRecord> activities, String preparerName, String preparerDesignation, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activities, "activities");
        Intrinsics.checkNotNullParameter(preparerName, "preparerName");
        Intrinsics.checkNotNullParameter(preparerDesignation, "preparerDesignation");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return generatePdfReport(context, activities, preparerName, preparerDesignation, fromDate + " to " + toDate);
    }

    public final File generatePdfReport(Context context, List<EhsActivityRecord> activities, String preparerName, String preparerDesignation, String reportingPeriodTitle) {
        int completedCount;
        int inProgressCount;
        PdfDocument pdfDoc;
        int pendingCount;
        Paint subheaderPaint;
        Paint subheaderPaint2;
        float y;
        PdfDocument pdfDoc2;
        File outputFile;
        FileOutputStream fos;
        Paint sectionTitlePaint;
        Paint linePaint;
        PdfDocument pdfDoc3;
        int pageHeight;
        PdfDocument.PageInfo pageInfo;
        Canvas canvas;
        PdfDocument.Page page;
        float y2;
        int i;
        Object obj;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activities, "activities");
        Intrinsics.checkNotNullParameter(preparerName, "preparerName");
        Intrinsics.checkNotNullParameter(preparerDesignation, "preparerDesignation");
        Intrinsics.checkNotNullParameter(reportingPeriodTitle, "reportingPeriodTitle");
        PdfDocument pdfDoc4 = new PdfDocument();
        Paint textPaint = new Paint(1);
        textPaint.setColor(Color.rgb(30, 41, 59));
        textPaint.setTextSize(10.0f);
        Paint headerPaint = new Paint(1);
        headerPaint.setColor(Color.rgb(15, 23, 42));
        headerPaint.setTextSize(18.0f);
        headerPaint.setFakeBoldText(true);
        Paint subheaderPaint3 = new Paint(1);
        subheaderPaint3.setColor(Color.rgb(71, 85, 105));
        subheaderPaint3.setTextSize(11.0f);
        Paint linePaint2 = new Paint(1);
        linePaint2.setColor(Color.rgb(30, 58, 138));
        linePaint2.setTextSize(12.0f);
        linePaint2.setFakeBoldText(true);
        Paint paint = new Paint(1);
        paint.setColor(Color.rgb(15, 23, 42));
        paint.setTextSize(9.5f);
        paint.setFakeBoldText(true);
        Paint tableHeaderPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(Color.rgb(226, 232, 240));
        paint2.setStrokeWidth(1.0f);
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint(1);
        paint3.setColor(Color.rgb(248, 250, 252));
        paint3.setStyle(Paint.Style.FILL);
        Paint cardBgPaint = paint3;
        PdfDocument.PageInfo pageInfo2 = new PdfDocument.PageInfo.Builder(595, 842, 1).create();
        PdfDocument.Page page2 = pdfDoc4.startPage(pageInfo2);
        Canvas canvas2 = page2.getCanvas();
        canvas2.drawText("EHS Daily Activity Report", 40.0f, 45.0f, headerPaint);
        float y3 = 45.0f + 18.0f;
        canvas2.drawText("Reporting Period: " + reportingPeriodTitle, 40.0f, y3, subheaderPaint3);
        float y4 = y3 + 16.0f;
        Paint paint4 = new Paint(1);
        paint4.setColor(Color.rgb(51, 65, 85));
        paint4.setTextSize(10.5f);
        paint4.setFakeBoldText(true);
        Unit unit = Unit.INSTANCE;
        canvas2.drawText("Prepared By: " + preparerName + " • " + preparerDesignation, 40.0f, y4, paint4);
        float y5 = y4 + 12.0f;
        canvas2.drawLine(40.0f, y5, 595 - 40, y5, paint2);
        float y6 = y5 + 20.0f;
        int totalCount = activities.size();
        List<EhsActivityRecord> list = activities;
        int i5 = 0;
        if ((list instanceof Collection) && list.isEmpty()) {
            completedCount = 0;
        } else {
            completedCount = 0;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Iterable iterable = list;
                int i6 = i5;
                if (StringsKt.equals(((EhsActivityRecord) it.next()).getStatus(), "Completed", true)) {
                    completedCount++;
                    if (completedCount < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                    list = iterable;
                    i5 = i6;
                } else {
                    list = iterable;
                    i5 = i6;
                }
            }
        }
        List<EhsActivityRecord> list2 = activities;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            pdfDoc = pdfDoc4;
            inProgressCount = 0;
        } else {
            inProgressCount = 0;
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                int i7 = inProgressCount;
                PdfDocument pdfDoc5 = pdfDoc4;
                if (StringsKt.equals(((EhsActivityRecord) it2.next()).getStatus(), MaterialFollowUpUtils.STATUS_IN_PROGRESS, true)) {
                    inProgressCount = i7 + 1;
                    if (inProgressCount < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                    pdfDoc4 = pdfDoc5;
                } else {
                    inProgressCount = i7;
                    pdfDoc4 = pdfDoc5;
                }
            }
            pdfDoc = pdfDoc4;
        }
        List<EhsActivityRecord> list3 = activities;
        int pageHeight2 = 842;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            subheaderPaint = subheaderPaint3;
            pendingCount = 0;
        } else {
            pendingCount = 0;
            Iterator it3 = list3.iterator();
            while (it3.hasNext()) {
                int i8 = pendingCount;
                Paint subheaderPaint4 = subheaderPaint3;
                if (StringsKt.equals(((EhsActivityRecord) it3.next()).getStatus(), "Pending", true)) {
                    pendingCount = i8 + 1;
                    if (pendingCount < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                    subheaderPaint3 = subheaderPaint4;
                } else {
                    pendingCount = i8;
                    subheaderPaint3 = subheaderPaint4;
                }
            }
            subheaderPaint = subheaderPaint3;
        }
        RectF summaryRect = new RectF(40.0f, y6, 595 - 40, y6 + 68.0f);
        canvas2.drawRoundRect(summaryRect, 6.0f, 6.0f, cardBgPaint);
        canvas2.drawRoundRect(summaryRect, 6.0f, 6.0f, paint2);
        canvas2.drawText("EXECUTIVE SUMMARY", 52.0f, y6 + 18.0f, linePaint2);
        canvas2.drawText("Total Activities Logged: " + totalCount, 52.0f, y6 + 36.0f, textPaint);
        Paint paint5 = new Paint(textPaint);
        Paint statusPaint = paint2;
        paint5.setColor(Color.rgb(22, 101, 52));
        Unit unit2 = Unit.INSTANCE;
        canvas2.drawText("Completed: " + completedCount, 220.0f, y6 + 36.0f, paint5);
        Paint paint6 = new Paint(textPaint);
        paint6.setColor(Color.rgb(180, 83, 9));
        Unit unit3 = Unit.INSTANCE;
        canvas2.drawText("In Progress: " + inProgressCount, 340.0f, y6 + 36.0f, paint6);
        Paint paint7 = new Paint(textPaint);
        paint7.setColor(Color.rgb(185, 28, 28));
        Unit unit4 = Unit.INSTANCE;
        canvas2.drawText("Pending: " + pendingCount, 460.0f, y6 + 36.0f, paint7);
        int completionRate = totalCount > 0 ? (completedCount * 100) / totalCount : 100;
        canvas2.drawText("Activity Completion Rate: " + completionRate + "%", 52.0f, y6 + 54.0f, textPaint);
        float y7 = y6 + 85.0f;
        canvas2.drawText("CATEGORY-WISE ACTIVITY SUMMARY", 40.0f, y7, linePaint2);
        float y8 = y7 + 14.0f;
        Object categories = EhsGovernanceCategories.INSTANCE.getALL_CATEGORIES();
        float colW = 595 - 80.0f;
        Paint paint8 = new Paint();
        paint8.setColor(Color.rgb(241, 245, 249));
        Unit unit5 = Unit.INSTANCE;
        canvas2.drawRect(40.0f, y8, colW + 40.0f, y8 + 18.0f, paint8);
        canvas2.drawText("Category", 48.0f, y8 + 13.0f, tableHeaderPaint);
        canvas2.drawText("Total", 320.0f, y8 + 13.0f, tableHeaderPaint);
        canvas2.drawText("Completed", 380.0f, y8 + 13.0f, tableHeaderPaint);
        canvas2.drawText(MaterialFollowUpUtils.STATUS_IN_PROGRESS, 450.0f, y8 + 13.0f, tableHeaderPaint);
        canvas2.drawText("Pending", 515.0f, y8 + 13.0f, tableHeaderPaint);
        float y9 = y8 + 20.0f;
        for (String str : (Iterable) categories) {
            int completionRate2 = completionRate;
            Collection arrayList = new ArrayList();
            for (Object obj2 : activities) {
                Object categories2 = categories;
                float colW2 = colW;
                if (Intrinsics.areEqual(((EhsActivityRecord) obj2).getCategory(), str)) {
                    arrayList.add(obj2);
                }
                categories = categories2;
                colW = colW2;
            }
            Object categories3 = categories;
            float colW3 = colW;
            List list4 = (List) arrayList;
            int size = list4.size();
            List list5 = list4;
            if ((list5 instanceof Collection) && list5.isEmpty()) {
                i2 = 0;
            } else {
                i2 = 0;
                Iterator it4 = list5.iterator();
                while (it4.hasNext()) {
                    Iterable iterable2 = list5;
                    int i9 = i2;
                    if (StringsKt.equals(((EhsActivityRecord) it4.next()).getStatus(), "Completed", true)) {
                        i2 = i9 + 1;
                        if (i2 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        list5 = iterable2;
                    } else {
                        list5 = iterable2;
                        i2 = i9;
                    }
                }
            }
            List list6 = list4;
            int i10 = i2;
            if ((list6 instanceof Collection) && list6.isEmpty()) {
                i3 = 0;
            } else {
                i3 = 0;
                Iterator it5 = list6.iterator();
                while (it5.hasNext()) {
                    Iterable iterable3 = list6;
                    int i11 = i3;
                    if (StringsKt.equals(((EhsActivityRecord) it5.next()).getStatus(), MaterialFollowUpUtils.STATUS_IN_PROGRESS, true)) {
                        i3 = i11 + 1;
                        if (i3 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        list6 = iterable3;
                    } else {
                        list6 = iterable3;
                        i3 = i11;
                    }
                }
            }
            List list7 = list4;
            int i12 = i3;
            if ((list7 instanceof Collection) && list7.isEmpty()) {
                i4 = 0;
            } else {
                i4 = 0;
                Iterator it6 = list7.iterator();
                while (it6.hasNext()) {
                    Iterable iterable4 = list7;
                    int i13 = i4;
                    if (StringsKt.equals(((EhsActivityRecord) it6.next()).getStatus(), "Pending", true)) {
                        i4 = i13 + 1;
                        if (i4 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        list7 = iterable4;
                    } else {
                        list7 = iterable4;
                        i4 = i13;
                    }
                }
            }
            canvas2.drawText(str, 48.0f, y9 + 12.0f, textPaint);
            canvas2.drawText(String.valueOf(size), 325.0f, y9 + 12.0f, textPaint);
            canvas2.drawText(String.valueOf(i10), 390.0f, y9 + 12.0f, textPaint);
            canvas2.drawText(String.valueOf(i12), 460.0f, y9 + 12.0f, textPaint);
            canvas2.drawText(String.valueOf(i4), 525.0f, y9 + 12.0f, textPaint);
            canvas2.drawLine(40.0f, y9 + 16.0f, colW3 + 40.0f, y9 + 16.0f, statusPaint);
            y9 += 18.0f;
            completionRate = completionRate2;
            categories = categories3;
            colW = colW3;
        }
        float y10 = y9 + 18.0f;
        canvas2.drawText("DAILY ACTIVITY TREND", 40.0f, y10, linePaint2);
        float y11 = y10 + 14.0f;
        List<EhsActivityRecord> list8 = activities;
        int i14 = 0;
        Map linkedHashMap = new LinkedHashMap();
        for (Object obj3 : list8) {
            String date = ((EhsActivityRecord) obj3).getDate();
            List list9 = list8;
            float y12 = y11;
            Object obj4 = linkedHashMap.get(date);
            if (obj4 == null) {
                obj = new ArrayList();
                i = i14;
                linkedHashMap.put(date, obj);
            } else {
                i = i14;
                obj = obj4;
            }
            ((List) obj).add(obj3);
            list8 = list9;
            y11 = y12;
            i14 = i;
        }
        float y13 = y11;
        SortedMap dateGrouped = MapsKt.toSortedMap(linkedHashMap);
        if (dateGrouped.isEmpty()) {
            subheaderPaint2 = subheaderPaint;
            canvas2.drawText("No activity records available for this date period.", 48.0f, y13 + 12.0f, subheaderPaint2);
            y = y13 + 22.0f;
        } else {
            subheaderPaint2 = subheaderPaint;
            StringBuilder dateSummaryText = new StringBuilder();
            Set entrySet = dateGrouped.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
            Iterable<Map.Entry> take = CollectionsKt.take(entrySet, 8);
            int i15 = 0;
            for (Map.Entry entry : take) {
                Intrinsics.checkNotNull(entry);
                dateSummaryText.append(((String) entry.getKey()) + ": " + ((List) entry.getValue()).size() + " activities • ");
                take = take;
                i15 = i15;
                dateGrouped = dateGrouped;
            }
            String sb = dateSummaryText.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            String summaryStr = StringsKt.trimEnd(sb, new char[]{' ', 8226});
            canvas2.drawText(StringsKt.take(summaryStr, 90), 48.0f, y13 + 12.0f, textPaint);
            y = y13 + 22.0f;
        }
        float y14 = y + 10.0f;
        canvas2.drawText("DETAILED ACTIVITY LIST", 40.0f, y14, linePaint2);
        Iterator it7 = activities.iterator();
        Canvas canvas3 = canvas2;
        float y15 = y14 + 16.0f;
        PdfDocument.PageInfo pageInfo3 = pageInfo2;
        int pageNumber = 1;
        PdfDocument.Page page3 = page2;
        int i16 = 0;
        while (true) {
            Iterator it8 = it7;
            if (!it7.hasNext()) {
                PdfDocument pdfDoc6 = pdfDoc;
                canvas3.drawText("Page " + pageNumber, (595 / 2.0f) - 15.0f, pageHeight2 - 25.0f, subheaderPaint2);
                pdfDoc6.finishPage(page3);
                try {
                    String safePeriod = StringsKt.take(new Regex("[^a-zA-Z0-9_-]").replace(reportingPeriodTitle, "_"), 40);
                    try {
                        String fileName = "EHS_Daily_Activity_Report_" + safePeriod + "_" + System.currentTimeMillis() + ".pdf";
                        File file = new File(context.getCacheDir(), "ehs_reports");
                        file.mkdirs();
                        outputFile = new File(file, fileName);
                        fos = new FileOutputStream(outputFile);
                        pdfDoc2 = pdfDoc6;
                    } catch (Exception e) {
                        e = e;
                        pdfDoc2 = pdfDoc6;
                    }
                } catch (Exception e2) {
                    e = e2;
                    pdfDoc2 = pdfDoc6;
                }
                try {
                    pdfDoc2.writeTo(fos);
                    fos.close();
                    pdfDoc2.close();
                    return outputFile;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    pdfDoc2.close();
                    return null;
                }
            }
            int index = i16;
            int i17 = i16 + 1;
            EhsActivityRecord act = (EhsActivityRecord) it8.next();
            String photoUri = act.getPhotoUri();
            float estimatedHeight = !(photoUri == null || StringsKt.isBlank(photoUri)) ? 110.0f : 68.0f;
            if (y15 + estimatedHeight > pageHeight2 - 50) {
                sectionTitlePaint = linePaint2;
                pageHeight = pageHeight2;
                canvas3.drawText("Page " + pageNumber, (595 / 2.0f) - 15.0f, pageHeight - 25.0f, subheaderPaint2);
                pdfDoc3 = pdfDoc;
                pdfDoc3.finishPage(page3);
                pageNumber++;
                PdfDocument.PageInfo pageInfo4 = new PdfDocument.PageInfo.Builder(595, pageHeight, pageNumber).create();
                PdfDocument.Page page4 = pdfDoc3.startPage(pageInfo4);
                Canvas canvas4 = page4.getCanvas();
                pageInfo = pageInfo4;
                canvas4.drawText("EHS Daily Activity Report — Continued (Page " + pageNumber + ")", 40.0f, 45.0f, subheaderPaint2);
                float y16 = 45.0f + 20.0f;
                canvas4.drawLine(40.0f, y16, 595 - 40, y16, statusPaint);
                linePaint = statusPaint;
                page = page4;
                canvas = canvas4;
                y2 = y16 + 16.0f;
            } else {
                float y17 = y15;
                sectionTitlePaint = linePaint2;
                linePaint = statusPaint;
                pdfDoc3 = pdfDoc;
                pageHeight = pageHeight2;
                pageInfo = pageInfo3;
                canvas = canvas3;
                page = page3;
                y2 = y17;
            }
            int pageNumber2 = pageNumber;
            int pageNumber3 = 595 - 40;
            PdfDocument.Page page5 = page;
            RectF itemRect = new RectF(40.0f, y2, pageNumber3, y2 + estimatedHeight);
            canvas.drawRoundRect(itemRect, 4.0f, 4.0f, cardBgPaint);
            canvas.drawRoundRect(itemRect, 4.0f, 4.0f, linePaint);
            String status = act.getStatus();
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            String lowerCase = status.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int statusColor = Intrinsics.areEqual(lowerCase, "completed") ? Color.rgb(34, 197, 94) : Intrinsics.areEqual(lowerCase, "in progress") ? Color.rgb(245, 158, 11) : Color.rgb(239, 68, 68);
            Paint statusPaint2 = new Paint();
            statusPaint2.setColor(statusColor);
            float y18 = y2;
            Canvas canvas5 = canvas;
            canvas5.drawRect(40.0f, y18, 44.0f, y2 + estimatedHeight, statusPaint2);
            String titleText = (index + 1) + ". " + act.getActivityName() + " [" + act.getCategory() + "]";
            canvas5.drawText(StringsKt.take(titleText, 55), 52.0f, y18 + 16.0f, tableHeaderPaint);
            Paint tableHeaderPaint2 = tableHeaderPaint;
            String statusBadgeText = "Status: " + act.getStatus() + " • " + act.getDate();
            Paint paint9 = new Paint(textPaint);
            Paint cardBgPaint2 = cardBgPaint;
            paint9.setFakeBoldText(true);
            Unit unit6 = Unit.INSTANCE;
            canvas5.drawText(statusBadgeText, 595 - 220, y18 + 16.0f, paint9);
            String desc = !StringsKt.isBlank(act.getDescription()) ? "Description: " + act.getDescription() : "Description: -";
            canvas5.drawText(StringsKt.take(desc, 85), 52.0f, y18 + 32.0f, textPaint);
            String remarks = !StringsKt.isBlank(act.getRemarks()) ? "Remarks: " + act.getRemarks() : "Remarks: None";
            canvas5.drawText(StringsKt.take(remarks, 85), 52.0f, y18 + 46.0f, textPaint);
            String photoUri2 = act.getPhotoUri();
            if (!(photoUri2 == null || StringsKt.isBlank(photoUri2))) {
                Paint paint10 = new Paint(textPaint);
                paint10.setColor(Color.rgb(37, 99, 235));
                Unit unit7 = Unit.INSTANCE;
                canvas5.drawText("Attachment: Photo Attached", 52.0f, y18 + 60.0f, paint10);
                try {
                    Uri uri = Uri.parse(act.getPhotoUri());
                    InputStream inputStream = context.getContentResolver().openInputStream(uri);
                    if (inputStream != null) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 4;
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, options);
                        inputStream.close();
                        if (bitmap != null) {
                            Rect destRect = new Rect(52, (int) (y18 + 66.0f), 102, (int) (y18 + 104.0f));
                            canvas5.drawBitmap(bitmap, (Rect) null, destRect, (Paint) null);
                        }
                    }
                } catch (Exception e4) {
                    canvas5.drawText("[Photo Attachment on File]", 52.0f, y18 + 74.0f, subheaderPaint2);
                }
            }
            canvas3 = canvas5;
            statusPaint = linePaint;
            tableHeaderPaint = tableHeaderPaint2;
            linePaint2 = sectionTitlePaint;
            pageInfo3 = pageInfo;
            pageNumber = pageNumber2;
            page3 = page5;
            cardBgPaint = cardBgPaint2;
            pdfDoc = pdfDoc3;
            pageHeight2 = pageHeight;
            it7 = it8;
            y15 = y18 + estimatedHeight + 8.0f;
            i16 = i17;
        }
    }

    public final File generateExcelReport(Context context, List<EhsActivityRecord> activities, String preparerName, String preparerDesignation, String fromDate, String toDate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activities, "activities");
        Intrinsics.checkNotNullParameter(preparerName, "preparerName");
        Intrinsics.checkNotNullParameter(preparerDesignation, "preparerDesignation");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return generateExcelReport(context, activities, preparerName, preparerDesignation, fromDate + " to " + toDate);
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x062f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0632  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.File generateExcelReport(android.content.Context r49, java.util.List<com.example.data.EhsActivityRecord> r50, java.lang.String r51, java.lang.String r52, java.lang.String r53) {
        /*
            Method dump skipped, instructions count: 1960
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.EhsReportExporter.generateExcelReport(android.content.Context, java.util.List, java.lang.String, java.lang.String, java.lang.String):java.io.File");
    }

    private final String xmlEscape(String str) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "&", "&amp;", false, 4, (Object) null), "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null), "\"", "&quot;", false, 4, (Object) null), "'", "&apos;", false, 4, (Object) null);
    }

    public final void shareGeneratedFile(Context context, File file, String mimeType, String chooserTitle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(chooserTitle, "chooserTitle");
        try {
            Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
            Intent shareIntent = new Intent("android.intent.action.SEND");
            shareIntent.setType(mimeType);
            shareIntent.putExtra("android.intent.extra.STREAM", uri);
            shareIntent.addFlags(1);
            context.startActivity(Intent.createChooser(shareIntent, chooserTitle));
        } catch (Exception e) {
            Toast.makeText(context, "Unable to share file: " + e.getMessage(), 1).show();
        }
    }

    public final void viewGeneratedFile(Context context, File file, String mimeType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        try {
            Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
            Intent viewIntent = new Intent("android.intent.action.VIEW");
            viewIntent.setDataAndType(uri, mimeType);
            viewIntent.addFlags(1);
            context.startActivity(viewIntent);
        } catch (Exception e) {
            Toast.makeText(context, "No app available to open this file. You can share it instead.", 0).show();
        }
    }
}
