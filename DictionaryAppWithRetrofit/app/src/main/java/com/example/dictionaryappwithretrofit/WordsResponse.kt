package com.example.dictionaryappwithretrofit

import com.example.dictionaryappwithretrofit.Words
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WordsResponse(@SerializedName("kelimeler")
                         @Expose
                         var wordsList : List<Words>,
                         @SerializedName("success")
                         @Expose
                         var success : Int) {
}