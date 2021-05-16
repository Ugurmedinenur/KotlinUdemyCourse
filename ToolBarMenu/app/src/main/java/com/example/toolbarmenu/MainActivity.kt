package com.example.toolbarmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "ToolBar Menu"
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.toolbar_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_info ->{
                Toast.makeText(applicationContext, "Bilgi TIklandı", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_settings ->{
                Toast.makeText(applicationContext, "Ayarlar TIklandı", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_add->{
                Toast.makeText(applicationContext, "Ekle TIklandı", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_logout ->{
                Toast.makeText(applicationContext, "Çıkış tıklandı ", Toast.LENGTH_SHORT).show()
                return true
            }
            else ->{
                return super.onOptionsItemSelected(item)
            }
        }

    }
}