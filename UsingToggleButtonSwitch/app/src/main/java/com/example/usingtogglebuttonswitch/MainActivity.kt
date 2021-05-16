package com.example.usingtogglebuttonswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switch1.setOnCheckedChangeListener { compoundButton, b ->

            if(b){
                Log.e("Switch","ON")
            }else{
                Log.e("Switch","OF")
            }

        }

        toggleButton.setOnCheckedChangeListener { compoundButton, b ->

            if(b){
                Log.e("toggle Button","ON")
            }else{
                Log.e("toggle Button","OF")
            }

        }
        button.setOnClickListener {
            val switchDurum = switch1.isChecked

            val toggleDurum = toggleButton.isChecked

            Log.e("toggle Button durum ",toggleDurum.toString())
            Log.e("Switch durum",switchDurum.toString())

        }
    }
}