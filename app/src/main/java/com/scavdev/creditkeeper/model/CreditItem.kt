package com.scavdev.creditkeeper.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.math.BigDecimal
import java.util.*

@Entity(tableName = "credit_items")
data class CreditItem(
    @PrimaryKey(autoGenerate = true) val id: Int,
     val creditName: String,
     val outstandingBalance: BigDecimal,
     val creditLimit: BigDecimal,
     val interestRate: Double,
     val minimumDueMonthly: BigDecimal,
     val dateDue: Date,
     val utilization: Double,
     val desiredUtilization: Double,
     val payToDesiredUtilization: Double,
     val totalAtDesiredUtilization: Double
)
