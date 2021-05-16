package com.example.usingsqlitedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vt = DatabaseHelper(this)

        //KisilerDao().kisiEkle(vt,"melike","5384236714", 18,1.72)
        //KisilerDao().kisiEkle(vt,"melisa","5384236714", 18,1.72)
        //KisilerDao().kisiEkle(vt,"adem","5384236714", 18,1.72)

        //KisilerDao().updateKisi(vt, 3, "Yeni Melisa","1111",100,1.22)

        KisilerDao().delete(vt,3)

        val kisilerListe = KisilerDao().selectKisiler(vt)

        for (k in kisilerListe){
            Log.e("Kişi no", k.kisi_no.toString())
            Log.e("Kişi ad", k.kisi_ad)
            Log.e("Kişi tel", k.kisi_tel)
            Log.e("Kişi yaş", k.kisi_yas.toString())
            Log.e("Kişi boy", k.kisi_boy.toString())
        }
    }


}