package com.scavdev.creditkeeper.di

import com.scavdev.creditkeeper.model.CreditRepository
import com.scavdev.creditkeeper.model.ICreditRepository
import dagger.Binds
import dagger.Module

@Module
abstract class CreditItemRepositoryModule {
    @Binds
    abstract fun providesCreditItemRepository(creditRepository: CreditRepository): ICreditRepository
}