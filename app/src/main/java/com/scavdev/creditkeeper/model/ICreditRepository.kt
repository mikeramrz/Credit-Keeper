package com.scavdev.creditkeeper.model

import kotlinx.coroutines.flow.Flow

interface ICreditRepository {

    val creditItemsFlow: Flow<List<CreditItem>>

    fun getCreditItemById(creditItemId: Int): Flow<CreditItem>

    fun updateCreditItem(creditItem: CreditItem)

    fun deleteCreditItem(creditItem: CreditItem)

    suspend fun addCreditItem(creditItem: CreditItem)
}