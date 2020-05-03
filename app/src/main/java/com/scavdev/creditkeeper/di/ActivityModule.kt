package com.scavdev.creditkeeper.di

import com.scavdev.creditkeeper.MainActivity
import com.scavdev.creditkeeper.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule{

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

}