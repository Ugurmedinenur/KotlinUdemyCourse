package com.example.dictionaryapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(private val context: Context, private val WordList: List<Words>) : RecyclerView.Adapter<WordsAdapter.CardDesignHandler>() {

    inner class CardDesignHandler(design: View) : RecyclerView.ViewHolder(design){

        var cardView : CardView
        var textViewEnglish: TextView
        var textViewTurkish: TextView


        init {
            cardView = design.findViewById(R.id.cardView)
            textViewEnglish = design.findViewById(R.id.textViewEnglish)
            textViewTurkish = design.findViewById(R.id.textViewTurkish)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHandler {
        val design = LayoutInflater.from(context).inflate(R.layout.card_design,parent,false)
        return CardDesignHandler(design)
    }

    override fun onBindViewHolder(holder: CardDesignHandler, position: Int) {

        val word = WordList.get(position)
        holder.textViewEnglish.text = word.english
        holder.textViewTurkish.text = word.turkish

        holder.cardView.setOnClickListener {
            val intent = Intent(context,DetailActivity :: class.java)
            intent.putExtra("nesne",word)
                context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return WordList.size
    }
}