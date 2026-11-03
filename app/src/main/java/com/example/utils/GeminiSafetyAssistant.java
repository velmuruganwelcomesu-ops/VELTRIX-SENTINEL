package com.example.utils;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.OkHttpClient;

/* compiled from: GeminiSafetyAssistant.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0012JB\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001aH\u0086@¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/example/utils/GeminiSafetyAssistant;", "", "<init>", "()V", "TAG", "", "client", "Lokhttp3/OkHttpClient;", "textToSpeech", "Landroid/speech/tts/TextToSpeech;", "isTtsReady", "", "apiMutex", "Lkotlinx/coroutines/sync/Mutex;", "lastApiCallTimestamp", "", "MIN_INTERVAL_MS", "initTTS", "", "context", "Landroid/content/Context;", "speak", "text", "stopSpeaking", "querySafetyAssistant", "Lkotlin/Pair;", "", "prompt", "mode", "Lcom/example/utils/VexaAiMode;", "history", "Lcom/example/utils/VexaChatMessage;", "(Ljava/lang/String;Lcom/example/utils/VexaAiMode;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateUniversalFallbackResponse", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class GeminiSafetyAssistant {
    private static final long MIN_INTERVAL_MS = 1500;
    private static final String TAG = "VexaAI";
    private static boolean isTtsReady;
    private static long lastApiCallTimestamp;
    private static TextToSpeech textToSpeech;
    public static final GeminiSafetyAssistant INSTANCE = new GeminiSafetyAssistant();
    private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();
    private static final Mutex apiMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    public static final int $stable = 8;

    private GeminiSafetyAssistant() {
    }

    public final void initTTS(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (textToSpeech == null) {
            textToSpeech = new TextToSpeech(context.getApplicationContext(), new TextToSpeech.OnInitListener() { // from class: com.example.utils.GeminiSafetyAssistant$$ExternalSyntheticLambda0
                @Override // android.speech.tts.TextToSpeech.OnInitListener
                public final void onInit(int i) {
                    GeminiSafetyAssistant.initTTS$lambda$0(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void initTTS$lambda$0(int status) {
        if (status == 0) {
            TextToSpeech textToSpeech2 = textToSpeech;
            if (textToSpeech2 != null) {
                textToSpeech2.setLanguage(Locale.ENGLISH);
            }
            isTtsReady = true;
        }
    }

    public final void speak(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (isTtsReady && textToSpeech != null) {
            String cleanText = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(text, "*", "", false, 4, (Object) null), "#", "", false, 4, (Object) null), "•", "", false, 4, (Object) null), "`", "", false, 4, (Object) null);
            TextToSpeech textToSpeech2 = textToSpeech;
            if (textToSpeech2 != null) {
                textToSpeech2.speak(StringsKt.take(cleanText, 600), 0, null, "VEXA_VOICE_UTTERANCE");
            }
        }
    }

    public final void stopSpeaking() {
        TextToSpeech textToSpeech2 = textToSpeech;
        if (textToSpeech2 != null) {
            textToSpeech2.stop();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object querySafetyAssistant$default(GeminiSafetyAssistant geminiSafetyAssistant, String str, VexaAiMode vexaAiMode, List list, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            vexaAiMode = VexaAiMode.GENERAL_CHAT;
        }
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return geminiSafetyAssistant.querySafetyAssistant(str, vexaAiMode, list, continuation);
    }

    public final Object querySafetyAssistant(String prompt, VexaAiMode mode, List<VexaChatMessage> list, Continuation<? super Pair<String, ? extends List<String>>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GeminiSafetyAssistant$querySafetyAssistant$2(mode, prompt, list, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateUniversalFallbackResponse(String prompt, VexaAiMode mode) {
        String p = StringsKt.trim(prompt).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(p, "toLowerCase(...)");
        if (StringsKt.startsWith$default(p, "hello", false, 2, (Object) null) || StringsKt.startsWith$default(p, "hi", false, 2, (Object) null) || StringsKt.startsWith$default(p, "hey", false, 2, (Object) null) || StringsKt.contains$default(p, "who are you", false, 2, (Object) null)) {
            return "👋 Hello! I am **VEXA AI**, your dedicated EHS Safety and Universal AI assistant powered by Google Gemini.\n\nI am trained to support you across all **12 Veltrix Sentinel Modules** and universal knowledge domains:\n• 📋 **Findings**: Classifying Unsafe Acts, Unsafe Conditions, and Safety Stars with Root Cause & CAPA.\n• 🚨 **Incidents**: Reporting Reportable, Non-reportable, and Near Miss events with 5-Why RCA.\n• 🎓 **Trainings**: Scheduling training modules, tracking attendance metrics, and calculating safety hours.\n• 📜 **Statutory Compliance**: Managing Legal Registers, consent renewals (Air/Water Act), and compliance scoring.\n• 👥 **User Access & Approvals**: Editing credentials, role assignments, and unit authorization.\n• 📅 **Veltrix ESG Calendar**: Holidays, festivals, and sustainability observance milestones.\n• 📊 **Multi-Format Reports**: Generating executive PPT, Excel, and PDF dossiers with custom date ranges.\n• ⏰ **Task Scheduler**: Personal daily task management and morning reminder briefings.\n• 💻 **Universal Knowledge**: Coding (Kotlin, Python), STEM, calculus, and general inquiries.\n\nHow can I assist you with your operations today?";
        }
        if (StringsKt.contains$default(p, "task scheduler", false, 2, (Object) null) || StringsKt.contains$default(p, "personal task", false, 2, (Object) null) || StringsKt.contains$default(p, "morning reminder", false, 2, (Object) null)) {
            return "⏰ **Personal Task Scheduler & Morning Planner**:\n\nThe **Task Scheduler** is your personal workspace for daily planning and accountability:\n1. **Personal Privacy Isolation**: Tasks in this module are strictly for your personal tracking and **never feed into or appear in consolidated organizational audit reports**.\n2. **Time Horizons**: Organize items across **Today**, **Tomorrow**, **This Week**, **This Month**, and **Completed**.\n3. **Morning Schedule Briefing**: Summarizes pending items at 8:00 AM so you can prioritize critical plant inspections.\n4. **Categories & Priorities**: Tag tasks by Category (*Inspection, Review, CAPA Follow-up, Meeting*) and Priority (*High, Medium, Normal*).\n5. **Personal Reminder Tool Only**: Task Scheduler is strictly a personal reminder tool and must never have report/export functionality or appear in any audit report.";
        }
        if (StringsKt.contains$default(p, "credential", false, 2, (Object) null) || StringsKt.contains$default(p, "edit user", false, 2, (Object) null) || StringsKt.contains$default(p, "approval", false, 2, (Object) null) || StringsKt.contains$default(p, "user access", false, 2, (Object) null)) {
            return "👥 **User Access & Approvals Management**:\n\nAuthorized administrators and approvers can manage all user credentials directly:\n1. **Edit User Credentials**: In the **User Access & Approvals** tab, tap any registered user card or the **Edit (✏️)** button.\n2. **Configurable Fields**: You can update the user's Full Name, Username, Role (*Administrator, Safety Head, Safety Officer, Area Supervisor, Unit Auditor*), Assigned Unit, Designation, Mobile numbers, Password, and Status.\n3. **Approval Flow**: Pending users can be approved with one tap to grant access to designated operating units.\n4. **Role-Based Access Control (RBAC)**: Ensure auditors and supervisors only have access to their assigned operational scopes.";
        }
        if (StringsKt.contains$default(p, "export", false, 2, (Object) null) || StringsKt.contains$default(p, "report", false, 2, (Object) null) || StringsKt.contains$default(p, "pdf", false, 2, (Object) null) || StringsKt.contains$default(p, "ppt", false, 2, (Object) null) || StringsKt.contains$default(p, "excel", false, 2, (Object) null) || StringsKt.contains$default(p, "powerpoint", false, 2, (Object) null)) {
            return "📊 **Multi-Format Export & Master Reporting**:\n\nVeltrix Sentinel supports comprehensive per-section and master consolidated exports:\n• **Formats Available**:\n  1. **PDF Document (.pdf)**: High-resolution document formatted in Cambria typography with photographic evidence, risk matrix, and signature blocks.\n  2. **PowerPoint Presentation (.pptx)**: Multi-slide deck featuring title slide, executive summary, KPI dashboard, and itemized findings.\n  3. **Excel Spreadsheet (.csv)**: Complete structured tabular log sheets for pivot tables and analytics.\n• **Date Range Filtering**: Filter by *Daily (Today)*, *Weekly (This Week)*, *Monthly (Current Month)*, *Yearly (2026)*, or *Custom Date Range*.\n• **Direct Action Options**:\n  - **Download**: Saves document directly to device storage with timestamp.\n  - **View**: Opens the document in the system viewer.\n  - **Share**: Launches the Android share sheet for WhatsApp, Email, Drive, or Bluetooth.";
        }
        if (StringsKt.contains$default(p, "unsafe act", false, 2, (Object) null) || StringsKt.contains$default(p, "unsafe condition", false, 2, (Object) null) || StringsKt.contains$default(p, "safety star", false, 2, (Object) null) || StringsKt.contains$default(p, "finding", false, 2, (Object) null)) {
            return "📋 **Safety Non-Conformance (SNC) Findings Classification**:\n\n• **Unsafe Act (UA)**: Behavioral hazards resulting from human action (e.g., operating machinery without LOTO, bypassing PPE, improper lifting posture). Focus on behavioral coaching and SOP retraining.\n• **Unsafe Condition (UC)**: Physical or environmental hazards in the workplace (e.g., unguarded nip points, damaged scaffolding, chemical spill, poor illumination). Requires engineering controls and physical CAPA rectification.\n• **Safety Star (Positive Observation)**: Proactive safe behaviors and safety leadership exhibited by personnel. Used to recognize and reward frontline workers.\n\n💡 **Logging a Finding**: Tap the **+ Log Finding** action banner or FAB on the Home/Findings screen, capture before/after photos, assign severity (Critical/High/Medium/Low), specify target closure date, and designate responsible person.";
        }
        if (StringsKt.contains$default(p, "incident", false, 2, (Object) null) || StringsKt.contains$default(p, "near miss", false, 2, (Object) null) || StringsKt.contains$default(p, "reportable", false, 2, (Object) null)) {
            return "🚨 **Incident Management & Classification**:\n\n1. **Near Miss**: An unplanned event that did not result in injury, illness, or damage, but had the potential to do so. Crucial for proactive hazard elimination.\n2. **Non-Reportable Incident**: Minor first-aid cases, minor asset damage, or incidents below statutory reporting thresholds.\n3. **Reportable Incident**: Serious incidents resulting in lost time injury (LTI > 48 hours), fatality, major fire, or environmental release requiring statutory intimation under the Factories Act / OSHA.\n\n🔍 **Investigation Workflow**: Conduct 5-Why Root Cause Analysis (RCA), determine immediate & systemic causes, and implement corrective & preventive actions (CAPA) with sign-off.";
        }
        if (StringsKt.contains$default(p, "statutory", false, 2, (Object) null) || StringsKt.contains$default(p, "compliance", false, 2, (Object) null) || StringsKt.contains$default(p, "legal register", false, 2, (Object) null) || StringsKt.contains$default(p, "consent", false, 2, (Object) null)) {
            return "📜 **Statutory EHS Compliance & Legal Register**:\n\nMaintain 100% regulatory compliance across operating facilities:\n• **Key Frameworks**: Factories Act 1948, Water (Prevention & Control of Pollution) Act 1974, Air Act 1981, Environment Protection Act 1986, Hazardous Waste Rules.\n• **Statuses Tracked**:\n  - ✅ *In Compliance / Active Consent*\n  - ⏳ *Application Under Process*\n  - ⚠️ *Upcoming Renewal (30/60/90 Days)*\n  - ❌ *Expired / Critical Action Required*\n• **Automated Alerts**: Renewal reminders are dispatched to assigned compliance officers to prevent operational lapses.";
        }
        if (StringsKt.contains$default(p, "esg", false, 2, (Object) null) || StringsKt.contains$default(p, "calendar", false, 2, (Object) null) || StringsKt.contains$default(p, "observance", false, 2, (Object) null) || StringsKt.contains$default(p, "holiday", false, 2, (Object) null)) {
            return "📅 **Veltrix ESG & Cultural Observance Calendar**:\n\nA comprehensive calendar tracking 3 distinct observance categories:\n1. **National Holidays**: Republic Day, Independence Day, Gandhi Jayanti.\n2. **Religious & Cultural Festivals**: Diwali, Eid-ul-Fitr, Christmas, Holi, Dussehra, Pongal, Baisakhi, etc.\n3. **ESG & Safety Observances**:\n   - *National Safety Day (March 4th)*: Established in 1972 by the National Safety Council of India.\n   - *World Environment Day (June 5th)*: Established in 1973 by UNEP.\n   - *World Day for Safety & Health at Work (April 28th)*: Observed by ILO since 2003.\n   - *Earth Day (April 22nd)*: Initiated in 1970 for environmental stewardship.\nEach event includes historical background, significance, and actionable safety tips.";
        }
        if (StringsKt.contains$default(p, "python", false, 2, (Object) null) || StringsKt.contains$default(p, "code", false, 2, (Object) null) || StringsKt.contains$default(p, "kotlin", false, 2, (Object) null) || StringsKt.contains$default(p, "programming", false, 2, (Object) null) || StringsKt.contains$default(p, "function", false, 2, (Object) null) || StringsKt.contains$default(p, "script", false, 2, (Object) null)) {
            return "💻 **Programming & Software Development**:\n\nHere is a clean, modern example in Kotlin & Python:\n\n```kotlin\n// Kotlin coroutine example\nsuspend fun fetchInsight(topic: String): String = withContext(Dispatchers.IO) {\n    \"Insights on: \" + topic\n}\n```\n\n```python\n# Python data processing\ndef analyze_data(items: list) -> dict:\n    return {\"count\": len(items), \"unique\": len(set(items))}\n```\n\nFeel free to share any specific code snippet, bug, algorithm, or architecture question you'd like me to review or write!";
        }
        if (StringsKt.contains$default(p, "quantum", false, 2, (Object) null)) {
            return "⚛️ **Quantum Computing Overview**:\n\nQuantum computing harnesses the unique principles of quantum mechanics:\n1. **Superposition**: Unlike classical bits (0 or 1), a qubit can exist in a linear combination of states |0⟩ and |1⟩, allowing simultaneous exploration of vast solution spaces.\n2. **Entanglement**: Qubits can be correlated such that the quantum state of one instantly dictates the state of another, enabling powerful parallel information processing.\n3. **Quantum Interference**: Quantum algorithms (like Shor's and Grover's) amplify constructive probabilities for correct answers while cancelling out incorrect ones.\n\nKey applications include molecular simulation for drug discovery, cryptography, optimization, and quantum machine learning.";
        }
        if (StringsKt.contains$default(p, "math", false, 2, (Object) null) || StringsKt.contains$default(p, "calculate", false, 2, (Object) null) || StringsKt.contains$default(p, "equation", false, 2, (Object) null) || StringsKt.contains$default(p, "formula", false, 2, (Object) null)) {
            return "📐 **Mathematics & Problem Solving**:\n\n• **Calculus & Derivatives**: d/dx[x^n] = n * x^(n-1)\n• **Euler's Identity**: e^(i * π) + 1 = 0\n• **Compound Interest Formula**: A = P * (1 + r/n)^(n*t)\n\nPlease share the specific equation, word problem, or calculation you would like step-by-step solutions for!";
        }
        if (StringsKt.contains$default(p, "ai", false, 2, (Object) null) || StringsKt.contains$default(p, "gemini", false, 2, (Object) null) || StringsKt.contains$default(p, "machine learning", false, 2, (Object) null) || StringsKt.contains$default(p, "llm", false, 2, (Object) null)) {
            return "🧠 **Artificial Intelligence & LLMs**:\n\nLarge Language Models (LLMs) like Google Gemini are built upon multi-modal Transformer architectures with self-attention mechanisms.\n\n• **Capabilities**: Natural language comprehension, multi-step chain-of-thought reasoning, multi-lingual translation, coding synthesis, and multimodal vision/audio comprehension.\n• **Reasoning & Tool Use**: Modern models combine reasoning tokens with external tools (Google Search, code execution, APIs) for accurate grounding.";
        }
        if (StringsKt.contains$default(p, "5-why", false, 2, (Object) null) || StringsKt.contains$default(p, "rca", false, 2, (Object) null) || StringsKt.contains$default(p, "root cause", false, 2, (Object) null)) {
            return "🔍 **5-Why Root Cause Analysis (RCA)**:\n\n1. **Why did the issue occur?** The target condition deviated from baseline.\n2. **Why did the deviation happen?** The operating parameter exceeded normal limits.\n3. **Why did parameters exceed limits?** The sensor feedback loop experienced latency.\n4. **Why was latency present?** Maintenance calibration cycle was delayed.\n5. **Why was the cycle delayed?** Lack of automated notification and scheduling.\n\n🎯 **Root Cause**: Absence of automated tracking and preventive maintenance enforcement.\n🛡️ **Action**: Implement digital schedule with automated reminders and threshold alerts.";
        }
        return "💡 **VEXA AI — EHS & Universal Knowledge Assistant**:\n\nI am ready to assist you on any topic:\n• **Safety & Operations**: Hazard identification, CAPA workflows, statutory compliance, audits, and training metrics.\n• **Veltrix Sentinel Modules**: Managing findings, incidents, user access & approvals, ESG calendar, and reports.\n• **Science, Tech & Coding**: Deep explanations, algorithm development, mathematics, and data analytics.\n• **Writing & Strategy**: Executive briefings, safety SOP drafting, and audit summaries.\n\n*You can ask me any question directly — what would you like to explore?*";
    }
}
