package com.scavdev.creditkeeper.model

import androidx.annotation.MainThread
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreditRepository @Inject constructor(
    private val creditItemDao: CreditItemDao
) :ICreditRepository{

    override val creditItemsFlow: Flow<List<CreditItem>>
        get() = creditItemDao.getAllCreditItemFlow()

    override suspend fun getCreditItemById(creditItemId: Int): Flow<CreditItem> =
        creditItemDao.getCreditItem(creditItemId.toString())

    override suspend fun updateCreditItem(creditItem: CreditItem) {
        creditItemDao.update(creditItem)
    }

    /*override suspend fun updateCreditItemBalance(creditItemId: Int, newBalance: BigDecimal, newUtilization: BigDecimal) {
        creditItemDao.updateOutstandingBalance(creditItemId, newBalance, newUtilization)
    }*/

    override suspend fun deleteCreditItem(creditItemId: Int){
        creditItemDao.delete(creditItemId)
    }

    override suspend fun addCreditItem(creditItem: CreditItem) {
        creditItemDao.insert(creditItem)
    }
}