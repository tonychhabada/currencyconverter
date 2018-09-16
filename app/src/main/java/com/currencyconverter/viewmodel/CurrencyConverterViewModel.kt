package com.currencyconverter.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.currencyconverter.model.Country
import com.currencyconverter.model.Currency

import com.currencyconverter.repositary.Repository
import javax.inject.Inject

class CurrencyConverterViewModel: ViewModel() {

    @Inject
    lateinit var repository: Repository

    var isLoading = MutableLiveData<Boolean>()

    var apiError = MutableLiveData<Throwable>()
    val mKeys = ArrayList<String>()

    var countriesResponse = MutableLiveData<Currency>()
//     var mKeys: Array<String>? = Array<String>(0){""}

    fun getCurrencies(basecurrency:String) {
        isLoading.value = true

        repository.getCurrencies(
                {

                    countriesResponse.value = it

                    isLoading.value = false
                    mKeys.addAll(countriesResponse.value?.rates!!.keys);

                },

                {
                    apiError.value = it
                    isLoading.value = false
                },basecurrency)


    }
//    /**
//     * Adapter Callback
//     */
//
    fun getCurrenciesAt(position: Int): String? {

        if (position < getCurrenciesSize()) {
            return mKeys!![position]+" => "+countriesResponse.value?.rates!!.get(mKeys!![position])
        } else {
            return null
        }
    }
//
    fun getCurrenciesSize(): Int {
        countriesResponse.value?.let {
            return it.rates.size
        }
        return 0
    }
}