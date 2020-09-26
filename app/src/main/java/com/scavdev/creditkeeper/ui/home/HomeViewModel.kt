package com.scavdev.creditkeeper.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.scavdev.creditkeeper.model.CreditItem
import com.scavdev.creditkeeper.model.CreditRepository
import com.scavdev.creditkeeper.model.ICreditRepository
import com.scavdev.creditkeeper.model.InformSnackBarState
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

class HomeViewModel @Inject constructor(private val creditRepository: ICreditRepository) :
    ViewModel() {

    val creditItems: LiveData<List<CreditItem>> = creditRepository.creditItemsFlow.asLiveData()


    fun removeItem(creditItemId: Int) {
        viewModelScope.launch {
            removeCreditItem(creditItemId)
        }
    }

    private suspend fun removeCreditItem(creditItemId: Int) {
       creditRepository.deleteCreditItem(creditItemId)
    }

    fun add() {
        viewModelScope.launch {
            creditRepository.addCreditItem(
                CreditItem(
                    0,
                    "AMEX",
                    BigDecimal(1433.54),
                    BigDecimal(2000),
                    12.5,
                    BigDecimal(75),
                    Calendar.getInstance().time,
                    44.5,
                    32.5,
                    123.4,
                    37.5
                )
            )
        }
    }
}