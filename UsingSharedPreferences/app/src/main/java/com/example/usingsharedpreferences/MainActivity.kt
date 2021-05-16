package com.example.usingsharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val sp = getSharedPreferences("PersonalInfo", Context.MODE_PRIVATE)

        val editor = sp.edit()

        editor.putString("ad","Ahmet")
        editor.putInt("yas",18)
        editor.putFloat("boy", 1.78f)
        editor.putBoolean("bekarMi",true)

        val arkadasListesi = HashSet<String>()
        arkadasListesi.add("Zeynep")
        arkadasListesi.add("Ece")
        arkadasListesi.add("Ali")

        editor.putStringSet("arkadasListesi", arkadasListesi)

        editor.commit()

        buttonGo.setOnClickListener {
            startActivity(Intent(this@MainActivity, ActivityB::class.java))
        }

    }
}