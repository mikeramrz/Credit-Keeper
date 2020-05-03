package com.scavdev.creditkeeper.di

import android.app.Application
import android.content.Context
import com.scavdev.creditkeeper.model.CreditItemDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CreditItemDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context) = CreditItemDatabase.getInstance(context)

    @Provides
    fun provideCreditItemDao(database: CreditItemDatabase) = database.getCreditDoa()
}