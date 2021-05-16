package com.example.filmsapp

class FilmsDao {

    fun getFilmByCategory(vt: DatabaseHelper, categoryId: Int ) : ArrayList<Films>{

        val db = vt.writableDatabase
        val filmList = ArrayList<Films>()

        val c = db.rawQuery("SELECT * FROM kategoriler,yonetmenler,filmler " +
                "WHERE filmler.kategori_id = kategoriler.kategori_id " +
                "AND filmler.yonetmen_id = yonetmenler.yonetmen_id " +
                "AND filmler.kategori_id = $categoryId",null)

        while (c.moveToNext()){
            val category = Categories(c.getInt(c.getColumnIndex("kategori_id"))
                , c.getString(c.getColumnIndex("kategori_ad")))

            val director = Directors(c.getInt(c.getColumnIndex("yonetmen_id"))
                , c.getString(c.getColumnIndex("yonetmen_ad")))

            val film = Films(c.getInt(c.getColumnIndex("film_id"))
                , c.getString(c.getColumnIndex("film_ad"))
                , c.getInt(c.getColumnIndex("film_yil"))
                , c.getString(c.getColumnIndex("film_resim")), category, director)

            filmList.add(film)
        }

        return filmList

    }
}