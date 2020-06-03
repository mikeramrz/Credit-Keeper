package com.scavdev.creditkeeper

import androidx.lifecycle.*
import com.scavdev.creditkeeper.model.CreditItem
import com.scavdev.creditkeeper.model.ICreditRepository
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class AddCreditItemViewModel @Inject constructor(private val creditRepository: ICreditRepository) :
    ViewModel() {

    val creditNameLiveData = MutableLiveData<String>()
    val outStandingBalanceLiveData = MutableLiveData<String>()
    val creditLimitLiveData = MutableLiveData<String>()
    val minMonthlyLiveData = MutableLiveData<String>()
    val interestRateLiveData = MutableLiveData<String>()
    val dueDateLiveData = MutableLiveData<String>()

    fun addCreditIem() {
        viewModelScope.launch {
            addCredItemToCreditRepository()
        }
    }

    private suspend fun addCredItemToCreditRepository() {
        val creditItem = CreditItem(
            0,
            creditNameLiveData.value.toString(),
            BigDecimal(outStandingBalanceLiveData.value.toString()),
            BigDecimal(creditLimitLiveData.value.toString()),
            interestRateLiveData.value.toString().toDouble(),
            minimumDueMonthly = BigDecimal(minMonthlyLiveData.value.toString()),
            dateDue = getDueDateFromDayOfMonth(dueDateLiveData.value.toString().toInt()),
            utilization = calculateUtilization(),
            desiredUtilization = 0.0,
            payToDesiredUtilization = 0.0,
            totalAtDesiredUtilization = 0.0
        )

        creditRepository.addCreditItem(
            creditItem
        )
    }

    private fun calculateUtilization(): Double {
        val outstanding =  outStandingBalanceLiveData.value.toString().toBigDecimal().toDouble()
        val limit = creditLimitLiveData.value.toString().toBigDecimal().toDouble()
        val util = outstanding.div(limit)
        return util * 100

    }

    private fun getDueDateFromDayOfMonth(dayOfMonth: Int): Date {
        val cal: Calendar = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        return Date(cal.time.time)
    }
}
