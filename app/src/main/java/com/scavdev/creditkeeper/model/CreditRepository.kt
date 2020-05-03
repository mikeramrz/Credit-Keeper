package com.scavdev.creditkeeper.model

import androidx.annotation.MainThread
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreditRepository @Inject constructor(
    private val creditItemDao: CreditItemDao
) :ICreditRepository{

    override val creditItemsFlow: Flow<List<CreditItem>>
        get() = creditItemDao.getAllCreditItemFlow()

    override fun getCreditItemById(creditItemId: Int): Flow<CreditItem> =
        creditItemDao.getCreditItem(creditItemId.toString())

    override fun updateCreditItem(creditItem: CreditItem) {
        creditItemDao.update(creditItem)
    }

   override fun deleteCreditItem(creditItem: CreditItem){
        creditItemDao.delete(creditItem)
    }

    override suspend fun addCreditItem(creditItem: CreditItem) {
        creditItemDao.insert(creditItem)
    }
}