package com.example.utils;

import android.content.Context;
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
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: XlsxReportGenerator.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JÈ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000e2\b\b\u0002\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"J¬\u0001\u0010#\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000e2\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0002¨\u0006)"}, d2 = {"Lcom/example/utils/XlsxReportGenerator;", "", "<init>", "()V", "generateXlsxReport", "", "context", "Landroid/content/Context;", "sectionTitle", "", "company", "Lcom/example/data/Company;", "dateRangeText", "observations", "", "Lcom/example/data/Observation;", "incidents", "Lcom/example/data/IncidentRecord;", "trainings", "Lcom/example/data/SafetyTraining;", "complianceItems", "Lcom/example/data/ComplianceItem;", "personnel", "Lcom/example/data/ResponsiblePerson;", "calendarEvents", "Lcom/example/ui/CalendarHolidayEvent;", "fireExtinguishers", "Lcom/example/data/FireExtinguisher;", "amcRecords", "Lcom/example/data/AmcRecord;", "materialFollowUps", "Lcom/example/data/MaterialFollowUpRecord;", "presenterName", "outputFile", "Ljava/io/File;", "buildSheetData", "getColumnLetter", "colNum", "", "escapeXml", "str", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class XlsxReportGenerator {
    public static final int $stable = 0;
    public static final XlsxReportGenerator INSTANCE = new XlsxReportGenerator();

    private XlsxReportGenerator() {
    }

    public final boolean generateXlsxReport(Context context, String sectionTitle, Company company, String dateRangeText, List<Observation> observations, List<IncidentRecord> incidents, List<SafetyTraining> trainings, List<ComplianceItem> complianceItems, List<ResponsiblePerson> personnel, List<CalendarHolidayEvent> calendarEvents, List<FireExtinguisher> fireExtinguishers, List<AmcRecord> amcRecords, List<MaterialFollowUpRecord> materialFollowUps, String presenterName, File outputFile) {
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
        try {
            File parentFile = outputFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(outputFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            zos.putNextEntry(new ZipEntry("[Content_Types].xml"));
            byte[] bytes = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Types xmlns=\"http://schemas.openxmlformats.org/package/2006/content-types\">\n  <Default Extension=\"rels\" ContentType=\"application/vnd.openxmlformats-package.relationships+xml\"/>\n  <Default Extension=\"xml\" ContentType=\"application/xml\"/>\n  <Override PartName=\"/xl/workbook.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml\"/>\n  <Override PartName=\"/xl/worksheets/sheet1.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml\"/>\n  <Override PartName=\"/xl/styles.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.spreadsheetml.styles+xml\"/>\n</Types>".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            zos.write(bytes);
            zos.closeEntry();
            zos.putNextEntry(new ZipEntry("_rels/.rels"));
            byte[] bytes2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">\n  <Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument\" Target=\"xl/workbook.xml\"/>\n</Relationships>".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            zos.write(bytes2);
            zos.closeEntry();
            String safeSheetName = escapeXml(StringsKt.take(sectionTitle, 28));
            zos.putNextEntry(new ZipEntry("xl/workbook.xml"));
            byte[] bytes3 = ("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<workbook xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\">\n  <sheets>\n    <sheet name=\"" + safeSheetName + "\" sheetId=\"1\" r:id=\"rId1\"/>\n  </sheets>\n</workbook>").getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
            zos.write(bytes3);
            zos.closeEntry();
            zos.putNextEntry(new ZipEntry("xl/_rels/workbook.xml.rels"));
            byte[] bytes4 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">\n  <Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/worksheet\" Target=\"worksheets/sheet1.xml\"/>\n  <Relationship Id=\"rId2\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles\" Target=\"styles.xml\"/>\n</Relationships>".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
            zos.write(bytes4);
            zos.closeEntry();
            zos.putNextEntry(new ZipEntry("xl/styles.xml"));
            byte[] bytes5 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<styleSheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\">\n  <fonts count=\"3\">\n    <font><sz val=\"11\"/><name val=\"Calibri\"/></font>\n    <font><b/><sz val=\"11\"/><color rgb=\"FFFFFFFF\"/><name val=\"Calibri\"/></font>\n    <font><b/><sz val=\"13\"/><color rgb=\"FF002060\"/><name val=\"Calibri\"/></font>\n  </fonts>\n  <fills count=\"4\">\n    <fill><patternFill fillType=\"none\"/></fill>\n    <fill><patternFill fillType=\"gray125\"/></fill>\n    <fill><patternFill fillType=\"solid\"><fgColor rgb=\"FF002060\"/></patternFill></fill>\n    <fill><patternFill fillType=\"solid\"><fgColor rgb=\"FFF1F5F9\"/></patternFill></fill>\n  </fills>\n  <borders count=\"2\">\n    <border><left/><right/><top/><bottom/><diagonal/></border>\n    <border>\n      <left style=\"thin\"><color rgb=\"FFCBD5E1\"/></left>\n      <right style=\"thin\"><color rgb=\"FFCBD5E1\"/></right>\n      <top style=\"thin\"><color rgb=\"FFCBD5E1\"/></top>\n      <bottom style=\"thin\"><color rgb=\"FFCBD5E1\"/></bottom>\n      <diagonal/>\n    </border>\n  </borders>\n  <cellStyleXfs count=\"1\">\n    <xf numFmtId=\"0\" fontId=\"0\" fillId=\"0\" borderId=\"0\"/>\n  </cellStyleXfs>\n  <cellXfs count=\"4\">\n    <xf numFmtId=\"0\" fontId=\"0\" fillId=\"0\" borderId=\"1\" xfId=\"0\"/>\n    <xf numFmtId=\"0\" fontId=\"1\" fillId=\"2\" borderId=\"1\" xfId=\"0\" applyFont=\"1\" applyFill=\"1\" applyBorder=\"1\"/>\n    <xf numFmtId=\"0\" fontId=\"2\" fillId=\"0\" borderId=\"0\" xfId=\"0\" applyFont=\"1\"/>\n    <xf numFmtId=\"0\" fontId=\"0\" fillId=\"3\" borderId=\"1\" xfId=\"0\" applyFill=\"1\" applyBorder=\"1\"/>\n  </cellXfs>\n</styleSheet>".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes5, "getBytes(...)");
            zos.write(bytes5);
            zos.closeEntry();
            String sheetDataXml = buildSheetData(sectionTitle, company, dateRangeText, observations, incidents, trainings, complianceItems, personnel, calendarEvents, fireExtinguishers, amcRecords, materialFollowUps, presenterName);
            zos.putNextEntry(new ZipEntry("xl/worksheets/sheet1.xml"));
            byte[] bytes6 = ("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<worksheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\">\n  <sheetData>\n" + sheetDataXml + "\n  </sheetData>\n</worksheet>").getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes6, "getBytes(...)");
            zos.write(bytes6);
            zos.closeEntry();
            zos.finish();
            zos.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0f5c  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0f8d  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0f9d  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0fa2  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0fa7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0f9f  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0f7d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String buildSheetData(java.lang.String r44, com.example.data.Company r45, java.lang.String r46, java.util.List<com.example.data.Observation> r47, java.util.List<com.example.data.IncidentRecord> r48, java.util.List<com.example.data.SafetyTraining> r49, java.util.List<com.example.data.ComplianceItem> r50, java.util.List<com.example.data.ResponsiblePerson> r51, java.util.List<com.example.ui.CalendarHolidayEvent> r52, java.util.List<com.example.data.FireExtinguisher> r53, java.util.List<com.example.data.AmcRecord> r54, java.util.List<com.example.data.MaterialFollowUpRecord> r55, java.lang.String r56) {
        /*
            Method dump skipped, instructions count: 5473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.XlsxReportGenerator.buildSheetData(java.lang.String, com.example.data.Company, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.lang.String):java.lang.String");
    }

    private static final void buildSheetData$addRow(StringBuilder sb, Ref.IntRef rowIdx, List<Pair<String, Integer>> list) {
        sb.append("    <row r=\"" + rowIdx.element + "\">\n");
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            sb.append("      <c r=\"" + (INSTANCE.getColumnLetter(i + 1) + rowIdx.element) + "\" t=\"inlineStr\" s=\"" + ((Number) pair.getSecond()).intValue() + "\"><is><t>" + INSTANCE.escapeXml((String) pair.getFirst()) + "</t></is></c>\n");
            i = i2;
        }
        sb.append("    </row>\n");
        rowIdx.element++;
    }

    private final String getColumnLetter(int colNum) {
        int num = colNum;
        String letter = "";
        while (num > 0) {
            int mod = (num - 1) % 26;
            letter = ((char) (mod + 65)) + letter;
            num = (num - mod) / 26;
        }
        return letter;
    }

    private final String escapeXml(String str) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "&", "&amp;", false, 4, (Object) null), "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null), "\"", "&quot;", false, 4, (Object) null), "'", "&apos;", false, 4, (Object) null);
    }
}
