
package com.jsbn.countryapp.adapter
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jsbn.countryapp.CountriesItem
import com.jsbn.countryapp.DetailActivity
import com.jsbn.countryapp.R

class ItemAdapter(
    private val context: Context,
    private var dataset: List<CountriesItem>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.textView)
        val capital:TextView = view.findViewById(R.id.textView_capital)
        val flag: ImageView = view.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.name.text = item.name.official
        holder.capital.text = item.capital?.get(0) ?: "Nan"
        Glide.with(context).load(item.flags.png).into(holder.flag)
        holder.itemView.setOnClickListener{
            val intent = Intent(context,DetailActivity::class.java)
            val listData = arrayListOf(
                item.flags.png,
                item.name.official,
                item.capital?.get(0) ?: "Don't have capital",
                item.region,
                item.subregion,
                item.population.toString(),
                item.continents[0]
            )
            intent.putExtra("INTENT_DATA",listData)
            startActivity(context,intent,null)
        }
    }

    override fun getItemCount() = dataset.size

}
