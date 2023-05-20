package dev.mlds.wallettest.domain.usecases

import dev.mlds.wallettest.domain.models.Resource
import kotlinx.coroutines.flow.Flow


interface SingleUseCase<R> {
    suspend fun execute(): Flow<Resource<R>>
}