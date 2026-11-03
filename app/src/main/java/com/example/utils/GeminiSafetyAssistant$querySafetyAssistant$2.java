package com.example.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeminiSafetyAssistant.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.utils.GeminiSafetyAssistant$querySafetyAssistant$2", f = "GeminiSafetyAssistant.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {488, 216, 280}, m = "invokeSuspend", n = {"apiKey", "actualModel", "url", "systemInstructionText", "payload", "$this$withLock_u24default\\8", "$i$f$withLock\\8\\212", "apiKey", "actualModel", "url", "systemInstructionText", "payload", "$this$withLock_u24default\\8", "$i$f$withLock\\8\\212", "$i$a$-withLock$default-GeminiSafetyAssistant$querySafetyAssistant$2$1\\9\\490\\0", "now\\9", "elapsed\\9", "apiKey", "actualModel", "url", "systemInstructionText", "payload", "body", "request", "response", "responseString", "attempts", "delayMs", "maxRetries", "responseCode"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "J$0", "I$1", "I$2"})
/* loaded from: /tmp/classes6.dex */
public final class GeminiSafetyAssistant$querySafetyAssistant$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends List<? extends String>>>, Object> {
    final /* synthetic */ List<VexaChatMessage> $history;
    final /* synthetic */ VexaAiMode $mode;
    final /* synthetic */ String $prompt;
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;

    /* compiled from: GeminiSafetyAssistant.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /tmp/classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VexaAiMode.values().length];
            try {
                iArr[VexaAiMode.VOICE_LIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[VexaAiMode.PRO_REASONING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[VexaAiMode.FAST_LITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[VexaAiMode.GENERAL_CHAT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeminiSafetyAssistant$querySafetyAssistant$2(VexaAiMode vexaAiMode, String str, List<VexaChatMessage> list, Continuation<? super GeminiSafetyAssistant$querySafetyAssistant$2> continuation) {
        super(2, continuation);
        this.$mode = vexaAiMode;
        this.$prompt = str;
        this.$history = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GeminiSafetyAssistant$querySafetyAssistant$2(this.$mode, this.$prompt, this.$history, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<String, ? extends List<String>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:181:0x00fd. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0011. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 25, insn: 0x0693: MOVE (r23 I:??[OBJECT, ARRAY]) = (r25 I:??[OBJECT, ARRAY] A[D('apiKey' java.lang.String)]), block:B:221:0x068f */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x01e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x04c3 A[Catch: Exception -> 0x065a, TryCatch #11 {Exception -> 0x065a, blocks: (B:11:0x061f, B:30:0x03e4, B:32:0x03ec, B:34:0x03f2, B:36:0x0407, B:38:0x040f, B:40:0x0415, B:42:0x0429, B:44:0x0439, B:46:0x0458, B:50:0x045f, B:52:0x0470, B:54:0x0478, B:56:0x0481, B:58:0x0495, B:60:0x04a3, B:61:0x04af, B:63:0x04b5, B:68:0x04c3, B:70:0x04c9, B:75:0x04d7, B:76:0x04f9, B:78:0x0512, B:88:0x052e, B:90:0x0537, B:108:0x0565, B:109:0x0587, B:111:0x058b, B:115:0x0630), top: B:10:0x061f }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x04d7 A[Catch: Exception -> 0x065a, TryCatch #11 {Exception -> 0x065a, blocks: (B:11:0x061f, B:30:0x03e4, B:32:0x03ec, B:34:0x03f2, B:36:0x0407, B:38:0x040f, B:40:0x0415, B:42:0x0429, B:44:0x0439, B:46:0x0458, B:50:0x045f, B:52:0x0470, B:54:0x0478, B:56:0x0481, B:58:0x0495, B:60:0x04a3, B:61:0x04af, B:63:0x04b5, B:68:0x04c3, B:70:0x04c9, B:75:0x04d7, B:76:0x04f9, B:78:0x0512, B:88:0x052e, B:90:0x0537, B:108:0x0565, B:109:0x0587, B:111:0x058b, B:115:0x0630), top: B:10:0x061f }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x050e  */
    /* JADX WARN: Type inference failed for: r0v64, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r14v23, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r19v5, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x060c -> B:10:0x061f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r41) {
        /*
            Method dump skipped, instructions count: 1774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.GeminiSafetyAssistant$querySafetyAssistant$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
