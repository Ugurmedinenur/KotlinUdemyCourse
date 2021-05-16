package com.example.hazirveritabanikullanm.dao

import com.example.hazirveritabanikullanm.DatabaseHelper
import com.example.hazirveritabanikullanm.models.Filmler
import com.example.hazirveritabanikullanm.models.Kategoriler
import com.example.hazirveritabanikullanm.models.Yonetmenler

class FilmlerDao {

    fun tumFilmlerByKategoriId(vt: DatabaseHelper, kategori_id: Int): ArrayList<Filmler> {

        val FilmList = ArrayList<Filmler>()
        val db = vt.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM filmler,kategoriler,yonetmenler " +
                "WHERE filmler.kategori_id = kategoriler.kategori_id " +
                "and filmler.yonetmen_id = yonetmenler.yonetmen_id " +
                "and filmler.kategori_id = $kategori_id",null)

        while(cursor.moveToNext()) {

            val kategori = Kategoriler(cursor.getInt(cursor.getColumnIndex("kategori_id")),
                cursor.getString(cursor.getColumnIndex("kategori_ad")))

            val yonetmen = Yonetmenler(cursor.getInt(cursor.getColumnIndex("yonetmen_id")),
                cursor.getString(cursor.getColumnIndex("yonetmen_ad")))

            val film = Filmler(cursor.getInt(cursor.getColumnIndex("film_id"))
                , cursor.getString(cursor.getColumnIndex("yonetmen_ad"))
                , cursor.getInt(cursor.getColumnIndex("film_yil"))
                , cursor.getString(cursor.getColumnIndex("film_resim"))
                , kategori, yonetmen)

            FilmList.add(film)

        }
        return FilmList
    }
}