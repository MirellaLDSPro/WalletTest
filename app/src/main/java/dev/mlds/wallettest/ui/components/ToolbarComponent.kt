package dev.mlds.wallettest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mlds.wallettest.R
import dev.mlds.wallettest.ui.theme.WalletLigthTheme

@Composable
fun ToolbarWallet(
    isTransient: Boolean = false,
    primaryIconClick: () -> Unit = {},
    secondIconClick: (() -> Unit)? = null
) {
    Card(
        shape = RoundedCornerShape(0.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(WalletLigthTheme.colors.ToolbarBackground)
                .padding(21.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier.clickable { primaryIconClick() },
                    painter = painterResource(R.drawable.ic_btn_back),
                    contentDescription = stringResource(id = R.string.back)
                )
                ProvideTextStyle(
                    value = WalletLigthTheme.typography.title
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        textAlign = TextAlign.Center,
                        color = WalletLigthTheme.colors.darkText,
                        text = stringResource(id = R.string.label_home)
                    )
                }
                Image(
                    modifier = Modifier
                        .clickable { secondIconClick?.invoke() },
                    painter = painterResource(R.drawable.ic_btn_plus),
                    contentDescription = stringResource(id = R.string.create)
                )
            }
        }
    }
}

@Preview(name = "ToolbarWallet Ligth Mode", showBackground = true)
@Composable
fun ToolbarWalletPreview() {
    WalletLigthTheme {
        ToolbarWallet()
    }
}