package com.scavdev.creditkeeper.di

import androidx.lifecycle.ViewModel
import com.scavdev.creditkeeper.ui.addItem.AddCreditItemViewModel
import com.scavdev.creditkeeper.ui.addItem.DeleteItemConfirmationBottomSheetDialog
import com.scavdev.creditkeeper.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Singleton

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

    @ContributesAndroidInjector
    abstract fun DeleteItemConfirmationBottomSheetDialog(): DeleteItemConfirmationBottomSheetDialog

}