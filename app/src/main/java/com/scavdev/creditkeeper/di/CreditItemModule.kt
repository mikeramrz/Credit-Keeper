package com.scavdev.creditkeeper.di

import androidx.lifecycle.ViewModel
import com.scavdev.creditkeeper.AddCreditItemFragment
import com.scavdev.creditkeeper.ui.home.HomeFragment
import com.scavdev.creditkeeper.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap


@Module
abstract class CreditItemModule {
    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment
    @ContributesAndroidInjector
    abstract fun contributesAddCreditItemFragment(): AddCreditItemFragment
}