package com.example.ca_contest

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ca_contest.adapters.HomepageCountryAdapter
import com.example.ca_contest.dao.AppDatabaseHelper
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        val recycler = findViewById<RecyclerView>(R.id.list_country)
        recycler.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager

        // Fetch Items in Database
        val adapter = HomepageCountryAdapter(
            AppDatabaseHelper
                .getDatabase(this)
                .countryDAO()
                .getListCountry()
        )
        recycler.adapter = adapter
    }

    fun addCountry(view: View) {
        val intent = Intent(this, CountrySelectorActivity::class.java)
        startActivity(intent)
    }

}
