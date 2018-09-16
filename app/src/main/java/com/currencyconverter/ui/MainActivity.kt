package com.currencyconverter.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.currencyconverter.R
import com.currencyconverter.adapter.CountryAdapter
import com.currencyconverter.databinding.ActivityMainBinding
import com.currencyconverter.di.ComponentInjector
import com.currencyconverter.model.Country
import com.currencyconverter.utilities.Utility
import com.currencyconverter.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding;


    private lateinit var adapter: CountryAdapter
    private lateinit var viewModel: CountryViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        activityMainBinding.setLifecycleOwner(this)

        viewModel = createViewModel()

        activityMainBinding.viewModel = viewModel
        adapter = CountryAdapter(this,viewModel)

        btnSearch.setOnClickListener(View.OnClickListener {
            hide()

            if(Utility.isNetworkAvailable(this@MainActivity)) {
                viewModel.getCountries()
            }else{

                Toast.makeText(this@MainActivity,"No Internet connection",Toast.LENGTH_LONG).show()
            }

        })
        rvCountries.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
        attachObserver()
    }
    private fun attachObserver() {
        viewModel.isLoading.observe(this, Observer<Boolean> {
            it?.let { showLoadingDialog(it) }
        })

        viewModel.apiError.observe(this, Observer<Throwable> {
            it?.let { showLoadingDialog(false) }
        })
        viewModel.countriesResponse.observe(this, Observer<List<Country>> {
            it?.let { adapter.notifyDataSetChanged() }
        })

    }


    private fun createViewModel(): CountryViewModel =
            ViewModelProviders.of(this).get(CountryViewModel::class.java).also {
                ComponentInjector.component.inject(it)
            }

    private fun showLoadingDialog(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
            txtInformation.visibility = View.GONE
        }
        else {

            if(viewModel.countriesResponse.value!!.size >= 1){

                rvCountries.visibility = View.VISIBLE
            }else{

                txtInformation.visibility =View.VISIBLE
                txtInformation.text = "Result not found, Try Again"
            }
            progressBar.visibility = View.GONE

        }
    }

    fun hide(){
        val inputManager:InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.SHOW_FORCED)
    }
}