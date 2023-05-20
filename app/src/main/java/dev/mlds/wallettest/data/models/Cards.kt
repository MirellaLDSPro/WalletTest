package dev.mlds.wallettest.data.models

data class Cards(
    val cards: List<dev.mlds.wallettest.domain.models.CardModel>
) {
    data class Card(
        val cvv: String,
        val id: String,
        val name: String,
        val number: String
    )
}
