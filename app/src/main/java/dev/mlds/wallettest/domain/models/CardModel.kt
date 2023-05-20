package dev.mlds.wallettest.domain.models

data class CardModel(
    val cvv: String,
    val id: String,
    val name: String,
    val number: String
)