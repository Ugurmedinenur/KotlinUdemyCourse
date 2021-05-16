package com.example.jsonparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonBayraklar = "{\"bayraklar\":[{\"bayrak_id\":\"1\",\"bayrak_ad\":\"T\\u00fcrkiye\",\"bayrak_resim\":\"turkiye\"},{\"bayrak_id\":\"2\",\"bayrak_ad\":\"Almanya\",\"bayrak_resim\":\"almanya\"},{\"bayrak_id\":\"3\",\"bayrak_ad\":\"\\u0130talya\",\"bayrak_resim\":\"italya\"},{\"bayrak_id\":\"4\",\"bayrak_ad\":\"Fransa\",\"bayrak_resim\":\"fransa\"},{\"bayrak_id\":\"5\",\"bayrak_ad\":\"Hollanda\",\"bayrak_resim\":\"hollanda\"},{\"bayrak_id\":\"6\",\"bayrak_ad\":\"\\u0130spanya\",\"bayrak_resim\":\"ispanya\"},{\"bayrak_id\":\"7\",\"bayrak_ad\":\"Slovenya\",\"bayrak_resim\":\"slovenya\"},{\"bayrak_id\":\"8\",\"bayrak_ad\":\"Slovakya\",\"bayrak_resim\":\"slovakya\"},{\"bayrak_id\":\"9\",\"bayrak_ad\":\"Estonya\",\"bayrak_resim\":\"estonya\"},{\"bayrak_id\":\"10\",\"bayrak_ad\":\"Rusya\",\"bayrak_resim\":\"rusya\"},{\"bayrak_id\":\"11\",\"bayrak_ad\":\"Bulgaristan\",\"bayrak_resim\":\"bulgaristan\"},{\"bayrak_id\":\"12\",\"bayrak_ad\":\"Romanya\",\"bayrak_resim\":\"romanya\"},{\"bayrak_id\":\"13\",\"bayrak_ad\":\"Norve\\u00e7\",\"bayrak_resim\":\"norvec\"},{\"bayrak_id\":\"14\",\"bayrak_ad\":\"Yunanistan\",\"bayrak_resim\":\"yunanistan\"},{\"bayrak_id\":\"15\",\"bayrak_ad\":\"Bosna Hersek\",\"bayrak_resim\":\"bosnahersek\"}],\"success\":1}";

        try{

            val jsonObject = JSONObject(jsonBayraklar)
            val list = jsonObject.getJSONArray("bayraklar")

            for (i in 0 until list.length()){

                val b = list.getJSONObject(i)

                val bayrak_id = b.getInt("bayrak_id")
                val bayrak_isim = b.getString("bayrak_ad")
                val bayrak_resim = b.getString("bayrak_resim")

                Log.e("********","**********")
                Log.e("Bayrak_id",bayrak_id.toString())
                Log.e("Bayrak_isim",bayrak_isim)
                Log.e("Bayrak_resim",bayrak_resim)
                Log.e("********","**********")

            }
        }catch (e: JSONException){
            e.printStackTrace()
        }

        val filmsJson = "{\"filmler\":[{\"film_id\":\"1\",\"film_ad\":\"Interstellar\",\"film_yil\":\"2015\",\"film_resim\":\"interstellar.png\",\"kategori\":{\"kategori_id\":\"4\",\"kategori_ad\":\"Bilim Kurgu\"},\"yonetmen\":{\"yonetmen_id\":\"1\",\"yonetmen_ad\":\"Christopher Nolan\"}},{\"film_id\":\"2\",\"film_ad\":\"Inception\",\"film_yil\":\"2010\",\"film_resim\":\"inception.png\",\"kategori\":{\"kategori_id\":\"4\",\"kategori_ad\":\"Bilim Kurgu\"},\"yonetmen\":{\"yonetmen_id\":\"1\",\"yonetmen_ad\":\"Christopher Nolan\"}},{\"film_id\":\"3\",\"film_ad\":\"The Pianist\",\"film_yil\":\"2002\",\"film_resim\":\"thepianist.png\",\"kategori\":{\"kategori_id\":\"3\",\"kategori_ad\":\"Drama\"},\"yonetmen\":{\"yonetmen_id\":\"4\",\"yonetmen_ad\":\"Roman Polanski\"}},{\"film_id\":\"4\",\"film_ad\":\"Bir Zamanlar Anadolu'da\",\"film_yil\":\"2011\",\"film_resim\":\"birzamanlaranadoluda.png\",\"kategori\":{\"kategori_id\":\"3\",\"kategori_ad\":\"Drama\"},\"yonetmen\":{\"yonetmen_id\":\"3\",\"yonetmen_ad\":\"Nuri Bilge Ceylan\"}},{\"film_id\":\"5\",\"film_ad\":\"The Hateful Eight\",\"film_yil\":\"2015\",\"film_resim\":\"thehatefuleight.png\",\"kategori\":{\"kategori_id\":\"1\",\"kategori_ad\":\"Aksiyon\"},\"yonetmen\":{\"yonetmen_id\":\"2\",\"yonetmen_ad\":\"Quentin Tarantino\"}},{\"film_id\":\"18\",\"film_ad\":\"Django\",\"film_yil\":\"2013\",\"film_resim\":\"django.png\",\"kategori\":{\"kategori_id\":\"1\",\"kategori_ad\":\"Aksiyon\"},\"yonetmen\":{\"yonetmen_id\":\"2\",\"yonetmen_ad\":\"Quentin Tarantino\"}}],\"success\":1}"
        try{

            val jsonObject = JSONObject(filmsJson)
            val list = jsonObject.getJSONArray("filmler")

            for (i in 0 until list.length()){

                val b = list.getJSONObject(i)

                val film_id = b.getInt("film_id")
                val film_isim = b.getString("film_ad")
                val film_yil = b.getInt("film_yil")
                val film_resim = b.getString("film_resim")

                val kategori = b.getJSONObject("kategori")
                val kategori_id = kategori.getInt("kategori_id")
                val kategori_isim = kategori.getString("kategori_ad")

                Log.e("********","**********")
                Log.e("Film_id",film_id.toString())
                Log.e("Bayrak_isim",film_isim)
                Log.e("Bayrak_resim",film_resim)
                Log.e("********","**********")

            }
        }catch (e: JSONException){
            e.printStackTrace()
        }

    }
}