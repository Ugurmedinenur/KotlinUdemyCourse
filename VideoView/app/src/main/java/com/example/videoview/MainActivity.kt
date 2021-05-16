package com.example.videoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_basla.setOnClickListener {

            val adres = Uri.parse("android.resource://"+packageName+"/"+R.raw.video)

            videoView.setVideoURI(adres)
            videoView.start()

        }
        button_dur.setOnClickListener {

            videoView.stopPlayback()

        }
    }
}