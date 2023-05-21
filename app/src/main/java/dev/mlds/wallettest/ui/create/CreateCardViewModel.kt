package dev.mlds.wallettest.ui.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mlds.wallettest.domain.models.CardModel
import dev.mlds.wallettest.domain.models.CardsModel
import dev.mlds.wallettest.domain.models.Resource
import dev.mlds.wallettest.domain.usecases.GetCardsUseCase
import dev.mlds.wallettest.domain.usecases.PostCardUseCase
import kotlinx.coroutines.launch
import java.util.UUID

class CreateCardViewModel(private val useCase: PostCardUseCase) : ViewModel() {

    private var _card: MutableLiveData<Resource<CardModel>> = MutableLiveData()
    val card: LiveData<Resource<CardModel>> = _card

    fun postCard(card: CardModel) {
        card.id = generateUUID()
        viewModelScope.launch {
            _card.postValue(Resource.Loading)
            useCase.execute(card).collect { state ->
                _card.postValue(state)
//                when (state) {
//                    is Resource.Success -> _cards.postValue(state)
//                    is Resource.HttpError -> {}
//                    else -> Unit
//                }
            }
        }
    }

    private fun generateUUID(): String {
        val uuid = UUID.randomUUID()
        return uuid.toString()
    }

}