package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var countriesList:ArrayList<Countries>
    private lateinit var adapter: RVAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this) //Linear Layout dersek alt alta sıralanır
        //rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL) // bunda ise dikey de scroll edilebiliyor
        //rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL) // bunda ise Yatayda de scroll edilebiliyor //İnstagram hikayeleri bu kullanılarak yapılıyor.

        val u1 = Countries(1, "Türkiye")
        val u2 = Countries(2, "Rusya")
        val u3 = Countries(3, "İngiltere")
        val u4 = Countries(4, "Fransa")

        countriesList = ArrayList<Countries>()

        countriesList.add(u1)
        countriesList.add(u2)
        countriesList.add(u3)
        countriesList.add(u4)

        adapter = RVAdapter(this, countriesList)

        rv.adapter = adapter
    }
}