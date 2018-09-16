package com.currencyconverter.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.currencyconverter.model.Country

import com.currencyconverter.repositary.Repository
import javax.inject.Inject

class CountryViewModel: ViewModel() {

    @Inject
    lateinit var repository: Repository
    var countryName :String =""
    var isLoading = MutableLiveData<Boolean>()

    var apiError = MutableLiveData<Throwable>()

    var countriesResponse = MutableLiveData<List<Country>>()


    fun getCountries() {
        isLoading.value = true
        repository.getCountries(
                {

                    countriesResponse.value = it
                    isLoading.value = false
                },

                {
                    apiError.value = it
                    isLoading.value = false
                },countryName.toString())
    }
    /**
     * Adapter Callback
     */

    fun getCountriesAt(position: Int): Country? {
        if (position < getCountriesSize()) {
            return countriesResponse.value?.get(position)
        } else {
            return null
        }
    }

    fun getCountriesSize(): Int {
        countriesResponse.value?.let {
            return it.size
        }
        return 0
    }


}