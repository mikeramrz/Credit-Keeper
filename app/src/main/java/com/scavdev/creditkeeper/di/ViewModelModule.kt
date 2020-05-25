package com.scavdev.creditkeeper.di

import androidx.lifecycle.ViewModel
import com.scavdev.creditkeeper.AddCreditItemFragment
import com.scavdev.creditkeeper.AddCreditItemViewModel
import com.scavdev.creditkeeper.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddCreditItemViewModel::class)
    abstract fun bindsAddCreditItemViewModel(viewModel: AddCreditItemViewModel) : ViewModel
}