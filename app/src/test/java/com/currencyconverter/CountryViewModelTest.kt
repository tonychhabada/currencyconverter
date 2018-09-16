package com.currencyconverter

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.currencyconverter.model.Country
import com.currencyconverter.model.Currencies
import com.currencyconverter.model.Currency
import com.currencyconverter.repositary.Repository
import com.currencyconverter.viewmodel.CountryViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryViewModelTest {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var countryViewModel: CountryViewModel

    val mockedCountries = listOf(
            Country("India",listOf("91"),listOf(".in"),"New Delhi","https://restcountries.eu/data/ind.svg",1295210000, listOf(Currencies()))
       )

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        countryViewModel = CountryViewModel().apply {
            repository = object : Repository {
                override fun getCurrencies(successHandler: (Currency) -> Unit, failureHandler: (Throwable?) -> Unit, basecurrency: String) {

                }

                override fun getCountries(successHandler: (List<Country>?) -> Unit, failureHandler: (Throwable?) -> Unit, countryname: String) {
                    successHandler(mockedCountries)
                }


            }

        }
        countryViewModel.countryName = "IN"
    }

    @Test
    fun getCountries() {
        val countriesResponse = MutableLiveData<List<Country>>()
        val observer = Mockito.mock(Observer::class.java)
        countryViewModel.countriesResponse = countriesResponse

        countriesResponse.observeForever(observer as Observer<List<Country>>)

        countryViewModel.getCountries()

        Mockito.verify(observer).onChanged(mockedCountries)
        Mockito.verifyNoMoreInteractions(observer)
    }
}