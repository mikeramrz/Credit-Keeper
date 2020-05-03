package com.scavdev.creditkeeper.ui.home

import androidx.lifecycle.*
import com.scavdev.creditkeeper.model.CreditItem
import com.scavdev.creditkeeper.model.CreditRepository
import com.scavdev.creditkeeper.model.ICreditRepository
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val creditRepository: ICreditRepository) :
    ViewModel() {

    val creditItems: LiveData<List<CreditItem>> = creditRepository.creditItemsFlow.asLiveData()

    fun add(){
        viewModelScope.launch {
            creditRepository.addCreditItem(CreditItem(0, "AMEX", BigDecimal(1433.54),
                BigDecimal(2000), 12.5, BigDecimal(75), Calendar.getInstance().time, 44.5, 32.5, 123.4,
            37.5))
        }
    }

    fun add2(){
        viewModelScope.launch {
            creditRepository.addCreditItem(CreditItem(0, "AA", BigDecimal(1433.54),
                BigDecimal(4000), 12.5, BigDecimal(75), Calendar.getInstance().time, 44.5, 32.5, 123.4,
                37.5))
        }
    }

}