package com.greedy0110.croops.ui.theme

import androidx.compose.material.Typography
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

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    h1 = TextStyle(
        fontFamily = Gmarket,
        fontWeight = FontWeight.Light,
        fontSize = 32.sp
    ),
    h3 = TextStyle(
        fontFamily = Gmarket,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)