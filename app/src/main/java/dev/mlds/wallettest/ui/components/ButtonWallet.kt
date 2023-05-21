package dev.mlds.wallettest.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.mlds.wallettest.ui.theme.WalletLigthTheme

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = WalletLigthTheme.colors.primaryButton,
            contentColor = WalletLigthTheme.colors.text
        ),
        modifier = modifier.height(55.dp),
        onClick = onClick,
        content = {
            ProvideTextStyle(
                value = WalletLigthTheme.typography.body
            ) {
                content()
            }
        }
    )
}

@Composable
fun SecondButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = WalletLigthTheme.colors.secondButton,
            contentColor = WalletLigthTheme.colors.secondButtonText
        ),
        modifier = modifier.height(55.dp),
        onClick = onClick,
        content = {
            ProvideTextStyle(
                value = WalletLigthTheme.typography.body
            ) {
                content()
            }
        }
    )
}

@Composable
fun ThirdButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Unspecified,
            contentColor = WalletLigthTheme.colors.text
        ),
        modifier = modifier.height(55.dp),
        onClick = onClick,
        content = {
            ProvideTextStyle(
                value = WalletLigthTheme.typography.body
            ) {
                content()
            }
        }
    )
}