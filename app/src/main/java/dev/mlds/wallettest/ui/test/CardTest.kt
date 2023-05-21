package dev.mlds.wallettest.ui.test

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mlds.wallettest.R
import dev.mlds.wallettest.WalletTestApp
import dev.mlds.wallettest.domain.models.CardModel
import dev.mlds.wallettest.domain.models.CardsModel
import dev.mlds.wallettest.ui.theme.WalletLigthTheme

@Composable
fun CardItem(card: CardModel) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
            .padding(16.dp)
            .animateContentSize()
    ) {
        if (expanded) {
            Column(
                modifier = Modifier
                    .background(card.color?.background ?: WalletLigthTheme.cardColors.background)
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 30.dp)
            ) {
                Text(text = card.color?.title.orEmpty())
                Spacer(modifier = Modifier.size(30.dp))
                Text(text = card.name)
                Text(text = card.number)
                Row {
                    Text(text = stringResource(id = R.string.doDate))
                    Spacer(modifier = Modifier.size(6.dp))
                    Text(text = card.validade)
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .background(card.color?.background ?: WalletLigthTheme.cardColors.background)
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 30.dp)
            ) {
                Text(text = card.color?.title.orEmpty())
            }
        }
    }
}

@Composable
fun CardList(cardList: CardsModel) {
    var cards by remember { mutableStateOf(cardList.cards) }

    LazyColumn {
        items(cards) { card ->
            CardItem(card = card)
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Button(
                onClick = { cards.drop(cards.lastIndex) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .animateContentSize() // Animates the size changes of the button
            ) {
                Text(text = "Remove Last Card")
            }
        }
    }
}

@Preview(name = "CardListPreview", showBackground = true)
@Composable
fun CardListPreview() {
    CardList(
        CardsModel(
            cards = listOf(
                CardModel(
                    id = "",
                    number = "**** **** **** 3727",
                    cvv = "1234",
                    name = "João Carlos Pereira",
                    validade = "06/29",
                    color = CardModel.CardType.GREEN
                )
            )
        )
    )
}