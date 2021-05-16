package com.example.buttontextviewedittextapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

//edit text de stringde girilebilir integer da bu yüzden önce herzaman toString()ile stringe çevir sonra istediğine cast et

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            val alinanVeri = editText.text.toString()
            textView.text = alinanVeri

        }

    }
}