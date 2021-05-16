package com.example.cratenemscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() { // onCreate sayfa açılması için çalışır

    private lateinit var myTextView: TextView //klasik yöntem
    private lateinit var myButton: Button

    override fun onCreate(savedInstanceState: Bundle?) { // Bundle sayfalar arası veri gönderme için kullanılan bir sınıf
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // tasarım bağlandı

        myTextView = findViewById(R.id.myTextView)
        myButton = findViewById(R.id.myButton)

        myButton.setOnClickListener {
            myTextView.text = "Hello!"
        }

    }
}