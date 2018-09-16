package com.currencyconverter

import android.app.Application
import com.currencyconverter.di.ComponentInjector

class CurrencyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ComponentInjector.init()
    }
}