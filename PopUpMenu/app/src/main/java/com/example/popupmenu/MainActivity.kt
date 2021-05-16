package com.example.popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_popup.setOnClickListener {
            val popup =PopupMenu(this, button_popup)

            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)

            popup.setOnMenuItemClickListener {item ->
                when(item.itemId){

                    R.id.action_sil ->{
                        Toast.makeText(applicationContext, "Sil", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_düzenle ->{
                        Toast.makeText(applicationContext, "Düzenle", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else ->false
                }
            }
            popup.show()
        }
    }
}