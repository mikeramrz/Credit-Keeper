package com.scavdev.creditkeeper.ui.home

import androidx.lifecycle.*
import com.scavdev.creditkeeper.model.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewModel @Inject constructor(private val creditRepository: ICreditRepository) :
    ViewModel() {

    val creditItems: LiveData<List<CreditItem>> = creditRepository.creditItemsFlow.asLiveData()

    private val _informSnackbarLiveData = MutableLiveData<CreditItemEvent<InformSnackBarState>>()
    val informSnackBarStateLiveData: LiveData<CreditItemEvent<InformSnackBarState>>
        get() = _informSnackbarLiveData

    fun removeItem(creditItemId: Int, creditName: String){
        GlobalScope.launch {
            removeCreditItem(creditItemId, creditName)
        }
    }

    private suspend fun removeCreditItem(creditItemId: Int, creditName: String) {
        creditRepository.deleteCreditItem(creditItemId)
        dispatchItemRemoved(creditName)
    }

    private fun dispatchItemRemoved(creditName: String) {
        _informSnackbarLiveData.postValue(CreditItemEvent(InformSnackBarState.ItemRemoved(creditName)))
    }
}