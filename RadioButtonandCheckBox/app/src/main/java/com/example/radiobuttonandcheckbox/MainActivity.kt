package com.example.radiobuttonandcheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

//birden fazla seçime izin vereceksek checkbox vermeyeceksek radio button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val javaDurum = java.isChecked
            val kotlinDurum = kotlin.isChecked
            val barcelonaDurum = barcelona.isChecked
            val realmadridDurum = realmadrid.isChecked

            Log.e("Java Durum",javaDurum.toString())
            Log.e("kotlin Durum",kotlinDurum.toString())
            Log.e("Barcelona Durum",barcelonaDurum.toString())
            Log.e("RealMadrid Durum",realmadridDurum.toString())

        }

        barcelona.setOnCheckedChangeListener { compoundButton, b ->
            if(b){

                Toast.makeText(applicationContext, "Tebrikler:)", Toast.LENGTH_SHORT).show()
            }
        }

    }
}