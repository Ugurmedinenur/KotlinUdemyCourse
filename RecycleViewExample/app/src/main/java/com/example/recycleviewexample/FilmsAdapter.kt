package com.example.recycleviewexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FilmsAdapter(private val mContext:Context, private val FilmList: List<Films>) : RecyclerView.Adapter<FilmsAdapter.CardDesignObjects>(){

    inner class CardDesignObjects(view:View) : RecyclerView.ViewHolder(view){

        var imageView_Film : ImageView
        var textView_FilmTitle : TextView
        var textView_FilmPrice : TextView
        var button_sepeteEkle : Button

        init {
            imageView_Film = view.findViewById(R.id.imageView_Film)
            textView_FilmTitle = view.findViewById(R.id.textView_FilmTitle)
            textView_FilmPrice = view.findViewById(R.id.textView_FilmPrice)
            button_sepeteEkle = view.findViewById(R.id.button_sepeteEkle)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignObjects {

        val design = LayoutInflater.from(mContext).inflate(R.layout.card_design, parent, false)

        return  CardDesignObjects(design)
    }

    override fun getItemCount(): Int {
        return FilmList.size
    }

    override fun onBindViewHolder(holder: CardDesignObjects, position: Int) {
        val film = FilmList[position]
        holder.textView_FilmTitle.text = film.film_name
        holder.textView_FilmPrice.text = "${film.film_price} ₺"

        holder.imageView_Film.setImageResource(mContext.resources.getIdentifier(film.film_image_name, "drawable", mContext.packageName))

        holder.button_sepeteEkle.setOnClickListener {
            Toast.makeText(mContext, "${film.film_name} sepete eklendi", Toast.LENGTH_SHORT).show()
        }

    }
}