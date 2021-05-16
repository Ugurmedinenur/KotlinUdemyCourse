package com.example.navigationdrawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_title.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var tempFragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Navigation Toolbar"
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, 0, 0)

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val title = navigationView.inflateHeaderView(R.layout.nav_title)
        title.textViewTitle.text = "Merhaba"

        supportFragmentManager.beginTransaction().add(R.id.fragmentTutucu, FragmentFirst()).commit()


        navigationView.setNavigationItemSelectedListener { menuItem->

            if(menuItem.itemId == R.id.nav_item_first){
                Toast.makeText(applicationContext,"BİRİNCİ",Toast.LENGTH_SHORT).show()
                tempFragment = FragmentFirst()

            }
            if(menuItem.itemId == R.id.nav_item_second){
                Toast.makeText(applicationContext,"İKİNCİ",Toast.LENGTH_SHORT).show()
                tempFragment = FragmentSecond()

            }
            if(menuItem.itemId == R.id.nav_item_third){
                Toast.makeText(applicationContext,"ÜÇÜNCÜ",Toast.LENGTH_SHORT).show()
                tempFragment = FragmentThird()

            }
            supportFragmentManager.beginTransaction().replace(R.id.fragmentTutucu, tempFragment).commit()
            drawer.closeDrawer(GravityCompat.START)
            true
        }


    }

    override fun onBackPressed() {

        if(drawer.isDrawerOpen(GravityCompat.START)){

            drawer.closeDrawer(GravityCompat.START)

        }
        else{

            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)

        }
    }
}