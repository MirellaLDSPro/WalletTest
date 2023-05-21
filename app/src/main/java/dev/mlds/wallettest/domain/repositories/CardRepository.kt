package dev.mlds.wallettest.domain.repositories

import dev.mlds.wallettest.data.models.Card
import dev.mlds.wallettest.data.models.Cards
import dev.mlds.wallettest.data.models.Result
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    suspend fun getCards(): Flow<Result<Cards>>
    suspend fun postCards(card: Card): Flow<Result<Card>>
}