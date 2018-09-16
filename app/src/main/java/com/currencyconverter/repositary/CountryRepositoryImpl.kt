package com.currencyconverter.repositary

import com.currencyconverter.model.Country
import com.currencyconverter.model.CountryList
import com.currencyconverter.model.Currency
import com.currencyconverter.model.CurrencyList
import com.currencyconverter.remote.CountryAPI
import com.currencyconverter.remote.CurrencyConverterAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryRepositoryImpl : Repository {
    var apiService: CountryAPI? = null
    var currencyAPIService: CurrencyConverterAPI? = null
    constructor(apiService: CountryAPI){
        this.apiService = apiService
    }

    constructor(currencyAPIService: CurrencyConverterAPI){
        this.currencyAPIService = currencyAPIService
    }

    override fun getCurrencies(successHandler: (Currency) -> Unit, failureHandler: (Throwable?) -> Unit, basecurrency: String) {
        currencyAPIService!!.getCurrencies(basecurrency).enqueue(object : Callback<Currency> {
            override fun onResponse(call: Call<Currency>?, response: Response<Currency>?) {

                 var test:String = response?.body().toString()
                response?.body()?.let {
                    successHandler(it)
                }
            }

            override fun onFailure(call: Call<Currency>?, t: Throwable?) {
                failureHandler(t)
            }


        })
    }

    override fun getCountries(successHandler: (List<Country>?) -> Unit, failureHandler: (Throwable?) -> Unit,countryname:String) {
        apiService!!.getCountries(countryname).enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>?, response: Response<List<Country>>?) {

                response?.body()?.let {
                    successHandler(it)
                }
            }

            override fun onFailure(call: Call<List<Country>>?, t: Throwable?) {
                failureHandler(t)

            }


        })
    }
}