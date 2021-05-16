package com.example.hazirveritabanikullanm.models

data class Filmler (var film_id: Int,
                    var film_ad: String,
                    var film_year: Int,
                    var film_resim: String,
                    var kategori: Kategoriler,
                    var yonetmen: Yonetmenler){

}