package com.example.ca_contest

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import com.example.ca_contest.api.Country
import java.text.SimpleDateFormat
import java.util.*

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val name=intent.getStringExtra("name")
        val capital=intent.getStringExtra("capital")
        val region=intent.getStringExtra("region")

        val datePicker = findViewById<DatePicker>(R.id.date)

        val today = Calendar.getInstance()
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month = month + 1
        }

        fun addDate(view: View) {
//            val listCountry: List<Country> = AppDatabaseHelper
//                .getDatabase(this)
//                .countryDAO()
//                .insert()
        }

    }
}