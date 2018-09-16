package com.currencyconverter.remote

import com.currencyconverter.model.Country
import com.currencyconverter.model.Currency
import com.currencyconverter.model.CurrencyList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CurrencyConverterAPI {
    @GET("latest")
    fun getCurrencies(@Query("base") basecurrency:String): Call<Currency>
}