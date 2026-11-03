package com.example.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeminiSafetyAssistant.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/example/utils/VexaChatMessage;", "", "sender", "", "text", "isUser", "", "modeUsed", "Lcom/example/utils/VexaAiMode;", "citations", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/example/utils/VexaAiMode;Ljava/util/List;)V", "getSender", "()Ljava/lang/String;", "getText", "()Z", "getModeUsed", "()Lcom/example/utils/VexaAiMode;", "getCitations", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final /* data */ class VexaChatMessage {
    public static final int $stable = 8;
    private final List<String> citations;
    private final boolean isUser;
    private final VexaAiMode modeUsed;
    private final String sender;
    private final String text;

    public static /* synthetic */ VexaChatMessage copy$default(VexaChatMessage vexaChatMessage, String str, String str2, boolean z, VexaAiMode vexaAiMode, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vexaChatMessage.sender;
        }
        if ((i & 2) != 0) {
            str2 = vexaChatMessage.text;
        }
        if ((i & 4) != 0) {
            z = vexaChatMessage.isUser;
        }
        if ((i & 8) != 0) {
            vexaAiMode = vexaChatMessage.modeUsed;
        }
        if ((i & 16) != 0) {
            list = vexaChatMessage.citations;
        }
        List list2 = list;
        boolean z2 = z;
        return vexaChatMessage.copy(str, str2, z2, vexaAiMode, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSender() {
        return this.sender;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsUser() {
        return this.isUser;
    }

    /* renamed from: component4, reason: from getter */
    public final VexaAiMode getModeUsed() {
        return this.modeUsed;
    }

    public final List<String> component5() {
        return this.citations;
    }

    public final VexaChatMessage copy(String sender, String text, boolean isUser, VexaAiMode modeUsed, List<String> citations) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(modeUsed, "modeUsed");
        Intrinsics.checkNotNullParameter(citations, "citations");
        return new VexaChatMessage(sender, text, isUser, modeUsed, citations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VexaChatMessage)) {
            return false;
        }
        VexaChatMessage vexaChatMessage = (VexaChatMessage) other;
        return Intrinsics.areEqual(this.sender, vexaChatMessage.sender) && Intrinsics.areEqual(this.text, vexaChatMessage.text) && this.isUser == vexaChatMessage.isUser && this.modeUsed == vexaChatMessage.modeUsed && Intrinsics.areEqual(this.citations, vexaChatMessage.citations);
    }

    public int hashCode() {
        return (((((((this.sender.hashCode() * 31) + this.text.hashCode()) * 31) + Boolean.hashCode(this.isUser)) * 31) + this.modeUsed.hashCode()) * 31) + this.citations.hashCode();
    }

    public String toString() {
        return "VexaChatMessage(sender=" + this.sender + ", text=" + this.text + ", isUser=" + this.isUser + ", modeUsed=" + this.modeUsed + ", citations=" + this.citations + ")";
    }

    public VexaChatMessage(String sender, String text, boolean isUser, VexaAiMode modeUsed, List<String> list) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(modeUsed, "modeUsed");
        Intrinsics.checkNotNullParameter(list, "citations");
        this.sender = sender;
        this.text = text;
        this.isUser = isUser;
        this.modeUsed = modeUsed;
        this.citations = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ VexaChatMessage(java.lang.String r7, java.lang.String r8, boolean r9, com.example.utils.VexaAiMode r10, java.util.List r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 8
            if (r13 == 0) goto L8
            com.example.utils.VexaAiMode r10 = com.example.utils.VexaAiMode.GENERAL_CHAT
            r4 = r10
            goto L9
        L8:
            r4 = r10
        L9:
            r10 = r12 & 16
            if (r10 == 0) goto L13
            java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
            r5 = r11
            goto L14
        L13:
            r5 = r11
        L14:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.VexaChatMessage.<init>(java.lang.String, java.lang.String, boolean, com.example.utils.VexaAiMode, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getSender() {
        return this.sender;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean isUser() {
        return this.isUser;
    }

    public final VexaAiMode getModeUsed() {
        return this.modeUsed;
    }

    public final List<String> getCitations() {
        return this.citations;
    }
}
