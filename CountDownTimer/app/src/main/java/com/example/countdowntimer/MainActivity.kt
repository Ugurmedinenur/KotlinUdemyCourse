 package com.example.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener {

            val counter = object : CountDownTimer(30000,1000){
                override fun onTick(millisUntilFinished: Long) {

                    textViewOutput.text = "Kalan Süre : ${millisUntilFinished/1000} sn"

                }

                override fun onFinish() {
                    textViewOutput.text = "Bitti"

                }
            }
            counter.start()

        }
    }
}