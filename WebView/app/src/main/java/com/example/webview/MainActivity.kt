package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        webview.settings.javaScriptEnabled = true
        webview.loadUrl("https://gelecegiyazanlar.turkcell.com.tr/") // http leri açabilmesi için manifest dosyasında değişiklik yaptım.
    }
}