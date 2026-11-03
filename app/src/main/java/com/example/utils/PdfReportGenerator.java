package com.example.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.example.R;
import com.example.data.Company;
import com.example.data.Observation;
import com.example.data.SafetyTraining;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* compiled from: PdfReportGenerator.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002J.\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002J \u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002JB\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000eH\u0002J&\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,2\u0006\u0010%\u001a\u00020&H\u0002JT\u0010-\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u0002010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J@\u00102\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\u000e2\f\u00104\u001a\b\u0012\u0004\u0012\u0002050\u000b2\u0006\u00106\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011Jh\u00107\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u000e2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010:\u001a\b\u0012\u0004\u0012\u0002010\u000b2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011JÊ\u0001\u0010<\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u000b2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002010\u000b2\f\u00104\u001a\b\u0012\u0004\u0012\u0002050\u000b2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010:\u001a\b\u0012\u0004\u0012\u0002010\u000b2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010D\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010E\u001a\u00020\u00162\b\b\u0002\u0010F\u001a\u00020\u0016H\u0002J4\u0010G\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020,2\b\u0010J\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010K\u001a\u00020\u0016H\u0002¨\u0006L"}, d2 = {"Lcom/example/utils/PdfReportGenerator;", "", "<init>", "()V", "generatePdfReport", "", "context", "Landroid/content/Context;", "company", "Lcom/example/data/Company;", "observations", "", "Lcom/example/data/Observation;", "dateRangeText", "", "presenterName", "outputFile", "Ljava/io/File;", "decodeSampledBitmapFromFile", "Landroid/graphics/Bitmap;", "filePath", "reqWidth", "", "reqHeight", "decodeSampledBitmapFromStream", "uri", "Landroid/net/Uri;", "calculateInSampleSize", "options", "Landroid/graphics/BitmapFactory$Options;", "drawPhoto", "", "canvas", "Landroid/graphics/Canvas;", "photoUriStr", "rect", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "titlePaint", "placeholderText", "wrapText", "text", "maxWidth", "", "generateConsolidatedMultiCompanyPdfReport", "selectedCompanies", "allObservations", "allIncidents", "Lcom/example/data/IncidentRecord;", "generateSafetyTrainingsPdfReport", "companyName", "trainings", "Lcom/example/data/SafetyTraining;", "monthYearText", "generateMonthComparisonPdfReport", "currentObs", "previousObs", "currentIncidents", "previousIncidents", "generateUnifiedMasterPdfReport", "selectedReportKeys", "unsafeActObservations", "unsafeConditionObservations", "safetyStarObservations", "rosterList", "Lcom/example/data/ResponsiblePerson;", "incidents", "loadVectorLogoBitmap", "width", "height", "drawWatermark", "pageWidth", "pageHeight", "logoBitmap", "alpha", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class PdfReportGenerator {
    public static final int $stable = 0;
    public static final PdfReportGenerator INSTANCE = new PdfReportGenerator();

    private PdfReportGenerator() {
    }

    public static /* synthetic */ boolean generatePdfReport$default(PdfReportGenerator pdfReportGenerator, Context context, Company company, List list, String str, String str2, File file, int i, Object obj) {
        String str3;
        if ((i & 16) == 0) {
            str3 = str2;
        } else {
            str3 = "J. VELMURUGAN";
        }
        return pdfReportGenerator.generatePdfReport(context, company, list, str, str3, file);
    }

    public final boolean generatePdfReport(Context context, Company company, List<Observation> observations, String dateRangeText, String presenterName, File outputFile) {
        String compName;
        String str;
        float f;
        float f2;
        float f3;
        float f4;
        RectF bottomMottoRect;
        PdfDocument pdfDocument;
        int slideNum;
        String safeDateRange;
        Canvas canvas;
        int pageHeight;
        int goldAccent;
        String presenter;
        Paint titlePaint;
        int pageWidth;
        Bitmap appLogoBitmap;
        PdfDocument.Page page;
        float f5;
        int navyColor;
        int greenHeaderColor;
        String starEmpDept;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(company, "company");
        Intrinsics.checkNotNullParameter(observations, "observations");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(presenterName, "presenterName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        PdfDocument pdfDocument2 = new PdfDocument();
        int pageWidth2 = 842;
        int pageWidth3 = 595;
        int redHeaderColor = Color.parseColor("#DC2626");
        int greenHeaderColor2 = Color.parseColor("#16A34A");
        int navyColor2 = Color.parseColor("#0F2744");
        int deepCanvasColor = Color.parseColor("#0A192F");
        int lightSlateBg = Color.parseColor("#F8FAFC");
        int cardBorderBefore = Color.parseColor("#FCA5A5");
        int cardBorderAfter = Color.parseColor("#86EFAC");
        int goldAccent2 = Color.parseColor("#F59E0B");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        String name = company.getName();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String compName2 = name.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(compName2, "toUpperCase(...)");
        if (company.getDivision().length() > 0) {
            String division = company.getDivision();
            Locale locale2 = Locale.getDefault();
            compName = compName2;
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
            str = division.toUpperCase(locale2);
            Intrinsics.checkNotNullExpressionValue(str, "toUpperCase(...)");
        } else {
            compName = compName2;
            str = "";
        }
        String divName = str;
        Locale locale3 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
        String presenter2 = presenterName.toUpperCase(locale3);
        Intrinsics.checkNotNullExpressionValue(presenter2, "toUpperCase(...)");
        String monthYear = new SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(new Date());
        String safeDateRange2 = !StringsKt.isBlank(dateRangeText) ? dateRangeText : monthYear;
        Bitmap appLogoBitmap2 = loadVectorLogoBitmap(context, 160, 160);
        List<Observation> effectiveObservations = observations.isEmpty() ? CollectionsKt.listOf(new Observation(0L, company.getId(), "ZERO-NC", "Entire Facility", "Good Practice", "Zero Non-Conformance (SNC) observations recorded for the specified audit period. 100% compliance maintained.", "Maintain existing high standard safety practices, housekeeping, and proactive hazard reporting.", "EHS Team", (String) null, (String) null, "N/A", (String) null, (String) null, (String) null, "Active preventive controls maintained.", (String) null, (String) null, true, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0L, 268286721, (DefaultConstructorMarker) null)) : observations;
        int totalSlides = effectiveObservations.size() + 1 + 1;
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(842, 595, 1).create();
        PdfDocument.Page page2 = pdfDocument2.startPage(pageInfo);
        Canvas canvas2 = page2.getCanvas();
        paint.setColor(deepCanvasColor);
        canvas2.drawRect(0.0f, 0.0f, 842, 595, paint);
        Intrinsics.checkNotNull(canvas2);
        int lightSlateBg2 = lightSlateBg;
        int cardBorderAfter2 = cardBorderAfter;
        int goldAccent3 = goldAccent2;
        Paint titlePaint2 = paint2;
        int navyColor3 = navyColor2;
        String compName3 = compName;
        int greenHeaderColor3 = greenHeaderColor2;
        String presenter3 = presenter2;
        boolean z = true;
        String safeDateRange3 = safeDateRange2;
        drawWatermark(canvas2, 842, 595, appLogoBitmap2, 20);
        Bitmap appLogoBitmap3 = appLogoBitmap2;
        paint.setColor(Color.parseColor("#2563EB"));
        canvas2.drawRect(0.0f, 0.0f, 842, 6.0f, paint);
        Paint paint3 = paint;
        RectF topBannerRect = new RectF(50.0f, 25.0f, 842 - 50.0f, 75.0f);
        paint3.setColor(Color.parseColor("#0F2744"));
        canvas2.drawRoundRect(topBannerRect, 8.0f, 8.0f, paint3);
        paint3.setColor(Color.parseColor("#3B82F6"));
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(1.5f);
        canvas2.drawRoundRect(topBannerRect, 8.0f, 8.0f, paint3);
        paint3.setStyle(Paint.Style.FILL);
        if (appLogoBitmap3 != null) {
            f = 50.0f;
            RectF logoRect = new RectF(65.0f, 32.0f, 95.0f, 68.0f);
            canvas2.drawBitmap(appLogoBitmap3, (Rect) null, logoRect, paint3);
        } else {
            f = 50.0f;
        }
        titlePaint2.setColor(-1);
        titlePaint2.setTextSize(15.0f);
        titlePaint2.setTextAlign(Paint.Align.CENTER);
        canvas2.drawText("🛡️ VELTRIX SENTINEL EHS INDUSTRIAL SAFETY AUDIT PORTAL", 842 / 2.0f, 56.0f, titlePaint2);
        RectF centerCard = new RectF(f, 90.0f, 842 - f, 595 - 95.0f);
        paint3.setColor(Color.parseColor("#112240"));
        canvas2.drawRoundRect(centerCard, 12.0f, 12.0f, paint3);
        paint3.setColor(goldAccent3);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(2.0f);
        canvas2.drawRoundRect(centerCard, 12.0f, 12.0f, paint3);
        paint3.setStyle(Paint.Style.FILL);
        titlePaint2.setColor(Color.parseColor("#EF4444"));
        titlePaint2.setTextSize(26.0f);
        titlePaint2.setTextAlign(Paint.Align.CENTER);
        canvas2.drawText("SAFETY NON-CONFORMANCE REPORT", 842 / 2.0f, 155.0f, titlePaint2);
        paint3.setColor(Color.parseColor("#94A3B8"));
        paint3.setTextSize(11.0f);
        paint3.setTextAlign(Paint.Align.CENTER);
        canvas2.drawText("ISO 45001 / OSHA OCCUPATIONAL HEALTH & SAFETY AUDIT DOSSIER", 842 / 2.0f, 180.0f, paint3);
        titlePaint2.setColor(Color.parseColor("#FBBF24"));
        titlePaint2.setTextSize(22.0f);
        canvas2.drawText(compName3, 842 / 2.0f, 235.0f, titlePaint2);
        if (divName.length() > 0) {
            titlePaint2.setTextSize(16.0f);
            titlePaint2.setColor(Color.parseColor("#60A5FA"));
            f3 = 2.0f;
            f2 = 22.0f;
            canvas2.drawText(divName, 842 / 2.0f, 270.0f, titlePaint2);
        } else {
            f2 = 22.0f;
            f3 = 2.0f;
        }
        RectF metaPill = new RectF((842 / f3) - 240.0f, 305.0f, (842 / f3) + 240.0f, 355.0f);
        paint3.setColor(Color.parseColor("#1E293B"));
        canvas2.drawRoundRect(metaPill, 8.0f, 8.0f, paint3);
        paint3.setColor(Color.parseColor("#334155"));
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(1.0f);
        canvas2.drawRoundRect(metaPill, 8.0f, 8.0f, paint3);
        paint3.setStyle(Paint.Style.FILL);
        titlePaint2.setTextSize(12.0f);
        titlePaint2.setColor(Color.parseColor("#E2E8F0"));
        canvas2.drawText("AUDIT PERIOD: " + safeDateRange3 + "   |   TOTAL FINDINGS: " + effectiveObservations.size() + " ITEMS", 842 / 2.0f, 335.0f, titlePaint2);
        titlePaint2.setTextSize(13.0f);
        titlePaint2.setColor(Color.parseColor("#34D399"));
        canvas2.drawText("EHS AUDITOR & PRESENTER: " + presenter3, 842 / 2.0f, 400.0f, titlePaint2);
        RectF bottomMottoRect2 = new RectF(50.0f, 595 - 80.0f, 842 - 50.0f, 595 - 30.0f);
        paint3.setColor(Color.parseColor("#065F46"));
        canvas2.drawRoundRect(bottomMottoRect2, 8.0f, 8.0f, paint3);
        paint3.setColor(Color.parseColor("#10B981"));
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(1.5f);
        canvas2.drawRoundRect(bottomMottoRect2, 8.0f, 8.0f, paint3);
        paint3.setStyle(Paint.Style.FILL);
        titlePaint2.setTextSize(13.0f);
        titlePaint2.setColor(-1);
        canvas2.drawText("⚠️ THINK SAFE  •  WORK SAFE  •  GO HOME SAFELY ⚠️", 842 / 2.0f, 595 - 48.0f, titlePaint2);
        PdfDocument pdfDocument3 = pdfDocument2;
        pdfDocument3.finishPage(page2);
        int i = 0;
        PdfDocument.PageInfo pageInfo2 = pageInfo;
        for (Observation obs : effectiveObservations) {
            int index = i;
            int i2 = i + 1;
            int slideNum2 = index + 2;
            PdfDocument.PageInfo pageInfo3 = new PdfDocument.PageInfo.Builder(pageWidth2, pageWidth3, slideNum2).create();
            PdfDocument.Page page3 = pdfDocument3.startPage(pageInfo3);
            Canvas canvas3 = page3.getCanvas();
            Bitmap appLogoBitmap4 = appLogoBitmap3;
            boolean isSafetyStar = StringsKt.equals(obs.getFindingType(), "Safety Star", z);
            if (isSafetyStar) {
                paint3.setColor(Color.parseColor("#F8FAFC"));
                Paint paint4 = paint3;
                canvas3.drawRect(0.0f, 0.0f, pageWidth2, pageWidth3, paint4);
                paint3.setColor(Color.parseColor("#064E3B"));
                canvas3.drawRect(0.0f, 0.0f, pageWidth2, 52.0f, paint4);
                paint3.setColor(Color.parseColor("#F59E0B"));
                canvas3.drawRect(0.0f, 49.0f, pageWidth2, 52.0f, paint4);
                titlePaint2.setColor(-1);
                titlePaint2.setTextSize(14.0f);
                titlePaint2.setTextAlign(Paint.Align.LEFT);
                canvas3.drawText("⭐ SAFETY STAR COMPLIANT EMPLOYEE RECOGNITION #" + (index + 1), 25.0f, 26.0f, titlePaint2);
                paint3.setColor(Color.parseColor("#A7F3D0"));
                paint3.setTextSize(10.0f);
                paint3.setTextAlign(Paint.Align.LEFT);
                String starHeaderSub = compName3 + " " + (divName.length() > 0 ? "• " + divName : "") + " • FACTORY TOUR COMPLIANCE RECOGNITION";
                canvas3.drawText(starHeaderSub, 25.0f, 42.0f, paint3);
                float rightX = 20.0f + 391.0f + 20.0f;
                bottomMottoRect = bottomMottoRect2;
                pdfDocument = pdfDocument3;
                slideNum = slideNum2;
                RectF starCardLeft = new RectF(20.0f, 62.0f, 20.0f + 391.0f, 62.0f + 488.0f);
                paint3.setColor(-1);
                canvas3.drawRoundRect(starCardLeft, 8.0f, 8.0f, paint3);
                paint3.setColor(Color.parseColor("#86EFAC"));
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(1.5f);
                canvas3.drawRoundRect(starCardLeft, 8.0f, 8.0f, paint3);
                paint3.setStyle(Paint.Style.FILL);
                RectF starBadgeLeft = new RectF(20.0f, 62.0f, 20.0f + 391.0f, 62.0f + 30.0f);
                paint3.setColor(Color.parseColor("#059669"));
                canvas3.drawRoundRect(starBadgeLeft, 8.0f, 8.0f, paint3);
                canvas3.drawRect(20.0f, 62.0f + 15.0f, 20.0f + 391.0f, 62.0f + 30.0f, paint3);
                canvas = canvas3;
                titlePaint2.setColor(-1);
                titlePaint2.setTextSize(11.5f);
                titlePaint2.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("⭐ COMPLIANT EMPLOYEE(S) DETAILS", (391.0f / 2.0f) + 20.0f, 62.0f + 20.0f, titlePaint2);
                float contentLeftX = 20.0f + 16.0f;
                float innerWidth = 391.0f - 32.0f;
                float curY = 48.0f + 62.0f;
                float leftX = contentLeftX + innerWidth;
                safeDateRange = safeDateRange3;
                RectF locBox = new RectF(contentLeftX, curY, leftX, curY + 32.0f);
                paint3.setColor(Color.parseColor("#F0FDF4"));
                canvas.drawRoundRect(locBox, 6.0f, 6.0f, paint3);
                paint3.setColor(Color.parseColor("#BBF7D0"));
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(1.0f);
                canvas.drawRoundRect(locBox, 6.0f, 6.0f, paint3);
                paint3.setStyle(Paint.Style.FILL);
                titlePaint2.setColor(Color.parseColor("#166534"));
                titlePaint2.setTextSize(9.5f);
                titlePaint2.setTextAlign(Paint.Align.LEFT);
                canvas.drawText("📍 WALKTHROUGH LOCATION:", contentLeftX + 10.0f, curY + 20.0f, titlePaint2);
                paint3.setColor(Color.parseColor("#C2185B"));
                paint3.setTextSize(9.5f);
                String location = obs.getLocation();
                if (StringsKt.isBlank(location)) {
                    location = "General Facility Walkthrough";
                }
                String locText = location;
                canvas.drawText(locText, 160.0f + contentLeftX, curY + 20.0f, paint3);
                float curY2 = curY + 42.0f;
                float empBoxHeight = curY2 + 160.0f;
                RectF empBox = new RectF(contentLeftX, curY2, contentLeftX + innerWidth, empBoxHeight);
                paint3.setColor(Color.parseColor("#F0FDF4"));
                canvas.drawRoundRect(empBox, 6.0f, 6.0f, paint3);
                paint3.setColor(Color.parseColor("#86EFAC"));
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(1.0f);
                canvas.drawRoundRect(empBox, 6.0f, 6.0f, paint3);
                paint3.setStyle(Paint.Style.FILL);
                float empTextY = curY2 + f2;
                titlePaint2.setColor(Color.parseColor("#166534"));
                titlePaint2.setTextSize(10.5f);
                canvas.drawText("👤 STAR EMPLOYEE INFORMATION", contentLeftX + 12.0f, empTextY, titlePaint2);
                float empTextY2 = empTextY + 10.0f;
                paint3.setColor(Color.parseColor("#86EFAC"));
                canvas.drawLine(contentLeftX + 12.0f, empTextY2, (contentLeftX + innerWidth) - 12.0f, empTextY2, paint3);
                float empTextY3 = empTextY2 + 18.0f;
                titlePaint2.setTextSize(9.5f);
                titlePaint2.setColor(Color.parseColor("#15803D"));
                canvas.drawText("Employee Name:", contentLeftX + 12.0f, empTextY3, titlePaint2);
                paint3.setTextSize(9.5f);
                paint3.setColor(Color.parseColor("#C2185B"));
                String employeeName = obs.getEmployeeName();
                if (StringsKt.isBlank(employeeName)) {
                    employeeName = "Safety Compliant Team Member";
                }
                String starEmpName = employeeName;
                canvas.drawText(starEmpName, 110.0f + contentLeftX, empTextY3, paint3);
                float empTextY4 = empTextY3 + f2;
                canvas.drawText("Employee ID No:", contentLeftX + 12.0f, empTextY4, titlePaint2);
                String employeeId = obs.getEmployeeId();
                if (StringsKt.isBlank(employeeId)) {
                    employeeId = "Recorded on Tour";
                }
                String starEmpId = employeeId;
                canvas.drawText(starEmpId, 110.0f + contentLeftX, empTextY4, paint3);
                float empTextY5 = empTextY4 + f2;
                canvas.drawText("Designation:", contentLeftX + 12.0f, empTextY5, titlePaint2);
                String employeeDesignation = obs.getEmployeeDesignation();
                if (StringsKt.isBlank(employeeDesignation)) {
                    employeeDesignation = "Plant Operative";
                }
                String starEmpDesig = employeeDesignation;
                canvas.drawText(starEmpDesig, 110.0f + contentLeftX, empTextY5, paint3);
                float empTextY6 = empTextY5 + f2;
                canvas.drawText("Department / Section:", contentLeftX + 12.0f, empTextY6, titlePaint2);
                if (StringsKt.isBlank(obs.getEmployeeDepartment())) {
                    String department = obs.getDepartment();
                    if (StringsKt.isBlank(department)) {
                        department = "Manufacturing";
                    }
                    starEmpDept = department;
                } else {
                    starEmpDept = obs.getEmployeeDepartment();
                }
                canvas.drawText(starEmpDept, 135.0f + contentLeftX, empTextY6, paint3);
                float curY3 = curY2 + 160.0f + 12.0f;
                float reasonBoxHeight = (488.0f - (curY3 - 62.0f)) - 14.0f;
                RectF reasonBox = new RectF(contentLeftX, curY3, contentLeftX + innerWidth, curY3 + reasonBoxHeight);
                paint3.setColor(Color.parseColor("#FEFCE8"));
                canvas.drawRoundRect(reasonBox, 6.0f, 6.0f, paint3);
                paint3.setColor(Color.parseColor("#FDE047"));
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(1.0f);
                canvas.drawRoundRect(reasonBox, 6.0f, 6.0f, paint3);
                paint3.setStyle(Paint.Style.FILL);
                float reasonTextY = curY3 + f2;
                titlePaint2.setColor(Color.parseColor("#854D0E"));
                titlePaint2.setTextSize(10.0f);
                canvas.drawText("⭐ REASON FOR CHOOSING AS A SAFETY STAR:", contentLeftX + 12.0f, reasonTextY, titlePaint2);
                float reasonTextY2 = reasonTextY + 8.0f;
                paint3.setColor(Color.parseColor("#FDE047"));
                canvas.drawLine(contentLeftX + 12.0f, reasonTextY2, (contentLeftX + innerWidth) - 12.0f, reasonTextY2, paint3);
                float reasonTextY3 = reasonTextY2 + 16.0f;
                paint3.setColor(Color.parseColor("#1E293B"));
                paint3.setTextSize(9.5f);
                String issueDetails = obs.getIssueDetails();
                if (StringsKt.isBlank(issueDetails)) {
                    issueDetails = "Observed strictly adhering to PPE guidelines and demonstrating proactive safety behavior.";
                }
                String starReason = issueDetails;
                List reasonLines = wrapText(starReason, innerWidth - 24.0f, paint3);
                Iterator it = CollectionsKt.take(reasonLines, 6).iterator();
                float reasonTextY4 = reasonTextY3;
                while (it.hasNext()) {
                    Iterator it2 = it;
                    String line = (String) it.next();
                    canvas.drawText(line, contentLeftX + 12.0f, reasonTextY4, paint3);
                    reasonTextY4 += 14.0f;
                    it = it2;
                    reasonLines = reasonLines;
                }
                RectF starCardRight = new RectF(rightX, 62.0f, rightX + 391.0f, 62.0f + 488.0f);
                paint3.setColor(-1);
                canvas.drawRoundRect(starCardRight, 8.0f, 8.0f, paint3);
                paint3.setColor(Color.parseColor("#FCD34D"));
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(1.5f);
                canvas.drawRoundRect(starCardRight, 8.0f, 8.0f, paint3);
                paint3.setStyle(Paint.Style.FILL);
                RectF starBadgeRight = new RectF(rightX, 62.0f, rightX + 391.0f, 62.0f + 30.0f);
                paint3.setColor(Color.parseColor("#D97706"));
                canvas.drawRoundRect(starBadgeRight, 8.0f, 8.0f, paint3);
                Paint paint5 = paint3;
                canvas.drawRect(rightX, 62.0f + 15.0f, rightX + 391.0f, 62.0f + 30.0f, paint5);
                titlePaint2.setColor(-1);
                titlePaint2.setTextSize(11.5f);
                titlePaint2.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("🏆 SAFETY EXCELLENCE COMMENDATION", (391.0f / 2.0f) + rightX, 62.0f + 20.0f, titlePaint2);
                float contentRightX = rightX + 16.0f;
                float rightCurY = 48.0f + 62.0f;
                float certBoxHeight = rightCurY + 175.0f;
                RectF certBox = new RectF(contentRightX, rightCurY, contentRightX + innerWidth, certBoxHeight);
                paint3.setColor(Color.parseColor("#FFFBEB"));
                canvas.drawRoundRect(certBox, 6.0f, 6.0f, paint3);
                paint3.setColor(Color.parseColor("#FDE68A"));
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(1.0f);
                canvas.drawRoundRect(certBox, 6.0f, 6.0f, paint3);
                paint3.setStyle(Paint.Style.FILL);
                float certTextY = rightCurY + f2;
                titlePaint2.setColor(Color.parseColor("#92400E"));
                titlePaint2.setTextSize(11.0f);
                titlePaint2.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("🌟 FACTORY TOUR SAFETY HERO 🌟", (innerWidth / 2.0f) + contentRightX, certTextY, titlePaint2);
                float certTextY2 = certTextY + 10.0f;
                paint3.setColor(Color.parseColor("#FDE68A"));
                canvas.drawLine(contentRightX + 20.0f, certTextY2, (contentRightX + innerWidth) - 20.0f, certTextY2, paint5);
                float certTextY3 = certTextY2 + 18.0f;
                paint3.setColor(Color.parseColor("#451A03"));
                paint3.setTextSize(9.5f);
                paint3.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("This Safety Star Award recognizes outstanding adherence", (innerWidth / 2.0f) + contentRightX, certTextY3, paint3);
                float certTextY4 = certTextY3 + 14.0f;
                canvas.drawText("to workplace health, safety standards, and hazard prevention.", (innerWidth / 2.0f) + contentRightX, certTextY4, paint3);
                float certTextY5 = certTextY4 + f2;
                titlePaint2.setTextSize(10.0f);
                titlePaint2.setColor(Color.parseColor("#059669"));
                canvas.drawText("“A Zero-Harm Workplace Starts With Your Commitment!”", (innerWidth / 2.0f) + contentRightX, certTextY5, titlePaint2);
                paint3.setTextSize(9.0f);
                paint3.setColor(Color.parseColor("#78350F"));
                canvas.drawText("Evaluated & Endorsed by EHS Walkthrough Audit Team", (innerWidth / 2.0f) + contentRightX, certTextY5 + f2, paint3);
                float rightCurY2 = rightCurY + 175.0f + 12.0f;
                float bestPracticeBoxHeight = (488.0f - (rightCurY2 - 62.0f)) - 55.0f;
                RectF bpBox = new RectF(contentRightX, rightCurY2, contentRightX + innerWidth, rightCurY2 + bestPracticeBoxHeight);
                paint3.setColor(Color.parseColor("#F0FDF4"));
                canvas.drawRoundRect(bpBox, 6.0f, 6.0f, paint3);
                paint3.setColor(Color.parseColor("#BBF7D0"));
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(1.0f);
                canvas.drawRoundRect(bpBox, 6.0f, 6.0f, paint3);
                paint3.setStyle(Paint.Style.FILL);
                float bpTextY = rightCurY2 + 20.0f;
                titlePaint2.setColor(Color.parseColor("#166534"));
                titlePaint2.setTextSize(10.0f);
                titlePaint2.setTextAlign(Paint.Align.LEFT);
                canvas.drawText("🎯 KEY OBSERVED SAFE PRACTICES:", contentRightX + 12.0f, bpTextY, titlePaint2);
                float bpTextY2 = bpTextY + 8.0f;
                paint3.setColor(Color.parseColor("#BBF7D0"));
                canvas.drawLine(contentRightX + 12.0f, bpTextY2, (contentRightX + innerWidth) - 12.0f, bpTextY2, paint5);
                paint3.setColor(Color.parseColor("#334155"));
                paint3.setTextSize(9.0f);
                z = true;
                List bpItems = CollectionsKt.listOf(new String[]{"✓ 100% Correct usage of Mandatory PPE", "✓ Proactive maintenance of safe work environment", "✓ Active participation in safety toolbox talks", "✓ Serving as a positive safety role model for peers"});
                Iterator it3 = bpItems.iterator();
                float bpTextY3 = bpTextY2 + 16.0f;
                while (it3.hasNext()) {
                    List bpItems2 = bpItems;
                    String item = (String) it3.next();
                    canvas.drawText(item, contentRightX + 12.0f, bpTextY3, paint3);
                    bpTextY3 += 14.0f;
                    it3 = it3;
                    bpItems = bpItems2;
                }
                RectF starFooterRect = new RectF(contentRightX, (62.0f + 488.0f) - 44.0f, contentRightX + innerWidth, (62.0f + 488.0f) - 10.0f);
                paint3.setColor(Color.parseColor("#F8FAFC"));
                canvas.drawRoundRect(starFooterRect, 6.0f, 6.0f, paint3);
                paint3.setColor(Color.parseColor("#CBD5E1"));
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(1.0f);
                canvas.drawRoundRect(starFooterRect, 6.0f, 6.0f, paint3);
                paint3.setStyle(Paint.Style.FILL);
                titlePaint2.setTextSize(8.5f);
                titlePaint2.setColor(Color.parseColor("#C2185B"));
                titlePaint2.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("AWARDED BY: " + presenter3, (innerWidth / 4.0f) + contentRightX, starFooterRect.top + 14.0f, titlePaint2);
                paint3.setTextSize(8.5f);
                paint3.setColor(Color.parseColor("#475569"));
                canvas.drawText("EHS Audit Team", (innerWidth / 4.0f) + contentRightX, starFooterRect.top + 26.0f, paint3);
                titlePaint2.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("STATUS: ⭐ RECOGNIZED", (innerWidth * 0.75f) + contentRightX, starFooterRect.top + 14.0f, titlePaint2);
                paint3.setColor(Color.parseColor("#15803D"));
                canvas.drawText("100% Compliant", (innerWidth * 0.75f) + contentRightX, starFooterRect.top + 26.0f, paint3);
                pageHeight = pageWidth3;
                presenter = presenter3;
                titlePaint = titlePaint2;
                pageWidth = pageWidth2;
                page = page3;
                greenHeaderColor = greenHeaderColor3;
                navyColor = navyColor3;
                f5 = 2.0f;
                goldAccent = goldAccent3;
                appLogoBitmap = appLogoBitmap4;
            } else {
                bottomMottoRect = bottomMottoRect2;
                pdfDocument = pdfDocument3;
                slideNum = slideNum2;
                safeDateRange = safeDateRange3;
                canvas = canvas3;
                z = true;
                int lightSlateBg3 = lightSlateBg2;
                paint3.setColor(lightSlateBg3);
                Paint paint6 = paint3;
                canvas3.drawRect(0.0f, 0.0f, pageWidth2, pageWidth3, paint6);
                int navyColor4 = navyColor3;
                paint3.setColor(navyColor4);
                canvas3.drawRect(0.0f, 0.0f, pageWidth2, 50.0f, paint6);
                paint3.setColor(Color.parseColor("#2563EB"));
                canvas3.drawRect(0.0f, 47.0f, pageWidth2, 50.0f, paint6);
                titlePaint2.setColor(-1);
                titlePaint2.setTextSize(14.0f);
                titlePaint2.setTextAlign(Paint.Align.LEFT);
                canvas.drawText("🛡️ SAFETY NON-CONFORMANCE AUDIT FINDING #" + (index + 1), 25.0f, 25.0f, titlePaint2);
                paint3.setColor(Color.parseColor("#93C5FD"));
                paint3.setTextSize(10.0f);
                paint3.setTextAlign(Paint.Align.LEFT);
                String str2 = divName.length() > 0 ? "• " + divName : "";
                String severity = obs.getSeverity();
                Locale locale4 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale4, "getDefault(...)");
                String upperCase = severity.toUpperCase(locale4);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                String headerSub = compName3 + " " + str2 + " • SEVERITY: " + upperCase;
                canvas.drawText(headerSub, 25.0f, 41.0f, paint3);
                float rightX2 = 20.0f + 391.0f + 20.0f;
                lightSlateBg2 = lightSlateBg3;
                RectF beforeCard = new RectF(20.0f, 60.0f, 20.0f + 391.0f, 60.0f + 490.0f);
                paint3.setColor(-1);
                canvas.drawRoundRect(beforeCard, 6.0f, 6.0f, paint3);
                paint3.setColor(cardBorderBefore);
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(1.5f);
                canvas.drawRoundRect(beforeCard, 6.0f, 6.0f, paint3);
                paint3.setStyle(Paint.Style.FILL);
                RectF beforeBadge = new RectF(20.0f, 60.0f, 20.0f + 391.0f, 60.0f + 28.0f);
                paint3.setColor(redHeaderColor);
                canvas.drawRoundRect(beforeBadge, 6.0f, 6.0f, paint3);
                Paint paint7 = paint3;
                canvas.drawRect(20.0f, 60.0f + 14.0f, 20.0f + 391.0f, 60.0f + 28.0f, paint7);
                titlePaint2.setColor(-1);
                titlePaint2.setTextSize(11.0f);
                titlePaint2.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("⚠️ BEFORE : NON-CONFORMANCE / HAZARD", 20.0f + (391.0f / 2.0f), 60.0f + 19.0f, titlePaint2);
                RectF beforePhotoRect = new RectF(20.0f + 10.0f, 60.0f + 36.0f, (20.0f + 391.0f) - 10.0f, 60.0f + 36.0f + 185.0f);
                Intrinsics.checkNotNull(canvas);
                pageHeight = pageWidth3;
                goldAccent = goldAccent3;
                presenter = presenter3;
                titlePaint = titlePaint2;
                pageWidth = pageWidth2;
                appLogoBitmap = appLogoBitmap4;
                page = page3;
                drawPhoto(context, canvas, obs.getPhotoUri(), beforePhotoRect, paint7, titlePaint, "📷 BEFORE AUDIT PHOTO EVIDENCE");
                RectF beforeDetailsRect = new RectF(20.0f + 10.0f, 60.0f + 36.0f + 185.0f + 10.0f, (20.0f + 391.0f) - 10.0f, (60.0f + 490.0f) - 55.0f);
                paint7.setColor(Color.parseColor("#FFF1F2"));
                canvas.drawRoundRect(beforeDetailsRect, 6.0f, 6.0f, paint7);
                paint7.setColor(Color.parseColor("#FECDD3"));
                paint7.setStyle(Paint.Style.STROKE);
                paint7.setStrokeWidth(1.0f);
                canvas.drawRoundRect(beforeDetailsRect, 6.0f, 6.0f, paint7);
                paint7.setStyle(Paint.Style.FILL);
                float textY = beforeDetailsRect.top + 16.0f;
                float textLeft = 20.0f + 18.0f;
                float contentWidth = 391.0f - 36.0f;
                titlePaint.setColor(Color.parseColor("#991B1B"));
                titlePaint.setTextSize(9.5f);
                titlePaint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText("📍 LOCATION:", textLeft, textY, titlePaint);
                paint7.setColor(Color.parseColor("#C2185B"));
                paint7.setTextSize(9.5f);
                paint7.setTextAlign(Paint.Align.LEFT);
                String location2 = obs.getLocation();
                if (StringsKt.isBlank(location2)) {
                    location2 = "General Facility Area";
                }
                String locStr = location2;
                canvas.drawText(locStr, textLeft + 75.0f, textY, paint7);
                float textY2 = textY + 8.0f;
                paint7.setColor(Color.parseColor("#FECDD3"));
                canvas.drawLine(textLeft, textY2, textLeft + contentWidth, textY2, paint7);
                float textY3 = textY2 + 14.0f;
                titlePaint.setColor(Color.parseColor("#991B1B"));
                canvas.drawText("⚠️ NON CONFORMANCE:", textLeft, textY3, titlePaint);
                String issueDetails2 = obs.getIssueDetails();
                if (StringsKt.isBlank(issueDetails2)) {
                    issueDetails2 = "Non-conformance recorded during walkthrough.";
                }
                String issueStr = issueDetails2;
                List issueLines = wrapText(issueStr, contentWidth, paint7);
                float textY4 = textY3 + 12.0f;
                paint7.setColor(Color.parseColor("#334155"));
                Iterator it4 = CollectionsKt.take(issueLines, 3).iterator();
                float textY5 = textY4;
                while (it4.hasNext()) {
                    Iterator it5 = it4;
                    String line2 = (String) it4.next();
                    canvas.drawText(line2, textLeft, textY5, paint7);
                    textY5 += 11.0f;
                    it4 = it5;
                }
                float textY6 = textY5 + 4.0f;
                paint7.setColor(Color.parseColor("#FECDD3"));
                canvas.drawLine(textLeft, textY6, textLeft + contentWidth, textY6, paint7);
                float textY7 = textY6 + 14.0f;
                titlePaint.setColor(Color.parseColor("#991B1B"));
                canvas.drawText("💡 SUGGESTION:", textLeft, textY7, titlePaint);
                String suggestion = obs.getSuggestion();
                if (StringsKt.isBlank(suggestion)) {
                    suggestion = "Implement corrective engineering / administrative controls.";
                }
                String sugStr = suggestion;
                List sugLines = wrapText(sugStr, contentWidth, paint7);
                paint7.setColor(Color.parseColor("#334155"));
                Iterator it6 = CollectionsKt.take(sugLines, 2).iterator();
                float textY8 = textY7 + 12.0f;
                while (it6.hasNext()) {
                    Iterator it7 = it6;
                    String line3 = (String) it6.next();
                    canvas.drawText(line3, textLeft, textY8, paint7);
                    textY8 += 11.0f;
                    it6 = it7;
                }
                RectF beforeMetaRect = new RectF(20.0f + 10.0f, (60.0f + 490.0f) - 45.0f, (20.0f + 391.0f) - 10.0f, (60.0f + 490.0f) - 10.0f);
                paint7.setColor(Color.parseColor("#F8FAFC"));
                canvas.drawRoundRect(beforeMetaRect, 6.0f, 6.0f, paint7);
                paint7.setColor(Color.parseColor("#CBD5E1"));
                paint7.setStyle(Paint.Style.STROKE);
                paint7.setStrokeWidth(1.0f);
                canvas.drawRoundRect(beforeMetaRect, 6.0f, 6.0f, paint7);
                paint7.setStyle(Paint.Style.FILL);
                float midBeforeX = 20.0f + (391.0f / 2.0f);
                paint7.setColor(Color.parseColor("#CBD5E1"));
                canvas.drawLine(midBeforeX, beforeMetaRect.top, midBeforeX, beforeMetaRect.bottom, paint7);
                titlePaint.setTextSize(8.5f);
                titlePaint.setColor(Color.parseColor("#C2185B"));
                titlePaint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("👤 RESPONSIBLE PERSON", 20.0f + (391.0f / 4.0f), beforeMetaRect.top + 14.0f, titlePaint);
                paint7.setTextSize(8.5f);
                paint7.setColor(Color.parseColor("#475569"));
                paint7.setTextAlign(Paint.Align.CENTER);
                String respStr = obs.getResponsiblePerson().length() > 0 ? obs.getResponsiblePerson() : "EHS Incharge";
                canvas.drawText(respStr, 20.0f + (391.0f / 4.0f), beforeMetaRect.top + 27.0f, paint7);
                f5 = 2.0f;
                canvas.drawText("📅 TARGET DATE", 20.0f + (0.75f * 391.0f), beforeMetaRect.top + 14.0f, titlePaint);
                String targetStr = obs.getTargetDate().length() > 0 ? obs.getTargetDate() : "Immediate";
                canvas.drawText(targetStr, 20.0f + (0.75f * 391.0f), beforeMetaRect.top + 27.0f, paint7);
                RectF afterCard = new RectF(rightX2, 60.0f, rightX2 + 391.0f, 60.0f + 490.0f);
                paint7.setColor(-1);
                canvas.drawRoundRect(afterCard, 6.0f, 6.0f, paint7);
                int cardBorderAfter3 = cardBorderAfter2;
                paint7.setColor(cardBorderAfter3);
                paint7.setStyle(Paint.Style.STROKE);
                paint7.setStrokeWidth(1.5f);
                canvas.drawRoundRect(afterCard, 6.0f, 6.0f, paint7);
                paint7.setStyle(Paint.Style.FILL);
                String respStr2 = respStr;
                RectF afterBadge = new RectF(rightX2, 60.0f, rightX2 + 391.0f, 60.0f + 28.0f);
                int greenHeaderColor4 = greenHeaderColor3;
                paint7.setColor(greenHeaderColor4);
                canvas.drawRoundRect(afterBadge, 6.0f, 6.0f, paint7);
                canvas.drawRect(rightX2, 60.0f + 14.0f, rightX2 + 391.0f, 60.0f + 28.0f, paint7);
                titlePaint.setColor(-1);
                titlePaint.setTextSize(11.0f);
                titlePaint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("✅ AFTER : CORRECTIVE ACTION / COMPLIANCE", (391.0f / 2.0f) + rightX2, 19.0f + 60.0f, titlePaint);
                RectF afterPhotoRect = new RectF(rightX2 + 10.0f, 60.0f + 36.0f, (rightX2 + 391.0f) - 10.0f, 60.0f + 36.0f + 185.0f);
                Intrinsics.checkNotNull(canvas);
                String afterPhotoUri = obs.getAfterPhotoUri();
                if (afterPhotoUri == null) {
                    afterPhotoUri = obs.isResolved() ? obs.getPhotoUri() : null;
                }
                String targetStr2 = afterPhotoUri;
                navyColor = navyColor4;
                paint3 = paint7;
                cardBorderAfter2 = cardBorderAfter3;
                greenHeaderColor = greenHeaderColor4;
                drawPhoto(context, canvas, targetStr2, afterPhotoRect, paint3, titlePaint, "📷 AFTER VERIFICATION PHOTO EVIDENCE");
                RectF afterDetailsRect = new RectF(rightX2 + 10.0f, 60.0f + 36.0f + 185.0f + 10.0f, (rightX2 + 391.0f) - 10.0f, (60.0f + 490.0f) - 55.0f);
                paint3.setColor(Color.parseColor("#F0FDF4"));
                canvas.drawRoundRect(afterDetailsRect, 6.0f, 6.0f, paint3);
                paint3.setColor(Color.parseColor("#BBF7D0"));
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(1.0f);
                canvas.drawRoundRect(afterDetailsRect, 6.0f, 6.0f, paint3);
                paint3.setStyle(Paint.Style.FILL);
                float textY9 = afterDetailsRect.top + 16.0f;
                float textRightLeft = rightX2 + 18.0f;
                titlePaint.setColor(Color.parseColor("#166534"));
                titlePaint.setTextSize(9.5f);
                titlePaint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText("📍 LOCATION:", textRightLeft, textY9, titlePaint);
                paint3.setColor(Color.parseColor("#C2185B"));
                paint3.setTextSize(9.5f);
                paint3.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(locStr, 75.0f + textRightLeft, textY9, paint3);
                float textY10 = textY9 + 8.0f;
                paint3.setColor(Color.parseColor("#BBF7D0"));
                canvas.drawLine(textRightLeft, textY10, textRightLeft + contentWidth, textY10, paint7);
                float textY11 = textY10 + 14.0f;
                titlePaint.setColor(Color.parseColor("#166534"));
                canvas.drawText("🛠️ ACTION TAKEN:", textRightLeft, textY11, titlePaint);
                String actText = obs.getActionTaken().length() > 0 ? obs.getActionTaken() : obs.isResolved() ? "Corrective action implemented and verified." : "Corrective action pending implementation.";
                List actLines = wrapText(actText, contentWidth, paint3);
                float textY12 = textY11 + 12.0f;
                paint3.setColor(Color.parseColor("#334155"));
                for (String line4 : CollectionsKt.take(actLines, 3)) {
                    canvas.drawText(line4, textRightLeft, textY12, paint3);
                    textY12 += 11.0f;
                }
                float textY13 = textY12 + 4.0f;
                paint3.setColor(Color.parseColor("#BBF7D0"));
                canvas.drawLine(textRightLeft, textY13, textRightLeft + contentWidth, textY13, paint3);
                float textY14 = textY13 + 14.0f;
                titlePaint.setColor(Color.parseColor("#166534"));
                canvas.drawText("🎯 CONTROL TYPE:", textRightLeft, textY14, titlePaint);
                paint3.setColor(Color.parseColor("#334155"));
                canvas.drawText("Engineering / Administrative Controls Verified Compliant", textRightLeft, textY14 + 12.0f, paint3);
                RectF afterMetaRect = new RectF(rightX2 + 10.0f, (60.0f + 490.0f) - 45.0f, (rightX2 + 391.0f) - 10.0f, (60.0f + 490.0f) - 10.0f);
                paint3.setColor(Color.parseColor("#F8FAFC"));
                canvas.drawRoundRect(afterMetaRect, 6.0f, 6.0f, paint3);
                paint3.setColor(Color.parseColor("#CBD5E1"));
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(1.0f);
                canvas.drawRoundRect(afterMetaRect, 6.0f, 6.0f, paint3);
                paint3.setStyle(Paint.Style.FILL);
                float midAfterX = rightX2 + (391.0f / 2.0f);
                paint3.setColor(Color.parseColor("#CBD5E1"));
                canvas.drawLine(midAfterX, afterMetaRect.top, midAfterX, afterMetaRect.bottom, paint3);
                titlePaint.setTextSize(8.5f);
                titlePaint.setColor(Color.parseColor("#C2185B"));
                titlePaint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("👤 RESPONSIBLE PERSON", rightX2 + (391.0f / 4.0f), afterMetaRect.top + 14.0f, titlePaint);
                paint3.setTextSize(8.5f);
                paint3.setColor(Color.parseColor("#475569"));
                paint3.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(respStr2, rightX2 + (391.0f / 4.0f), afterMetaRect.top + 27.0f, paint3);
                canvas.drawText("✅ COMPLETED / STATUS", rightX2 + (0.75f * 391.0f), afterMetaRect.top + 14.0f, titlePaint);
                String compStr = obs.getCompletedDate().length() > 0 ? obs.getCompletedDate() : obs.isResolved() ? "Verified Closed" : MaterialFollowUpUtils.STATUS_IN_PROGRESS;
                canvas.drawText(compStr, rightX2 + (0.75f * 391.0f), afterMetaRect.top + 27.0f, paint3);
            }
            if (appLogoBitmap != null) {
                RectF footerLogoRect = new RectF(20.0f, pageHeight - 32.0f, 40.0f, pageHeight - 12.0f);
                canvas.drawBitmap(appLogoBitmap, (Rect) null, footerLogoRect, paint3);
            }
            String footerTitle = divName.length() > 0 ? z : false ? compName3 + " - " + divName : compName3;
            int navyColor5 = navyColor;
            titlePaint.setColor(navyColor5);
            titlePaint.setTextSize(10.0f);
            titlePaint.setTextAlign(Paint.Align.CENTER);
            int pageWidth4 = pageWidth;
            canvas.drawText(footerTitle + "   |   THINK SAFE • WORK SAFE • GO HOME SAFELY", pageWidth4 / f5, pageHeight - 18.0f, titlePaint);
            paint3.setTextSize(10.0f);
            paint3.setColor(Color.parseColor("#64748B"));
            paint3.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText("Slide " + slideNum + " of " + totalSlides, pageWidth4 - 25.0f, pageHeight - 18.0f, paint3);
            PdfDocument pdfDocument4 = pdfDocument;
            pdfDocument4.finishPage(page);
            appLogoBitmap3 = appLogoBitmap;
            navyColor3 = navyColor5;
            pdfDocument3 = pdfDocument4;
            goldAccent3 = goldAccent;
            presenter3 = presenter;
            greenHeaderColor3 = greenHeaderColor;
            bottomMottoRect2 = bottomMottoRect;
            f2 = 22.0f;
            titlePaint2 = titlePaint;
            pageWidth2 = pageWidth4;
            pageWidth3 = pageHeight;
            pageInfo2 = pageInfo3;
            i = i2;
            safeDateRange3 = safeDateRange;
        }
        String presenter4 = presenter3;
        Paint titlePaint3 = titlePaint2;
        int pageHeight2 = pageWidth3;
        int pageHeight3 = pageWidth2;
        PdfDocument pdfDocument5 = pdfDocument3;
        PdfDocument.Page page4 = pdfDocument5.startPage(new PdfDocument.PageInfo.Builder(pageHeight3, pageHeight2, totalSlides).create());
        Canvas canvas4 = page4.getCanvas();
        paint3.setColor(deepCanvasColor);
        Paint paint8 = paint3;
        canvas4.drawRect(0.0f, 0.0f, pageHeight3, pageHeight2, paint8);
        Intrinsics.checkNotNull(canvas4);
        drawWatermark(canvas4, pageHeight3, pageHeight2, appLogoBitmap3, 20);
        paint8.setColor(Color.parseColor("#2563EB"));
        canvas4.drawRect(0.0f, 0.0f, pageHeight3, 6.0f, paint8);
        RectF closingCard = new RectF(50.0f, 50.0f, pageHeight3 - 50.0f, pageHeight2 - 60.0f);
        paint8.setColor(Color.parseColor("#112240"));
        canvas4.drawRoundRect(closingCard, 12.0f, 12.0f, paint8);
        paint8.setColor(goldAccent3);
        paint8.setStyle(Paint.Style.STROKE);
        paint8.setStrokeWidth(2.0f);
        canvas4.drawRoundRect(closingCard, 12.0f, 12.0f, paint8);
        paint8.setStyle(Paint.Style.FILL);
        titlePaint3.setColor(Color.parseColor("#FBBF24"));
        titlePaint3.setTextSize(24.0f);
        titlePaint3.setTextAlign(Paint.Align.CENTER);
        canvas4.drawText(compName3, pageHeight3 / 2.0f, 120.0f, titlePaint3);
        if (divName.length() > 0 ? z : false) {
            titlePaint3.setTextSize(16.0f);
            titlePaint3.setColor(Color.parseColor("#60A5FA"));
            f4 = 2.0f;
            canvas4.drawText(divName, pageHeight3 / 2.0f, 150.0f, titlePaint3);
        } else {
            f4 = 2.0f;
        }
        RectF targetZeroRect = new RectF((pageHeight3 / f4) - 260.0f, 180.0f, (pageHeight3 / f4) + 260.0f, 260.0f);
        paint8.setColor(Color.parseColor("#065F46"));
        canvas4.drawRoundRect(targetZeroRect, 10.0f, 10.0f, paint8);
        paint8.setColor(Color.parseColor("#10B981"));
        paint8.setStyle(Paint.Style.STROKE);
        paint8.setStrokeWidth(1.5f);
        canvas4.drawRoundRect(targetZeroRect, 10.0f, 10.0f, paint8);
        paint8.setStyle(Paint.Style.FILL);
        titlePaint3.setTextSize(22.0f);
        titlePaint3.setColor(Color.parseColor("#10B981"));
        canvas4.drawText("🎯 TARGET ZERO ACCIDENTS", pageHeight3 / 2.0f, 218.0f, titlePaint3);
        titlePaint3.setTextSize(12.0f);
        titlePaint3.setColor(-1);
        canvas4.drawText("ZERO HARM • ZERO ACCIDENTS • 100% COMPLIANCE", pageHeight3 / 2.0f, 243.0f, titlePaint3);
        titlePaint3.setTextSize(28.0f);
        titlePaint3.setColor(-1);
        canvas4.drawText("THANK YOU", pageHeight3 / 2.0f, 320.0f, titlePaint3);
        paint8.setTextSize(13.0f);
        paint8.setColor(Color.parseColor("#CBD5E1"));
        paint8.setTextAlign(Paint.Align.CENTER);
        canvas4.drawText("THANK YOU FOR YOUR COMMITMENT TO WORKPLACE HEALTH & SAFETY", pageHeight3 / 2.0f, 350.0f, paint8);
        titlePaint3.setTextSize(15.0f);
        titlePaint3.setColor(Color.parseColor("#FCD34D"));
        canvas4.drawText("“THINK SAFE  •  WORK SAFE  •  GO HOME SAFELY”", pageHeight3 / 2.0f, 385.0f, titlePaint3);
        RectF auditorBox = new RectF((pageHeight3 / 2.0f) - 200.0f, 420.0f, (pageHeight3 / 2.0f) + 200.0f, 470.0f);
        paint8.setColor(Color.parseColor("#1E293B"));
        canvas4.drawRoundRect(auditorBox, 8.0f, 8.0f, paint8);
        paint8.setColor(Color.parseColor("#334155"));
        paint8.setStyle(Paint.Style.STROKE);
        paint8.setStrokeWidth(1.0f);
        canvas4.drawRoundRect(auditorBox, 8.0f, 8.0f, paint8);
        paint8.setStyle(Paint.Style.FILL);
        titlePaint3.setTextSize(11.0f);
        titlePaint3.setColor(Color.parseColor("#38BDF8"));
        canvas4.drawText("AUDIT PREPARED & PRESENTED BY: " + presenter4, pageHeight3 / 2.0f, 442.0f, titlePaint3);
        paint8.setTextSize(9.5f);
        paint8.setColor(Color.parseColor("#94A3B8"));
        canvas4.drawText("HEALTH, SAFETY & ENVIRONMENT LEAD AUDITOR", pageHeight3 / 2.0f, 458.0f, paint8);
        titlePaint3.setTextSize(10.0f);
        titlePaint3.setColor(Color.parseColor("#64748B"));
        canvas4.drawText("VELTRIX SENTINEL EHS SAFETY AUDIT PORTAL   (Slide " + totalSlides + " of " + totalSlides + ")", pageHeight3 / 2.0f, pageHeight2 - 30.0f, titlePaint3);
        pdfDocument5.finishPage(page4);
        try {
            try {
                pdfDocument5.writeTo(new FileOutputStream(outputFile));
                pdfDocument5.close();
                return z;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                pdfDocument5.close();
                return false;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    static /* synthetic */ Bitmap decodeSampledBitmapFromFile$default(PdfReportGenerator pdfReportGenerator, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 800;
        }
        if ((i3 & 4) != 0) {
            i2 = 600;
        }
        return pdfReportGenerator.decodeSampledBitmapFromFile(str, i, i2);
    }

    private final Bitmap decodeSampledBitmapFromFile(String filePath, int reqWidth, int reqHeight) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(filePath, options);
            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return BitmapFactory.decodeFile(filePath, options);
        } catch (Exception e) {
            return null;
        }
    }

    static /* synthetic */ Bitmap decodeSampledBitmapFromStream$default(PdfReportGenerator pdfReportGenerator, Context context, Uri uri, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 800;
        }
        if ((i3 & 8) != 0) {
            i2 = 600;
        }
        return pdfReportGenerator.decodeSampledBitmapFromStream(context, uri, i, i2);
    }

    private final Bitmap decodeSampledBitmapFromStream(Context context, Uri uri, int reqWidth, int reqHeight) {
        InputStream inputStream;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                inputStream = openInputStream;
                try {
                    BitmapFactory.decodeStream(inputStream, null, options);
                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                } finally {
                }
            }
            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            InputStream openInputStream2 = context.getContentResolver().openInputStream(uri);
            if (openInputStream2 == null) {
                return null;
            }
            inputStream = openInputStream2;
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                CloseableKt.closeFinally(inputStream, (Throwable) null);
                return decodeStream;
            } finally {
            }
        } catch (Exception e) {
            return null;
        }
    }

    private final int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void drawPhoto(android.content.Context r18, android.graphics.Canvas r19, java.lang.String r20, android.graphics.RectF r21, android.graphics.Paint r22, android.graphics.Paint r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.PdfReportGenerator.drawPhoto(android.content.Context, android.graphics.Canvas, java.lang.String, android.graphics.RectF, android.graphics.Paint, android.graphics.Paint, java.lang.String):void");
    }

    private final List<String> wrapText(String text, float maxWidth, Paint paint) {
        if (StringsKt.isBlank(text)) {
            return CollectionsKt.emptyList();
        }
        List<String> words = StringsKt.split$default(text, new String[]{" "}, false, 0, 6, (Object) null);
        List lines = new ArrayList();
        StringBuilder currentLine = new StringBuilder();
        for (String word : words) {
            String testLine = currentLine.length() == 0 ? word : ((Object) currentLine) + " " + word;
            if (paint.measureText(testLine) <= maxWidth) {
                currentLine.append(currentLine.length() == 0 ? word : " " + word);
            } else {
                if (currentLine.length() > 0) {
                    String sb = currentLine.toString();
                    Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
                    lines.add(sb);
                }
                currentLine = new StringBuilder(word);
            }
        }
        if (currentLine.length() > 0) {
            String sb2 = currentLine.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            lines.add(sb2);
        }
        return lines;
    }

    public static /* synthetic */ boolean generateConsolidatedMultiCompanyPdfReport$default(PdfReportGenerator pdfReportGenerator, Context context, List list, List list2, List list3, String str, String str2, File file, int i, Object obj) {
        List list4;
        String str3;
        if ((i & 8) == 0) {
            list4 = list3;
        } else {
            list4 = CollectionsKt.emptyList();
        }
        if ((i & 32) == 0) {
            str3 = str2;
        } else {
            str3 = "VELTRIX SENTINEL EHS ADMIN";
        }
        return pdfReportGenerator.generateConsolidatedMultiCompanyPdfReport(context, list, list2, list4, str, str3, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x03d2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x08a9  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0930 A[Catch: Exception -> 0x09ed, TryCatch #0 {Exception -> 0x09ed, blocks: (B:9:0x00c4, B:10:0x01e0, B:13:0x01ec, B:15:0x01f6, B:16:0x01f9, B:17:0x021a, B:19:0x0220, B:23:0x023f, B:30:0x0258, B:31:0x0279, B:33:0x027f, B:37:0x029e, B:44:0x02b9, B:46:0x02d9, B:49:0x0309, B:51:0x0316, B:55:0x0349, B:56:0x0357, B:58:0x036f, B:61:0x03e1, B:62:0x03ec, B:64:0x03f2, B:66:0x0402, B:69:0x0419, B:71:0x044a, B:72:0x046a, B:75:0x0486, B:77:0x0490, B:78:0x04a9, B:81:0x04c2, B:84:0x04e5, B:87:0x051d, B:91:0x0534, B:92:0x0530, B:94:0x0519, B:98:0x0482, B:99:0x0466, B:101:0x037e, B:102:0x0383, B:104:0x0389, B:106:0x03ae, B:116:0x03c6, B:118:0x03ca, B:125:0x0322, B:126:0x0327, B:128:0x032d, B:131:0x033d, B:134:0x0341, B:140:0x02e5, B:141:0x02ea, B:143:0x02f0, B:146:0x0300, B:149:0x0304, B:156:0x056a, B:158:0x05f8, B:162:0x0609, B:165:0x064b, B:168:0x066e, B:169:0x06ec, B:171:0x06f2, B:173:0x070c, B:174:0x072d, B:176:0x0733, B:178:0x074f, B:184:0x0766, B:186:0x077a, B:187:0x07fb, B:189:0x0801, B:191:0x0809, B:192:0x080c, B:193:0x081a, B:195:0x0820, B:202:0x0840, B:204:0x0844, B:206:0x0852, B:210:0x088d, B:213:0x08ae, B:215:0x0930, B:216:0x0950, B:219:0x0973, B:223:0x0986, B:227:0x094c, B:229:0x0878, B:237:0x09a8, B:238:0x09c4), top: B:8:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0970  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0981  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0984  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0972  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x094c A[Catch: Exception -> 0x09ed, TryCatch #0 {Exception -> 0x09ed, blocks: (B:9:0x00c4, B:10:0x01e0, B:13:0x01ec, B:15:0x01f6, B:16:0x01f9, B:17:0x021a, B:19:0x0220, B:23:0x023f, B:30:0x0258, B:31:0x0279, B:33:0x027f, B:37:0x029e, B:44:0x02b9, B:46:0x02d9, B:49:0x0309, B:51:0x0316, B:55:0x0349, B:56:0x0357, B:58:0x036f, B:61:0x03e1, B:62:0x03ec, B:64:0x03f2, B:66:0x0402, B:69:0x0419, B:71:0x044a, B:72:0x046a, B:75:0x0486, B:77:0x0490, B:78:0x04a9, B:81:0x04c2, B:84:0x04e5, B:87:0x051d, B:91:0x0534, B:92:0x0530, B:94:0x0519, B:98:0x0482, B:99:0x0466, B:101:0x037e, B:102:0x0383, B:104:0x0389, B:106:0x03ae, B:116:0x03c6, B:118:0x03ca, B:125:0x0322, B:126:0x0327, B:128:0x032d, B:131:0x033d, B:134:0x0341, B:140:0x02e5, B:141:0x02ea, B:143:0x02f0, B:146:0x0300, B:149:0x0304, B:156:0x056a, B:158:0x05f8, B:162:0x0609, B:165:0x064b, B:168:0x066e, B:169:0x06ec, B:171:0x06f2, B:173:0x070c, B:174:0x072d, B:176:0x0733, B:178:0x074f, B:184:0x0766, B:186:0x077a, B:187:0x07fb, B:189:0x0801, B:191:0x0809, B:192:0x080c, B:193:0x081a, B:195:0x0820, B:202:0x0840, B:204:0x0844, B:206:0x0852, B:210:0x088d, B:213:0x08ae, B:215:0x0930, B:216:0x0950, B:219:0x0973, B:223:0x0986, B:227:0x094c, B:229:0x0878, B:237:0x09a8, B:238:0x09c4), top: B:8:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x08ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean generateConsolidatedMultiCompanyPdfReport(android.content.Context r64, java.util.List<com.example.data.Company> r65, java.util.List<com.example.data.Observation> r66, java.util.List<com.example.data.IncidentRecord> r67, java.lang.String r68, java.lang.String r69, java.io.File r70) {
        /*
            Method dump skipped, instructions count: 2554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.PdfReportGenerator.generateConsolidatedMultiCompanyPdfReport(android.content.Context, java.util.List, java.util.List, java.util.List, java.lang.String, java.lang.String, java.io.File):boolean");
    }

    public static /* synthetic */ boolean generateSafetyTrainingsPdfReport$default(PdfReportGenerator pdfReportGenerator, Context context, String str, List list, String str2, String str3, File file, int i, Object obj) {
        String str4;
        String str5;
        if ((i & 2) == 0) {
            str4 = str;
        } else {
            str4 = "All Units";
        }
        if ((i & 16) == 0) {
            str5 = str3;
        } else {
            str5 = "Safety Officer";
        }
        return pdfReportGenerator.generateSafetyTrainingsPdfReport(context, str4, list, str2, str5, file);
    }

    public final boolean generateSafetyTrainingsPdfReport(Context context, String companyName, List<SafetyTraining> trainings, String monthYearText, String presenterName, File outputFile) {
        int headerBarColor;
        PdfDocument pdfDocument;
        int pageHeight;
        Paint paint;
        Iterable iterable;
        int parseColor;
        PdfDocument.Page page2;
        Canvas canvas2;
        int headerBarColor2;
        int i;
        SafetyTraining safetyTraining;
        Iterable iterable2;
        int i2;
        int darkBlueColor;
        int i3;
        Pair pair;
        float f;
        List kpiData;
        Iterable iterable3;
        int i4;
        int parseColor2;
        int darkBlueColor2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        Intrinsics.checkNotNullParameter(trainings, "trainings");
        Intrinsics.checkNotNullParameter(monthYearText, "monthYearText");
        Intrinsics.checkNotNullParameter(presenterName, "presenterName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        PdfDocument pdfDocument2 = new PdfDocument();
        Color.parseColor("#EE0000");
        Color.parseColor("#008000");
        int darkBlueColor3 = Color.parseColor("#880E4F");
        int headerBarColor3 = Color.parseColor("#C2185B");
        Color.parseColor("#F8FAFC");
        Color.parseColor("#E2E8F0");
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        int darkBlueColor4 = darkBlueColor3;
        try {
            Bitmap appLogoBitmap = loadVectorLogoBitmap$default(this, context, 0, 0, 6, null);
            int totalSessions = trainings.size();
            Iterator<T> it = trainings.iterator();
            int totalAttendees = 0;
            while (it.hasNext()) {
                try {
                    totalAttendees += ((SafetyTraining) it.next()).getAttendeesCount();
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return false;
                }
            }
            Iterator<T> it2 = trainings.iterator();
            double avgFeedback = 0.0d;
            double d = 0.0d;
            while (it2.hasNext()) {
                d += ((SafetyTraining) it2.next()).getDurationHours();
            }
            double totalHours = d;
            Iterator<T> it3 = trainings.iterator();
            double d2 = 0.0d;
            while (it3.hasNext()) {
                d2 += ((SafetyTraining) it3.next()).getManHoursTrained();
            }
            double totalManHours = d2;
            if (!trainings.isEmpty()) {
                double sumScore = 0.0d;
                for (SafetyTraining safetyTraining2 : trainings) {
                    sumScore += safetyTraining2.getPostAssessmentScoreAvg() > 0.0d ? safetyTraining2.getPostAssessmentScoreAvg() : 85.0d;
                }
                avgFeedback = sumScore / trainings.size();
            }
            PdfDocument.PageInfo pageInfo1 = new PdfDocument.PageInfo.Builder(842, 595, 1).create();
            PdfDocument.Page page1 = pdfDocument2.startPage(pageInfo1);
            Canvas canvas1 = page1.getCanvas();
            try {
                paint2.setColor(headerBarColor3);
                try {
                    canvas1.drawRect(0.0f, 0.0f, 842, 65.0f, paint2);
                    Canvas canvas12 = canvas1;
                    Paint paint4 = paint2;
                    double avgFeedback2 = avgFeedback;
                    if (appLogoBitmap != null) {
                        try {
                            headerBarColor = headerBarColor3;
                            pdfDocument = pdfDocument2;
                            pageHeight = 595;
                            try {
                                RectF logoRect = new RectF(24.0f, 12.0f, 64.0f, 52.0f);
                                canvas12.drawBitmap(appLogoBitmap, (Rect) null, logoRect, paint4);
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                return false;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            return false;
                        }
                    } else {
                        pageHeight = 595;
                        headerBarColor = headerBarColor3;
                        pdfDocument = pdfDocument2;
                    }
                    try {
                        paint3.setColor(Color.parseColor("#F59E0B"));
                        paint3.setTextSize(9.0f);
                        paint3.setTextAlign(Paint.Align.LEFT);
                        Locale locale = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                        String upperCase = companyName.toUpperCase(locale);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        canvas12.drawText(upperCase + " • ENVIRONMENTAL HEALTH & SAFETY", 75.0f, 22.0f, paint3);
                        paint3.setColor(-1);
                        paint3.setTextSize(15.0f);
                        canvas12.drawText("MONTHLY SAFETY TRAININGS & ATTENDANCE REGISTER", 75.0f, 40.0f, paint3);
                        paint3.setTextSize(9.5f);
                        paint3.setColor(Color.parseColor("#CBD5E1"));
                        paint3.setTextAlign(Paint.Align.RIGHT);
                        canvas12.drawText("PERIOD: " + monthYearText + " | UNIT: " + companyName, 842 - 24.0f, 25.0f, paint3);
                        canvas12.drawText("Compiled: " + new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(new Date()) + " | Presenter: " + presenterName, 842 - 24.0f, 42.0f, paint3);
                        paint3.setTextAlign(Paint.Align.LEFT);
                        paint4.setColor(Color.parseColor("#D97706"));
                        try {
                            canvas12.drawRect(0.0f, 65.0f, 842, 68.0f, paint4);
                            float cardY = 78.0f;
                            float kpiCardWidth = ((842 - 48.0f) - 40.0f) / 5.0f;
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            int totalAttendees2 = totalAttendees;
                            String format = String.format(Locale.getDefault(), "%.1f Hours", Arrays.copyOf(new Object[]{Double.valueOf(totalHours)}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            String format2 = String.format(Locale.getDefault(), "%.1f Man-Hrs", Arrays.copyOf(new Object[]{Double.valueOf(totalManHours)}, 1));
                            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                            String format3 = String.format(Locale.getDefault(), "%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf(avgFeedback2)}, 1));
                            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                            List kpiData2 = CollectionsKt.listOf(new Pair[]{new Pair("SESSIONS HELD", totalSessions + " Sessions"), new Pair("TOTAL ATTENDEES", totalAttendees + " Employees"), new Pair("TRAINING DURATION", format), new Pair("MAN-HOURS TRAINED", format2), new Pair("AVG. PASS SCORE", format3)});
                            List list = kpiData2;
                            int i5 = 0;
                            int i6 = 0;
                            for (Object obj : list) {
                                try {
                                    i3 = i6 + 1;
                                    if (i6 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    pair = (Pair) obj;
                                    f = (i6 * (kpiCardWidth + 10.0f)) + 24.0f;
                                    kpiData = kpiData2;
                                    iterable3 = list;
                                    i4 = i5;
                                    RectF rectF = new RectF(f, cardY, f + kpiCardWidth, cardY + 58.0f);
                                    paint4.setColor(Color.parseColor("#F1F5F9"));
                                    canvas12.drawRoundRect(rectF, 6.0f, 6.0f, paint4);
                                    paint4.setColor(Color.parseColor("#CBD5E1"));
                                    paint4.setStyle(Paint.Style.STROKE);
                                    paint4.setStrokeWidth(1.0f);
                                    canvas12.drawRoundRect(rectF, 6.0f, 6.0f, paint4);
                                    paint4.setStyle(Paint.Style.FILL);
                                    switch (i6) {
                                        case 0:
                                            parseColor2 = Color.parseColor("#3B82F6");
                                            break;
                                        case 1:
                                            parseColor2 = Color.parseColor("#10B981");
                                            break;
                                        case 2:
                                            parseColor2 = Color.parseColor("#8B5CF6");
                                            break;
                                        case 3:
                                            parseColor2 = Color.parseColor("#F59E0B");
                                            break;
                                        default:
                                            parseColor2 = Color.parseColor("#06B6D4");
                                            break;
                                    }
                                    paint4.setColor(parseColor2);
                                    canvas12.drawRoundRect(new RectF(f, cardY, f + kpiCardWidth, cardY + 4.0f), 6.0f, 6.0f, paint4);
                                    paint3.setColor(Color.parseColor("#475569"));
                                    paint3.setTextSize(8.0f);
                                    paint3.setTextAlign(Paint.Align.CENTER);
                                    canvas12.drawText((String) pair.getFirst(), (kpiCardWidth / 2.0f) + f, 20.0f + cardY, paint3);
                                    darkBlueColor2 = darkBlueColor4;
                                } catch (Exception e4) {
                                    e = e4;
                                }
                                try {
                                    paint3.setColor(darkBlueColor2);
                                    paint3.setTextSize(12.0f);
                                    float cardY2 = cardY;
                                    canvas12.drawText((String) pair.getSecond(), (kpiCardWidth / 2.0f) + f, cardY2 + 42.0f, paint3);
                                    paint3.setTextAlign(Paint.Align.LEFT);
                                    i6 = i3;
                                    list = iterable3;
                                    i5 = i4;
                                    cardY = cardY2;
                                    darkBlueColor4 = darkBlueColor2;
                                    kpiData2 = kpiData;
                                } catch (Exception e5) {
                                    e = e5;
                                    e.printStackTrace();
                                    return false;
                                }
                            }
                            int darkBlueColor5 = darkBlueColor4;
                            try {
                                paint3.setColor(darkBlueColor5);
                                paint3.setTextSize(12.0f);
                                canvas12.drawText("TRAINING SESSIONS & ATTENDANCE LOG", 24.0f, 150.0f, paint3);
                                paint4.setColor(Color.parseColor("#64748B"));
                                paint4.setTextSize(8.5f);
                                canvas12.drawText("(Conducted in accordance with Factories Act, 1948 & ISO 45001 Competency Requirements)", 300.0f, 150.0f, paint4);
                                float thY = 150.0f + 8.0f;
                                float thH = 22.0f;
                                paint4.setColor(Color.parseColor("#1E293B"));
                                try {
                                    canvas12.drawRect(24.0f, thY, 842 - 24.0f, thY + 22.0f, paint4);
                                    float thY2 = thY;
                                    paint3.setColor(-1);
                                    paint3.setTextSize(8.5f);
                                    paint3.setTextAlign(Paint.Align.LEFT);
                                    canvas12.drawText("S.NO", 30.0f, thY2 + 14.0f, paint3);
                                    canvas12.drawText("DATE", 65.0f, thY2 + 14.0f, paint3);
                                    canvas12.drawText("TRAINING TOPIC / MODULE", 130.0f, thY2 + 14.0f, paint3);
                                    canvas12.drawText("DEPARTMENT", 360.0f, thY2 + 14.0f, paint3);
                                    canvas12.drawText("TRAINER & VENUE", 480.0f, thY2 + 14.0f, paint3);
                                    canvas12.drawText("DUR.", 645.0f, thY2 + 14.0f, paint3);
                                    canvas12.drawText("ATTENDEES", 685.0f, thY2 + 14.0f, paint3);
                                    canvas12.drawText("MAN-HRS", 755.0f, thY2 + 14.0f, paint3);
                                    float rowY = thY2 + 22.0f;
                                    List displayTrainings = CollectionsKt.take(trainings, 12);
                                    if (displayTrainings.isEmpty()) {
                                        paint4.setColor(Color.parseColor("#F8FAFC"));
                                        try {
                                            canvas12.drawRect(24.0f, rowY, 842 - 24.0f, rowY + 60.0f, paint4);
                                            paint4.setColor(Color.parseColor("#64748B"));
                                            paint4.setTextSize(11.0f);
                                            paint4.setTextAlign(Paint.Align.CENTER);
                                            float tableStartY = rowY + 35.0f;
                                            canvas12.drawText("No trainings recorded for the selected period.", 842 / 2.0f, tableStartY, paint4);
                                            paint4.setTextAlign(Paint.Align.LEFT);
                                            rowY += 60.0f;
                                            paint = paint4;
                                        } catch (Exception e6) {
                                            e = e6;
                                            e.printStackTrace();
                                            return false;
                                        }
                                    } else {
                                        List list2 = displayTrainings;
                                        int i7 = 0;
                                        int i8 = 0;
                                        for (Object obj2 : list2) {
                                            try {
                                                int i9 = i8 + 1;
                                                if (i8 < 0) {
                                                    CollectionsKt.throwIndexOverflow();
                                                }
                                                SafetyTraining safetyTraining3 = (SafetyTraining) obj2;
                                                if (i8 % 2 == 0) {
                                                    iterable = list2;
                                                    parseColor = -1;
                                                } else {
                                                    iterable = list2;
                                                    parseColor = Color.parseColor("#F8FAFC");
                                                }
                                                paint4.setColor(parseColor);
                                                Paint paint5 = paint4;
                                                Canvas canvas13 = canvas12;
                                                try {
                                                    canvas13.drawRect(24.0f, rowY, 842 - 24.0f, rowY + 26.0f, paint5);
                                                    float rowY2 = rowY;
                                                    try {
                                                        paint5.setColor(Color.parseColor("#E2E8F0"));
                                                        paint5.setStrokeWidth(0.8f);
                                                        canvas13.drawLine(24.0f, rowY2 + 26.0f, 842 - 24.0f, rowY2 + 26.0f, paint5);
                                                        canvas12 = canvas13;
                                                        paint3.setColor(Color.parseColor("#1E293B"));
                                                        paint3.setTextSize(8.5f);
                                                        int i10 = i7;
                                                        float thH2 = thH;
                                                        float thH3 = rowY2 + 16.0f;
                                                        canvas12.drawText(String.valueOf(i8 + 1), 32.0f, thH3, paint3);
                                                        canvas12.drawText(safetyTraining3.getTrainingDate(), 65.0f, rowY2 + 16.0f, paint3);
                                                        canvas12.drawText(safetyTraining3.getTrainingTopic().length() > 38 ? StringsKt.take(safetyTraining3.getTrainingTopic(), 36) + ".." : safetyTraining3.getTrainingTopic(), 130.0f, rowY2 + 16.0f, paint3);
                                                        paint5.setColor(Color.parseColor("#475569"));
                                                        paint5.setTextSize(8.0f);
                                                        canvas12.drawText(safetyTraining3.getTargetDepartment().length() > 20 ? StringsKt.take(safetyTraining3.getTargetDepartment(), 19) + "." : safetyTraining3.getTargetDepartment(), 360.0f, rowY2 + 16.0f, paint5);
                                                        String str = safetyTraining3.getTrainerName() + " (" + safetyTraining3.getVenue() + ")";
                                                        if (str.length() > 28) {
                                                            str = StringsKt.take(str, 26) + "..";
                                                        }
                                                        canvas12.drawText(str, 480.0f, rowY2 + 16.0f, paint5);
                                                        paint3.setColor(darkBlueColor5);
                                                        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                                                        float thY3 = thY2;
                                                        String format4 = String.format(Locale.getDefault(), "%.1fh", Arrays.copyOf(new Object[]{Double.valueOf(safetyTraining3.getDurationHours())}, 1));
                                                        Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                                                        canvas12.drawText(format4, 645.0f, rowY2 + 16.0f, paint3);
                                                        canvas12.drawText(safetyTraining3.getAttendeesCount() + " staff", 685.0f, rowY2 + 16.0f, paint3);
                                                        StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                                                        String format5 = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(safetyTraining3.getManHoursTrained())}, 1));
                                                        Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
                                                        canvas12.drawText(format5, 755.0f, rowY2 + 16.0f, paint3);
                                                        rowY = rowY2 + 26.0f;
                                                        paint4 = paint5;
                                                        i7 = i10;
                                                        i8 = i9;
                                                        list2 = iterable;
                                                        thH = thH2;
                                                        thY2 = thY3;
                                                    } catch (Exception e7) {
                                                        e = e7;
                                                        e.printStackTrace();
                                                        return false;
                                                    }
                                                } catch (Exception e8) {
                                                    e = e8;
                                                }
                                            } catch (Exception e9) {
                                                e = e9;
                                            }
                                        }
                                        paint = paint4;
                                    }
                                    try {
                                        paint.setColor(Color.parseColor("#F1F5F9"));
                                        Paint paint6 = paint;
                                        canvas12.drawRect(24.0f, rowY, 842 - 24.0f, rowY + 22.0f, paint6);
                                        float rowY3 = rowY;
                                        paint4 = paint6;
                                        paint3.setColor(darkBlueColor5);
                                        paint3.setTextSize(9.0f);
                                        canvas12.drawText("GRAND TOTALS:", 480.0f, rowY3 + 15.0f, paint3);
                                        StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
                                        String format6 = String.format(Locale.getDefault(), "%.1f h", Arrays.copyOf(new Object[]{Double.valueOf(totalHours)}, 1));
                                        Intrinsics.checkNotNullExpressionValue(format6, "format(...)");
                                        canvas12.drawText(format6, 645.0f, rowY3 + 15.0f, paint3);
                                        canvas12.drawText(String.valueOf(totalAttendees2), 685.0f, rowY3 + 15.0f, paint3);
                                        StringCompanionObject stringCompanionObject7 = StringCompanionObject.INSTANCE;
                                        String format7 = String.format(Locale.getDefault(), "%.1f h", Arrays.copyOf(new Object[]{Double.valueOf(totalManHours)}, 1));
                                        Intrinsics.checkNotNullExpressionValue(format7, "format(...)");
                                        canvas12.drawText(format7, 755.0f, rowY3 + 15.0f, paint3);
                                        int pageHeight2 = pageHeight;
                                        float signY = pageHeight2 - 90.0f;
                                        try {
                                            paint4.setColor(Color.parseColor("#F8FAFC"));
                                            Canvas canvas14 = canvas12;
                                            try {
                                                canvas14.drawRect(24.0f, signY, 842 - 24.0f, signY + 50.0f, paint4);
                                                paint4.setColor(Color.parseColor("#CBD5E1"));
                                                paint4.setStyle(Paint.Style.STROKE);
                                                canvas14.drawRect(24.0f, signY, 842 - 24.0f, signY + 50.0f, paint4);
                                                paint4.setStyle(Paint.Style.FILL);
                                                paint3.setColor(Color.parseColor("#334155"));
                                                paint3.setTextSize(8.5f);
                                                canvas14.drawText("Prepared & Verified By: _____________________", 40.0f, signY + 30.0f, paint3);
                                                canvas14.drawText("EHS Head / Safety Lead: _____________________", 300.0f, signY + 30.0f, paint3);
                                                canvas14.drawText("Factory / Plant Head: _____________________", 570.0f, signY + 30.0f, paint3);
                                                paint4.setColor(darkBlueColor5);
                                                canvas14.drawRect(0.0f, pageHeight2 - 25.0f, 842, pageHeight2, paint4);
                                                paint3.setColor(-1);
                                                paint3.setTextSize(8.5f);
                                                paint3.setTextAlign(Paint.Align.CENTER);
                                                Locale locale2 = Locale.getDefault();
                                                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                                                String upperCase2 = companyName.toUpperCase(locale2);
                                                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                                                canvas14.drawText(upperCase2 + " HSE PORTAL  •  ZERO HARM & CONTINUOUS SAFETY LEARNING", 842 / 2.0f, pageHeight2 - 9.0f, paint3);
                                                PdfDocument pdfDocument3 = pdfDocument;
                                                try {
                                                    pdfDocument3.finishPage(page1);
                                                    if (!trainings.isEmpty()) {
                                                        try {
                                                            PdfDocument.PageInfo pageInfo2 = new PdfDocument.PageInfo.Builder(842, pageHeight2, 2).create();
                                                            page2 = pdfDocument3.startPage(pageInfo2);
                                                            canvas2 = page2.getCanvas();
                                                            headerBarColor2 = headerBarColor;
                                                            try {
                                                                paint4.setColor(headerBarColor2);
                                                                try {
                                                                    canvas2.drawRect(0.0f, 0.0f, 842, 45.0f, paint4);
                                                                    paint4 = paint4;
                                                                    paint3.setColor(-1);
                                                                    paint3.setTextSize(13.0f);
                                                                    paint3.setTextAlign(Paint.Align.LEFT);
                                                                    canvas2.drawText("DETAILED SAFETY TRAINING TOPICS, REMARKS & EVALUATIONS", 24.0f, 28.0f, paint3);
                                                                    paint3.setColor(Color.parseColor("#F59E0B"));
                                                                    paint3.setTextSize(9.0f);
                                                                    paint3.setTextAlign(Paint.Align.RIGHT);
                                                                    Locale locale3 = Locale.getDefault();
                                                                    Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
                                                                    String upperCase3 = companyName.toUpperCase(locale3);
                                                                    Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
                                                                    canvas2.drawText("UNIT: " + upperCase3 + "  |  PAGE 2 OF 2", 842 - 24.0f, 28.0f, paint3);
                                                                    paint3.setTextAlign(Paint.Align.LEFT);
                                                                    float detailY = 60.0f;
                                                                    Iterable take = CollectionsKt.take(trainings, 8);
                                                                    int i11 = 0;
                                                                    int i12 = 0;
                                                                    Iterator it4 = take.iterator();
                                                                    while (it4.hasNext()) {
                                                                        try {
                                                                            Object next = it4.next();
                                                                            i = i12 + 1;
                                                                            if (i12 < 0) {
                                                                                try {
                                                                                    CollectionsKt.throwIndexOverflow();
                                                                                } catch (Exception e10) {
                                                                                    e = e10;
                                                                                    e.printStackTrace();
                                                                                    return false;
                                                                                }
                                                                            }
                                                                            safetyTraining = (SafetyTraining) next;
                                                                            iterable2 = take;
                                                                            i2 = i11;
                                                                            RectF rectF2 = new RectF(24.0f, detailY, 842 - 24.0f, detailY + 54.0f);
                                                                            paint4.setColor(Color.parseColor("#F8FAFC"));
                                                                            canvas2.drawRoundRect(rectF2, 6.0f, 6.0f, paint4);
                                                                            paint4.setColor(Color.parseColor("#E2E8F0"));
                                                                            paint4.setStyle(Paint.Style.STROKE);
                                                                            canvas2.drawRoundRect(rectF2, 6.0f, 6.0f, paint4);
                                                                            paint4.setStyle(Paint.Style.FILL);
                                                                            paint4.setColor(Color.parseColor("#3B82F6"));
                                                                            canvas2.drawRoundRect(new RectF(24.0f, detailY, 28.0f, 54.0f + detailY), 6.0f, 6.0f, paint4);
                                                                            paint3.setColor(darkBlueColor5);
                                                                            paint3.setTextSize(10.0f);
                                                                            canvas2.drawText((i12 + 1) + ". " + safetyTraining.getTrainingTopic() + " (" + safetyTraining.getTrainingCategory() + ")", 36.0f, detailY + 16.0f, paint3);
                                                                            paint4.setColor(Color.parseColor("#64748B"));
                                                                            paint4.setTextSize(8.5f);
                                                                            darkBlueColor = darkBlueColor5;
                                                                        } catch (Exception e11) {
                                                                            e = e11;
                                                                        }
                                                                        try {
                                                                            Iterator it5 = it4;
                                                                            canvas2.drawText("Date: " + safetyTraining.getTrainingDate() + "  |  Trainer: " + safetyTraining.getTrainerName() + " (" + safetyTraining.getTrainerType() + ")  |  Venue: " + safetyTraining.getVenue(), 36.0f, detailY + 30.0f, paint4);
                                                                            String remarks = !StringsKt.isBlank(safetyTraining.getRemarks()) ? safetyTraining.getRemarks() : "Training conducted in accordance with EHS standards with active worker participation.";
                                                                            canvas2.drawText("Remarks / Scope: " + (remarks.length() > 90 ? StringsKt.take(remarks, 88) + ".." : remarks), 36.0f, 44.0f + detailY, paint4);
                                                                            paint3.setColor(Color.parseColor("#059669"));
                                                                            paint3.setTextSize(9.5f);
                                                                            paint3.setTextAlign(Paint.Align.RIGHT);
                                                                            canvas2.drawText("Rating: " + safetyTraining.getEffectivenessRating(), 842 - 36.0f, 18.0f + detailY, paint3);
                                                                            paint3.setColor(Color.parseColor("#1E293B"));
                                                                            canvas2.drawText(safetyTraining.getAttendeesCount() + " Attendees • " + safetyTraining.getDurationHours() + "h", 842 - 36.0f, 34.0f + detailY, paint3);
                                                                            paint3.setTextAlign(Paint.Align.LEFT);
                                                                            detailY += 60.0f;
                                                                            i12 = i;
                                                                            take = iterable2;
                                                                            i11 = i2;
                                                                            darkBlueColor5 = darkBlueColor;
                                                                            it4 = it5;
                                                                        } catch (Exception e12) {
                                                                            e = e12;
                                                                            e.printStackTrace();
                                                                            return false;
                                                                        }
                                                                    }
                                                                } catch (Exception e13) {
                                                                    e = e13;
                                                                }
                                                            } catch (Exception e14) {
                                                                e = e14;
                                                            }
                                                        } catch (Exception e15) {
                                                            e = e15;
                                                        }
                                                        try {
                                                            paint4.setColor(headerBarColor2);
                                                            try {
                                                                canvas2.drawRect(0.0f, pageHeight2 - 25.0f, 842, pageHeight2, paint4);
                                                                paint3.setColor(-1);
                                                                paint3.setTextSize(8.5f);
                                                                paint3.setTextAlign(Paint.Align.CENTER);
                                                                canvas2.drawText("ISO 45001:2018 OCCUPATIONAL HEALTH & SAFETY MANAGEMENT SYSTEM  •  TRAINING DOSSIER", 842 / 2.0f, pageHeight2 - 9.0f, paint3);
                                                                pdfDocument3.finishPage(page2);
                                                            } catch (Exception e16) {
                                                                e = e16;
                                                                e.printStackTrace();
                                                                return false;
                                                            }
                                                        } catch (Exception e17) {
                                                            e = e17;
                                                            e.printStackTrace();
                                                            return false;
                                                        }
                                                    }
                                                    try {
                                                        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
                                                        try {
                                                            pdfDocument3.writeTo(fileOutputStream);
                                                            Unit unit = Unit.INSTANCE;
                                                            CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                                                            pdfDocument3.close();
                                                            return true;
                                                        } finally {
                                                        }
                                                    } catch (Exception e18) {
                                                        e = e18;
                                                        e.printStackTrace();
                                                        return false;
                                                    }
                                                } catch (Exception e19) {
                                                    e = e19;
                                                }
                                            } catch (Exception e20) {
                                                e = e20;
                                            }
                                        } catch (Exception e21) {
                                            e = e21;
                                        }
                                    } catch (Exception e22) {
                                        e = e22;
                                    }
                                } catch (Exception e23) {
                                    e = e23;
                                }
                            } catch (Exception e24) {
                                e = e24;
                            }
                        } catch (Exception e25) {
                            e = e25;
                        }
                    } catch (Exception e26) {
                        e = e26;
                    }
                } catch (Exception e27) {
                    e = e27;
                }
            } catch (Exception e28) {
                e = e28;
            }
        } catch (Exception e29) {
            e = e29;
        }
    }

    public static /* synthetic */ boolean generateMonthComparisonPdfReport$default(PdfReportGenerator pdfReportGenerator, Context context, String str, List list, List list2, List list3, List list4, String str2, String str3, File file, int i, Object obj) {
        String str4;
        if ((i & 128) == 0) {
            str4 = str3;
        } else {
            str4 = "J. VELMURUGAN";
        }
        return pdfReportGenerator.generateMonthComparisonPdfReport(context, str, list, list2, list3, list4, str2, str4, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:231:0x0ca4  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0cf1  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0cf4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean generateMonthComparisonPdfReport(android.content.Context r62, java.lang.String r63, java.util.List<com.example.data.Observation> r64, java.util.List<com.example.data.Observation> r65, java.util.List<com.example.data.IncidentRecord> r66, java.util.List<com.example.data.IncidentRecord> r67, java.lang.String r68, java.lang.String r69, java.io.File r70) {
        /*
            Method dump skipped, instructions count: 3578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.PdfReportGenerator.generateMonthComparisonPdfReport(android.content.Context, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, java.lang.String, java.lang.String, java.io.File):boolean");
    }

    public static /* synthetic */ boolean generateUnifiedMasterPdfReport$default(PdfReportGenerator pdfReportGenerator, Context context, Company company, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, List list10, List list11, String str, String str2, File file, int i, Object obj) {
        String str3;
        if ((i & 16384) == 0) {
            str3 = str2;
        } else {
            str3 = "J. VELMURUGAN";
        }
        return pdfReportGenerator.generateUnifiedMasterPdfReport(context, company, list, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, str, str3, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0c3d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0c40  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean generateUnifiedMasterPdfReport(android.content.Context r113, com.example.data.Company r114, java.util.List<java.lang.String> r115, java.util.List<com.example.data.Observation> r116, java.util.List<com.example.data.Observation> r117, java.util.List<com.example.data.Observation> r118, java.util.List<com.example.data.ResponsiblePerson> r119, java.util.List<com.example.data.IncidentRecord> r120, java.util.List<com.example.data.SafetyTraining> r121, java.util.List<com.example.data.Observation> r122, java.util.List<com.example.data.Observation> r123, java.util.List<com.example.data.IncidentRecord> r124, java.util.List<com.example.data.IncidentRecord> r125, java.lang.String r126, java.lang.String r127, java.io.File r128) {
        /*
            Method dump skipped, instructions count: 6518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.PdfReportGenerator.generateUnifiedMasterPdfReport(android.content.Context, com.example.data.Company, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.lang.String, java.lang.String, java.io.File):boolean");
    }

    static /* synthetic */ Bitmap loadVectorLogoBitmap$default(PdfReportGenerator pdfReportGenerator, Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 240;
        }
        if ((i3 & 4) != 0) {
            i2 = 200;
        }
        return pdfReportGenerator.loadVectorLogoBitmap(context, i, i2);
    }

    private final Bitmap loadVectorLogoBitmap(Context context, int width, int height) {
        try {
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_app_logo);
            if (drawable == null) {
                return null;
            }
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, width, height);
            drawable.draw(canvas);
            return bitmap;
        } catch (Exception e) {
            return null;
        }
    }

    static /* synthetic */ void drawWatermark$default(PdfReportGenerator pdfReportGenerator, Canvas canvas, float f, float f2, Bitmap bitmap, int i, int i2, Object obj) {
        int i3;
        if ((i2 & 16) == 0) {
            i3 = i;
        } else {
            i3 = 18;
        }
        pdfReportGenerator.drawWatermark(canvas, f, f2, bitmap, i3);
    }

    private final void drawWatermark(Canvas canvas, float pageWidth, float pageHeight, Bitmap logoBitmap, int alpha) {
        if (logoBitmap == null) {
            return;
        }
        Paint watermarkPaint = new Paint(1);
        watermarkPaint.setAlpha(alpha);
        float size = Math.min(pageWidth, pageHeight) * 0.48f;
        float left = (pageWidth - size) / 2.0f;
        float top = (pageHeight - size) / 2.0f;
        RectF destRect = new RectF(left, top, left + size, top + size);
        canvas.drawBitmap(logoBitmap, (Rect) null, destRect, watermarkPaint);
    }
}
