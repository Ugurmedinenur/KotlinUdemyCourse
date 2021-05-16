package com.example.dictionaryappwithretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Words(@SerializedName("kelime_id")
                 @Expose
                 var word_id: Int,
                 @SerializedName("ingilizce")
                 @Expose
                 var english: String,
                 @SerializedName("turkce")
                 @Expose
                 var turkish: String) : Serializable{
}