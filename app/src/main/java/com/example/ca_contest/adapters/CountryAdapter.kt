package com.example.ca_contest.adapters

import com.example.ca_contest.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ca_contest.api.Country
import com.squareup.picasso.Picasso

// Adapter for the CountrySelector
class CountryAdapter(list: ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private var list: ArrayList<Country> = ArrayList()

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
        holder.capital?.text = "Capital : " + list[position].capital
        holder.region?.text = "Continent : " + list[position].region
        Picasso.get()
                .load("http://www.geognos.com/api/en/countries/flag/" + list[position].alpha2Code + ".png")
                .into(holder.image!!)
    }

    // Update the list
    fun update(list: ArrayList<Country>) {
        this.list = list
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView? = null
        var capital: TextView? = null
        var region: TextView? = null
        var image: ImageView? = null

        init {
            name = itemView.findViewById(R.id.name)
            capital = itemView.findViewById(R.id.capital)
            region = itemView.findViewById(R.id.region)
            image = itemView.findViewById(R.id.image)

            itemView.setOnClickListener {
                val context = itemView.context

                // Intent to Calendar
                Toast.makeText(
                    context, name?.text, Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}