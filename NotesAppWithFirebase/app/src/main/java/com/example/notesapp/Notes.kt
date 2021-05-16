package com.example.notesapp

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class Notes(var not_id: String? ="",
                 var ders_adi: String? = "",
                 var not1: Int? = 0 ,
                 var not2: Int? = 0) :Serializable{
}