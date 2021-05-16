package com.example.game

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("score",0)
        textViewScoreResult.text = score.toString()

        val sp = getSharedPreferences("result",Context.MODE_PRIVATE)
        val bestScore = sp.getInt("bestScore",0)

        if(score > bestScore){
            val editor = sp.edit()
            editor.putInt("bestScore",score)
            editor.commit()
            textViewBestScore.text = score.toString()
        }
        else{
            textViewBestScore.text = bestScore.toString()
        }

        buttonRepeat.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity :: class.java))
            finish()
        }

    }
}