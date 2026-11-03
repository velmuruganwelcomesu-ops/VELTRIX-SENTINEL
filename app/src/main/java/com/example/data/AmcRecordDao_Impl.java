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

/* compiled from: AmcRecordDao_Impl.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u0018H\u0016J\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00182\u0006\u0010\u001a\u001a\u00020\rH\u0016J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0096@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/example/data/AmcRecordDao_Impl;", "Lcom/example/data/AmcRecordDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfAmcRecord", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/data/AmcRecord;", "__deleteAdapterOfAmcRecord", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfAmcRecord", "insertAmcRecord", "", "record", "(Lcom/example/data/AmcRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAllAmcRecords", "", "records", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAmcRecord", "updateAmcRecord", "getAllAmcRecords", "Lkotlinx/coroutines/flow/Flow;", "getAmcRecordsForCompany", "companyId", "getAmcRecordById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAmcRecordsList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAmcRecordById", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes5.dex */
public final class AmcRecordDao_Impl implements AmcRecordDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<AmcRecord> __deleteAdapterOfAmcRecord;
    private final EntityInsertAdapter<AmcRecord> __insertAdapterOfAmcRecord;
    private final EntityDeleteOrUpdateAdapter<AmcRecord> __updateAdapterOfAmcRecord;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public AmcRecordDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfAmcRecord = new EntityInsertAdapter<AmcRecord>() { // from class: com.example.data.AmcRecordDao_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `amc_records` (`id`,`companyId`,`companyName`,`equipmentType`,`equipmentName`,`location`,`vendor`,`vendorContact`,`lastServiceDate`,`nextServiceDueDate`,`status`,`remarks`,`contractRefNo`,`serviceFrequency`,`syncState`,`lastSyncedAt`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, AmcRecord entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getCompanyId());
                statement.bindText(3, entity.getCompanyName());
                statement.bindText(4, entity.getEquipmentType());
                statement.bindText(5, entity.getEquipmentName());
                statement.bindText(6, entity.getLocation());
                statement.bindText(7, entity.getVendor());
                statement.bindText(8, entity.getVendorContact());
                statement.bindText(9, entity.getLastServiceDate());
                statement.bindText(10, entity.getNextServiceDueDate());
                statement.bindText(11, entity.getStatus());
                statement.bindText(12, entity.getRemarks());
                statement.bindText(13, entity.getContractRefNo());
                statement.bindText(14, entity.getServiceFrequency());
                statement.bindText(15, entity.getSyncState());
                statement.bindLong(16, entity.getLastSyncedAt());
                statement.bindLong(17, entity.getCreatedAt());
            }
        };
        this.__deleteAdapterOfAmcRecord = new EntityDeleteOrUpdateAdapter<AmcRecord>() { // from class: com.example.data.AmcRecordDao_Impl.2
            protected String createQuery() {
                return "DELETE FROM `amc_records` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, AmcRecord entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfAmcRecord = new EntityDeleteOrUpdateAdapter<AmcRecord>() { // from class: com.example.data.AmcRecordDao_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `amc_records` SET `id` = ?,`companyId` = ?,`companyName` = ?,`equipmentType` = ?,`equipmentName` = ?,`location` = ?,`vendor` = ?,`vendorContact` = ?,`lastServiceDate` = ?,`nextServiceDueDate` = ?,`status` = ?,`remarks` = ?,`contractRefNo` = ?,`serviceFrequency` = ?,`syncState` = ?,`lastSyncedAt` = ?,`createdAt` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, AmcRecord entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getCompanyId());
                statement.bindText(3, entity.getCompanyName());
                statement.bindText(4, entity.getEquipmentType());
                statement.bindText(5, entity.getEquipmentName());
                statement.bindText(6, entity.getLocation());
                statement.bindText(7, entity.getVendor());
                statement.bindText(8, entity.getVendorContact());
                statement.bindText(9, entity.getLastServiceDate());
                statement.bindText(10, entity.getNextServiceDueDate());
                statement.bindText(11, entity.getStatus());
                statement.bindText(12, entity.getRemarks());
                statement.bindText(13, entity.getContractRefNo());
                statement.bindText(14, entity.getServiceFrequency());
                statement.bindText(15, entity.getSyncState());
                statement.bindLong(16, entity.getLastSyncedAt());
                statement.bindLong(17, entity.getCreatedAt());
                statement.bindLong(18, entity.getId());
            }
        };
    }

    @Override // com.example.data.AmcRecordDao
    public Object insertAmcRecord(final AmcRecord record, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.AmcRecordDao_Impl$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return Long.valueOf(AmcRecordDao_Impl.insertAmcRecord$lambda$0(AmcRecordDao_Impl.this, record, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long insertAmcRecord$lambda$0(AmcRecordDao_Impl this$0, AmcRecord $record, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        long _result = this$0.__insertAdapterOfAmcRecord.insertAndReturnId(_connection, $record);
        return _result;
    }

    @Override // com.example.data.AmcRecordDao
    public Object insertAllAmcRecords(final List<AmcRecord> list, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.AmcRecordDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return AmcRecordDao_Impl.insertAllAmcRecords$lambda$1(AmcRecordDao_Impl.this, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit insertAllAmcRecords$lambda$1(AmcRecordDao_Impl this$0, List $records, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__insertAdapterOfAmcRecord.insert(_connection, $records);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.AmcRecordDao
    public Object deleteAmcRecord(final AmcRecord record, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.AmcRecordDao_Impl$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return AmcRecordDao_Impl.deleteAmcRecord$lambda$2(AmcRecordDao_Impl.this, record, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteAmcRecord$lambda$2(AmcRecordDao_Impl this$0, AmcRecord $record, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__deleteAdapterOfAmcRecord.handle(_connection, $record);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.AmcRecordDao
    public Object updateAmcRecord(final AmcRecord record, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.AmcRecordDao_Impl$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return AmcRecordDao_Impl.updateAmcRecord$lambda$3(AmcRecordDao_Impl.this, record, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit updateAmcRecord$lambda$3(AmcRecordDao_Impl this$0, AmcRecord $record, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__updateAdapterOfAmcRecord.handle(_connection, $record);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.AmcRecordDao
    public Flow<List<AmcRecord>> getAllAmcRecords() {
        final String _sql = "SELECT * FROM amc_records ORDER BY nextServiceDueDate ASC, id DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"amc_records"}, new Function1() { // from class: com.example.data.AmcRecordDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return AmcRecordDao_Impl.getAllAmcRecords$lambda$4(_sql, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getAllAmcRecords$lambda$4(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfCompanyId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyId");
            int _columnIndexOfCompanyName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyName");
            int _columnIndexOfEquipmentType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "equipmentType");
            int _columnIndexOfEquipmentName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "equipmentName");
            int _columnIndexOfLocation = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "location");
            int _columnIndexOfVendor = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "vendor");
            int _columnIndexOfVendorContact = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "vendorContact");
            int _columnIndexOfLastServiceDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lastServiceDate");
            int _columnIndexOfNextServiceDueDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nextServiceDueDate");
            int _columnIndexOfStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "status");
            int _columnIndexOfRemarks = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "remarks");
            int _columnIndexOfContractRefNo = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "contractRefNo");
            int _columnIndexOfServiceFrequency = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "serviceFrequency");
            int _columnIndexOfSyncState = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "syncState");
            int _columnIndexOfSyncState2 = _columnIndexOfSyncState;
            int _columnIndexOfLastSyncedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lastSyncedAt");
            int _columnIndexOfServiceFrequency2 = _columnIndexOfLastSyncedAt;
            int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                long _tmpCompanyId = _stmt.getLong(_columnIndexOfCompanyId);
                String _tmpCompanyName = _stmt.getText(_columnIndexOfCompanyName);
                String _tmpEquipmentType = _stmt.getText(_columnIndexOfEquipmentType);
                String _tmpEquipmentName = _stmt.getText(_columnIndexOfEquipmentName);
                String _tmpLocation = _stmt.getText(_columnIndexOfLocation);
                String _tmpVendor = _stmt.getText(_columnIndexOfVendor);
                String _tmpVendorContact = _stmt.getText(_columnIndexOfVendorContact);
                String _tmpLastServiceDate = _stmt.getText(_columnIndexOfLastServiceDate);
                String _tmpNextServiceDueDate = _stmt.getText(_columnIndexOfNextServiceDueDate);
                String _tmpStatus = _stmt.getText(_columnIndexOfStatus);
                String _tmpRemarks = _stmt.getText(_columnIndexOfRemarks);
                String _tmpContractRefNo = _stmt.getText(_columnIndexOfContractRefNo);
                String _tmpServiceFrequency = _stmt.getText(_columnIndexOfServiceFrequency);
                int _columnIndexOfId2 = _columnIndexOfId;
                int _columnIndexOfId3 = _columnIndexOfSyncState2;
                String _tmpSyncState = _stmt.getText(_columnIndexOfId3);
                _columnIndexOfSyncState2 = _columnIndexOfId3;
                int _columnIndexOfSyncState3 = _columnIndexOfServiceFrequency2;
                long _tmpLastSyncedAt = _stmt.getLong(_columnIndexOfSyncState3);
                long _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
                AmcRecord _item = new AmcRecord(_tmpId, _tmpCompanyId, _tmpCompanyName, _tmpEquipmentType, _tmpEquipmentName, _tmpLocation, _tmpVendor, _tmpVendorContact, _tmpLastServiceDate, _tmpNextServiceDueDate, _tmpStatus, _tmpRemarks, _tmpContractRefNo, _tmpServiceFrequency, _tmpSyncState, _tmpLastSyncedAt, _tmpCreatedAt);
                int _columnIndexOfServiceFrequency3 = _columnIndexOfServiceFrequency;
                List _result2 = _result;
                _result2.add(_item);
                _result = _result2;
                _columnIndexOfServiceFrequency = _columnIndexOfServiceFrequency3;
                _columnIndexOfServiceFrequency2 = _columnIndexOfSyncState3;
                _columnIndexOfId = _columnIndexOfId2;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.AmcRecordDao
    public Flow<List<AmcRecord>> getAmcRecordsForCompany(final long companyId) {
        final String _sql = "SELECT * FROM amc_records WHERE companyId = ? ORDER BY nextServiceDueDate ASC, id DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"amc_records"}, new Function1() { // from class: com.example.data.AmcRecordDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return AmcRecordDao_Impl.getAmcRecordsForCompany$lambda$5(_sql, companyId, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getAmcRecordsForCompany$lambda$5(String $_sql, long $companyId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $companyId);
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfCompanyId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyId");
            int _columnIndexOfCompanyName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyName");
            int _columnIndexOfEquipmentType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "equipmentType");
            int _columnIndexOfEquipmentName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "equipmentName");
            int _columnIndexOfLocation = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "location");
            int _columnIndexOfVendor = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "vendor");
            int _columnIndexOfVendorContact = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "vendorContact");
            int _columnIndexOfLastServiceDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lastServiceDate");
            int _columnIndexOfNextServiceDueDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nextServiceDueDate");
            int _columnIndexOfStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "status");
            int _columnIndexOfRemarks = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "remarks");
            int _columnIndexOfContractRefNo = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "contractRefNo");
            int _columnIndexOfServiceFrequency = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "serviceFrequency");
            int _columnIndexOfSyncState = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "syncState");
            int _columnIndexOfSyncState2 = _columnIndexOfSyncState;
            int _columnIndexOfLastSyncedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lastSyncedAt");
            int _columnIndexOfRemarks2 = _columnIndexOfLastSyncedAt;
            int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                long _tmpCompanyId = _stmt.getLong(_columnIndexOfCompanyId);
                String _tmpCompanyName = _stmt.getText(_columnIndexOfCompanyName);
                String _tmpEquipmentType = _stmt.getText(_columnIndexOfEquipmentType);
                String _tmpEquipmentName = _stmt.getText(_columnIndexOfEquipmentName);
                String _tmpLocation = _stmt.getText(_columnIndexOfLocation);
                String _tmpVendor = _stmt.getText(_columnIndexOfVendor);
                String _tmpVendorContact = _stmt.getText(_columnIndexOfVendorContact);
                String _tmpLastServiceDate = _stmt.getText(_columnIndexOfLastServiceDate);
                String _tmpNextServiceDueDate = _stmt.getText(_columnIndexOfNextServiceDueDate);
                String _tmpStatus = _stmt.getText(_columnIndexOfStatus);
                String _tmpRemarks = _stmt.getText(_columnIndexOfRemarks);
                String _tmpContractRefNo = _stmt.getText(_columnIndexOfContractRefNo);
                String _tmpServiceFrequency = _stmt.getText(_columnIndexOfServiceFrequency);
                int _columnIndexOfStatus2 = _columnIndexOfStatus;
                int _columnIndexOfStatus3 = _columnIndexOfSyncState2;
                String _tmpSyncState = _stmt.getText(_columnIndexOfStatus3);
                _columnIndexOfSyncState2 = _columnIndexOfStatus3;
                int _columnIndexOfSyncState3 = _columnIndexOfRemarks2;
                long _tmpLastSyncedAt = _stmt.getLong(_columnIndexOfSyncState3);
                long _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
                AmcRecord _item = new AmcRecord(_tmpId, _tmpCompanyId, _tmpCompanyName, _tmpEquipmentType, _tmpEquipmentName, _tmpLocation, _tmpVendor, _tmpVendorContact, _tmpLastServiceDate, _tmpNextServiceDueDate, _tmpStatus, _tmpRemarks, _tmpContractRefNo, _tmpServiceFrequency, _tmpSyncState, _tmpLastSyncedAt, _tmpCreatedAt);
                int _columnIndexOfRemarks3 = _columnIndexOfRemarks;
                List _result2 = _result;
                _result2.add(_item);
                _result = _result2;
                _columnIndexOfRemarks = _columnIndexOfRemarks3;
                _columnIndexOfRemarks2 = _columnIndexOfSyncState3;
                _columnIndexOfStatus = _columnIndexOfStatus2;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.AmcRecordDao
    public Object getAmcRecordById(final long id, Continuation<? super AmcRecord> continuation) {
        final String _sql = "SELECT * FROM amc_records WHERE id = ? LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.example.data.AmcRecordDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return AmcRecordDao_Impl.getAmcRecordById$lambda$6(_sql, id, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final AmcRecord getAmcRecordById$lambda$6(String $_sql, long $id, SQLiteConnection _connection) {
        AmcRecord _result;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $id);
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfCompanyId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyId");
            int _columnIndexOfCompanyName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyName");
            int _columnIndexOfEquipmentType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "equipmentType");
            int _columnIndexOfEquipmentName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "equipmentName");
            int _columnIndexOfLocation = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "location");
            int _columnIndexOfVendor = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "vendor");
            int _columnIndexOfVendorContact = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "vendorContact");
            int _columnIndexOfLastServiceDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lastServiceDate");
            int _columnIndexOfNextServiceDueDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nextServiceDueDate");
            int _columnIndexOfStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "status");
            int _columnIndexOfRemarks = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "remarks");
            int _columnIndexOfContractRefNo = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "contractRefNo");
            int _columnIndexOfServiceFrequency = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "serviceFrequency");
            int _columnIndexOfSyncState = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "syncState");
            int _columnIndexOfLastSyncedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lastSyncedAt");
            int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
            if (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                long _tmpCompanyId = _stmt.getLong(_columnIndexOfCompanyId);
                String _tmpCompanyName = _stmt.getText(_columnIndexOfCompanyName);
                String _tmpEquipmentType = _stmt.getText(_columnIndexOfEquipmentType);
                String _tmpEquipmentName = _stmt.getText(_columnIndexOfEquipmentName);
                String _tmpLocation = _stmt.getText(_columnIndexOfLocation);
                String _tmpVendor = _stmt.getText(_columnIndexOfVendor);
                String _tmpVendorContact = _stmt.getText(_columnIndexOfVendorContact);
                String _tmpLastServiceDate = _stmt.getText(_columnIndexOfLastServiceDate);
                String _tmpNextServiceDueDate = _stmt.getText(_columnIndexOfNextServiceDueDate);
                String _tmpStatus = _stmt.getText(_columnIndexOfStatus);
                String _tmpRemarks = _stmt.getText(_columnIndexOfRemarks);
                String _tmpContractRefNo = _stmt.getText(_columnIndexOfContractRefNo);
                String _tmpServiceFrequency = _stmt.getText(_columnIndexOfServiceFrequency);
                String _tmpSyncState = _stmt.getText(_columnIndexOfSyncState);
                long _tmpLastSyncedAt = _stmt.getLong(_columnIndexOfLastSyncedAt);
                long _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
                _result = new AmcRecord(_tmpId, _tmpCompanyId, _tmpCompanyName, _tmpEquipmentType, _tmpEquipmentName, _tmpLocation, _tmpVendor, _tmpVendorContact, _tmpLastServiceDate, _tmpNextServiceDueDate, _tmpStatus, _tmpRemarks, _tmpContractRefNo, _tmpServiceFrequency, _tmpSyncState, _tmpLastSyncedAt, _tmpCreatedAt);
            } else {
                _result = null;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.AmcRecordDao
    public Object getAllAmcRecordsList(Continuation<? super List<AmcRecord>> continuation) {
        final String _sql = "SELECT * FROM amc_records ORDER BY nextServiceDueDate ASC, id DESC";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.example.data.AmcRecordDao_Impl$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return AmcRecordDao_Impl.getAllAmcRecordsList$lambda$7(_sql, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List getAllAmcRecordsList$lambda$7(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            int _columnIndexOfCompanyId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyId");
            int _columnIndexOfCompanyName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "companyName");
            int _columnIndexOfEquipmentType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "equipmentType");
            int _columnIndexOfEquipmentName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "equipmentName");
            int _columnIndexOfLocation = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "location");
            int _columnIndexOfVendor = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "vendor");
            int _columnIndexOfVendorContact = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "vendorContact");
            int _columnIndexOfLastServiceDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lastServiceDate");
            int _columnIndexOfNextServiceDueDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nextServiceDueDate");
            int _columnIndexOfStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "status");
            int _columnIndexOfRemarks = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "remarks");
            int _columnIndexOfContractRefNo = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "contractRefNo");
            int _columnIndexOfServiceFrequency = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "serviceFrequency");
            int _columnIndexOfSyncState = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "syncState");
            int _columnIndexOfSyncState2 = _columnIndexOfSyncState;
            int _columnIndexOfLastSyncedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "lastSyncedAt");
            int _columnIndexOfServiceFrequency2 = _columnIndexOfLastSyncedAt;
            int _columnIndexOfCreatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdAt");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_columnIndexOfId);
                long _tmpCompanyId = _stmt.getLong(_columnIndexOfCompanyId);
                String _tmpCompanyName = _stmt.getText(_columnIndexOfCompanyName);
                String _tmpEquipmentType = _stmt.getText(_columnIndexOfEquipmentType);
                String _tmpEquipmentName = _stmt.getText(_columnIndexOfEquipmentName);
                String _tmpLocation = _stmt.getText(_columnIndexOfLocation);
                String _tmpVendor = _stmt.getText(_columnIndexOfVendor);
                String _tmpVendorContact = _stmt.getText(_columnIndexOfVendorContact);
                String _tmpLastServiceDate = _stmt.getText(_columnIndexOfLastServiceDate);
                String _tmpNextServiceDueDate = _stmt.getText(_columnIndexOfNextServiceDueDate);
                String _tmpStatus = _stmt.getText(_columnIndexOfStatus);
                String _tmpRemarks = _stmt.getText(_columnIndexOfRemarks);
                String _tmpContractRefNo = _stmt.getText(_columnIndexOfContractRefNo);
                String _tmpServiceFrequency = _stmt.getText(_columnIndexOfServiceFrequency);
                int _columnIndexOfId2 = _columnIndexOfId;
                int _columnIndexOfId3 = _columnIndexOfSyncState2;
                String _tmpSyncState = _stmt.getText(_columnIndexOfId3);
                _columnIndexOfSyncState2 = _columnIndexOfId3;
                int _columnIndexOfSyncState3 = _columnIndexOfServiceFrequency2;
                long _tmpLastSyncedAt = _stmt.getLong(_columnIndexOfSyncState3);
                long _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt);
                AmcRecord _item = new AmcRecord(_tmpId, _tmpCompanyId, _tmpCompanyName, _tmpEquipmentType, _tmpEquipmentName, _tmpLocation, _tmpVendor, _tmpVendorContact, _tmpLastServiceDate, _tmpNextServiceDueDate, _tmpStatus, _tmpRemarks, _tmpContractRefNo, _tmpServiceFrequency, _tmpSyncState, _tmpLastSyncedAt, _tmpCreatedAt);
                int _columnIndexOfServiceFrequency3 = _columnIndexOfServiceFrequency;
                List _result2 = _result;
                _result2.add(_item);
                _result = _result2;
                _columnIndexOfServiceFrequency = _columnIndexOfServiceFrequency3;
                _columnIndexOfServiceFrequency2 = _columnIndexOfSyncState3;
                _columnIndexOfId = _columnIndexOfId2;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // com.example.data.AmcRecordDao
    public Object deleteAmcRecordById(final long id, Continuation<? super Unit> continuation) {
        final String _sql = "DELETE FROM amc_records WHERE id = ?";
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.AmcRecordDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return AmcRecordDao_Impl.deleteAmcRecordById$lambda$8(_sql, id, (SQLiteConnection) obj);
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit deleteAmcRecordById$lambda$8(String $_sql, long $id, SQLiteConnection _connection) {
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

    /* compiled from: AmcRecordDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/example/data/AmcRecordDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
