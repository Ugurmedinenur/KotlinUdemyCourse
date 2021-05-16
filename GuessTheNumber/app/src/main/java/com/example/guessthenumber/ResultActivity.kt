package com.example.guessthenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getBooleanExtra("result",false)
        if(result){
            textView_result.text = "KAZANDINIZ"
            imageView_result.setImageResource(R.drawable.hapiness)
        }else{
            textView_result.text = "KAYBETTİNİZ"
            imageView_result.setImageResource(R.drawable.sad_image)
        }


        button_tekrar.setOnClickListener {

            startActivity(Intent(this@ResultActivity, GuessActivity::class.java))
            finish()
        }
    }
}