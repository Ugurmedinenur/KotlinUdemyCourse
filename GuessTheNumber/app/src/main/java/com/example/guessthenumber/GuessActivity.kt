package com.example.guessthenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_guess.*
import kotlin.random.Random

class GuessActivity : AppCompatActivity() {

    private var sayi = 0
    private var sayac = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)

        sayi = Random.nextInt(101)
        Log.e("Sayı ",sayi.toString())

        button_tahmin.setOnClickListener {
            val tahmin = editText_input.text.toString().toInt()
            sayac = sayac - 1



            if (tahmin == sayi){

                val intent = Intent(this@GuessActivity, ResultActivity::class.java)
                intent.putExtra("result",true)
                startActivity(intent)
                finish()
                return@setOnClickListener
            }
            else if (tahmin > sayi){
                textView_kalan_hak.text = "Kalan Hak : $sayac"
                textView_yardım.text = "Azalt"
            }
            else{
                textView_kalan_hak.text = "Kalan Hak : $sayac"
                textView_yardım.text = "Arttır"
            }

            if(sayac <= 0){
                val intent = Intent(this@GuessActivity, ResultActivity::class.java)
                intent.putExtra("result",false)
                startActivity(intent)
                finish()
            }
            editText_input.setText("")
        }
    }
}