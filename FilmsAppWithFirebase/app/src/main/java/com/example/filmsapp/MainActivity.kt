package com.example.filmsapp

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

    private lateinit var categoryList: ArrayList<Categories>
    private lateinit var categoryAdapter: CategoryAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarCategory.title = "Kategoriler"
        setSupportActionBar(toolbarCategory)

        categoryRv.setHasFixedSize(true)
        categoryRv.layoutManager = LinearLayoutManager(this)

        allCategories()


    }
    fun allCategories(){
        val url = "http://kasimadalan.pe.hu/filmler/tum_kategoriler.php"
        val request = StringRequest(Request.Method.GET, url, Response.Listener { response ->
            try {
                categoryList= ArrayList()

                val jsonObject = JSONObject(response)
                val categories = jsonObject.getJSONArray("kategoriler")
                for(i in 0 until categories.length()){
                    val k = categories.getJSONObject(i)
                    val category = Categories(k.getInt("kategori_id"), k.getString("kategori_ad"))
                    categoryList.add(category)
                }
                categoryAdapter = CategoryAdapter(this,categoryList)
                categoryRv.adapter = categoryAdapter


            }catch (e:Exception){
                e.printStackTrace()
            }
        },Response.ErrorListener {  })
        Volley.newRequestQueue(this@MainActivity).add(request)
    }


}