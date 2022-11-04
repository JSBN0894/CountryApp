package com.jsbn.countryapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.jsbn.countryapp.databinding.ActivityDetailBinding

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        render()

    }

    fun render() {
        val bundle = intent.extras
        var listInfo = arrayListOf<String>()
        listInfo = bundle?.get("INTENT_DATA") as ArrayList<String>
        Glide.with(this).load(listInfo[0]).into(binding.flagVal)
        binding.nameVal.text = listInfo[1]
        binding.capitalVal.text = listInfo[2]
        binding.regionVal.text = listInfo[3]
        binding.subregionVal.text = listInfo[4]
        binding.populationVal.text = listInfo[5]
        binding.continentsVal.text = listInfo[6]



    }
}