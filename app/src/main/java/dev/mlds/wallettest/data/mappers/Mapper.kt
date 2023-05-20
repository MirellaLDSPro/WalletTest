package dev.mlds.wallettest.data.mappers

import dev.mlds.wallettest.data.models.Cards
import dev.mlds.wallettest.domain.models.CardModel
import dev.mlds.wallettest.domain.models.CardsModel

fun Cards.toCardsModel(): CardsModel {
    return CardsModel(
        cards.map {
            CardModel(
                id = it.id,
                number = it.number,
                cvv = it.cvv,
                name = it.name
            )
        }
    )
}