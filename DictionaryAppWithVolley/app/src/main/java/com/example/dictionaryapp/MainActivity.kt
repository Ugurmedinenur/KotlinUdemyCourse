package com.example.dictionaryappwithvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var wordList: ArrayList<Words>
    private lateinit var adapter: WordsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Sözlük Uygulaması"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)


        allWords()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu?.findItem(R.id.action_search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            searchWord(query)
            Log.e("Gönderilen query",query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            searchWord(newText)
            Log.e("Harf Girdikçe", newText)
        }
        return true
    }




    fun allWords(){

        val url = "http://kasimadalan.pe.hu/sozluk/tum_kelimeler.php"

        val request = StringRequest(Request.Method.GET, url, Response.Listener{ response->
            wordList = ArrayList()

            Log.e("Veri okuma Cevap",response)

            try {
                val jsonObject = JSONObject(response)
                val words = jsonObject.getJSONArray("kelimeler")

                for (i in 0 until words.length()){
                    val k = words.getJSONObject(i)
                    val word = Words(k.getInt("kelime_id")
                        , k.getString("ingilizce")
                        , k.getString("ingilizce"))
                    wordList.add(word)

                }
                adapter = WordsAdapter(this@MainActivity, wordList)
                rv.adapter = adapter

            }catch (e: JSONException){
                e.printStackTrace()
            }

        }, Response.ErrorListener{ error ->

            error.printStackTrace()

        })


        Volley.newRequestQueue(this@MainActivity).add(request)
    }
    fun searchWord(key:String){

        val url = "http://kasimadalan.pe.hu/sozluk/kelime_ara.php"

        val request = object : StringRequest(Method.POST, url, Response.Listener{ response->
            wordList = ArrayList()

            Log.e("Veri okuma Cevap",response)

            try {
                val jsonObject = JSONObject(response)
                val words = jsonObject.getJSONArray("kelimeler")

                for (i in 0 until words.length()){
                    val k = words.getJSONObject(i)
                    val word = Words(k.getInt("kelime_id")
                        , k.getString("ingilizce")
                        , k.getString("ingilizce"))
                    wordList.add(word)

                }
                adapter = WordsAdapter(this@MainActivity, wordList)
                rv.adapter = adapter

            }catch (e: JSONException){
                e.printStackTrace()
            }

        }, Response.ErrorListener{ error ->

            error.printStackTrace()

        }){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String,String>()
                params["ingilizce"] = key
                return params
            }
        }


        Volley.newRequestQueue(this@MainActivity).add(request)
    }


}