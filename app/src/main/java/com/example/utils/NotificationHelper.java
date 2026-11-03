package com.example.utils;

import android.R;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.example.MainActivity;
import com.example.data.Observation;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: NotificationHelper.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ2\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0005J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011J&\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J\u001e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J&\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005J\u001e\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/example/utils/NotificationHelper;", "", "<init>", "()V", "CHANNEL_ID", "", "CHANNEL_NAME", "GENERAL_CHANNEL_ID", "GENERAL_CHANNEL_NAME", "createNotificationChannel", "", "context", "Landroid/content/Context;", "sendSystemPushNotification", "title", "contentText", "notificationId", "", "category", "sendDueDatesNotification", "sendOtpSmsToUser", "mobileNumber", "userName", "otpCode", "openSmsMessengerWithOtp", "sendWhatsAppOtp", "", "sendWhatsAppReminder", "recipientPhone", "observation", "Lcom/example/data/Observation;", "companyName", "sendOtpSmsToAdmin", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class NotificationHelper {
    public static final int $stable = 0;
    private static final String CHANNEL_ID = "snc_due_dates_channel";
    private static final String CHANNEL_NAME = "Veltrix Sentinel Due Dates & Task Reminders";
    private static final String GENERAL_CHANNEL_ID = "veltrix_general_notifications_channel";
    private static final String GENERAL_CHANNEL_NAME = "Veltrix Sentinel Safety Alerts & System Updates";
    public static final NotificationHelper INSTANCE = new NotificationHelper();

    private NotificationHelper() {
    }

    public final void createNotificationChannel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = context.getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            NotificationChannel taskChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 4);
            taskChannel.setDescription("Notifications for upcoming task due dates, overdue hazards, and WhatsApp reminder alerts.");
            taskChannel.enableVibration(true);
            notificationManager.createNotificationChannel(taskChannel);
            NotificationChannel generalChannel = new NotificationChannel(GENERAL_CHANNEL_ID, GENERAL_CHANNEL_NAME, 4);
            generalChannel.setDescription("System notifications, Safety Star accolades, approval requests, and password reset alerts.");
            generalChannel.enableVibration(true);
            notificationManager.createNotificationChannel(generalChannel);
        }
    }

    public static /* synthetic */ void sendSystemPushNotification$default(NotificationHelper notificationHelper, Context context, String str, String str2, int i, String str3, int i2, Object obj) {
        int i3;
        String str4;
        if ((i2 & 8) == 0) {
            i3 = i;
        } else {
            i3 = RangesKt.random(new IntRange(1000, 9999), Random.Default);
        }
        if ((i2 & 16) == 0) {
            str4 = str3;
        } else {
            str4 = "GENERAL";
        }
        notificationHelper.sendSystemPushNotification(context, str, str2, i3, str4);
    }

    public final void sendSystemPushNotification(Context context, String title, String contentText, int notificationId, String category) {
        String channelId;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        Intrinsics.checkNotNullParameter(category, "category");
        try {
            createNotificationChannel(context);
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.setFlags(268468224);
            intent.putExtra("notification_category", category);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, notificationId, intent, 201326592);
            if (!Intrinsics.areEqual(category, "TASK") && !Intrinsics.areEqual(category, "DUE_DATE")) {
                channelId = GENERAL_CHANNEL_ID;
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId).setSmallIcon(R.drawable.ic_dialog_info).setContentTitle(title).setContentText(contentText).setStyle(new NotificationCompat.BigTextStyle().bigText(contentText)).setPriority(1).setDefaults(-1).setContentIntent(pendingIntent).setAutoCancel(true);
                Intrinsics.checkNotNullExpressionValue(builder, "setAutoCancel(...)");
                Object systemService = context.getSystemService("notification");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                NotificationManager notificationManager = (NotificationManager) systemService;
                notificationManager.notify(notificationId, builder.build());
            }
            channelId = CHANNEL_ID;
            NotificationCompat.Builder builder2 = new NotificationCompat.Builder(context, channelId).setSmallIcon(R.drawable.ic_dialog_info).setContentTitle(title).setContentText(contentText).setStyle(new NotificationCompat.BigTextStyle().bigText(contentText)).setPriority(1).setDefaults(-1).setContentIntent(pendingIntent).setAutoCancel(true);
            Intrinsics.checkNotNullExpressionValue(builder2, "setAutoCancel(...)");
            Object systemService2 = context.getSystemService("notification");
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager2 = (NotificationManager) systemService2;
            notificationManager2.notify(notificationId, builder2.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void sendDueDatesNotification$default(NotificationHelper notificationHelper, Context context, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 1001;
        }
        notificationHelper.sendDueDatesNotification(context, str, str2, i);
    }

    public final void sendDueDatesNotification(Context context, String title, String contentText, int notificationId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        sendSystemPushNotification(context, title, contentText, notificationId, "TASK");
    }

    public final void sendOtpSmsToUser(Context context, String mobileNumber, String userName, String otpCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mobileNumber, "mobileNumber");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(otpCode, "otpCode");
        String cleanPhone = StringsKt.replace$default(StringsKt.replace$default(mobileNumber, " ", "", false, 4, (Object) null), "-", "", false, 4, (Object) null);
        sendSystemPushNotification(context, "🔐 Password Reset OTP: " + otpCode, "Your OTP for user '" + userName + "' is " + otpCode + ". Dispatched to mobile number " + cleanPhone + ".", 3003, "PASSWORD");
        try {
            Toast.makeText(context, "📩 OTP Dispatched to " + userName + " (" + cleanPhone + "): Code " + otpCode, 1).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void openSmsMessengerWithOtp(Context context, String mobileNumber, String otpCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mobileNumber, "mobileNumber");
        Intrinsics.checkNotNullParameter(otpCode, "otpCode");
        String cleanPhone = StringsKt.replace$default(StringsKt.replace$default(mobileNumber, " ", "", false, 4, (Object) null), "-", "", false, 4, (Object) null);
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("smsto:" + cleanPhone));
        intent.putExtra("sms_body", "Your Veltrix Sentinel Safety App verification OTP code is: " + otpCode + ". Valid for 10 minutes.");
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "Cannot open default SMS application", 0).show();
        }
    }

    public final boolean sendWhatsAppOtp(Context context, String mobileNumber, String otpCode) {
        String whatsappUrl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mobileNumber, "mobileNumber");
        Intrinsics.checkNotNullParameter(otpCode, "otpCode");
        String cleanPhone = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(mobileNumber, " ", "", false, 4, (Object) null), "-", "", false, 4, (Object) null), "+", "", false, 4, (Object) null);
        String messageText = "🔐 *VELTRIX SENTINEL SAFETY APP VERIFICATION OTP*\n\nYour 6-digit password reset OTP is: *" + otpCode + "*.\n\nPlease enter this code in the app to reset your password.";
        try {
            String encodedMessage = URLEncoder.encode(messageText, "UTF-8");
            if (!StringsKt.isBlank(cleanPhone)) {
                whatsappUrl = "https://api.whatsapp.com/send?phone=" + cleanPhone + "&text=" + encodedMessage;
            } else {
                whatsappUrl = "https://api.whatsapp.com/send?text=" + encodedMessage;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(whatsappUrl));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean sendWhatsAppReminder(Context context, String recipientPhone, Observation observation, String companyName) {
        String typeBadge;
        String encodedMessage;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recipientPhone, "recipientPhone");
        Intrinsics.checkNotNullParameter(observation, "observation");
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        String cleanPhone = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(recipientPhone, " ", "", false, 4, (Object) null), "-", "", false, 4, (Object) null), "(", "", false, 4, (Object) null), ")", "", false, 4, (Object) null), "+", "", false, 4, (Object) null);
        String str = companyName;
        if (StringsKt.isBlank(str)) {
            str = "Main Facility Unit";
        }
        String loggedInUnitName = str;
        String findingType = observation.getFindingType();
        switch (findingType.hashCode()) {
            case -1379113248:
                if (findingType.equals("Safety Star")) {
                    typeBadge = "⭐ *VELTRIX SENTINEL - SAFETY STAR RECOGNITION*";
                    break;
                }
                typeBadge = "🚨 *VELTRIX SENTINEL - SAFETY NON-CONFORMANCE NOTIFICATION*";
                break;
            case -196511967:
                if (findingType.equals("Unsafe Condition")) {
                    typeBadge = "⚡ *VELTRIX SENTINEL - UNSAFE CONDITION NOTIFICATION*";
                    break;
                }
                typeBadge = "🚨 *VELTRIX SENTINEL - SAFETY NON-CONFORMANCE NOTIFICATION*";
                break;
            case 987430680:
                if (findingType.equals("Unsafe Act")) {
                    typeBadge = "⚠️ *VELTRIX SENTINEL - UNSAFE ACT NOTIFICATION*";
                    break;
                }
                typeBadge = "🚨 *VELTRIX SENTINEL - SAFETY NON-CONFORMANCE NOTIFICATION*";
                break;
            default:
                typeBadge = "🚨 *VELTRIX SENTINEL - SAFETY NON-CONFORMANCE NOTIFICATION*";
                break;
        }
        String sncNumber = observation.getSncNumber();
        if (StringsKt.isBlank(sncNumber)) {
            sncNumber = "#SNC-" + observation.getId();
        }
        String location = observation.getLocation();
        String severity = observation.getSeverity();
        String issueDetails = observation.getIssueDetails();
        String suggestion = observation.getSuggestion();
        if (StringsKt.isBlank(suggestion)) {
            suggestion = "Immediate corrective action required";
        }
        String responsiblePerson = observation.getResponsiblePerson();
        if (StringsKt.isBlank(responsiblePerson)) {
            responsiblePerson = "Safety In-Charge";
        }
        String targetDate = observation.getTargetDate();
        if (StringsKt.isBlank(targetDate)) {
            targetDate = "Immediate";
        }
        String whatsappNotificationMode = observation.getWhatsappNotificationMode();
        if (StringsKt.isBlank(whatsappNotificationMode)) {
            whatsappNotificationMode = "Manual";
        }
        String photoUri = observation.getPhotoUri();
        String messageText = StringsKt.trimIndent("\n            " + typeBadge + "\n            \n            🏢 *Logged-in Unit Name*: " + loggedInUnitName + "\n            📌 *SNC Ref*: " + ((Object) sncNumber) + "\n            📍 *Location / Dept*: " + location + "\n            ⚠️ *Severity*: " + severity + "\n            \n            📝 *Hazard / Condition Details*: " + issueDetails + "\n            💡 *Required Corrective Action*: " + ((Object) suggestion) + "\n            \n            👤 *Assigned To*: " + ((Object) responsiblePerson) + "\n            📅 *Target Closure Date*: " + ((Object) targetDate) + "\n            ⚡ *Mode*: " + ((Object) whatsappNotificationMode) + "\n            " + (!(photoUri == null || StringsKt.isBlank(photoUri)) ? "📸 *Photo Evidence*: Attached compressed photo" : "") + "\n            \n            _Please review the attached evidence, perform necessary corrective action, and update status in Veltrix Sentinel._\n        ");
        Uri shareableImageUri = ImageCompressionHelper.INSTANCE.getShareableUri(context, observation.getPhotoUri());
        if (shareableImageUri == null) {
            try {
                encodedMessage = URLEncoder.encode(messageText, "UTF-8");
            } catch (Exception e) {
                e = e;
            }
            try {
                String whatsappUrl = !StringsKt.isBlank(cleanPhone) ? "https://api.whatsapp.com/send?phone=" + cleanPhone + "&text=" + encodedMessage : "https://api.whatsapp.com/send?text=" + encodedMessage;
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(whatsappUrl));
                intent.addFlags(268435456);
                try {
                    context.startActivity(intent);
                } catch (Exception e2) {
                    Intent sendIntent = new Intent("android.intent.action.SEND");
                    sendIntent.setType("text/plain");
                    sendIntent.putExtra("android.intent.extra.TEXT", messageText);
                    sendIntent.addFlags(268435456);
                    Intent chooser = Intent.createChooser(sendIntent, "Share Safety Notification via WhatsApp");
                    chooser.addFlags(268435456);
                    context.startActivity(chooser);
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return false;
            }
        }
        try {
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setType("image/*");
            intent2.putExtra("android.intent.extra.STREAM", shareableImageUri);
            intent2.putExtra("android.intent.extra.TEXT", messageText);
            intent2.setClipData(ClipData.newRawUri("Hazard Evidence", shareableImageUri));
            intent2.addFlags(1);
            intent2.addFlags(268435456);
            PackageManager pm = context.getPackageManager();
            intent2.setPackage("com.whatsapp");
            ResolveInfo waResolved = pm.resolveActivity(intent2, 65536);
            if (waResolved != null) {
                context.grantUriPermission("com.whatsapp", shareableImageUri, 1);
                context.startActivity(intent2);
            } else {
                intent2.setPackage("com.whatsapp.w4b");
                ResolveInfo w4bResolved = pm.resolveActivity(intent2, 65536);
                if (w4bResolved != null) {
                    context.grantUriPermission("com.whatsapp.w4b", shareableImageUri, 1);
                    context.startActivity(intent2);
                } else {
                    intent2.setPackage(null);
                    Intent chooser2 = Intent.createChooser(intent2, "Share Safety Notification via WhatsApp");
                    chooser2.addFlags(268435456);
                    context.startActivity(chooser2);
                }
            }
            return true;
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            return false;
        }
    }

    public final void sendOtpSmsToAdmin(Context context, String mobileNumber, String otpCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mobileNumber, "mobileNumber");
        Intrinsics.checkNotNullParameter(otpCode, "otpCode");
        String cleanPhone = StringsKt.replace$default(StringsKt.replace$default(mobileNumber, " ", "", false, 4, (Object) null), "-", "", false, 4, (Object) null);
        sendDueDatesNotification(context, "🔐 Direct In-App OTP Generated: " + otpCode, "Password Reset OTP Code " + otpCode + " sent directly from App for " + cleanPhone + ".", 3003);
        try {
            Toast.makeText(context, "📩 IN-APP OTP GENERATED: Code '" + otpCode + "' sent directly from App for " + cleanPhone + ".", 1).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
