package com.currencyconverter.utilities

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class Utility {
    companion object {
        val BASE_URL = "https://restcountries.eu/"
        val CURRENCY_BASE_URL = "https://api.exchangeratesapi.io/"

        fun isNetworkAvailable(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var activeNetworkInfo: NetworkInfo? = null
            activeNetworkInfo = cm.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
        }
    }
}