package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_note_record.*

class NoteRecordActivity : AppCompatActivity() {

    private lateinit var refNotes: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_record)

        toolbarNoteSave.title = "Not Kayıt"

        setSupportActionBar(toolbarNoteSave)

        val db = FirebaseDatabase.getInstance()
        refNotes = db.getReference("notlar")



        buttonSave.setOnClickListener {

            val lecture_name = editTextLecture.text.toString().trim()
            val note1 = editTextNote1.text.toString().trim()
            val note2 = editTextNot2.text.toString().trim()

            if(TextUtils.isEmpty(lecture_name)){
                Snackbar.make(toolbarNoteSave, "Ders adı giriniz", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(note1)){
                Snackbar.make(toolbarNoteSave, "Birinci notu giriniz", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(note2)){
                Snackbar.make(toolbarNoteSave, "İkinci notu giriniz", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val note = Notes("", lecture_name, note1.toInt(), note2.toInt())
            refNotes.push().setValue(note)

            startActivity(Intent(this@NoteRecordActivity, MainActivity :: class.java))
            finish()
        }
    }
}