package com.currencyconverter.model

import com.google.gson.annotations.SerializedName

data class Country(@SerializedName("name") var name:String,@SerializedName("callingCodes") var callingCodes:List<String>,@SerializedName("topLevelDomain") var topLevelDomain:List<String>,@SerializedName("capital") var capital:String, @SerializedName("flag") var flag:String, @SerializedName("population") var population:Long, @SerializedName("currencies") var currencies:List<Currencies> )


public class Currencies {
    val code: String? = null
    val name: String? = null
    val symbol: String? = null

}