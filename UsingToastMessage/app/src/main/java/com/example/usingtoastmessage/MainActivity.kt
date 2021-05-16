package com.example.usingtoastmessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_normal.setOnClickListener {
            Toast.makeText(applicationContext, "Merhaba", Toast.LENGTH_SHORT).show()
        }

        button_ozel.setOnClickListener {

            val design = layoutInflater.inflate(R.layout.toast_design, null)
            val textViewMessage = design.findViewById(R.id.textViewMessage) as TextView

            textViewMessage.text = "Merhaba Özel Mesaj"

            val toast = Toast(applicationContext)
            toast.view = design
            toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0, 0)
            toast.duration = Toast.LENGTH_LONG
            toast.show()

        }
    }
}