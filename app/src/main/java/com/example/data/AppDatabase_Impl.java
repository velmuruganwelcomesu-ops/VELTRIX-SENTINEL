package com.example.data;

import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: AppDatabase_Impl.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020(H\u0016J\"\u0010)\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030+\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0,0*H\u0014J\u0016\u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020/0+0.H\u0016J*\u00100\u001a\b\u0012\u0004\u0012\u0002010,2\u001a\u00102\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020/0+\u0012\u0004\u0012\u00020/0*H\u0016J\b\u00103\u001a\u00020\u0006H\u0016J\b\u00104\u001a\u00020\bH\u0016J\b\u00105\u001a\u00020\nH\u0016J\b\u00106\u001a\u00020\fH\u0016J\b\u00107\u001a\u00020\u000eH\u0016J\b\u00108\u001a\u00020\u0010H\u0016J\b\u00109\u001a\u00020\u0012H\u0016J\b\u0010:\u001a\u00020\u0014H\u0016J\b\u0010;\u001a\u00020\u0016H\u0016J\b\u0010<\u001a\u00020\u0018H\u0016J\b\u0010=\u001a\u00020\u001aH\u0016J\b\u0010>\u001a\u00020\u001cH\u0016J\b\u0010?\u001a\u00020\u001eH\u0016J\b\u0010@\u001a\u00020 H\u0016J\b\u0010A\u001a\u00020\"H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/example/data/AppDatabase_Impl;", "Lcom/example/data/AppDatabase;", "<init>", "()V", "_companyDao", "Lkotlin/Lazy;", "Lcom/example/data/CompanyDao;", "_observationDao", "Lcom/example/data/ObservationDao;", "_responsiblePersonDao", "Lcom/example/data/ResponsiblePersonDao;", "_auditReportDao", "Lcom/example/data/AuditReportDao;", "_incidentDao", "Lcom/example/data/IncidentDao;", "_trainingDao", "Lcom/example/data/TrainingDao;", "_complianceDao", "Lcom/example/data/ComplianceDao;", "_reminderRuleDao", "Lcom/example/data/ReminderRuleDao;", "_reminderDispatchLogDao", "Lcom/example/data/ReminderDispatchLogDao;", "_fireExtinguisherDao", "Lcom/example/data/FireExtinguisherDao;", "_complianceDocumentDao", "Lcom/example/data/ComplianceDocumentDao;", "_complianceMeetingDao", "Lcom/example/data/ComplianceMeetingDao;", "_amcRecordDao", "Lcom/example/data/AmcRecordDao;", "_materialFollowUpDao", "Lcom/example/data/MaterialFollowUpDao;", "_ehsActivityDao", "Lcom/example/data/EhsActivityDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "companyDao", "observationDao", "responsiblePersonDao", "auditReportDao", "incidentDao", "trainingDao", "complianceDao", "reminderRuleDao", "reminderDispatchLogDao", "fireExtinguisherDao", "complianceDocumentDao", "complianceMeetingDao", "amcRecordDao", "materialFollowUpDao", "ehsActivityDao", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes5.dex */
public final class AppDatabase_Impl extends AppDatabase {
    public static final int $stable = 8;
    private final Lazy<CompanyDao> _companyDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda0
        public final Object invoke() {
            return AppDatabase_Impl._companyDao$lambda$0(AppDatabase_Impl.this);
        }
    });
    private final Lazy<ObservationDao> _observationDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda11
        public final Object invoke() {
            return AppDatabase_Impl._observationDao$lambda$1(AppDatabase_Impl.this);
        }
    });
    private final Lazy<ResponsiblePersonDao> _responsiblePersonDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda12
        public final Object invoke() {
            return AppDatabase_Impl._responsiblePersonDao$lambda$2(AppDatabase_Impl.this);
        }
    });
    private final Lazy<AuditReportDao> _auditReportDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda13
        public final Object invoke() {
            return AppDatabase_Impl._auditReportDao$lambda$3(AppDatabase_Impl.this);
        }
    });
    private final Lazy<IncidentDao> _incidentDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda14
        public final Object invoke() {
            return AppDatabase_Impl._incidentDao$lambda$4(AppDatabase_Impl.this);
        }
    });
    private final Lazy<TrainingDao> _trainingDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda1
        public final Object invoke() {
            return AppDatabase_Impl._trainingDao$lambda$5(AppDatabase_Impl.this);
        }
    });
    private final Lazy<ComplianceDao> _complianceDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda2
        public final Object invoke() {
            return AppDatabase_Impl._complianceDao$lambda$6(AppDatabase_Impl.this);
        }
    });
    private final Lazy<ReminderRuleDao> _reminderRuleDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda3
        public final Object invoke() {
            return AppDatabase_Impl._reminderRuleDao$lambda$7(AppDatabase_Impl.this);
        }
    });
    private final Lazy<ReminderDispatchLogDao> _reminderDispatchLogDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda4
        public final Object invoke() {
            return AppDatabase_Impl._reminderDispatchLogDao$lambda$8(AppDatabase_Impl.this);
        }
    });
    private final Lazy<FireExtinguisherDao> _fireExtinguisherDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda5
        public final Object invoke() {
            return AppDatabase_Impl._fireExtinguisherDao$lambda$9(AppDatabase_Impl.this);
        }
    });
    private final Lazy<ComplianceDocumentDao> _complianceDocumentDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda6
        public final Object invoke() {
            return AppDatabase_Impl._complianceDocumentDao$lambda$10(AppDatabase_Impl.this);
        }
    });
    private final Lazy<ComplianceMeetingDao> _complianceMeetingDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda7
        public final Object invoke() {
            return AppDatabase_Impl._complianceMeetingDao$lambda$11(AppDatabase_Impl.this);
        }
    });
    private final Lazy<AmcRecordDao> _amcRecordDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda8
        public final Object invoke() {
            return AppDatabase_Impl._amcRecordDao$lambda$12(AppDatabase_Impl.this);
        }
    });
    private final Lazy<MaterialFollowUpDao> _materialFollowUpDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda9
        public final Object invoke() {
            return AppDatabase_Impl._materialFollowUpDao$lambda$13(AppDatabase_Impl.this);
        }
    });
    private final Lazy<EhsActivityDao> _ehsActivityDao = LazyKt.lazy(new Function0() { // from class: com.example.data.AppDatabase_Impl$$ExternalSyntheticLambda10
        public final Object invoke() {
            return AppDatabase_Impl._ehsActivityDao$lambda$14(AppDatabase_Impl.this);
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CompanyDao_Impl _companyDao$lambda$0(AppDatabase_Impl this$0) {
        return new CompanyDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ObservationDao_Impl _observationDao$lambda$1(AppDatabase_Impl this$0) {
        return new ObservationDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ResponsiblePersonDao_Impl _responsiblePersonDao$lambda$2(AppDatabase_Impl this$0) {
        return new ResponsiblePersonDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final AuditReportDao_Impl _auditReportDao$lambda$3(AppDatabase_Impl this$0) {
        return new AuditReportDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final IncidentDao_Impl _incidentDao$lambda$4(AppDatabase_Impl this$0) {
        return new IncidentDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final TrainingDao_Impl _trainingDao$lambda$5(AppDatabase_Impl this$0) {
        return new TrainingDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ComplianceDao_Impl _complianceDao$lambda$6(AppDatabase_Impl this$0) {
        return new ComplianceDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ReminderRuleDao_Impl _reminderRuleDao$lambda$7(AppDatabase_Impl this$0) {
        return new ReminderRuleDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ReminderDispatchLogDao_Impl _reminderDispatchLogDao$lambda$8(AppDatabase_Impl this$0) {
        return new ReminderDispatchLogDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final FireExtinguisherDao_Impl _fireExtinguisherDao$lambda$9(AppDatabase_Impl this$0) {
        return new FireExtinguisherDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ComplianceDocumentDao_Impl _complianceDocumentDao$lambda$10(AppDatabase_Impl this$0) {
        return new ComplianceDocumentDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ComplianceMeetingDao_Impl _complianceMeetingDao$lambda$11(AppDatabase_Impl this$0) {
        return new ComplianceMeetingDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final AmcRecordDao_Impl _amcRecordDao$lambda$12(AppDatabase_Impl this$0) {
        return new AmcRecordDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final MaterialFollowUpDao_Impl _materialFollowUpDao$lambda$13(AppDatabase_Impl this$0) {
        return new MaterialFollowUpDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final EhsActivityDao_Impl _ehsActivityDao$lambda$14(AppDatabase_Impl this$0) {
        return new EhsActivityDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: createOpenDelegate, reason: merged with bridge method [inline-methods] */
    public RoomOpenDelegate m0createOpenDelegate() {
        RoomOpenDelegate _openDelegate = new RoomOpenDelegate() { // from class: com.example.data.AppDatabase_Impl$createOpenDelegate$_openDelegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(21, "6717e60201ae15c5ef418801342c0f7e", "2fe7fc283c95bd6963b31145c81580fe");
            }

            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `companies` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `address` TEXT NOT NULL, `division` TEXT NOT NULL, `assignedSafetyOfficer` TEXT NOT NULL, `isPendingDeletion` INTEGER NOT NULL, `deletionRequestedBy` TEXT NOT NULL, `deletionRequestedAt` INTEGER NOT NULL, `deletionReason` TEXT NOT NULL, `syncState` TEXT NOT NULL, `lastSyncedAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `observations` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `companyId` INTEGER NOT NULL, `sncNumber` TEXT NOT NULL, `location` TEXT NOT NULL, `severity` TEXT NOT NULL, `issueDetails` TEXT NOT NULL, `suggestion` TEXT NOT NULL, `responsiblePerson` TEXT NOT NULL, `responsibleWhatsapp` TEXT NOT NULL, `whatsappNotificationMode` TEXT NOT NULL, `targetDate` TEXT NOT NULL, `dateAdded` TEXT NOT NULL, `photoUri` TEXT, `afterPhotoUri` TEXT, `actionTaken` TEXT NOT NULL, `closedBy` TEXT NOT NULL, `completedDate` TEXT NOT NULL, `isResolved` INTEGER NOT NULL, `findingType` TEXT NOT NULL, `employeeId` TEXT NOT NULL, `employeeName` TEXT NOT NULL, `employeeDepartment` TEXT NOT NULL, `employeeDesignation` TEXT NOT NULL, `employeeListJson` TEXT NOT NULL, `riskLevel` TEXT NOT NULL, `department` TEXT NOT NULL, `syncState` TEXT NOT NULL, `lastSyncedAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `responsible_persons` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `companyId` INTEGER NOT NULL, `name` TEXT NOT NULL, `designation` TEXT NOT NULL, `department` TEXT NOT NULL, `whatsappNumber` TEXT NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `audit_reports` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `companyId` INTEGER NOT NULL, `companyName` TEXT NOT NULL, `title` TEXT NOT NULL, `dateRange` TEXT NOT NULL, `totalObservations` INTEGER NOT NULL, `pendingCount` INTEGER NOT NULL, `resolvedCount` INTEGER NOT NULL, `reportType` TEXT NOT NULL, `generatedDate` TEXT NOT NULL, `filePath` TEXT NOT NULL, `presenterName` TEXT NOT NULL, `syncState` TEXT NOT NULL, `lastSyncedAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `incidents` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `companyId` INTEGER NOT NULL, `companyName` TEXT NOT NULL, `companyAddress` TEXT NOT NULL, `docRefNo` TEXT NOT NULL, `revNo` TEXT NOT NULL, `revDate` TEXT NOT NULL, `incidentNumber` TEXT NOT NULL, `incidentDate` TEXT NOT NULL, `incidentTime` TEXT NOT NULL, `reportTypeCategory` TEXT NOT NULL, `reportMadeBy` TEXT NOT NULL, `isReportable` INTEGER NOT NULL, `department` TEXT NOT NULL, `location` TEXT NOT NULL, `incidentType` TEXT NOT NULL, `affectedBodyPart` TEXT NOT NULL, `injuryType` TEXT NOT NULL, `affectedEmployeeId` TEXT NOT NULL, `affectedEmployeeName` TEXT NOT NULL, `affectedEmployeeAge` INTEGER NOT NULL, `affectedEmployeeGender` TEXT NOT NULL, `affectedEmployeeDesignation` TEXT NOT NULL, `affectedEmployeeDepartment` TEXT NOT NULL, `employmentType` TEXT NOT NULL, `monthsWithEmployee` TEXT NOT NULL, `monthsDoingJob` TEXT NOT NULL, `workdayPhase` TEXT NOT NULL, `witnesses` TEXT NOT NULL, `ppeUsed` TEXT NOT NULL, `description` TEXT NOT NULL, `injuryDescription` TEXT NOT NULL, `rootCause` TEXT NOT NULL, `correctiveMeasures` TEXT NOT NULL, `investigationTeam` TEXT NOT NULL, `investigatedBy` TEXT NOT NULL, `closingComments` TEXT NOT NULL, `responsiblePerson` TEXT NOT NULL, `targetDate` TEXT NOT NULL, `lostDays` INTEGER NOT NULL, `manHoursWorked` INTEGER NOT NULL, `severity` TEXT NOT NULL, `status` TEXT NOT NULL, `isDeleted` INTEGER NOT NULL, `photoUri` TEXT, `syncState` TEXT NOT NULL, `lastSyncedAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `safety_trainings` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `companyId` INTEGER NOT NULL, `companyName` TEXT NOT NULL, `trainingTopic` TEXT NOT NULL, `trainingCategory` TEXT NOT NULL, `trainingDate` TEXT NOT NULL, `trainerName` TEXT NOT NULL, `trainerType` TEXT NOT NULL, `trainingType` TEXT NOT NULL, `targetDepartment` TEXT NOT NULL, `durationHours` REAL NOT NULL, `attendeesCount` INTEGER NOT NULL, `attendeeDetailsJson` TEXT NOT NULL, `manHoursTrained` REAL NOT NULL, `preAssessmentScoreAvg` REAL NOT NULL, `postAssessmentScoreAvg` REAL NOT NULL, `effectivenessRating` TEXT NOT NULL, `venue` TEXT NOT NULL, `certificateIssued` INTEGER NOT NULL, `photoUri` TEXT, `remarks` TEXT NOT NULL, `status` TEXT NOT NULL, `syncState` TEXT NOT NULL, `lastSyncedAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `compliance_items` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `companyId` INTEGER NOT NULL, `companyName` TEXT NOT NULL, `location` TEXT NOT NULL, `documentName` TEXT NOT NULL, `category` TEXT NOT NULL, `issuingAuthority` TEXT NOT NULL, `documentNumber` TEXT NOT NULL, `issueDate` TEXT NOT NULL, `expiryDate` TEXT NOT NULL, `leadTimeDays` INTEGER NOT NULL, `applyByDate` TEXT NOT NULL, `status` TEXT NOT NULL, `responsiblePerson` TEXT NOT NULL, `responsibleDepartment` TEXT NOT NULL, `renewalSubmissionDate` TEXT NOT NULL, `documentUri` TEXT, `renewalFee` REAL NOT NULL, `currency` TEXT NOT NULL, `remarks` TEXT NOT NULL, `renewalHistoryJson` TEXT NOT NULL, `syncState` TEXT NOT NULL, `lastSyncedAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `reminder_rules` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `companyId` INTEGER NOT NULL, `companyName` TEXT NOT NULL, `linkedModule` TEXT NOT NULL, `linkedRecordId` INTEGER NOT NULL, `linkedRecordTitle` TEXT NOT NULL, `purpose` TEXT NOT NULL, `title` TEXT NOT NULL, `recipientType` TEXT NOT NULL, `recipientName` TEXT NOT NULL, `recipientEmail` TEXT NOT NULL, `recipientDepartment` TEXT NOT NULL, `frequencyType` TEXT NOT NULL, `repeatEveryDays` INTEGER NOT NULL, `startDate` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endDate` TEXT NOT NULL, `endTime` TEXT NOT NULL, `messageTemplate` TEXT NOT NULL, `escalationEnabled` INTEGER NOT NULL, `escalateAfterDays` INTEGER NOT NULL, `escalationRecipientName` TEXT NOT NULL, `escalationRecipientEmail` TEXT NOT NULL, `escalationRole` TEXT NOT NULL, `status` TEXT NOT NULL, `autoGenerated` INTEGER NOT NULL, `lastDispatchedAt` INTEGER NOT NULL, `nextTriggerDate` TEXT NOT NULL, `createdBy` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `syncState` TEXT NOT NULL, `lastSyncedAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `reminder_dispatch_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ruleId` INTEGER NOT NULL, `companyId` INTEGER NOT NULL, `companyName` TEXT NOT NULL, `linkedModule` TEXT NOT NULL, `linkedRecordId` INTEGER NOT NULL, `linkedRecordTitle` TEXT NOT NULL, `purpose` TEXT NOT NULL, `dispatchType` TEXT NOT NULL, `recipientName` TEXT NOT NULL, `recipientEmail` TEXT NOT NULL, `recipientDepartment` TEXT NOT NULL, `subject` TEXT NOT NULL, `renderedMessage` TEXT NOT NULL, `dispatchedAt` INTEGER NOT NULL, `dispatchedAtFormatted` TEXT NOT NULL, `isAcknowledged` INTEGER NOT NULL, `acknowledgedBy` TEXT NOT NULL, `acknowledgedAt` INTEGER NOT NULL, `acknowledgedAtFormatted` TEXT NOT NULL, `acknowledgementNotes` TEXT NOT NULL, `uploadedDocumentUri` TEXT, `uploadedDocumentName` TEXT NOT NULL, `isEscalated` INTEGER NOT NULL, `escalationNotes` TEXT NOT NULL, `syncState` TEXT NOT NULL, `lastSyncedAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `fire_extinguishers` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `companyId` INTEGER NOT NULL, `companyName` TEXT NOT NULL, `feNo` TEXT NOT NULL, `location` TEXT NOT NULL, `typeAndCapacity` TEXT NOT NULL, `classesOfFireUsed` TEXT NOT NULL, `refillingDate` TEXT NOT NULL, `refillDueDate` TEXT NOT NULL, `hptDate` TEXT NOT NULL, `hptDueDate` TEXT NOT NULL, `status` TEXT NOT NULL, `remarks` TEXT NOT NULL, `missingSparesJson` TEXT NOT NULL, `category` TEXT NOT NULL, `syncState` TEXT NOT NULL, `lastSyncedAt` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `compliance_documents` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `companyId` INTEGER NOT NULL, `companyName` TEXT NOT NULL, `name` TEXT NOT NULL, `category` TEXT NOT NULL, `referenceNumber` TEXT NOT NULL, `relatedDate` TEXT NOT NULL, `responsiblePerson` TEXT NOT NULL, `status` TEXT NOT NULL, `remarks` TEXT NOT NULL, `syncState` TEXT NOT NULL, `lastSyncedAt` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `compliance_meetings` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `companyId` INTEGER NOT NULL, `companyName` TEXT NOT NULL, `title` TEXT NOT NULL, `committeeType` TEXT NOT NULL, `meetingDate` TEXT NOT NULL, `meetingTime` TEXT NOT NULL, `locationOrVenue` TEXT NOT NULL, `chairperson` TEXT NOT NULL, `attendees` TEXT NOT NULL, `agenda` TEXT NOT NULL, `minutesOfMeeting` TEXT NOT NULL, `actionItemsJson` TEXT NOT NULL, `status` TEXT NOT NULL, `remarks` TEXT NOT NULL, `syncState` TEXT NOT NULL, `lastSyncedAt` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `amc_records` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `companyId` INTEGER NOT NULL, `companyName` TEXT NOT NULL, `equipmentType` TEXT NOT NULL, `equipmentName` TEXT NOT NULL, `location` TEXT NOT NULL, `vendor` TEXT NOT NULL, `vendorContact` TEXT NOT NULL, `lastServiceDate` TEXT NOT NULL, `nextServiceDueDate` TEXT NOT NULL, `status` TEXT NOT NULL, `remarks` TEXT NOT NULL, `contractRefNo` TEXT NOT NULL, `serviceFrequency` TEXT NOT NULL, `syncState` TEXT NOT NULL, `lastSyncedAt` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `materials_follow_up` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `companyId` INTEGER NOT NULL, `companyName` TEXT NOT NULL, `title` TEXT NOT NULL, `category` TEXT NOT NULL, `description` TEXT NOT NULL, `vendor` TEXT NOT NULL, `responsiblePerson` TEXT NOT NULL, `startDate` TEXT NOT NULL, `dueDate` TEXT NOT NULL, `priority` TEXT NOT NULL, `status` TEXT NOT NULL, `remarks` TEXT NOT NULL, `attachments` TEXT NOT NULL, `reminderFrequency` TEXT NOT NULL, `reminderDateTime` TEXT NOT NULL, `isReminderEnabled` INTEGER NOT NULL, `repeatUntilClosed` INTEGER NOT NULL, `syncState` TEXT NOT NULL, `lastSyncedAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `ehs_governance_activities` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `username` TEXT NOT NULL, `userFullName` TEXT NOT NULL, `userDesignation` TEXT NOT NULL, `category` TEXT NOT NULL, `activityName` TEXT NOT NULL, `description` TEXT NOT NULL, `date` TEXT NOT NULL, `time` TEXT NOT NULL, `status` TEXT NOT NULL, `remarks` TEXT NOT NULL, `photoUri` TEXT, `createdAt` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6717e60201ae15c5ef418801342c0f7e')");
            }

            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `companies`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `observations`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `responsible_persons`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `audit_reports`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `incidents`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `safety_trainings`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `compliance_items`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `reminder_rules`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `reminder_dispatch_logs`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `fire_extinguishers`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `compliance_documents`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `compliance_meetings`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `amc_records`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `materials_follow_up`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `ehs_governance_activities`");
            }

            public void onCreate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                AppDatabase_Impl.this.internalInitInvalidationTracker(connection);
            }

            public void onPreMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                DBUtil.dropFtsSyncTriggers(connection);
            }

            public void onPostMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                Map _columnsCompanies = new LinkedHashMap();
                _columnsCompanies.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsCompanies.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                _columnsCompanies.put("address", new TableInfo.Column("address", "TEXT", true, 0, (String) null, 1));
                _columnsCompanies.put("division", new TableInfo.Column("division", "TEXT", true, 0, (String) null, 1));
                _columnsCompanies.put("assignedSafetyOfficer", new TableInfo.Column("assignedSafetyOfficer", "TEXT", true, 0, (String) null, 1));
                _columnsCompanies.put("isPendingDeletion", new TableInfo.Column("isPendingDeletion", "INTEGER", true, 0, (String) null, 1));
                _columnsCompanies.put("deletionRequestedBy", new TableInfo.Column("deletionRequestedBy", "TEXT", true, 0, (String) null, 1));
                _columnsCompanies.put("deletionRequestedAt", new TableInfo.Column("deletionRequestedAt", "INTEGER", true, 0, (String) null, 1));
                _columnsCompanies.put("deletionReason", new TableInfo.Column("deletionReason", "TEXT", true, 0, (String) null, 1));
                _columnsCompanies.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, (String) null, 1));
                _columnsCompanies.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysCompanies = new LinkedHashSet();
                Set _indicesCompanies = new LinkedHashSet();
                TableInfo _infoCompanies = new TableInfo("companies", _columnsCompanies, _foreignKeysCompanies, _indicesCompanies);
                TableInfo _existingCompanies = TableInfo.Companion.read(connection, "companies");
                if (!_infoCompanies.equals(_existingCompanies)) {
                    return new RoomOpenDelegate.ValidationResult(false, "companies(com.example.data.Company).\n Expected:\n" + _infoCompanies + "\n Found:\n" + _existingCompanies);
                }
                Map _columnsObservations = new LinkedHashMap();
                _columnsObservations.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsObservations.put("companyId", new TableInfo.Column("companyId", "INTEGER", true, 0, (String) null, 1));
                _columnsObservations.put("sncNumber", new TableInfo.Column("sncNumber", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("location", new TableInfo.Column("location", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("severity", new TableInfo.Column("severity", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("issueDetails", new TableInfo.Column("issueDetails", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("suggestion", new TableInfo.Column("suggestion", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("responsiblePerson", new TableInfo.Column("responsiblePerson", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("responsibleWhatsapp", new TableInfo.Column("responsibleWhatsapp", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("whatsappNotificationMode", new TableInfo.Column("whatsappNotificationMode", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("targetDate", new TableInfo.Column("targetDate", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("dateAdded", new TableInfo.Column("dateAdded", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("photoUri", new TableInfo.Column("photoUri", "TEXT", false, 0, (String) null, 1));
                _columnsObservations.put("afterPhotoUri", new TableInfo.Column("afterPhotoUri", "TEXT", false, 0, (String) null, 1));
                _columnsObservations.put("actionTaken", new TableInfo.Column("actionTaken", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("closedBy", new TableInfo.Column("closedBy", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("completedDate", new TableInfo.Column("completedDate", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("isResolved", new TableInfo.Column("isResolved", "INTEGER", true, 0, (String) null, 1));
                _columnsObservations.put("findingType", new TableInfo.Column("findingType", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("employeeId", new TableInfo.Column("employeeId", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("employeeName", new TableInfo.Column("employeeName", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("employeeDepartment", new TableInfo.Column("employeeDepartment", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("employeeDesignation", new TableInfo.Column("employeeDesignation", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("employeeListJson", new TableInfo.Column("employeeListJson", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("riskLevel", new TableInfo.Column("riskLevel", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("department", new TableInfo.Column("department", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, (String) null, 1));
                _columnsObservations.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysObservations = new LinkedHashSet();
                Set _indicesObservations = new LinkedHashSet();
                TableInfo _infoObservations = new TableInfo("observations", _columnsObservations, _foreignKeysObservations, _indicesObservations);
                TableInfo _existingObservations = TableInfo.Companion.read(connection, "observations");
                if (!_infoObservations.equals(_existingObservations)) {
                    return new RoomOpenDelegate.ValidationResult(false, "observations(com.example.data.Observation).\n Expected:\n" + _infoObservations + "\n Found:\n" + _existingObservations);
                }
                Map _columnsResponsiblePersons = new LinkedHashMap();
                _columnsResponsiblePersons.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsResponsiblePersons.put("companyId", new TableInfo.Column("companyId", "INTEGER", true, 0, (String) null, 1));
                _columnsResponsiblePersons.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                _columnsResponsiblePersons.put("designation", new TableInfo.Column("designation", "TEXT", true, 0, (String) null, 1));
                _columnsResponsiblePersons.put("department", new TableInfo.Column("department", "TEXT", true, 0, (String) null, 1));
                _columnsResponsiblePersons.put("whatsappNumber", new TableInfo.Column("whatsappNumber", "TEXT", true, 0, (String) null, 1));
                Set _foreignKeysResponsiblePersons = new LinkedHashSet();
                Set _indicesResponsiblePersons = new LinkedHashSet();
                TableInfo _infoResponsiblePersons = new TableInfo("responsible_persons", _columnsResponsiblePersons, _foreignKeysResponsiblePersons, _indicesResponsiblePersons);
                TableInfo _existingResponsiblePersons = TableInfo.Companion.read(connection, "responsible_persons");
                if (!_infoResponsiblePersons.equals(_existingResponsiblePersons)) {
                    return new RoomOpenDelegate.ValidationResult(false, "responsible_persons(com.example.data.ResponsiblePerson).\n Expected:\n" + _infoResponsiblePersons + "\n Found:\n" + _existingResponsiblePersons);
                }
                Map _columnsAuditReports = new LinkedHashMap();
                _columnsAuditReports.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsAuditReports.put("companyId", new TableInfo.Column("companyId", "INTEGER", true, 0, (String) null, 1));
                _columnsAuditReports.put("companyName", new TableInfo.Column("companyName", "TEXT", true, 0, (String) null, 1));
                _columnsAuditReports.put("title", new TableInfo.Column("title", "TEXT", true, 0, (String) null, 1));
                _columnsAuditReports.put("dateRange", new TableInfo.Column("dateRange", "TEXT", true, 0, (String) null, 1));
                _columnsAuditReports.put("totalObservations", new TableInfo.Column("totalObservations", "INTEGER", true, 0, (String) null, 1));
                _columnsAuditReports.put("pendingCount", new TableInfo.Column("pendingCount", "INTEGER", true, 0, (String) null, 1));
                _columnsAuditReports.put("resolvedCount", new TableInfo.Column("resolvedCount", "INTEGER", true, 0, (String) null, 1));
                _columnsAuditReports.put("reportType", new TableInfo.Column("reportType", "TEXT", true, 0, (String) null, 1));
                _columnsAuditReports.put("generatedDate", new TableInfo.Column("generatedDate", "TEXT", true, 0, (String) null, 1));
                _columnsAuditReports.put("filePath", new TableInfo.Column("filePath", "TEXT", true, 0, (String) null, 1));
                _columnsAuditReports.put("presenterName", new TableInfo.Column("presenterName", "TEXT", true, 0, (String) null, 1));
                _columnsAuditReports.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, (String) null, 1));
                _columnsAuditReports.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysAuditReports = new LinkedHashSet();
                Set _indicesAuditReports = new LinkedHashSet();
                TableInfo _infoAuditReports = new TableInfo("audit_reports", _columnsAuditReports, _foreignKeysAuditReports, _indicesAuditReports);
                TableInfo _existingAuditReports = TableInfo.Companion.read(connection, "audit_reports");
                if (!_infoAuditReports.equals(_existingAuditReports)) {
                    return new RoomOpenDelegate.ValidationResult(false, "audit_reports(com.example.data.AuditReport).\n Expected:\n" + _infoAuditReports + "\n Found:\n" + _existingAuditReports);
                }
                Map _columnsIncidents = new LinkedHashMap();
                _columnsIncidents.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsIncidents.put("companyId", new TableInfo.Column("companyId", "INTEGER", true, 0, (String) null, 1));
                _columnsIncidents.put("companyName", new TableInfo.Column("companyName", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("companyAddress", new TableInfo.Column("companyAddress", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("docRefNo", new TableInfo.Column("docRefNo", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("revNo", new TableInfo.Column("revNo", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("revDate", new TableInfo.Column("revDate", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("incidentNumber", new TableInfo.Column("incidentNumber", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("incidentDate", new TableInfo.Column("incidentDate", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("incidentTime", new TableInfo.Column("incidentTime", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("reportTypeCategory", new TableInfo.Column("reportTypeCategory", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("reportMadeBy", new TableInfo.Column("reportMadeBy", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("isReportable", new TableInfo.Column("isReportable", "INTEGER", true, 0, (String) null, 1));
                _columnsIncidents.put("department", new TableInfo.Column("department", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("location", new TableInfo.Column("location", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("incidentType", new TableInfo.Column("incidentType", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("affectedBodyPart", new TableInfo.Column("affectedBodyPart", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("injuryType", new TableInfo.Column("injuryType", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("affectedEmployeeId", new TableInfo.Column("affectedEmployeeId", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("affectedEmployeeName", new TableInfo.Column("affectedEmployeeName", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("affectedEmployeeAge", new TableInfo.Column("affectedEmployeeAge", "INTEGER", true, 0, (String) null, 1));
                _columnsIncidents.put("affectedEmployeeGender", new TableInfo.Column("affectedEmployeeGender", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("affectedEmployeeDesignation", new TableInfo.Column("affectedEmployeeDesignation", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("affectedEmployeeDepartment", new TableInfo.Column("affectedEmployeeDepartment", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("employmentType", new TableInfo.Column("employmentType", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("monthsWithEmployee", new TableInfo.Column("monthsWithEmployee", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("monthsDoingJob", new TableInfo.Column("monthsDoingJob", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("workdayPhase", new TableInfo.Column("workdayPhase", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("witnesses", new TableInfo.Column("witnesses", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("ppeUsed", new TableInfo.Column("ppeUsed", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("description", new TableInfo.Column("description", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("injuryDescription", new TableInfo.Column("injuryDescription", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("rootCause", new TableInfo.Column("rootCause", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("correctiveMeasures", new TableInfo.Column("correctiveMeasures", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("investigationTeam", new TableInfo.Column("investigationTeam", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("investigatedBy", new TableInfo.Column("investigatedBy", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("closingComments", new TableInfo.Column("closingComments", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("responsiblePerson", new TableInfo.Column("responsiblePerson", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("targetDate", new TableInfo.Column("targetDate", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("lostDays", new TableInfo.Column("lostDays", "INTEGER", true, 0, (String) null, 1));
                _columnsIncidents.put("manHoursWorked", new TableInfo.Column("manHoursWorked", "INTEGER", true, 0, (String) null, 1));
                _columnsIncidents.put("severity", new TableInfo.Column("severity", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("status", new TableInfo.Column("status", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", true, 0, (String) null, 1));
                _columnsIncidents.put("photoUri", new TableInfo.Column("photoUri", "TEXT", false, 0, (String) null, 1));
                _columnsIncidents.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, (String) null, 1));
                _columnsIncidents.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysIncidents = new LinkedHashSet();
                Set _indicesIncidents = new LinkedHashSet();
                TableInfo _infoIncidents = new TableInfo("incidents", _columnsIncidents, _foreignKeysIncidents, _indicesIncidents);
                TableInfo _existingIncidents = TableInfo.Companion.read(connection, "incidents");
                if (!_infoIncidents.equals(_existingIncidents)) {
                    return new RoomOpenDelegate.ValidationResult(false, "incidents(com.example.data.IncidentRecord).\n Expected:\n" + _infoIncidents + "\n Found:\n" + _existingIncidents);
                }
                Map _columnsSafetyTrainings = new LinkedHashMap();
                _columnsSafetyTrainings.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsSafetyTrainings.put("companyId", new TableInfo.Column("companyId", "INTEGER", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("companyName", new TableInfo.Column("companyName", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("trainingTopic", new TableInfo.Column("trainingTopic", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("trainingCategory", new TableInfo.Column("trainingCategory", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("trainingDate", new TableInfo.Column("trainingDate", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("trainerName", new TableInfo.Column("trainerName", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("trainerType", new TableInfo.Column("trainerType", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("trainingType", new TableInfo.Column("trainingType", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("targetDepartment", new TableInfo.Column("targetDepartment", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("durationHours", new TableInfo.Column("durationHours", "REAL", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("attendeesCount", new TableInfo.Column("attendeesCount", "INTEGER", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("attendeeDetailsJson", new TableInfo.Column("attendeeDetailsJson", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("manHoursTrained", new TableInfo.Column("manHoursTrained", "REAL", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("preAssessmentScoreAvg", new TableInfo.Column("preAssessmentScoreAvg", "REAL", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("postAssessmentScoreAvg", new TableInfo.Column("postAssessmentScoreAvg", "REAL", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("effectivenessRating", new TableInfo.Column("effectivenessRating", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("venue", new TableInfo.Column("venue", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("certificateIssued", new TableInfo.Column("certificateIssued", "INTEGER", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("photoUri", new TableInfo.Column("photoUri", "TEXT", false, 0, (String) null, 1));
                _columnsSafetyTrainings.put("remarks", new TableInfo.Column("remarks", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("status", new TableInfo.Column("status", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, (String) null, 1));
                _columnsSafetyTrainings.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysSafetyTrainings = new LinkedHashSet();
                Set _indicesSafetyTrainings = new LinkedHashSet();
                TableInfo _infoSafetyTrainings = new TableInfo("safety_trainings", _columnsSafetyTrainings, _foreignKeysSafetyTrainings, _indicesSafetyTrainings);
                TableInfo _existingSafetyTrainings = TableInfo.Companion.read(connection, "safety_trainings");
                if (!_infoSafetyTrainings.equals(_existingSafetyTrainings)) {
                    return new RoomOpenDelegate.ValidationResult(false, "safety_trainings(com.example.data.SafetyTraining).\n Expected:\n" + _infoSafetyTrainings + "\n Found:\n" + _existingSafetyTrainings);
                }
                Map _columnsComplianceItems = new LinkedHashMap();
                _columnsComplianceItems.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsComplianceItems.put("companyId", new TableInfo.Column("companyId", "INTEGER", true, 0, (String) null, 1));
                _columnsComplianceItems.put("companyName", new TableInfo.Column("companyName", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("location", new TableInfo.Column("location", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("documentName", new TableInfo.Column("documentName", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("category", new TableInfo.Column("category", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("issuingAuthority", new TableInfo.Column("issuingAuthority", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("documentNumber", new TableInfo.Column("documentNumber", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("issueDate", new TableInfo.Column("issueDate", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("expiryDate", new TableInfo.Column("expiryDate", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("leadTimeDays", new TableInfo.Column("leadTimeDays", "INTEGER", true, 0, (String) null, 1));
                _columnsComplianceItems.put("applyByDate", new TableInfo.Column("applyByDate", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("status", new TableInfo.Column("status", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("responsiblePerson", new TableInfo.Column("responsiblePerson", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("responsibleDepartment", new TableInfo.Column("responsibleDepartment", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("renewalSubmissionDate", new TableInfo.Column("renewalSubmissionDate", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("documentUri", new TableInfo.Column("documentUri", "TEXT", false, 0, (String) null, 1));
                _columnsComplianceItems.put("renewalFee", new TableInfo.Column("renewalFee", "REAL", true, 0, (String) null, 1));
                _columnsComplianceItems.put("currency", new TableInfo.Column("currency", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("remarks", new TableInfo.Column("remarks", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("renewalHistoryJson", new TableInfo.Column("renewalHistoryJson", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceItems.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysComplianceItems = new LinkedHashSet();
                Set _indicesComplianceItems = new LinkedHashSet();
                TableInfo _infoComplianceItems = new TableInfo("compliance_items", _columnsComplianceItems, _foreignKeysComplianceItems, _indicesComplianceItems);
                TableInfo _existingComplianceItems = TableInfo.Companion.read(connection, "compliance_items");
                if (!_infoComplianceItems.equals(_existingComplianceItems)) {
                    return new RoomOpenDelegate.ValidationResult(false, "compliance_items(com.example.data.ComplianceItem).\n Expected:\n" + _infoComplianceItems + "\n Found:\n" + _existingComplianceItems);
                }
                Map _columnsReminderRules = new LinkedHashMap();
                _columnsReminderRules.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsReminderRules.put("companyId", new TableInfo.Column("companyId", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderRules.put("companyName", new TableInfo.Column("companyName", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("linkedModule", new TableInfo.Column("linkedModule", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("linkedRecordId", new TableInfo.Column("linkedRecordId", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderRules.put("linkedRecordTitle", new TableInfo.Column("linkedRecordTitle", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("purpose", new TableInfo.Column("purpose", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("title", new TableInfo.Column("title", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("recipientType", new TableInfo.Column("recipientType", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("recipientName", new TableInfo.Column("recipientName", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("recipientEmail", new TableInfo.Column("recipientEmail", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("recipientDepartment", new TableInfo.Column("recipientDepartment", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("frequencyType", new TableInfo.Column("frequencyType", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("repeatEveryDays", new TableInfo.Column("repeatEveryDays", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderRules.put("startDate", new TableInfo.Column("startDate", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("startTime", new TableInfo.Column("startTime", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("endDate", new TableInfo.Column("endDate", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("endTime", new TableInfo.Column("endTime", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("messageTemplate", new TableInfo.Column("messageTemplate", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("escalationEnabled", new TableInfo.Column("escalationEnabled", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderRules.put("escalateAfterDays", new TableInfo.Column("escalateAfterDays", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderRules.put("escalationRecipientName", new TableInfo.Column("escalationRecipientName", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("escalationRecipientEmail", new TableInfo.Column("escalationRecipientEmail", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("escalationRole", new TableInfo.Column("escalationRole", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("status", new TableInfo.Column("status", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("autoGenerated", new TableInfo.Column("autoGenerated", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderRules.put("lastDispatchedAt", new TableInfo.Column("lastDispatchedAt", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderRules.put("nextTriggerDate", new TableInfo.Column("nextTriggerDate", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("createdBy", new TableInfo.Column("createdBy", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderRules.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, (String) null, 1));
                _columnsReminderRules.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysReminderRules = new LinkedHashSet();
                Set _indicesReminderRules = new LinkedHashSet();
                TableInfo _infoReminderRules = new TableInfo("reminder_rules", _columnsReminderRules, _foreignKeysReminderRules, _indicesReminderRules);
                TableInfo _existingReminderRules = TableInfo.Companion.read(connection, "reminder_rules");
                if (!_infoReminderRules.equals(_existingReminderRules)) {
                    return new RoomOpenDelegate.ValidationResult(false, "reminder_rules(com.example.data.ReminderRule).\n Expected:\n" + _infoReminderRules + "\n Found:\n" + _existingReminderRules);
                }
                Map _columnsReminderDispatchLogs = new LinkedHashMap();
                _columnsReminderDispatchLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsReminderDispatchLogs.put("ruleId", new TableInfo.Column("ruleId", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("companyId", new TableInfo.Column("companyId", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("companyName", new TableInfo.Column("companyName", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("linkedModule", new TableInfo.Column("linkedModule", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("linkedRecordId", new TableInfo.Column("linkedRecordId", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("linkedRecordTitle", new TableInfo.Column("linkedRecordTitle", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("purpose", new TableInfo.Column("purpose", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("dispatchType", new TableInfo.Column("dispatchType", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("recipientName", new TableInfo.Column("recipientName", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("recipientEmail", new TableInfo.Column("recipientEmail", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("recipientDepartment", new TableInfo.Column("recipientDepartment", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("subject", new TableInfo.Column("subject", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("renderedMessage", new TableInfo.Column("renderedMessage", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("dispatchedAt", new TableInfo.Column("dispatchedAt", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("dispatchedAtFormatted", new TableInfo.Column("dispatchedAtFormatted", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("isAcknowledged", new TableInfo.Column("isAcknowledged", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("acknowledgedBy", new TableInfo.Column("acknowledgedBy", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("acknowledgedAt", new TableInfo.Column("acknowledgedAt", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("acknowledgedAtFormatted", new TableInfo.Column("acknowledgedAtFormatted", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("acknowledgementNotes", new TableInfo.Column("acknowledgementNotes", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("uploadedDocumentUri", new TableInfo.Column("uploadedDocumentUri", "TEXT", false, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("uploadedDocumentName", new TableInfo.Column("uploadedDocumentName", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("isEscalated", new TableInfo.Column("isEscalated", "INTEGER", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("escalationNotes", new TableInfo.Column("escalationNotes", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, (String) null, 1));
                _columnsReminderDispatchLogs.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysReminderDispatchLogs = new LinkedHashSet();
                Set _indicesReminderDispatchLogs = new LinkedHashSet();
                TableInfo _infoReminderDispatchLogs = new TableInfo("reminder_dispatch_logs", _columnsReminderDispatchLogs, _foreignKeysReminderDispatchLogs, _indicesReminderDispatchLogs);
                TableInfo _existingReminderDispatchLogs = TableInfo.Companion.read(connection, "reminder_dispatch_logs");
                if (!_infoReminderDispatchLogs.equals(_existingReminderDispatchLogs)) {
                    return new RoomOpenDelegate.ValidationResult(false, "reminder_dispatch_logs(com.example.data.ReminderDispatchLog).\n Expected:\n" + _infoReminderDispatchLogs + "\n Found:\n" + _existingReminderDispatchLogs);
                }
                Map _columnsFireExtinguishers = new LinkedHashMap();
                _columnsFireExtinguishers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsFireExtinguishers.put("companyId", new TableInfo.Column("companyId", "INTEGER", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("companyName", new TableInfo.Column("companyName", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("feNo", new TableInfo.Column("feNo", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("location", new TableInfo.Column("location", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("typeAndCapacity", new TableInfo.Column("typeAndCapacity", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("classesOfFireUsed", new TableInfo.Column("classesOfFireUsed", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("refillingDate", new TableInfo.Column("refillingDate", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("refillDueDate", new TableInfo.Column("refillDueDate", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("hptDate", new TableInfo.Column("hptDate", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("hptDueDate", new TableInfo.Column("hptDueDate", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("status", new TableInfo.Column("status", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("remarks", new TableInfo.Column("remarks", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("missingSparesJson", new TableInfo.Column("missingSparesJson", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("category", new TableInfo.Column("category", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", true, 0, (String) null, 1));
                _columnsFireExtinguishers.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysFireExtinguishers = new LinkedHashSet();
                Set _indicesFireExtinguishers = new LinkedHashSet();
                TableInfo _infoFireExtinguishers = new TableInfo("fire_extinguishers", _columnsFireExtinguishers, _foreignKeysFireExtinguishers, _indicesFireExtinguishers);
                TableInfo _existingFireExtinguishers = TableInfo.Companion.read(connection, "fire_extinguishers");
                if (!_infoFireExtinguishers.equals(_existingFireExtinguishers)) {
                    return new RoomOpenDelegate.ValidationResult(false, "fire_extinguishers(com.example.data.FireExtinguisher).\n Expected:\n" + _infoFireExtinguishers + "\n Found:\n" + _existingFireExtinguishers);
                }
                Map _columnsComplianceDocuments = new LinkedHashMap();
                _columnsComplianceDocuments.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsComplianceDocuments.put("companyId", new TableInfo.Column("companyId", "INTEGER", true, 0, (String) null, 1));
                _columnsComplianceDocuments.put("companyName", new TableInfo.Column("companyName", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceDocuments.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceDocuments.put("category", new TableInfo.Column("category", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceDocuments.put("referenceNumber", new TableInfo.Column("referenceNumber", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceDocuments.put("relatedDate", new TableInfo.Column("relatedDate", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceDocuments.put("responsiblePerson", new TableInfo.Column("responsiblePerson", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceDocuments.put("status", new TableInfo.Column("status", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceDocuments.put("remarks", new TableInfo.Column("remarks", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceDocuments.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceDocuments.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", true, 0, (String) null, 1));
                _columnsComplianceDocuments.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysComplianceDocuments = new LinkedHashSet();
                Set _indicesComplianceDocuments = new LinkedHashSet();
                TableInfo _infoComplianceDocuments = new TableInfo("compliance_documents", _columnsComplianceDocuments, _foreignKeysComplianceDocuments, _indicesComplianceDocuments);
                TableInfo _existingComplianceDocuments = TableInfo.Companion.read(connection, "compliance_documents");
                if (!_infoComplianceDocuments.equals(_existingComplianceDocuments)) {
                    return new RoomOpenDelegate.ValidationResult(false, "compliance_documents(com.example.data.ComplianceDocument).\n Expected:\n" + _infoComplianceDocuments + "\n Found:\n" + _existingComplianceDocuments);
                }
                Map _columnsComplianceMeetings = new LinkedHashMap();
                _columnsComplianceMeetings.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsComplianceMeetings.put("companyId", new TableInfo.Column("companyId", "INTEGER", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("companyName", new TableInfo.Column("companyName", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("title", new TableInfo.Column("title", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("committeeType", new TableInfo.Column("committeeType", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("meetingDate", new TableInfo.Column("meetingDate", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("meetingTime", new TableInfo.Column("meetingTime", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("locationOrVenue", new TableInfo.Column("locationOrVenue", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("chairperson", new TableInfo.Column("chairperson", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("attendees", new TableInfo.Column("attendees", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("agenda", new TableInfo.Column("agenda", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("minutesOfMeeting", new TableInfo.Column("minutesOfMeeting", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("actionItemsJson", new TableInfo.Column("actionItemsJson", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("status", new TableInfo.Column("status", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("remarks", new TableInfo.Column("remarks", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", true, 0, (String) null, 1));
                _columnsComplianceMeetings.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysComplianceMeetings = new LinkedHashSet();
                Set _indicesComplianceMeetings = new LinkedHashSet();
                TableInfo _infoComplianceMeetings = new TableInfo("compliance_meetings", _columnsComplianceMeetings, _foreignKeysComplianceMeetings, _indicesComplianceMeetings);
                TableInfo _existingComplianceMeetings = TableInfo.Companion.read(connection, "compliance_meetings");
                if (!_infoComplianceMeetings.equals(_existingComplianceMeetings)) {
                    return new RoomOpenDelegate.ValidationResult(false, "compliance_meetings(com.example.data.ComplianceMeeting).\n Expected:\n" + _infoComplianceMeetings + "\n Found:\n" + _existingComplianceMeetings);
                }
                Map _columnsAmcRecords = new LinkedHashMap();
                _columnsAmcRecords.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsAmcRecords.put("companyId", new TableInfo.Column("companyId", "INTEGER", true, 0, (String) null, 1));
                _columnsAmcRecords.put("companyName", new TableInfo.Column("companyName", "TEXT", true, 0, (String) null, 1));
                _columnsAmcRecords.put("equipmentType", new TableInfo.Column("equipmentType", "TEXT", true, 0, (String) null, 1));
                _columnsAmcRecords.put("equipmentName", new TableInfo.Column("equipmentName", "TEXT", true, 0, (String) null, 1));
                _columnsAmcRecords.put("location", new TableInfo.Column("location", "TEXT", true, 0, (String) null, 1));
                _columnsAmcRecords.put("vendor", new TableInfo.Column("vendor", "TEXT", true, 0, (String) null, 1));
                _columnsAmcRecords.put("vendorContact", new TableInfo.Column("vendorContact", "TEXT", true, 0, (String) null, 1));
                _columnsAmcRecords.put("lastServiceDate", new TableInfo.Column("lastServiceDate", "TEXT", true, 0, (String) null, 1));
                _columnsAmcRecords.put("nextServiceDueDate", new TableInfo.Column("nextServiceDueDate", "TEXT", true, 0, (String) null, 1));
                _columnsAmcRecords.put("status", new TableInfo.Column("status", "TEXT", true, 0, (String) null, 1));
                _columnsAmcRecords.put("remarks", new TableInfo.Column("remarks", "TEXT", true, 0, (String) null, 1));
                _columnsAmcRecords.put("contractRefNo", new TableInfo.Column("contractRefNo", "TEXT", true, 0, (String) null, 1));
                _columnsAmcRecords.put("serviceFrequency", new TableInfo.Column("serviceFrequency", "TEXT", true, 0, (String) null, 1));
                _columnsAmcRecords.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, (String) null, 1));
                _columnsAmcRecords.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", true, 0, (String) null, 1));
                _columnsAmcRecords.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysAmcRecords = new LinkedHashSet();
                Set _indicesAmcRecords = new LinkedHashSet();
                TableInfo _infoAmcRecords = new TableInfo("amc_records", _columnsAmcRecords, _foreignKeysAmcRecords, _indicesAmcRecords);
                TableInfo _existingAmcRecords = TableInfo.Companion.read(connection, "amc_records");
                if (!_infoAmcRecords.equals(_existingAmcRecords)) {
                    return new RoomOpenDelegate.ValidationResult(false, "amc_records(com.example.data.AmcRecord).\n Expected:\n" + _infoAmcRecords + "\n Found:\n" + _existingAmcRecords);
                }
                Map _columnsMaterialsFollowUp = new LinkedHashMap();
                _columnsMaterialsFollowUp.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsMaterialsFollowUp.put("companyId", new TableInfo.Column("companyId", "INTEGER", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("companyName", new TableInfo.Column("companyName", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("title", new TableInfo.Column("title", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("category", new TableInfo.Column("category", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("description", new TableInfo.Column("description", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("vendor", new TableInfo.Column("vendor", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("responsiblePerson", new TableInfo.Column("responsiblePerson", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("startDate", new TableInfo.Column("startDate", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("dueDate", new TableInfo.Column("dueDate", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("priority", new TableInfo.Column("priority", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("status", new TableInfo.Column("status", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("remarks", new TableInfo.Column("remarks", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("attachments", new TableInfo.Column("attachments", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("reminderFrequency", new TableInfo.Column("reminderFrequency", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("reminderDateTime", new TableInfo.Column("reminderDateTime", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("isReminderEnabled", new TableInfo.Column("isReminderEnabled", "INTEGER", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("repeatUntilClosed", new TableInfo.Column("repeatUntilClosed", "INTEGER", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("syncState", new TableInfo.Column("syncState", "TEXT", true, 0, (String) null, 1));
                _columnsMaterialsFollowUp.put("lastSyncedAt", new TableInfo.Column("lastSyncedAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysMaterialsFollowUp = new LinkedHashSet();
                Set _indicesMaterialsFollowUp = new LinkedHashSet();
                TableInfo _infoMaterialsFollowUp = new TableInfo("materials_follow_up", _columnsMaterialsFollowUp, _foreignKeysMaterialsFollowUp, _indicesMaterialsFollowUp);
                TableInfo _existingMaterialsFollowUp = TableInfo.Companion.read(connection, "materials_follow_up");
                if (!_infoMaterialsFollowUp.equals(_existingMaterialsFollowUp)) {
                    return new RoomOpenDelegate.ValidationResult(false, "materials_follow_up(com.example.data.MaterialFollowUpRecord).\n Expected:\n" + _infoMaterialsFollowUp + "\n Found:\n" + _existingMaterialsFollowUp);
                }
                Map _columnsEhsGovernanceActivities = new LinkedHashMap();
                _columnsEhsGovernanceActivities.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                _columnsEhsGovernanceActivities.put("username", new TableInfo.Column("username", "TEXT", true, 0, (String) null, 1));
                _columnsEhsGovernanceActivities.put("userFullName", new TableInfo.Column("userFullName", "TEXT", true, 0, (String) null, 1));
                _columnsEhsGovernanceActivities.put("userDesignation", new TableInfo.Column("userDesignation", "TEXT", true, 0, (String) null, 1));
                _columnsEhsGovernanceActivities.put("category", new TableInfo.Column("category", "TEXT", true, 0, (String) null, 1));
                _columnsEhsGovernanceActivities.put("activityName", new TableInfo.Column("activityName", "TEXT", true, 0, (String) null, 1));
                _columnsEhsGovernanceActivities.put("description", new TableInfo.Column("description", "TEXT", true, 0, (String) null, 1));
                _columnsEhsGovernanceActivities.put("date", new TableInfo.Column("date", "TEXT", true, 0, (String) null, 1));
                _columnsEhsGovernanceActivities.put("time", new TableInfo.Column("time", "TEXT", true, 0, (String) null, 1));
                _columnsEhsGovernanceActivities.put("status", new TableInfo.Column("status", "TEXT", true, 0, (String) null, 1));
                _columnsEhsGovernanceActivities.put("remarks", new TableInfo.Column("remarks", "TEXT", true, 0, (String) null, 1));
                _columnsEhsGovernanceActivities.put("photoUri", new TableInfo.Column("photoUri", "TEXT", false, 0, (String) null, 1));
                _columnsEhsGovernanceActivities.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysEhsGovernanceActivities = new LinkedHashSet();
                Set _indicesEhsGovernanceActivities = new LinkedHashSet();
                TableInfo _infoEhsGovernanceActivities = new TableInfo("ehs_governance_activities", _columnsEhsGovernanceActivities, _foreignKeysEhsGovernanceActivities, _indicesEhsGovernanceActivities);
                TableInfo _existingEhsGovernanceActivities = TableInfo.Companion.read(connection, "ehs_governance_activities");
                if (!_infoEhsGovernanceActivities.equals(_existingEhsGovernanceActivities)) {
                    return new RoomOpenDelegate.ValidationResult(false, "ehs_governance_activities(com.example.data.EhsActivityRecord).\n Expected:\n" + _infoEhsGovernanceActivities + "\n Found:\n" + _existingEhsGovernanceActivities);
                }
                return new RoomOpenDelegate.ValidationResult(true, (String) null);
            }
        };
        return _openDelegate;
    }

    protected InvalidationTracker createInvalidationTracker() {
        Map _shadowTablesMap = new LinkedHashMap();
        Map _viewTables = new LinkedHashMap();
        return new InvalidationTracker(this, _shadowTablesMap, _viewTables, new String[]{"companies", "observations", "responsible_persons", "audit_reports", "incidents", "safety_trainings", "compliance_items", "reminder_rules", "reminder_dispatch_logs", "fire_extinguishers", "compliance_documents", "compliance_meetings", "amc_records", "materials_follow_up", "ehs_governance_activities"});
    }

    public void clearAllTables() {
        super.performClear(false, new String[]{"companies", "observations", "responsible_persons", "audit_reports", "incidents", "safety_trainings", "compliance_items", "reminder_rules", "reminder_dispatch_logs", "fire_extinguishers", "compliance_documents", "compliance_meetings", "amc_records", "materials_follow_up", "ehs_governance_activities"});
    }

    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        Map _typeConvertersMap = new LinkedHashMap();
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(CompanyDao.class), CompanyDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(ObservationDao.class), ObservationDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(ResponsiblePersonDao.class), ResponsiblePersonDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(AuditReportDao.class), AuditReportDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(IncidentDao.class), IncidentDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(TrainingDao.class), TrainingDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(ComplianceDao.class), ComplianceDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(ReminderRuleDao.class), ReminderRuleDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(ReminderDispatchLogDao.class), ReminderDispatchLogDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(FireExtinguisherDao.class), FireExtinguisherDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(ComplianceDocumentDao.class), ComplianceDocumentDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(ComplianceMeetingDao.class), ComplianceMeetingDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(AmcRecordDao.class), AmcRecordDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(MaterialFollowUpDao.class), MaterialFollowUpDao_Impl.INSTANCE.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(EhsActivityDao.class), EhsActivityDao_Impl.INSTANCE.getRequiredConverters());
        return _typeConvertersMap;
    }

    public Set<KClass<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        Set _autoMigrationSpecsSet = new LinkedHashSet();
        return _autoMigrationSpecsSet;
    }

    public List<Migration> createAutoMigrations(Map<KClass<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        List _autoMigrations = new ArrayList();
        return _autoMigrations;
    }

    @Override // com.example.data.AppDatabase
    public CompanyDao companyDao() {
        return (CompanyDao) this._companyDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public ObservationDao observationDao() {
        return (ObservationDao) this._observationDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public ResponsiblePersonDao responsiblePersonDao() {
        return (ResponsiblePersonDao) this._responsiblePersonDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public AuditReportDao auditReportDao() {
        return (AuditReportDao) this._auditReportDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public IncidentDao incidentDao() {
        return (IncidentDao) this._incidentDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public TrainingDao trainingDao() {
        return (TrainingDao) this._trainingDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public ComplianceDao complianceDao() {
        return (ComplianceDao) this._complianceDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public ReminderRuleDao reminderRuleDao() {
        return (ReminderRuleDao) this._reminderRuleDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public ReminderDispatchLogDao reminderDispatchLogDao() {
        return (ReminderDispatchLogDao) this._reminderDispatchLogDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public FireExtinguisherDao fireExtinguisherDao() {
        return (FireExtinguisherDao) this._fireExtinguisherDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public ComplianceDocumentDao complianceDocumentDao() {
        return (ComplianceDocumentDao) this._complianceDocumentDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public ComplianceMeetingDao complianceMeetingDao() {
        return (ComplianceMeetingDao) this._complianceMeetingDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public AmcRecordDao amcRecordDao() {
        return (AmcRecordDao) this._amcRecordDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public MaterialFollowUpDao materialFollowUpDao() {
        return (MaterialFollowUpDao) this._materialFollowUpDao.getValue();
    }

    @Override // com.example.data.AppDatabase
    public EhsActivityDao ehsActivityDao() {
        return (EhsActivityDao) this._ehsActivityDao.getValue();
    }
}
