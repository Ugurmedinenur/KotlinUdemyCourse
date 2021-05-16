package com.example.transformdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val arrivingMessage = intent.getStringExtra("message")
        val age = intent.getIntExtra("yas",0)//integr gönderdiğimizde default değer ister
        Log.e("Message",arrivingMessage)
        Log.e("yas",age.toString())

        val arrivingPerson = intent.getSerializableExtra("nesne") as People

        Log.e("Kisi tcNo",(arrivingPerson.tcno).toString())
        Log.e("Kisi isim",(arrivingPerson.name))
        Log.e("Kisi age",(arrivingPerson.age).toString())



    }
}