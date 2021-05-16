package com.example.hazirveritabanikullanm.dao

import com.example.hazirveritabanikullanm.DatabaseHelper
import com.example.hazirveritabanikullanm.models.Kategoriler

class KategorilerDao {

    fun tumKategoriler(vt: DatabaseHelper): ArrayList<Kategoriler> {

        val KategoriList = ArrayList<Kategoriler>()
        val db = vt.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM kategoriler",null)

        while(cursor.moveToNext()) {

            val kategori = Kategoriler(cursor.getInt(cursor.getColumnIndex("kategori_id")),
                cursor.getString(cursor.getColumnIndex("kategori_ad")))

            KategoriList.add(kategori)

        }
        return KategoriList
    }
}