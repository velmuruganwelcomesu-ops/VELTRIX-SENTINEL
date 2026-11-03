package com.example.utils;

import android.content.Context;
import android.util.Log;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BiometricAuthHelper.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJP\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0014JP\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0014JJ\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0014H\u0002J`\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u00142\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/example/utils/BiometricAuthHelper;", "", "<init>", "()V", "TAG", "", "checkBiometricStatus", "Lcom/example/utils/BiometricAuthHelper$BiometricStatus;", "context", "Landroid/content/Context;", "authenticate", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "title", "subtitle", "description", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "authenticateAdministrator", "promptStandardBiometric", "promptBiometricAuth", "onFallbackRequired", "BiometricStatus", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class BiometricAuthHelper {
    public static final int $stable = 0;
    public static final BiometricAuthHelper INSTANCE = new BiometricAuthHelper();
    private static final String TAG = "BiometricAuthHelper";

    /* compiled from: BiometricAuthHelper.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/example/utils/BiometricAuthHelper$BiometricStatus;", "", "<init>", "(Ljava/lang/String;I)V", "AVAILABLE", "NOT_ENROLLED", "NO_HARDWARE", "HARDWARE_UNAVAILABLE", "UNKNOWN", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /tmp/classes6.dex */
    public enum BiometricStatus {
        AVAILABLE,
        NOT_ENROLLED,
        NO_HARDWARE,
        HARDWARE_UNAVAILABLE,
        UNKNOWN;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<BiometricStatus> getEntries() {
            return $ENTRIES;
        }
    }

    private BiometricAuthHelper() {
    }

    public final BiometricStatus checkBiometricStatus(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BiometricManager biometricManager = BiometricManager.from(context);
        Intrinsics.checkNotNullExpressionValue(biometricManager, "from(...)");
        switch (biometricManager.canAuthenticate(32783)) {
            case 0:
                return BiometricStatus.AVAILABLE;
            case 1:
                return BiometricStatus.HARDWARE_UNAVAILABLE;
            case 11:
                return BiometricStatus.NOT_ENROLLED;
            case 12:
                return BiometricStatus.NO_HARDWARE;
            default:
                return BiometricStatus.UNKNOWN;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit authenticate$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final void authenticate(FragmentActivity activity, String title, String subtitle, String description, final Function0<Unit> onSuccess, final Function1<? super String, Unit> onError) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Executor executor = ContextCompat.getMainExecutor((Context) activity);
        Intrinsics.checkNotNullExpressionValue(executor, "getMainExecutor(...)");
        BiometricManager biometricManager = BiometricManager.from((Context) activity);
        Intrinsics.checkNotNullExpressionValue(biometricManager, "from(...)");
        int canAuth = biometricManager.canAuthenticate(32783);
        if (canAuth != 0) {
            if (biometricManager.canAuthenticate(255) == 0) {
                promptStandardBiometric(activity, title, subtitle, description, onSuccess, onError);
                return;
            } else {
                onError.invoke("Device lock (PIN/Password) or Biometrics is not configured on this device. Please enter your password to sign in.");
                return;
            }
        }
        try {
            BiometricPrompt biometricPrompt = new BiometricPrompt(activity, executor, new BiometricPrompt.AuthenticationCallback() { // from class: com.example.utils.BiometricAuthHelper$authenticate$callback$1
                public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    super.onAuthenticationSucceeded(result);
                    Log.d("BiometricAuthHelper", "Device/Biometric authentication succeeded");
                    onSuccess.invoke();
                }

                public void onAuthenticationError(int errorCode, CharSequence errString) {
                    Intrinsics.checkNotNullParameter(errString, "errString");
                    super.onAuthenticationError(errorCode, errString);
                    Log.e("BiometricAuthHelper", "Biometric authentication error: [" + errorCode + "] " + ((Object) errString));
                    Function1<String, Unit> function1 = onError;
                    switch (errorCode) {
                        case 5:
                        case 10:
                        case 13:
                            function1.invoke("Authentication cancelled by user.");
                            return;
                        default:
                            function1.invoke("Authentication error: " + ((Object) errString));
                            return;
                    }
                }

                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                    Log.w("BiometricAuthHelper", "Authentication failed - unrecognized biometric / credential");
                    onError.invoke("Fingerprint, Face, PIN or Password not recognized. Access denied.");
                }
            });
            BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle(title).setSubtitle(subtitle).setDescription(description).setAllowedAuthenticators(32783).build();
            Intrinsics.checkNotNullExpressionValue(promptInfo, "build(...)");
            biometricPrompt.authenticate(promptInfo);
        } catch (Exception e) {
            Log.e(TAG, "Failed to launch BiometricPrompt", e);
            onError.invoke("Authentication could not be initiated: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit authenticateAdministrator$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final void authenticateAdministrator(FragmentActivity activity, String title, String subtitle, String description, Function0<Unit> onSuccess, Function1<? super String, Unit> onError) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        authenticate(activity, title, subtitle, description, onSuccess, onError);
    }

    private final void promptStandardBiometric(FragmentActivity activity, String title, String subtitle, String description, final Function0<Unit> onSuccess, final Function1<? super String, Unit> onError) {
        Executor executor = ContextCompat.getMainExecutor((Context) activity);
        Intrinsics.checkNotNullExpressionValue(executor, "getMainExecutor(...)");
        try {
            BiometricPrompt biometricPrompt = new BiometricPrompt(activity, executor, new BiometricPrompt.AuthenticationCallback() { // from class: com.example.utils.BiometricAuthHelper$promptStandardBiometric$callback$1
                public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    super.onAuthenticationSucceeded(result);
                    onSuccess.invoke();
                }

                public void onAuthenticationError(int errorCode, CharSequence errString) {
                    Intrinsics.checkNotNullParameter(errString, "errString");
                    super.onAuthenticationError(errorCode, errString);
                    Function1<String, Unit> function1 = onError;
                    switch (errorCode) {
                        case 10:
                        case 13:
                            function1.invoke("Authentication cancelled.");
                            return;
                        default:
                            function1.invoke("Authentication error: " + ((Object) errString));
                            return;
                    }
                }

                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                    onError.invoke("Fingerprint or Face not recognized. Access denied.");
                }
            });
            BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle(title).setSubtitle(subtitle).setDescription(description).setNegativeButtonText("Use Password").build();
            Intrinsics.checkNotNullExpressionValue(promptInfo, "build(...)");
            biometricPrompt.authenticate(promptInfo);
        } catch (Exception e) {
            onError.invoke("Biometric prompt failed: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit promptBiometricAuth$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final void promptBiometricAuth(FragmentActivity activity, String title, String subtitle, String description, Function0<Unit> onSuccess, final Function1<? super String, Unit> onError, final Function0<Unit> onFallbackRequired) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onFallbackRequired, "onFallbackRequired");
        authenticate(activity, title, subtitle, description, onSuccess, new Function1() { // from class: com.example.utils.BiometricAuthHelper$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return BiometricAuthHelper.promptBiometricAuth$lambda$4(onError, onFallbackRequired, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit promptBiometricAuth$lambda$4(Function1 $onError, Function0 $onFallbackRequired, String err) {
        Intrinsics.checkNotNullParameter(err, "err");
        $onError.invoke(err);
        $onFallbackRequired.invoke();
        return Unit.INSTANCE;
    }
}
