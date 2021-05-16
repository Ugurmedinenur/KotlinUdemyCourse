package com.example.phonebookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , SearchView.OnQueryTextListener{

    private lateinit var personList: ArrayList<Person>
    private lateinit var personAdapter: PersonAdapter
    private lateinit var vt:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Kişiler Uygulaması"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        personList = ArrayList()
        vt = DatabaseHelper(this)

        getAllPeople()

        fab.setOnClickListener {

            alertShow()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu?.findItem(R.id.action_search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    fun alertShow(){
        val design = LayoutInflater.from(this).inflate(R.layout.alert_design,null)
        val editTextName = design.findViewById(R.id.editTextName) as EditText
        val editTextPhone = design.findViewById(R.id.editTextPhone) as EditText

        val ad = AlertDialog.Builder(this)
        ad.setTitle("Kişi Ekle")
        ad.setView(design)
        ad.setPositiveButton("Ekle"){dialogInterface, i->

            val person_name = editTextName.text.toString().trim()
            val person_phone = editTextPhone.text.toString().trim()

            PersonDao().addPerson(vt,person_name,person_phone)
            getAllPeople()


        }
        ad.setNegativeButton("İptal"){dialogInterface, i->


        }

        ad.create().show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            search(query)
            Log.e("Gönderilen arama",query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            search(newText)
            Log.e("Harf gitdikçe",newText)
        }
        return true
    }

    fun getAllPeople(){
        personList = PersonDao().allPeople(vt)

        personAdapter = PersonAdapter(this,personList,vt)
        rv.adapter = personAdapter
    }

    fun search(key:String){
        personList = PersonDao().searchPerson(vt,key)

        personAdapter = PersonAdapter(this,personList,vt)
        rv.adapter = personAdapter
    }
}