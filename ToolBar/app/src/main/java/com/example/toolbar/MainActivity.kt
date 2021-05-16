package com.example.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Özel Toolbar Başlık"
        toolbar.subtitle = "Özel Tolbar Altbaşlık"
        toolbar.setLogo(R.drawable.resim);
        toolbar.setTitleTextColor(resources.getColor(R.color.colorAccent))

        setSupportActionBar(toolbar)
    }
}