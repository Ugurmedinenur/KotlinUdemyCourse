package com.example.bayrakquisuygulamas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tCouter = intent.getIntExtra("tCounter", 0)

        textViewResult.text = "$tCouter DOĞRU ${5 - tCouter} YANLIŞ"

        textViewPercentage.text = "% ${(tCouter * 100) / 5} BAŞARI"

        buttonRepeat.setOnClickListener {
            startActivity(Intent(this@ResultActivity,  QuizActivity:: class.java))
            finish()

        }
    }
}