package com.example.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafetyFCMService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J@\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002¨\u0006\u0015"}, d2 = {"Lcom/example/utils/SafetyFCMService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "onNewToken", "", "token", "", "onMessageReceived", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "showFCMNotification", "context", "Landroid/content/Context;", "title", "body", "sncNumber", "responsiblePerson", "alertType", "severity", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class SafetyFCMService extends FirebaseMessagingService {
    public static final String CHANNEL_ID = "veltrix_fcm_safety_alerts_channel";
    public static final String CHANNEL_NAME = "Veltrix Sentinel FCM Safety & Deadline Alerts";
    private static final String TAG = "SafetyFCMService";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public void onNewToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        super.onNewToken(token);
        Log.d(TAG, "Refreshed FCM Registration Token: " + token);
        SafetyFCMManager safetyFCMManager = SafetyFCMManager.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        SafetyFCMManager.saveFCMTokenLocally$default(safetyFCMManager, applicationContext, token, null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMessageReceived(com.google.firebase.messaging.RemoteMessage r13) {
        /*
            r12 = this;
            java.lang.String r0 = "remoteMessage"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            super.onMessageReceived(r13)
            java.lang.String r0 = r13.getFrom()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "FCM Message Received from: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "SafetyFCMService"
            android.util.Log.d(r1, r0)
            java.util.Map r0 = r13.getData()
            java.lang.String r1 = "getData(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.google.firebase.messaging.RemoteMessage$Notification r1 = r13.getNotification()
            java.lang.String r2 = "title"
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            if (r2 != 0) goto L48
            if (r1 == 0) goto L43
            java.lang.String r2 = r1.getTitle()
            goto L44
        L43:
            r2 = r3
        L44:
            if (r2 != 0) goto L48
            java.lang.String r2 = "🚨 Safety Audit Alert"
        L48:
            r6 = r2
            java.lang.String r2 = "body"
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L60
            if (r1 == 0) goto L59
            java.lang.String r3 = r1.getBody()
        L59:
            if (r3 != 0) goto L5e
            java.lang.String r2 = "New safety finding or deadline update assigned."
            goto L60
        L5e:
            r7 = r3
            goto L61
        L60:
            r7 = r2
        L61:
            java.lang.String r2 = "findingId"
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = ""
            if (r2 != 0) goto L6e
            r2 = r3
        L6e:
            java.lang.String r4 = "sncNumber"
            java.lang.Object r4 = r0.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L7a
            r8 = r3
            goto L7b
        L7a:
            r8 = r4
        L7b:
            java.lang.String r4 = "responsiblePerson"
            java.lang.Object r4 = r0.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L87
            r9 = r3
            goto L88
        L87:
            r9 = r4
        L88:
            java.lang.String r3 = "type"
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L94
            java.lang.String r3 = "SAFETY_ALERT"
        L94:
            r10 = r3
            java.lang.String r3 = "severity"
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto La1
            java.lang.String r3 = "MEDIUM"
        La1:
            r11 = r3
            android.content.Context r5 = r12.getApplicationContext()
            java.lang.String r3 = "getApplicationContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            r4 = r12
            r4.showFCMNotification(r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.SafetyFCMService.onMessageReceived(com.google.firebase.messaging.RemoteMessage):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0060, code lost:
    
        if (r2.equals("CRITICAL") != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0057, code lost:
    
        if (r2.equals("HIGH") == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0062, code lost:
    
        r2 = android.R.drawable.stat_notify_error;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void showFCMNotification(android.content.Context r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            r12 = this;
            com.example.utils.SafetyFCMService$Companion r0 = com.example.utils.SafetyFCMService.INSTANCE
            r0.createNotificationChannel(r13)
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.example.MainActivity> r1 = com.example.MainActivity.class
            r0.<init>(r13, r1)
            r1 = r0
            r2 = 0
            r3 = 268468224(0x10008000, float:2.5342157E-29)
            r1.setFlags(r3)
            java.lang.String r3 = "EXTRA_NAVIGATE_TAB"
            java.lang.String r4 = "OBSERVATIONS"
            r1.putExtra(r3, r4)
            java.lang.String r3 = "EXTRA_SNC_NUMBER"
            r4 = r16
            r1.putExtra(r3, r4)
            java.lang.String r3 = "EXTRA_RESPONSIBLE_PERSON"
            r5 = r17
            r1.putExtra(r3, r5)
            long r1 = java.lang.System.currentTimeMillis()
            r6 = 10000(0x2710, double:4.9407E-320)
            long r1 = r1 % r6
            int r1 = (int) r1
            r2 = 201326592(0xc000000, float:9.8607613E-32)
            android.app.PendingIntent r1 = android.app.PendingIntent.getActivity(r13, r1, r0, r2)
            java.util.Locale r2 = java.util.Locale.ROOT
            r3 = r19
            java.lang.String r2 = r3.toUpperCase(r2)
            java.lang.String r6 = "toUpperCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            int r6 = r2.hashCode()
            switch(r6) {
                case -2024701067: goto L66;
                case -1560189025: goto L5a;
                case 2217378: goto L51;
                default: goto L50;
            }
        L50:
            goto L73
        L51:
            java.lang.String r6 = "HIGH"
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L62
            goto L50
        L5a:
            java.lang.String r6 = "CRITICAL"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L50
        L62:
            r2 = 17301624(0x1080078, float:2.497959E-38)
            goto L76
        L66:
            java.lang.String r6 = "MEDIUM"
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L6f
            goto L50
        L6f:
            r2 = 17301642(0x108008a, float:2.4979642E-38)
            goto L76
        L73:
            r2 = 17301625(0x1080079, float:2.4979594E-38)
        L76:
            androidx.core.app.NotificationCompat$Builder r6 = new androidx.core.app.NotificationCompat$Builder
            java.lang.String r7 = "veltrix_fcm_safety_alerts_channel"
            r6.<init>(r13, r7)
            androidx.core.app.NotificationCompat$Builder r6 = r6.setSmallIcon(r2)
            r7 = r14
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            androidx.core.app.NotificationCompat$Builder r6 = r6.setContentTitle(r7)
            r7 = r15
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            androidx.core.app.NotificationCompat$Builder r6 = r6.setContentText(r7)
            androidx.core.app.NotificationCompat$BigTextStyle r7 = new androidx.core.app.NotificationCompat$BigTextStyle
            r7.<init>()
            r8 = r15
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            androidx.core.app.NotificationCompat$BigTextStyle r7 = r7.bigText(r8)
            androidx.core.app.NotificationCompat$Style r7 = (androidx.core.app.NotificationCompat.Style) r7
            androidx.core.app.NotificationCompat$Builder r6 = r6.setStyle(r7)
            r7 = 2
            androidx.core.app.NotificationCompat$Builder r6 = r6.setPriority(r7)
            java.lang.String r7 = "alarm"
            androidx.core.app.NotificationCompat$Builder r6 = r6.setCategory(r7)
            androidx.core.app.NotificationCompat$Builder r6 = r6.setContentIntent(r1)
            r7 = 1
            androidx.core.app.NotificationCompat$Builder r6 = r6.setAutoCancel(r7)
            r7 = -1
            androidx.core.app.NotificationCompat$Builder r6 = r6.setDefaults(r7)
            java.lang.String r7 = "setDefaults(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.String r7 = "notification"
            java.lang.Object r7 = r13.getSystemService(r7)
            java.lang.String r8 = "null cannot be cast to non-null type android.app.NotificationManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r8)
            android.app.NotificationManager r7 = (android.app.NotificationManager) r7
            long r8 = java.lang.System.currentTimeMillis()
            r10 = 100000(0x186a0, double:4.94066E-319)
            long r8 = r8 % r10
            int r8 = (int) r8
            int r8 = r8 + 2000
            android.app.Notification r9 = r6.build()
            r7.notify(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.utils.SafetyFCMService.showFCMNotification(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* compiled from: SafetyFCMService.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/example/utils/SafetyFCMService$Companion;", "", "<init>", "()V", "TAG", "", "CHANNEL_ID", "CHANNEL_NAME", "createNotificationChannel", "", "context", "Landroid/content/Context;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /tmp/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void createNotificationChannel(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel channel = new NotificationChannel(SafetyFCMService.CHANNEL_ID, SafetyFCMService.CHANNEL_NAME, 4);
                channel.setDescription("Instant Firebase Cloud Messaging alerts for newly captured safety non-conformances and approaching deadlines.");
                channel.enableLights(true);
                channel.enableVibration(true);
                Object systemService = context.getSystemService("notification");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                NotificationManager notificationManager = (NotificationManager) systemService;
                notificationManager.createNotificationChannel(channel);
            }
        }
    }
}
