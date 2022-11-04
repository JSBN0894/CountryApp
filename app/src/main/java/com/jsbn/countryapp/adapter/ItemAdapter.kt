
package com.jsbn.countryapp.adapter
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jsbn.countryapp.CountriesItem
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
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refresh(){
        notifyDataSetChanged()
    }

    override fun getItemCount() = dataset.size

}
