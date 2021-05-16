package com.example.phonebookapp

import android.content.ContentValues
import java.nio.channels.spi.AbstractSelectionKey

class PersonDao {

    fun allPeople(vt:DatabaseHelper) : ArrayList<Person>{

        val personList = ArrayList<Person>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM phonebook", null)

        while (c.moveToNext()){
            val person = Person(c.getInt(c.getColumnIndex("person_id"))
                , c.getString(c.getColumnIndex("person_name"))
                , c.getString(c.getColumnIndex("person_phone")))
            personList.add(person)
        }
        return personList

    }

    fun searchPerson(vt:DatabaseHelper, searchKey: String) : ArrayList<Person>{

        val personList = ArrayList<Person>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM phonebook WHERE person_name like '%$searchKey%'", null)


        while (c.moveToNext()){
            val person = Person(c.getInt(c.getColumnIndex("person_id"))
                , c.getString(c.getColumnIndex("person_name"))
                , c.getString(c.getColumnIndex("person_phone")))
            personList.add(person)
        }
        db.close()
        return personList

    }

    fun deletePerson(vt:DatabaseHelper, person_id: Int){

        val db = vt.writableDatabase
        db.delete("phonebook", "person_id = ?", arrayOf(person_id.toString()))
        db.close()

    }
    fun addPerson(vt:DatabaseHelper, person_name: String, person_phone:String){

        val db = vt.writableDatabase
        val values = ContentValues()
        values.put("person_name", person_name)
        values.put("person_phone", person_phone)

        db.insertOrThrow("phonebook",null, values)
        db.close()

    }
    fun updatePerson(vt:DatabaseHelper,person_id: Int, person_name: String, person_phone:String){

        val db = vt.writableDatabase
        val values = ContentValues()
        values.put("person_name", person_name)
        values.put("person_phone", person_phone)

        db.update("phonebook",values,"person_id = ?", arrayOf(person_id.toString()))
        db.close()

    }
}