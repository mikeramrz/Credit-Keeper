package com.scavdev.creditkeeper.model

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CreditItemDao {

    @Query("SELECT * from credit_items ORDER BY id ASC")
    fun getAllCreditItemFlow(): Flow<List<CreditItem>>

    @Query("SELECT * FROM credit_items WHERE id = :creditItemId")
    fun getCreditItem(creditItemId: String): Flow<CreditItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(creditItem: CreditItem)

    @Query("DELETE FROM credit_items")
    fun deleteAll()

    @Delete
    fun delete(creditItem: CreditItem)

    @Update
    fun update(creditItem: CreditItem)

}