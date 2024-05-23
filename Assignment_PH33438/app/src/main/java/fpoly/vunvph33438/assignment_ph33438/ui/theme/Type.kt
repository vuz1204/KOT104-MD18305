package fpoly.vunvph33438.assignment_ph33438.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import fpoly.vunvph33438.assignment_ph33438.R

val Gelasio = FontFamily(
    Font(R.font.gelasio_semibold, FontWeight.W600),
)

val Nunitosans = FontFamily(
    Font(R.font.nunitosans_regular, FontWeight.W400),
)

val Merriweather_regular = FontFamily(
    Font(R.font.merriweather_regular, FontWeight.W400),
)

val Merriweather_bold = FontFamily(
    Font(R.font.merriweather_bold, FontWeight.W700),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)