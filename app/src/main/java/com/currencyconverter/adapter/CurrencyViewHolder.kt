package com.currencyconverter.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.currencyconverter.R

class CurrencyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val currency by lazy { view.findViewById(R.id.txtCurrency) as TextView }

}
