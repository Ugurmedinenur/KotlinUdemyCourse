package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_note_record.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class NoteRecordActivity : AppCompatActivity() {

    private lateinit var ndi : NotesDaoInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_record)

        toolbarNoteSave.title = "Not Kayıt"

        setSupportActionBar(toolbarNoteSave)



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

            ndi = ApiUtils.getNotesDaoInterface()
            addNote(lecture_name, note1.toInt(),note2.toInt())

            startActivity(Intent(this@NoteRecordActivity, MainActivity :: class.java))
            finish()
        }
    }

    fun addNote(lecture_name : String, note1: Int, note2: Int){
        ndi.insert(lecture_name,note1,note2).enqueue(object : retrofit2.Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {

            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {
                
            }

        })
    }
}