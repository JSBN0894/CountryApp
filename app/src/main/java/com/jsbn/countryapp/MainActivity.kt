package com.jsbn.countryapp
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.jsbn.countryapp.adapter.ItemAdapter
import com.jsbn.countryapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Run MainActivity
        init()
    }

    private fun init(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val call = CountryApi.retrofitService.getCountry()
                val countriesInfo = call.body()
                runOnUiThread{
                    if (countriesInfo != null) {
                        val recyclerView = binding.recyclerView
                        recyclerView.adapter = ItemAdapter(binding.searchView.context,countriesInfo)
                        binding.searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
                            override fun onQueryTextSubmit(p0: String?): Boolean {
                                return false
                            }

                            override fun onQueryTextChange(p0: String?): Boolean {
                                recyclerView.adapter =
                                    p0?.let { filterCountriesByName(it,countriesInfo) }?.let {
                                        ItemAdapter(binding.searchView.context,
                                            it
                                        )
                                    }
                                return true
                            }

                        })

                    }
                }
            }catch (e : Exception){
                //pass
            }
        }
    }

    fun filterCountriesByName(query:String,list:List<CountriesItem>): List<CountriesItem> {
        return list.filter{ it.name.official?.lowercase()?.contains(query.lowercase()) ?: false}
    }

}



