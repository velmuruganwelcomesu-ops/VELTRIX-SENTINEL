package com.example.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AuditRepository.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.data.AuditRepository", f = "AuditRepository.kt", i = {0, 1}, l = {245, 246}, m = "deleteCompanyById", n = {"id", "id"}, s = {"J$0", "J$0"})
/* loaded from: /tmp/classes5.dex */
public final class AuditRepository$deleteCompanyById$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuditRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuditRepository$deleteCompanyById$1(AuditRepository auditRepository, Continuation<? super AuditRepository$deleteCompanyById$1> continuation) {
        super(continuation);
        this.this$0 = auditRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deleteCompanyById(0L, (Continuation) this);
    }
}
