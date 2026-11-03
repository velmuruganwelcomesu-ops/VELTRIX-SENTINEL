package com.example.utils;

import com.example.data.IncidentRecord;
import com.example.data.Observation;
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
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: DocxReportGenerator.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0002J8\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0005H\u0002J(\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J6\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%J6\u0010&\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%JD\u0010'\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0 2\u0006\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%J`\u0010*\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00052\f\u0010+\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0 2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0 2\u0006\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%J6\u00100\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00052\f\u00101\u001a\b\u0012\u0004\u0012\u0002020 2\u0006\u00103\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%J4\u00104\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00052\f\u00105\u001a\b\u0012\u0004\u0012\u00020.0 2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%JÂ\u0001\u00106\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00052\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00050 2\f\u00108\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u00109\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0 2\f\u00105\u001a\b\u0012\u0004\u0012\u00020.0 2\f\u00101\u001a\b\u0012\u0004\u0012\u0002020 2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0 2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0 2\u0006\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%¨\u0006;"}, d2 = {"Lcom/example/utils/DocxReportGenerator;", "", "<init>", "()V", "escapeXml", "", "text", "addZipEntry", "", "zos", "Ljava/util/zip/ZipOutputStream;", "entryName", "content", "buildContentTypesXml", "buildPackageRelsXml", "buildDocumentRelsXml", "buildStylesXml", "tableHeaderCell", "widthDxa", "", "tableDataCell", "isAltRow", "", "bold", "colorHex", "buildHeaderXml", "title", "subtitle", "companyName", "period", "generateUnsafeActsDocxReport", "observations", "", "Lcom/example/data/Observation;", "dateRangeText", "presenterName", "outputFile", "Ljava/io/File;", "generateUnsafeConditionsDocxReport", "generateSafetyStarDocxReport", "rosterList", "Lcom/example/data/ResponsiblePerson;", "generateExecutiveComparisonDocxReport", "currentObs", "previousObs", "currentIncidents", "Lcom/example/data/IncidentRecord;", "previousIncidents", "generateSafetyTrainingsDocxReport", "trainings", "Lcom/example/data/SafetyTraining;", "monthYearText", "generateIncidentsDocxReport", "incidents", "generateUnifiedMasterDocxReport", "selectedReportKeys", "unsafeActObservations", "unsafeConditionObservations", "safetyStarObservations", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class DocxReportGenerator {
    public static final int $stable = 0;
    public static final DocxReportGenerator INSTANCE = new DocxReportGenerator();

    private DocxReportGenerator() {
    }

    private final String escapeXml(String text) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(text, "&", "&amp;", false, 4, (Object) null), "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null), "\"", "&quot;", false, 4, (Object) null), "'", "&apos;", false, 4, (Object) null);
    }

    private final void addZipEntry(ZipOutputStream zos, String entryName, String content) {
        ZipEntry entry = new ZipEntry(entryName);
        zos.putNextEntry(entry);
        byte[] bytes = content.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        zos.write(bytes, 0, bytes.length);
        zos.closeEntry();
    }

    private final String buildContentTypesXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Types xmlns=\"http://schemas.openxmlformats.org/package/2006/content-types\">\n  <Default Extension=\"rels\" ContentType=\"application/vnd.openxmlformats-package.relationships+xml\"/>\n  <Default Extension=\"xml\" ContentType=\"application/xml\"/>\n  <Override PartName=\"/word/document.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml\"/>\n  <Override PartName=\"/word/styles.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.wordprocessingml.styles+xml\"/>\n</Types>";
    }

    private final String buildPackageRelsXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">\n  <Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument\" Target=\"word/document.xml\"/>\n</Relationships>";
    }

    private final String buildDocumentRelsXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">\n  <Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles\" Target=\"styles.xml\"/>\n</Relationships>";
    }

    private final String buildStylesXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<w:styles xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\">\n  <w:docDefaults>\n    <w:rPrDefault>\n      <w:rPr>\n        <w:rFonts w:ascii=\"Segoe UI\" w:hAnsi=\"Segoe UI\" w:cs=\"Segoe UI\"/>\n        <w:sz w:val=\"22\"/>\n        <w:color w:val=\"1E293B\"/>\n      </w:rPr>\n    </w:rPrDefault>\n  </w:docDefaults>\n</w:styles>";
    }

    static /* synthetic */ String tableHeaderCell$default(DocxReportGenerator docxReportGenerator, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2000;
        }
        return docxReportGenerator.tableHeaderCell(str, i);
    }

    private final String tableHeaderCell(String text, int widthDxa) {
        return "<w:tc>\n  <w:tcPr>\n    <w:tcW w:w=\"" + widthDxa + "\" w:type=\"dxa\"/>\n    <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"002060\"/>\n    <w:tcMar><w:top w:w=\"120\" w:type=\"dxa\"/><w:bottom w:w=\"120\" w:type=\"dxa\"/><w:left w:w=\"140\" w:type=\"dxa\"/><w:right w:w=\"140\" w:type=\"dxa\"/></w:tcMar>\n  </w:tcPr>\n  <w:p>\n    <w:pPr><w:jc w:val=\"left\"/><w:spacing w:before=\"0\" w:after=\"0\"/></w:pPr>\n    <w:r><w:rPr><w:b/><w:color w:val=\"FFFFFF\"/><w:sz w:val=\"18\"/></w:rPr><w:t>" + escapeXml(text) + "</w:t></w:r>\n  </w:p>\n</w:tc>";
    }

    static /* synthetic */ String tableDataCell$default(DocxReportGenerator docxReportGenerator, String str, int i, boolean z, boolean z2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2000;
        }
        int i3 = i;
        boolean z3 = (i2 & 4) != 0 ? false : z;
        boolean z4 = (i2 & 8) != 0 ? false : z2;
        if ((i2 & 16) != 0) {
            str2 = "1E293B";
        }
        return docxReportGenerator.tableDataCell(str, i3, z3, z4, str2);
    }

    private final String tableDataCell(String text, int widthDxa, boolean isAltRow, boolean bold, String colorHex) {
        String bgFill = isAltRow ? "F8FAFC" : "FFFFFF";
        return "<w:tc>\n  <w:tcPr>\n    <w:tcW w:w=\"" + widthDxa + "\" w:type=\"dxa\"/>\n    <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"" + bgFill + "\"/>\n    <w:tcMar><w:top w:w=\"100\" w:type=\"dxa\"/><w:bottom w:w=\"100\" w:type=\"dxa\"/><w:left w:w=\"140\" w:type=\"dxa\"/><w:right w:w=\"140\" w:type=\"dxa\"/></w:tcMar>\n  </w:tcPr>\n  <w:p>\n    <w:pPr><w:spacing w:before=\"0\" w:after=\"0\"/></w:pPr>\n    <w:r><w:rPr>" + (bold ? "<w:b/>" : "") + "<w:color w:val=\"" + colorHex + "\"/><w:sz w:val=\"18\"/></w:rPr><w:t>" + escapeXml(text) + "</w:t></w:r>\n  </w:p>\n</w:tc>";
    }

    private final String buildHeaderXml(String title, String subtitle, String companyName, String period) {
        String todayStr = new SimpleDateFormat("dd-MMM-yyyy HH:mm", Locale.getDefault()).format(new Date());
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = companyName.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String escapeXml = escapeXml(upperCase);
        String escapeXml2 = escapeXml(title);
        String escapeXml3 = escapeXml(subtitle);
        String tableDataCell = tableDataCell("Factory Unit / Company:", 2600, false, true, "002060");
        String tableDataCell2 = tableDataCell(companyName, 6600, false, false, "0F172A");
        String tableDataCell3 = tableDataCell("Audit Period:", 2600, true, true, "002060");
        String tableDataCell4 = tableDataCell(period, 6600, true, false, "0F172A");
        String tableDataCell5 = tableDataCell("Generated Timestamp:", 2600, false, true, "002060");
        Intrinsics.checkNotNull(todayStr);
        return "\n<w:p>\n  <w:pPr><w:jc w:val=\"center\"/><w:spacing w:before=\"0\" w:after=\"60\"/></w:pPr>\n  <w:r><w:rPr><w:b/><w:color w:val=\"002060\"/><w:sz w:val=\"32\"/></w:rPr><w:t>" + escapeXml + "</w:t></w:r>\n</w:p>\n<w:p>\n  <w:pPr><w:jc w:val=\"center\"/><w:spacing w:before=\"0\" w:after=\"120\"/></w:pPr>\n  <w:r><w:rPr><w:b/><w:color w:val=\"D97706\"/><w:sz w:val=\"22\"/></w:rPr><w:t>ENVIRONMENTAL HEALTH &amp; SAFETY (EHS) AUDIT &amp; COMPLIANCE DIVISION</w:t></w:r>\n</w:p>\n<w:p>\n  <w:pPr><w:jc w:val=\"center\"/><w:spacing w:before=\"0\" w:after=\"160\"/></w:pPr>\n  <w:r><w:rPr><w:b/><w:color w:val=\"0F172A\"/><w:sz w:val=\"28\"/></w:rPr><w:t>" + escapeXml2 + "</w:t></w:r>\n</w:p>\n<w:p>\n  <w:pPr><w:jc w:val=\"center\"/><w:spacing w:before=\"0\" w:after=\"200\"/></w:pPr>\n  <w:r><w:rPr><w:i/><w:color w:val=\"475569\"/><w:sz w:val=\"20\"/></w:rPr><w:t>" + escapeXml3 + "</w:t></w:r>\n</w:p>\n\n<!-- Meta Box -->\n<w:tbl>\n  <w:tblPr>\n    <w:tblW w:w=\"9200\" w:type=\"dxa\"/>\n    <w:tblBorders>\n      <w:top w:val=\"single\" w:sz=\"6\" w:space=\"0\" w:color=\"CBD5E1\"/>\n      <w:left w:val=\"single\" w:sz=\"6\" w:space=\"0\" w:color=\"CBD5E1\"/>\n      <w:bottom w:val=\"single\" w:sz=\"6\" w:space=\"0\" w:color=\"CBD5E1\"/>\n      <w:right w:val=\"single\" w:sz=\"6\" w:space=\"0\" w:color=\"CBD5E1\"/>\n      <w:insideH w:val=\"single\" w:sz=\"4\" w:space=\"0\" w:color=\"E2E8F0\"/>\n      <w:insideV w:val=\"single\" w:sz=\"4\" w:space=\"0\" w:color=\"E2E8F0\"/>\n    </w:tblBorders>\n  </w:tblPr>\n  <w:tr>\n    " + tableDataCell + "\n    " + tableDataCell2 + "\n  </w:tr>\n  <w:tr>\n    " + tableDataCell3 + "\n    " + tableDataCell4 + "\n  </w:tr>\n  <w:tr>\n    " + tableDataCell5 + "\n    " + tableDataCell(todayStr, 6600, false, false, "0F172A") + "\n  </w:tr>\n</w:tbl>\n<w:p><w:pPr><w:spacing w:before=\"160\" w:after=\"160\"/></w:pPr></w:p>\n";
    }

    public static /* synthetic */ boolean generateUnsafeActsDocxReport$default(DocxReportGenerator docxReportGenerator, String str, List list, String str2, String str3, File file, int i, Object obj) {
        String str4;
        if ((i & 8) == 0) {
            str4 = str3;
        } else {
            str4 = "J. VELMURUGAN";
        }
        return docxReportGenerator.generateUnsafeActsDocxReport(str, list, str2, str4, file);
    }

    public final boolean generateUnsafeActsDocxReport(String companyName, List<Observation> observations, String dateRangeText, String presenterName, File outputFile) {
        ZipOutputStream zos;
        List acts;
        int i;
        int openActs;
        int resolvedActs;
        StringBuilder docXml;
        String str;
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        Intrinsics.checkNotNullParameter(observations, "observations");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(presenterName, "presenterName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
            zos = new ZipOutputStream(new FileOutputStream(outputFile));
            addZipEntry(zos, "[Content_Types].xml", buildContentTypesXml());
            addZipEntry(zos, "_rels/.rels", buildPackageRelsXml());
            addZipEntry(zos, "word/_rels/document.xml.rels", buildDocumentRelsXml());
            addZipEntry(zos, "word/styles.xml", buildStylesXml());
            List<Observation> list = observations;
            int i2 = 0;
            Collection arrayList = new ArrayList();
            for (Object obj : list) {
                Iterable iterable = list;
                int i3 = i2;
                if (StringsKt.equals(((Observation) obj).getFindingType(), "Unsafe Act", true)) {
                    arrayList.add(obj);
                }
                list = iterable;
                i2 = i3;
            }
            acts = (List) arrayList;
            List list2 = acts;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                i = 0;
            } else {
                i = 0;
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    if (!((Observation) it.next()).isResolved() && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            openActs = i;
            List list3 = acts;
            if ((list3 instanceof Collection) && list3.isEmpty()) {
                resolvedActs = 0;
            } else {
                resolvedActs = 0;
                Iterator it2 = list3.iterator();
                while (it2.hasNext()) {
                    if (((Observation) it2.next()).isResolved() && (resolvedActs = resolvedActs + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            docXml = new StringBuilder();
            docXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<w:document xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\">\n  <w:body>\n");
            docXml.append(buildHeaderXml("UNSAFE ACTS & EMPLOYEE DETAILS AUDIT DOSSIER", "Employee Behavioral Safety, Coaching Logs & Non-Conformance Tracking", companyName, dateRangeText));
        } catch (Exception e) {
            e = e;
        }
        try {
            docXml.append("\n<w:p><w:pPr><w:spacing w:before=\"120\" w:after=\"80\"/></w:pPr><w:r><w:rPr><w:b/><w:color w:val=\"002060\"/><w:sz w:val=\"24\"/></w:rPr><w:t>1. BEHAVIORAL SAFETY METRICS SUMMARY</w:t></w:r></w:p>\n<w:tbl>\n  <w:tblPr>\n    <w:tblW w:w=\"9200\" w:type=\"dxa\"/>\n    <w:tblBorders>\n      <w:top w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:left w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:bottom w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:right w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:insideH w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/><w:insideV w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/>\n    </w:tblBorders>\n  </w:tblPr>\n  <w:tr>\n    " + tableHeaderCell("TOTAL UNSAFE ACTS", 3066) + "\n    " + tableHeaderCell("OPEN VIOLATIONS", 3066) + "\n    " + tableHeaderCell("COACHED & RESOLVED", 3066) + "\n  </w:tr>\n  <w:tr>\n    " + tableDataCell(acts.size() + " Recorded", 3066, false, true, "002060") + "\n    " + tableDataCell(openActs + " Open", 3066, false, true, "DC2626") + "\n    " + tableDataCell(resolvedActs + " Resolved", 3066, false, true, "16A34A") + "\n  </w:tr>\n</w:tbl>\n<w:p><w:pPr><w:spacing w:before=\"200\" w:after=\"100\"/></w:pPr><w:r><w:rPr><w:b/><w:color w:val=\"002060\"/><w:sz w:val=\"24\"/></w:rPr><w:t>2. ITEMIZED UNSAFE ACTS &amp; EMPLOYEE INTERVENTION LOG</w:t></w:r></w:p>\n");
            docXml.append("\n<w:tbl>\n  <w:tblPr>\n    <w:tblW w:w=\"9200\" w:type=\"dxa\"/>\n    <w:tblBorders>\n      <w:top w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:left w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:bottom w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:right w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:insideH w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/><w:insideV w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/>\n    </w:tblBorders>\n  </w:tblPr>\n  <w:tr>\n    " + tableHeaderCell("S.NO", 600) + "\n    " + tableHeaderCell("REF #", 1200) + "\n    " + tableHeaderCell("EMPLOYEE & DEPT", 2200) + "\n    " + tableHeaderCell("UNSAFE ACT DETAILS", 2600) + "\n    " + tableHeaderCell("MANDATED COACHING / CAPA", 1800) + "\n    " + tableHeaderCell("STATUS", 800) + "\n  </w:tr>\n");
            if (acts.isEmpty()) {
                docXml.append("<w:tr>\n  <w:tc>\n    <w:tcPr><w:tcW w:w=\"9200\" w:type=\"dxa\"/><w:gridSpan w:val=\"6\"/><w:tcMar><w:top w:w=\"180\" w:type=\"dxa\"/><w:bottom w:w=\"180\" w:type=\"dxa\"/></w:tcMar></w:tcPr>\n    <w:p><w:pPr><w:jc w:val=\"center\"/></w:pPr><w:r><w:rPr><w:i/><w:color w:val=\"16A34A\"/><w:sz w:val=\"20\"/></w:rPr><w:t>Zero Unsafe Acts recorded for this period. Excellent Behavioral Safety Compliance!</w:t></w:r></w:p>\n  </w:tc>\n</w:tr>");
            } else {
                List list4 = acts;
                int i4 = 0;
                int i5 = 0;
                Iterator it3 = list4.iterator();
                while (it3.hasNext()) {
                    Object next = it3.next();
                    int i6 = i5 + 1;
                    if (i5 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Observation observation = (Observation) next;
                    boolean z = i5 % 2 == 1;
                    if (StringsKt.isBlank(observation.getEmployeeName())) {
                        String responsiblePerson = observation.getResponsiblePerson();
                        if (StringsKt.isBlank(responsiblePerson)) {
                            responsiblePerson = "Unassigned";
                        }
                        str = responsiblePerson;
                    } else {
                        str = observation.getEmployeeName();
                    }
                    String employeeDepartment = !StringsKt.isBlank(observation.getEmployeeDepartment()) ? observation.getEmployeeDepartment() : observation.getLocation();
                    String employeeId = observation.getEmployeeId();
                    Iterable iterable2 = list4;
                    int i7 = i4;
                    String str2 = str + " (" + ((Object) (StringsKt.isBlank(employeeId) ? "ID: N/A" : employeeId)) + ")\nDept: " + employeeDepartment;
                    String str3 = observation.isResolved() ? "16A34A" : "DC2626";
                    String tableDataCell$default = tableDataCell$default(INSTANCE, String.valueOf(i5 + 1), 600, z, false, null, 24, null);
                    String tableDataCell = INSTANCE.tableDataCell(observation.getSncNumber(), 1200, z, true, "002060");
                    String tableDataCell$default2 = tableDataCell$default(INSTANCE, str2, 2200, z, false, null, 24, null);
                    String tableDataCell$default3 = tableDataCell$default(INSTANCE, observation.getIssueDetails(), 2600, z, false, null, 24, null);
                    DocxReportGenerator docxReportGenerator = INSTANCE;
                    String suggestion = observation.getSuggestion();
                    if (StringsKt.isBlank(suggestion)) {
                        suggestion = observation.getActionTaken();
                    }
                    Iterator it4 = it3;
                    docXml.append("<w:tr>\n  " + tableDataCell$default + "\n  " + tableDataCell + "\n  " + tableDataCell$default2 + "\n  " + tableDataCell$default3 + "\n  " + tableDataCell$default(docxReportGenerator, suggestion, 1800, z, false, null, 24, null) + "\n  " + INSTANCE.tableDataCell(observation.isResolved() ? "RESOLVED" : "OPEN", 800, z, true, str3) + "\n</w:tr>");
                    i5 = i6;
                    list4 = iterable2;
                    i4 = i7;
                    it3 = it4;
                }
            }
            docXml.append("</w:tbl>\n<w:p><w:pPr><w:spacing w:before=\"300\" w:after=\"100\"/></w:pPr><w:r><w:rPr><w:i/><w:color w:val=\"64748B\"/><w:sz w:val=\"18\"/></w:rPr><w:t>Compiled by Lead EHS Auditor: " + escapeXml(presenterName) + " | Verified &amp; Signed</w:t></w:r></w:p>\n<w:sectPr><w:pgSz w:w=\"12240\" w:h=\"15840\"/><w:pgMar w:top=\"1000\" w:right=\"1000\" w:bottom=\"1000\" w:left=\"1000\"/></w:sectPr>\n</w:body></w:document>");
            String sb = docXml.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            addZipEntry(zos, "word/document.xml", sb);
            zos.close();
            return true;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return false;
        }
    }

    public static /* synthetic */ boolean generateUnsafeConditionsDocxReport$default(DocxReportGenerator docxReportGenerator, String str, List list, String str2, String str3, File file, int i, Object obj) {
        String str4;
        if ((i & 8) == 0) {
            str4 = str3;
        } else {
            str4 = "J. VELMURUGAN";
        }
        return docxReportGenerator.generateUnsafeConditionsDocxReport(str, list, str2, str4, file);
    }

    public final boolean generateUnsafeConditionsDocxReport(String companyName, List<Observation> observations, String dateRangeText, String presenterName, File outputFile) {
        boolean z;
        ZipOutputStream zos;
        List<Observation> list;
        int i;
        Collection arrayList;
        Iterator it;
        int i2;
        int resolvedConds;
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        Intrinsics.checkNotNullParameter(observations, "observations");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(presenterName, "presenterName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
            zos = new ZipOutputStream(new FileOutputStream(outputFile));
            addZipEntry(zos, "[Content_Types].xml", buildContentTypesXml());
            addZipEntry(zos, "_rels/.rels", buildPackageRelsXml());
            addZipEntry(zos, "word/_rels/document.xml.rels", buildDocumentRelsXml());
            addZipEntry(zos, "word/styles.xml", buildStylesXml());
            list = observations;
            i = 0;
            arrayList = new ArrayList();
            it = list.iterator();
        } catch (Exception e) {
            e = e;
            z = false;
        }
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            try {
                Object next = it.next();
                Iterable iterable = list;
                int i3 = i;
                if (!StringsKt.equals(((Observation) next).getFindingType(), "Unsafe Act", true)) {
                    arrayList.add(next);
                }
                list = iterable;
                i = i3;
            } catch (Exception e2) {
                e = e2;
            }
            e = e2;
            e.printStackTrace();
            return z;
        }
        List conditions = (List) arrayList;
        List list2 = conditions;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 0;
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                if (!((Observation) it2.next()).isResolved() && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        int openConds = i2;
        List list3 = conditions;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            resolvedConds = 0;
        } else {
            resolvedConds = 0;
            Iterator it3 = list3.iterator();
            while (it3.hasNext()) {
                if (((Observation) it3.next()).isResolved() && (resolvedConds = resolvedConds + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        StringBuilder docXml = new StringBuilder();
        docXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<w:document xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\">\n  <w:body>\n");
        docXml.append(buildHeaderXml("UNSAFE CONDITIONS & ENVIRONMENTAL PARAMETERS REPORT", "Physical Workplace Hazards, Engineering Controls & 5S Non-Conformance Log", companyName, dateRangeText));
        CollectionsKt.listOf(new String[]{"Machinery & Guarding", "Electrical Safety", "Chemical / HAZMAT", "Fire Protection & Exits", "Housekeeping & 5S", "Working at Heights", "PPE Compliance", "Ergonomics & Lighting"});
        try {
            docXml.append("\n<w:p><w:pPr><w:spacing w:before=\"120\" w:after=\"80\"/></w:pPr><w:r><w:rPr><w:b/><w:color w:val=\"002060\"/><w:sz w:val=\"24\"/></w:rPr><w:t>1. HAZARD PARAMETER DISTRIBUTION</w:t></w:r></w:p>\n<w:tbl>\n  <w:tblPr>\n    <w:tblW w:w=\"9200\" w:type=\"dxa\"/>\n    <w:tblBorders>\n      <w:top w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:left w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:bottom w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:right w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:insideH w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/><w:insideV w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/>\n    </w:tblBorders>\n  </w:tblPr>\n  <w:tr>\n    " + tableHeaderCell("TOTAL HAZARDS IDENTIFIED", 3066) + "\n    " + tableHeaderCell("PENDING RECTIFICATION", 3066) + "\n    " + tableHeaderCell("RECTIFIED & COMPLIANT", 3066) + "\n  </w:tr>\n  <w:tr>\n    " + tableDataCell(conditions.size() + " Conditions", 3066, false, true, "002060") + "\n    " + tableDataCell(openConds + " Pending", 3066, false, true, "DC2626") + "\n    " + tableDataCell(resolvedConds + " Rectified", 3066, false, true, "16A34A") + "\n  </w:tr>\n</w:tbl>\n<w:p><w:pPr><w:spacing w:before=\"200\" w:after=\"100\"/></w:pPr><w:r><w:rPr><w:b/><w:color w:val=\"002060\"/><w:sz w:val=\"24\"/></w:rPr><w:t>2. ITEMIZED UNSAFE PHYSICAL CONDITIONS &amp; ENGINEERING CONTROLS</w:t></w:r></w:p>\n");
            docXml.append("\n<w:tbl>\n  <w:tblPr>\n    <w:tblW w:w=\"9200\" w:type=\"dxa\"/>\n    <w:tblBorders>\n      <w:top w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:left w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:bottom w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:right w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:insideH w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/><w:insideV w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/>\n    </w:tblBorders>\n  </w:tblPr>\n  <w:tr>\n    " + tableHeaderCell("S.NO", 600) + "\n    " + tableHeaderCell("SNC #", 1200) + "\n    " + tableHeaderCell("LOCATION & PARAMETER", 2200) + "\n    " + tableHeaderCell("HAZARD DETAILS", 2600) + "\n    " + tableHeaderCell("ENGINEERING CONTROL / CAPA", 1800) + "\n    " + tableHeaderCell("STATUS", 800) + "\n  </w:tr>\n");
            List list4 = conditions;
            int i4 = 0;
            int i5 = 0;
            Iterator it4 = list4.iterator();
            while (it4.hasNext()) {
                Object next2 = it4.next();
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Observation observation = (Observation) next2;
                boolean z2 = i5 % 2 == 1;
                Iterable iterable2 = list4;
                String str = observation.getLocation() + "\nParam: " + CsvReportGenerator.INSTANCE.determineHazardParameter(observation.getIssueDetails(), observation.getLocation()) + "\nRisk: " + observation.getRiskLevel();
                String str2 = observation.isResolved() ? "16A34A" : "DC2626";
                String tableDataCell$default = tableDataCell$default(INSTANCE, String.valueOf(i5 + 1), 600, z2, false, null, 24, null);
                String tableDataCell = INSTANCE.tableDataCell(observation.getSncNumber(), 1200, z2, true, "002060");
                int i7 = i4;
                String tableDataCell$default2 = tableDataCell$default(INSTANCE, str, 2200, z2, false, null, 24, null);
                String tableDataCell$default3 = tableDataCell$default(INSTANCE, observation.getIssueDetails(), 2600, z2, false, null, 24, null);
                DocxReportGenerator docxReportGenerator = INSTANCE;
                String suggestion = observation.getSuggestion();
                if (StringsKt.isBlank(suggestion)) {
                    suggestion = observation.getActionTaken();
                }
                Iterator it5 = it4;
                docXml.append("<w:tr>\n  " + tableDataCell$default + "\n  " + tableDataCell + "\n  " + tableDataCell$default2 + "\n  " + tableDataCell$default3 + "\n  " + tableDataCell$default(docxReportGenerator, suggestion, 1800, z2, false, null, 24, null) + "\n  " + INSTANCE.tableDataCell(observation.isResolved() ? "RESOLVED" : "OPEN", 800, z2, true, str2) + "\n</w:tr>");
                i5 = i6;
                list4 = iterable2;
                i4 = i7;
                it4 = it5;
            }
            docXml.append("</w:tbl>\n<w:p><w:pPr><w:spacing w:before=\"300\" w:after=\"100\"/></w:pPr><w:r><w:rPr><w:i/><w:color w:val=\"64748B\"/><w:sz w:val=\"18\"/></w:rPr><w:t>Lead Safety Engineer: " + escapeXml(presenterName) + " | Verified on Site</w:t></w:r></w:p>\n<w:sectPr><w:pgSz w:w=\"12240\" w:h=\"15840\"/><w:pgMar w:top=\"1000\" w:right=\"1000\" w:bottom=\"1000\" w:left=\"1000\"/></w:sectPr>\n</w:body></w:document>");
            String sb = docXml.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            addZipEntry(zos, "word/document.xml", sb);
            zos.close();
            return true;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static /* synthetic */ boolean generateSafetyStarDocxReport$default(DocxReportGenerator docxReportGenerator, String str, List list, List list2, String str2, String str3, File file, int i, Object obj) {
        String str4;
        if ((i & 16) == 0) {
            str4 = str3;
        } else {
            str4 = "J. VELMURUGAN";
        }
        return docxReportGenerator.generateSafetyStarDocxReport(str, list, list2, str2, str4, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0372 A[Catch: Exception -> 0x02c1, TryCatch #1 {Exception -> 0x02c1, blocks: (B:8:0x0102, B:12:0x010d, B:15:0x011d, B:16:0x0135, B:28:0x0179, B:35:0x01c5, B:39:0x0266, B:44:0x0198, B:45:0x019c, B:66:0x02c6, B:67:0x033d, B:69:0x0343, B:71:0x035a, B:73:0x0366, B:78:0x0372, B:84:0x0378, B:86:0x038d, B:91:0x0396, B:92:0x039f, B:94:0x03a5, B:96:0x03ad, B:97:0x03b0, B:100:0x03bc, B:102:0x03ca, B:105:0x03dd, B:106:0x03e1), top: B:7:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0375 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean generateSafetyStarDocxReport(java.lang.String r38, java.util.List<com.example.data.Observation> r39, java.util.List<com.example.data.ResponsiblePerson> r40, java.lang.String r41, java.lang.String r42, java.io.File r43) {
        /*
            Method dump skipped, instructions count: 1234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.DocxReportGenerator.generateSafetyStarDocxReport(java.lang.String, java.util.List, java.util.List, java.lang.String, java.lang.String, java.io.File):boolean");
    }

    public static /* synthetic */ boolean generateExecutiveComparisonDocxReport$default(DocxReportGenerator docxReportGenerator, String str, List list, List list2, List list3, List list4, String str2, String str3, File file, int i, Object obj) {
        String str4;
        if ((i & 64) == 0) {
            str4 = str3;
        } else {
            str4 = "J. VELMURUGAN";
        }
        return docxReportGenerator.generateExecutiveComparisonDocxReport(str, list, list2, list3, list4, str2, str4, file);
    }

    public final boolean generateExecutiveComparisonDocxReport(String companyName, List<Observation> currentObs, List<Observation> previousObs, List<IncidentRecord> currentIncidents, List<IncidentRecord> previousIncidents, String dateRangeText, String presenterName, File outputFile) {
        boolean z;
        ZipOutputStream zos;
        StringBuilder docXml;
        int curTotal;
        int prevTotal;
        int deltaTotal;
        int curResolved;
        int prevResolved;
        int curRate;
        int prevRate;
        int i;
        int curUA;
        List<Observation> list;
        int prevUA;
        int curUC;
        int prevUC;
        StringBuilder docXml2;
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        Intrinsics.checkNotNullParameter(currentObs, "currentObs");
        Intrinsics.checkNotNullParameter(previousObs, "previousObs");
        Intrinsics.checkNotNullParameter(currentIncidents, "currentIncidents");
        Intrinsics.checkNotNullParameter(previousIncidents, "previousIncidents");
        Intrinsics.checkNotNullParameter(dateRangeText, "dateRangeText");
        Intrinsics.checkNotNullParameter(presenterName, "presenterName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        boolean z2 = false;
        try {
            zos = new ZipOutputStream(new FileOutputStream(outputFile));
            addZipEntry(zos, "[Content_Types].xml", buildContentTypesXml());
            addZipEntry(zos, "_rels/.rels", buildPackageRelsXml());
            addZipEntry(zos, "word/_rels/document.xml.rels", buildDocumentRelsXml());
            addZipEntry(zos, "word/styles.xml", buildStylesXml());
            docXml = new StringBuilder();
            docXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<w:document xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\">\n  <w:body>\n");
            docXml.append(buildHeaderXml("EXECUTIVE EHS DASHBOARD & MONTH-OVER-MONTH COMPARISON", "Comparative Safety Analytics, Variance Analysis & Strategic Compliance Overview", companyName, dateRangeText));
            docXml.append("\n<w:p><w:pPr><w:spacing w:before=\"120\" w:after=\"80\"/></w:pPr><w:r><w:rPr><w:b/><w:color w:val=\"002060\"/><w:sz w:val=\"24\"/></w:rPr><w:t>1. MONTH-OVER-MONTH (MoM) KPI VARIANCE ANALYSIS</w:t></w:r></w:p>\n<w:tbl>\n  <w:tblPr>\n    <w:tblW w:w=\"9200\" w:type=\"dxa\"/>\n    <w:tblBorders>\n      <w:top w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:left w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:bottom w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:right w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:insideH w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/><w:insideV w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/>\n    </w:tblBorders>\n  </w:tblPr>\n  <w:tr>\n    " + tableHeaderCell("EHS PERFORMANCE METRIC", 3200) + "\n    " + tableHeaderCell("CURRENT PERIOD", 1800) + "\n    " + tableHeaderCell("PREVIOUS PERIOD", 1800) + "\n    " + tableHeaderCell("VARIANCE (DELTA)", 2400) + "\n  </w:tr>\n");
            curTotal = currentObs.size();
            prevTotal = previousObs.size();
            deltaTotal = curTotal - prevTotal;
            List<Observation> list2 = currentObs;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                curResolved = 0;
            } else {
                curResolved = 0;
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    if (((Observation) it.next()).isResolved() && (curResolved = curResolved + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            List<Observation> list3 = previousObs;
            if ((list3 instanceof Collection) && list3.isEmpty()) {
                prevResolved = 0;
            } else {
                prevResolved = 0;
                Iterator it2 = list3.iterator();
                while (it2.hasNext()) {
                    if (((Observation) it2.next()).isResolved() && (prevResolved = prevResolved + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            curRate = curTotal > 0 ? (curResolved * 100) / curTotal : 100;
            prevRate = prevTotal > 0 ? (prevResolved * 100) / prevTotal : 100;
            List<Observation> list4 = currentObs;
            if ((list4 instanceof Collection) && list4.isEmpty()) {
                i = 0;
            } else {
                i = 0;
                Iterator it3 = list4.iterator();
                while (it3.hasNext()) {
                    try {
                        if (StringsKt.equals(((Observation) it3.next()).getFindingType(), "Unsafe Act", true)) {
                            i++;
                            if (i < 0) {
                                CollectionsKt.throwCountOverflow();
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        z = z2;
                        e.printStackTrace();
                        return z;
                    }
                }
            }
            curUA = i;
            list = previousObs;
        } catch (Exception e2) {
            e = e2;
        }
        try {
            if ((list instanceof Collection) && list.isEmpty()) {
                prevUA = 0;
            } else {
                int i2 = 0;
                Iterator it4 = list.iterator();
                while (it4.hasNext()) {
                    int i3 = i2;
                    Iterable iterable = list;
                    if (StringsKt.equals(((Observation) it4.next()).getFindingType(), "Unsafe Act", true)) {
                        i2 = i3 + 1;
                        if (i2 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        list = iterable;
                    } else {
                        i2 = i3;
                        list = iterable;
                    }
                }
                prevUA = i2;
            }
            List<Observation> list5 = currentObs;
            StringBuilder docXml3 = docXml;
            if ((list5 instanceof Collection) && list5.isEmpty()) {
                curUC = 0;
            } else {
                int i4 = 0;
                Iterator it5 = list5.iterator();
                while (it5.hasNext()) {
                    int i5 = i4;
                    Iterable iterable2 = list5;
                    if (StringsKt.equals(((Observation) it5.next()).getFindingType(), "Unsafe Act", true)) {
                        i4 = i5;
                        list5 = iterable2;
                    } else {
                        i4 = i5 + 1;
                        if (i4 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        list5 = iterable2;
                    }
                }
                curUC = i4;
            }
            List<Observation> list6 = previousObs;
            String str = "\n  ";
            if ((list6 instanceof Collection) && list6.isEmpty()) {
                prevUC = 0;
            } else {
                int i6 = 0;
                Iterator it6 = list6.iterator();
                while (it6.hasNext()) {
                    int i7 = i6;
                    Iterable iterable3 = list6;
                    if (StringsKt.equals(((Observation) it6.next()).getFindingType(), "Unsafe Act", true)) {
                        i6 = i7;
                        list6 = iterable3;
                    } else {
                        i6 = i7 + 1;
                        if (i6 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        list6 = iterable3;
                    }
                }
                prevUC = i6;
            }
            Pair[] pairArr = new Pair[5];
            int prevUC2 = prevUC;
            pairArr[0] = new Pair("Total Safety Findings Logged", new Triple(curTotal + " Findings", prevTotal + " Findings", (deltaTotal <= 0 ? new StringBuilder().append("✅ ").append(deltaTotal).append(" (Reduced)") : new StringBuilder().append("⚠️ +").append(deltaTotal).append(" (Increase)")).toString()));
            pairArr[1] = new Pair("Resolution Compliance Rate", new Triple(curRate + "%", prevRate + "%", (curRate >= prevRate ? new StringBuilder().append("✅ +").append(curRate - prevRate).append("% Improved") : new StringBuilder().append("⚠️ -").append(prevRate - curRate).append("% Drop")).toString()));
            pairArr[2] = new Pair("Unsafe Acts (Behavioral)", new Triple(curUA + " Acts", prevUA + " Acts", curUA <= prevUA ? "✅ Coached & Reduced" : "⚠️ Attention Needed"));
            pairArr[3] = new Pair("Unsafe Conditions (Physical)", new Triple(curUC + " Hazards", prevUC2 + " Hazards", curUC <= prevUC2 ? "✅ Safer Facility" : "⚠️ Hazards Identified"));
            pairArr[4] = new Pair("Lost Time / Recordable Incidents", new Triple(currentIncidents.size() + " Incidents", previousIncidents.size() + " Incidents", currentIncidents.size() <= previousIncidents.size() ? "✅ Zero Incident Goal" : "⚠️ Recorded Incident"));
            List metrics = CollectionsKt.listOf(pairArr);
            List list7 = metrics;
            int i8 = 0;
            for (Object obj : list7) {
                try {
                    int i9 = i8 + 1;
                    if (i8 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Pair pair = (Pair) obj;
                    List metrics2 = metrics;
                    boolean z3 = i8 % 2 == 1 ? true : z2;
                    int curUA2 = curUA;
                    int curUC2 = curUC;
                    Iterable iterable4 = list7;
                    int deltaTotal2 = deltaTotal;
                    boolean z4 = z2;
                    int prevRate2 = prevRate;
                    z = z4;
                    int prevUA2 = prevUA;
                    try {
                        String str2 = str;
                        StringBuilder docXml4 = docXml3;
                        docXml4.append("<w:tr>\n  " + INSTANCE.tableDataCell((String) pair.getFirst(), 3200, z3, true, "002060") + str2 + tableDataCell$default(INSTANCE, (String) ((Triple) pair.getSecond()).getFirst(), 1800, z3, false, null, 24, null) + str2 + tableDataCell$default(INSTANCE, (String) ((Triple) pair.getSecond()).getSecond(), 1800, z3, false, null, 24, null) + str2 + INSTANCE.tableDataCell((String) ((Triple) pair.getSecond()).getThird(), 2400, z3, true, StringsKt.startsWith$default((String) ((Triple) pair.getSecond()).getThird(), "✅", z, 2, (Object) null) ? "16A34A" : "DC2626") + "\n</w:tr>");
                        z2 = z;
                        prevRate = prevRate2;
                        docXml3 = docXml4;
                        str = str2;
                        i8 = i9;
                        metrics = metrics2;
                        curUC = curUC2;
                        list7 = iterable4;
                        curUA = curUA2;
                        deltaTotal = deltaTotal2;
                        prevUA = prevUA2;
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        return z;
                    }
                } catch (Exception e4) {
                    e = e4;
                    z = z2;
                }
            }
            z = z2;
            docXml2 = docXml3;
        } catch (Exception e5) {
            e = e5;
            z = z2;
            e.printStackTrace();
            return z;
        }
        try {
            docXml2.append("</w:tbl>\n<w:p><w:pPr><w:spacing w:before=\"300\" w:after=\"100\"/></w:pPr><w:r><w:rPr><w:i/><w:color w:val=\"64748B\"/><w:sz w:val=\"18\"/></w:rPr><w:t>Executive Report Endorsement: " + escapeXml(presenterName) + " | Chief Safety Officer</w:t></w:r></w:p>\n<w:sectPr><w:pgSz w:w=\"12240\" w:h=\"15840\"/><w:pgMar w:top=\"1000\" w:right=\"1000\" w:bottom=\"1000\" w:left=\"1000\"/></w:sectPr>\n</w:body></w:document>");
            String sb = docXml2.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            addZipEntry(zos, "word/document.xml", sb);
            zos.close();
            return true;
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            return z;
        }
    }

    public static /* synthetic */ boolean generateSafetyTrainingsDocxReport$default(DocxReportGenerator docxReportGenerator, String str, List list, String str2, String str3, File file, int i, Object obj) {
        String str4;
        if ((i & 8) == 0) {
            str4 = str3;
        } else {
            str4 = "J. VELMURUGAN";
        }
        return docxReportGenerator.generateSafetyTrainingsDocxReport(str, list, str2, str4, file);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean generateSafetyTrainingsDocxReport(String companyName, List<SafetyTraining> trainings, String monthYearText, String presenterName, File outputFile) {
        String tableDataCell;
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        Intrinsics.checkNotNullParameter(trainings, "trainings");
        Intrinsics.checkNotNullParameter(monthYearText, "monthYearText");
        Intrinsics.checkNotNullParameter(presenterName, "presenterName");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outputFile));
            addZipEntry(zos, "[Content_Types].xml", buildContentTypesXml());
            addZipEntry(zos, "_rels/.rels", buildPackageRelsXml());
            addZipEntry(zos, "word/_rels/document.xml.rels", buildDocumentRelsXml());
            addZipEntry(zos, "word/styles.xml", buildStylesXml());
            int totalSessions = trainings.size();
            Iterator<T> it = trainings.iterator();
            int totalAttendees = 0;
            while (it.hasNext()) {
                totalAttendees += ((SafetyTraining) it.next()).getAttendeesCount();
            }
            Iterator<T> it2 = trainings.iterator();
            double totalManHours = 0.0d;
            double totalHours = 0.0d;
            while (it2.hasNext()) {
                totalHours += ((SafetyTraining) it2.next()).getDurationHours();
            }
            Iterator<T> it3 = trainings.iterator();
            while (it3.hasNext()) {
                totalManHours += ((SafetyTraining) it3.next()).getManHoursTrained();
            }
            StringBuilder docXml = new StringBuilder();
            docXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<w:document xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\">\n  <w:body>\n");
            docXml.append(buildHeaderXml("MONTHLY SAFETY TRAININGS & ATTENDANCE REGISTER", "Statutory Training Compliance, Factories Act 1948 & ISO 45001 Competency Dossier", companyName, monthYearText));
            String tableHeaderCell = tableHeaderCell("SESSIONS", 2300);
            String tableHeaderCell2 = tableHeaderCell("ATTENDEES", 2300);
            String tableHeaderCell3 = tableHeaderCell("DURATION", 2300);
            String tableHeaderCell4 = tableHeaderCell("MAN-HOURS", 2300);
            try {
                int totalAttendees2 = totalAttendees;
                try {
                    tableDataCell = tableDataCell(totalSessions + " Completed", 2300, false, true, "002060");
                } catch (Exception e) {
                    e = e;
                }
                try {
                    String tableDataCell2 = tableDataCell(totalAttendees2 + " Personnel", 2300, false, true, "16A34A");
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(Locale.getDefault(), "%.1f Hrs", Arrays.copyOf(new Object[]{Double.valueOf(totalHours)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    String str = "\n  ";
                    int i = 1;
                    String tableDataCell3 = tableDataCell(format, 2300, false, true, "2563EB");
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format(Locale.getDefault(), "%.1f Man-Hrs", Arrays.copyOf(new Object[]{Double.valueOf(totalManHours)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    docXml.append("\n<w:p><w:pPr><w:spacing w:before=\"120\" w:after=\"80\"/></w:pPr><w:r><w:rPr><w:b/><w:color w:val=\"002060\"/><w:sz w:val=\"24\"/></w:rPr><w:t>1. TRAINING KPI SUMMARY</w:t></w:r></w:p>\n<w:tbl>\n  <w:tblPr>\n    <w:tblW w:w=\"9200\" w:type=\"dxa\"/>\n    <w:tblBorders>\n      <w:top w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:left w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:bottom w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:right w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:insideH w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/><w:insideV w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/>\n    </w:tblBorders>\n  </w:tblPr>\n  <w:tr>\n    " + tableHeaderCell + "\n    " + tableHeaderCell2 + "\n    " + tableHeaderCell3 + "\n    " + tableHeaderCell4 + "\n  </w:tr>\n  <w:tr>\n    " + tableDataCell + "\n    " + tableDataCell2 + "\n    " + tableDataCell3 + "\n    " + tableDataCell(format2, 2300, false, true, "D97706") + "\n  </w:tr>\n</w:tbl>\n<w:p><w:pPr><w:spacing w:before=\"200\" w:after=\"100\"/></w:pPr><w:r><w:rPr><w:b/><w:color w:val=\"002060\"/><w:sz w:val=\"24\"/></w:rPr><w:t>2. TRAINING SESSIONS &amp; ATTENDANCE LOG</w:t></w:r></w:p>\n");
                    docXml.append("\n<w:tbl>\n  <w:tblPr>\n    <w:tblW w:w=\"9200\" w:type=\"dxa\"/>\n    <w:tblBorders>\n      <w:top w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:left w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:bottom w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/><w:right w:val=\"single\" w:sz=\"6\" w:color=\"CBD5E1\"/>\n      <w:insideH w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/><w:insideV w:val=\"single\" w:sz=\"4\" w:color=\"E2E8F0\"/>\n    </w:tblBorders>\n  </w:tblPr>\n  <w:tr>\n    " + tableHeaderCell("S.NO", 600) + "\n    " + tableHeaderCell("DATE", 1100) + "\n    " + tableHeaderCell("TOPIC / MODULE", 2700) + "\n    " + tableHeaderCell("DEPARTMENT", 1800) + "\n    " + tableHeaderCell("TRAINER & VENUE", 1800) + "\n    " + tableHeaderCell("ATTENDEES", 1200) + "\n  </w:tr>\n");
                    if (trainings.isEmpty()) {
                        docXml.append("<w:tr>\n  <w:tc>\n    <w:tcPr><w:tcW w:w=\"9200\" w:type=\"dxa\"/><w:gridSpan w:val=\"6\"/><w:tcMar><w:top w:w=\"160\" w:type=\"dxa\"/><w:bottom w:w=\"160\" w:type=\"dxa\"/></w:tcMar></w:tcPr>\n    <w:p><w:pPr><w:jc w:val=\"center\"/></w:pPr><w:r><w:rPr><w:i/><w:color w:val=\"64748B\"/></w:rPr><w:t>No safety training sessions recorded for this period.</w:t></w:r></w:p>\n  </w:tc>\n</w:tr>");
                    } else {
                        List<SafetyTraining> list = trainings;
                        int i2 = 0;
                        int i3 = 0;
                        for (Object obj : list) {
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            SafetyTraining safetyTraining = (SafetyTraining) obj;
                            boolean z = i3 % 2 == i ? i : 0;
                            String tableDataCell$default = tableDataCell$default(INSTANCE, String.valueOf(i3 + 1), 600, z, false, null, 24, null);
                            String tableDataCell$default2 = tableDataCell$default(INSTANCE, safetyTraining.getTrainingDate(), 1100, z, false, null, 24, null);
                            String tableDataCell4 = INSTANCE.tableDataCell(safetyTraining.getTrainingTopic(), 2700, z, true, "002060");
                            String tableDataCell$default3 = tableDataCell$default(INSTANCE, safetyTraining.getTargetDepartment(), 1800, z, false, null, 24, null);
                            Iterable iterable = list;
                            String tableDataCell$default4 = tableDataCell$default(INSTANCE, safetyTraining.getTrainerName() + "\n(" + safetyTraining.getVenue() + ")", 1800, z, false, null, 24, null);
                            String tableDataCell5 = INSTANCE.tableDataCell(safetyTraining.getAttendeesCount() + " pax", 1200, z, true, "16A34A");
                            int i5 = i2;
                            StringBuilder append = new StringBuilder().append("<w:tr>\n  ").append(tableDataCell$default);
                            String str2 = str;
                            docXml.append(append.append(str2).append(tableDataCell$default2).append(str2).append(tableDataCell4).append(str2).append(tableDataCell$default3).append(str2).append(tableDataCell$default4).append(str2).append(tableDataCell5).append("\n</w:tr>").toString());
                            i3 = i4;
                            str = str2;
                            list = iterable;
                            i2 = i5;
                            i = 1;
                        }
                    }
                    docXml.append("</w:tbl>\n<w:p><w:pPr><w:spacing w:before=\"300\" w:after=\"100\"/></w:pPr><w:r><w:rPr><w:i/><w:color w:val=\"64748B\"/><w:sz w:val=\"18\"/></w:rPr><w:t>Lead Safety Trainer / Faculty: " + escapeXml(presenterName) + " | Verified &amp; Certified</w:t></w:r></w:p>\n<w:sectPr><w:pgSz w:w=\"12240\" w:h=\"15840\"/><w:pgMar w:top=\"1000\" w:right=\"1000\" w:bottom=\"1000\" w:left=\"1000\"/></w:sectPr>\n</w:body></w:document>");
                    String sb = docXml.toString();
                    Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
                    addZipEntry(zos, "word/document.xml", sb);
                    zos.close();
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return false;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean generateIncidentsDocxReport(java.lang.String r36, java.util.List<com.example.data.IncidentRecord> r37, java.lang.String r38, java.lang.String r39, java.io.File r40) {
        /*
            Method dump skipped, instructions count: 1200
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.DocxReportGenerator.generateIncidentsDocxReport(java.lang.String, java.util.List, java.lang.String, java.lang.String, java.io.File):boolean");
    }

    public static /* synthetic */ boolean generateUnifiedMasterDocxReport$default(DocxReportGenerator docxReportGenerator, String str, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, List list10, List list11, String str2, String str3, File file, int i, Object obj) {
        String str4;
        if ((i & 8192) == 0) {
            str4 = str3;
        } else {
            str4 = "J. VELMURUGAN";
        }
        return docxReportGenerator.generateUnifiedMasterDocxReport(str, list, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, str2, str4, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:241:0x0e29  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0e4c A[Catch: Exception -> 0x11e4, TryCatch #2 {Exception -> 0x11e4, blocks: (B:151:0x0b8a, B:153:0x0bee, B:154:0x0d3d, B:156:0x0da7, B:157:0x0f53, B:159:0x0fbd, B:183:0x0fc4, B:184:0x0fce, B:189:0x0fdc, B:195:0x0ffd, B:224:0x0db0, B:225:0x0dba, B:227:0x0dc0, B:229:0x0dc8, B:230:0x0dcb, B:233:0x0ddd, B:235:0x0dee, B:239:0x0dff, B:242:0x0e30, B:244:0x0e4c, B:245:0x0e5b, B:247:0x0ebc, B:248:0x0eef, B:252:0x0f00, B:255:0x0ed6, B:261:0x0f4d, B:262:0x0bf7, B:263:0x0c01, B:265:0x0c07, B:267:0x0c0f, B:268:0x0c12, B:271:0x0c25, B:273:0x0c50, B:274:0x0c5f, B:278:0x0c9d, B:283:0x0d37), top: B:150:0x0b8a }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0ebc A[Catch: Exception -> 0x11e4, TryCatch #2 {Exception -> 0x11e4, blocks: (B:151:0x0b8a, B:153:0x0bee, B:154:0x0d3d, B:156:0x0da7, B:157:0x0f53, B:159:0x0fbd, B:183:0x0fc4, B:184:0x0fce, B:189:0x0fdc, B:195:0x0ffd, B:224:0x0db0, B:225:0x0dba, B:227:0x0dc0, B:229:0x0dc8, B:230:0x0dcb, B:233:0x0ddd, B:235:0x0dee, B:239:0x0dff, B:242:0x0e30, B:244:0x0e4c, B:245:0x0e5b, B:247:0x0ebc, B:248:0x0eef, B:252:0x0f00, B:255:0x0ed6, B:261:0x0f4d, B:262:0x0bf7, B:263:0x0c01, B:265:0x0c07, B:267:0x0c0f, B:268:0x0c12, B:271:0x0c25, B:273:0x0c50, B:274:0x0c5f, B:278:0x0c9d, B:283:0x0d37), top: B:150:0x0b8a }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0efb  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0efe  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0ed6 A[Catch: Exception -> 0x11e4, TryCatch #2 {Exception -> 0x11e4, blocks: (B:151:0x0b8a, B:153:0x0bee, B:154:0x0d3d, B:156:0x0da7, B:157:0x0f53, B:159:0x0fbd, B:183:0x0fc4, B:184:0x0fce, B:189:0x0fdc, B:195:0x0ffd, B:224:0x0db0, B:225:0x0dba, B:227:0x0dc0, B:229:0x0dc8, B:230:0x0dcb, B:233:0x0ddd, B:235:0x0dee, B:239:0x0dff, B:242:0x0e30, B:244:0x0e4c, B:245:0x0e5b, B:247:0x0ebc, B:248:0x0eef, B:252:0x0f00, B:255:0x0ed6, B:261:0x0f4d, B:262:0x0bf7, B:263:0x0c01, B:265:0x0c07, B:267:0x0c0f, B:268:0x0c12, B:271:0x0c25, B:273:0x0c50, B:274:0x0c5f, B:278:0x0c9d, B:283:0x0d37), top: B:150:0x0b8a }] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0e57  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0e2c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean generateUnifiedMasterDocxReport(java.lang.String r68, java.util.List<java.lang.String> r69, java.util.List<com.example.data.Observation> r70, java.util.List<com.example.data.Observation> r71, java.util.List<com.example.data.Observation> r72, java.util.List<com.example.data.ResponsiblePerson> r73, java.util.List<com.example.data.IncidentRecord> r74, java.util.List<com.example.data.SafetyTraining> r75, java.util.List<com.example.data.Observation> r76, java.util.List<com.example.data.Observation> r77, java.util.List<com.example.data.IncidentRecord> r78, java.util.List<com.example.data.IncidentRecord> r79, java.lang.String r80, java.lang.String r81, java.io.File r82) {
        /*
            Method dump skipped, instructions count: 4593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.DocxReportGenerator.generateUnifiedMasterDocxReport(java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.lang.String, java.lang.String, java.io.File):boolean");
    }
}
