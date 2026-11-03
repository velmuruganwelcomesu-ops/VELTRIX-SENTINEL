package com.example.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: Daos.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH'J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\bH§@¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\bH§@¢\u0006\u0002\u0010\u000b¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/example/data/AmcRecordDao;", "", "getAllAmcRecords", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/AmcRecord;", "getAmcRecordsForCompany", "companyId", "", "getAmcRecordById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAmcRecordsList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAmcRecord", "record", "(Lcom/example/data/AmcRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAllAmcRecords", "", "records", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAmcRecord", "deleteAmcRecord", "deleteAmcRecordById", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes5.dex */
public interface AmcRecordDao {
    Object deleteAmcRecord(AmcRecord amcRecord, Continuation<? super Unit> continuation);

    Object deleteAmcRecordById(long j, Continuation<? super Unit> continuation);

    Flow<List<AmcRecord>> getAllAmcRecords();

    Object getAllAmcRecordsList(Continuation<? super List<AmcRecord>> continuation);

    Object getAmcRecordById(long j, Continuation<? super AmcRecord> continuation);

    Flow<List<AmcRecord>> getAmcRecordsForCompany(long companyId);

    Object insertAllAmcRecords(List<AmcRecord> list, Continuation<? super Unit> continuation);

    Object insertAmcRecord(AmcRecord amcRecord, Continuation<? super Long> continuation);

    Object updateAmcRecord(AmcRecord amcRecord, Continuation<? super Unit> continuation);
}
