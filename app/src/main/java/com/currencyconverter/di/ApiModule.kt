package com.currencyconverter.di

import com.currencyconverter.remote.CountryAPI
import com.currencyconverter.remote.CurrencyConverterAPI
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule(val baseUrl: String) {
    @Provides
    @Singleton
    fun provideApiService(): CountryAPI {
        val gson = GsonBuilder().create()

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(CountryAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideCurrencyApiService(): CurrencyConverterAPI {
        val gson = GsonBuilder().create()

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(CurrencyConverterAPI::class.java)
    }
}


