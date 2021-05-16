package com.example.phonebookapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class PersonAdapter(private val context: Context, private var personList: List<Person>, private val vt: DatabaseHelper) : RecyclerView.Adapter<PersonAdapter.CardDesignHandler>(){

    inner class CardDesignHandler(design: View) : RecyclerView.ViewHolder(design){

        var textViewPersonInfo: TextView
        var imageViewMore: ImageView

        init {
            textViewPersonInfo = design.findViewById(R.id.textViewPersonInfo)
            imageViewMore = design.findViewById(R.id.imageViewMore)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHandler {
        val design = LayoutInflater.from(context).inflate(R.layout.person_card_design,parent, false)
        return CardDesignHandler(design)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: CardDesignHandler, position: Int) {
        val person = personList.get(position)

        holder.textViewPersonInfo.text = "${person.person_name} : ${person.person_phone}"
        holder.imageViewMore.setOnClickListener {
            val popupMenu = PopupMenu(context,holder.imageViewMore)
            popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { menuItem ->

                when(menuItem.itemId){
                    R.id.action_delete ->{
                        Snackbar.make(holder.imageViewMore,"${person.person_name} silinsin mi?",Snackbar.LENGTH_SHORT).setAction("EVET"){

                            PersonDao().deletePerson(vt,person.person_id)
                            personList = PersonDao().allPeople(vt)
                            notifyDataSetChanged()

                        }.show()
                        true
                    }
                    R.id.action_update ->{
                        alertShow(person)
                        true
                    }
                    else -> false
                }

            }
            popupMenu.show()
        }

    }

    fun alertShow(person:Person){
        val design = LayoutInflater.from(context).inflate(R.layout.alert_design,null)
        val editTextName = design.findViewById(R.id.editTextName) as EditText
        val editTextPhone = design.findViewById(R.id.editTextPhone) as EditText

        editTextName.setText(person.person_name)
        editTextPhone.setText(person.person_phone)

        val ad = AlertDialog.Builder(context)
        ad.setTitle("Kişi Güncelle")
        ad.setView(design)
        ad.setPositiveButton("Güncelle"){dialogInterface, i->

            val person_name = editTextName.text.toString().trim()
            val person_phone = editTextPhone.text.toString().trim()

            PersonDao().updatePerson(vt,person.person_id, person_name, person_phone)
            personList = PersonDao().allPeople(vt)
            notifyDataSetChanged()

        }
        ad.setNegativeButton("İptal"){dialogInterface, i->


        }

        ad.create().show()
    }


}