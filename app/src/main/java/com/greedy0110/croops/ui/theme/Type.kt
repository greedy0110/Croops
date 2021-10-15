package com.greedy0110.croops.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.greedy0110.croops.R

val Gmarket = FontFamily(
    Font(R.font.gmarket_light, weight = FontWeight.Light),
    Font(R.font.gmarket_medium, weight = FontWeight.Medium),
    Font(R.font.gmarket_bold, weight = FontWeight.Bold),
)

val croopTypography = CroopTypography(
    header = TextStyle(
        fontFamily = Gmarket,
        fontWeight = FontWeight.Light,
        fontSize = 32.sp
    ),
    title1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    title2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    body3 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    ),
    body4 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    caption1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp
    ),
    caption2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
)

@Immutable
data class CroopTypography(
    val header: TextStyle = TextStyle.Default,
    val title1: TextStyle = TextStyle.Default,
    val title2: TextStyle = TextStyle.Default,
    val body1: TextStyle = TextStyle.Default,
    val body2: TextStyle = TextStyle.Default,
    val body3: TextStyle = TextStyle.Default,
    val body4: TextStyle = TextStyle.Default,
    val caption1: TextStyle = TextStyle.Default,
    val caption2: TextStyle = TextStyle.Default,
)

val LocalCroopTypography = staticCompositionLocalOf {
    CroopTypography()
}

object CroopTheme {
    val typography: CroopTypography
        @Composable
        get() = LocalCroopTypography.current
}