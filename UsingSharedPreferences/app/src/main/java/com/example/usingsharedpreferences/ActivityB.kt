package com.example.usingsharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val sp = getSharedPreferences("PersonalInfo", Context.MODE_PRIVATE)

        val ad = sp.getString("ad","isim yok")
        val yas = sp.getInt("yas",0)
        val boy = sp.getFloat("boy",0.0f)
        val bekarMi = sp.getBoolean("bekarMi",false)

        val liste = sp.getStringSet("arkadasListesi",null)
        if (ad != null) {
            Log.e("Ad",ad)
        }

        Log.e("yas",yas.toString())
        Log.e("boy",boy.toString())
        Log.e("bekarMi",bekarMi.toString())

        if(liste != null){
            for (a in liste){
                Log.e("Arkadaş",a)

            }
        }



    }
}