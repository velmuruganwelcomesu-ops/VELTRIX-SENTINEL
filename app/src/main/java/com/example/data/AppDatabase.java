package com.example.data;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppDatabase.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020!H&¨\u0006#"}, d2 = {"Lcom/example/data/AppDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "companyDao", "Lcom/example/data/CompanyDao;", "observationDao", "Lcom/example/data/ObservationDao;", "responsiblePersonDao", "Lcom/example/data/ResponsiblePersonDao;", "auditReportDao", "Lcom/example/data/AuditReportDao;", "incidentDao", "Lcom/example/data/IncidentDao;", "trainingDao", "Lcom/example/data/TrainingDao;", "complianceDao", "Lcom/example/data/ComplianceDao;", "reminderRuleDao", "Lcom/example/data/ReminderRuleDao;", "reminderDispatchLogDao", "Lcom/example/data/ReminderDispatchLogDao;", "fireExtinguisherDao", "Lcom/example/data/FireExtinguisherDao;", "complianceDocumentDao", "Lcom/example/data/ComplianceDocumentDao;", "complianceMeetingDao", "Lcom/example/data/ComplianceMeetingDao;", "amcRecordDao", "Lcom/example/data/AmcRecordDao;", "materialFollowUpDao", "Lcom/example/data/MaterialFollowUpDao;", "ehsActivityDao", "Lcom/example/data/EhsActivityDao;", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes5.dex */
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Migration MIGRATION_10_11 = new Migration() { // from class: com.example.data.AppDatabase$Companion$MIGRATION_10_11$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            try {
                db.execSQL("ALTER TABLE observations ADD COLUMN employeeDesignation TEXT NOT NULL DEFAULT ''");
            } catch (Exception e) {
            }
        }
    };
    private static final Migration MIGRATION_11_12 = new Migration() { // from class: com.example.data.AppDatabase$Companion$MIGRATION_11_12$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            try {
                db.execSQL("CREATE TABLE IF NOT EXISTS safety_trainings (\n    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    companyId INTEGER NOT NULL,\n    companyName TEXT NOT NULL DEFAULT '',\n    trainingTopic TEXT NOT NULL,\n    trainingCategory TEXT NOT NULL DEFAULT 'General Safety',\n    trainingDate TEXT NOT NULL DEFAULT '',\n    trainerName TEXT NOT NULL DEFAULT '',\n    trainerType TEXT NOT NULL DEFAULT 'Internal HSE Team',\n    trainingType TEXT NOT NULL DEFAULT 'Classroom & Theory',\n    targetDepartment TEXT NOT NULL DEFAULT 'All Departments',\n    durationHours REAL NOT NULL DEFAULT 1.0,\n    attendeesCount INTEGER NOT NULL DEFAULT 0,\n    attendeeDetailsJson TEXT NOT NULL DEFAULT '',\n    manHoursTrained REAL NOT NULL DEFAULT 0.0,\n    preAssessmentScoreAvg REAL NOT NULL DEFAULT 0.0,\n    postAssessmentScoreAvg REAL NOT NULL DEFAULT 0.0,\n    effectivenessRating TEXT NOT NULL DEFAULT 'Satisfactory',\n    venue TEXT NOT NULL DEFAULT 'Plant Safety Training Hall',\n    certificateIssued INTEGER NOT NULL DEFAULT 0,\n    photoUri TEXT,\n    remarks TEXT NOT NULL DEFAULT '',\n    status TEXT NOT NULL DEFAULT 'Completed',\n    syncState TEXT NOT NULL DEFAULT 'SYNCED',\n    lastSyncedAt INTEGER NOT NULL DEFAULT 0\n)");
            } catch (Exception e) {
            }
        }
    };
    private static final Migration MIGRATION_12_13 = new Migration() { // from class: com.example.data.AppDatabase$Companion$MIGRATION_12_13$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            try {
                db.execSQL("CREATE TABLE IF NOT EXISTS compliance_items (\n    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    companyId INTEGER NOT NULL,\n    companyName TEXT NOT NULL DEFAULT '',\n    location TEXT NOT NULL DEFAULT '',\n    documentName TEXT NOT NULL,\n    category TEXT NOT NULL DEFAULT 'Statutory & Factory',\n    issuingAuthority TEXT NOT NULL DEFAULT '',\n    documentNumber TEXT NOT NULL DEFAULT '',\n    issueDate TEXT NOT NULL DEFAULT '',\n    expiryDate TEXT NOT NULL DEFAULT '',\n    leadTimeDays INTEGER NOT NULL DEFAULT 60,\n    applyByDate TEXT NOT NULL DEFAULT '',\n    status TEXT NOT NULL DEFAULT 'Valid',\n    responsiblePerson TEXT NOT NULL DEFAULT '',\n    responsibleDepartment TEXT NOT NULL DEFAULT 'EHS / Legal',\n    renewalSubmissionDate TEXT NOT NULL DEFAULT '',\n    documentUri TEXT,\n    renewalFee REAL NOT NULL DEFAULT 0.0,\n    currency TEXT NOT NULL DEFAULT '₹',\n    remarks TEXT NOT NULL DEFAULT '',\n    renewalHistoryJson TEXT NOT NULL DEFAULT '[]',\n    syncState TEXT NOT NULL DEFAULT 'SYNCED',\n    lastSyncedAt INTEGER NOT NULL DEFAULT 0\n)");
            } catch (Exception e) {
            }
        }
    };
    private static final Migration MIGRATION_13_14 = new Migration() { // from class: com.example.data.AppDatabase$Companion$MIGRATION_13_14$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            try {
                db.execSQL("CREATE TABLE IF NOT EXISTS reminder_rules (\n    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    companyId INTEGER NOT NULL DEFAULT 0,\n    companyName TEXT NOT NULL DEFAULT '',\n    linkedModule TEXT NOT NULL DEFAULT 'Compliance Tracker',\n    linkedRecordId INTEGER NOT NULL DEFAULT 0,\n    linkedRecordTitle TEXT NOT NULL DEFAULT '',\n    purpose TEXT NOT NULL DEFAULT 'Send Email',\n    title TEXT NOT NULL DEFAULT '',\n    recipientType TEXT NOT NULL DEFAULT 'Person',\n    recipientName TEXT NOT NULL DEFAULT '',\n    recipientEmail TEXT NOT NULL DEFAULT '',\n    recipientDepartment TEXT NOT NULL DEFAULT 'EHS & Safety',\n    frequencyType TEXT NOT NULL DEFAULT 'Daily',\n    repeatEveryDays INTEGER NOT NULL DEFAULT 1,\n    startDate TEXT NOT NULL DEFAULT '',\n    startTime TEXT NOT NULL DEFAULT '09:00',\n    endDate TEXT NOT NULL DEFAULT '',\n    endTime TEXT NOT NULL DEFAULT '18:00',\n    messageTemplate TEXT NOT NULL DEFAULT '',\n    escalationEnabled INTEGER NOT NULL DEFAULT 0,\n    escalateAfterDays INTEGER NOT NULL DEFAULT 3,\n    escalationRecipientName TEXT NOT NULL DEFAULT '',\n    escalationRecipientEmail TEXT NOT NULL DEFAULT '',\n    escalationRole TEXT NOT NULL DEFAULT 'Safety Head / EHS Director',\n    status TEXT NOT NULL DEFAULT 'Active',\n    autoGenerated INTEGER NOT NULL DEFAULT 0,\n    lastDispatchedAt INTEGER NOT NULL DEFAULT 0,\n    nextTriggerDate TEXT NOT NULL DEFAULT '',\n    createdBy TEXT NOT NULL DEFAULT 'Admin',\n    createdAt INTEGER NOT NULL DEFAULT 0,\n    syncState TEXT NOT NULL DEFAULT 'SYNCED',\n    lastSyncedAt INTEGER NOT NULL DEFAULT 0\n)");
                db.execSQL("CREATE TABLE IF NOT EXISTS reminder_dispatch_logs (\n    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    ruleId INTEGER NOT NULL DEFAULT 0,\n    companyId INTEGER NOT NULL DEFAULT 0,\n    companyName TEXT NOT NULL DEFAULT '',\n    linkedModule TEXT NOT NULL DEFAULT 'Compliance Tracker',\n    linkedRecordId INTEGER NOT NULL DEFAULT 0,\n    linkedRecordTitle TEXT NOT NULL DEFAULT '',\n    purpose TEXT NOT NULL DEFAULT 'Send Email',\n    dispatchType TEXT NOT NULL DEFAULT 'Email',\n    recipientName TEXT NOT NULL DEFAULT '',\n    recipientEmail TEXT NOT NULL DEFAULT '',\n    recipientDepartment TEXT NOT NULL DEFAULT '',\n    subject TEXT NOT NULL DEFAULT '',\n    renderedMessage TEXT NOT NULL DEFAULT '',\n    dispatchedAt INTEGER NOT NULL DEFAULT 0,\n    dispatchedAtFormatted TEXT NOT NULL DEFAULT '',\n    isAcknowledged INTEGER NOT NULL DEFAULT 0,\n    acknowledgedBy TEXT NOT NULL DEFAULT '',\n    acknowledgedAt INTEGER NOT NULL DEFAULT 0,\n    acknowledgedAtFormatted TEXT NOT NULL DEFAULT '',\n    acknowledgementNotes TEXT NOT NULL DEFAULT '',\n    uploadedDocumentUri TEXT,\n    uploadedDocumentName TEXT NOT NULL DEFAULT '',\n    isEscalated INTEGER NOT NULL DEFAULT 0,\n    escalationNotes TEXT NOT NULL DEFAULT '',\n    syncState TEXT NOT NULL DEFAULT 'SYNCED',\n    lastSyncedAt INTEGER NOT NULL DEFAULT 0\n)");
            } catch (Exception e) {
            }
        }
    };
    private static final Migration MIGRATION_14_15 = new Migration() { // from class: com.example.data.AppDatabase$Companion$MIGRATION_14_15$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            try {
                db.execSQL("CREATE TABLE IF NOT EXISTS fire_extinguishers (\n    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    companyId INTEGER NOT NULL DEFAULT 0,\n    companyName TEXT NOT NULL DEFAULT '',\n    feNo TEXT NOT NULL,\n    location TEXT NOT NULL,\n    typeAndCapacity TEXT NOT NULL,\n    classesOfFireUsed TEXT NOT NULL,\n    refillingDate TEXT NOT NULL DEFAULT '',\n    refillDueDate TEXT NOT NULL DEFAULT '',\n    hptDate TEXT NOT NULL DEFAULT '',\n    hptDueDate TEXT NOT NULL DEFAULT '',\n    status TEXT NOT NULL DEFAULT 'OK',\n    remarks TEXT NOT NULL DEFAULT '',\n    missingSparesJson TEXT NOT NULL DEFAULT '[]',\n    syncState TEXT NOT NULL DEFAULT 'SYNCED',\n    lastSyncedAt INTEGER NOT NULL DEFAULT 0,\n    createdAt INTEGER NOT NULL DEFAULT 0\n)");
            } catch (Exception e) {
            }
        }
    };
    private static final Migration MIGRATION_15_16 = new Migration() { // from class: com.example.data.AppDatabase$Companion$MIGRATION_15_16$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            try {
                db.execSQL("CREATE TABLE IF NOT EXISTS compliance_documents (\n    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    companyId INTEGER NOT NULL DEFAULT 0,\n    companyName TEXT NOT NULL DEFAULT '',\n    name TEXT NOT NULL,\n    category TEXT NOT NULL DEFAULT 'Statutory & Factory',\n    referenceNumber TEXT NOT NULL DEFAULT '',\n    relatedDate TEXT NOT NULL DEFAULT '',\n    responsiblePerson TEXT NOT NULL DEFAULT '',\n    status TEXT NOT NULL DEFAULT 'Active',\n    remarks TEXT NOT NULL DEFAULT '',\n    syncState TEXT NOT NULL DEFAULT 'SYNCED',\n    lastSyncedAt INTEGER NOT NULL DEFAULT 0,\n    createdAt INTEGER NOT NULL DEFAULT 0\n)");
                db.execSQL("CREATE TABLE IF NOT EXISTS compliance_meetings (\n    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    companyId INTEGER NOT NULL DEFAULT 0,\n    companyName TEXT NOT NULL DEFAULT '',\n    title TEXT NOT NULL,\n    committeeType TEXT NOT NULL DEFAULT 'Safety Committee',\n    meetingDate TEXT NOT NULL DEFAULT '',\n    meetingTime TEXT NOT NULL DEFAULT '',\n    locationOrVenue TEXT NOT NULL DEFAULT '',\n    chairperson TEXT NOT NULL DEFAULT '',\n    attendees TEXT NOT NULL DEFAULT '',\n    agenda TEXT NOT NULL DEFAULT '',\n    minutesOfMeeting TEXT NOT NULL DEFAULT '',\n    actionItemsJson TEXT NOT NULL DEFAULT '[]',\n    status TEXT NOT NULL DEFAULT 'Scheduled',\n    remarks TEXT NOT NULL DEFAULT '',\n    syncState TEXT NOT NULL DEFAULT 'SYNCED',\n    lastSyncedAt INTEGER NOT NULL DEFAULT 0,\n    createdAt INTEGER NOT NULL DEFAULT 0\n)");
            } catch (Exception e) {
            }
        }
    };
    private static final Migration MIGRATION_16_17 = new Migration() { // from class: com.example.data.AppDatabase$Companion$MIGRATION_16_17$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            try {
                db.execSQL("CREATE TABLE IF NOT EXISTS amc_records (\n    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    companyId INTEGER NOT NULL DEFAULT 0,\n    companyName TEXT NOT NULL DEFAULT '',\n    equipmentType TEXT NOT NULL DEFAULT 'Fire Alarm',\n    equipmentName TEXT NOT NULL DEFAULT '',\n    location TEXT NOT NULL DEFAULT '',\n    vendor TEXT NOT NULL DEFAULT '',\n    vendorContact TEXT NOT NULL DEFAULT '',\n    lastServiceDate TEXT NOT NULL DEFAULT '',\n    nextServiceDueDate TEXT NOT NULL DEFAULT '',\n    status TEXT NOT NULL DEFAULT 'Active',\n    remarks TEXT NOT NULL DEFAULT '',\n    contractRefNo TEXT NOT NULL DEFAULT '',\n    serviceFrequency TEXT NOT NULL DEFAULT 'Quarterly',\n    syncState TEXT NOT NULL DEFAULT 'SYNCED',\n    lastSyncedAt INTEGER NOT NULL DEFAULT 0,\n    createdAt INTEGER NOT NULL DEFAULT 0\n)");
            } catch (Exception e) {
            }
        }
    };
    private static final Migration MIGRATION_17_18 = new Migration() { // from class: com.example.data.AppDatabase$Companion$MIGRATION_17_18$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            try {
                db.execSQL("CREATE TABLE IF NOT EXISTS materials_follow_up (\n    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    companyId INTEGER NOT NULL DEFAULT 0,\n    companyName TEXT NOT NULL DEFAULT '',\n    title TEXT NOT NULL,\n    category TEXT NOT NULL DEFAULT 'Raw Materials',\n    description TEXT NOT NULL DEFAULT '',\n    vendor TEXT NOT NULL DEFAULT '',\n    responsiblePerson TEXT NOT NULL DEFAULT '',\n    startDate TEXT NOT NULL DEFAULT '',\n    dueDate TEXT NOT NULL DEFAULT '',\n    priority TEXT NOT NULL DEFAULT 'Medium',\n    status TEXT NOT NULL DEFAULT 'Open',\n    remarks TEXT NOT NULL DEFAULT '',\n    attachments TEXT NOT NULL DEFAULT '',\n    reminderFrequency TEXT NOT NULL DEFAULT 'Once',\n    reminderDateTime TEXT NOT NULL DEFAULT '',\n    isReminderEnabled INTEGER NOT NULL DEFAULT 1,\n    repeatUntilClosed INTEGER NOT NULL DEFAULT 1,\n    syncState TEXT NOT NULL DEFAULT 'SYNCED',\n    lastSyncedAt INTEGER NOT NULL DEFAULT 0\n)");
            } catch (Exception e) {
            }
        }
    };
    private static final Migration MIGRATION_18_19 = new Migration() { // from class: com.example.data.AppDatabase$Companion$MIGRATION_18_19$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            try {
                db.execSQL("ALTER TABLE fire_extinguishers ADD COLUMN category TEXT NOT NULL DEFAULT 'Fire Extinguishers'");
            } catch (Exception e) {
            }
        }
    };
    private static final Migration MIGRATION_19_20 = new Migration() { // from class: com.example.data.AppDatabase$Companion$MIGRATION_19_20$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            try {
                db.execSQL("CREATE TABLE IF NOT EXISTS ehs_governance_activities (\n    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    username TEXT NOT NULL,\n    userFullName TEXT NOT NULL DEFAULT '',\n    userDesignation TEXT NOT NULL DEFAULT '',\n    category TEXT NOT NULL,\n    activityName TEXT NOT NULL,\n    description TEXT NOT NULL,\n    date TEXT NOT NULL,\n    time TEXT NOT NULL DEFAULT '',\n    status TEXT NOT NULL,\n    remarks TEXT NOT NULL DEFAULT '',\n    photoUri TEXT,\n    createdAt INTEGER NOT NULL DEFAULT 0\n)");
            } catch (Exception e) {
            }
        }
    };
    private static final Migration MIGRATION_20_21 = new Migration() { // from class: com.example.data.AppDatabase$Companion$MIGRATION_20_21$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            try {
                db.execSQL("ALTER TABLE ehs_governance_activities ADD COLUMN time TEXT NOT NULL DEFAULT ''");
            } catch (Exception e) {
            }
        }
    };

    public abstract AmcRecordDao amcRecordDao();

    public abstract AuditReportDao auditReportDao();

    public abstract CompanyDao companyDao();

    public abstract ComplianceDao complianceDao();

    public abstract ComplianceDocumentDao complianceDocumentDao();

    public abstract ComplianceMeetingDao complianceMeetingDao();

    public abstract EhsActivityDao ehsActivityDao();

    public abstract FireExtinguisherDao fireExtinguisherDao();

    public abstract IncidentDao incidentDao();

    public abstract MaterialFollowUpDao materialFollowUpDao();

    public abstract ObservationDao observationDao();

    public abstract ReminderDispatchLogDao reminderDispatchLogDao();

    public abstract ReminderRuleDao reminderRuleDao();

    public abstract ResponsiblePersonDao responsiblePersonDao();

    public abstract TrainingDao trainingDao();

    /* compiled from: AppDatabase.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0011\u0010\u0018\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0011\u0010\u001a\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\t¨\u0006!"}, d2 = {"Lcom/example/data/AppDatabase$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/example/data/AppDatabase;", "MIGRATION_10_11", "Landroidx/room/migration/Migration;", "getMIGRATION_10_11", "()Landroidx/room/migration/Migration;", "MIGRATION_11_12", "getMIGRATION_11_12", "MIGRATION_12_13", "getMIGRATION_12_13", "MIGRATION_13_14", "getMIGRATION_13_14", "MIGRATION_14_15", "getMIGRATION_14_15", "MIGRATION_15_16", "getMIGRATION_15_16", "MIGRATION_16_17", "getMIGRATION_16_17", "MIGRATION_17_18", "getMIGRATION_17_18", "MIGRATION_18_19", "getMIGRATION_18_19", "MIGRATION_19_20", "getMIGRATION_19_20", "MIGRATION_20_21", "getMIGRATION_20_21", "getDatabase", "context", "Landroid/content/Context;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /tmp/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Migration getMIGRATION_10_11() {
            return AppDatabase.MIGRATION_10_11;
        }

        public final Migration getMIGRATION_11_12() {
            return AppDatabase.MIGRATION_11_12;
        }

        public final Migration getMIGRATION_12_13() {
            return AppDatabase.MIGRATION_12_13;
        }

        public final Migration getMIGRATION_13_14() {
            return AppDatabase.MIGRATION_13_14;
        }

        public final Migration getMIGRATION_14_15() {
            return AppDatabase.MIGRATION_14_15;
        }

        public final Migration getMIGRATION_15_16() {
            return AppDatabase.MIGRATION_15_16;
        }

        public final Migration getMIGRATION_16_17() {
            return AppDatabase.MIGRATION_16_17;
        }

        public final Migration getMIGRATION_17_18() {
            return AppDatabase.MIGRATION_17_18;
        }

        public final Migration getMIGRATION_18_19() {
            return AppDatabase.MIGRATION_18_19;
        }

        public final Migration getMIGRATION_19_20() {
            return AppDatabase.MIGRATION_19_20;
        }

        public final Migration getMIGRATION_20_21() {
            return AppDatabase.MIGRATION_20_21;
        }

        public final AppDatabase getDatabase(Context context) {
            AppDatabase appDatabase;
            Intrinsics.checkNotNullParameter(context, "context");
            AppDatabase appDatabase2 = AppDatabase.INSTANCE;
            if (appDatabase2 != null) {
                return appDatabase2;
            }
            synchronized (this) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                appDatabase = (AppDatabase) Room.databaseBuilder(applicationContext, AppDatabase.class, "snc_safety_audit_database").addMigrations(new Migration[]{AppDatabase.INSTANCE.getMIGRATION_10_11(), AppDatabase.INSTANCE.getMIGRATION_11_12(), AppDatabase.INSTANCE.getMIGRATION_12_13(), AppDatabase.INSTANCE.getMIGRATION_13_14(), AppDatabase.INSTANCE.getMIGRATION_14_15(), AppDatabase.INSTANCE.getMIGRATION_15_16(), AppDatabase.INSTANCE.getMIGRATION_16_17(), AppDatabase.INSTANCE.getMIGRATION_17_18(), AppDatabase.INSTANCE.getMIGRATION_18_19(), AppDatabase.INSTANCE.getMIGRATION_19_20(), AppDatabase.INSTANCE.getMIGRATION_20_21()}).fallbackToDestructiveMigration().fallbackToDestructiveMigrationOnDowngrade().build();
                Companion companion = AppDatabase.INSTANCE;
                AppDatabase.INSTANCE = appDatabase;
            }
            return appDatabase;
        }
    }
}
