package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var notlarAdapter: NotlarAdapter
    private lateinit var ndi : NotesDaoInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Notlar Uygulaması"

        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)


        ndi = ApiUtils.getNotesDaoInterface()

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
        ndi.getAll().enqueue(object : Callback<NotesResponse>{
            override fun onResponse(
                call: Call<NotesResponse>?,
                response: Response<NotesResponse>?
            ) {
                if(response != null){
                    val noteList = response.body().notes

                    notlarAdapter = NotlarAdapter(this@MainActivity, noteList)

                    rv.adapter = notlarAdapter

                    var sum = 0

                    for(i in noteList){
                        sum = sum + (i.note1 + i.note2)/2
                    }

                    if(sum != 0 ){
                        toolbar.subtitle = "Ortalama : ${sum/noteList.size}"
                    }
                }


            }

            override fun onFailure(call: Call<NotesResponse>?, t: Throwable?) {

            }

        })
    }
}