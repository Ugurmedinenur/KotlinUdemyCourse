package com.example.bottomnavigationvew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bottomnavigationvew.R.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var tempFragment:Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fragment_tutucu, FragmentFirst()).commit()

        bottom_navigation.setOnNavigationItemSelectedListener {menuItem->

            if(menuItem.itemId == R.id.action_first){
                Toast.makeText(applicationContext, "Birinci Tıklandı", Toast.LENGTH_SHORT).show()
                tempFragment = FragmentFirst()

            }
            if(menuItem.itemId == R.id.action_first){
                Toast.makeText(applicationContext, "Birinci Tıklandı", Toast.LENGTH_SHORT).show()
                tempFragment = FragmentSecond()

            }
            if(menuItem.itemId == R.id.action_first){
                Toast.makeText(applicationContext, "Birinci Tıklandı", Toast.LENGTH_SHORT).show()
                tempFragment = FragmentThird()

            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_tutucu, tempFragment).commit()
            true

        }

    }
}