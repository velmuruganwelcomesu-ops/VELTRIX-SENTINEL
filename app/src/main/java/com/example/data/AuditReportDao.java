package com.example.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: Daos.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0002\u0010\u0007J\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\n\u001a\u00020\u000bH'J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0014¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/example/data/AuditReportDao;", "", "getAllAuditReports", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/AuditReport;", "getAllAuditReportsList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingAuditReportsList", "getReportsForCompany", "companyId", "", "insertAuditReport", "report", "(Lcom/example/data/AuditReport;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAuditReport", "", "deleteAuditReport", "deleteAuditReportById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteReportsForCompany", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes5.dex */
public interface AuditReportDao {
    Object deleteAuditReport(AuditReport auditReport, Continuation<? super Unit> continuation);

    Object deleteAuditReportById(long j, Continuation<? super Unit> continuation);

    Object deleteReportsForCompany(long j, Continuation<? super Unit> continuation);

    Flow<List<AuditReport>> getAllAuditReports();

    Object getAllAuditReportsList(Continuation<? super List<AuditReport>> continuation);

    Object getPendingAuditReportsList(Continuation<? super List<AuditReport>> continuation);

    Flow<List<AuditReport>> getReportsForCompany(long companyId);

    Object insertAuditReport(AuditReport auditReport, Continuation<? super Long> continuation);

    Object updateAuditReport(AuditReport auditReport, Continuation<? super Unit> continuation);
}
