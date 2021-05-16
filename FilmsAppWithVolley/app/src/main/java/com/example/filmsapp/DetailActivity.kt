package com.example.filmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
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
        val url = "http://kasimadalan.pe.hu/filmler/resimler/${film.film_image}"
        Picasso.get().load(url).into(imageView)
    }
}