package com.example.filmsapp

class CategoriesDao {

    fun allCategories(vt:DatabaseHelper) : ArrayList<Categories> {

        val db = vt.writableDatabase
        val categoriesList = ArrayList<Categories>()

        val c = db.rawQuery("SELECT * FROM kategoriler",null)

        while (c.moveToNext()){
            val category = Categories(c.getInt(c.getColumnIndex("kategori_id"))
                , c.getString(c.getColumnIndex("kategori_ad")))

            categoriesList.add(category)
        }

        return categoriesList

    }
}