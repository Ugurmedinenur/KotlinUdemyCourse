package com.example.hazirveritabanikullanm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hazirveritabanikullanm.dao.FilmlerDao
import com.example.hazirveritabanikullanm.dao.KategorilerDao
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseCopy()

        val vt = DatabaseHelper(this)
       // val liste = KategorilerDao().tumKategoriler(vt)
        val liste = FilmlerDao().tumFilmlerByKategoriId(vt,2)

        for(k in liste){
            Log.e("Film_id",k.film_id.toString())
            Log.e("Film_ad",k.film_ad)
            Log.e("Film_yil",k.film_year.toString())
            Log.e("Film_resim",k.film_resim)
            Log.e("Film_kategori_id",k.kategori.kategori_id.toString())
            Log.e("Film_kategori_ad",k.kategori.kategori_ad)
            Log.e("Film_yonetmen_id",k.yonetmen.yonetmen_id.toString())
            Log.e("Film_yonetmen_ad",k.yonetmen.yonetmen_ad)

        }

    }

    fun databaseCopy(){
        val db = DatabaseCopyHelper(this)

        try {
            db.createDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }

        try {
            db.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}