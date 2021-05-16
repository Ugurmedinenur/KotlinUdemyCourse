package com.example.notesapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Notes(@SerializedName("not_id")
                 @Expose
                 var note_id: Int,
                 @SerializedName("ders_adi")
                 @Expose
                 var lecture_name: String,
                 @SerializedName("not1")
                 @Expose
                 var note1: Int, @SerializedName("not2")
                 @Expose
                 var note2: Int) :Serializable{
}