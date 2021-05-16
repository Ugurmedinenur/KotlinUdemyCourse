package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_note_record.*

class DetailActivity : AppCompatActivity() {

    private  lateinit var note: Notes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        toolbarNoteDetail.title = "Not Detay"
        setSupportActionBar(toolbarNoteDetail)

        note = intent.getSerializableExtra("nesne") as Notes

        editTextLectureDetail.setText(note.lecture_name)
        editTextNote1Detail.setText((note.note1).toString())
        editTextNote2Detail.setText((note.note2).toString())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_delete ->{
                Snackbar.make(toolbarNoteDetail,"Silinsin mi?",Snackbar.LENGTH_SHORT)
                    .setAction("EVET"){
                        delete(note.note_id)


                        startActivity(Intent(this@DetailActivity, MainActivity :: class.java))
                        finish()
                    }.show()



                return true
            }
            R.id.action_update ->{
                val lecture_name = editTextLectureDetail.text.toString().trim()
                val note1 = editTextNote1Detail.text.toString().trim()
                val note2 = editTextNote2Detail.text.toString().trim()

                if(TextUtils.isEmpty(lecture_name)){
                    Snackbar.make(toolbarNoteDetail, "Ders adı giriniz", Snackbar.LENGTH_SHORT).show()
                    return false
                }
                if(TextUtils.isEmpty(note1)){
                    Snackbar.make(toolbarNoteDetail, "Birinci notu giriniz", Snackbar.LENGTH_SHORT).show()
                    return false
                }
                if(TextUtils.isEmpty(note2)){
                    Snackbar.make(toolbarNoteDetail, "İkinci notu giriniz", Snackbar.LENGTH_SHORT).show()
                    return false
                }

                update(note.note_id, lecture_name, note1.toInt(), note2.toInt())

                startActivity(Intent(this@DetailActivity, MainActivity :: class.java))
                finish()
                return true
            }
            else -> return false
        }
        return super.onOptionsItemSelected(item)
    }

    fun update(not_id: Int, lecture_name: String, not1: Int, not2:Int){
        val url = "http://kasimadalan.pe.hu/notlar/update_not.php"
        val request = object : StringRequest(Method.POST, url, Response.Listener { response ->



        }, Response.ErrorListener {  }){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String,String>()
                params["not_id"] = not_id.toString()
                params["ders_adi"] = lecture_name
                params["not1"] = not1.toString()
                params["not2"] = not2.toString()
                return params
            }
        }
        Volley.newRequestQueue(this@DetailActivity).add(request)
    }

    fun delete(not_id: Int){
        val url = "http://kasimadalan.pe.hu/notlar/delete_not.php"
        val request = object : StringRequest(Method.POST, url, Response.Listener { response ->



        }, Response.ErrorListener {  }){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String,String>()
                params["not_id"] = not_id.toString()
                return params
            }
        }
        Volley.newRequestQueue(this@DetailActivity).add(request)
    }

}