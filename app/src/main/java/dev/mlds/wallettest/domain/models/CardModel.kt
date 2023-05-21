package dev.mlds.wallettest.domain.models

import androidx.compose.ui.graphics.Color

data class CardModel(
    val cvv: String,
    var id: String = "",
    val name: String,
    val number: String,
    val validade: String = "",
    val color: CardType? = null
) {
    enum class CardType(val title: String, val background: Color, val textColor: Color) {
        BLACK(title = "Black Card", background = Color(0xFF000000), textColor = Color(0xFFFFFFFF)),
        GREEN(title = "Green Card", background = Color(0xFFA5FF32), textColor = Color(0xFF000000));

        companion object {
            fun stringToCardType(value: String?): CardType {
                return CardType.values().find { it.name == value } ?: GREEN
            }
        }
    }
}