package com.example.ca_contest

import com.example.ca_contest.adapters.CountryAdapter
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ca_contest.api.ApiClient
import com.example.ca_contest.api.Country
import kotlinx.android.synthetic.main.activity_country_selector.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class CountrySelectorActivity : AppCompatActivity() {

    companion object {
        const val PROGRESS_BAR_TITLE = "Récupération des pays..."
    }

    private var data: ArrayList<Country> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_country_selector)

        // Progress Bar
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle(PROGRESS_BAR_TITLE)
        progressDialog.setCancelable(false)
        progressDialog.show()

        // Initialize Recycler
        val recycler = findViewById<RecyclerView>(R.id.list)
        recycler.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager

        val adapter = CountryAdapter(data)
        recycler.adapter = adapter

        // Fetch Countries
        ApiClient.getClient.getCountries().enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>?, response: Response<List<Country>>?) {
                progressDialog.dismiss()
                data.addAll(response!!.body()!!)
                adapter.update(data.clone() as ArrayList<Country>)
                recycler.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Country>>?, t: Throwable?) {
                progressDialog.dismiss()
            }
        })


        // Input Text and Button
        val textView = findViewById<TextView>(R.id.text)
        var btn = findViewById<Button>(R.id.validate)
        btn.setOnClickListener {
            adapter.update((data.filter { country -> country.name.contains(textView.text, true) } as ArrayList<Country>))
            recycler.adapter?.notifyDataSetChanged()
        }
    }
}