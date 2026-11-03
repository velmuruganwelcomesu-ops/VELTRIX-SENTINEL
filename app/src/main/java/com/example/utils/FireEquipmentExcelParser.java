package com.example.utils;

import android.content.Context;
import android.net.Uri;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: FireEquipmentExcelParser.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J*\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0014\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010J:\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0010R\u0011\u0010)\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/example/utils/FireEquipmentExcelParser;", "", "<init>", "()V", "parseSpreadsheet", "Lcom/example/utils/ParsedExcelSheet;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "fileName", "", "parseXlsx", "inputStream", "Ljava/io/InputStream;", "extractSharedStrings", "", "xml", "extractSheetRows", "sharedStrings", "columnNameToIndex", "", "cellRef", "parseCsvOrTsv", "rawText", "parseLineWithQuotes", "line", "delimiter", "", "autoDetectMapping", "Lcom/example/utils/ExcelColumnMapping;", "headers", "validateAndBuildRecords", "Lcom/example/utils/ValidatedImportRecord;", "parsedSheet", "mapping", "targetCompanyId", "", "targetCompanyName", "existingDatabaseRecords", "Lcom/example/data/FireExtinguisher;", "sampleCsvData", "getSampleCsvData", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class FireEquipmentExcelParser {
    public static final int $stable = 0;
    public static final FireEquipmentExcelParser INSTANCE = new FireEquipmentExcelParser();
    private static final String sampleCsvData = "Tag No,Category,Location,Type & Capacity,Specification,Last Test Date,Next Due Date,Hydrostatic Test Date,Status,Remarks,Defects\nHYD-01,Fire Hydrants,Main Transformer Yard - Post 1,Single Landing Valve (63mm),Operating Pressure: 7.0 kg/cm²,15-01-2026,15-04-2026,10-06-2024,OK,Ring header pressure maintained at 7.2 bar. Handwheel smooth.,\nHYD-02,Fire Hydrants,Raw Material Warehouse Gate 2,Double Landing Valve (63mm),Operating Pressure: 8.5 kg/cm²,20-01-2026,20-04-2026,12-07-2024,OK,Dual instantaneous couplings tested with branch pipe.,\nHR-01,Fire Hose Reels,Assembly Hall 1st Floor - Staircase 2,Swinging Drum Hose Reel (30m x 19mm),Working Pressure: 12 kg/cm²,10-02-2026,10-05-2026,15-08-2024,OK,Drum swings 180 deg freely. Jet/spray shutoff nozzle functional.,\nHR-02,Fire Hose Reels,Finished Goods Bay A,Fixed Drum Hose Reel (36m x 25mm),Working Pressure: 12 kg/cm²,15-02-2026,15-05-2026,18-09-2024,OK,Rubber hose hydraulic pressure test completed.,\nFACP-01,Smoke Detectors & Fire Alarm Panels,Main Security Control Center,Addressable Fire Alarm Panel (4 Loops, 500 Points),24V DC Standby Battery (2x12V 26Ah),05-03-2026,05-06-2026,15-11-2025,OK,AC mains and dual 26Ah batteries healthy. Zero faults.,\nSD-104,Smoke Detectors & Fire Alarm Panels,Server Room Rack Row 2,Optical Smoke Detector (Addressable),Dual Wavelength Optical Sensing,08-03-2026,08-06-2026,10-12-2025,OK,Chamber cleaned with aerosol duster. Sensitivity within NFPA 72 limits.,\nMCP-01,MCP (Manual Call Points),Emergency Exit Door West Stairwell,Break Glass Call Point (Conventional Red),Push-Break Frangible Element,12-02-2026,12-05-2026,,OK,Frangible glass intact. Test hammer chained securely.,\nHT-01,Hooters,High Noise Fabrication Bay,Electronic Fire Hooter with Strobe (105 dB),Output: 105 dB(A) @ 1m,18-01-2026,18-04-2026,,OK,Audibility confirmed >15 dB above ambient workshop noise. Xenon flasher synchronized.,\nEXT-01,Exit Lights,Ground Floor Final Exit Fire Doorway,Edge-Lit LED Emergency Exit Sign (Double Sided),3-Hour Battery Inverter Backup,12-02-2026,12-05-2026,,OK,Switches to emergency battery instantly on mains cut. 180 min runtime passed.,\nEXT-02,Exit Lights,Basement Ramp West Passage,Maintained Bulkhead Exit Light (3-Hour Ni-Cd Battery),Green LED Matrix Viewing 25m,14-02-2026,14-05-2026,,OK,Illuminated emergency running man graphic clear.,\nFE-05,Fire Extinguishers,Chemical Dosing Area,Mechanical Foam (AFFF) 9 L,Class A, B,20-02-2026,20-02-2027,15-03-2024,OK,Periodic inspection completed. Level indicator verified.,\nFE-06,Fire Extinguishers,Main Switchgear Room,CO2 4.5 Kg,Class B, C & Electrical,10-01-2026,10-01-2027,10-01-2024,OK,Tare weight verified 16.8 kg. No leakage.,\nFE-07,Fire Extinguishers,Solvent Storage Yard,ABC Dry Chemical Powder 9 Kg,Class A, B, C,15-08-2025,15-08-2026,12-09-2023,Expired,Safety pull-pin missing. Refill overdue.,Missing Pin;Seal Broken\nSPK-01,Sprinklers,Finished Goods High Bay Aisle 4,Pendant Sprinkler Head (68°C),K-Factor: 5.6 (80 LPM/√bar),10-02-2026,10-05-2026,15-08-2024,OK,Red glass bulb intact. Deflector free of dust or paint.,\nFP-01,Fire Pumps,Central Fire Pump House - Base 1,Main Electric Fire Pump (2850 RPM),Rated Flow: 2850 LPM @ 7 bar,15-02-2026,15-05-2026,10-01-2025,OK,Automatic start on 7 bar ring drop verified. Gland packing healthy.,\nOFE-01,Other Fire Equipment,Control Room Corridor Cabinet 1,Fire Safety Blanket (1.8m x 1.8m),EN 1869:2019 Certified,01-02-2026,01-05-2026,,OK,Fiberglass blanket neatly folded with quick-pull tabs accessible.,";

    private FireEquipmentExcelParser() {
    }

    public final ParsedExcelSheet parseSpreadsheet(Context context, Uri uri, String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerName = fileName.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerName, "toLowerCase(...)");
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            if (inputStream == null) {
                return parseCsvOrTsv(sampleCsvData, "sample_fire_inventory.xlsx");
            }
            if (StringsKt.endsWith$default(lowerName, ".xlsx", false, 2, (Object) null)) {
                return parseXlsx(inputStream, fileName);
            }
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String readText = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                return parseCsvOrTsv(readText, fileName);
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return parseCsvOrTsv(sampleCsvData, fileName);
        }
    }

    /* JADX WARN: Finally extract failed */
    public final ParsedExcelSheet parseXlsx(InputStream inputStream, String fileName) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        List sharedStrings = new ArrayList();
        String str = null;
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        try {
            ZipInputStream zipInputStream2 = zipInputStream;
            for (ZipEntry nextEntry = zipInputStream2.getNextEntry(); nextEntry != null; nextEntry = zipInputStream2.getNextEntry()) {
                String name = nextEntry.getName();
                if (Intrinsics.areEqual(name, "xl/sharedStrings.xml")) {
                    sharedStrings.addAll(INSTANCE.extractSharedStrings(new String(ByteStreamsKt.readBytes(zipInputStream2), Charsets.UTF_8)));
                } else if (Intrinsics.areEqual(name, "xl/worksheets/sheet1.xml")) {
                    str = new String(ByteStreamsKt.readBytes(zipInputStream2), Charsets.UTF_8);
                }
                zipInputStream2.closeEntry();
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(zipInputStream, (Throwable) null);
            if (str != null) {
                List rawRows = extractSheetRows(str, sharedStrings);
                if (!rawRows.isEmpty()) {
                    List headers = (List) CollectionsKt.first(rawRows);
                    Iterable drop = CollectionsKt.drop(rawRows, 1);
                    Collection arrayList = new ArrayList();
                    for (Object obj : drop) {
                        Iterable iterable = (List) obj;
                        List rawRows2 = rawRows;
                        boolean z = false;
                        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                            Iterator it = iterable.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                if (!StringsKt.isBlank((String) it.next())) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        if (z) {
                            arrayList.add(obj);
                        }
                        rawRows = rawRows2;
                    }
                    List dataRows = (List) arrayList;
                    return new ParsedExcelSheet(fileName, headers, dataRows);
                }
            }
            return parseCsvOrTsv(sampleCsvData, fileName);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(zipInputStream, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x002c. Please report as an issue. */
    private final List<String> extractSharedStrings(String xml) {
        XmlPullParser parser;
        int eventType;
        boolean inT;
        StringBuilder currentText;
        List strings = new ArrayList();
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();
            parser.setInput(new StringReader(xml));
            inT = false;
            currentText = new StringBuilder();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (eventType = parser.getEventType(); eventType != 1; eventType = parser.next()) {
            switch (eventType) {
                case 2:
                    if (Intrinsics.areEqual(parser.getName(), "t")) {
                        inT = true;
                        currentText.setLength(0);
                    }
                case 3:
                    if (Intrinsics.areEqual(parser.getName(), "t")) {
                        inT = false;
                        String sb = currentText.toString();
                        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
                        strings.add(sb);
                    }
                case 4:
                    if (inT) {
                        currentText.append(parser.getText());
                    }
                default:
            }
            return strings;
        }
        return strings;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0064. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:74:0x0122. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0040. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00df A[Catch: Exception -> 0x017e, TryCatch #0 {Exception -> 0x017e, blocks: (B:6:0x001b, B:19:0x0049, B:22:0x0058, B:24:0x005e, B:25:0x0064, B:27:0x0069, B:30:0x0071, B:32:0x0077, B:34:0x0085, B:35:0x0089, B:37:0x0095, B:40:0x00a2, B:42:0x00a7, B:44:0x00aa, B:46:0x00b5, B:49:0x00c3, B:51:0x00df, B:53:0x00e5, B:56:0x00ed, B:60:0x00fb, B:62:0x0108, B:67:0x00bc, B:71:0x0118, B:73:0x011e, B:74:0x0122, B:77:0x0128, B:79:0x012e, B:81:0x0137, B:84:0x0145, B:85:0x013e, B:88:0x014d, B:91:0x0156), top: B:5:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0108 A[Catch: Exception -> 0x017e, TryCatch #0 {Exception -> 0x017e, blocks: (B:6:0x001b, B:19:0x0049, B:22:0x0058, B:24:0x005e, B:25:0x0064, B:27:0x0069, B:30:0x0071, B:32:0x0077, B:34:0x0085, B:35:0x0089, B:37:0x0095, B:40:0x00a2, B:42:0x00a7, B:44:0x00aa, B:46:0x00b5, B:49:0x00c3, B:51:0x00df, B:53:0x00e5, B:56:0x00ed, B:60:0x00fb, B:62:0x0108, B:67:0x00bc, B:71:0x0118, B:73:0x011e, B:74:0x0122, B:77:0x0128, B:79:0x012e, B:81:0x0137, B:84:0x0145, B:85:0x013e, B:88:0x014d, B:91:0x0156), top: B:5:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<java.util.List<java.lang.String>> extractSheetRows(java.lang.String r19, java.util.List<java.lang.String> r20) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.FireEquipmentExcelParser.extractSheetRows(java.lang.String, java.util.List):java.util.List");
    }

    private final int columnNameToIndex(String cellRef) {
        int i;
        String str = cellRef;
        int i2 = 0;
        int length = str.length();
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (Character.isLetter(str.charAt(i2))) {
                i2++;
            } else {
                String substring = str.substring(0, i2);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                str = substring;
                break;
            }
        }
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String colLetters = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(colLetters, "toUpperCase(...)");
        if (colLetters.length() == 0) {
            return -1;
        }
        int result = 0;
        int length2 = colLetters.length();
        for (i = 0; i < length2; i++) {
            char ch = colLetters.charAt(i);
            result = (result * 26) + (ch - 'A') + 1;
        }
        return result - 1;
    }

    public static /* synthetic */ ParsedExcelSheet parseCsvOrTsv$default(FireEquipmentExcelParser fireEquipmentExcelParser, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "Pasted_Inventory.csv";
        }
        return fireEquipmentExcelParser.parseCsvOrTsv(str, str2);
    }

    public final ParsedExcelSheet parseCsvOrTsv(String rawText, String fileName) {
        char delimiter;
        boolean z;
        Intrinsics.checkNotNullParameter(rawText, "rawText");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Iterable lines = StringsKt.lines(rawText);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(lines, 10));
        Iterator it = lines.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((String) it.next()).toString());
        }
        Collection arrayList2 = new ArrayList();
        for (Object obj : (List) arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List lines2 = (List) arrayList2;
        if (lines2.isEmpty()) {
            return new ParsedExcelSheet(fileName, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }
        CharSequence firstLine = (String) CollectionsKt.first(lines2);
        CharSequence charSequence = firstLine;
        int i = 0;
        int i2 = 0;
        while (true) {
            delimiter = '\t';
            if (i2 >= charSequence.length()) {
                break;
            }
            if (charSequence.charAt(i2) == '\t') {
                i++;
            }
            i2++;
        }
        if (i < 2) {
            CharSequence charSequence2 = firstLine;
            int i3 = 0;
            for (int i4 = 0; i4 < charSequence2.length(); i4++) {
                if (charSequence2.charAt(i4) == ';') {
                    i3++;
                }
            }
            delimiter = i3 >= 2 ? ';' : ',';
        }
        List list = lines2;
        Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(INSTANCE.parseLineWithQuotes((String) it2.next(), delimiter));
        }
        List parsedLines = (List) arrayList3;
        List headers = (List) CollectionsKt.first(parsedLines);
        Iterable drop = CollectionsKt.drop(parsedLines, 1);
        Collection arrayList4 = new ArrayList();
        for (Object obj2 : drop) {
            Iterable iterable = (List) obj2;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it3 = iterable.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (!StringsKt.isBlank((String) it3.next())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            } else {
                z = false;
            }
            if (z) {
                arrayList4.add(obj2);
            }
        }
        List dataRows = (List) arrayList4;
        return new ParsedExcelSheet(fileName, headers, dataRows);
    }

    private final List<String> parseLineWithQuotes(String line, char delimiter) {
        List tokens = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;
        int i = 0;
        while (i < line.length()) {
            char c = line.charAt(i);
            if (c == '\"') {
                if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '\"') {
                    sb.append('\"');
                    i++;
                } else {
                    inQuotes = inQuotes ? false : true;
                }
            } else if (c == delimiter && !inQuotes) {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                tokens.add(StringsKt.trim(sb2).toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
            i++;
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        tokens.add(StringsKt.trim(sb3).toString());
        return tokens;
    }

    public final ExcelColumnMapping autoDetectMapping(List<String> headers) {
        List<String> list;
        int category;
        int feNo;
        String str;
        Intrinsics.checkNotNullParameter(headers, "headers");
        int feNo2 = -1;
        int category2 = -1;
        int location = -1;
        int typeAndCapacity = -1;
        int classesOfFire = -1;
        int refillDate = -1;
        int refillDueDate = -1;
        int hptDate = -1;
        int hptDueDate = -1;
        int status = -1;
        int remarks = -1;
        int missingSpares = -1;
        List<String> list2 = headers;
        int i = 0;
        int i2 = 0;
        Iterator it = list2.iterator();
        while (true) {
            Iterable iterable = list2;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int i4 = i;
            Locale locale = Locale.ROOT;
            int i5 = i2;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            String lowerCase = ((String) next).toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String replace$default = StringsKt.replace$default(StringsKt.replace$default(lowerCase, "_", " ", false, 4, (Object) null), "-", " ", false, 4, (Object) null);
            if (feNo2 == -1) {
                feNo = feNo2;
                str = replace$default;
                if (StringsKt.contains$default(replace$default, "tag", false, 2, (Object) null) || StringsKt.contains$default(str, "fe no", false, 2, (Object) null) || StringsKt.contains$default(str, "feno", false, 2, (Object) null) || StringsKt.contains$default(str, "equipment id", false, 2, (Object) null) || StringsKt.contains$default(str, "equipment no", false, 2, (Object) null) || StringsKt.contains$default(str, "item no", false, 2, (Object) null) || StringsKt.contains$default(str, "serial", false, 2, (Object) null)) {
                    feNo2 = i5;
                    list2 = iterable;
                    i2 = i3;
                    i = i4;
                }
            } else {
                feNo = feNo2;
                str = replace$default;
            }
            if (category2 == -1 && (StringsKt.contains$default(str, "category", false, 2, (Object) null) || StringsKt.contains$default(str, "section", false, 2, (Object) null) || StringsKt.contains$default(str, "system type", false, 2, (Object) null) || StringsKt.contains$default(str, "equipment group", false, 2, (Object) null))) {
                category2 = i5;
                feNo2 = feNo;
            } else if (location == -1 && (StringsKt.contains$default(str, "location", false, 2, (Object) null) || StringsKt.contains$default(str, "area", false, 2, (Object) null) || StringsKt.contains$default(str, "place", false, 2, (Object) null) || StringsKt.contains$default(str, "dept", false, 2, (Object) null) || StringsKt.contains$default(str, "department", false, 2, (Object) null) || StringsKt.contains$default(str, "floor", false, 2, (Object) null) || StringsKt.contains$default(str, "zone", false, 2, (Object) null))) {
                location = i5;
                feNo2 = feNo;
            } else if (typeAndCapacity == -1 && (StringsKt.contains$default(str, "type", false, 2, (Object) null) || StringsKt.contains$default(str, "capacity", false, 2, (Object) null) || StringsKt.contains$default(str, "model", false, 2, (Object) null) || StringsKt.contains$default(str, "description", false, 2, (Object) null) || StringsKt.contains$default(str, "size", false, 2, (Object) null))) {
                typeAndCapacity = i5;
                feNo2 = feNo;
            } else if (classesOfFire == -1 && (StringsKt.contains$default(str, "class", false, 2, (Object) null) || StringsKt.contains$default(str, "spec", false, 2, (Object) null) || StringsKt.contains$default(str, "rating", false, 2, (Object) null) || StringsKt.contains$default(str, "fire class", false, 2, (Object) null) || StringsKt.contains$default(str, "medium", false, 2, (Object) null))) {
                classesOfFire = i5;
                feNo2 = feNo;
            } else if (refillDueDate == -1 && (StringsKt.contains$default(str, "refill due", false, 2, (Object) null) || StringsKt.contains$default(str, "next due", false, 2, (Object) null) || StringsKt.contains$default(str, "inspection due", false, 2, (Object) null) || StringsKt.contains$default(str, "service due", false, 2, (Object) null))) {
                refillDueDate = i5;
                feNo2 = feNo;
            } else if (refillDate == -1 && (StringsKt.contains$default(str, "refill", false, 2, (Object) null) || StringsKt.contains$default(str, "last inspection", false, 2, (Object) null) || StringsKt.contains$default(str, "installed date", false, 2, (Object) null) || StringsKt.contains$default(str, "service date", false, 2, (Object) null))) {
                refillDate = i5;
                feNo2 = feNo;
            } else if (hptDueDate == -1 && (StringsKt.contains$default(str, "hpt due", false, 2, (Object) null) || StringsKt.contains$default(str, "pressure test due", false, 2, (Object) null) || StringsKt.contains$default(str, "hydro due", false, 2, (Object) null))) {
                hptDueDate = i5;
                feNo2 = feNo;
            } else if (hptDate == -1 && (StringsKt.contains$default(str, "hpt", false, 2, (Object) null) || StringsKt.contains$default(str, "hydro", false, 2, (Object) null) || StringsKt.contains$default(str, "pressure test", false, 2, (Object) null))) {
                hptDate = i5;
                feNo2 = feNo;
            } else if (status == -1 && (StringsKt.contains$default(str, "status", false, 2, (Object) null) || StringsKt.contains$default(str, "condition", false, 2, (Object) null) || StringsKt.contains$default(str, "health", false, 2, (Object) null))) {
                status = i5;
                feNo2 = feNo;
            } else if (remarks == -1 && (StringsKt.contains$default(str, "remark", false, 2, (Object) null) || StringsKt.contains$default(str, "note", false, 2, (Object) null) || StringsKt.contains$default(str, "comment", false, 2, (Object) null) || StringsKt.contains$default(str, "observation", false, 2, (Object) null))) {
                remarks = i5;
                feNo2 = feNo;
            } else if (missingSpares == -1 && (StringsKt.contains$default(str, "spare", false, 2, (Object) null) || StringsKt.contains$default(str, "defect", false, 2, (Object) null) || StringsKt.contains$default(str, "issue", false, 2, (Object) null) || StringsKt.contains$default(str, "missing", false, 2, (Object) null))) {
                missingSpares = i5;
                feNo2 = feNo;
            } else {
                feNo2 = feNo;
            }
            list2 = iterable;
            i2 = i3;
            i = i4;
        }
        if (feNo2 == -1 && !headers.isEmpty()) {
            feNo2 = 0;
        }
        if (category2 != -1 || headers.size() <= 1) {
            list = headers;
        } else {
            list = headers;
            if (StringsKt.contains(list.get(1), "type", true) || StringsKt.contains(list.get(1), "name", true)) {
                category = 1;
                return new ExcelColumnMapping(feNo2, category, (location == -1 || list.size() <= 2) ? location : 2, typeAndCapacity, classesOfFire, refillDate, refillDueDate, hptDate, hptDueDate, status, remarks, missingSpares);
            }
        }
        category = category2;
        return new ExcelColumnMapping(feNo2, category, (location == -1 || list.size() <= 2) ? location : 2, typeAndCapacity, classesOfFire, refillDate, refillDueDate, hptDate, hptDueDate, status, remarks, missingSpares);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x04be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.example.utils.ValidatedImportRecord> validateAndBuildRecords(com.example.utils.ParsedExcelSheet r57, com.example.utils.ExcelColumnMapping r58, long r59, java.lang.String r61, java.util.List<com.example.data.FireExtinguisher> r62) {
        /*
            Method dump skipped, instructions count: 1256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.FireEquipmentExcelParser.validateAndBuildRecords(com.example.utils.ParsedExcelSheet, com.example.utils.ExcelColumnMapping, long, java.lang.String, java.util.List):java.util.List");
    }

    private static final String validateAndBuildRecords$lambda$22$getCol(List<String> list, int colIdx) {
        boolean z = false;
        if (colIdx >= 0 && colIdx < list.size()) {
            z = true;
        }
        return z ? StringsKt.trim(list.get(colIdx)).toString() : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence validateAndBuildRecords$lambda$22$lambda$21(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "\"" + StringsKt.replace$default(it, "\"", "\\\"", false, 4, (Object) null) + "\"";
    }

    public final String getSampleCsvData() {
        return sampleCsvData;
    }
}
