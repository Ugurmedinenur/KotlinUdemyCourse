package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var noteList: ArrayList<Notes>
    private lateinit var notlarAdapter: NotlarAdapter
    private lateinit var refNotes: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Notlar Uygulaması"

        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        val db = FirebaseDatabase.getInstance()
        refNotes = db.getReference("notlar")

        noteList = ArrayList()
        notlarAdapter = NotlarAdapter(this, noteList)

        rv.adapter = notlarAdapter
        allNotes()

        fab.setOnClickListener {

            startActivity(Intent(this@MainActivity, NoteRecordActivity :: class.java))

        }
    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    fun allNotes(){
        refNotes.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                noteList.clear()

                var sum = 0
                for (c in snapshot.children){
                    val note = c.getValue(Notes :: class.java)
                    if(note!= null){
                        note.not_id = c.key
                        noteList.add(note)
                        sum += (note.not1!! + note.not2!!)/2
                    }
                }
                notlarAdapter.notifyDataSetChanged()
                if(sum != 0){
                    toolbar.subtitle = "Ortalama : ${sum/noteList.size}"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        } )
    }
}