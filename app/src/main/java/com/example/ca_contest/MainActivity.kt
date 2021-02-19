package com.example.ca_contest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn = findViewById<Button>(R.id.btnStartAnotherActivity)
        btn.setOnClickListener {
            val intent = Intent(this, CountrySelectorActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}