package com.currencyconverter.di

import com.currencyconverter.viewmodel.CountryViewModel
import com.currencyconverter.viewmodel.CurrencyConverterViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = arrayOf(
                ApiModule::class,
                CurrenciesRepositoryModule::class
        )
)
interface CurrencyObjectComponent {

    fun inject(countryViewModel: CurrencyConverterViewModel)
}
