package com.example.coffeeapp.Presentation.theme

import androidx.compose.ui.graphics.Color

// Existing brand colors — used directly by several screens/components,
// left untouched so nothing else in the app breaks.
val CreamBeige = Color(color = 0xFFEBD4C6)
val CharcoalGray = Color(color = 0xFF313131)
val LightGray = Color(color = 0xFFE1E1E1)
val IvoryWhite = Color(color = 0xFFF7F0EB)
val LightBrown = Color(color = 0xFFC67C4E)

// ---------------------------------------------------------------------
// Coffee-inspired Material 3 color roles
// ---------------------------------------------------------------------

// Light scheme
val CoffeeLightPrimary = LightBrown                     // 0xFFC67C4E
val CoffeeLightOnPrimary = Color(0xFFFFFFFF)
val CoffeeLightPrimaryContainer = CreamBeige             // 0xFFEBD4C6
val CoffeeLightOnPrimaryContainer = Color(0xFF3A2415)
val CoffeeLightSecondary = Color(0xFF8D6E5C)             // muted mocha
val CoffeeLightOnSecondary = Color(0xFFFFFFFF)
val CoffeeLightTertiary = Color(0xFF6F5B40)              // roasted tan
val CoffeeLightOnTertiary = Color(0xFFFFFFFF)
val CoffeeLightBackground = IvoryWhite                   // 0xFFF7F0EB
val CoffeeLightOnBackground = CharcoalGray               // 0xFF313131
val CoffeeLightSurface = Color(0xFFFFFDFB)
val CoffeeLightOnSurface = CharcoalGray
val CoffeeLightSurfaceVariant = CreamBeige
val CoffeeLightOnSurfaceVariant = Color(0xFF5C4A3E)
val CoffeeLightOutline = Color(0xFFB8A99C)
val CoffeeLightError = Color(0xFFBA1A1A)
val CoffeeLightOnError = Color(0xFFFFFFFF)
val CoffeeLightErrorContainer = Color(0xFFFFDAD6)
val CoffeeLightOnErrorContainer = Color(0xFF410002)

// Dark scheme — warm espresso tones, never pure black
val CoffeeDarkPrimary = Color(0xFFE0A872)                // warm caramel, pops on dark bg
val CoffeeDarkOnPrimary = Color(0xFF3A2415)
val CoffeeDarkPrimaryContainer = Color(0xFF4A3222)
val CoffeeDarkOnPrimaryContainer = Color(0xFFFFDDB8)
val CoffeeDarkSecondary = Color(0xFFC9A489)
val CoffeeDarkOnSecondary = Color(0xFF2E1F15)
val CoffeeDarkTertiary = Color(0xFFD3B896)
val CoffeeDarkOnTertiary = Color(0xFF3A2C17)
val CoffeeDarkBackground = Color(0xFF1E1712)             // warm espresso, not pure black
val CoffeeDarkOnBackground = Color(0xFFF3EAE3)
val CoffeeDarkSurface = Color(0xFF2A2019)                // cards sit slightly lighter than bg
val CoffeeDarkOnSurface = Color(0xFFF3EAE3)
val CoffeeDarkSurfaceVariant = Color(0xFF3B2E24)
val CoffeeDarkOnSurfaceVariant = Color(0xFFD8C4B8)
val CoffeeDarkOutline = Color(0xFF7A6255)
val CoffeeDarkError = Color(0xFFFFB4AB)
val CoffeeDarkOnError = Color(0xFF690005)
val CoffeeDarkErrorContainer = Color(0xFF93000A)
val CoffeeDarkOnErrorContainer = Color(0xFFFFDAD6)
