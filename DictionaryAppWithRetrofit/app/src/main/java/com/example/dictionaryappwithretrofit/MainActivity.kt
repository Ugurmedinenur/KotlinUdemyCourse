package com.example.dictionaryappwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var adapter: WordsAdapter
    private lateinit var kdi: WordsDaoInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Sözlük Uygulaması"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        kdi = ApiUtils.getWordsDaoInterface()
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
        kdi.allWords().enqueue(object : Callback<WordsResponse>{

            override fun onResponse(call: Call<WordsResponse>?, response: Response<WordsResponse>?) {

                if (response != null){
                    var list = response.body().wordsList
                    adapter = WordsAdapter(this@MainActivity, list)
                    rv.adapter = adapter
                }

            }

            override fun onFailure(call: Call<WordsResponse>?, t: Throwable?) {

            }

        })
    }

    fun searchWord(key : String){
        kdi.searchWord(key).enqueue(object : Callback<WordsResponse>{

            override fun onResponse(call: Call<WordsResponse>?, response: Response<WordsResponse>?) {

                if (response != null){
                    var list = response.body().wordsList
                    adapter = WordsAdapter(this@MainActivity, list)
                    rv.adapter = adapter
                }

            }

            override fun onFailure(call: Call<WordsResponse>?, t: Throwable?) {

            }

        })
    }


}