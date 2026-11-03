package com.example.utils;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CalendarMonthKt;
import androidx.compose.material.icons.filled.ClearKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: DateUtils.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class ComposableSingletons$DateUtilsKt {
    public static final ComposableSingletons$DateUtilsKt INSTANCE = new ComposableSingletons$DateUtilsKt();

    /* renamed from: lambda$-320987154, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f0lambda$320987154 = ComposableLambdaKt.composableLambdaInstance(-320987154, false, new Function2() { // from class: com.example.utils.ComposableSingletons$DateUtilsKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DateUtilsKt.lambda__320987154$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1127109843 = ComposableLambdaKt.composableLambdaInstance(1127109843, false, new Function2() { // from class: com.example.utils.ComposableSingletons$DateUtilsKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DateUtilsKt.lambda_1127109843$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-320987154$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4getLambda$320987154$app() {
        return f0lambda$320987154;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1127109843$app() {
        return lambda$1127109843;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__320987154$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C279@9986L119:DateUtils.kt#8vfgxs");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-320987154, $changed, -1, "com.example.utils.ComposableSingletons$DateUtilsKt.lambda$-320987154.<anonymous> (DateUtils.kt:279)");
            }
            IconKt.Icon-ww6aTOc(ClearKt.getClear(Icons.INSTANCE.getDefault()), "Clear Date", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), ColorKt.Color(4282865001L), $composer, 3504, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1127109843$lambda$1(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C286@10318L211:DateUtils.kt#8vfgxs");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1127109843, $changed, -1, "com.example.utils.ComposableSingletons$DateUtilsKt.lambda$1127109843.<anonymous> (DateUtils.kt:286)");
            }
            IconKt.Icon-ww6aTOc(CalendarMonthKt.getCalendarMonth(Icons.INSTANCE.getDefault()), "Select from Calendar (DD-MM-YYYY)", (Modifier) null, ColorKt.Color(4294096645L), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
