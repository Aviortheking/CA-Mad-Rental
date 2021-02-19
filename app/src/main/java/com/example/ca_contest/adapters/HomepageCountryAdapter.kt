package com.example.ca_contest.adapters

import android.content.Context
import com.example.ca_contest.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ca_contest.dao.AppDatabaseHelper
import com.example.ca_contest.dao.Country
import com.squareup.picasso.Picasso
import java.text.DateFormat

// Adapter for the homepage
class HomepageCountryAdapter(list: List<Country>) : RecyclerView.Adapter<HomepageCountryAdapter.CountryViewHolder>() {

    private var list: List<Country> = ArrayList()

    init {
        this.list = list
    }

    // Create the view Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val viewMemo: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return CountryViewHolder(viewMemo)
    }

    // Bind each items
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.name?.text = list[position].country
        holder.capital?.text =  "Capital : " + list[position].capitalCity
        holder.date?.text = DateFormat.getDateInstance(DateFormat.MEDIUM).format(list[position].date)
        holder.region?.text = "Continent : " + list[position].continent
        Picasso.get()
                .load("http://www.geognos.com/api/en/countries/flag/" + list[position].code + ".png")
                .into(holder.image!!)
        holder.button.setOnClickListener {
            AppDatabaseHelper
                .getDatabase(holder.context)
                .countryDAO()
                .delete(list[position].countryId)
            val newList = ArrayList(list)
            newList.removeAt(position)
            list = newList
            this.notifyDataSetChanged()
        }
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
        var date: TextView? = null
        var image: ImageView? = null
        var button: ImageView
        var context: Context

        init {
            name = itemView.findViewById(R.id.country)
            date = itemView.findViewById(R.id.date)
            capital = itemView.findViewById(R.id.capital)
            region = itemView.findViewById(R.id.continent)
            image = itemView.findViewById(R.id.image)
            button = itemView.findViewById(R.id.delete)
            context = itemView.context
        }
    }

}