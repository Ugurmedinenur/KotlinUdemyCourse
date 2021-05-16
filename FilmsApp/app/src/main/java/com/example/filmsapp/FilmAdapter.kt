package com.example.filmsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FilmAdapter(private val context: Context,private val filmList: List<Films>) :RecyclerView.Adapter<FilmAdapter.CardDesignHandler>(){

    inner class CardDesignHandler(design : View) : RecyclerView.ViewHolder(design) {

        var film_card: CardView
        var imageViewFilm: ImageView
        var textViewFilmName: TextView

        init {
            film_card = design.findViewById(R.id.film_card)
            textViewFilmName = design.findViewById(R.id.textViewFilmName)
            imageViewFilm = design.findViewById(R.id.imageViewFilm)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHandler {
        val design = LayoutInflater.from(context).inflate(R.layout.film_card_design,parent,false)
        return CardDesignHandler(design)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: CardDesignHandler, position: Int) {
        val film = filmList.get(position)
        holder.textViewFilmName.text = film.film_name
        holder.imageViewFilm.setImageResource(context.resources.getIdentifier(film.film_image,"drawable", context.packageName))

        holder.film_card.setOnClickListener {
            var intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("film",film)
            context.startActivity(intent)
        }
    }
}