package com.currencyconverter.repositary

import com.currencyconverter.model.Country
import com.currencyconverter.model.Currency

interface Repository {

    fun getCountries(successHandler: (List<Country>?) -> Unit, failureHandler: (Throwable?) -> Unit,countryname:String)

    fun getCurrencies(successHandler: (Currency) -> Unit, failureHandler: (Throwable?) -> Unit,basecurrency:String)
}