package com.scavdev.creditkeeper.model

import java.math.BigDecimal

interface ICreditItemUpdateUtility {

    suspend fun getDecreasedBalanceItem(creditItem: CreditItem, amountChanged: BigDecimal) : CreditItem

    suspend fun getIncreasedBalanceItem(creditItem: CreditItem, amountChanged: BigDecimal) : CreditItem

    suspend fun updateLimit(creditItem: CreditItem) : CreditItem

}