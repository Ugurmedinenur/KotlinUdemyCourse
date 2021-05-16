package com.example.notesapp

class ApiUtils {

    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getNotesDaoInterface(): NotesDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(NotesDaoInterface :: class.java)
        }
    }
}