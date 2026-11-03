package com.example.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GeminiSafetyAssistant.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/example/utils/VexaAiMode;", "", "title", "", "badge", "modelName", "description", "iconName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getBadge", "getModelName", "getDescription", "getIconName", "GENERAL_CHAT", "PRO_REASONING", "FAST_LITE", "VOICE_LIVE", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public enum VexaAiMode {
    GENERAL_CHAT("Omni Assistant", "🌐 gemini-2.5-flash", "gemini-2.5-flash", "Universal AI powered by Google Gemini — answers any question on any topic, field, or subject", "auto_awesome"),
    PRO_REASONING("Pro Reasoning", "🧠 gemini-2.5-pro", "gemini-2.5-pro", "Advanced reasoning, complex mathematics, coding, STEM, analysis, and deep problem solving", "psychology"),
    FAST_LITE("Flash Lite", "⚡ gemini-2.5-flash-lite", "gemini-2.5-flash-lite", "Ultra-fast lightning responses for instant Q&A, summaries, and general questions", "bolt"),
    VOICE_LIVE("Live Voice Chat", "🎙️ gemini-2.5-flash", "gemini-2.5-flash", "Hands-free voice conversation assistant with speech-to-text and voice playback on any subject", "mic");

    private final String badge;
    private final String description;
    private final String iconName;
    private final String modelName;
    private final String title;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final VexaAiMode SEARCH_GROUNDED = GENERAL_CHAT;

    public static EnumEntries<VexaAiMode> getEntries() {
        return $ENTRIES;
    }

    VexaAiMode(String title, String badge, String modelName, String description, String iconName) {
        this.title = title;
        this.badge = badge;
        this.modelName = modelName;
        this.description = description;
        this.iconName = iconName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBadge() {
        return this.badge;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIconName() {
        return this.iconName;
    }

    /* compiled from: GeminiSafetyAssistant.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/example/utils/VexaAiMode$Companion;", "", "<init>", "()V", "SEARCH_GROUNDED", "Lcom/example/utils/VexaAiMode;", "getSEARCH_GROUNDED", "()Lcom/example/utils/VexaAiMode;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /tmp/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VexaAiMode getSEARCH_GROUNDED() {
            return VexaAiMode.SEARCH_GROUNDED;
        }
    }
}
