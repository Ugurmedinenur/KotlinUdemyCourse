package com.example.notesapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context:Context) :SQLiteOpenHelper(context,"notlar.sqlite",null,1){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE notes (note_id INTEGER PRIMARY KEY AUTOINCREMENT,lecture_name TEXT, note_1 INTEGER, note_2 INTEGER);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS notes")
        onCreate(db)
    }
}