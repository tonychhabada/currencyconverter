package com.currencyconverter.di

import com.currencyconverter.remote.CountryAPI
import com.currencyconverter.remote.CurrencyConverterAPI
import com.currencyconverter.repositary.CountryRepositoryImpl
import com.currencyconverter.repositary.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



@Module
class CurrenciesRepositoryModule {



    @Provides
    @Singleton
    fun provideCurrencyRepository(apiService: CurrencyConverterAPI): Repository = CountryRepositoryImpl(apiService)
}