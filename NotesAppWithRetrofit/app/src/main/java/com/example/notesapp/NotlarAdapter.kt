package com.example.notesapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NotlarAdapter(private val context: Context, private val notlarListe : List<Notes>) : RecyclerView.Adapter<NotlarAdapter.CardDesignHandler>(){

    inner class CardDesignHandler(design: View) : RecyclerView.ViewHolder(design){

        var note_card: CardView
        var textViewLecture: TextView
        var textViewNoteFirst: TextView
        var textViewNoteSecond: TextView


        init {

            note_card = design.findViewById(R.id.note_card)
            textViewLecture = design.findViewById(R.id.textViewLecture)
            textViewNoteFirst = design.findViewById(R.id.textViewNoteFirst)
            textViewNoteSecond = design.findViewById(R.id.textViewNoteSecond)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHandler {
        val design = LayoutInflater.from(context).inflate(R.layout.card_design,parent,false)

        return CardDesignHandler(design)

    }

    override fun onBindViewHolder(holder: CardDesignHandler, position: Int) {

        val note = notlarListe.get(position)

        holder.textViewLecture.text = note.lecture_name
        holder.textViewNoteFirst.text = note.note1.toString()
        holder.textViewNoteSecond.text = note.note2.toString()

        holder.note_card.setOnClickListener {
            val intent = Intent(context, DetailActivity :: class.java)
            intent.putExtra("nesne",note)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return notlarListe.size
    }
}