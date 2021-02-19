package com.example.ca_contest

import android.annotation.SuppressLint
import android.content.ContextWrapper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ca_contest.dao.AppDatabaseHelper
import com.squareup.picasso.Picasso;
import kotlinx.android.synthetic.main.activity_list_country.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ListCountryActivity : AppCompatActivity() {
    private lateinit var countryAdapter: CountryAdapter
//    private lateinit var imageView: ImageView
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_country)

//        imageView = findViewById(R.id.image)
        // à ajouter pour de meilleures performances :
        list_country.setHasFixedSize(true)

        // layout manager, décrivant comment les items sont disposés :
        val layoutManager = LinearLayoutManager(this)
        list_country.layoutManager = layoutManager
        // contenu d'exemple :
        val listCountry: List<Country> = AppDatabaseHelper
            .getDatabase(this)
            .countryDAO()
            .getListCountry()

//        Picasso.get()
//            .load("http://www.geognos.com/api/en/countries/flag/FR.png")
//            .fit()
//            .centerCrop() // ou centerInside()
//            .into(imageView)

    }

    fun addCountry(view: View) {
//        val intent = Intent(this, CountrySelectorActivity::class.java)
//        startActivity(intent)
//
//        finish()
    }

    fun deleteCountry(view: View) {

    }

}
