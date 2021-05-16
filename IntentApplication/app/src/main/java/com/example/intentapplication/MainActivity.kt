package com.example.intentapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_go_to_b.setOnClickListener {

            val newIntent = Intent(this@MainActivity, ActivityB::class.java)

            startActivity(newIntent)

        }
    }
}