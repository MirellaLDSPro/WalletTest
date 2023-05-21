package dev.mlds.wallettest.domain.usecases

import dev.mlds.wallettest.data.mappers.toCardsModel
import dev.mlds.wallettest.data.models.Result
import dev.mlds.wallettest.domain.models.CardsModel
import dev.mlds.wallettest.domain.models.Resource
import dev.mlds.wallettest.domain.repositories.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCardsUseCase(private val cardRepository: CardRepository) : SingleUseCase<CardsModel> {
    override suspend fun execute(): Flow<Resource<CardsModel>> {
        return cardRepository.getCards().map { result ->
            when (result) {
                is Result.Success -> Resource.Success(result.data.toCardsModel())
                is Result.Error -> Resource.Error(result.exception)// ToDo: Tratar o erro corretamente aqui
            }
        }
    }
}