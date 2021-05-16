package com.example.createalertview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_desing.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_normal.setOnClickListener {

            val ad = AlertDialog.Builder(this@MainActivity)

            ad.setMessage("Mesaj")
            ad.setTitle("Başlık")
            ad.setIcon(R.drawable.resim)

            ad.setPositiveButton("Tamam"){dialogInterface, i ->
                Toast.makeText(applicationContext,"TAMAM", Toast.LENGTH_SHORT).show()

            }
            ad.setNegativeButton("İptal"){dialogInterface, i ->
                Toast.makeText(applicationContext,"İPTAL", Toast.LENGTH_SHORT).show()

            }
            ad.create().show()

        }

        button_ozel.setOnClickListener {

            val design = layoutInflater.inflate(R.layout.alert_desing, null)
            val edittext = design.findViewById(R.id.editTextAlert) as EditText



            val ad = AlertDialog.Builder(this@MainActivity)

            ad.setMessage("Mesaj")
            ad.setTitle("Başlık")
            ad.setIcon(R.drawable.resim)
            ad.setView(design)

            ad.setPositiveButton("Kaydet"){dialogInterface, i ->
                val input = edittext.text.toString()
                Toast.makeText(applicationContext,"Alınan veri: $input", Toast.LENGTH_SHORT).show()

            }
            ad.setNegativeButton("İptal"){dialogInterface, i ->
                Toast.makeText(applicationContext,"İPTAL", Toast.LENGTH_SHORT).show()

            }
            ad.create().show()

        }


    }
}