package com.example.loginapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ana_ekran.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.button_login

class AnaEkranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ana_ekran)

        val sp = getSharedPreferences("LoginInfo", Context.MODE_PRIVATE)

        val userName = sp.getString("userName", "kullanıcı adı yok")
        val pass = sp.getString("password","şifre yok")

        textViewOutput.text = "Kullanıcı Adı : $userName  Şifre : $pass"

        button_logout.setOnClickListener {

            val editor = sp.edit()

            editor.remove("userName")
            editor.remove("password")
            editor.commit()

            startActivity(Intent(this@AnaEkranActivity, MainActivity::class.java))
            finish()

        }
    }
}