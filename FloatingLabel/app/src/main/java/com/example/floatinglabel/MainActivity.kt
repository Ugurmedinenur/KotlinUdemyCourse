package com.example.floatinglabel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnYap.setOnClickListener {
            val ad = EditTextName.text.toString().trim()
            val tel = editTextTel.text.toString().trim()
            //trim() boşlukları siler

            if(TextUtils.isEmpty(ad)){ // gelen verinin boş olup olmadığıı kontrol eder
                Toast.makeText(applicationContext, "Ad alanı boş",Toast.LENGTH_SHORT).show()
                return@setOnClickListener//butonun işlemini durdurur bunu yapmam gerekiyor
            }
            if(TextUtils.isEmpty(tel)){
                Toast.makeText(applicationContext, "Tel alanı boş",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(tel.length < 6){
                Toast.makeText(applicationContext, "Tel en az 6 hane olmalı boş",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(applicationContext, "$ad - $tel",Toast.LENGTH_SHORT).show()
        }
    }
}