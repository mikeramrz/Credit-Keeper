package com.scavdev.creditkeeper

import androidx.lifecycle.*
import com.scavdev.creditkeeper.model.ICreditRepository
import java.math.BigDecimal
import javax.inject.Inject

class AddCreditItemViewModel @Inject constructor(private val creditRepository: ICreditRepository) :
    ViewModel() {

    val creditNameLiveData = MutableLiveData<String>()
    val outStandingBalanceLiveData = MutableLiveData<String>()
    val creditLimitLiveData = MutableLiveData<String>()
    val minMonthlyLiveData = MutableLiveData<String>()
    val interestRateLiveData = MutableLiveData<String>()
    val utilizationLiveData: MediatorLiveData<String> = MediatorLiveData()



}
