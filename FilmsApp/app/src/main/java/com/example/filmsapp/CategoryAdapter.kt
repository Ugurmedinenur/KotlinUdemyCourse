package com.example.filmsapp

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val context: Context, private val categoryList: List<Categories>) : RecyclerView.Adapter<CategoryAdapter.CardDesignHandler>() {

    inner class CardDesignHandler(design : View) : RecyclerView.ViewHolder(design) {

        var category_card: CardView
        var textViewCategoryName: TextView

        init {
            category_card = design.findViewById(R.id.category_card)
            textViewCategoryName = design.findViewById(R.id.textViewCategoryName)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHandler {
        val design = LayoutInflater.from(context).inflate(R.layout.category_card_design,parent,false)
        return CardDesignHandler(design)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CardDesignHandler, position: Int) {
        val category = categoryList[position]

        holder.textViewCategoryName.text = category.category_name

        holder.category_card.setOnClickListener {

            val intent = Intent(context,FilmsActivity::class.java)
            intent.putExtra("category",category)
            context.startActivity(intent)

        }
    }

}