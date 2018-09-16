package com.currencyconverter.di

import com.currencyconverter.utilities.Utility


class ComponentInjector {

    companion object {


        lateinit var component: CurrencyAppComponent
        lateinit var currencyCmponent: CurrencyObjectComponent
        fun init() {
            component = DaggerCurrencyAppComponent.builder()
                    .apiModule(ApiModule(Utility.BASE_URL))
                    .countriesRepositoryModule(CountriesRepositoryModule())
                    .build()

            currencyCmponent = DaggerCurrencyObjectComponent.builder()
                    .apiModule(ApiModule(Utility.CURRENCY_BASE_URL))
                    .currenciesRepositoryModule(CurrenciesRepositoryModule())
                    .build()
        }
    }
}