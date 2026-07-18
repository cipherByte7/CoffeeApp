package com.example.coffeeapp.Presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = CoffeeDarkPrimary,
    onPrimary = CoffeeDarkOnPrimary,
    primaryContainer = CoffeeDarkPrimaryContainer,
    onPrimaryContainer = CoffeeDarkOnPrimaryContainer,
    secondary = CoffeeDarkSecondary,
    onSecondary = CoffeeDarkOnSecondary,
    tertiary = CoffeeDarkTertiary,
    onTertiary = CoffeeDarkOnTertiary,
    background = CoffeeDarkBackground,
    onBackground = CoffeeDarkOnBackground,
    surface = CoffeeDarkSurface,
    onSurface = CoffeeDarkOnSurface,
    surfaceVariant = CoffeeDarkSurfaceVariant,
    onSurfaceVariant = CoffeeDarkOnSurfaceVariant,
    outline = CoffeeDarkOutline,
    error = CoffeeDarkError,
    onError = CoffeeDarkOnError,
    errorContainer = CoffeeDarkErrorContainer,
    onErrorContainer = CoffeeDarkOnErrorContainer
)

private val LightColorScheme = lightColorScheme(
    primary = CoffeeLightPrimary,
    onPrimary = CoffeeLightOnPrimary,
    primaryContainer = CoffeeLightPrimaryContainer,
    onPrimaryContainer = CoffeeLightOnPrimaryContainer,
    secondary = CoffeeLightSecondary,
    onSecondary = CoffeeLightOnSecondary,
    tertiary = CoffeeLightTertiary,
    onTertiary = CoffeeLightOnTertiary,
    background = CoffeeLightBackground,
    onBackground = CoffeeLightOnBackground,
    surface = CoffeeLightSurface,
    onSurface = CoffeeLightOnSurface,
    surfaceVariant = CoffeeLightSurfaceVariant,
    onSurfaceVariant = CoffeeLightOnSurfaceVariant,
    outline = CoffeeLightOutline,
    error = CoffeeLightError,
    onError = CoffeeLightOnError,
    errorContainer = CoffeeLightErrorContainer,
    onErrorContainer = CoffeeLightOnErrorContainer
)

@Composable
fun CoffeeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color would replace our coffee palette with wallpaper-derived
    // colors on Android 12+, so it's off by default to keep the brand look
    // consistent. Callers can still opt in explicitly if ever needed.
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
