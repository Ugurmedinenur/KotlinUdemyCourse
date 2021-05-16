package com.example.progressbarsliderratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_basla.setOnClickListener {

            progressBar.visibility = View.VISIBLE
        }

        button_dur.setOnClickListener {

            progressBar.visibility = View.INVISIBLE
        }

        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textView_sonuc.text = "Sonuç : $p1"
            }
        })

        button_goster.setOnClickListener {

            val gelenIlerleme = slider.progress
            val gelenOylama = ratingBar.rating

            Log.e("İlerleme ",gelenIlerleme.toString())
            Log.e("Oylama",gelenOylama.toString())

        }
    }
}