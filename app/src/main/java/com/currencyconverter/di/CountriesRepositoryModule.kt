package com.currencyconverter.di

import com.currencyconverter.remote.CountryAPI
import com.currencyconverter.remote.CurrencyConverterAPI

import com.currencyconverter.repositary.CountryRepositoryImpl
import com.currencyconverter.repositary.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class CountriesRepositoryModule {

    @Provides
    @Singleton

    fun provideRepository(apiService: CountryAPI): Repository = CountryRepositoryImpl(apiService)

}