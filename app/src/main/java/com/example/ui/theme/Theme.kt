package com.example.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val VeltrixCardShape = RoundedCornerShape(12.dp)
val VeltrixLargeCardShape = RoundedCornerShape(16.dp)
val VeltrixSmallShape = RoundedCornerShape(8.dp)
val VeltrixBadgeShape = RoundedCornerShape(6.dp)
val VeltrixPillShape = RoundedCornerShape(20.dp)

val VeltrixCardBorder = BorderStroke(1.dp, GoldAccents)
val VeltrixPinkCardBorder = BorderStroke(1.dp, BrightPinkHighlight)
val VeltrixBlueCardBorder = BorderStroke(1.dp, GoldAccents)

val VeltrixCardElevation = 2.dp
val VeltrixFloatingCardElevation = 6.dp

private val DarkColorScheme = darkColorScheme(
    primary = BrightPinkHighlight,
    onPrimary = PrimaryText,
    primaryContainer = GradientTop,
    onPrimaryContainer = PrimaryText,
    secondary = GoldAccents,
    onSecondary = TextOnLightPink,
    secondaryContainer = GradientMiddle,
    onSecondaryContainer = PrimaryText,
    tertiary = LightPinkSurface,
    onTertiary = TextOnLightPink,
    tertiaryContainer = GradientBottom,
    onTertiaryContainer = SecondaryText,
    background = GradientBottom,
    onBackground = PrimaryText,
    surface = GradientBottom,
    onSurface = PrimaryText,
    surfaceVariant = GradientMiddle,
    onSurfaceVariant = SecondaryText,
    outline = GoldAccents,
    outlineVariant = BrightPinkHighlight,
    error = StatusCritical,
    onError = PrimaryText
)

private val LightColorScheme = lightColorScheme(
    primary = GradientTop,
    onPrimary = PrimaryText,
    primaryContainer = GradientMiddle,
    onPrimaryContainer = PrimaryText,
    secondary = GoldAccents,
    onSecondary = TextOnLightPink,
    secondaryContainer = GradientMiddle,
    onSecondaryContainer = PrimaryText,
    tertiary = BrightPinkHighlight,
    onTertiary = PrimaryText,
    background = GradientBottom,
    onBackground = PrimaryText,
    surface = GradientBottom,
    onSurface = PrimaryText,
    surfaceVariant = GradientMiddle,
    onSurfaceVariant = SecondaryText,
    outline = GoldAccents,
    outlineVariant = BrightPinkHighlight,
    error = StatusCritical,
    onError = PrimaryText
)

@Composable
fun SncTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
