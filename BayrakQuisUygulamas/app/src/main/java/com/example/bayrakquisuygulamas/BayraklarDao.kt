package com.example.bayrakquisuygulamas

class BayraklarDao {

    fun randomFlags(vt : DatabaseHelper) : ArrayList<Bayraklar> {

        val bayraklar = ArrayList<Bayraklar>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5",null)

        while (cursor.moveToNext()){
            val bayrak = Bayraklar(cursor.getInt(cursor.getColumnIndex("bayrak_id"))
                , cursor.getString(cursor.getColumnIndex("bayrak_ad"))
                , cursor.getString(cursor.getColumnIndex("bayrak_resim")))

            bayraklar.add(bayrak)
        }
        return bayraklar
    }

    fun falseOptions(vt : DatabaseHelper,bayrak_id: Int) : ArrayList<Bayraklar> {

        val bayraklar = ArrayList<Bayraklar>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id !=$bayrak_id ORDER BY RANDOM() LIMIT 3",null)

        while (cursor.moveToNext()){
            val bayrak = Bayraklar(cursor.getInt(cursor.getColumnIndex("bayrak_id"))
                , cursor.getString(cursor.getColumnIndex("bayrak_ad"))
                , cursor.getString(cursor.getColumnIndex("bayrak_resim")))

            bayraklar.add(bayrak)
        }
        return bayraklar
    }
}