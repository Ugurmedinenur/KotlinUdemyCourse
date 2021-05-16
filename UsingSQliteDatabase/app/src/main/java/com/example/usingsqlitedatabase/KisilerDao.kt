package com.example.usingsqlitedatabase

import android.content.ContentValues
import java.util.ArrayList

class KisilerDao {

    fun kisiEkle(vt: DatabaseHelper, kisi_ad: String, kisi_tel: String, kisi_yas: Int, kisi_boy: Double){

        val db = vt.writableDatabase

        val values = ContentValues()
        values.put("kisi_ad", kisi_ad)
        values.put("kisi_tel", kisi_tel)
        values.put("kisi_yas", kisi_yas)
        values.put("kisi_boy", kisi_boy)

        db.insertOrThrow("kisiler", null,values)
        db.close()

    }

    fun updateKisi(vt: DatabaseHelper,kisi_no: Int, kisi_ad: String, kisi_tel: String, kisi_yas: Int, kisi_boy: Double){

        val db = vt.writableDatabase

        val values = ContentValues()
        values.put("kisi_no",kisi_no)
        values.put("kisi_ad", kisi_ad)
        values.put("kisi_tel", kisi_tel)
        values.put("kisi_yas", kisi_yas)
        values.put("kisi_boy", kisi_boy)

        db.update("kisiler",values, "kisi_no=?", arrayOf(kisi_no.toString()))
        db.close()

    }

    fun delete(vt: DatabaseHelper, kisi_no:Int) {

        val db = vt.writableDatabase
        db.delete("kisiler","kisi_no=?", arrayOf(kisi_no.toString()))
        db.close()

    }

    fun selectKisiler(vt: DatabaseHelper) : ArrayList<Kisiler>{

        val kisilerArrayList = ArrayList<Kisiler>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM kisiler",null)

        while (cursor.moveToNext()){

            val kisi = Kisiler(cursor.getInt(cursor.getColumnIndex("kisi_no")),
                cursor.getString(cursor.getColumnIndex("kisi_ad")),
                cursor.getString(cursor.getColumnIndex("kisi_tel")),
                cursor.getInt(cursor.getColumnIndex("kisi_yas")),
                cursor.getDouble(cursor.getColumnIndex("kisi_boy")))

            kisilerArrayList.add(kisi)

        }
        return kisilerArrayList

    }

    fun search(vt: DatabaseHelper,keyWord: String) : ArrayList<Kisiler>{

        val kisilerArrayList = ArrayList<Kisiler>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM kisiler WHERE kisi_ad like '%$keyWord%'",null)

        while (cursor.moveToNext()){

            val kisi = Kisiler(cursor.getInt(cursor.getColumnIndex("kisi_no")),
                cursor.getString(cursor.getColumnIndex("kisi_ad")),
                cursor.getString(cursor.getColumnIndex("kisi_tel")),
                cursor.getInt(cursor.getColumnIndex("kisi_yas")),
                cursor.getDouble(cursor.getColumnIndex("kisi_boy")))

            kisilerArrayList.add(kisi)

        }
        return kisilerArrayList

    }

    fun KayitKontrol(vt:DatabaseHelper, kisi_ad:String) : Int {

        var sonuc = 0
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT count(*)  AS sonuc FROM kisiler WHERE kisi_ad='$kisi_ad'",null)

        while (cursor.moveToNext()){
            sonuc = cursor.getInt(cursor.getColumnIndex("sonuc"))
        }

        return sonuc
    }



}