package dev.mlds.wallettest.domain.usecases

import dev.mlds.wallettest.domain.models.Resource
import kotlinx.coroutines.flow.Flow


interface SingleUseCase<R, P> {
    suspend fun execute(params: P? = null): Flow<Resource<R>>
}