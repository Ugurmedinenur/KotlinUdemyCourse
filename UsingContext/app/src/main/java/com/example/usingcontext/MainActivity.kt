package com.example.usingcontext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            Toast.makeText(this ,"Merhaba", Toast.LENGTH_SHORT).show() // context farklı türlerde olabilir. Bunlardan birisi this
            // Toast.makeText(this@MainActivity ,"Merhaba", Toast.LENGTH_SHORT).show()
            // Toast.makeText(applicationContext ,"Merhaba", Toast.LENGTH_SHORT).show()
            //Fragmentlarda ise Activity kullanılır.
        }
    }
}