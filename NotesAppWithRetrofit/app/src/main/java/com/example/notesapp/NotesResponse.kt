package com.example.notesapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NotesResponse(@SerializedName("notlar")
                         @Expose
                         var notes : List<Notes>,
                         @SerializedName("success")
                         @Expose
                         var success : Int) {
}