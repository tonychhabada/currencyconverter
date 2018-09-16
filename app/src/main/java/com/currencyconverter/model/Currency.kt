package com.currencyconverter.model

import com.google.gson.annotations.SerializedName

data class Currency(@SerializedName("base") var base:String, @SerializedName("date") var date:String,@SerializedName("rates")var rates:HashMap<String, String>)