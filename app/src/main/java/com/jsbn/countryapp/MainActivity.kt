package com.jsbn.countryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData

import com.jsbn.countryapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCountriesInfo()
    }


    private fun getCountriesInfo(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val call = CountryApi.retrofitService.getCountry()
                val countriesInfo = call.body()
                runOnUiThread{
                    binding.textView.text = countriesInfo?.get(0)?.name?.official.toString()
                }
            }catch (e : Exception){
                binding.textView.text = "Error de conexión"

            }

        }
    }

}


