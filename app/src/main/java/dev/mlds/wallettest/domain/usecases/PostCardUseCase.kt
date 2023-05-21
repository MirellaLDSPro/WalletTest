package dev.mlds.wallettest.domain.usecases

import dev.mlds.wallettest.domain.models.CardModel
import dev.mlds.wallettest.domain.models.Resource
import kotlinx.coroutines.flow.Flow

class PostCardUseCase: SingleUseCase<CardModel> {
    override suspend fun execute(): Flow<Resource<CardModel>> {
        TODO("Not yet implemented")
    }
}