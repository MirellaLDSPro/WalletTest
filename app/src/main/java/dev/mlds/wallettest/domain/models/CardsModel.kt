package dev.mlds.wallettest.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardsModel(
    val cards: List<CardModel>
): Parcelable