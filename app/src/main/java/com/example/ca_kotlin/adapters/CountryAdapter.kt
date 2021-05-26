package com.example.ca_kotlin.adapters

import android.content.Intent
import com.example.ca_kotlin.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ca_kotlin.DetailsActivity
import com.example.ca_kotlin.api.Vehicles
import com.squareup.picasso.Picasso

// Adapter for the CountrySelector
class CountryAdapter(list: ArrayList<Vehicles>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private var list: ArrayList<Vehicles> = ArrayList()

    init {
        this.list = list
    }

    // Create the view Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val viewMemo: View =
            LayoutInflater.from(parent.context).inflate(R.layout.country_selector_item, parent, false)
        return CountryViewHolder(viewMemo)
    }

    // Bind each items
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.name?.text = list[position].name
        holder.price?.text = "Capital : " + list[position].price
        holder.category?.text = "Continent : " + list[position].category
        Picasso.get()
            .load("http://s519716619.onlinehome.fr/exchange/madrental/images/" + list[position].image)
            .into(holder.image!!)
    }

    // Update the list
    fun update(list: ArrayList<Vehicles>) {
        this.list = list
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView? = null
        var price: TextView? = null
        var category: TextView? = null
        var image: ImageView? = null

        init {
            name = itemView.findViewById(R.id.name)
            price = itemView.findViewById(R.id.price)
            category = itemView.findViewById(R.id.category)
            image = itemView.findViewById(R.id.image)

            itemView.setOnClickListener {
                val context = itemView.context

                // Intent to Calendar
                println(list[adapterPosition])
                context.startActivity(Intent(context, DetailsActivity::class.java)
                    .putExtra("name", list[adapterPosition].name)
                    .putExtra("price", list[adapterPosition].price)
                    .putExtra("category", list[adapterPosition].category)
                    .putExtra("image", list[adapterPosition].image)
                    .putExtra("id", list[adapterPosition].vehicleId.toString())
                )
            }
        }
    }

}