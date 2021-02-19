package com.example.ca_contest

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import com.example.ca_contest.dao.AppDatabaseHelper
import com.example.ca_contest.dao.Country
import java.text.SimpleDateFormat
import java.util.*

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val name=intent.getStringExtra("name")
        val capital=intent.getStringExtra("capital")
        val region=intent.getStringExtra("region")
        val code = intent.getStringExtra("code")
        var date = Date(0)

        val datePicker = findViewById<DatePicker>(R.id.date)

        val today = Calendar.getInstance()
        datePicker.init(
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { _, year, month, day ->
            date = Date(year, month, day)
        }

        val validateur = findViewById<Button>(R.id.add_date)
        validateur.setOnClickListener {
            AppDatabaseHelper
                .getDatabase(this)
                .countryDAO()
                .insert(Country(
                    country = name,
                    capitalCity = capital,
                    continent = region,
                    code = code,
                    date = date
                ))
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}