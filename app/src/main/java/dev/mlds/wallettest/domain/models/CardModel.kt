package dev.mlds.wallettest.domain.models

data class CardModel(
    var cvv: String,
    var id: String = "",
    var name: String,
    var number: String
)