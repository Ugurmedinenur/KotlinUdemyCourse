package com.example.usingpicassolib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        button_goster.setOnClickListener {
            val url = "http://kasimadalan.pe.hu/filmler/resimler/django.png"
            Picasso.get()
                    .load(url)
                    .resize(400,600)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error_image)
                    .into(imageView)
        }
    }
}