package com.currencyconverter.remote

import com.currencyconverter.model.Country
import com.currencyconverter.model.CountryList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryAPI{

    @GET("rest/v2/name/{countryname}?fullText=true")
    fun getCountries(@Path(value = "countryname", encoded = true) countryname:String): Call<List<Country>>
}