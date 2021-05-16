package com.example.imageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_resim1.setOnClickListener {

            imageView.setImageResource(R.drawable.resim1)

        }
        button_resim2.setOnClickListener {

            imageView.setImageResource(resources.getIdentifier("rainy","drawable",packageName))

        }
    }
}