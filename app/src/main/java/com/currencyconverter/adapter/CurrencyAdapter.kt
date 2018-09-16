package com.currencyconverter.adapter

import android.app.Activity

import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup

import com.currencyconverter.R

import com.currencyconverter.viewmodel.CurrencyConverterViewModel

class CurrencyAdapter (var context: Activity, var currencyViewModel: CurrencyConverterViewModel) : RecyclerView.Adapter<CurrencyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        return CurrencyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.currency_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return currencyViewModel.mKeys!!.size

    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {

        currencyViewModel.getCurrenciesAt(position)?.let {
            holder.apply {
                currency.text = it
            }
        }
    }
}