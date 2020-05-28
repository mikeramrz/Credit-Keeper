package com.scavdev.creditkeeper

import androidx.lifecycle.*
import com.scavdev.creditkeeper.model.ICreditRepository
import java.math.BigDecimal
import javax.inject.Inject

class AddCreditItemViewModel @Inject constructor(private val creditRepository: ICreditRepository) :
    ViewModel() {

    val creditName = MutableLiveData<String>()
    val outStandingBalance = MutableLiveData<String>()
    val creditLimit = MutableLiveData<String>()
    val minMonthly = MutableLiveData<String>()
    val interestRate = MutableLiveData<String>()
    val utilization = MutableLiveData<String>()



}
