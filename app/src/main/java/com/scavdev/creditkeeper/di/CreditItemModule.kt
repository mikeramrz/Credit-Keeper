package com.scavdev.creditkeeper.di

import com.scavdev.creditkeeper.ui.addItem.AddCreditItemFragment
import com.scavdev.creditkeeper.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class CreditItemModule {
    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment
    @ContributesAndroidInjector
    abstract fun contributesAddCreditItemFragment(): AddCreditItemFragment
}