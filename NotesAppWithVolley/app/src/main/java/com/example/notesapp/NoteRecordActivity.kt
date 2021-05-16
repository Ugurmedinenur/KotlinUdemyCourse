package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_note_record.*
import org.json.JSONObject

class NoteRecordActivity : AppCompatActivity() {



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

            record(lecture_name,note1.toInt(),note2.toInt())

            startActivity(Intent(this@NoteRecordActivity, MainActivity :: class.java))
            finish()
        }
    }

    fun record(lecture_name: String, not1: Int, not2:Int){
        val url = "http://kasimadalan.pe.hu/notlar/insert_not.php"
        val request = object : StringRequest(Method.POST, url, Response.Listener { response ->



        }, Response.ErrorListener {  }){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String,String>()
                params["ders_adi"] = lecture_name
                params["not1"] = not1.toString()
                params["not2"] = not2.toString()
                return params
            }
        }
        Volley.newRequestQueue(this@NoteRecordActivity).add(request)
    }
}