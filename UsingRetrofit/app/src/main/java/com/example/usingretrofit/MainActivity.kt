package com.example.usingretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search()
    }

    fun deletePerson(){
        val kdi =ApiUtils.getKisilerDaoInterface()
        kdi.delete(957).enqueue(object : Callback<CRUDCevap>{

            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {

                if(response != null){
                    Log.e("Başarı",response.body().success.toString())
                    Log.e("Mesaj",response.body().message.toString())
                }

            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {

            }
        })
    }

    fun insertPerson(){
        val kdi =ApiUtils.getKisilerDaoInterface()
        kdi.insert("retrofitdeneme","retrofitdeneme").enqueue(object : Callback<CRUDCevap>{

            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {

                if(response != null){
                    Log.e("Başarı",response.body().success.toString())
                    Log.e("Mesaj",response.body().message.toString())
                }

            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {

            }
        })
    }

    fun updatePerson(){
        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.update(960, "retrofitdeneme","retrofitdeneme").enqueue(object : Callback<CRUDCevap>{

            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {

                if(response != null){
                    Log.e("Başarı",response.body().success.toString())
                    Log.e("Mesaj",response.body().message.toString())
                }

            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {

            }
        })
    }

    fun getAll(){
        val kdi =ApiUtils.getKisilerDaoInterface()
        kdi.getAll().enqueue(object : Callback<KisilerCevap> {
            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>?) {
                if(response != null) {

                    val kisilerList = response.body().kisiler

                    for(k in kisilerList){
                        Log.e("*******","*******")
                        Log.e("Kisi_id",k.kisiId.toString())
                        Log.e("Kisi_ad",k.kisiAd)
                        Log.e("Kisi_tel",k.kisiTel)

                    }

                }
            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {

            }
        })
    }

    fun search(){
        val kdi =ApiUtils.getKisilerDaoInterface()
        kdi.search("A").enqueue(object : Callback<KisilerCevap> {
            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>?) {
                if(response != null) {

                    val kisilerList = response.body().kisiler

                    for(k in kisilerList){
                        Log.e("*******","*******")
                        Log.e("Kisi_id",k.kisiId.toString())
                        Log.e("Kisi_ad",k.kisiAd)
                        Log.e("Kisi_tel",k.kisiTel)

                    }

                }
            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {

            }
        })
    }
}