package dev.mlds.wallettest.data.mappers

import dev.mlds.wallettest.data.models.Card
import dev.mlds.wallettest.data.models.Cards
import dev.mlds.wallettest.domain.models.CardModel
import dev.mlds.wallettest.domain.models.CardsModel

fun Cards.toCardsModel(): CardsModel {
    return CardsModel(
        this.map {
            CardModel(
                id = it.id,
                number = it.number,
                cvv = it.cvv,
                name = it.name,
                color = CardModel.CardType.stringToCardType(it.cardType)
            )
        }
    )
}

fun Card.toCardModel(): CardModel {
    return CardModel(
        id = this.id,
        number = this.number,
        cvv = this.cvv,
        name = this.name,
        color = CardModel.CardType.stringToCardType(this.cardType)
    )
}