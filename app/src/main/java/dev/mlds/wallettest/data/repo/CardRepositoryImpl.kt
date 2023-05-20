package dev.mlds.wallettest.data.repo

import dev.mlds.wallettest.data.models.Cards
import dev.mlds.wallettest.data.models.Result
import dev.mlds.wallettest.domain.repositories.CardRepository
import kotlinx.coroutines.flow.Flow

class CardRepositoryImpl: CardRepository {
    override suspend fun getCards(): Flow<Result<Cards>> {
        TODO("Not yet implemented")
    }
}