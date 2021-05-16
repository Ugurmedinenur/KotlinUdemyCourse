package com.example.snackbar

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNormal.setOnClickListener {view ->
            Snackbar.make(view, "Merhaba", Snackbar.LENGTH_SHORT).show()
        }
        buttonReturn.setOnClickListener {view ->

            Snackbar.make(view, "Mesaj Silinsin mi?", Snackbar.LENGTH_SHORT)
                    .setAction("EVET"){view1 ->
                        Snackbar.make(view1, "Merhaba", Snackbar.LENGTH_SHORT).show()
                    }
                    .show()


        }
        buttonOzel.setOnClickListener {view ->

            val sb = Snackbar.make(view, "İnternet bağlantısı yok.", Snackbar.LENGTH_LONG)

            sb.setAction("Tekrar Dene"){view1 ->
                Snackbar.make(view1, "Merhaba", Snackbar.LENGTH_SHORT).show()
            }
            sb.setActionTextColor(Color.RED)
            sb.setTextColor(Color.BLUE)
            sb.setBackgroundTint(Color.WHITE)


            sb.show()

        }

    }
}