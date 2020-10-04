package com.scavdev.creditkeeper.model

import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreditItemUpdateUtility @Inject constructor() : ICreditItemUpdateUtility {

    override suspend fun getDecreasedBalanceItem(
        creditItem: CreditItem,
        amountChanged: BigDecimal
    ): CreditItem {

        val newBalance = creditItem.outstandingBalance.minus(amountChanged).toDouble()
        val newUtilization = newBalance.div(creditItem.creditLimit.toDouble()) * 100

        return CreditItem(
            id = creditItem.id,
            creditName = creditItem.creditName,
            outstandingBalance = newBalance.toBigDecimal(),
            creditLimit = creditItem.creditLimit,
            interestRate = creditItem.interestRate,
            minimumDueMonthly = creditItem.minimumDueMonthly,
            dateDue = creditItem.dateDue,
            utilization = newUtilization,
            desiredUtilization = creditItem.desiredUtilization,
            payToDesiredUtilization = creditItem.payToDesiredUtilization,
            totalAtDesiredUtilization = creditItem.totalAtDesiredUtilization
        )
    }

    override suspend fun getIncreasedBalanceItem(
        creditItem: CreditItem,
        amountChanged: BigDecimal
    ): CreditItem {

        val newBalance = creditItem.outstandingBalance.add(amountChanged).toDouble()
        val newUtilization = newBalance.div(creditItem.creditLimit.toDouble()) * 100

        return CreditItem(
            id = creditItem.id,
            creditName = creditItem.creditName,
            outstandingBalance = creditItem.outstandingBalance,
            creditLimit = creditItem.creditLimit,
            interestRate = creditItem.interestRate,
            minimumDueMonthly = creditItem.minimumDueMonthly,
            dateDue = creditItem.dateDue,
            utilization = newUtilization,
            desiredUtilization = creditItem.desiredUtilization,
            payToDesiredUtilization = creditItem.payToDesiredUtilization,
            totalAtDesiredUtilization = creditItem.totalAtDesiredUtilization
        )    }

    override suspend fun updateLimit(creditItem: CreditItem): CreditItem {
        TODO("Not yet implemented")
    }

}

