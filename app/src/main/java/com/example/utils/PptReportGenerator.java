package com.example.utils;

import android.content.Context;
import com.example.data.Company;
import com.example.data.IncidentRecord;
import com.example.data.Observation;
import com.example.data.ResponsiblePerson;
import com.example.data.SafetyTraining;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: PptReportGenerator.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002J\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002J0\u0010#\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000eJ.\u0010&\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001aJ&\u0010*\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eH\u0002J6\u0010-\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u000b2\u0006\u00100\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011JÊ\u0001\u00101\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u00106\u001a\b\u0012\u0004\u0012\u0002070\u000b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u000b2\f\u00108\u001a\b\u0012\u0004\u0012\u0002090\u000b2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020/0\u000b2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020/0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006>"}, d2 = {"Lcom/example/utils/PptReportGenerator;", "", "<init>", "()V", "generatePptReport", "", "context", "Landroid/content/Context;", "company", "Lcom/example/data/Company;", "observations", "", "Lcom/example/data/Observation;", "dateRangeText", "", "presenterName", "outputFile", "Ljava/io/File;", "addZipEntry", "", "zos", "Ljava/util/zip/ZipOutputStream;", "entryName", "content", "buildContentTypesXml", "totalSlides", "", "buildRelsXml", "buildPresentationXml", "buildPresentationRelsXml", "buildSlideMasterXml", "buildSlideLayoutXml", "buildSlideRelsXml", "buildSlideMasterRelsXml", "buildSlideLayoutRelsXml", "buildCoverSlideXml", "totalObs", "reportTitle", "buildFindingSlideXml", "obs", "findIndex", "slideNum", "buildClosingSlideXml", "sanitizeText", "input", "generateInjurySummaryPpt", "incidents", "Lcom/example/data/IncidentRecord;", "companyName", "generateUnifiedMasterPptReport", "selectedReportKeys", "unsafeActObservations", "unsafeConditionObservations", "safetyStarObservations", "rosterList", "Lcom/example/data/ResponsiblePerson;", "trainings", "Lcom/example/data/SafetyTraining;", "currentObs", "previousObs", "currentIncidents", "previousIncidents", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class PptReportGenerator {
    public static final int $stable = 0;
    public static final PptReportGenerator INSTANCE = new PptReportGenerator();

    private PptReportGenerator() {
    }

    public static /* synthetic */ boolean generatePptReport$default(PptReportGenerator pptReportGenerator, Context context, Company company, List list, String str, String str2, File file, int i, Object obj) {
        String str3;
        if ((i & 16) == 0) {
            str3 = str2;
        } else {
            str3 = "J. VELMURUGAN";
        }
        return pptReportGenerator.generatePptReport(context, company, list, str, str3, file);
    }

    public final boolean generatePptReport(Context context, Company company, List<Observation> observations, String dateRangeText, String presenterName, File outputFile) {
        List list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(company, "company");
        Intrinsics.checkNotNullParameter(observations, "observations");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(presenterName, "presenterName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outputFile));
            if (observations.isEmpty()) {
                list = CollectionsKt.listOf(new Observation(0L, company.getId(), "ZERO-NC", "Entire Facility", "Good Practice", "Zero Non-Conformance (SNC) observations recorded for the specified audit period. 100% compliance maintained.", "Maintain existing high standard safety practices, housekeeping, and proactive hazard reporting.", "EHS Team", (String) null, (String) null, "N/A", (String) null, (String) null, (String) null, "Active preventive controls maintained.", (String) null, (String) null, true, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0L, 268286721, (DefaultConstructorMarker) null));
            } else {
                list = observations;
            }
            List<Observation> effectiveObservations = list;
            int totalSlides = effectiveObservations.size() + 1 + 1;
            addZipEntry(zos, "[Content_Types].xml", buildContentTypesXml(totalSlides));
            addZipEntry(zos, "_rels/.rels", buildRelsXml());
            addZipEntry(zos, "ppt/presentation.xml", buildPresentationXml(totalSlides));
            addZipEntry(zos, "ppt/_rels/presentation.xml.rels", buildPresentationRelsXml(totalSlides));
            addZipEntry(zos, "ppt/slideMasters/slideMaster1.xml", buildSlideMasterXml());
            addZipEntry(zos, "ppt/slideMasters/_rels/slideMaster1.xml.rels", buildSlideMasterRelsXml());
            addZipEntry(zos, "ppt/slideLayouts/slideLayout1.xml", buildSlideLayoutXml());
            addZipEntry(zos, "ppt/slideLayouts/_rels/slideLayout1.xml.rels", buildSlideLayoutRelsXml());
            int i = 1;
            if (1 <= totalSlides) {
                while (true) {
                    addZipEntry(zos, "ppt/slides/_rels/slide" + i + ".xml.rels", buildSlideRelsXml());
                    if (i == totalSlides) {
                        break;
                    }
                    i++;
                }
            }
            try {
                addZipEntry(zos, "ppt/slides/slide1.xml", buildCoverSlideXml$default(this, company, dateRangeText, observations.size(), presenterName, null, 16, null));
                int i2 = 0;
                for (Observation obs : effectiveObservations) {
                    int index = i2;
                    int i3 = i2 + 1;
                    int slideNum = index + 2;
                    int totalSlides2 = totalSlides;
                    try {
                        addZipEntry(zos, "ppt/slides/slide" + slideNum + ".xml", buildFindingSlideXml(company, obs, index + 1, slideNum, totalSlides2));
                        totalSlides = totalSlides2;
                        i2 = i3;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        return false;
                    }
                }
                int totalSlides3 = totalSlides;
                addZipEntry(zos, "ppt/slides/slide" + totalSlides3 + ".xml", buildClosingSlideXml(company, totalSlides3, totalSlides3, presenterName));
                zos.close();
                return true;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

        private final void addAssetZipEntry(ZipOutputStream zos, Context context, String entryName, String assetName) {
        try {
            InputStream is = context.getAssets().open(assetName);
            ZipEntry entry = new ZipEntry(entryName);
            zos.putNextEntry(entry);
            byte[] buffer = new byte[8192];
            int len;
            while ((len = is.read(buffer)) != -1) {
                zos.write(buffer, 0, len);
            }
            zos.closeEntry();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

private final void addZipEntry(ZipOutputStream zos, String entryName, String content) {
        ZipEntry entry = new ZipEntry(entryName);
        zos.putNextEntry(entry);
        byte[] bytes = content.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        zos.write(bytes);
        zos.closeEntry();
    }

    private final String buildContentTypesXml(int totalSlides) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        sb.append("<Types xmlns=\"http://schemas.openxmlformats.org/package/2006/content-types\">");
        sb.append("<Default Extension=\"rels\" ContentType=\"application/vnd.openxmlformats-package.relationships+xml\"/>");
        sb.append("<Default Extension=\"xml\" ContentType=\"application/xml\"/>");
        sb.append("<Default Extension=\"jpg\" ContentType=\"image/jpeg\"/>");
        sb.append("<Default Extension=\"jpeg\" ContentType=\"image/jpeg\"/>");
        sb.append("<Default Extension=\"png\" ContentType=\"image/png\"/>");
        sb.append("<Override PartName=\"/ppt/presentation.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.presentationml.presentation.main+xml\"/>");
        sb.append("<Override PartName=\"/ppt/slideMasters/slideMaster1.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.presentationml.slideMaster+xml\"/>");
        sb.append("<Override PartName=\"/ppt/slideLayouts/slideLayout1.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.presentationml.slideLayout+xml\"/>");
        int i = 1;
        if (1 <= totalSlides) {
            while (true) {
                sb.append("<Override PartName=\"/ppt/slides/slide" + i + ".xml\" ContentType=\"application/vnd.openxmlformats-officedocument.presentationml.slide+xml\"/>");
                if (i == totalSlides) {
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

    private final String buildPresentationXml(int totalSlides) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        sb.append("<p:presentation xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">");
        sb.append("<p:sldMasterIdLst><p:sldMasterId id=\"2147483648\" r:id=\"rId1\"/></p:sldMasterIdLst>");
        sb.append("<p:sldIdLst>");
        int i = 1;
        if (1 <= totalSlides) {
            while (true) {
                int id = i + 255;
                sb.append("<p:sldId id=\"" + id + "\" r:id=\"rId" + (i + 1) + "\"/>");
                if (i == totalSlides) {
                    break;
                }
                i++;
            }
        }
        sb.append("</p:sldIdLst>");
        sb.append("<p:sldSz cx=\"11887200\" cy=\"8409600\"/>");
        sb.append("</p:presentation>");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final String buildPresentationRelsXml(int totalSlides) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        sb.append("<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">");
        sb.append("<Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideMaster\" Target=\"slideMasters/slideMaster1.xml\"/>");
        int i = 1;
        if (1 <= totalSlides) {
            while (true) {
                sb.append("<Relationship Id=\"rId" + (i + 1) + "\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/slide\" Target=\"slides/slide" + i + ".xml\"/>");
                if (i == totalSlides) {
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
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sldMaster xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld><p:spTree><p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr><p:grpSpPr/></p:spTree></p:cSld>\n  <p:clrMap bg1=\"lt1\" tx1=\"dk1\" bg2=\"lt2\" tx2=\"dk2\" accent1=\"accent1\" accent2=\"accent2\" accent3=\"accent3\" accent4=\"accent4\" accent5=\"accent5\" accent6=\"accent6\" hlink=\"hlink\" folHlink=\"folHlink\"/>\n  <p:txStyles>\n    <p:titleStyle><a:lvl1pPr><a:defRPr><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:defRPr></a:lvl1pPr></p:titleStyle>\n    <p:bodyStyle><a:lvl1pPr><a:defRPr><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:defRPr></a:lvl1pPr></p:bodyStyle>\n    <p:otherStyle><a:defPPr><a:defRPr><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:defRPr></a:defPPr></p:otherStyle>\n  </p:txStyles>\n</p:sldMaster>";
    }

    private final String buildSlideLayoutXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sldLayout xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\" type=\"blank\">\n  <p:cSld><p:spTree><p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvPr/><p:nvPr/></p:nvGrpSpPr><p:grpSpPr/></p:spTree></p:cSld>\n</p:sldLayout>";
    }

        private final String buildSlideRelsXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>
" +
               "<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">
" +
               "  <Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideLayout\" Target=\"../slideLayouts/slideLayout1.xml\"/>
" +
               "  <Relationship Id=\"rIdLogo\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/image\" Target=\"../media/logo.jpg\"/>
" +
               "  <Relationship Id=\"rIdGlobe\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/image\" Target=\"../media/globe.jpg\"/>
" +
               "  <Relationship Id=\"rIdWatermark\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/image\" Target=\"../media/watermark.png\"/>
" +
               "</Relationships>";
    }

    private final String buildSlideMasterRelsXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">\n  <Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideLayout\" Target=\"../slideLayouts/slideLayout1.xml\"/>\n</Relationships>";
    }

    private final String buildSlideLayoutRelsXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">\n  <Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideMaster\" Target=\"../slideMasters/slideMaster1.xml\"/>\n</Relationships>";
    }

    public static /* synthetic */ String buildCoverSlideXml$default(PptReportGenerator pptReportGenerator, Company company, String str, int i, String str2, String str3, int i2, Object obj) {
        String str4;
        if ((i2 & 16) == 0) {
            str4 = str3;
        } else {
            str4 = "ESG PERFORMANCE & COMPLIANCE REVIEW";
        }
        return pptReportGenerator.buildCoverSlideXml(company, str, i, str2, str4);
    }

    public final String buildCoverSlideXml(Company company, String dateRangeText, int totalObs, String presenterName, String reportTitle) {
        Intrinsics.checkNotNullParameter(company, "company");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(presenterName, "presenterName");
        Intrinsics.checkNotNullParameter(reportTitle, "reportTitle");
        String name = company.getName();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = name.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String compName = sanitizeText(upperCase);
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
        String upperCase2 = presenterName.toUpperCase(locale2);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        String presenter = sanitizeText(upperCase2);
        String safeDateRange = sanitizeText(!StringsKt.isBlank(dateRangeText) ? dateRangeText : "CURRENT AUDIT CYCLE");
        Locale locale3 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
        String upperCase3 = reportTitle.toUpperCase(locale3);
        Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
        String safeTitle = sanitizeText(upperCase3);
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr/>\n      \n      <!-- Rich Executive Maroon Canvas (PDF Page 1 Reference) -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"101\" name=\"Canvas BG\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr>\n          <a:off x=\"0\" y=\"0\"/>\n          <a:ext cx=\"11887200\" cy=\"8409600\"/>\n          <a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom>\n          <a:solidFill><a:srgbClr val=\"6B0B24\"/></a:solidFill>\n        </p:spPr>\n      </p:sp>\n\n      <!-- Top-Left Veltrix Sentinel Shield & Brand Block -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"102\" name=\"Shield Icon\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr>\n          <a:off x=\"600000\" y=\"450000\"/>\n          <a:ext cx=\"550000\" cy=\"550000\"/>\n          <a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 2500\"/></a:avLst></p:prstGeom>\n          <a:solidFill><a:srgbClr val=\"54061A\"/></a:solidFill>\n          <a:ln w=\"19050\"><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></a:ln>\n        </p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"2200\" b=\"1\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>🛡️</a:t></a:r></a:p>\n        </p:txBody>\n      </p:sp>\n\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"103\" name=\"Brand Title &amp; Tagline\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"1250000\" y=\"420000\"/><a:ext cx=\"5800000\" cy=\"620000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"t\"/>\n          <a:p><a:r><a:rPr sz=\"2600\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>VELTRIX SENTINEL</a:t></a:r></a:p>\n          <a:p><a:r><a:rPr sz=\"1150\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Safety, Compliance &amp; Sustainability – Managed Right.</a:t></a:r></a:p>\n        </p:txBody>\n      </p:sp>\n\n      <!-- Delicate Gold Accent Underline -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"104\" name=\"Top Brand Line\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"1150000\"/><a:ext cx=\"6400000\" cy=\"18000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></p:spPr>\n      </p:sp>\n\n      <!-- Top-Right 3 Italic Mission Script Lines -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"105\" name=\"Top Right Script\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"7800000\" y=\"420000\"/><a:ext cx=\"3500000\" cy=\"900000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"t\"/>\n          <a:p><a:pPr algn=\"r\"/><a:r><a:rPr sz=\"1350\" i=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>A Safer Today...</a:t></a:r></a:p>\n          <a:p><a:pPr algn=\"r\"/><a:r><a:rPr sz=\"1350\" i=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>A Greener Tomorrow...</a:t></a:r></a:p>\n          <a:p><a:pPr algn=\"r\"/><a:r><a:rPr sz=\"1350\" i=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Together Always...</a:t></a:r></a:p>\n        </p:txBody>\n      </p:sp>\n\n      <!-- Center Title: < COMPANY NAME > -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"106\" name=\"Company Name Title\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"1950000\"/><a:ext cx=\"6600000\" cy=\"800000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"t\"/>\n          <a:p><a:r><a:rPr sz=\"3400\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>&lt; " + compName + " &gt;</a:t></a:r></a:p>\n        </p:txBody>\n      </p:sp>\n\n      <!-- Center Sub-rule -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"107\" name=\"Company Underline\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"2750000\"/><a:ext cx=\"5800000\" cy=\"20000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></p:spPr>\n      </p:sp>\n\n      <!-- Review Sub-heading -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"108\" name=\"Review Heading\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"2850000\"/><a:ext cx=\"6600000\" cy=\"450000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"t\"/>\n          <a:p><a:r><a:rPr sz=\"1750\" b=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + safeTitle + "</a:t></a:r></a:p>\n        </p:txBody>\n      </p:sp>\n\n      <!-- Left Badge 1: PRESENTED BY -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"109\" name=\"Presenter Badge Frame\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr>\n          <a:off x=\"600000\" y=\"3750000\"/>\n          <a:ext cx=\"4600000\" cy=\"1150000\"/>\n          <a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 2000\"/></a:avLst></p:prstGeom>\n          <a:solidFill><a:srgbClr val=\"54061A\"/></a:solidFill>\n          <a:ln w=\"22225\"><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></a:ln>\n        </p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\" lIns=\"200000\" rIns=\"200000\"/>\n          <a:p><a:r><a:rPr sz=\"1100\" b=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>●   PRESENTED BY</a:t></a:r></a:p>\n          <a:p><a:r><a:rPr sz=\"1600\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + presenter + "</a:t></a:r></a:p>\n        </p:txBody>\n      </p:sp>\n\n      <!-- Left Badge 2: REPORTING PERIOD -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"110\" name=\"Period Badge Frame\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr>\n          <a:off x=\"600000\" y=\"5150000\"/>\n          <a:ext cx=\"4600000\" cy=\"1150000\"/>\n          <a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 2000\"/></a:avLst></p:prstGeom>\n          <a:solidFill><a:srgbClr val=\"54061A\"/></a:solidFill>\n          <a:ln w=\"22225\"><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></a:ln>\n        </p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\" lIns=\"200000\" rIns=\"200000\"/>\n          <a:p><a:r><a:rPr sz=\"1100\" b=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>●   REPORTING PERIOD</a:t></a:r></a:p>\n          <a:p><a:r><a:rPr sz=\"1600\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + safeDateRange + "</a:t></a:r></a:p>\n        </p:txBody>\n      </p:sp>\n\n      <!-- Right Side: Earth Globe & Green Wreath Motif -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"111\" name=\"Outer Orbit Ring\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr>\n          <a:off x=\"7200000\" y=\"2100000\"/>\n          <a:ext cx=\"3900000\" cy=\"3900000\"/>\n          <a:prstGeom prst=\"ellipse\"><a:avLst/></a:prstGeom>\n          <a:ln w=\"25400\"><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></a:ln>\n        </p:spPr>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"112\" name=\"Earth Globe\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr>\n          <a:off x=\"7550000\" y=\"2450000\"/>\n          <a:ext cx=\"3200000\" cy=\"3200000\"/>\n          <a:prstGeom prst=\"ellipse\"><a:avLst/></a:prstGeom>\n          <a:solidFill><a:srgbClr val=\"0284C7\"/></a:solidFill>\n          <a:ln w=\"31750\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill></a:ln>\n        </p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"4200\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>🌍</a:t></a:r></a:p>\n        </p:txBody>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"113\" name=\"Globe Label\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"7400000\" y=\"5800000\"/><a:ext cx=\"3500000\" cy=\"500000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1300\" b=\"1\" i=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>🌱 Sustainable EHS Operations</a:t></a:r></a:p>\n        </p:txBody>\n      </p:sp>\n\n      <!-- Bottom Line & Motto -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"114\" name=\"Bottom Line\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"7350000\"/><a:ext cx=\"10687200\" cy=\"18000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></p:spPr>\n      </p:sp>\n\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"115\" name=\"Bottom Motto\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"7500000\"/><a:ext cx=\"10687200\" cy=\"400000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1300\" b=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>PEOPLE SAFE   |   PROCESS COMPLIANT   |   PLANET SUSTAINABLE</a:t></a:r></a:p>\n        </p:txBody>\n      </p:sp>\n\n    </p:spTree>\n  </p:cSld>\n</p:sld>";
    }

    public final String buildFindingSlideXml(Company company, Observation obs, int findIndex, int slideNum, int totalSlides) {
        String divName;
        String issueText;
        Intrinsics.checkNotNullParameter(company, "company");
        Intrinsics.checkNotNullParameter(obs, "obs");
        String name = company.getName();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = name.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String compName = sanitizeText(upperCase);
        if (company.getDivision().length() > 0) {
            String division = company.getDivision();
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
            String upperCase2 = division.toUpperCase(locale2);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            divName = sanitizeText(upperCase2);
        } else {
            divName = "";
        }
        String location = obs.getLocation();
        if (StringsKt.isBlank(location)) {
            location = "General Facility Area";
        }
        String locText = sanitizeText(location);
        String issueDetails = obs.getIssueDetails();
        if (StringsKt.isBlank(issueDetails)) {
            issueDetails = "Non-conformance recorded during walkthrough.";
        }
        String issueText2 = sanitizeText(issueDetails);
        String suggestion = obs.getSuggestion();
        if (StringsKt.isBlank(suggestion)) {
            suggestion = "Implement corrective engineering / administrative controls.";
        }
        String sugText = sanitizeText(suggestion);
        String respText = sanitizeText(obs.getResponsiblePerson().length() > 0 ? obs.getResponsiblePerson() : "EHS Incharge");
        String targetText = sanitizeText(obs.getTargetDate().length() > 0 ? obs.getTargetDate() : "Immediate");
        String actionText = sanitizeText(obs.getActionTaken().length() > 0 ? obs.getActionTaken() : obs.isResolved() ? "Corrective action implemented and verified." : "Corrective action pending.");
        String compDateText = sanitizeText(obs.getCompletedDate().length() > 0 ? obs.getCompletedDate() : obs.isResolved() ? "Verified Closed" : MaterialFollowUpUtils.STATUS_IN_PROGRESS);
        String footerTitle = (divName.length() > 0 ? new StringBuilder().append("&lt; ").append(compName).append(" - ").append(divName) : new StringBuilder().append("&lt; ").append(compName)).append(" &gt;").toString();
        boolean isSafetyStar = StringsKt.equals(obs.getFindingType(), "Safety Star", true);
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\"\n       xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"\n       xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr><a:xfrm><a:off x=\"0\" y=\"0\"/><a:ext cx=\"0\" cy=\"0\"/><a:chOff x=\"0\" y=\"0\"/><a:chExt cx=\"0\" cy=\"0\"/></a:xfrm></p:grpSpPr>\n");
        sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"101\" name=\"Canvas BG\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
        sb.append("<p:spPr><a:off x=\"0\" y=\"0\"/><a:ext cx=\"11887200\" cy=\"8409600\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill></p:spPr></p:sp>");
        sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"102\" name=\"Watermark Logo\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
        sb.append("<p:spPr><a:off x=\"4443600\" y=\"2704800\"/><a:ext cx=\"3000000\" cy=\"3000000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 2500\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"FFF8FA\"/></a:solidFill><a:ln w=\"12700\"><a:solidFill><a:srgbClr val=\"FCE7F3\"/></a:solidFill></a:ln></p:spPr>");
        sb.append("<p:txBody><a:bodyPr anchor=\"ctr\"/><a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"2800\"><a:solidFill><a:srgbClr val=\"FCD34D\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>🛡️</a:t></a:r></a:p>");
        sb.append("<a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1250\" b=\"1\"><a:solidFill><a:srgbClr val=\"F9A8D4\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>VELTRIX SENTINEL</a:t></a:r></a:p></p:txBody></p:sp>");
        sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"103\" name=\"Branded Header\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
        sb.append("<p:spPr><a:off x=\"500000\" y=\"200000\"/><a:ext cx=\"10887200\" cy=\"400000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>");
        sb.append("<p:txBody><a:bodyPr anchor=\"ctr\"/>");
        sb.append("<a:p><a:r><a:rPr sz=\"1300\" b=\"1\"><a:solidFill><a:srgbClr val=\"700D2B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>🛡️ VELTRIX SENTINEL - </a:t></a:r>");
        sb.append("<a:r><a:rPr sz=\"1200\"><a:solidFill><a:srgbClr val=\"475569\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Safety, Compliance &amp; Sustainability – Managed Right.</a:t></a:r></a:p>");
        sb.append("</p:txBody></p:sp>");
        if (isSafetyStar) {
            String respText2 = obs.getEmployeeName();
            if (StringsKt.isBlank(respText2)) {
                respText2 = "Safety Compliant Team Member";
            }
            String starEmpName = sanitizeText(respText2);
            String employeeId = obs.getEmployeeId();
            if (StringsKt.isBlank(employeeId)) {
                employeeId = "Recorded on Tour";
            }
            String sugText2 = employeeId;
            String starEmpId = sanitizeText(sugText2);
            String employeeDesignation = obs.getEmployeeDesignation();
            if (StringsKt.isBlank(employeeDesignation)) {
                employeeDesignation = "Plant Operative";
            }
            String rightX = employeeDesignation;
            String starEmpDesig = sanitizeText(rightX);
            if (StringsKt.isBlank(obs.getEmployeeDepartment())) {
                String department = obs.getDepartment();
                if (StringsKt.isBlank(department)) {
                    department = "Manufacturing";
                }
                issueText = department;
            } else {
                issueText = obs.getEmployeeDepartment();
            }
            String starEmpDept = sanitizeText(issueText);
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"104\" name=\"Title Banner\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"500000\" y=\"650000\"/><a:ext cx=\"10887200\" cy=\"550000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 1200\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"700D2B\"/></a:solidFill><a:ln w=\"19050\"><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></a:ln></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"ctr\"/>");
            sb.append("<a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1900\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>⭐ SAFETY STAR COMPLIANT EMPLOYEE RECOGNITION #" + findIndex + "</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"10\" name=\"Employee Details Card\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"500000\" y=\"1350000\"/><a:ext cx=\"5250000\" cy=\"6250000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 1200\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"FAFAFA\"/></a:solidFill><a:ln w=\"19050\"><a:solidFill><a:srgbClr val=\"059669\"/></a:solidFill></a:ln></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"t\" lIns=\"150000\" tIns=\"150000\" rIns=\"150000\" bIns=\"150000\"/>");
            sb.append("<a:p><a:r><a:rPr sz=\"1600\" b=\"1\"><a:solidFill><a:srgbClr val=\"059669\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>⭐ COMPLIANT EMPLOYEE DETAILS</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1300\" b=\"1\"><a:solidFill><a:srgbClr val=\"1E293B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>• Name: </a:t></a:r><a:r><a:rPr sz=\"1300\"><a:solidFill><a:srgbClr val=\"334155\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + starEmpName + "</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1300\" b=\"1\"><a:solidFill><a:srgbClr val=\"1E293B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>• Emp ID: </a:t></a:r><a:r><a:rPr sz=\"1300\"><a:solidFill><a:srgbClr val=\"334155\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + starEmpId + "</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1300\" b=\"1\"><a:solidFill><a:srgbClr val=\"1E293B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>• Designation: </a:t></a:r><a:r><a:rPr sz=\"1300\"><a:solidFill><a:srgbClr val=\"334155\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + starEmpDesig + "</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1300\" b=\"1\"><a:solidFill><a:srgbClr val=\"1E293B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>• Department: </a:t></a:r><a:r><a:rPr sz=\"1300\"><a:solidFill><a:srgbClr val=\"334155\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + starEmpDept + "</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1300\" b=\"1\"><a:solidFill><a:srgbClr val=\"700D2B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>📍 LOCATION: </a:t></a:r><a:r><a:rPr sz=\"1300\"><a:solidFill><a:srgbClr val=\"334155\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + locText + "</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1350\" b=\"1\"><a:solidFill><a:srgbClr val=\"B45309\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>⭐ REASON FOR SELECTION:</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1250\"><a:solidFill><a:srgbClr val=\"334155\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + issueText2 + "</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"20\" name=\"Commendation Card\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"6137200\" y=\"1350000\"/><a:ext cx=\"5250000\" cy=\"6250000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 1200\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"FAFAFA\"/></a:solidFill><a:ln w=\"19050\"><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></a:ln></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"t\" lIns=\"150000\" tIns=\"150000\" rIns=\"150000\" bIns=\"150000\"/>");
            sb.append("<a:p><a:r><a:rPr sz=\"1600\" b=\"1\"><a:solidFill><a:srgbClr val=\"B45309\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>🏆 SAFETY EXCELLENCE COMMENDATION</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1350\" b=\"1\" i=\"1\"><a:solidFill><a:srgbClr val=\"059669\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>“A Zero-Harm Workplace Starts With Individual Commitment!”</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1350\" b=\"1\"><a:solidFill><a:srgbClr val=\"700D2B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>KEY OBSERVED SAFE PRACTICES:</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1250\"><a:solidFill><a:srgbClr val=\"334155\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>✓ 100% Correct usage of Mandatory PPE</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1250\"><a:solidFill><a:srgbClr val=\"334155\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>✓ Proactive maintenance of safe work area</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1250\"><a:solidFill><a:srgbClr val=\"334155\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>✓ Active participation in safety toolbox talks</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1250\"><a:solidFill><a:srgbClr val=\"334155\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>✓ Role model behavior promoting safe work culture</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
        } else {
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"104\" name=\"Title Banner\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"500000\" y=\"650000\"/><a:ext cx=\"10887200\" cy=\"550000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 1200\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"700D2B\"/></a:solidFill><a:ln w=\"19050\"><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></a:ln></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"ctr\"/>");
            sb.append("<a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1900\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>🛡️ SAFETY NON-CONFORMANCE AUDIT FINDING #" + findIndex + "</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"10\" name=\"Before Header\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"500000\" y=\"1300000\"/><a:ext cx=\"5250000\" cy=\"400000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"ctr\"/>");
            sb.append("<a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"2000\" b=\"1\"><a:solidFill><a:srgbClr val=\"DC2626\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>BEFORE</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"11\" name=\"Before Photo Frame\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"500000\" y=\"1750000\"/><a:ext cx=\"5250000\" cy=\"2800000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"F8FAFC\"/></a:solidFill><a:ln w=\"12700\"><a:solidFill><a:srgbClr val=\"CBD5E1\"/></a:solidFill></a:ln></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"ctr\"/>");
            sb.append("<a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1500\" b=\"1\"><a:solidFill><a:srgbClr val=\"64748B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>📷 BEFORE AUDIT PHOTO EVIDENCE</a:t></a:r></a:p>");
            sb.append("<a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1150\"><a:solidFill><a:srgbClr val=\"94A3B8\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>(Defect / Unsafe Condition Captured on Walkthrough)</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"12\" name=\"Before Details Box\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"500000\" y=\"4650000\"/><a:ext cx=\"5250000\" cy=\"2450000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:ln w=\"12700\"><a:solidFill><a:srgbClr val=\"CBD5E1\"/></a:solidFill></a:ln></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"t\" wrap=\"square\" lIns=\"120000\" tIns=\"100000\" rIns=\"120000\" bIns=\"100000\"/>");
            sb.append("<a:p><a:r><a:rPr sz=\"1250\" b=\"1\"><a:solidFill><a:srgbClr val=\"700D2B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>LOCATION: </a:t></a:r><a:r><a:rPr sz=\"1200\"><a:solidFill><a:srgbClr val=\"1E293B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + locText + "</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1250\" b=\"1\"><a:solidFill><a:srgbClr val=\"DC2626\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>NON CONFORMANCE: </a:t></a:r><a:r><a:rPr sz=\"1200\"><a:solidFill><a:srgbClr val=\"334155\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + issueText2 + "</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1250\" b=\"1\"><a:solidFill><a:srgbClr val=\"B45309\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>SUGGESTION: </a:t></a:r><a:r><a:rPr sz=\"1200\"><a:solidFill><a:srgbClr val=\"334155\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + sugText + "</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"13\" name=\"Resp Cell\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"500000\" y=\"7150000\"/><a:ext cx=\"2600000\" cy=\"450000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"F8FAFC\"/></a:solidFill><a:ln w=\"12700\"><a:solidFill><a:srgbClr val=\"CBD5E1\"/></a:solidFill></a:ln></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"ctr\" lIns=\"80000\" rIns=\"80000\"/>");
            sb.append("<a:p><a:r><a:rPr sz=\"950\" b=\"1\"><a:solidFill><a:srgbClr val=\"64748B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>RESPONSIBLE PERSON: </a:t></a:r><a:r><a:rPr sz=\"1100\" b=\"1\"><a:solidFill><a:srgbClr val=\"0F172A\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + respText + "</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"14\" name=\"Target Date Cell\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"3150000\" y=\"7150000\"/><a:ext cx=\"2600000\" cy=\"450000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"F8FAFC\"/></a:solidFill><a:ln w=\"12700\"><a:solidFill><a:srgbClr val=\"CBD5E1\"/></a:solidFill></a:ln></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"ctr\" lIns=\"80000\" rIns=\"80000\"/>");
            sb.append("<a:p><a:r><a:rPr sz=\"950\" b=\"1\"><a:solidFill><a:srgbClr val=\"64748B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>TARGET DATE: </a:t></a:r><a:r><a:rPr sz=\"1100\" b=\"1\"><a:solidFill><a:srgbClr val=\"0F172A\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + targetText + "</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"20\" name=\"After Header\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"6137200\" y=\"1300000\"/><a:ext cx=\"5250000\" cy=\"400000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"ctr\"/>");
            sb.append("<a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"2000\" b=\"1\"><a:solidFill><a:srgbClr val=\"16A34A\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>AFTER</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"21\" name=\"After Photo Frame\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"6137200\" y=\"1750000\"/><a:ext cx=\"5250000\" cy=\"2800000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"F8FAFC\"/></a:solidFill><a:ln w=\"12700\"><a:solidFill><a:srgbClr val=\"CBD5E1\"/></a:solidFill></a:ln></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"ctr\"/>");
            sb.append("<a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1500\" b=\"1\"><a:solidFill><a:srgbClr val=\"16A34A\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>📷 AFTER VERIFICATION PHOTO EVIDENCE</a:t></a:r></a:p>");
            sb.append("<a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1150\"><a:solidFill><a:srgbClr val=\"94A3B8\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>(Corrected &amp; Compliant Condition Verified)</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"22\" name=\"After Details Box\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"6137200\" y=\"4650000\"/><a:ext cx=\"5250000\" cy=\"2450000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:ln w=\"12700\"><a:solidFill><a:srgbClr val=\"CBD5E1\"/></a:solidFill></a:ln></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"t\" wrap=\"square\" lIns=\"120000\" tIns=\"100000\" rIns=\"120000\" bIns=\"100000\"/>");
            sb.append("<a:p><a:r><a:rPr sz=\"1250\" b=\"1\"><a:solidFill><a:srgbClr val=\"700D2B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>LOCATION: </a:t></a:r><a:r><a:rPr sz=\"1200\"><a:solidFill><a:srgbClr val=\"1E293B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + locText + "</a:t></a:r></a:p>");
            sb.append("<a:p><a:r><a:rPr sz=\"1250\" b=\"1\"><a:solidFill><a:srgbClr val=\"16A34A\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Action Taken : </a:t></a:r><a:r><a:rPr sz=\"1200\"><a:solidFill><a:srgbClr val=\"334155\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + actionText + "</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"23\" name=\"After Resp Cell\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"6137200\" y=\"7150000\"/><a:ext cx=\"2600000\" cy=\"450000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"F8FAFC\"/></a:solidFill><a:ln w=\"12700\"><a:solidFill><a:srgbClr val=\"CBD5E1\"/></a:solidFill></a:ln></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"ctr\" lIns=\"80000\" rIns=\"80000\"/>");
            sb.append("<a:p><a:r><a:rPr sz=\"950\" b=\"1\"><a:solidFill><a:srgbClr val=\"64748B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>RESPONSIBLE PERSON: </a:t></a:r><a:r><a:rPr sz=\"1100\" b=\"1\"><a:solidFill><a:srgbClr val=\"0F172A\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + respText + "</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
            sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"24\" name=\"Comp Date Cell\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
            sb.append("<p:spPr><a:off x=\"8787200\" y=\"7150000\"/><a:ext cx=\"2600000\" cy=\"450000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"F8FAFC\"/></a:solidFill><a:ln w=\"12700\"><a:solidFill><a:srgbClr val=\"CBD5E1\"/></a:solidFill></a:ln></p:spPr>");
            sb.append("<p:txBody><a:bodyPr anchor=\"ctr\" lIns=\"80000\" rIns=\"80000\"/>");
            sb.append("<a:p><a:r><a:rPr sz=\"950\" b=\"1\"><a:solidFill><a:srgbClr val=\"64748B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>COMPLETED DATE: </a:t></a:r><a:r><a:rPr sz=\"1100\" b=\"1\"><a:solidFill><a:srgbClr val=\"0F172A\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + compDateText + "</a:t></a:r></a:p>");
            sb.append("</p:txBody></p:sp>");
        }
        sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"30\" name=\"Company Name Footer\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
        sb.append("<p:spPr><a:off x=\"500000\" y=\"7850000\"/><a:ext cx=\"9000000\" cy=\"400000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>");
        sb.append("<p:txBody><a:bodyPr anchor=\"ctr\"/>");
        sb.append("<a:p><a:r><a:rPr sz=\"1350\" b=\"1\"><a:solidFill><a:srgbClr val=\"700D2B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + footerTitle + "</a:t></a:r></a:p>");
        sb.append("</p:txBody></p:sp>");
        sb.append("<p:sp><p:nvSpPr><p:cNvPr id=\"31\" name=\"Slide Page Number\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>");
        sb.append("<p:spPr><a:off x=\"10000000\" y=\"7850000\"/><a:ext cx=\"1387200\" cy=\"400000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>");
        sb.append("<p:txBody><a:bodyPr anchor=\"ctr\"/>");
        sb.append("<a:p><a:pPr algn=\"r\"/><a:r><a:rPr sz=\"1350\" b=\"1\"><a:solidFill><a:srgbClr val=\"64748B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + slideNum + "</a:t></a:r></a:p>");
        sb.append("</p:txBody></p:sp>");
        sb.append("</p:spTree></p:cSld></p:sld>");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final String buildClosingSlideXml(Company company, int slideNum, int totalSlides, String presenterName) {
        Intrinsics.checkNotNullParameter(company, "company");
        Intrinsics.checkNotNullParameter(presenterName, "presenterName");
        String name = company.getName();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = name.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String compName = sanitizeText(upperCase);
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
        String upperCase2 = presenterName.toUpperCase(locale2);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        String presenter = sanitizeText(upperCase2);
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr/>\n\n      <!-- Rich Executive Maroon Canvas (PDF Page 3 Reference) -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"201\" name=\"Canvas BG\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr>\n          <a:off x=\"0\" y=\"0\"/>\n          <a:ext cx=\"11887200\" cy=\"8409600\"/>\n          <a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom>\n          <a:solidFill><a:srgbClr val=\"6B0B24\"/></a:solidFill>\n        </p:spPr>\n      </p:sp>\n\n      <!-- Top-Left Veltrix Sentinel Shield & Brand Block -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"202\" name=\"Shield Icon\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr>\n          <a:off x=\"600000\" y=\"450000\"/>\n          <a:ext cx=\"550000\" cy=\"550000\"/>\n          <a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 2500\"/></a:avLst></p:prstGeom>\n          <a:solidFill><a:srgbClr val=\"54061A\"/></a:solidFill>\n          <a:ln w=\"19050\"><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></a:ln>\n        </p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"2200\" b=\"1\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>🛡️</a:t></a:r></a:p>\n        </p:txBody>\n      </p:sp>\n\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"203\" name=\"Brand Title &amp; Tagline\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"1250000\" y=\"420000\"/><a:ext cx=\"5800000\" cy=\"620000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"t\"/>\n          <a:p><a:r><a:rPr sz=\"2600\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>VELTRIX SENTINEL</a:t></a:r></a:p>\n          <a:p><a:r><a:rPr sz=\"1150\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Safety, Compliance &amp; Sustainability – Managed Right.</a:t></a:r></a:p>\n        </p:txBody>\n      </p:sp>\n\n      <!-- Delicate Gold Accent Underline -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"204\" name=\"Top Brand Line\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"1150000\"/><a:ext cx=\"6400000\" cy=\"18000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></p:spPr>\n      </p:sp>\n\n      <!-- Top-Right 3 Italic Mission Script Lines -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"205\" name=\"Top Right Script\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"7800000\" y=\"420000\"/><a:ext cx=\"3500000\" cy=\"900000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"t\"/>\n          <a:p><a:pPr algn=\"r\"/><a:r><a:rPr sz=\"1350\" i=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>A Safer Today...</a:t></a:r></a:p>\n          <a:p><a:pPr algn=\"r\"/><a:r><a:rPr sz=\"1350\" i=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>A Greener Tomorrow...</a:t></a:r></a:p>\n          <a:p><a:pPr algn=\"r\"/><a:r><a:rPr sz=\"1350\" i=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Together Always...</a:t></a:r></a:p>\n        </p:txBody>\n      </p:sp>\n\n      <!-- Center Thank You Presentation -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"206\" name=\"Thank You Main Box\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr>\n          <a:off x=\"1000000\" y=\"1750000\"/>\n          <a:ext cx=\"9887200\" cy=\"4600000\"/>\n          <a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom>\n        </p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\" lIns=\"100000\" tIns=\"100000\" rIns=\"100000\" bIns=\"100000\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"5200\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>THANK YOU</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"2200\" b=\"1\"><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>─── ❧ ───</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1500\" b=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>TOGETHER, LET US BUILD A</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"2500\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>SAFER, HEALTHIER &amp; MORE SUSTAINABLE FUTURE.</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1450\" i=\"1\"><a:solidFill><a:srgbClr val=\"FECDD3\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>— COME SAFE • WORK SAFE • GO HOME SAFELY —</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n\n      <!-- Center Presenter Badge Card -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"207\" name=\"Presenter Badge\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr>\n          <a:off x=\"3943600\" y=\"5850000\"/>\n          <a:ext cx=\"4000000\" cy=\"1150000\"/>\n          <a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 2000\"/></a:avLst></p:prstGeom>\n          <a:solidFill><a:srgbClr val=\"54061A\"/></a:solidFill>\n          <a:ln w=\"22225\"><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></a:ln>\n        </p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\" lIns=\"100000\" rIns=\"100000\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1100\" b=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>●   PRESENTED BY</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1600\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + presenter + "</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n\n      <!-- Bottom Footer: Company Name Flanked by Thin Lines -->\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"208\" name=\"Left Footer Rule\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"1000000\" y=\"7500000\"/><a:ext cx=\"3000000\" cy=\"18000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></p:spPr>\n      </p:sp>\n\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"209\" name=\"Slide Footer\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"4000000\" y=\"7300000\"/><a:ext cx=\"3887200\" cy=\"400000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1350\" b=\"1\"><a:solidFill><a:srgbClr val=\"FDE047\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>■   |   &lt; " + compName + " &gt;</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"210\" name=\"Right Footer Rule\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"7887200\" y=\"7500000\"/><a:ext cx=\"3000000\" cy=\"18000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill></p:spPr>\n      </p:sp>\n\n    </p:spTree>\n  </p:cSld>\n</p:sld>";
    }

    private final String sanitizeText(String input) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(input, "&", "&amp;", false, 4, (Object) null), "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null), "\"", "&quot;", false, 4, (Object) null), "'", "&apos;", false, 4, (Object) null);
    }

    public final boolean generateInjurySummaryPpt(Context context, Company company, List<IncidentRecord> incidents, String companyName, File outputFile) {
        int reportableCount;
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(incidents, "incidents");
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
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
                    break;
                }
                i++;
            }
            String safeComp = sanitizeText(companyName);
            List<IncidentRecord> list = incidents;
            if ((list instanceof Collection) && list.isEmpty()) {
                reportableCount = 0;
            } else {
                reportableCount = 0;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((IncidentRecord) it.next()).isReportable() && (reportableCount = reportableCount + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            int nonReportableCount = incidents.size() - reportableCount;
            String slide1Xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\"\n       xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"\n       xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr><a:xfrm><a:off x=\"0\" y=\"0\"/><a:ext cx=\"0\" cy=\"0\"/><a:chOff x=\"0\" y=\"0\"/><a:chExt cx=\"0\" cy=\"0\"/></a:xfrm></p:grpSpPr>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"1\" name=\"Bg\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"0\" y=\"0\"/><a:ext cx=\"11887200\" cy=\"8409600\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"55051B\"/></a:solidFill></p:spPr>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"2\" name=\"Cover\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"1000000\" y=\"1500000\"/><a:ext cx=\"9887200\" cy=\"5400000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 2000\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill><a:ln w=\"25400\"><a:solidFill><a:srgbClr val=\"EF4444\"/></a:solidFill></a:ln></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"3600\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>SAFETY INCIDENT &amp; INJURY SUMMARY</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"2600\" b=\"1\"><a:solidFill><a:srgbClr val=\"F87171\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + safeComp + "</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1800\"><a:solidFill><a:srgbClr val=\"94A3B8\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Total Incidents Logged: " + incidents.size() + " | Reportable LTIs: " + reportableCount + " | Non-Reportable: " + nonReportableCount + "</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n    </p:spTree>\n  </p:cSld>\n</p:sld>";
            addZipEntry(zos, "ppt/slides/slide1.xml", slide1Xml);
            Map linkedHashMap = new LinkedHashMap();
            for (Object obj2 : incidents) {
                String department = ((IncidentRecord) obj2).getDepartment();
                if (StringsKt.isBlank(department)) {
                    department = "General Plant";
                }
                String str = department;
                Object obj3 = linkedHashMap.get(str);
                if (obj3 == null) {
                    ArrayList arrayList = new ArrayList();
                    linkedHashMap.put(str, arrayList);
                    obj = arrayList;
                } else {
                    obj = obj3;
                }
                ((List) obj).add(obj2);
            }
            String deptBreakdown = CollectionsKt.joinToString$default(linkedHashMap.entrySet(), " | ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.example.utils.PptReportGenerator$$ExternalSyntheticLambda0
                public final Object invoke(Object obj4) {
                    return PptReportGenerator.generateInjurySummaryPpt$lambda$10((Map.Entry) obj4);
                }
            }, 30, (Object) null);
            String safeDept = sanitizeText(deptBreakdown);
            String slide2Xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\"\n       xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"\n       xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr><a:xfrm><a:off x=\"0\" y=\"0\"/><a:ext cx=\"0\" cy=\"0\"/><a:chOff x=\"0\" y=\"0\"/><a:chExt cx=\"0\" cy=\"0\"/></a:xfrm></p:grpSpPr>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"1\" name=\"Bg\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"0\" y=\"0\"/><a:ext cx=\"11887200\" cy=\"8409600\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"55051B\"/></a:solidFill></p:spPr>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"2\" name=\"Title\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"500000\"/><a:ext cx=\"10687200\" cy=\"800000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"690722\"/></a:solidFill></p:spPr>\n        <p:txBody><a:bodyPr anchor=\"ctr\"/><a:p><a:r><a:rPr sz=\"2200\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>DEPARTMENT INJURY BREAKDOWN &amp; SEVERITY</a:t></a:r></p></p:txBody>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"3\" name=\"Content\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"1600000\"/><a:ext cx=\"10687200\" cy=\"5800000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 1000\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill><a:ln w=\"12700\"><a:solidFill><a:srgbClr val=\"BE185D\"/></a:solidFill></a:ln></p:spPr>\n        <p:txBody>\n          <a:bodyPr/>\n          <a:p><a:r><a:rPr sz=\"1800\" b=\"1\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Department Wise Distribution:</a:t></a:r></p>\n          <a:p><a:r><a:rPr sz=\"1400\"><a:solidFill><a:srgbClr val=\"FCE7F3\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + safeDept + "</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n    </p:spTree>\n  </p:cSld>\n</p:sld>";
            addZipEntry(zos, "ppt/slides/slide2.xml", slide2Xml);
            String slide3Xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\"\n       xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"\n       xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr><a:xfrm><a:off x=\"0\" y=\"0\"/><a:ext cx=\"0\" cy=\"0\"/><a:chOff x=\"0\" y=\"0\"/><a:chExt cx=\"0\" cy=\"0\"/></a:xfrm></p:grpSpPr>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"1\" name=\"Bg\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"0\" y=\"0\"/><a:ext cx=\"11887200\" cy=\"8409600\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"55051B\"/></a:solidFill></p:spPr>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"2\" name=\"Closing Card\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"1200000\" y=\"1200000\"/><a:ext cx=\"9487200\" cy=\"5800000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 3000\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill><a:ln w=\"38100\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill></a:ln></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"2800\" b=\"1\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + safeComp + "</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"4400\" b=\"1\"><a:solidFill><a:srgbClr val=\"22C55E\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>TARGET ZERO ACCIDENTS</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"2200\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>THINK SAFE • WORK SAFE • GO HOME SAFELY</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n    </p:spTree>\n  </p:cSld>\n</p:sld>";
            addZipEntry(zos, "ppt/slides/slide3.xml", slide3Xml);
            zos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence generateInjurySummaryPpt$lambda$10(Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getKey() + ": " + ((List) it.getValue()).size();
    }

    public static /* synthetic */ boolean generateUnifiedMasterPptReport$default(PptReportGenerator pptReportGenerator, Context context, Company company, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, List list10, List list11, String str, String str2, File file, int i, Object obj) {
        String str3;
        if ((i & 16384) == 0) {
            str3 = str2;
        } else {
            str3 = "J. VELMURUGAN";
        }
        return pptReportGenerator.generateUnifiedMasterPptReport(context, company, list, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, str, str3, file);
    }

    public final boolean generateUnifiedMasterPptReport(Context context, Company company, List<String> selectedReportKeys, List<Observation> unsafeActObservations, List<Observation> unsafeConditionObservations, List<Observation> safetyStarObservations, List<ResponsiblePerson> rosterList, List<IncidentRecord> incidents, List<SafetyTraining> trainings, List<Observation> currentObs, List<Observation> previousObs, List<IncidentRecord> currentIncidents, List<IncidentRecord> previousIncidents, String dateRangeText, String presenterName, File outputFile) {
        int closedCount;
        int openCount;
        String str;
        int ltiCount;
        int staffTrained;
        String kpiSlideXml;
        ZipOutputStream zos;
        int i;
        int i2;
        ZipOutputStream zos2;
        String str2;
        String str3 = presenterName;
        String str4 = "\n        </p:txBody>\n      </p:sp>\n    </p:spTree>\n  </p:cSld>\n</p:sld>";
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(company, "company");
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
        Intrinsics.checkNotNullParameter(str3, "presenterName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
        } catch (Exception e) {
            e = e;
        }
        try {
            ZipOutputStream zos3 = new ZipOutputStream(new FileOutputStream(outputFile));
            List plus = CollectionsKt.plus(CollectionsKt.plus(unsafeActObservations, unsafeConditionObservations), safetyStarObservations);
            if (plus.isEmpty()) {
                plus = CollectionsKt.listOf(new Observation(0L, company.getId(), "ZERO-NC", "Entire Facility", "Good Practice", "Zero Non-Conformance (SNC) observations recorded. 100% compliance maintained.", "Maintain standard safety practices.", "EHS Team", (String) null, (String) null, "N/A", (String) null, (String) null, (String) null, "Active preventive controls maintained.", (String) null, (String) null, true, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0L, 268286721, (DefaultConstructorMarker) null));
            }
            List allObs = plus;
            int totalSlides = 5 + 1 + allObs.size() + 1;
            addZipEntry(zos3, "[Content_Types].xml", buildContentTypesXml(totalSlides));
            addZipEntry(zos3, "_rels/.rels", buildRelsXml());
            addZipEntry(zos3, "ppt/presentation.xml", buildPresentationXml(totalSlides));
            addZipEntry(zos3, "ppt/_rels/presentation.xml.rels", buildPresentationRelsXml(totalSlides));
            addZipEntry(zos3, "ppt/slideMasters/slideMaster1.xml", buildSlideMasterXml());
            addZipEntry(zos3, "ppt/slideMasters/_rels/slideMaster1.xml.rels", buildSlideMasterRelsXml());
            addZipEntry(zos3, "ppt/slideLayouts/slideLayout1.xml", buildSlideLayoutXml());
            addZipEntry(zos3, "ppt/slideLayouts/_rels/slideLayout1.xml.rels", buildSlideLayoutRelsXml());
            int i3 = 1;
            if (1 <= totalSlides) {
                while (true) {
                    try {
                        addZipEntry(zos3, "ppt/slides/_rels/slide" + i3 + ".xml.rels", buildSlideRelsXml());
                        if (i3 == totalSlides) {
                            break;
                        }
                        i3++;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        return false;
                    }
                }
            }
            str3 = presenterName;
            int totalSlides2 = totalSlides;
            try {
                addZipEntry(zos3, "ppt/slides/slide1.xml", buildCoverSlideXml$default(this, company, dateRangeText, allObs.size(), str3, null, 16, null));
                int currentSlideIdx = 1 + 1;
                String safeComp = sanitizeText(company.getName());
                String safeDate = sanitizeText(dateRangeText);
                String safePresenter = sanitizeText(str3);
                int totalCount = allObs.size();
                List list = allObs;
                if ((list instanceof Collection) && list.isEmpty()) {
                    closedCount = 0;
                } else {
                    closedCount = 0;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (((Observation) it.next()).isResolved() && (closedCount = closedCount + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                List list2 = allObs;
                if ((list2 instanceof Collection) && list2.isEmpty()) {
                    openCount = 0;
                } else {
                    openCount = 0;
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (!((Observation) it2.next()).isResolved() && (openCount = openCount + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                int compRate = totalCount > 0 ? (int) ((closedCount / totalCount) * 100.0f) : 100;
                Iterable iterable = incidents;
                try {
                    if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                        str = "\n        </p:txBody>\n      </p:sp>\n    </p:spTree>\n  </p:cSld>\n</p:sld>";
                        ltiCount = 0;
                    } else {
                        int i4 = 0;
                        Iterator it3 = iterable.iterator();
                        while (it3.hasNext()) {
                            int i5 = i4;
                            Iterable iterable2 = iterable;
                            String str5 = str4;
                            if (StringsKt.contains(((IncidentRecord) it3.next()).getIncidentType(), "LTI", true)) {
                                i4 = i5 + 1;
                                if (i4 < 0) {
                                    CollectionsKt.throwCountOverflow();
                                }
                                str4 = str5;
                                iterable = iterable2;
                            } else {
                                str4 = str5;
                                i4 = i5;
                                iterable = iterable2;
                            }
                        }
                        str = str4;
                        ltiCount = i4;
                    }
                    Iterator<T> it4 = trainings.iterator();
                    staffTrained = 0;
                    while (it4.hasNext()) {
                        staffTrained += ((SafetyTraining) it4.next()).getAttendeesCount();
                    }
                    try {
                        kpiSlideXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\"\n       xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"\n       xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr><a:xfrm><a:off x=\"0\" y=\"0\"/><a:ext cx=\"0\" cy=\"0\"/><a:chOff x=\"0\" y=\"0\"/><a:chExt cx=\"0\" cy=\"0\"/></a:xfrm></p:grpSpPr>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"1\" name=\"Bg\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"0\" y=\"0\"/><a:ext cx=\"11887200\" cy=\"8409600\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"55051B\"/></a:solidFill></p:spPr>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"2\" name=\"Title\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"400000\"/><a:ext cx=\"10687200\" cy=\"800000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"lft\"/><a:r><a:rPr sz=\"2600\" b=\"1\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>EXECUTIVE SAFETY SCORECARD &amp; KPI DASHBOARD</a:t></a:r></p>\n          <a:p><a:pPr algn=\"lft\"/><a:r><a:rPr sz=\"1400\"><a:solidFill><a:srgbClr val=\"94A3B8\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + safeComp + " | Period: " + safeDate + " | Auditor: " + safePresenter + "</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"3\" name=\"KPI 1\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"1500000\"/><a:ext cx=\"3300000\" cy=\"1800000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 2000\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill><a:ln w=\"25400\"><a:solidFill><a:srgbClr val=\"38BDF8\"/></a:solidFill></a:ln></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1500\" b=\"1\"><a:solidFill><a:srgbClr val=\"38BDF8\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>TOTAL OBSERVATIONS</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"3800\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + totalCount + "</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"4\" name=\"KPI 2\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"4200000\" y=\"1500000\"/><a:ext cx=\"3300000\" cy=\"1800000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 2000\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill><a:ln w=\"25400\"><a:solidFill><a:srgbClr val=\"22C55E\"/></a:solidFill></a:ln></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1500\" b=\"1\"><a:solidFill><a:srgbClr val=\"22C55E\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>COMPLIANCE RATE</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"3800\" b=\"1\"><a:solidFill><a:srgbClr val=\"22C55E\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + compRate + "%</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"5\" name=\"KPI 3\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"7800000\" y=\"1500000\"/><a:ext cx=\"3487200\" cy=\"1800000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 2000\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill><a:ln w=\"25400\"><a:solidFill><a:srgbClr val=\"EF4444\"/></a:solidFill></a:ln></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"1500\" b=\"1\"><a:solidFill><a:srgbClr val=\"EF4444\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>OPEN ACTIONS</a:t></a:r></p>\n          <a:p><a:pPr algn=\"ctr\"/><a:r><a:rPr sz=\"3800\" b=\"1\"><a:solidFill><a:srgbClr val=\"FFFFFF\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>" + openCount + "</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"6\" name=\"Details Box\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"3600000\"/><a:ext cx=\"10687200\" cy=\"4200000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 1500\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"t\"/>\n          <a:p><a:r><a:rPr sz=\"2000\" b=\"1\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>• INCIDENTS LOG: " + incidents.size() + " incidents recorded (" + ltiCount + " LTI)</a:t></a:r></p>\n          <a:p><a:r><a:rPr sz=\"2000\" b=\"1\"><a:solidFill><a:srgbClr val=\"38BDF8\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>• SAFETY TRAININGS: " + trainings.size() + " sessions conducted (" + staffTrained + " personnel trained)</a:t></a:r></p>\n          <a:p><a:r><a:rPr sz=\"2000\" b=\"1\"><a:solidFill><a:srgbClr val=\"22C55E\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>• SAFETY STARS: " + safetyStarObservations.size() + " positive recognitions awarded</a:t></a:r></p>\n          <a:p><a:r><a:rPr sz=\"2000\" b=\"1\"><a:solidFill><a:srgbClr val=\"F59E0B\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>• UNSAFE ACTS: " + unsafeActObservations.size() + " behavioral observations</a:t></a:r></p>\n          <a:p><a:r><a:rPr sz=\"2000\" b=\"1\"><a:solidFill><a:srgbClr val=\"CBD5E1\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>• UNSAFE CONDITIONS: " + unsafeConditionObservations.size() + " physical condition findings across 8 parameters</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n    </p:spTree>\n  </p:cSld>\n</p:sld>";
                        zos = zos3;
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    e = e4;
                }
                try {
                    addZipEntry(zos, "ppt/slides/slide" + currentSlideIdx + ".xml", kpiSlideXml);
                    int currentSlideIdx2 = currentSlideIdx + 1;
                    int curObsSize = currentObs.size();
                    int prevObsSize = previousObs.size();
                    int curIncSize = currentIncidents.size();
                    int prevIncSize = previousIncidents.size();
                    List<Observation> list3 = currentObs;
                    if ((list3 instanceof Collection) && list3.isEmpty()) {
                        i = 0;
                    } else {
                        i = 0;
                        Iterator it5 = list3.iterator();
                        while (it5.hasNext()) {
                            if (((Observation) it5.next()).isResolved() && (i = i + 1) < 0) {
                                CollectionsKt.throwCountOverflow();
                            }
                        }
                    }
                    int curRes = i;
                    List<Observation> list4 = previousObs;
                    if ((list4 instanceof Collection) && list4.isEmpty()) {
                        i2 = 0;
                    } else {
                        i2 = 0;
                        Iterator it6 = list4.iterator();
                        while (it6.hasNext()) {
                            if (((Observation) it6.next()).isResolved() && (i2 = i2 + 1) < 0) {
                                CollectionsKt.throwCountOverflow();
                            }
                        }
                    }
                    int prevRes = i2;
                    int prevObsSize2 = prevObsSize;
                    int prevIncSize2 = prevIncSize;
                    String momSlideXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr/>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"1\" name=\"Bg\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"0\" y=\"0\"/><a:ext cx=\"11887200\" cy=\"8409600\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"55051B\"/></a:solidFill></p:spPr>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"2\" name=\"Title\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"400000\"/><a:ext cx=\"10687200\" cy=\"800000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"lft\"/><a:r><a:rPr sz=\"2400\" b=\"1\"><a:solidFill><a:srgbClr val=\"38BDF8\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>MONTH-OVER-MONTH (MoM) SAFETY PERFORMANCE MATRIX</a:t></a:r></p>\n          <a:p><a:pPr algn=\"lft\"/><a:r><a:rPr sz=\"1300\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Unit: " + safeComp + " | Period: " + safeDate + "</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"3\" name=\"TableBox\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"1500000\"/><a:ext cx=\"10687200\" cy=\"6300000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 1500\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"t\"/>\n          <a:p><a:r><a:rPr sz=\"2200\" b=\"1\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>1. Total Audit Observations: Current = " + curObsSize + " | Previous = " + prevObsSize2 + " (Variance: " + (curObsSize - prevObsSize) + ")</a:t></a:r></p>\n          <a:p><a:r><a:rPr sz=\"2200\" b=\"1\"><a:solidFill><a:srgbClr val=\"22C55E\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>2. Closed Corrective Actions: Current = " + curRes + " | Previous = " + prevRes + "</a:t></a:r></p>\n          <a:p><a:r><a:rPr sz=\"2200\" b=\"1\"><a:solidFill><a:srgbClr val=\"EF4444\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>3. Total Incidents / Near Misses: Current = " + curIncSize + " | Previous = " + prevIncSize2 + "</a:t></a:r></p>\n          <a:p><a:r><a:rPr sz=\"2000\"><a:solidFill><a:srgbClr val=\"CBD5E1\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Conclusion: Systematic hazard resolution and daily proactive walkthroughs show positive safety engagement.</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n    </p:spTree>\n  </p:cSld>\n</p:sld>";
                    addZipEntry(zos, "ppt/slides/slide" + currentSlideIdx2 + ".xml", momSlideXml);
                    int currentSlideIdx3 = currentSlideIdx2 + 1;
                    StringBuilder incContentSb = new StringBuilder();
                    String momSlideXml2 = ": ";
                    if (incidents.isEmpty()) {
                        incContentSb.append("<a:p><a:r><a:rPr sz=\"2200\" b=\"1\"><a:solidFill><a:srgbClr val=\"22C55E\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Zero work-related accidents or lost time incidents recorded during this audit cycle.</a:t></a:r></p>");
                        zos2 = zos;
                    } else {
                        Iterable<IncidentRecord> take = CollectionsKt.take(incidents, 5);
                        int i6 = 0;
                        for (IncidentRecord incidentRecord : take) {
                            Iterable iterable3 = take;
                            int i7 = i6;
                            incContentSb.append("<a:p><a:r><a:rPr sz=\"1800\" b=\"1\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>• [" + INSTANCE.sanitizeText(incidentRecord.getIncidentNumber()) + "] " + INSTANCE.sanitizeText(incidentRecord.getIncidentDate()) + ": " + INSTANCE.sanitizeText(incidentRecord.getIncidentType()) + " at " + INSTANCE.sanitizeText(incidentRecord.getLocation()) + " - Status: " + INSTANCE.sanitizeText(incidentRecord.getStatus()) + "</a:t></a:r></p>");
                            take = iterable3;
                            i6 = i7;
                            prevIncSize2 = prevIncSize2;
                            prevObsSize2 = prevObsSize2;
                            staffTrained = staffTrained;
                            zos = zos;
                        }
                        zos2 = zos;
                        Unit unit = Unit.INSTANCE;
                    }
                    String str6 = str;
                    String incSlideXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr/>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"1\" name=\"Bg\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"0\" y=\"0\"/><a:ext cx=\"11887200\" cy=\"8409600\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"55051B\"/></a:solidFill></p:spPr>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"2\" name=\"Title\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"400000\"/><a:ext cx=\"10687200\" cy=\"800000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"lft\"/><a:r><a:rPr sz=\"2400\" b=\"1\"><a:solidFill><a:srgbClr val=\"EF4444\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>INCIDENT &amp; NEAR MISS INVESTIGATION REGISTER</a:t></a:r></p>\n          <a:p><a:pPr algn=\"lft\"/><a:r><a:rPr sz=\"1300\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Unit: " + safeComp + " | Period: " + safeDate + "</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"3\" name=\"LogBox\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"1500000\"/><a:ext cx=\"10687200\" cy=\"6300000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 1500\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"t\"/>\n          " + ((Object) incContentSb) + str6;
                    ZipOutputStream zos4 = zos2;
                    addZipEntry(zos4, "ppt/slides/slide" + currentSlideIdx3 + ".xml", incSlideXml);
                    int currentSlideIdx4 = currentSlideIdx3 + 1;
                    StringBuilder trContentSb = new StringBuilder();
                    if (trainings.isEmpty()) {
                        trContentSb.append("<a:p><a:r><a:rPr sz=\"2200\" b=\"1\"><a:solidFill><a:srgbClr val=\"94A3B8\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>No training sessions recorded for this period.</a:t></a:r></p>");
                        str2 = ": ";
                    } else {
                        Iterable<SafetyTraining> take2 = CollectionsKt.take(trainings, 5);
                        int i8 = 0;
                        for (SafetyTraining safetyTraining : take2) {
                            Iterable iterable4 = take2;
                            trContentSb.append("<a:p><a:r><a:rPr sz=\"1800\" b=\"1\"><a:solidFill><a:srgbClr val=\"38BDF8\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>• " + INSTANCE.sanitizeText(safetyTraining.getTrainingTopic()) + " (" + INSTANCE.sanitizeText(safetyTraining.getTrainingDate()) + ") - " + safetyTraining.getAttendeesCount() + " attendees - Trainer: " + INSTANCE.sanitizeText(safetyTraining.getTrainerName()) + "</a:t></a:r></p>");
                            take2 = iterable4;
                            incContentSb = incContentSb;
                            incSlideXml = incSlideXml;
                            i8 = i8;
                            momSlideXml2 = momSlideXml2;
                        }
                        str2 = momSlideXml2;
                        Unit unit2 = Unit.INSTANCE;
                    }
                    String trSlideXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr/>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"1\" name=\"Bg\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"0\" y=\"0\"/><a:ext cx=\"11887200\" cy=\"8409600\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"55051B\"/></a:solidFill></p:spPr>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"2\" name=\"Title\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"400000\"/><a:ext cx=\"10687200\" cy=\"800000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"lft\"/><a:r><a:rPr sz=\"2400\" b=\"1\"><a:solidFill><a:srgbClr val=\"38BDF8\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>SAFETY TRAININGS &amp; COMPETENCY REGISTER</a:t></a:r></p>\n          <a:p><a:pPr algn=\"lft\"/><a:r><a:rPr sz=\"1300\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Unit: " + safeComp + " | Period: " + safeDate + "</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"3\" name=\"TrBox\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"1500000\"/><a:ext cx=\"10687200\" cy=\"6300000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 1500\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"t\"/>\n          " + ((Object) trContentSb) + str6;
                    addZipEntry(zos4, "ppt/slides/slide" + currentSlideIdx4 + ".xml", trSlideXml);
                    int currentSlideIdx5 = currentSlideIdx4 + 1;
                    StringBuilder starContentSb = new StringBuilder();
                    if (safetyStarObservations.isEmpty()) {
                        starContentSb.append("<a:p><a:r><a:rPr sz=\"2200\" b=\"1\"><a:solidFill><a:srgbClr val=\"94A3B8\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>No Safety Star observations recorded for this period.</a:t></a:r></p>");
                    } else {
                        Iterable take3 = CollectionsKt.take(safetyStarObservations, 5);
                        int i9 = 0;
                        Iterator it7 = take3.iterator();
                        while (it7.hasNext()) {
                            Observation observation = (Observation) it7.next();
                            Iterator it8 = it7;
                            String str7 = str2;
                            starContentSb.append("<a:p><a:r><a:rPr sz=\"1800\" b=\"1\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>• [SAFETY CHAMPION] " + INSTANCE.sanitizeText(observation.getResponsiblePerson()) + str7 + INSTANCE.sanitizeText(observation.getIssueDetails()) + "</a:t></a:r></p>");
                            str2 = str7;
                            take3 = take3;
                            i9 = i9;
                            it7 = it8;
                            trSlideXml = trSlideXml;
                        }
                        Unit unit3 = Unit.INSTANCE;
                    }
                    String starSlideXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<p:sld xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">\n  <p:cSld>\n    <p:spTree>\n      <p:nvGrpSpPr><p:cNvPr id=\"1\" name=\"\"/><p:cNvGrpSpPr/><p:nvPr/></p:nvGrpSpPr>\n      <p:grpSpPr/>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"1\" name=\"Bg\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"0\" y=\"0\"/><a:ext cx=\"11887200\" cy=\"8409600\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"55051B\"/></a:solidFill></p:spPr>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"2\" name=\"Title\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"400000\"/><a:ext cx=\"10687200\" cy=\"800000\"/><a:prstGeom prst=\"rect\"><a:avLst/></a:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"ctr\"/>\n          <a:p><a:pPr algn=\"lft\"/><a:r><a:rPr sz=\"2400\" b=\"1\"><a:solidFill><a:srgbClr val=\"FACC15\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>SAFETY STARS &amp; EMPLOYEE RECOGNITION</a:t></a:r></p>\n          <a:p><a:pPr algn=\"lft\"/><a:r><a:rPr sz=\"1300\"><a:solidFill><a:srgbClr val=\"94A3B8\"/></a:solidFill><a:latin typeface=\"Cambria\"/><a:cs typeface=\"Cambria\"/></a:rPr><a:t>Unit: " + safeComp + " | Period: " + safeDate + "</a:t></a:r></p>\n        </p:txBody>\n      </p:sp>\n      <p:sp>\n        <p:nvSpPr><p:cNvPr id=\"3\" name=\"StarBox\"/><p:cNvSpPr/><p:nvPr/></p:nvSpPr>\n        <p:spPr><a:off x=\"600000\" y=\"1500000\"/><a:ext cx=\"10687200\" cy=\"6300000\"/><a:prstGeom prst=\"roundRect\"><a:avLst><a:gd name=\"adj\" fmla=\"val 1500\"/></a:avLst></p:prstGeom><a:solidFill><a:srgbClr val=\"3D0515\"/></a:solidFill></p:spPr>\n        <p:txBody>\n          <a:bodyPr anchor=\"t\"/>\n          " + ((Object) starContentSb) + str6;
                    addZipEntry(zos4, "ppt/slides/slide" + currentSlideIdx5 + ".xml", starSlideXml);
                    int currentSlideIdx6 = currentSlideIdx5 + 1;
                    int i10 = 0;
                    for (Object obj : allObs) {
                        int i11 = i10 + 1;
                        if (i10 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        int totalSlides3 = totalSlides2;
                        String safeDate2 = safeDate;
                        try {
                            try {
                                INSTANCE.addZipEntry(zos4, "ppt/slides/slide" + currentSlideIdx6 + ".xml", INSTANCE.buildFindingSlideXml(company, (Observation) obj, i10, currentSlideIdx6, totalSlides3));
                                currentSlideIdx6++;
                                safeDate = safeDate2;
                                i10 = i11;
                                totalSlides2 = totalSlides3;
                            } catch (Exception e5) {
                                e = e5;
                                e.printStackTrace();
                                return false;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            e.printStackTrace();
                            return false;
                        }
                    }
                    try {
                        addZipEntry(zos4, "ppt/slides/slide" + currentSlideIdx6 + ".xml", buildClosingSlideXml(company, currentSlideIdx6, totalSlides2, presenterName));
                        zos4.close();
                        return true;
                    } catch (Exception e7) {
                        e = e7;
                        e.printStackTrace();
                        return false;
                    }
                } catch (Exception e8) {
                    e = e8;
                    e.printStackTrace();
                    return false;
                }
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Exception e10) {
            e = e10;
            e.printStackTrace();
            return false;
        }
    }
}
