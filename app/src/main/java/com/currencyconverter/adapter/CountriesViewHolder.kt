package com.currencyconverter.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.currencyconverter.R

class CountriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title by lazy { view.findViewById(R.id.title) as TextView }
    val list_image by lazy {view.findViewById(R.id.list_image) as ImageView}
    val topleveldomain by lazy{view.findViewById(R.id.topleveldomain) as TextView}
    val txtPopulation by lazy{view.findViewById(R.id.txtPopulation) as TextView}
    val txtCapital by lazy{view.findViewById(R.id.txtCapital) as TextView}
    val txtCode by lazy{view.findViewById(R.id.txtCode) as TextView}
    val txtCurrencyName by lazy{view.findViewById(R.id.txtCurrencyName) as TextView}
    val txtCurrencySymbol by lazy{view.findViewById(R.id.txtCurrencySymbol) as TextView}
}
