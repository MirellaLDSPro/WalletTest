package dev.mlds.wallettest.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import dev.mlds.wallettest.R
import dev.mlds.wallettest.domain.models.CardModel
import dev.mlds.wallettest.ui.theme.WalletLigthTheme

@Composable
fun CardComponent(card: CardModel, index: Int = 0) {
    var expanded by remember { mutableStateOf(false) }

    if (expanded) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .offset { IntOffset(0, index * (-100)) }
                .clickable { expanded = !expanded }
                .animateContentSize(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {
            CardBody(card)
        }
    } else {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .offset { IntOffset(0, index * (-100)) }
                .clickable { expanded = !expanded }
                .animateContentSize(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .background(
                        card.color?.background ?: WalletLigthTheme.cardColors.background
                    )
                    .fillMaxWidth()
                    .padding(vertical = 30.dp, horizontal = 16.dp)
            ) {
                card.color?.let {
                    Text(
                        color = it.textColor,
                        text = it.title
                    )
                }
            }
        }
    }
}

@Composable
private fun CardBody(c: CardModel) {
    Column(
        modifier = Modifier
            .background(c.color?.background ?: WalletLigthTheme.cardColors.background)
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 30.dp)
    ) {
        Text(text = c.color?.title.orEmpty())
        Spacer(modifier = Modifier.size(30.dp))
        Text(text = c.name)
        Text(text = c.number)
        Row {
            Text(text = stringResource(id = R.string.doDate))
            Spacer(modifier = Modifier.size(6.dp))
            Text(text = c.validade)
        }
    }
}

@Preview(name = "Card", showBackground = true)
@Composable
fun CardComponentPreview() {
    WalletLigthTheme {
        CardComponent(
            CardModel(
                id = "",
                number = "**** **** **** 3727",
                cvv = "1234",
                name = "João Carlos Pereira",
                validade = "06/29",
                color = CardModel.CardType.GREEN
            ), index = 0
        )
    }
}