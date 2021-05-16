package com.example.usingvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search()

    }
    fun delete(){
        val url = "http://kasimadalan.pe.hu/kisiler/delete_kisiler.php"

        val request = object : StringRequest(Method.POST, url, Response.Listener { cevap->

            Log.e("Silme İşlemi Cevap",cevap)

        }, Response.ErrorListener { error ->

            error.printStackTrace()

        }){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String,String>()
                params["kisi_id"] = "951"
                return params
            }
        }

        Volley.newRequestQueue(this@MainActivity).add(request)
    }

    fun insert(){
        val url = "http://kasimadalan.pe.hu/kisiler/insert_kisiler.php"

        val request = object : StringRequest(Method.POST, url, Response.Listener { cevap->

            Log.e("Ekleme İşlemi Cevap",cevap)

        }, Response.ErrorListener { error ->

            error.printStackTrace()

        }){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String,String>()
                params["kisi_ad"] = "testad"
                params["kisi_tel"] = "testtel"
                return params
            }
        }

        Volley.newRequestQueue(this@MainActivity).add(request)
    }

    fun update(){
        val url = "http://kasimadalan.pe.hu/kisiler/update_kisiler.php"

        val request = object : StringRequest(Method.POST, url, Response.Listener { cevap->

            Log.e("Güncllene İşlemi Cevap",cevap)

        }, Response.ErrorListener { error ->

            error.printStackTrace()

        }){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String,String>()
                params["kisi_id"] = "956"
                params["kisi_ad"] = "testad2"
                params["kisi_tel"] = "testtel2"
                return params
            }
        }

        Volley.newRequestQueue(this@MainActivity).add(request)
    }

    fun getAll(){
        val url = "http://kasimadalan.pe.hu/kisiler/tum_kisiler.php"

        val request = StringRequest(Request.Method.GET, url, Response.Listener{ cevap->

            Log.e("Veri okuma Cevap",cevap)

            try {
                val jsonObject = JSONObject(cevap)
                val list = jsonObject.getJSONArray("kisiler")

                for (i in 0 until list.length()){
                    val k = list.getJSONObject(i)

                    val person_id = k.getInt("kisi_id")
                    val kisi_ad = k.getString("kisi_ad")
                    val kisi_tel = k.getString("kisi_tel")

                    Log.e("Id",person_id.toString())
                    Log.e("Name",kisi_ad)
                    Log.e("Tel",kisi_tel)
                    Log.e("**********","***************")

                }

            }catch (e:JSONException){
                e.printStackTrace()
            }

        }, Response.ErrorListener{ error ->

            error.printStackTrace()

        })


        Volley.newRequestQueue(this@MainActivity).add(request)
    }

    fun search(){
        val url = "http://kasimadalan.pe.hu/kisiler/tum_kisiler_arama.php"

        val request = object : StringRequest(Method.POST, url, Response.Listener { cevap->

            Log.e("Arama Cevap",cevap)
            try {
                val jsonObject = JSONObject(cevap)
                val list = jsonObject.getJSONArray("kisiler")

                for (i in 0 until list.length()){
                    val k = list.getJSONObject(i)

                    val person_id = k.getInt("kisi_id")
                    val kisi_ad = k.getString("kisi_ad")
                    val kisi_tel = k.getString("kisi_tel")

                    Log.e("Id",person_id.toString())
                    Log.e("Name",kisi_ad)
                    Log.e("Tel",kisi_tel)
                    Log.e("**********","***************")

                }

            }catch (e:JSONException){
                e.printStackTrace()
            }


        }, Response.ErrorListener { error ->

            error.printStackTrace()

        }){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String,String>()
                params["kisi_ad"] = "T"
                return params
            }
        }

        Volley.newRequestQueue(this@MainActivity).add(request)
    }



}