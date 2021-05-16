package com.example.filmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_films.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class FilmsActivity : AppCompatActivity() {

    private lateinit var filmList: ArrayList<Films>
    private lateinit var filmAdapter: FilmAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)

        val category = intent.getSerializableExtra("category") as Categories

        toolbarFilms.title = "Filmler : ${category.category_name}"
        setSupportActionBar(toolbarCategory)

        filmsRv.setHasFixedSize(true)
        filmsRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        filmList= ArrayList()

        allFilms(category.category_id)


    }
    fun allFilms(category_id : Int){
        val url = "http://kasimadalan.pe.hu/filmler/tum_filmler.php"
        val request = object : StringRequest( Method.POST, url, Response.Listener { response ->
            try {
                filmList= ArrayList()

                val jsonObject = JSONObject(response)
                val films = jsonObject.getJSONArray("filmler")

                for(i in 0 until films.length()){
                    val f = films.getJSONObject(i)
                    val c = f.getJSONObject("kategori")
                    val category = Categories(c.getInt("kategori_id"), c.getString("kategori_ad"))
                    val y = f.getJSONObject("yonetmen")

                    val yonetmen = Directors(y.getInt("yonetmen_id"), y.getString("yonetmen_ad"))

                    val film = Films(f.getInt("film_id"), f.getString("film_ad"), f.getInt("film_yil"), f.getString("film_resim"),category,yonetmen)

                    filmList.add(film)
                }
                filmAdapter = FilmAdapter(this,filmList)
                categoryRv.adapter = filmAdapter


            }catch (e:Exception){

                e.printStackTrace()
            }
        }, Response.ErrorListener {  }){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["kategori_id"] = category_id.toString()
                return params
            }
        }
        Volley.newRequestQueue(this@FilmsActivity).add(request)
    }



}