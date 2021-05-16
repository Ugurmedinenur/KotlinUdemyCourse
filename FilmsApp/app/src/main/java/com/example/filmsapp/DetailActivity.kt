package com.example.filmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val film = intent.getSerializableExtra("film") as Films

        textViewFilmNameDetail.text = film.film_name
        textViewYear.text = film.film_year.toString()
        textViewDirector.text = film.director.director_name
        imageView.setImageResource(resources.getIdentifier(film.film_image,"drawable", packageName))
    }
}