package dev.mlds.wallettest.ui.resume

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.mlds.wallettest.R
import dev.mlds.wallettest.domain.models.CardModel
import dev.mlds.wallettest.ui.components.CardComponent
import dev.mlds.wallettest.ui.components.PrimaryButton
import dev.mlds.wallettest.ui.components.ToolbarWallet
import dev.mlds.wallettest.ui.theme.WalletLigthTheme

@Composable
fun ResumeScreen(
    backClick: () -> Unit = {},
    nextPage: () -> Unit = {}
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(WalletLigthTheme.colors.background)
        ) {
            Image(
                painter = painterResource(R.drawable.background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            Column {
                ToolbarWallet(
                    isTransient = true,
                    primaryIconClick = backClick
                )
                CardComponent(
                    CardModel(
                        id = "",
                        number = "**** **** **** 3727",
                        cvv = "1234",
                        name = "João Carlos Pereira",
                        validade = "06/29",
                        color = CardModel.CardType.GREEN
                    )
                )
                Spacer(modifier = Modifier.size(22.dp))
                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        nextPage()
                    },
                    content = {
                        Text(text = stringResource(id = R.string.next_button))
                    }
                )
            }
        }
    }
}