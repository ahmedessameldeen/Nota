package com.nota.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// ── Light palette ──────────────────────────────────────────────────────────────
private object Light {
    val Primary            = Color(0xFF1A6B4A)
    val OnPrimary          = Color(0xFFFFFFFF)
    val PrimaryContainer   = Color(0xFFB2F0D4)
    val OnPrimaryContainer = Color(0xFF002114)
    val Secondary          = Color(0xFF4A6358)
    val OnSecondary        = Color(0xFFFFFFFF)
    val SecondaryContainer = Color(0xFFCCE8DA)
    val OnSecondaryContainer = Color(0xFF072017)
    val Tertiary           = Color(0xFF3A6472)
    val TertiaryContainer  = Color(0xFFBDE9FA)
    val Background         = Color(0xFFF8FAF8)
    val Surface            = Color(0xFFF8FAF8)
    val SurfaceContainerLow = Color(0xFFEFF3EF)
    val SurfaceContainerHigh = Color(0xFFE4EAE4)
    val OnBackground       = Color(0xFF191C1A)
    val OnSurface          = Color(0xFF191C1A)
    val OnSurfaceVariant   = Color(0xFF3F4944)
    val Outline            = Color(0xFF6F7973)
    val OutlineVariant     = Color(0xFFBEC9C2)
    val Error              = Color(0xFFBA1A1A)
    val ErrorContainer     = Color(0xFFFFDAD6)
    val OnErrorContainer   = Color(0xFF410002)
}

// ── Dark palette ───────────────────────────────────────────────────────────────
private object Dark {
    val Primary            = Color(0xFF87D8B0)
    val OnPrimary          = Color(0xFF003824)
    val PrimaryContainer   = Color(0xFF005236)
    val OnPrimaryContainer = Color(0xFFA3F4CC)
    val Secondary          = Color(0xFFB1CCBE)
    val OnSecondary        = Color(0xFF1D352B)
    val SecondaryContainer = Color(0xFF334B41)
    val OnSecondaryContainer = Color(0xFFCCE8DA)
    val Background         = Color(0xFF101411)
    val Surface            = Color(0xFF101411)
    val SurfaceContainerLow = Color(0xFF191C1A)
    val SurfaceContainerHigh = Color(0xFF252927)
    val OnBackground       = Color(0xFFE1E3DF)
    val OnSurface          = Color(0xFFE1E3DF)
    val OnSurfaceVariant   = Color(0xFFBEC9C2)
    val Outline            = Color(0xFF89938D)
    val OutlineVariant     = Color(0xFF3F4944)
    val Error              = Color(0xFFFFB4AB)
    val ErrorContainer     = Color(0xFF93000A)
    val OnErrorContainer   = Color(0xFFFFDAD6)
}

private val LightColorScheme = lightColorScheme(
    primary = Light.Primary,
    onPrimary = Light.OnPrimary,
    primaryContainer = Light.PrimaryContainer,
    onPrimaryContainer = Light.OnPrimaryContainer,
    secondary = Light.Secondary,
    onSecondary = Light.OnSecondary,
    secondaryContainer = Light.SecondaryContainer,
    onSecondaryContainer = Light.OnSecondaryContainer,
    tertiary = Light.Tertiary,
    tertiaryContainer = Light.TertiaryContainer,
    background = Light.Background,
    surface = Light.Surface,
    surfaceContainerLow = Light.SurfaceContainerLow,
    surfaceContainerHigh = Light.SurfaceContainerHigh,
    onBackground = Light.OnBackground,
    onSurface = Light.OnSurface,
    onSurfaceVariant = Light.OnSurfaceVariant,
    outline = Light.Outline,
    outlineVariant = Light.OutlineVariant,
    error = Light.Error,
    errorContainer = Light.ErrorContainer,
    onErrorContainer = Light.OnErrorContainer
)

private val DarkColorScheme = darkColorScheme(
    primary = Dark.Primary,
    onPrimary = Dark.OnPrimary,
    primaryContainer = Dark.PrimaryContainer,
    onPrimaryContainer = Dark.OnPrimaryContainer,
    secondary = Dark.Secondary,
    onSecondary = Dark.OnSecondary,
    secondaryContainer = Dark.SecondaryContainer,
    onSecondaryContainer = Dark.OnSecondaryContainer,
    background = Dark.Background,
    surface = Dark.Surface,
    surfaceContainerLow = Dark.SurfaceContainerLow,
    surfaceContainerHigh = Dark.SurfaceContainerHigh,
    onBackground = Dark.OnBackground,
    onSurface = Dark.OnSurface,
    onSurfaceVariant = Dark.OnSurfaceVariant,
    outline = Dark.Outline,
    outlineVariant = Dark.OutlineVariant,
    error = Dark.Error,
    errorContainer = Dark.ErrorContainer,
    onErrorContainer = Dark.OnErrorContainer
)

private val NotaTypography = Typography(
    displayLarge  = TextStyle(fontSize = 57.sp, fontWeight = FontWeight.Normal,    lineHeight = 64.sp, letterSpacing = (-0.25).sp),
    headlineLarge = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 40.sp, letterSpacing = (-0.5).sp),
    headlineMedium= TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold,      lineHeight = 36.sp, letterSpacing = (-0.25).sp),
    headlineSmall = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold,  lineHeight = 32.sp),
    titleLarge    = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.SemiBold,  lineHeight = 28.sp),
    titleMedium   = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold,  lineHeight = 24.sp, letterSpacing = 0.15.sp),
    titleSmall    = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium,    lineHeight = 20.sp, letterSpacing = 0.1.sp),
    bodyLarge     = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal,    lineHeight = 26.sp, letterSpacing = 0.5.sp),
    bodyMedium    = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal,    lineHeight = 22.sp, letterSpacing = 0.25.sp),
    bodySmall     = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal,    lineHeight = 18.sp, letterSpacing = 0.4.sp),
    labelLarge    = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium,    lineHeight = 20.sp, letterSpacing = 0.1.sp),
    labelMedium   = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium,    lineHeight = 16.sp, letterSpacing = 0.5.sp),
    labelSmall    = TextStyle(fontSize = 11.sp, fontWeight = FontWeight.Medium,    lineHeight = 16.sp, letterSpacing = 0.5.sp),
)

@Composable
fun NotaTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = NotaTypography,
        content = content
    )
}
