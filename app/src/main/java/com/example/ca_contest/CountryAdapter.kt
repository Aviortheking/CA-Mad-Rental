package com.example.ca_contest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private var listCountry: MutableList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>()
{
    // Crée chaque vue item à afficher :
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder
    {
        val viewCourse = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return CountryViewHolder(viewCourse)
    }

    // Renseigne le contenu de chaque vue item :
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int)
    {
        holder.textViewLibelleCourse.text = listCountry[position].country
    }

    override fun getItemCount(): Int = listCountry.size
    // ViewHolder :
    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textViewLibelleCourse: TextView = itemView.findViewById(R.id.list_country)
        init
        {
            textViewLibelleCourse.setOnClickListener {
                val country = listCountry[adapterPosition]
            }
        }
    }

}