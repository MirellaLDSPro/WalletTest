package dev.mlds.wallettest.data.repo

import android.content.Context
import dev.mlds.wallettest.R
import dev.mlds.wallettest.data.api.CardService
import dev.mlds.wallettest.data.models.Card
import dev.mlds.wallettest.data.models.Cards
import dev.mlds.wallettest.data.models.Result
import dev.mlds.wallettest.domain.repositories.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

// Todo: Pode ficar mais genérico

class CardRepositoryImpl(
    private val context: Context,
    private val cardService: CardService
) : CardRepository {
    override suspend fun getCards(): Flow<Result<Cards>> = flow {
        try {
            val response = cardService.getCards()

            if (response.isSuccessful) {
                val cards = response.body()
                if (cards != null) {
                    emit(Result.Success(cards))
                } else {
                    emit(Result.Error(Exception(context.getString(R.string.empty_response))))
                }
            } else {
                val errorBody = response.errorBody()?.string()
                val errorMessage = errorBody ?: response.message()
                emit(Result.Error(Exception(errorMessage)))
            }

        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }

    override suspend fun postCards(card: Card): Flow<Result<Card>> = flow {
        try {
            val response = cardService.postCard(card)
            if (response.isSuccessful) {
                val cards = response.body()
                if (cards != null) {
                    emit(Result.Success(cards))
                } else {
                    emit(Result.Error(Exception(context.getString(R.string.empty_response))))
                }
            } else {
                val errorBody = response.errorBody()?.string()
                val errorMessage = errorBody ?: response.message()
                emit(Result.Error(Exception(errorMessage)))
            }
        } catch (e: java.lang.Exception) {
            emit(Result.Error(e))
        }
    }

}