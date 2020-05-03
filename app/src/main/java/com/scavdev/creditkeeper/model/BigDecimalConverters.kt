package com.scavdev.creditkeeper.model

import androidx.room.TypeConverter
import java.math.BigDecimal

class BigDecimalConverters {
    @TypeConverter
    fun fromLong(value: Long): BigDecimal {
        return value.let {
            BigDecimal(value).divide(BigDecimal(100))
        }
    }

    @TypeConverter
    fun toLong(bigDecimal: BigDecimal): Long {
        return bigDecimal.let { bigDecimal.multiply(BigDecimal(100)).toLong() }
    }
}