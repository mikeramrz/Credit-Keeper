package com.scavdev.creditkeeper.ui.home

import androidx.lifecycle.*
import com.scavdev.creditkeeper.model.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewModel @Inject constructor(private val creditRepository: ICreditRepository) :
    ViewModel() {

    @Inject
    lateinit var updateUtility: ICreditItemUpdateUtility

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

    fun updateMinimumPaymentMade(creditItemId: Int){
        val creditItem: CreditItem = creditItems.value?.single { it.id == creditItemId }!!
        updateOutStandingBalance(creditItemId,creditItem.minimumDueMonthly )
    }

    private fun updateOutStandingBalance(creditItemId: Int, balanceChange: BigDecimal){

        GlobalScope.launch {
            val creditItem: CreditItem = creditItems.value?.single { it.id == creditItemId }!!
            val newCreditItem =  updateUtility.getDecreasedBalanceItem(creditItem, balanceChange)

            updateOutstandingCreditItemBalance(newCreditItem)
        }
    }

    private suspend fun updateOutstandingCreditItemBalance(newCreditItem:CreditItem){
        creditRepository.updateCreditItem(creditItem = newCreditItem)
    }

}