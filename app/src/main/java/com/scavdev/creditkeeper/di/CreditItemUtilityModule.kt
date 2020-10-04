package com.scavdev.creditkeeper.di

import com.scavdev.creditkeeper.model.CreditItemUpdateUtility
import com.scavdev.creditkeeper.model.ICreditItemUpdateUtility
import dagger.Binds
import dagger.Module

@Module
abstract class CreditItemUtilityModule {

    @Binds
    abstract fun bindsCreditItemUpdateUtility(creditItemUpdateUtility: CreditItemUpdateUtility): ICreditItemUpdateUtility

}