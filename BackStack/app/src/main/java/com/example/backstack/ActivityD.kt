package com.example.backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)
    }

    override fun onBackPressed() {

        val newIntent = Intent(this@ActivityD, ActivityB :: class.java)

        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) //d ye ait back stacki siler b nin back stackini kullanır.

        startActivity(newIntent)

    }
}