package com.example.sayacuygulamasi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = getSharedPreferences("GirisSayaci", Context.MODE_PRIVATE)

        var sayac = sp.getInt("sayac", 0)

        val editor = sp.edit()
        editor.putInt("sayac",++sayac)
        editor.commit()
        
        textView_sayac.text = "Açılış Sayısı: $sayac"

    }
}