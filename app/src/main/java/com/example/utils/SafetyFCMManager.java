package com.example.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.example.data.Observation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SafetyFCMManager.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016J\"\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0005J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u001e\u001a\u00020\u00182\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001f\u001a\u00020\u0005J\u001a\u0010 \u001a\u00020\u00182\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001f\u001a\u00020\u0005J\u001e\u0010!\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005J(\u0010%\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u0005J(\u0010'\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020)J>\u0010*\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u00061"}, d2 = {"Lcom/example/utils/SafetyFCMManager;", "", "<init>", "()V", "TAG", "", "PREFS_NAME", "KEY_FCM_TOKEN", "_fcmToken", "Lkotlinx/coroutines/flow/MutableStateFlow;", "fcmToken", "Lkotlinx/coroutines/flow/StateFlow;", "getFcmToken", "()Lkotlinx/coroutines/flow/StateFlow;", "_recentAlerts", "", "Lcom/example/utils/FCMAlertRecord;", "recentAlerts", "getRecentAlerts", "getPrefs", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "initialize", "", "saveFCMTokenLocally", "token", "username", "onUserLogin", "onUserLogout", "unsubscribeFromTopic", "topicName", "subscribeToTopic", "onNewFindingCaptured", "observation", "Lcom/example/data/Observation;", "companyName", "onDeadlineApproaching", "hoursOrDaysText", "onFindingOverdue", "daysOverdue", "", "dispatchPushAlert", "title", "body", "type", "recipient", "sncNumber", "severity", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class SafetyFCMManager {
    private static final String KEY_FCM_TOKEN = "key_current_fcm_token";
    private static final String PREFS_NAME = "fcm_safety_prefs";
    private static final String TAG = "SafetyFCMManager";
    public static final SafetyFCMManager INSTANCE = new SafetyFCMManager();
    private static final MutableStateFlow<String> _fcmToken = StateFlowKt.MutableStateFlow("");
    private static final StateFlow<String> fcmToken = FlowKt.asStateFlow(_fcmToken);
    private static final MutableStateFlow<List<FCMAlertRecord>> _recentAlerts = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private static final StateFlow<List<FCMAlertRecord>> recentAlerts = FlowKt.asStateFlow(_recentAlerts);
    public static final int $stable = 8;

    private SafetyFCMManager() {
    }

    public final StateFlow<String> getFcmToken() {
        return fcmToken;
    }

    public final StateFlow<List<FCMAlertRecord>> getRecentAlerts() {
        return recentAlerts;
    }

    private final SharedPreferences getPrefs(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    public final void initialize(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SafetyFCMService.Companion.createNotificationChannel(context);
        String string = getPrefs(context).getString(KEY_FCM_TOKEN, "");
        String savedToken = string != null ? string : "";
        if (!StringsKt.isBlank(savedToken)) {
            _fcmToken.setValue(savedToken);
        }
        try {
            FirebaseMessaging messaging = SafetyFirebaseHelper.INSTANCE.getMessaging(context);
            if (messaging != null) {
                try {
                    Intrinsics.checkNotNull(messaging.getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.example.utils.SafetyFCMManager$$ExternalSyntheticLambda6
                        public final void onComplete(Task task) {
                            SafetyFCMManager.initialize$lambda$0(context, task);
                        }
                    }));
                    return;
                } catch (Throwable th) {
                    e = th;
                }
            } else if (StringsKt.isBlank((CharSequence) _fcmToken.getValue())) {
                String fallbackToken = "fcm_token_" + System.currentTimeMillis() + "_device";
                _fcmToken.setValue(fallbackToken);
                try {
                    saveFCMTokenLocally$default(this, context, fallbackToken, null, 4, null);
                    return;
                } catch (Throwable th2) {
                    e = th2;
                }
            } else {
                return;
            }
        } catch (Throwable th3) {
            e = th3;
        }
        Log.d(TAG, "FCM initialization handled gracefully: " + e.getMessage());
        if (StringsKt.isBlank((CharSequence) _fcmToken.getValue())) {
            _fcmToken.setValue("fcm_token_" + System.currentTimeMillis() + "_device");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void initialize$lambda$0(Context $context, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful() && task.getResult() != null) {
            String token = (String) task.getResult();
            Log.d(TAG, "Fetched FCM Token: " + token);
            SafetyFCMManager safetyFCMManager = INSTANCE;
            Intrinsics.checkNotNull(token);
            saveFCMTokenLocally$default(safetyFCMManager, $context, token, null, 4, null);
            _fcmToken.setValue(token);
            INSTANCE.subscribeToTopic($context, "all_safety_officers");
            INSTANCE.subscribeToTopic($context, "snc_alerts_broadcast");
            return;
        }
        Exception exception = task.getException();
        Log.d(TAG, "Fetching FCM registration token skipped: " + (exception != null ? exception.getMessage() : null));
        if (StringsKt.isBlank((CharSequence) _fcmToken.getValue())) {
            String fallbackToken = "fcm_token_" + System.currentTimeMillis() + "_local";
            _fcmToken.setValue(fallbackToken);
            saveFCMTokenLocally$default(INSTANCE, $context, fallbackToken, null, 4, null);
        }
    }

    public static /* synthetic */ void saveFCMTokenLocally$default(SafetyFCMManager safetyFCMManager, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        safetyFCMManager.saveFCMTokenLocally(context, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0074 A[Catch: all -> 0x00cf, TryCatch #0 {all -> 0x00cf, blocks: (B:3:0x0023, B:5:0x002b, B:7:0x0068, B:12:0x0074, B:13:0x0079, B:15:0x0095, B:20:0x00a1), top: B:2:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1 A[Catch: all -> 0x00cf, TRY_LEAVE, TryCatch #0 {all -> 0x00cf, blocks: (B:3:0x0023, B:5:0x002b, B:7:0x0068, B:12:0x0074, B:13:0x0079, B:15:0x0095, B:20:0x00a1), top: B:2:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void saveFCMTokenLocally(android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            java.lang.String r0 = "fcmToken"
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = "token"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> r1 = com.example.utils.SafetyFCMManager._fcmToken
            r1.setValue(r11)
            android.content.SharedPreferences r1 = r9.getPrefs(r10)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.lang.String r2 = "key_current_fcm_token"
            android.content.SharedPreferences$Editor r1 = r1.putString(r2, r11)
            r1.apply()
            com.example.utils.SafetyFirebaseHelper r1 = com.example.utils.SafetyFirebaseHelper.INSTANCE     // Catch: java.lang.Throwable -> Lcf
            com.google.firebase.firestore.FirebaseFirestore r1 = r1.getFirestore(r10)     // Catch: java.lang.Throwable -> Lcf
            if (r1 == 0) goto Lec
            r2 = 4
            kotlin.Pair[] r2 = new kotlin.Pair[r2]     // Catch: java.lang.Throwable -> Lcf
            kotlin.Pair r3 = kotlin.TuplesKt.to(r0, r11)     // Catch: java.lang.Throwable -> Lcf
            r4 = 0
            r2[r4] = r3     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r3 = "updatedAt"
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lcf
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> Lcf
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r5)     // Catch: java.lang.Throwable -> Lcf
            r5 = 1
            r2[r5] = r3     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r3 = "device"
            java.lang.String r6 = android.os.Build.MODEL     // Catch: java.lang.Throwable -> Lcf
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r6)     // Catch: java.lang.Throwable -> Lcf
            r6 = 2
            r2[r6] = r3     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r3 = "platform"
            java.lang.String r7 = "Android"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r7)     // Catch: java.lang.Throwable -> Lcf
            r7 = 3
            r2[r7] = r3     // Catch: java.lang.Throwable -> Lcf
            java.util.Map r2 = kotlin.collections.MapsKt.mutableMapOf(r2)     // Catch: java.lang.Throwable -> Lcf
            r3 = r12
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Throwable -> Lcf
            if (r3 == 0) goto L71
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)     // Catch: java.lang.Throwable -> Lcf
            if (r3 == 0) goto L6f
            goto L71
        L6f:
            r3 = r4
            goto L72
        L71:
            r3 = r5
        L72:
            if (r3 != 0) goto L79
            java.lang.String r3 = "username"
            r2.put(r3, r12)     // Catch: java.lang.Throwable -> Lcf
        L79:
            java.lang.String r3 = "fcm_device_tokens"
            com.google.firebase.firestore.CollectionReference r3 = r1.collection(r3)     // Catch: java.lang.Throwable -> Lcf
            r7 = 20
            java.lang.String r7 = kotlin.text.StringsKt.takeLast(r11, r7)     // Catch: java.lang.Throwable -> Lcf
            com.google.firebase.firestore.DocumentReference r3 = r3.document(r7)     // Catch: java.lang.Throwable -> Lcf
            com.google.firebase.firestore.SetOptions r7 = com.google.firebase.firestore.SetOptions.merge()     // Catch: java.lang.Throwable -> Lcf
            r3.set(r2, r7)     // Catch: java.lang.Throwable -> Lcf
            r3 = r12
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Throwable -> Lcf
            if (r3 == 0) goto L9e
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)     // Catch: java.lang.Throwable -> Lcf
            if (r3 == 0) goto L9c
            goto L9e
        L9c:
            r3 = r4
            goto L9f
        L9e:
            r3 = r5
        L9f:
            if (r3 != 0) goto Lec
            java.lang.String r3 = "users"
            com.google.firebase.firestore.CollectionReference r3 = r1.collection(r3)     // Catch: java.lang.Throwable -> Lcf
            com.google.firebase.firestore.DocumentReference r3 = r3.document(r12)     // Catch: java.lang.Throwable -> Lcf
            kotlin.Pair[] r6 = new kotlin.Pair[r6]     // Catch: java.lang.Throwable -> Lcf
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r11)     // Catch: java.lang.Throwable -> Lcf
            r6[r4] = r0     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r0 = "lastTokenUpdate"
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lcf
            java.lang.Long r4 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> Lcf
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r4)     // Catch: java.lang.Throwable -> Lcf
            r6[r5] = r0     // Catch: java.lang.Throwable -> Lcf
            java.util.Map r0 = kotlin.collections.MapsKt.mapOf(r6)     // Catch: java.lang.Throwable -> Lcf
            com.google.firebase.firestore.SetOptions r4 = com.google.firebase.firestore.SetOptions.merge()     // Catch: java.lang.Throwable -> Lcf
            r3.set(r0, r4)     // Catch: java.lang.Throwable -> Lcf
            goto Lec
        Lcf:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Firestore token sync skipped: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "SafetyFCMManager"
            android.util.Log.d(r2, r1)
        Lec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.SafetyFCMManager.saveFCMTokenLocally(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public final void onUserLogin(final Context context, final String username) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(username, "username");
        try {
            FirebaseMessaging messaging = SafetyFirebaseHelper.INSTANCE.getMessaging(context);
            if (messaging != null) {
                messaging.getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.example.utils.SafetyFCMManager$$ExternalSyntheticLambda2
                    public final void onComplete(Task task) {
                        SafetyFCMManager.onUserLogin$lambda$1(context, username, task);
                    }
                });
            }
        } catch (Throwable e) {
            Log.d(TAG, "Refreshing FCM token on login skipped: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onUserLogin$lambda$1(Context $context, String $username, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful() && task.getResult() != null) {
            String token = (String) task.getResult();
            SafetyFCMManager safetyFCMManager = INSTANCE;
            Intrinsics.checkNotNull(token);
            safetyFCMManager.saveFCMTokenLocally($context, token, $username);
            SafetyFCMManager safetyFCMManager2 = INSTANCE;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = $username.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            safetyFCMManager2.subscribeToTopic($context, "user_" + lowerCase);
            INSTANCE.subscribeToTopic($context, "all_safety_officers");
            INSTANCE.subscribeToTopic($context, "snc_alerts_broadcast");
        }
    }

    public final void onUserLogout(Context context, String username) {
        Task deleteToken;
        CollectionReference collection;
        DocumentReference document;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String str = username;
            if (!(str == null || StringsKt.isBlank(str))) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String lowerCase = username.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                unsubscribeFromTopic(context, "user_" + lowerCase);
                try {
                    FirebaseFirestore db = SafetyFirebaseHelper.INSTANCE.getFirestore(context);
                    if (db != null && (collection = db.collection("users")) != null && (document = collection.document(username)) != null) {
                        document.set(MapsKt.mapOf(new Pair[]{TuplesKt.to("fcmToken", ""), TuplesKt.to("lastTokenUpdate", Long.valueOf(System.currentTimeMillis()))}), SetOptions.merge());
                    }
                } catch (Throwable e) {
                    Log.d(TAG, "Firestore token clear skipped: " + e.getMessage());
                }
            }
            getPrefs(context).edit().remove(KEY_FCM_TOKEN).apply();
            _fcmToken.setValue("");
            FirebaseMessaging messaging = SafetyFirebaseHelper.INSTANCE.getMessaging(context);
            if (messaging == null || (deleteToken = messaging.deleteToken()) == null) {
                return;
            }
            deleteToken.addOnCompleteListener(new OnCompleteListener() { // from class: com.example.utils.SafetyFCMManager$$ExternalSyntheticLambda5
                public final void onComplete(Task task) {
                    SafetyFCMManager.onUserLogout$lambda$2(task);
                }
            });
        } catch (Throwable e2) {
            Log.d(TAG, "FCM token cleanup on logout skipped: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onUserLogout$lambda$2(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            Log.d(TAG, "FCM token successfully deleted on logout");
        }
    }

    public static /* synthetic */ void unsubscribeFromTopic$default(SafetyFCMManager safetyFCMManager, Context context, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        safetyFCMManager.unsubscribeFromTopic(context, str);
    }

    public final void unsubscribeFromTopic(Context context, String topicName) {
        Task unsubscribeFromTopic;
        Intrinsics.checkNotNullParameter(topicName, "topicName");
        try {
            final String cleanTopic = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(topicName, " ", "_", false, 4, (Object) null), "@", "_", false, 4, (Object) null), ".", "_", false, 4, (Object) null);
            FirebaseMessaging messaging = SafetyFirebaseHelper.INSTANCE.getMessaging(context);
            if (messaging == null || (unsubscribeFromTopic = messaging.unsubscribeFromTopic(cleanTopic)) == null) {
                return;
            }
            final Function1 function1 = new Function1() { // from class: com.example.utils.SafetyFCMManager$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return SafetyFCMManager.unsubscribeFromTopic$lambda$3(cleanTopic, (Void) obj);
                }
            };
            unsubscribeFromTopic.addOnSuccessListener(new OnSuccessListener() { // from class: com.example.utils.SafetyFCMManager$$ExternalSyntheticLambda1
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            });
        } catch (Throwable e) {
            Log.d(TAG, "Unsubscribe from FCM topic skipped: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit unsubscribeFromTopic$lambda$3(String $cleanTopic, Void it) {
        Log.d(TAG, "Unsubscribed from FCM topic: " + $cleanTopic);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void subscribeToTopic$default(SafetyFCMManager safetyFCMManager, Context context, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        safetyFCMManager.subscribeToTopic(context, str);
    }

    public final void subscribeToTopic(Context context, String topicName) {
        Task subscribeToTopic;
        Intrinsics.checkNotNullParameter(topicName, "topicName");
        try {
            final String cleanTopic = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(topicName, " ", "_", false, 4, (Object) null), "@", "_", false, 4, (Object) null), ".", "_", false, 4, (Object) null);
            FirebaseMessaging messaging = SafetyFirebaseHelper.INSTANCE.getMessaging(context);
            if (messaging == null || (subscribeToTopic = messaging.subscribeToTopic(cleanTopic)) == null) {
                return;
            }
            final Function1 function1 = new Function1() { // from class: com.example.utils.SafetyFCMManager$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    return SafetyFCMManager.subscribeToTopic$lambda$5(cleanTopic, (Void) obj);
                }
            };
            subscribeToTopic.addOnSuccessListener(new OnSuccessListener() { // from class: com.example.utils.SafetyFCMManager$$ExternalSyntheticLambda4
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            });
        } catch (Throwable e) {
            Log.d(TAG, "Subscribe to FCM topic skipped: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit subscribeToTopic$lambda$5(String $cleanTopic, Void it) {
        Log.d(TAG, "Subscribed to FCM topic: " + $cleanTopic);
        return Unit.INSTANCE;
    }

    public final void onNewFindingCaptured(Context context, Observation observation, String companyName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(observation, "observation");
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        String title = "🚨 New Safety Finding Assigned [" + observation.getSncNumber() + "]";
        String body = "Assigned to " + observation.getResponsiblePerson() + " (" + observation.getSeverity() + " hazard at " + observation.getLocation() + "): " + StringsKt.take(observation.getIssueDetails(), 90) + "... Target Date: " + observation.getTargetDate();
        dispatchPushAlert(context, title, body, "NEW_FINDING", observation.getResponsiblePerson(), observation.getSncNumber(), observation.getSeverity());
    }

    public static /* synthetic */ void onDeadlineApproaching$default(SafetyFCMManager safetyFCMManager, Context context, Observation observation, String str, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = "24 hours";
        }
        safetyFCMManager.onDeadlineApproaching(context, observation, str, str2);
    }

    public final void onDeadlineApproaching(Context context, Observation observation, String companyName, String hoursOrDaysText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(observation, "observation");
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        Intrinsics.checkNotNullParameter(hoursOrDaysText, "hoursOrDaysText");
        String title = "⏰ Safety Deadline Approaching: " + observation.getSncNumber();
        String body = "Action Due in " + hoursOrDaysText + " for " + observation.getResponsiblePerson() + " at " + observation.getLocation() + ". Corrective action: " + StringsKt.take(observation.getSuggestion(), 80);
        dispatchPushAlert(context, title, body, "DEADLINE_APPROACHING", observation.getResponsiblePerson(), observation.getSncNumber(), observation.getSeverity());
    }

    public static /* synthetic */ void onFindingOverdue$default(SafetyFCMManager safetyFCMManager, Context context, Observation observation, String str, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 1;
        }
        safetyFCMManager.onFindingOverdue(context, observation, str, i);
    }

    public final void onFindingOverdue(Context context, Observation observation, String companyName, int daysOverdue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(observation, "observation");
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        String title = "⚠️ OVERDUE Finding Alert: " + observation.getSncNumber();
        String body = "Target closure date (" + observation.getTargetDate() + ") passed for " + observation.getResponsiblePerson() + " (" + daysOverdue + " day(s) overdue). Immediate escalation required.";
        dispatchPushAlert(context, title, body, "OVERDUE", observation.getResponsiblePerson(), observation.getSncNumber(), "CRITICAL");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d2, code lost:
    
        if (r11.equals("CRITICAL") != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x00c9, code lost:
    
        if (r11.equals("HIGH") == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x00d4, code lost:
    
        r11 = android.R.drawable.stat_notify_error;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dispatchPushAlert(android.content.Context r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.SafetyFCMManager.dispatchPushAlert(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
