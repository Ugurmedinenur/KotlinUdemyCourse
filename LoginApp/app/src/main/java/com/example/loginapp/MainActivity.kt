package com.example.loginapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = getSharedPreferences("LoginInfo", Context.MODE_PRIVATE)

        val og_userName = sp.getString("userName", "kullanıcı adı yok")
        val og_pass = sp.getString("password","şifre yok")

        if(og_userName == "admin" && og_pass == "123"){
            startActivity(Intent(this@MainActivity, AnaEkranActivity::class.java))
            finish()

        }

        button_login.setOnClickListener {

            val userName = editText_userName.text.toString()
            val pass = editText_password.text.toString()

            if(userName == "admin" && pass == "123"){

                val editor = sp.edit()

                editor.putString("userName", userName)
                editor.putString("password", pass)
                editor.commit()

                startActivity(Intent(this@MainActivity, AnaEkranActivity::class.java))
                finish()

            }else{
                Toast.makeText(applicationContext, "Hatalı Giriş", Toast.LENGTH_SHORT).show()
            }

        }
    }
}