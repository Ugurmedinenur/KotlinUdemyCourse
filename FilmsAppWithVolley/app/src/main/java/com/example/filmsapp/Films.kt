package com.example.filmsapp

import java.io.Serializable

data class Films (var film_id: Int,
                  var film_name: String,
                  var film_year: Int,
                  var film_image: String,
                  var category: Categories,
                  var director: Directors) : Serializable {
}