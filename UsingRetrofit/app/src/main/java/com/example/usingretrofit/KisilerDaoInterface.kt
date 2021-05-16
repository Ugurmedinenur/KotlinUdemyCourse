package com.example.usingretrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDaoInterface {

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    fun delete(@Field("kisi_id") kisi_id: Int):Call<CRUDCevap>

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    fun insert(@Field("kisi_ad") kisi_ad: String
               , @Field("kisi_tel") kisi_tel: String):Call<CRUDCevap>

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    fun update(@Field("kisi_id") kisi_id: Int
               , @Field("kisi_ad") kisi_ad: String
               , @Field("kisi_tel") kisi_tel: String):Call<CRUDCevap>

    @GET("kisiler/tum_kisiler.php")
    fun getAll():Call<KisilerCevap>

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    fun search( @Field("kisi_ad") kisi_ad: String):Call<KisilerCevap>


}