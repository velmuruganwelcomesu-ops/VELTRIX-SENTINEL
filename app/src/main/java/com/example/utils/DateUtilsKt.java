package com.example.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: DateUtils.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ah\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"CalendarDatePickerField", "", "value", "", "onValueChange", "Lkotlin/Function1;", "label", "placeholder", "modifier", "Landroidx/compose/ui/Modifier;", "isError", "", "supportingText", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class DateUtilsKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CalendarDatePickerField$lambda$15(String str, Function1 function1, String str2, String str3, Modifier modifier, boolean z, Function2 function2, int i, int i2, Composer composer, int i3) {
        CalendarDatePickerField(str, function1, str2, str3, modifier, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CalendarDatePickerField(final java.lang.String r34, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r35, java.lang.String r36, java.lang.String r37, androidx.compose.ui.Modifier r38, boolean r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.DateUtilsKt.CalendarDatePickerField(java.lang.String, kotlin.jvm.functions.Function1, java.lang.String, java.lang.String, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CalendarDatePickerField$lambda$2$lambda$1(String $value, Context $context, final Function1 $onValueChange) {
        Date parsed = DateUtils.INSTANCE.parseDate($value);
        Calendar cal = Calendar.getInstance();
        if (parsed != null) {
            cal.setTime(parsed);
        }
        new DatePickerDialog($context, new DatePickerDialog.OnDateSetListener() { // from class: com.example.utils.DateUtilsKt$$ExternalSyntheticLambda2
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                DateUtilsKt.CalendarDatePickerField$lambda$2$lambda$1$lambda$0($onValueChange, datePicker, i, i2, i3);
            }
        }, cal.get(1), cal.get(2), cal.get(5)).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void CalendarDatePickerField$lambda$2$lambda$1$lambda$0(Function1 $onValueChange, DatePicker datePicker, int year, int month, int dayOfMonth) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String formatted = String.format(Locale.getDefault(), "%02d-%02d-%04d", Arrays.copyOf(new Object[]{Integer.valueOf(dayOfMonth), Integer.valueOf(month + 1), Integer.valueOf(year)}, 3));
        Intrinsics.checkNotNullExpressionValue(formatted, "format(...)");
        $onValueChange.invoke(formatted);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CalendarDatePickerField$lambda$6$lambda$5(Function1 $onValueChange, String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        $onValueChange.invoke(input);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CalendarDatePickerField$lambda$7(String $label, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C270@9585L29:DateUtils.kt#8vfgxs");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1535960079, $changed, -1, "com.example.utils.CalendarDatePickerField.<anonymous> (DateUtils.kt:270)");
            }
            TextKt.Text--4IGK_g($label, (Modifier) null, 0L, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 3072, 0, 131062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CalendarDatePickerField$lambda$8(String $placeholder, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C271@9642L62:DateUtils.kt#8vfgxs");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(574334864, $changed, -1, "com.example.utils.CalendarDatePickerField.<anonymous> (DateUtils.kt:271)");
            }
            TextKt.Text--4IGK_g($placeholder, (Modifier) null, ColorKt.Color(4284773515L), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 3456, 0, 131058);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit CalendarDatePickerField$lambda$14(java.lang.String r35, final kotlin.jvm.functions.Function1 r36, final kotlin.jvm.functions.Function0 r37, androidx.compose.runtime.Composer r38, int r39) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.DateUtilsKt.CalendarDatePickerField$lambda$14(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CalendarDatePickerField$lambda$14$lambda$13$lambda$10$lambda$9(Function1 $onValueChange) {
        $onValueChange.invoke("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CalendarDatePickerField$lambda$14$lambda$13$lambda$12$lambda$11(Function0 $openDatePicker) {
        $openDatePicker.invoke();
        return Unit.INSTANCE;
    }
}
