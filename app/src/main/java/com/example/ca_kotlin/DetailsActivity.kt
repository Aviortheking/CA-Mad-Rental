package com.example.ca_kotlin

import android.content.Intent
import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ca_kotlin.dao.AppDatabaseHelper
import com.example.ca_kotlin.dao.Vehicle

class DetailsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.details)

        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")
        val category = intent.getStringExtra("category")
        val image = intent.getStringExtra("image")
        val id = intent.getStringExtra("id")

        val textView = findViewById<TextView>(R.id.text)
        textView.text = "nom: " + name + "\nPrice: " + price + "\nCategory: " + category

        val button = findViewById<Button>(R.id.favorites)

        button.setOnClickListener {
            val dao = AppDatabaseHelper.getDatabase(this)
                .vehicleDAO()

            try {
                dao.insert(Vehicle(
                    id.toLong(),
                    name, price, category, image
                ))
            } catch (e: SQLiteConstraintException) {
                return@setOnClickListener
            }

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }

}