package com.example.utils;

import android.content.Context;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafetyFirebaseHelper.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/example/utils/SafetyFirebaseHelper;", "", "<init>", "()V", "TAG", "", "isInitialized", "", "ensureInitialized", "context", "Landroid/content/Context;", "getFirestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getMessaging", "Lcom/google/firebase/messaging/FirebaseMessaging;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class SafetyFirebaseHelper {
    private static final String TAG = "SafetyFirebaseHelper";
    private static volatile boolean isInitialized;
    public static final SafetyFirebaseHelper INSTANCE = new SafetyFirebaseHelper();
    public static final int $stable = 8;

    private SafetyFirebaseHelper() {
    }

    public final boolean ensureInitialized(Context context) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Context appContext = context.getApplicationContext();
        if (appContext == null) {
            appContext = context;
        }
        boolean z2 = true;
        if (isInitialized) {
            List apps = FirebaseApp.getApps(appContext);
            Intrinsics.checkNotNullExpressionValue(apps, "getApps(...)");
            if (!apps.isEmpty()) {
                return true;
            }
        }
        synchronized (this) {
            z = false;
            try {
                List apps2 = FirebaseApp.getApps(appContext);
                Intrinsics.checkNotNullExpressionValue(apps2, "getApps(...)");
                if (apps2.isEmpty()) {
                    try {
                        FirebaseApp.initializeApp(appContext);
                    } catch (Throwable th) {
                        Log.d(TAG, "Default Firebase initialization not available, initializing with fallback project options: " + th.getMessage());
                        FirebaseOptions build = new FirebaseOptions.Builder().setApplicationId("1:805980475750:android:com_aistudio_sncsafetyaudit_vtx").setProjectId("sncsafetyaudit-vtx").setApiKey("AIzaSyB3189912SafeAuditFallbackKey").build();
                        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                        FirebaseApp.initializeApp(appContext, build);
                    }
                }
                List apps3 = FirebaseApp.getApps(appContext);
                Intrinsics.checkNotNullExpressionValue(apps3, "getApps(...)");
                if (apps3.isEmpty()) {
                    z2 = false;
                }
                isInitialized = z2;
                z = isInitialized;
            } catch (Throwable th2) {
                Log.d(TAG, "Firebase initialization handled gracefully: " + th2.getMessage());
                isInitialized = false;
            }
        }
        return z;
    }

    public final FirebaseFirestore getFirestore(Context context) {
        if (context == null) {
            return null;
        }
        try {
            boolean ready = ensureInitialized(context);
            if (!ready) {
                return null;
            }
            return FirebaseFirestore.getInstance();
        } catch (Throwable e) {
            Log.d(TAG, "Firestore not available: " + e.getMessage());
            return null;
        }
    }

    public final FirebaseMessaging getMessaging(Context context) {
        if (context == null) {
            return null;
        }
        try {
            boolean ready = ensureInitialized(context);
            if (!ready) {
                return null;
            }
            return FirebaseMessaging.getInstance();
        } catch (Throwable e) {
            Log.d(TAG, "FirebaseMessaging not available: " + e.getMessage());
            return null;
        }
    }
}
