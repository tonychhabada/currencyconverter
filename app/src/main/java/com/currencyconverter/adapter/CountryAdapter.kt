package com.currencyconverter.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmadrosid.svgloader.SvgLoader
import com.currencyconverter.R
import com.currencyconverter.ui.CurrencyConverterActivity
import com.currencyconverter.viewmodel.CountryViewModel

import kotlinx.android.synthetic.main.country_list_item.view.*

class CountryAdapter(var context: Activity, var countryViewModel: CountryViewModel) : RecyclerView.Adapter<CountriesViewHolder>() {

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        countryViewModel.getCountriesAt(position)?.let {
            holder.apply {
                title.text = it.name + "(+" + it.callingCodes.get(0)+")"
                SvgLoader.pluck()
                        .with(context)
                        .load(it.flag, list_image);

                var t =  it.currencies.get(0).code
                Log.d("",""+it.currencies.size);
                topleveldomain.text = it.topLevelDomain.get(0)
                txtCapital.text = it.capital
                txtPopulation.text = it.population.toString()
                txtCode.text = it.currencies.get(0).code
                txtCurrencyName.text = it.currencies.get(0).name
                txtCurrencySymbol.text = it.currencies.get(0).symbol
                itemView.setOnClickListener { view ->
                    context.startActivity(Intent(context,CurrencyConverterActivity::class.java).putExtra("basecurrency",it.currencies.get(0).code))
                }
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.country_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return countryViewModel.getCountriesSize()
    }
}