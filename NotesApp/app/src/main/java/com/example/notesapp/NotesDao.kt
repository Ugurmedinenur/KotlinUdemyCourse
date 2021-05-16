package com.example.notesapp

import android.content.ContentValues
import android.provider.ContactsContract

class NotesDao {

    fun allNotes(vt: DatabaseHelper): ArrayList<Notes>{
        val db = vt.writableDatabase

        val notesList = ArrayList<Notes>()
        val c = db.rawQuery("SELECT * FROM notes",null)

        while (c.moveToNext()){
            val note = Notes(c.getInt(c.getColumnIndex("note_id"))
                , c.getString(c.getColumnIndex("lecture_name"))
                , c.getInt(c.getColumnIndex("note_1"))
                , c.getInt(c.getColumnIndex("note_2")))

            notesList.add(note)
        }
        return  notesList
    }

    fun deleteNote(vt: DatabaseHelper, note_id: Int){

        val db = vt.writableDatabase
        db.delete("notes", "note_id = ?", arrayOf(note_id.toString()))
        db.close()

    }

    fun addNote(vt: DatabaseHelper, lecture_name:String, note_1: Int, note_2: Int){

        val db = vt.writableDatabase

        val values = ContentValues()
        values.put("lecture_name", lecture_name)
        values.put("note_1",note_1)
        values.put("note_2",note_2)

        db.insertOrThrow("notes",null,values)
        db.close()

    }

    fun updateNote(vt: DatabaseHelper, note_id: Int, lecture_name:String, note_1: Int, note_2: Int){

        val db = vt.writableDatabase

        val values = ContentValues()
        values.put("lecture_name", lecture_name)
        values.put("note_1",note_1)
        values.put("note_2",note_2)

        db.update("notes",values,"note_id=?", arrayOf(note_id.toString()))
        db.close()

    }

}