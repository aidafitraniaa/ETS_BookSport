package com.example.booksport.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = MustardDark,
    onPrimary = White,
    secondary = MustardYellow,
    onSecondary = DarkGray,
    background = White,
    onBackground = DarkGray,
    surface = LightGray,
    onSurface = DarkGray,
    surfaceVariant = Color(0xFFE0E0E0),
    onSurfaceVariant = Color(0xFF424242)
)

private val DarkColorScheme = darkColorScheme(
    primary = MustardYellow,
    onPrimary = DarkGray,
    secondary = MustardDark,
    onSecondary = White,
    background = Color(0xFF121212),
    onBackground = White,
    surface = Color(0xFF1E1E1E),
    onSurface = White,
    surfaceVariant = Color(0xFF2E2E2E),
    onSurfaceVariant = Color(0xFFD3D3D3)
)

@Composable
fun BookSportTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}
