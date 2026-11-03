package com.example.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// =========================================================================
// VELTRIX SENTINEL - GLOBAL PINK / MAGENTA GRADIENT THEME SPECIFICATION
// =========================================================================

// Exact User Required Deep-Red / Dark-Crimson Colors (matching Login screen):
val GradientTop = Color(0xFF8B0025)              // #8B0025 - Gradient top (rich wine crimson)
val GradientMiddle = Color(0xFF680014)           // #680014 - Gradient middle (deep crimson)
val GradientBottom = Color(0xFF51000D)           // #51000D - Gradient bottom (darkest wine red)
val BrightPinkHighlight = Color(0xFFA3002E)      // #A3002E - Crimson highlight
val LightPinkSurface = Color(0xFFE8A0BC)         // #E8A0BC - Light-pink surface
val GoldAccents = Color(0xFFF2B705)              // #F2B705 - Gold accents
val PrimaryText = Color(0xFFFDF4E8)              // #FDF4E8 - Primary text
val SecondaryText = Color(0xFFE8C4D4)            // #E8C4D4 - Secondary text
val TextOnLightPink = Color(0xFF650D32)          // #650D32 - Text on light surfaces

// =========================================================================
// SHARED REUSABLE THEME TOKENS
// =========================================================================

val VeltrixDarkPinkDeep = GradientBottom          // #880E4F
val VeltrixDarkPinkMid = GradientMiddle           // #AD1457
val VeltrixDarkPinkPrimary = GradientTop          // #C2185B
val VeltrixDarkPinkLight = BrightPinkHighlight    // #D81B60
val VeltrixDarkPinkBorder = BrightPinkHighlight   // #D81B60

// Global Pink / Magenta Gradients
val VeltrixDarkPinkGradient = Brush.verticalGradient(
    listOf(GradientTop, GradientMiddle, GradientBottom)
)

val VeltrixCanvasGradient = Brush.verticalGradient(
    listOf(GradientTop, GradientMiddle, GradientBottom)
)

val VeltrixHeaderGradient = Brush.horizontalGradient(
    listOf(GradientTop, BrightPinkHighlight, GradientMiddle)
)

val VeltrixCardGradient = Brush.verticalGradient(
    listOf(GradientTop, GradientMiddle)
)

val VeltrixButtonGradient = Brush.horizontalGradient(
    listOf(BrightPinkHighlight, GradientTop)
)

// Legacy compatibility mappings updated to coordinated pink shades
val BrandBlueStructural = GradientTop
val BrandBlueSecondary = BrightPinkHighlight
val BrandBlueDark = GradientBottom
val BrandBlueLight = LightPinkSurface
val BrandBlueSubtle = Color(0xFFFCE4EC)
val BrandBlueBorder = BrightPinkHighlight

// Category Colors - Coordinated with Pink/Gold
val CategoryDashboard = BrightPinkHighlight
val CategoryUnsafeAct = Color(0xFFE91E63)
val CategoryUnsafeCondition = Color(0xFFC2185B)
val CategorySafetyStar = GoldAccents
val CategoryIncidents = Color(0xFFE53935)
val CategoryCompliance = Color(0xFF9C27B0)
val CategoryReminders = Color(0xFFAD1457)
val CategoryTrainings = Color(0xFF880E4F)
val CategoryReports = BrightPinkHighlight
val CategoryAccess = Color(0xFFD81B60)
val CategoryDueDashboard = GoldAccents

// Status Colors
val StatusCritical = Color(0xFFE53935)
val StatusCriticalLight = Color(0xFFFFEBEE)
val StatusCriticalBorder = Color(0xFFEF9A9A)
val StatusWarning = GoldAccents
val StatusWarningLight = Color(0xFFFFF8E1)
val StatusWarningBorder = Color(0xFFFFE082)
val StatusSuccess = Color(0xFF43A047)
val StatusSuccessLight = Color(0xFFE8F5E9)
val StatusSuccessBorder = Color(0xFFA5D6A7)
val StatusInfo = BrightPinkHighlight
val StatusInfoLight = Color(0xFFFCE4EC)
val StatusInfoBorder = LightPinkSurface

// Surfaces & Borders
val SurfaceWhite = Color(0xFFFFFFFF)
val SurfaceCard = LightPinkSurface
val SurfaceCardAlt = LightPinkSurface
val SurfaceMuted = Color(0xFFF8BBD0)
val BorderCardDefault = GoldAccents
val BorderCardPink = BrightPinkHighlight
val BorderCardBlue = GoldAccents

// Text Colors
val TextPrimaryDark = PrimaryText
val TextSecondaryDark = SecondaryText
val TextMutedDark = Color(0xFFD4A5BA)
val TextPrimaryLight = TextOnLightPink
val TextSecondaryLight = Color(0xFF7A1A40)
val TextMutedLight = Color(0xFF8E2E55)
val TextAccentGold = GoldAccents

val SafetyRed = StatusCritical
val SafetyRedDark = Color(0xFFB71C1C)
val SafetyRedLight = StatusCriticalLight
val SafetyGreen = StatusSuccess
val SafetyGreenLight = StatusSuccessLight
val SafetyAmber = StatusWarning
val SafetyAmberLight = StatusWarningLight
val SafetyBlue = BrightPinkHighlight
val SafetyBlueLight = StatusInfoLight
val SafetyBlueDark = GradientBottom

val DarkSurface = GradientBottom
val DarkBackground = GradientBottom
val LightBackground = GradientBottom
val VeltrixDeepWineText = TextOnLightPink

// High Contrast Tokens
val HighContrastTextDarkPrimary = PrimaryText
val HighContrastTextDarkSecondary = SecondaryText
val HighContrastTextDarkMuted = Color(0xFFD4A5BA)
val HighContrastTextLightPrimary = TextOnLightPink
val HighContrastTextLightSecondary = Color(0xFF7A1A40)
val HighContrastTextLightMuted = Color(0xFF8E2E55)
val HighContrastHeadingGold = GoldAccents
val HighContrastHeadingGoldBright = Color(0xFFFFD54F)
val HighContrastHeadingBlue = BrightPinkHighlight
val HighContrastHeadingTeal = Color(0xFFEC407A)
val HighContrastHeadingAmber = GoldAccents
val HighContrastCardHeadingBlue = TextOnLightPink
val HighContrastCardHeadingTeal = TextOnLightPink
val HighContrastCardHeadingAmber = GoldAccents
val HighContrastPlaceholder = Color(0xFFD4A5BA)
val HighContrastPlaceholderDarkBg = SecondaryText
val HighContrastDisabledText = Color(0xFF8E2E55)
val HighContrastDisabledContainer = Color(0xFFF8BBD0)
val HighContrastDivider = BrightPinkHighlight.copy(alpha = 0.3f)
val HighContrastGoldOnDark = GoldAccents
val HighContrastGoldOnLight = Color(0xFFB78103)
val HighContrastGreenIndicator = Color(0xFF2E7D32)
val HighContrastRedIndicator = Color(0xFFC62828)
val HighContrastWhiteText = PrimaryText
