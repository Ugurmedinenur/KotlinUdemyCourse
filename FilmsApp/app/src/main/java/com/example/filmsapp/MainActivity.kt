package com.example.filmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var categoryList: ArrayList<Categories>
    private lateinit var categoryAdapter: CategoryAdapter

    private lateinit var vt:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        copyDatabase()

        toolbarCategory.title = "Kategoriler"
        setSupportActionBar(toolbarCategory)

        categoryRv.setHasFixedSize(true)
        categoryRv.layoutManager = LinearLayoutManager(this)

        categoryList= ArrayList()

        vt = DatabaseHelper(this)

        categoryList = CategoriesDao().allCategories(vt)

        categoryAdapter = CategoryAdapter(this,categoryList)
        categoryRv.adapter = categoryAdapter



    }

    fun copyDatabase(){

       val copyHelper = DatabaseCopyHelper(this)

        try {

            copyHelper.createDataBase()
            copyHelper.openDataBase()

        }catch (e:Exception){
            e.printStackTrace()
        }

    }
}