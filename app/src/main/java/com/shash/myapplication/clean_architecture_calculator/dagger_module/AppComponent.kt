package com.shash.myapplication.clean_architecture_calculator.dagger_module

import com.shash.myapplication.clean_architecture_calculator.MainActivityCalculator
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivityCalculator)
}