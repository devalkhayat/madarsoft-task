package com.madarsoft.core.common.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.madarsoft.core.common.R


/**************************************************************/

data class Colors(
    val black: Color = Color(0xFF000000),
    val gray: Color = Color(0xFFD0D5DD),
    val blue: Color = Color(0xFF002E96),
    val white: Color = Color(0xFFFFFFFF)


    )

val LocalColors= compositionLocalOf { Colors()  }

val MaterialTheme.colors: Colors
    @Composable @ReadOnlyComposable get() = LocalColors.current



/**************************************************************/

private val fonts= FontFamily(
    Font(R.font.inter_regular, weight = FontWeight.Normal),
    Font(R.font.inter_medium, weight = FontWeight.Medium),
    Font(R.font.inter_semibold, weight = FontWeight.SemiBold)
)

object FontSizes {
    val small: TextUnit = 16.sp
    val large: TextUnit = 18.sp
    val xlarge: TextUnit = 20.sp
}

data class Labels(
    val title:TextStyle =TextStyle(
                                        fontFamily = fonts,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = FontSizes.large,
                                        lineHeight =FontSizes.large,
                                        letterSpacing = 0.5.sp,
                                        color = Colors().black
                                    ),

    val normal:TextStyle =TextStyle(
                                            fontFamily = fonts,
                                            fontWeight = FontWeight.Normal,
                                            fontSize = FontSizes.large,
                                            lineHeight = FontSizes.large,
                                            letterSpacing = 0.5.sp,
                                            color = Colors().black
                                        ),

    val header:TextStyle =TextStyle(
                                            fontFamily = fonts,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = FontSizes.xlarge,
                                            lineHeight = FontSizes.xlarge,
                                            letterSpacing = 0.5.sp,
                                            color = Colors().black
                                        ),
    val button:TextStyle =TextStyle(
                                            fontFamily = fonts,
                                            fontWeight = FontWeight.Normal,
                                            fontSize = FontSizes.large,
                                            lineHeight = FontSizes.large,
                                            letterSpacing = 0.5.sp,
                                            color = Colors().white
                                        ),

    val inputFieldCaption:TextStyle =TextStyle(
                                                fontFamily = fonts,
                                                fontWeight = FontWeight.Medium,
                                                fontSize = FontSizes.small,
                                                lineHeight = FontSizes.small,
                                                letterSpacing = 0.5.sp,
                                                color = Colors().black
                                            ),

    val dropDownLabel:TextStyle =TextStyle(
                                                fontFamily = fonts,
                                                fontWeight = FontWeight.Medium,
                                                fontSize = FontSizes.small,
                                                lineHeight = FontSizes.small,
                                                letterSpacing = 0.5.sp,
                                                color = Colors().black
                                            ),

    val inputFieldPlaceHolder:TextStyle =TextStyle(
                                            fontFamily = fonts,
                                            fontWeight = FontWeight.Medium,
                                            fontSize = FontSizes.small,
                                            lineHeight = FontSizes.small,
                                            letterSpacing = 0.5.sp,
                                            color = Colors().gray
                                        ),


)

val LocalLabels= compositionLocalOf { Labels()  }

val MaterialTheme.labels: Labels
    @Composable @ReadOnlyComposable get() = LocalLabels.current








