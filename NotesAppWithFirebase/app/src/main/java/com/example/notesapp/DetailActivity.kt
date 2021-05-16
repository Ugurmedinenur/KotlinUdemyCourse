package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_note_record.*

class DetailActivity : AppCompatActivity() {

    private  lateinit var note: Notes
    private lateinit var refNotes: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        toolbarNoteDetail.title = "Not Detay"
        setSupportActionBar(toolbarNoteDetail)

        note = intent.getSerializableExtra("nesne") as Notes

        editTextLectureDetail.setText(note.ders_adi)
        editTextNote1Detail.setText((note.not1).toString())
        editTextNote2Detail.setText((note.not2).toString())

        val db = FirebaseDatabase.getInstance()
        refNotes = db.getReference("notlar")

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

                        refNotes.child(note.not_id!!).removeValue()

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

                val info = HashMap<String, Any>()
                info.put("ders_adi",lecture_name)
                info.put("not1",note1.toInt())
                info.put("not2",note2.toInt())

                refNotes.child(note.not_id!!).updateChildren(info)

                startActivity(Intent(this@DetailActivity, MainActivity :: class.java))
                finish()
                return true
            }
            else -> return false
        }
        return super.onOptionsItemSelected(item)
    }

}