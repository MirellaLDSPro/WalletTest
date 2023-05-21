package dev.mlds.wallettest.ui.cardList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mlds.wallettest.domain.models.CardsModel
import dev.mlds.wallettest.domain.models.Resource
import dev.mlds.wallettest.domain.usecases.GetCardsUseCase
import kotlinx.coroutines.launch

class CardListViewModel(private val repository: GetCardsUseCase) : ViewModel() {

    private var _cards: MutableLiveData<Resource<CardsModel>> = MutableLiveData()
    val cards: LiveData<Resource<CardsModel>> = _cards

    fun getAllCards() {
        viewModelScope.launch {
            _cards.postValue(Resource.Loading)
            repository.execute().collect { state ->
                _cards.postValue(state)
//                when (state) {
//                    is Resource.Success -> _cards.postValue(state)
//                    is Resource.HttpError -> {}
//                    else -> Unit
//                }
            }
        }
    }

}