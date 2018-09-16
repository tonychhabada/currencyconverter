package com.currencyconverter.di

import com.currencyconverter.viewmodel.CountryViewModel
import com.currencyconverter.viewmodel.CurrencyConverterViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = arrayOf(
                ApiModule::class,
                CountriesRepositoryModule::class
        )
)
interface CurrencyAppComponent {

    fun inject(countryViewModel: CountryViewModel)


}