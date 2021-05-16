package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_note_record.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private  lateinit var note: Notes
    private  lateinit var ndi: NotesDaoInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        ndi = ApiUtils.getNotesDaoInterface()

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
                        deleteNote()
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
                updateNote(note.note_id, lecture_name, note1.toInt(), note2.toInt())
                startActivity(Intent(this@DetailActivity, MainActivity :: class.java))
                finish()
                return true
            }
            else -> return false
        }
        return super.onOptionsItemSelected(item)
    }
    fun deleteNote(){
        ndi.delete(note.note_id).enqueue(object : Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }
    fun updateNote(note_id : Int, lecture_name : String, note1: Int, note2: Int){
        ndi.update(note_id, lecture_name,note1,note2).enqueue(object : retrofit2.Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {

            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {

            }

        })
    }

}