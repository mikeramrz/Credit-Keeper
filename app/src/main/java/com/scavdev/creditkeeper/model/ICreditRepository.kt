package com.scavdev.creditkeeper.model

import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal

interface ICreditRepository {

    val creditItemsFlow: Flow<List<CreditItem>>

    suspend fun getCreditItemById(creditItemId: Int): Flow<CreditItem>

    suspend fun updateCreditItem(creditItem: CreditItem)

    suspend fun deleteCreditItem(creditItemId: Int)

    suspend fun addCreditItem(creditItem: CreditItem)

   // suspend fun updateCreditItemBalance(creditItemId: Int, newBalance: BigDecimal, newUtilization: BigDecimal)
}