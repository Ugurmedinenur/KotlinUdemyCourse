package com.example.filmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_films.*
import kotlinx.android.synthetic.main.activity_main.*

class FilmsActivity : AppCompatActivity() {

    private lateinit var filmList: ArrayList<Films>
    private lateinit var filmAdapter: FilmAdapter

    private lateinit var vt:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)

        val category = intent.getSerializableExtra("category") as Categories

        toolbarFilms.title = "Filmler : ${category.category_name}"
        setSupportActionBar(toolbarCategory)

        filmsRv.setHasFixedSize(true)
        filmsRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        filmList= ArrayList()
        vt = DatabaseHelper(this)

        filmList = FilmsDao().getFilmByCategory(vt, category.category_id)
        filmAdapter = FilmAdapter(this,filmList)
        filmsRv.adapter = filmAdapter


    }
}