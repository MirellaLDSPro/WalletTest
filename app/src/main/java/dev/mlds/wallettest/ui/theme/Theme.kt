package dev.mlds.wallettest.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Immutable
data class ExtendedColors(
    val ToolbarBackground: Color,
    val background: Color,
    val text: Color,
    val primary: Color,
    val textEnabled: Color,
    val TitleScreenText: Color,
    val darkText: Color,
    val primaryButton: Color,
    val secondButton: Color,
    val secondButtonText: Color
)

@Immutable
data class CardColors(
    val background: Color,
    val text: Color
)

@Immutable
data class CustomTypography(
    val body: TextStyle,
    val title: TextStyle
)

private val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        ToolbarBackground = Color.Unspecified,
        background = Color.Unspecified,
        text = Color.Unspecified,
        primary = Color.Unspecified,
        textEnabled = Color.Unspecified,
        TitleScreenText = Color.Unspecified,
        darkText = Color.Unspecified,
        primaryButton = Color.Unspecified,
        secondButton = Color.Unspecified,
        secondButtonText = Color.Unspecified
    )
}

private val LocalCardColors = staticCompositionLocalOf {
    CardColors(
        background = Color.Unspecified,
        text = Color.Unspecified
    )
}

val LocalCustomTypography = staticCompositionLocalOf {
    CustomTypography(
        body = TextStyle.Default,
        title = TextStyle.Default
    )
}

@Composable
fun WalletLigthTheme(
    content: @Composable () -> Unit
) {
    val extendedColors = ExtendedColors(
        ToolbarBackground = ToolbarBackground,
        background = Background,
        text = Text,
        primary = primary,
        textEnabled = primary,
        TitleScreenText = TitleScreenText,
        darkText = DarkText,
        primaryButton = PrimaryButton,
        secondButton = SecondButton,
        secondButtonText = secondButtonText
    )

    val cardColors = CardColors(
        background = cardGreen,
        text = cardGreenText
    )

    val customTypography = CustomTypography(
        body = TextStyle(fontSize = 16.sp),
        title = TextStyle(fontSize = 28.sp)
    )
    CompositionLocalProvider(
        LocalExtendedColors provides extendedColors,
        LocalCardColors provides cardColors,
        LocalCustomTypography provides customTypography
    ) {
        MaterialTheme(
            /* colors = ..., typography = ..., shapes = ... */
            typography = WalletTypography,
            content = content
        )
    }
}

object WalletLigthTheme {
    val colors: ExtendedColors
        @Composable
        get() = LocalExtendedColors.current
    val cardColors: CardColors
        @Composable
        get() = LocalCardColors.current
    val typography: CustomTypography
        @Composable
        get() = LocalCustomTypography.current
}