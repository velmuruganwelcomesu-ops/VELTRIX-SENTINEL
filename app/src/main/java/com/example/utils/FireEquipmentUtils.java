package com.example.utils;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckCircleKt;
import androidx.compose.material.icons.filled.ErrorKt;
import androidx.compose.material.icons.filled.HourglassTopKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.example.data.FireExtinguisher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: FireEquipmentUtils.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\u0006\u0010&\u001a\u00020\u0005J\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\u0006\u0010&\u001a\u00020\u0005J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\u0006\u0010&\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005J\u000e\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u000201J\u000e\u00103\u001a\u00020\u00052\u0006\u00100\u001a\u000201J(\u00104\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\f\u00105\u001a\b\u0012\u0004\u0012\u0002010\u00142\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0005J\u001c\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000209\u0018\u0001082\u0006\u0010:\u001a\u00020\u0005J\u0010\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0005J\u001a\u0010B\u001a\u00020\u00052\b\u0010C\u001a\u0004\u0018\u00010\u00052\b\u0010A\u001a\u0004\u0018\u00010\u0005J\u001a\u0010D\u001a\u00020\u00052\b\u0010E\u001a\u0004\u0018\u00010\u00052\b\u0010F\u001a\u0004\u0018\u00010\u0005J\u001a\u0010G\u001a\u00020\u00052\b\u0010E\u001a\u0004\u0018\u00010\u00052\b\u0010F\u001a\u0004\u0018\u00010\u0005J\u0015\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0005¢\u0006\u0004\bK\u0010LJ\u0015\u0010M\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0005¢\u0006\u0004\bN\u0010LJ\u000e\u0010O\u001a\u00020P2\u0006\u0010J\u001a\u00020\u0005J\u0014\u0010Q\u001a\u00020\u00052\f\u0010R\u001a\b\u0012\u0004\u0012\u0002010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0016R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0016R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0016R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0016¨\u0006S"}, d2 = {"Lcom/example/utils/FireEquipmentUtils;", "", "<init>", "()V", "STATUS_OK", "", "STATUS_EXPIRING_SOON", "STATUS_EXPIRED", "CATEGORY_ALL", "CATEGORY_HYDRANTS", "CATEGORY_HOSE_REELS", "CATEGORY_DETECTORS_AND_PANELS", "CATEGORY_MCP", "CATEGORY_HOOTERS", "CATEGORY_EXIT_LIGHTS", "CATEGORY_EXTINGUISHERS", "CATEGORY_SPRINKLERS", "CATEGORY_FIRE_PUMPS", "CATEGORY_OTHER", "ALL_CATEGORIES", "", "getALL_CATEGORIES", "()Ljava/util/List;", "COMMON_EXTINGUISHER_TYPES", "getCOMMON_EXTINGUISHER_TYPES", "COMMON_HYDRANT_TYPES", "getCOMMON_HYDRANT_TYPES", "COMMON_HOSE_REEL_TYPES", "getCOMMON_HOSE_REEL_TYPES", "COMMON_DETECTOR_AND_PANEL_TYPES", "getCOMMON_DETECTOR_AND_PANEL_TYPES", "COMMON_MCP_TYPES", "getCOMMON_MCP_TYPES", "COMMON_HOOTER_TYPES", "getCOMMON_HOOTER_TYPES", "COMMON_EXIT_LIGHT_TYPES", "getCOMMON_EXIT_LIGHT_TYPES", "getCategoryTypes", "category", "getCategoryFireClassesOrSpecs", "getCategoryDefectsOrSpares", "normalizeCategory", "raw", "FIRE_PUMP_TYPES", "getFIRE_PUMP_TYPES", "FIRE_PUMP_HP_CAPACITIES", "getFIRE_PUMP_HP_CAPACITIES", "getEquipmentQty", "item", "Lcom/example/data/FireExtinguisher;", "getFirePumpType", "getFirePumpHp", "generateNextTagForCategory", "existingList", "subType", "extractPrefixAndNumber", "Lkotlin/Pair;", "", "tag", "COMMON_FIRE_CLASSES", "getCOMMON_FIRE_CLASSES", "SPARE_QUICK_TAGS", "getSPARE_QUICK_TAGS", "isCo2Type", "", "typeAndCapacity", "calculateHptDueDate", "hptDateStr", "computeStatus", "refillDueDateStr", "hptDueDateStr", "getStatusBreakdown", "getStatusColor", "Landroidx/compose/ui/graphics/Color;", "status", "getStatusColor-vNxB06k", "(Ljava/lang/String;)J", "getStatusBadgeBgColor", "getStatusBadgeBgColor-vNxB06k", "getStatusIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "generateNextFeNo", "existingExtinguishers", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class FireEquipmentUtils {
    public static final String CATEGORY_ALL = "All Equipment";
    public static final String CATEGORY_HYDRANTS = "Fire Hydrants";
    public static final String STATUS_EXPIRED = "Expired";
    public static final String STATUS_EXPIRING_SOON = "Expiring Soon";
    public static final String STATUS_OK = "OK";
    public static final FireEquipmentUtils INSTANCE = new FireEquipmentUtils();
    public static final String CATEGORY_HOSE_REELS = "Fire Hose Reels";
    public static final String CATEGORY_DETECTORS_AND_PANELS = "Smoke Detectors & Fire Alarm Panels";
    public static final String CATEGORY_MCP = "MCP (Manual Call Points)";
    public static final String CATEGORY_HOOTERS = "Hooters";
    public static final String CATEGORY_EXIT_LIGHTS = "Exit Lights";
    public static final String CATEGORY_EXTINGUISHERS = "Fire Extinguishers";
    public static final String CATEGORY_SPRINKLERS = "Sprinklers";
    public static final String CATEGORY_FIRE_PUMPS = "Fire Pumps";
    public static final String CATEGORY_OTHER = "Other Fire Equipment";
    private static final List<String> ALL_CATEGORIES = CollectionsKt.listOf(new String[]{"Fire Hydrants", CATEGORY_HOSE_REELS, CATEGORY_DETECTORS_AND_PANELS, CATEGORY_MCP, CATEGORY_HOOTERS, CATEGORY_EXIT_LIGHTS, CATEGORY_EXTINGUISHERS, CATEGORY_SPRINKLERS, CATEGORY_FIRE_PUMPS, CATEGORY_OTHER});
    private static final List<String> COMMON_EXTINGUISHER_TYPES = CollectionsKt.listOf(new String[]{"CO2 4.5 Kg", "CO2 2 Kg", "CO2 6.5 Kg", "ABC Dry Chemical Powder 6 Kg", "ABC Dry Chemical Powder 4 Kg", "ABC Dry Chemical Powder 9 Kg", "Mechanical Foam (AFFF) 9 L", "Water CO2 9 L", "Clean Agent (FE-36) 2 Kg", "Clean Agent (FE-36) 4 Kg", "DCP Metal Fire (Class D) 9 Kg"});
    private static final List<String> COMMON_HYDRANT_TYPES = CollectionsKt.listOf(new String[]{"Single Landing Valve (63mm)", "Double Landing Valve (63mm)", "Pillar Hydrant (100mm)", "Hydrant Ring Header Post", "Pressure Reducing Valve (PRV)", "Four-Way Fire Brigade Breeching Inlet"});
    private static final List<String> COMMON_HOSE_REEL_TYPES = CollectionsKt.listOf(new String[]{"Swinging Drum Hose Reel (30m x 19mm)", "Fixed Drum Hose Reel (36m x 25mm)", "Automatic Hose Reel with Shut-off Jet Nozzle", "Recessed Cabinet Hose Reel (30m)", "High-Pressure Rubber Hose Reel (40m)"});
    private static final List<String> COMMON_DETECTOR_AND_PANEL_TYPES = CollectionsKt.listOf(new String[]{"Addressable Fire Alarm Panel (4 Loops, 500 Points)", "Conventional Fire Alarm Panel (8 Zones)", "Conventional Fire Alarm Panel (16 Zones)", "Repeater Fire Alarm Panel (Gatehouse)", "Optical Smoke Detector (Addressable)", "Multi-Sensor Smoke & Heat Detector", "Rate-of-Rise Heat Detector", "Beam Smoke Detector (High Bay Warehouse)"});
    private static final List<String> COMMON_MCP_TYPES = CollectionsKt.listOf(new String[]{"Break Glass Call Point (Conventional Red)", "Addressable Resettable Key Call Point (IP67)", "Weatherproof Outdoor Push Button MCP", "Explosion-Proof MCP (Zone 1/2 Hazardous)", "Lift Lobby Evacuation Call Point"});
    private static final List<String> COMMON_HOOTER_TYPES = CollectionsKt.listOf(new String[]{"Electronic Fire Hooter with Strobe (105 dB)", "Dual Tone Industrial Sounder (115 dB)", "Motor Siren (High Decibel Exterior)", "Flameproof Flashing Strobe Hooter", "Multi-Tone Directional Sounder"});
    private static final List<String> COMMON_EXIT_LIGHT_TYPES = CollectionsKt.listOf(new String[]{"Edge-Lit LED Emergency Exit Sign (Double Sided)", "Maintained Bulkhead Exit Light (3-Hour Ni-Cd Battery)", "Photoluminescent Running Man Egress Indicator", "Weatherproof IP65 Emergency Exit Luminaire", "Recessed Ceiling Mounted Exit Sign"});
    private static final List<String> FIRE_PUMP_TYPES = CollectionsKt.listOf(new String[]{"Main Pump", "Jockey Pump", "Diesel Pump", "Booster Pump", "Sprinkler Pump", "Standby Electric Pump"});
    private static final List<String> FIRE_PUMP_HP_CAPACITIES = CollectionsKt.listOf(new String[]{"150 HP", "180 HP", "110 HP", "75 HP", "50 HP", "25 HP", "15 HP", "10 HP"});
    private static final List<String> COMMON_FIRE_CLASSES = CollectionsKt.listOf(new String[]{"Class A (Solids: Wood/Paper)", "Class B (Flammable Liquids)", "Class C (Flammable Gases)", "Class D (Combustible Metals)", "Electrical Fires"});
    private static final List<String> SPARE_QUICK_TAGS = CollectionsKt.listOf(new String[]{"Missing Pin", "Missing Hose", "Missing Gauge", "Seal Broken", "Pressure Gauge Low", "Defective Nozzle", "Inspection Tag Missing", "Mounting Bracket Loose", "Obstruction in Front", "Corrosion on Body"});
    public static final int $stable = 8;

    private FireEquipmentUtils() {
    }

    public final List<String> getALL_CATEGORIES() {
        return ALL_CATEGORIES;
    }

    public final List<String> getCOMMON_EXTINGUISHER_TYPES() {
        return COMMON_EXTINGUISHER_TYPES;
    }

    public final List<String> getCOMMON_HYDRANT_TYPES() {
        return COMMON_HYDRANT_TYPES;
    }

    public final List<String> getCOMMON_HOSE_REEL_TYPES() {
        return COMMON_HOSE_REEL_TYPES;
    }

    public final List<String> getCOMMON_DETECTOR_AND_PANEL_TYPES() {
        return COMMON_DETECTOR_AND_PANEL_TYPES;
    }

    public final List<String> getCOMMON_MCP_TYPES() {
        return COMMON_MCP_TYPES;
    }

    public final List<String> getCOMMON_HOOTER_TYPES() {
        return COMMON_HOOTER_TYPES;
    }

    public final List<String> getCOMMON_EXIT_LIGHT_TYPES() {
        return COMMON_EXIT_LIGHT_TYPES;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000f. Please report as an issue. */
    public final List<String> getCategoryTypes(String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        switch (category.hashCode()) {
            case -2142294027:
                if (category.equals("Fire Hydrants")) {
                    return COMMON_HYDRANT_TYPES;
                }
                return COMMON_EXTINGUISHER_TYPES;
            case -1788437604:
                if (category.equals(CATEGORY_MCP)) {
                    return COMMON_MCP_TYPES;
                }
                return COMMON_EXTINGUISHER_TYPES;
            case -1535308646:
                if (category.equals(CATEGORY_HOOTERS)) {
                    return COMMON_HOOTER_TYPES;
                }
                return COMMON_EXTINGUISHER_TYPES;
            case -1432693921:
                if (category.equals(CATEGORY_EXIT_LIGHTS)) {
                    return COMMON_EXIT_LIGHT_TYPES;
                }
                return COMMON_EXTINGUISHER_TYPES;
            case -935325909:
                if (category.equals(CATEGORY_SPRINKLERS)) {
                    return CollectionsKt.listOf(new String[]{"Pendant Sprinkler Head (68°C / 155°F)", "Upright Sprinkler Head (68°C)", "Sidewall Sprinkler Head (79°C)", "Concealed Quick Response Sprinkler (57°C)", "ESFR High Bay Storage Sprinkler"});
                }
                return COMMON_EXTINGUISHER_TYPES;
            case -728054692:
                if (category.equals(CATEGORY_HOSE_REELS)) {
                    return COMMON_HOSE_REEL_TYPES;
                }
                return COMMON_EXTINGUISHER_TYPES;
            case -126151519:
                if (category.equals(CATEGORY_FIRE_PUMPS)) {
                    return CollectionsKt.listOf(new String[]{"Main Electric Fire Pump (2850 RPM, 150 kW)", "Diesel Engine Driven Fire Pump (Automatic Start)", "Jockey Pump (Pressure Maintenance, 15 kW)", "Hydrant Dedicated Booster Pump (2200 LPM)", "Sprinkler System Multi-Stage Fire Pump"});
                }
                return COMMON_EXTINGUISHER_TYPES;
            case 189864788:
                if (category.equals(CATEGORY_OTHER)) {
                    return CollectionsKt.listOf(new String[]{"Fire Safety Blanket (1.8m x 1.8m Fiberglass)", "Fire Bucket Stand (4x 9L Water & Sand)", "SCBA Breathing Apparatus (6.8L 300 Bar)", "Fire Proximity Suit (Aluminized)", "Foam Inductor & Branch Pipe Set (225 LPM)"});
                }
                return COMMON_EXTINGUISHER_TYPES;
            case 1031273866:
                if (category.equals(CATEGORY_DETECTORS_AND_PANELS)) {
                    return COMMON_DETECTOR_AND_PANEL_TYPES;
                }
                return COMMON_EXTINGUISHER_TYPES;
            default:
                return COMMON_EXTINGUISHER_TYPES;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000f. Please report as an issue. */
    public final List<String> getCategoryFireClassesOrSpecs(String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        switch (category.hashCode()) {
            case -2142294027:
                if (category.equals("Fire Hydrants")) {
                    return CollectionsKt.listOf(new String[]{"Operating Pressure: 7.0 kg/cm²", "Operating Pressure: 8.5 kg/cm²", "Flow Rate: 900 LPM", "Flow Rate: 1800 LPM", "Hydrostatic Test: 21 kg/cm²"});
                }
                return CollectionsKt.listOf(new String[]{"Class A (Solids: Wood/Paper)", "Class B (Flammable Liquids)", "Class C (Flammable Gases)", "Class D (Combustible Metals)", "Class B, C & Electrical", "Class A, B, C", "Electrical Fires"});
            case -1788437604:
                if (category.equals(CATEGORY_MCP)) {
                    return CollectionsKt.listOf(new String[]{"Zone 1 Conventional", "Loop 1 Addressable", "Push-Break Frangible Element", "Key-Reset Mechanism with LED"});
                }
                return CollectionsKt.listOf(new String[]{"Class A (Solids: Wood/Paper)", "Class B (Flammable Liquids)", "Class C (Flammable Gases)", "Class D (Combustible Metals)", "Class B, C & Electrical", "Class A, B, C", "Electrical Fires"});
            case -1535308646:
                if (category.equals(CATEGORY_HOOTERS)) {
                    return CollectionsKt.listOf(new String[]{"Output: 105 dB(A) @ 1m", "Output: 115 dB(A) @ 1m", "Xenon Red Flasher 2.5 Joules", "Synchronized Multi-Zone Tone"});
                }
                return CollectionsKt.listOf(new String[]{"Class A (Solids: Wood/Paper)", "Class B (Flammable Liquids)", "Class C (Flammable Gases)", "Class D (Combustible Metals)", "Class B, C & Electrical", "Class A, B, C", "Electrical Fires"});
            case -1432693921:
                if (category.equals(CATEGORY_EXIT_LIGHTS)) {
                    return CollectionsKt.listOf(new String[]{"3-Hour Battery Inverter Backup", "Green LED Matrix Viewing 25m", "Self-Testing Diagnostics (Maintained)", "Non-Maintained 90-min Backup"});
                }
                return CollectionsKt.listOf(new String[]{"Class A (Solids: Wood/Paper)", "Class B (Flammable Liquids)", "Class C (Flammable Gases)", "Class D (Combustible Metals)", "Class B, C & Electrical", "Class A, B, C", "Electrical Fires"});
            case -935325909:
                if (category.equals(CATEGORY_SPRINKLERS)) {
                    return CollectionsKt.listOf(new String[]{"K-Factor: 5.6 (80 LPM/√bar)", "K-Factor: 8.0 (115 LPM/√bar)", "Working Pressure: 12 bar", "Glass Bulb: Red (68°C / 155°F)", "Coverage Area: 12 m²"});
                }
                return CollectionsKt.listOf(new String[]{"Class A (Solids: Wood/Paper)", "Class B (Flammable Liquids)", "Class C (Flammable Gases)", "Class D (Combustible Metals)", "Class B, C & Electrical", "Class A, B, C", "Electrical Fires"});
            case -728054692:
                if (category.equals(CATEGORY_HOSE_REELS)) {
                    return CollectionsKt.listOf(new String[]{"Working Pressure: 12 kg/cm²", "Jet Throw: >6 meters", "Flow Rate: 24 LPM @ 2 bar", "Burst Pressure: 30 bar"});
                }
                return CollectionsKt.listOf(new String[]{"Class A (Solids: Wood/Paper)", "Class B (Flammable Liquids)", "Class C (Flammable Gases)", "Class D (Combustible Metals)", "Class B, C & Electrical", "Class A, B, C", "Electrical Fires"});
            case -126151519:
                if (category.equals(CATEGORY_FIRE_PUMPS)) {
                    return CollectionsKt.listOf(new String[]{"Rated Flow: 2850 LPM @ 7 bar", "Rated Flow: 3500 LPM @ 10 bar", "Driver: Electric Motor 110 kW 415V", "Driver: Diesel Engine 180 HP 1500 RPM", "System Cut-in: 7.0 bar / Cut-out: 8.5 bar"});
                }
                return CollectionsKt.listOf(new String[]{"Class A (Solids: Wood/Paper)", "Class B (Flammable Liquids)", "Class C (Flammable Gases)", "Class D (Combustible Metals)", "Class B, C & Electrical", "Class A, B, C", "Electrical Fires"});
            case 189864788:
                if (category.equals(CATEGORY_OTHER)) {
                    return CollectionsKt.listOf(new String[]{"EN 1869:2019 Certified", "Working Pressure: 300 Bar (SCBA)", "Cylinder Capacity: 6.8L Composite", "Reflective Thermal Shield up to 1000°C", "IS 2546 Fire Sand Buckets (Red)"});
                }
                return CollectionsKt.listOf(new String[]{"Class A (Solids: Wood/Paper)", "Class B (Flammable Liquids)", "Class C (Flammable Gases)", "Class D (Combustible Metals)", "Class B, C & Electrical", "Class A, B, C", "Electrical Fires"});
            case 1031273866:
                if (category.equals(CATEGORY_DETECTORS_AND_PANELS)) {
                    return CollectionsKt.listOf(new String[]{"24V DC Standby Battery (2x12V 26Ah)", "Loop 1 - SLC Circuit", "Loop 2 - SLC Circuit", "Dual Wavelength Optical Sensing", "NFPA 72 Sensitivity Compliant"});
                }
                return CollectionsKt.listOf(new String[]{"Class A (Solids: Wood/Paper)", "Class B (Flammable Liquids)", "Class C (Flammable Gases)", "Class D (Combustible Metals)", "Class B, C & Electrical", "Class A, B, C", "Electrical Fires"});
            default:
                return CollectionsKt.listOf(new String[]{"Class A (Solids: Wood/Paper)", "Class B (Flammable Liquids)", "Class C (Flammable Gases)", "Class D (Combustible Metals)", "Class B, C & Electrical", "Class A, B, C", "Electrical Fires"});
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0013. Please report as an issue. */
    public final List<String> getCategoryDefectsOrSpares(String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        switch (category.hashCode()) {
            case -2142294027:
                if (category.equals("Fire Hydrants")) {
                    return CollectionsKt.listOf(new String[]{"Blank Cap Missing", "Chained Pin Broken", "Handwheel Stiff / Damaged", "Gasket Leakage", "Lug Damaged", "Pressure Drop Below 7 kg/cm²", "Branch Pipe Missing", "Hydrant Box Lock Broken"});
                }
                return SPARE_QUICK_TAGS;
            case -1788437604:
                if (category.equals(CATEGORY_MCP)) {
                    return CollectionsKt.listOf(new String[]{"Glass / Element Broken", "Test Key Missing", "Operating Hammer Missing", "Tamper Seal Broken", "LED Indicator Failed", "Mounting Box Damaged", "Cable Conduit Loose"});
                }
                return SPARE_QUICK_TAGS;
            case -1535308646:
                if (category.equals(CATEGORY_HOOTERS)) {
                    return CollectionsKt.listOf(new String[]{"Sound Output Low / Muffled", "Strobe Flasher Not Working", "Wiring Loose / Tampered", "Tone Generator Fault", "Mounting Base Cracked", "Audio Distortion"});
                }
                return SPARE_QUICK_TAGS;
            case -1432693921:
                if (category.equals(CATEGORY_EXIT_LIGHTS)) {
                    return CollectionsKt.listOf(new String[]{"Battery Backup Failed (0 min)", "LED Lamp Blown", "Charging Indicator Red", "Diffuser Panel Cracked", "Mounting Bracket Broken", "Autonomy Under 180 Mins", "Emergency Test Switch Stuck"});
                }
                return SPARE_QUICK_TAGS;
            case -935325909:
                if (category.equals(CATEGORY_SPRINKLERS)) {
                    return CollectionsKt.listOf(new String[]{"Deflector Bent / Damaged", "Glass Bulb Broken / Leaking", "Paint / Dust on Deflector", "Corrosion on Frame", "Sprinkler Wrench Missing", "Spare Sprinkler Cabinet Empty"});
                }
                return SPARE_QUICK_TAGS;
            case -728054692:
                if (category.equals(CATEGORY_HOSE_REELS)) {
                    return CollectionsKt.listOf(new String[]{"Nozzle Defective / Missing", "Drum Binding / Hard to Turn", "Hose Punctured / Cracked", "Inlet Valve Gland Leakage", "Mounting Bracket Loose", "Hose Guide Jammed", "Pressure Low"});
                }
                return SPARE_QUICK_TAGS;
            case -126151519:
                if (category.equals(CATEGORY_FIRE_PUMPS)) {
                    return CollectionsKt.listOf(new String[]{"Pump Gland Packing Leakage", "Diesel Starting Battery Low", "Pressure Relief Valve (PRV) Passing", "Automatic Start Controller Fault", "Fuel Tank Level Below 80%", "Suction Strainer Clogged", "Bearing Vibration / Overheating"});
                }
                return SPARE_QUICK_TAGS;
            case 189864788:
                if (category.equals(CATEGORY_OTHER)) {
                    return CollectionsKt.listOf(new String[]{"Fire Blanket Missing / Torn", "Bucket Sand Solidified / Wet", "SCBA Cylinder Pressure <270 Bar", "SCBA Face Mask Straps Perished", "Inspection Tag Missing", "Cabinet Seal Damaged / Jammed"});
                }
                return SPARE_QUICK_TAGS;
            case 1031273866:
                if (category.equals(CATEGORY_DETECTORS_AND_PANELS)) {
                    return CollectionsKt.listOf(new String[]{"Panel AC Mains Fail", "Standby Battery Low / Expired", "Loop Open Fault", "Detector Chamber Dusty", "False Alarm Trigger", "Repeater Communication Error", "Ground Fault Warning", "Zone Disconnected"});
                }
                return SPARE_QUICK_TAGS;
            default:
                return SPARE_QUICK_TAGS;
        }
    }

    public final String normalizeCategory(String raw) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        String obj = StringsKt.trim(raw).toString();
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lower = obj.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
        if (StringsKt.contains$default(lower, "hydrant", false, 2, (Object) null)) {
            return "Fire Hydrants";
        }
        if (StringsKt.contains$default(lower, "hose", false, 2, (Object) null) || StringsKt.contains$default(lower, "reel", false, 2, (Object) null)) {
            return CATEGORY_HOSE_REELS;
        }
        if (StringsKt.contains$default(lower, "panel", false, 2, (Object) null) || StringsKt.contains$default(lower, "smoke", false, 2, (Object) null) || StringsKt.contains$default(lower, "detector", false, 2, (Object) null) || StringsKt.contains$default(lower, "alarm", false, 2, (Object) null)) {
            return CATEGORY_DETECTORS_AND_PANELS;
        }
        if (StringsKt.contains$default(lower, "mcp", false, 2, (Object) null) || StringsKt.contains$default(lower, "call point", false, 2, (Object) null) || StringsKt.contains$default(lower, "manual call", false, 2, (Object) null)) {
            return CATEGORY_MCP;
        }
        if (StringsKt.contains$default(lower, "hooter", false, 2, (Object) null) || StringsKt.contains$default(lower, "sounder", false, 2, (Object) null) || StringsKt.contains$default(lower, "siren", false, 2, (Object) null)) {
            return CATEGORY_HOOTERS;
        }
        if (StringsKt.contains$default(lower, "exit", false, 2, (Object) null) || StringsKt.contains$default(lower, "light", false, 2, (Object) null) || StringsKt.contains$default(lower, "luminaire", false, 2, (Object) null) || StringsKt.contains$default(lower, "egress", false, 2, (Object) null)) {
            return CATEGORY_EXIT_LIGHTS;
        }
        if (StringsKt.contains$default(lower, "sprinkler", false, 2, (Object) null)) {
            return CATEGORY_SPRINKLERS;
        }
        if (StringsKt.contains$default(lower, "pump", false, 2, (Object) null)) {
            return CATEGORY_FIRE_PUMPS;
        }
        if (StringsKt.contains$default(lower, "other", false, 2, (Object) null) || StringsKt.contains$default(lower, "cabinet", false, 2, (Object) null) || StringsKt.contains$default(lower, "blanket", false, 2, (Object) null) || StringsKt.contains$default(lower, "bucket", false, 2, (Object) null) || StringsKt.contains$default(lower, "scba", false, 2, (Object) null)) {
            return CATEGORY_OTHER;
        }
        return CATEGORY_EXTINGUISHERS;
    }

    public final List<String> getFIRE_PUMP_TYPES() {
        return FIRE_PUMP_TYPES;
    }

    public final List<String> getFIRE_PUMP_HP_CAPACITIES() {
        return FIRE_PUMP_HP_CAPACITIES;
    }

    public final String getEquipmentQty(FireExtinguisher item) {
        List groupValues;
        String str;
        Intrinsics.checkNotNullParameter(item, "item");
        try {
            if (StringsKt.startsWith$default(item.getMissingSparesJson(), "{", false, 2, (Object) null)) {
                JSONObject obj = new JSONObject(item.getMissingSparesJson());
                if (obj.has("qty")) {
                    String string = obj.getString("qty");
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }
            }
        } catch (Exception e) {
        }
        MatchResult match = Regex.find$default(new Regex("\\b(?:Qty|QTY)[:\\s]*(\\d+)\\b"), item.getTypeAndCapacity(), 0, 2, (Object) null);
        if (match == null) {
            match = Regex.find$default(new Regex("\\b(?:Qty|QTY)[:\\s]*(\\d+)\\b"), item.getRemarks(), 0, 2, (Object) null);
        }
        return (match == null || (groupValues = match.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null) ? "1" : str;
    }

    public final String getFirePumpType(FireExtinguisher item) {
        Intrinsics.checkNotNullParameter(item, "item");
        String t = StringsKt.trim(item.getTypeAndCapacity()).toString();
        return StringsKt.contains(t, "Main", true) ? "Main Pump" : StringsKt.contains(t, "Jockey", true) ? "Jockey Pump" : StringsKt.contains(t, "Diesel", true) ? "Diesel Pump" : StringsKt.contains(t, "Booster", true) ? "Booster Pump" : StringsKt.contains(t, "Sprinkler", true) ? "Sprinkler Pump" : !StringsKt.isBlank(t) ? t : "Main Pump";
    }

    public final String getFirePumpHp(FireExtinguisher item) {
        Intrinsics.checkNotNullParameter(item, "item");
        try {
            if (StringsKt.startsWith$default(item.getMissingSparesJson(), "{", false, 2, (Object) null)) {
                JSONObject obj = new JSONObject(item.getMissingSparesJson());
                if (obj.has("hpCapacity")) {
                    String string = obj.getString("hpCapacity");
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }
            }
        } catch (Exception e) {
        }
        MatchResult match = Regex.find$default(new Regex("(\\d+\\s*(?:HP|kW|rpm))", RegexOption.IGNORE_CASE), item.getClassesOfFireUsed(), 0, 2, (Object) null);
        if (match == null) {
            match = Regex.find$default(new Regex("(\\d+\\s*(?:HP|kW|rpm))", RegexOption.IGNORE_CASE), item.getTypeAndCapacity(), 0, 2, (Object) null);
        }
        if (match != null) {
            return match.getValue();
        }
        if (!StringsKt.isBlank(item.getClassesOfFireUsed()) && !StringsKt.contains(item.getClassesOfFireUsed(), "Class", true)) {
            return item.getClassesOfFireUsed();
        }
        return "150 HP";
    }

    public static /* synthetic */ String generateNextTagForCategory$default(FireEquipmentUtils fireEquipmentUtils, String str, List list, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return fireEquipmentUtils.generateNextTagForCategory(str, list, str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String generateNextTagForCategory(java.lang.String r21, java.util.List<com.example.data.FireExtinguisher> r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.FireEquipmentUtils.generateNextTagForCategory(java.lang.String, java.util.List, java.lang.String):java.lang.String");
    }

    public final Pair<String, Integer> extractPrefixAndNumber(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        String trimmed = StringsKt.trim(tag).toString();
        MatchResult matchWithSeparator = Regex.find$default(new Regex("^([A-Za-z]+[-_\\s/]+)(\\d+)$"), trimmed, 0, 2, (Object) null);
        if (matchWithSeparator != null) {
            String prefix = (String) matchWithSeparator.getGroupValues().get(1);
            Integer intOrNull = StringsKt.toIntOrNull((String) matchWithSeparator.getGroupValues().get(2));
            if (intOrNull == null) {
                return null;
            }
            int num = intOrNull.intValue();
            return new Pair<>(prefix, Integer.valueOf(num));
        }
        MatchResult matchNoSeparator = Regex.find$default(new Regex("^([A-Za-z]+)(\\d+)$"), trimmed, 0, 2, (Object) null);
        if (matchNoSeparator == null) {
            return null;
        }
        String prefix2 = matchNoSeparator.getGroupValues().get(1) + "-";
        Integer intOrNull2 = StringsKt.toIntOrNull((String) matchNoSeparator.getGroupValues().get(2));
        if (intOrNull2 == null) {
            return null;
        }
        int num2 = intOrNull2.intValue();
        return new Pair<>(prefix2, Integer.valueOf(num2));
    }

    public final List<String> getCOMMON_FIRE_CLASSES() {
        return COMMON_FIRE_CLASSES;
    }

    public final List<String> getSPARE_QUICK_TAGS() {
        return SPARE_QUICK_TAGS;
    }

    public final boolean isCo2Type(String typeAndCapacity) {
        String str = typeAndCapacity;
        if (str == null || StringsKt.isBlank(str)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lower = typeAndCapacity.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
        return StringsKt.contains$default(lower, "co2", false, 2, (Object) null) || StringsKt.contains$default(lower, "carbon dioxide", false, 2, (Object) null);
    }

    public final String calculateHptDueDate(String hptDateStr, String typeAndCapacity) {
        Date parsed;
        String str = hptDateStr;
        if ((str == null || StringsKt.isBlank(str)) || (parsed = DateUtils.INSTANCE.parseDate(hptDateStr)) == null) {
            return "";
        }
        boolean isCo2 = isCo2Type(typeAndCapacity);
        int yearsToAdd = isCo2 ? 5 : 3;
        Calendar cal = Calendar.getInstance();
        cal.setTime(parsed);
        cal.add(1, yearsToAdd);
        return DateUtils.INSTANCE.formatToDdMmYyyy(cal.getTime());
    }

    public final String computeStatus(String refillDueDateStr, String hptDueDateStr) {
        String str = refillDueDateStr;
        boolean hasRefill = !(str == null || StringsKt.isBlank(str));
        String str2 = hptDueDateStr;
        boolean hasHpt = !(str2 == null || StringsKt.isBlank(str2));
        if (!hasRefill && !hasHpt) {
            return STATUS_OK;
        }
        long daysToRefill = hasRefill ? DateUtils.INSTANCE.getDaysUntil(refillDueDateStr) : Long.MAX_VALUE;
        long daysToHpt = hasHpt ? DateUtils.INSTANCE.getDaysUntil(hptDueDateStr) : Long.MAX_VALUE;
        if (daysToRefill < 0 || daysToHpt < 0) {
            return "Expired";
        }
        if (daysToRefill > 30 && daysToHpt > 30) {
            return STATUS_OK;
        }
        return STATUS_EXPIRING_SOON;
    }

    public final String getStatusBreakdown(String refillDueDateStr, String hptDueDateStr) {
        Long daysToRefill;
        String str = refillDueDateStr;
        boolean hasRefill = !(str == null || StringsKt.isBlank(str));
        String str2 = hptDueDateStr;
        boolean hasHpt = !(str2 == null || StringsKt.isBlank(str2));
        if (hasRefill) {
            daysToRefill = Long.valueOf(DateUtils.INSTANCE.getDaysUntil(refillDueDateStr));
        } else {
            daysToRefill = null;
        }
        Long daysToHpt = hasHpt ? Long.valueOf(DateUtils.INSTANCE.getDaysUntil(hptDueDateStr)) : null;
        List reasons = new ArrayList();
        if (daysToRefill != null) {
            if (daysToRefill.longValue() < 0) {
                reasons.add("Refill Overdue by " + (-daysToRefill.longValue()) + "d");
            } else if (daysToRefill.longValue() == 0) {
                reasons.add("Refill Due Today");
            } else if (daysToRefill.longValue() <= 30) {
                reasons.add("Refill Due in " + daysToRefill + "d");
            }
        }
        if (daysToHpt != null) {
            if (daysToHpt.longValue() < 0) {
                reasons.add("HPT Overdue by " + (-daysToHpt.longValue()) + "d");
            } else if (daysToHpt.longValue() == 0) {
                reasons.add("HPT Due Today");
            } else if (daysToHpt.longValue() <= 30) {
                reasons.add("HPT Due in " + daysToHpt + "d");
            }
        }
        return !reasons.isEmpty() ? CollectionsKt.joinToString$default(reasons, " • ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : "All Periodic Tests Valid";
    }

    /* renamed from: getStatusColor-vNxB06k, reason: not valid java name */
    public final long m6getStatusColorvNxB06k(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        return Intrinsics.areEqual(status, "Expired") ? ColorKt.Color(4292617766L) : Intrinsics.areEqual(status, STATUS_EXPIRING_SOON) ? ColorKt.Color(4292441862L) : ColorKt.Color(4279673674L);
    }

    /* renamed from: getStatusBadgeBgColor-vNxB06k, reason: not valid java name */
    public final long m5getStatusBadgeBgColorvNxB06k(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        return Intrinsics.areEqual(status, "Expired") ? ColorKt.Color(4294898418L) : Intrinsics.areEqual(status, STATUS_EXPIRING_SOON) ? ColorKt.Color(4294966251L) : ColorKt.Color(4293983732L);
    }

    public final ImageVector getStatusIcon(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        return Intrinsics.areEqual(status, "Expired") ? ErrorKt.getError(Icons.INSTANCE.getDefault()) : Intrinsics.areEqual(status, STATUS_EXPIRING_SOON) ? HourglassTopKt.getHourglassTop(Icons.INSTANCE.getDefault()) : CheckCircleKt.getCheckCircle(Icons.INSTANCE.getDefault());
    }

    public final String generateNextFeNo(List<FireExtinguisher> existingExtinguishers) {
        Integer num;
        MatchResult match;
        Intrinsics.checkNotNullParameter(existingExtinguishers, "existingExtinguishers");
        Regex feRegex = new Regex("\\bFE[-/\\s_]?(\\d+)\\b", RegexOption.IGNORE_CASE);
        int maxNum = 0;
        boolean foundFe = false;
        for (FireExtinguisher fe : existingExtinguishers) {
            String trimmed = StringsKt.trim(fe.getFeNo()).toString();
            if (!(trimmed.length() == 0) && (match = Regex.find$default(feRegex, trimmed, 0, 2, (Object) null)) != null) {
                foundFe = true;
                Integer num2 = StringsKt.toIntOrNull((String) match.getGroupValues().get(1));
                if (num2 != null && num2.intValue() > maxNum) {
                    maxNum = num2.intValue();
                }
            }
        }
        if (!foundFe) {
            Regex numRegex = new Regex("^(\\d+)$");
            for (FireExtinguisher fe2 : existingExtinguishers) {
                MatchResult match2 = Regex.find$default(numRegex, StringsKt.trim(fe2.getFeNo()).toString(), 0, 2, (Object) null);
                if (match2 != null && (num = StringsKt.toIntOrNull((String) match2.getGroupValues().get(1))) != null && num.intValue() > maxNum) {
                    maxNum = num.intValue();
                }
            }
        }
        int nextNum = maxNum + 1;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "FE-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(nextNum)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
