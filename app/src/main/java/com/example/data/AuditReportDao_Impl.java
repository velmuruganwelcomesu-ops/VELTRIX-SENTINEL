package com.example.data;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;

/* compiled from: AuditReportDao_Impl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u000b\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00150\u0014H\u0016J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\u0096@¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\u0096@¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00150\u00142\u0006\u0010\u001a\u001a\u00020\rH\u0016J\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/example/data/AuditReportDao_Impl;", "Lcom/example/data/AuditReportDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfAuditReport", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/data/AuditReport;", "__deleteAdapterOfAuditReport", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfAuditReport", "insertAuditReport", "", "report", "(Lcom/example/data/AuditReport;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAuditReport", "", "updateAuditReport", "getAllAuditReports", "Lkotlinx/coroutines/flow/Flow;", "", "getAllAuditReportsList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingAuditReportsList", "getReportsForCompany", "companyId", "deleteAuditReportById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteReportsForCompany", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes5.dex */
public final class AuditReportDao_Impl implements AuditReportDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<AuditReport> __deleteAdapterOfAuditReport;
    private final EntityInsertAdapter<AuditReport> __insertAdapterOfAuditReport;
    private final EntityDeleteOrUpdateAdapter<AuditReport> __updateAdapterOfAuditReport;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public AuditReportDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfAuditReport = new EntityInsertAdapter<AuditReport>() { // from class: com.example.data.AuditReportDao_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `audit_reports` (`id`,`companyId`,`companyName`,`title`,`dateRange`,`totalObservations`,`pendingCount`,`resolvedCount`,`reportType`,`generatedDate`,`filePath`,`presenterName`,`syncState`,`lastSyncedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, AuditReport entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getCompanyId());
                statement.bindText(3, entity.getCompanyName());
                statement.bindText(4, entity.getTitle());
                statement.bindText(5, entity.getDateRange());
                statement.bindLong(6, entity.getTotalObservations());
                statement.bindLong(7, entity.getPendingCount());
                statement.bindLong(8, entity.getResolvedCount());
                statement.bindText(9, entity.getReportType());
                statement.bindText(10, entity.getGeneratedDate());
                statement.bindText(11, entity.getFilePath());
                statement.bindText(12, entity.getPresenterName());
                statement.bindText(13, entity.getSyncState());
                statement.bindLong(14, entity.getLastSyncedAt());
            }
        };
        this.__deleteAdapterOfAuditReport = new EntityDeleteOrUpdateAdapter<AuditReport>() { // from class: com.example.data.AuditReportDao_Impl.2
            protected String createQuery() {
                return "DELETE FROM `audit_reports` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, AuditReport entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfAuditReport = new EntityDeleteOrUpdateAdapter<AuditReport>() { // from class: com.example.data.AuditReportDao_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `audit_reports` SET `id` = ?,`companyId` = ?,`companyName` = ?,`title` = ?,`dateRange` = ?,`totalObservations` = ?,`pendingCount` = ?,`resolvedCount` = ?,`reportType` = ?,`generatedDate` = ?,`filePath` = ?,`presenterName` = ?,`syncState` = ?,`lastSyncedAt` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, AuditReport entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getCompanyId());
                statement.bindText(3, entity.getCompanyName());
                statement.bindText(4, entity.getTitle());
                statement.bindText(5, entity.getDateRange());
                statement.bindLong(6, entity.getTotalObservations());
                statement.bindLong(7, entity.getPendingCount());
                statement.bindLong(8, entity.getResolvedCount());
                statement.bindText(9, entity.getReportType());
                statement.bindText(10, entity.getGeneratedDate());
                statement.bindText(11, entity.getFilePath());
                statement.bindText(12, entity.getPresenterName());
                statement.bindText(13, entity.getSyncState());
                statement.bindLong(14, entity.getLastSyncedAt());
                statement.bindLong(15, entity.getId());
            }
        };
    }

    @Override // com.example.data.AuditReportDao
    public Object insertAuditReport(final AuditReport report, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.AuditReportDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return Long.valueOf(AuditReportDao_Impl.insertAuditReport$lambda$0(AuditReportDao_Impl.this, report, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long insertAuditReport$lambda$0(AuditReportDao_Impl this$0, AuditReport $report, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        long _result = this$0.__insertAdapterOfAuditReport.insertAndReturnId(_connection, $report);
        return _result;
    }

    @Override // com.example.data.AuditReportDao
    public Object deleteAuditReport(final AuditReport report, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.AuditReportDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return AuditReportDao_Impl.deleteAuditReport$lambda$1(AuditReportDao_Impl.this, report, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteAuditReport$lambda$1(AuditReportDao_Impl this$0, AuditReport $report, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__deleteAdapterOfAuditReport.handle(_connection, $report);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.AuditReportDao
    public Object updateAuditReport(final AuditReport report, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.AuditReportDao_Impl$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return AuditReportDao_Impl.updateAuditReport$lambda$2(AuditReportDao_Impl.this, report, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit updateAuditReport$lambda$2(AuditReportDao_Impl this$0, AuditReport $report, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__updateAdapterOfAuditReport.handle(_connection, $report);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.AuditReportDao
    public Flow<List<AuditReport>> getAllAuditReports() {
        final String _sql = "SELECT * FROM audit_reports ORDER BY id DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"audit_reports"}, new Function1() { // from class: com.example.data.AuditReportDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return AuditReportDao_Impl.getAllAuditReports$lambda$3(_sql, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getAllAuditReports$lambda$3(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfCompanyId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyId");
            int _columnIndexOfCompanyName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyName");
            int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
            int _columnIndexOfDateRange = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "dateRange");
            int _columnIndexOfTotalObservations = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalObservations");
            int _columnIndexOfPendingCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "pendingCount");
            int _columnIndexOfResolvedCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "resolvedCount");
            int _columnIndexOfReportType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reportType");
            int _columnIndexOfGeneratedDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "generatedDate");
            int _columnIndexOfFilePath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filePath");
            int _columnIndexOfPresenterName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "presenterName");
            int _columnIndexOfSyncState = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "syncState");
            int _columnIndexOfLastSyncedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lastSyncedAt");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                long _tmpCompanyId = _stmt.getLong(_columnIndexOfCompanyId);
                String _tmpCompanyName = _stmt.getText(_columnIndexOfCompanyName);
                String _tmpTitle = _stmt.getText(_columnIndexOfTitle);
                String _tmpDateRange = _stmt.getText(_columnIndexOfDateRange);
                int _columnIndexOfCompanyId2 = _columnIndexOfCompanyId;
                int _columnIndexOfCompanyName2 = _columnIndexOfCompanyName;
                int _tmpTotalObservations = (int) _stmt.getLong(_columnIndexOfTotalObservations);
                int _tmpPendingCount = (int) _stmt.getLong(_columnIndexOfPendingCount);
                int _tmpResolvedCount = (int) _stmt.getLong(_columnIndexOfResolvedCount);
                String _tmpReportType = _stmt.getText(_columnIndexOfReportType);
                String _tmpGeneratedDate = _stmt.getText(_columnIndexOfGeneratedDate);
                String _tmpFilePath = _stmt.getText(_columnIndexOfFilePath);
                String _tmpPresenterName = _stmt.getText(_columnIndexOfPresenterName);
                String _tmpSyncState = _stmt.getText(_columnIndexOfSyncState);
                long _tmpLastSyncedAt = _stmt.getLong(_columnIndexOfLastSyncedAt);
                AuditReport _item = new AuditReport(_tmpId, _tmpCompanyId, _tmpCompanyName, _tmpTitle, _tmpDateRange, _tmpTotalObservations, _tmpPendingCount, _tmpResolvedCount, _tmpReportType, _tmpGeneratedDate, _tmpFilePath, _tmpPresenterName, _tmpSyncState, _tmpLastSyncedAt);
                List _result2 = _result;
                _result2.add(_item);
                _result = _result2;
                _columnIndexOfCompanyId = _columnIndexOfCompanyId2;
                _columnIndexOfCompanyName = _columnIndexOfCompanyName2;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.AuditReportDao
    public Object getAllAuditReportsList(Continuation<? super List<AuditReport>> continuation) {
        final String _sql = "SELECT * FROM audit_reports ORDER BY id DESC";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.example.data.AuditReportDao_Impl$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return AuditReportDao_Impl.getAllAuditReportsList$lambda$4(_sql, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getAllAuditReportsList$lambda$4(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfCompanyId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyId");
            int _columnIndexOfCompanyName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyName");
            int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
            int _columnIndexOfDateRange = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "dateRange");
            int _columnIndexOfTotalObservations = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalObservations");
            int _columnIndexOfPendingCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "pendingCount");
            int _columnIndexOfResolvedCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "resolvedCount");
            int _columnIndexOfReportType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reportType");
            int _columnIndexOfGeneratedDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "generatedDate");
            int _columnIndexOfFilePath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filePath");
            int _columnIndexOfPresenterName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "presenterName");
            int _columnIndexOfSyncState = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "syncState");
            int _columnIndexOfLastSyncedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lastSyncedAt");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                long _tmpCompanyId = _stmt.getLong(_columnIndexOfCompanyId);
                String _tmpCompanyName = _stmt.getText(_columnIndexOfCompanyName);
                String _tmpTitle = _stmt.getText(_columnIndexOfTitle);
                String _tmpDateRange = _stmt.getText(_columnIndexOfDateRange);
                int _columnIndexOfCompanyId2 = _columnIndexOfCompanyId;
                int _columnIndexOfCompanyName2 = _columnIndexOfCompanyName;
                int _tmpTotalObservations = (int) _stmt.getLong(_columnIndexOfTotalObservations);
                int _tmpPendingCount = (int) _stmt.getLong(_columnIndexOfPendingCount);
                int _tmpResolvedCount = (int) _stmt.getLong(_columnIndexOfResolvedCount);
                String _tmpReportType = _stmt.getText(_columnIndexOfReportType);
                String _tmpGeneratedDate = _stmt.getText(_columnIndexOfGeneratedDate);
                String _tmpFilePath = _stmt.getText(_columnIndexOfFilePath);
                String _tmpPresenterName = _stmt.getText(_columnIndexOfPresenterName);
                String _tmpSyncState = _stmt.getText(_columnIndexOfSyncState);
                long _tmpLastSyncedAt = _stmt.getLong(_columnIndexOfLastSyncedAt);
                AuditReport _item = new AuditReport(_tmpId, _tmpCompanyId, _tmpCompanyName, _tmpTitle, _tmpDateRange, _tmpTotalObservations, _tmpPendingCount, _tmpResolvedCount, _tmpReportType, _tmpGeneratedDate, _tmpFilePath, _tmpPresenterName, _tmpSyncState, _tmpLastSyncedAt);
                List _result2 = _result;
                _result2.add(_item);
                _result = _result2;
                _columnIndexOfCompanyId = _columnIndexOfCompanyId2;
                _columnIndexOfCompanyName = _columnIndexOfCompanyName2;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.AuditReportDao
    public Object getPendingAuditReportsList(Continuation<? super List<AuditReport>> continuation) {
        final String _sql = "SELECT * FROM audit_reports WHERE pendingCount > 0";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.example.data.AuditReportDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return AuditReportDao_Impl.getPendingAuditReportsList$lambda$5(_sql, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getPendingAuditReportsList$lambda$5(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfCompanyId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyId");
            int _columnIndexOfCompanyName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyName");
            int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
            int _columnIndexOfDateRange = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "dateRange");
            int _columnIndexOfTotalObservations = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalObservations");
            int _columnIndexOfPendingCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "pendingCount");
            int _columnIndexOfResolvedCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "resolvedCount");
            int _columnIndexOfReportType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reportType");
            int _columnIndexOfGeneratedDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "generatedDate");
            int _columnIndexOfFilePath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filePath");
            int _columnIndexOfPresenterName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "presenterName");
            int _columnIndexOfSyncState = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "syncState");
            int _columnIndexOfLastSyncedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lastSyncedAt");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                long _tmpCompanyId = _stmt.getLong(_columnIndexOfCompanyId);
                String _tmpCompanyName = _stmt.getText(_columnIndexOfCompanyName);
                String _tmpTitle = _stmt.getText(_columnIndexOfTitle);
                String _tmpDateRange = _stmt.getText(_columnIndexOfDateRange);
                int _columnIndexOfCompanyId2 = _columnIndexOfCompanyId;
                int _columnIndexOfCompanyName2 = _columnIndexOfCompanyName;
                int _tmpTotalObservations = (int) _stmt.getLong(_columnIndexOfTotalObservations);
                int _tmpPendingCount = (int) _stmt.getLong(_columnIndexOfPendingCount);
                int _tmpResolvedCount = (int) _stmt.getLong(_columnIndexOfResolvedCount);
                String _tmpReportType = _stmt.getText(_columnIndexOfReportType);
                String _tmpGeneratedDate = _stmt.getText(_columnIndexOfGeneratedDate);
                String _tmpFilePath = _stmt.getText(_columnIndexOfFilePath);
                String _tmpPresenterName = _stmt.getText(_columnIndexOfPresenterName);
                String _tmpSyncState = _stmt.getText(_columnIndexOfSyncState);
                long _tmpLastSyncedAt = _stmt.getLong(_columnIndexOfLastSyncedAt);
                AuditReport _item = new AuditReport(_tmpId, _tmpCompanyId, _tmpCompanyName, _tmpTitle, _tmpDateRange, _tmpTotalObservations, _tmpPendingCount, _tmpResolvedCount, _tmpReportType, _tmpGeneratedDate, _tmpFilePath, _tmpPresenterName, _tmpSyncState, _tmpLastSyncedAt);
                List _result2 = _result;
                _result2.add(_item);
                _result = _result2;
                _columnIndexOfCompanyId = _columnIndexOfCompanyId2;
                _columnIndexOfCompanyName = _columnIndexOfCompanyName2;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.AuditReportDao
    public Flow<List<AuditReport>> getReportsForCompany(final long companyId) {
        final String _sql = "SELECT * FROM audit_reports WHERE companyId = ? ORDER BY id DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"audit_reports"}, new Function1() { // from class: com.example.data.AuditReportDao_Impl$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return AuditReportDao_Impl.getReportsForCompany$lambda$6(_sql, companyId, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getReportsForCompany$lambda$6(String $_sql, long $companyId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $companyId);
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfCompanyId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyId");
            int _columnIndexOfCompanyName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyName");
            int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
            int _columnIndexOfDateRange = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "dateRange");
            int _columnIndexOfTotalObservations = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalObservations");
            int _columnIndexOfPendingCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "pendingCount");
            int _columnIndexOfResolvedCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "resolvedCount");
            int _columnIndexOfReportType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reportType");
            int _columnIndexOfGeneratedDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "generatedDate");
            int _columnIndexOfFilePath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filePath");
            int _columnIndexOfPresenterName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "presenterName");
            int _columnIndexOfSyncState = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "syncState");
            int _columnIndexOfLastSyncedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lastSyncedAt");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                long _tmpCompanyId = _stmt.getLong(_columnIndexOfCompanyId);
                String _tmpCompanyName = _stmt.getText(_columnIndexOfCompanyName);
                String _tmpTitle = _stmt.getText(_columnIndexOfTitle);
                String _tmpDateRange = _stmt.getText(_columnIndexOfDateRange);
                int _columnIndexOfId2 = _columnIndexOfId;
                int _columnIndexOfCompanyId2 = _columnIndexOfCompanyId;
                int _tmpTotalObservations = (int) _stmt.getLong(_columnIndexOfTotalObservations);
                int _tmpPendingCount = (int) _stmt.getLong(_columnIndexOfPendingCount);
                int _tmpResolvedCount = (int) _stmt.getLong(_columnIndexOfResolvedCount);
                String _tmpReportType = _stmt.getText(_columnIndexOfReportType);
                String _tmpGeneratedDate = _stmt.getText(_columnIndexOfGeneratedDate);
                String _tmpFilePath = _stmt.getText(_columnIndexOfFilePath);
                String _tmpPresenterName = _stmt.getText(_columnIndexOfPresenterName);
                String _tmpSyncState = _stmt.getText(_columnIndexOfSyncState);
                long _tmpLastSyncedAt = _stmt.getLong(_columnIndexOfLastSyncedAt);
                AuditReport _item = new AuditReport(_tmpId, _tmpCompanyId, _tmpCompanyName, _tmpTitle, _tmpDateRange, _tmpTotalObservations, _tmpPendingCount, _tmpResolvedCount, _tmpReportType, _tmpGeneratedDate, _tmpFilePath, _tmpPresenterName, _tmpSyncState, _tmpLastSyncedAt);
                _result.add(_item);
                _columnIndexOfId = _columnIndexOfId2;
                _columnIndexOfCompanyId = _columnIndexOfCompanyId2;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.AuditReportDao
    public Object deleteAuditReportById(final long id, Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM audit_reports WHERE id = ?";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.AuditReportDao_Impl$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return AuditReportDao_Impl.deleteAuditReportById$lambda$7(_sql, id, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteAuditReportById$lambda$7(String $_sql, long $id, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $id);
            _stmt.step();
            _stmt.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    @Override // com.example.data.AuditReportDao
    public Object deleteReportsForCompany(final long companyId, Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM audit_reports WHERE companyId = ?";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.AuditReportDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return AuditReportDao_Impl.deleteReportsForCompany$lambda$8(_sql, companyId, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteReportsForCompany$lambda$8(String $_sql, long $companyId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $companyId);
            _stmt.step();
            _stmt.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    /* compiled from: AuditReportDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/example/data/AuditReportDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /tmp/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}
