package com.example.transformdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val person = People(999999,"ahmet",10)

        button_gonder.setOnClickListener {

            val newIntent = Intent(this@MainActivity , ActivityB::class.java)
            newIntent.putExtra("message","Hello")
            newIntent.putExtra("yas",4)

            newIntent.putExtra("nesne",person)

            startActivity(newIntent)

        }

    }
}