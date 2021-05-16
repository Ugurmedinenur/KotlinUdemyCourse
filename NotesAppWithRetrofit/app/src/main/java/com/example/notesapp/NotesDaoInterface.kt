package com.example.notesapp

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface NotesDaoInterface {

    @GET("/notlar/tum_notlar.php")
    fun getAll() : Call<NotesResponse>

    @POST("/notlar/delete_not.php")
    @FormUrlEncoded
    fun delete(@Field("not_id") not_id : Int) : Call<CRUDResponse>

    @POST("/notlar/insert_not.php")
    @FormUrlEncoded
    fun insert(@Field("ders_adi") ders_adi : String
               , @Field("not1") not1 : Int
               , @Field("not2") not2 : Int) : Call<CRUDResponse>

    @POST("/notlar/update_not.php")
    @FormUrlEncoded
    fun update(@Field("not_id") not_id : Int
               , @Field("ders_adi") ders_adi : String
               , @Field("not1") not1 : Int
               , @Field("not2") not2 : Int) : Call<CRUDResponse>

}