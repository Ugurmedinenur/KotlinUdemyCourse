package com.example.finishfunction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_oyun.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyun)

        buttonResult.setOnClickListener {
            val intent = Intent(this@GameActivity , ResultActivity :: class.java)
            finish()
            startActivity(intent)

        }

    }
}