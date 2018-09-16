package com.currencyconverter.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.currencyconverter.R
import com.currencyconverter.adapter.CountryAdapter
import com.currencyconverter.adapter.CurrencyAdapter
import com.currencyconverter.di.ComponentInjector
import com.currencyconverter.model.Country
import com.currencyconverter.model.Currency
import com.currencyconverter.utilities.Utility
import com.currencyconverter.viewmodel.CountryViewModel
import com.currencyconverter.viewmodel.CurrencyConverterViewModel
import kotlinx.android.synthetic.main.activity_currency_converter.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class CurrencyConverterActivity : AppCompatActivity() {
    private lateinit var viewModel: CurrencyConverterViewModel;
    private lateinit var adapter: CurrencyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_converter)
        val basecurrency=intent.getStringExtra("basecurrency")
        txtBase.text = basecurrency
        viewModel = createViewModel()
        adapter = CurrencyAdapter(this,viewModel)
        rvCurrencies.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CurrencyConverterActivity)
            adapter = this@CurrencyConverterActivity.adapter
        }
        if(Utility.isNetworkAvailable(this@CurrencyConverterActivity)) {
            viewModel.getCurrencies(basecurrency)
        }else{

            Toast.makeText(this@CurrencyConverterActivity,"No Internet connection",Toast.LENGTH_LONG).show()
        }
        attachObserver()

    }
    private fun attachObserver() {

        viewModel.countriesResponse.observe(this, Observer<Currency> {
            it?.let {
//
                adapter.notifyDataSetChanged()
            }
        })

    }
    private fun createViewModel(): CurrencyConverterViewModel =
            ViewModelProviders.of(this).get(CurrencyConverterViewModel::class.java).also {
                ComponentInjector.currencyCmponent.inject(it)
            }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.sort_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.action_ascending -> {
                viewModel.mKeys.sort();
                adapter.notifyDataSetChanged()
                return true
            }
            R.id.action_descending -> {
                viewModel.mKeys.reverse()
                adapter.notifyDataSetChanged()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
