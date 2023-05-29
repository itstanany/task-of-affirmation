package com.tananygeek.toa.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.tananygeek.toa.R

private val UrbanistExtraBold = FontFamily(Font(R.font.urbanist_extrabold))
private val UrbanistSemiBold = FontFamily(Font(R.font.urbanist_semibold))

private val UrbanistBold = FontFamily(Font(R.font.urbanist_bold))
private val UrbanistMedium = FontFamily(Font(R.font.urbanist_medium))
private val UrbanistLight = FontFamily(Font(R.font.urbanist_light))

// Set of Material typography styles to start with
val Typography = Typography(
//    h1
    headlineLarge = TextStyle(
        fontFamily = UrbanistExtraBold,
        fontSize = 40.sp,
    ),
//  h2
    headlineMedium = TextStyle(
        fontFamily = UrbanistExtraBold,
        fontSize = 36.sp,
    ),
//  h3
    headlineSmall = TextStyle(
        fontFamily = UrbanistSemiBold,
        fontSize = 13.sp,
    ),
//    body1
    bodyLarge = TextStyle(
        fontFamily = UrbanistLight,
        fontSize = 13.sp,
    ),
//    subtitle1
    labelSmall = TextStyle(
        fontFamily = UrbanistMedium,
        fontSize = 15.sp,
    ),
//    button
    labelMedium = TextStyle(
        fontFamily = UrbanistBold,
        fontSize = 13.sp,
    ),
    /*

Other default text styles to override
titleLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 22.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.sp
),

*/
)
