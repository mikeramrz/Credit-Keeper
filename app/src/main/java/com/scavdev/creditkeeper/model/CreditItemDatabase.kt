package com.scavdev.creditkeeper.model

import android.content.Context
import androidx.room.*

@Database(entities = [CreditItem::class], version = 1, exportSchema = false)
@TypeConverters(BigDecimalConverters::class, DateConverter::class)
abstract class CreditItemDatabase : RoomDatabase() {

    abstract fun getCreditDoa(): CreditItemDao

    companion object {
        private const val DB_NAME = "credit_item_database"

        @Volatile
        private var INSTANCE: CreditItemDatabase? = null

        fun getInstance(context: Context): CreditItemDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CreditItemDatabase::class.java,
                    DB_NAME
                ).build()

                INSTANCE = instance
                return instance
            }
        }

    }
}