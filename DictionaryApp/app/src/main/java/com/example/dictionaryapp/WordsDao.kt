package com.example.dictionaryapp

class WordsDao {

    fun allWords(vt: DatabaseHelper): ArrayList<Words> {
        val wordList = ArrayList<Words>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM kelimeler",null)

        while(cursor.moveToNext()){
            val word = Words(cursor.getInt(cursor.getColumnIndex("kelime_id"))
                , cursor.getString(cursor.getColumnIndex("ingilizce"))
                , cursor.getString(cursor.getColumnIndex("turkce")))

            wordList.add(word)
        }

        return wordList
    }

    fun search(vt: DatabaseHelper, key:String): ArrayList<Words> {
        val wordList = ArrayList<Words>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce LIKE '%$key%'",null)

        while(cursor.moveToNext()){
            val word = Words(cursor.getInt(cursor.getColumnIndex("kelime_id"))
                , cursor.getString(cursor.getColumnIndex("ingilizce"))
                , cursor.getString(cursor.getColumnIndex("turkce")))

            wordList.add(word)
        }

        return wordList
    }
}