package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val mContext : Context, private val countriesList:List<Countries>) : RecyclerView.Adapter<RVAdapter.CardViewDesignObjects>(){

    inner class CardViewDesignObjects(view:View):RecyclerView.ViewHolder(view){
        var cardView : CardView
        var textView_Satir : TextView
        var image : ImageView

        init{
            cardView = view.findViewById(R.id.cardView)
            textView_Satir = view.findViewById(R.id.textView_satir)
            image = view.findViewById(R.id.image_more)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewDesignObjects {

        val design = LayoutInflater.from(mContext).inflate(R.layout.card_design, parent, false)

        return CardViewDesignObjects(design)
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }

    override fun onBindViewHolder(holder: CardViewDesignObjects, position: Int) {

        val country = countriesList[position]

        holder.textView_Satir.text = country.name

        holder.cardView.setOnClickListener{
            Toast.makeText(mContext, "Seçilen Ülke : ${country.name}",Toast.LENGTH_SHORT).show()
        }

        holder.image.setOnClickListener {
            val popup = PopupMenu(mContext, holder.image)
            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)
            popup.show()

            popup.setOnMenuItemClickListener {item->

                when(item.itemId){
                    R.id.action_delete ->{
                        Toast.makeText(mContext, "Sil : ${country.name}",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_update ->{
                        Toast.makeText(mContext, "Güncelle: ${country.name}",Toast.LENGTH_SHORT).show()
                        true
                    }
                    else->false

                }

            }
        }

    }
}