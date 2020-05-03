package com.scavdev.creditkeeper.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        CreditItemModule::class,
        ViewModelModule::class,
        AppModule::class,
        AppModule::class,
        CreditItemRepositoryModule::class,
        CreditItemDatabaseModule::class
    ]
)

interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}

