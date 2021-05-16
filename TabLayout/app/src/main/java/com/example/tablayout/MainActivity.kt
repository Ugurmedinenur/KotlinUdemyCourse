package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentList.add(FirstFragment())
        fragmentList.add(SecondFragment())
        fragmentList.add(ThirdFragment())

        val adapter = MyViewPagerAdapter(this)

        viewpager2.adapter = adapter

        fragmentTitleList.add("Bir")
        fragmentTitleList.add("İki")
        fragmentTitleList.add("Üç")

        TabLayoutMediator(tablayout, viewpager2) {tab, position ->

            tab.setText(fragmentTitleList[position])

        }.attach()

        tablayout.getTabAt(0)!!.setIcon(R.drawable.resim)
    }

    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {

            return fragmentList.size

        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }

    }
}