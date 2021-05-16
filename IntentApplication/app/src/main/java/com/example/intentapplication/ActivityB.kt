package com.example.intentapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        button_go_to_c.setOnClickListener {

            val newIntent = Intent(this@ActivityB , ActivityC::class.java)
            startActivity(newIntent)

        }
    }

    override fun onBackPressed() {

        val newIntent = Intent(Intent.ACTION_MAIN)
        newIntent.addCategory(Intent.CATEGORY_HOME)
        newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        
        startActivity(newIntent)
    }
}