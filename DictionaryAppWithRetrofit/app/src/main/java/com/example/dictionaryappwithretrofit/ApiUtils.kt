package com.example.dictionaryappwithretrofit



class ApiUtils {

    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getWordsDaoInterface(): WordsDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(WordsDaoInterface :: class.java)
        }
    }
}