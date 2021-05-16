package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var noteList: ArrayList<Notes>
    private lateinit var notlarAdapter: NotlarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Notlar Uygulaması"

        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        noteList = ArrayList()

        getAll()

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

    fun getAll(){
        val url = "http://kasimadalan.pe.hu/notlar/tum_notlar.php"
        val request = StringRequest(Request.Method.GET, url, Response.Listener { response ->

            try {

                var sum = 0

                val jsonObject = JSONObject(response)
                val notes = jsonObject.getJSONArray("notlar")

                for(i in 0 until notes.length()){

                    val n = notes.getJSONObject(i)
                    val not1 = n.getInt("not1")
                    val not2 = n.getInt("not2")

                    val not = Notes(n.getInt("not_id")
                            , n.getString("ders_adi")
                            , not1
                            , not2)

                    noteList.add(not)
                    sum = sum + (not1 + not2)/2

                    if(sum != 0){
                        toolbar.subtitle = "Ortalama : ${sum/noteList.size}"
                    }

                }

                notlarAdapter = NotlarAdapter(this, noteList)

                rv.adapter = notlarAdapter

            }catch (e:Exception){
                e.printStackTrace()
            }

        },Response.ErrorListener {  })
        Volley.newRequestQueue(this@MainActivity).add(request)
    }
}