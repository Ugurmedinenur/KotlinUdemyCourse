package com.example.dictionaryappwithvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val word = intent.getSerializableExtra("nesne") as Words
        textViewEnglishDetail.text = word.english
        textViewTurkishDetail.text = word.turkish
    }
}