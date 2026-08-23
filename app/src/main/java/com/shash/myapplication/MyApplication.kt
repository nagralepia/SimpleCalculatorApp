package com.shash.myapplication

import android.app.Application
import com.shash.myapplication.clean_architecture_calculator.dagger_module.AppComponent
import com.shash.myapplication.clean_architecture_calculator.dagger_module.DaggerAppComponent
class MyApplication: Application() {
    lateinit var appComponent : AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }

}