package com.example.banneradd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}

        val adRequest = AdRequest.Builder().build()

        banner.loadAd(adRequest)

        banner.adListener = object : AdListener(){
            override fun onAdLoaded() {
                Log.e("Banner","yüklendi")
            }

            override fun onAdFailedToLoad(p0: LoadAdError?) {
                Log.e("Banner","yüklenemedi")
            }

            override fun onAdOpened() {
                Log.e("Banner","ad açıldı")
            }

            override fun onAdLeftApplication() {
                Log.e("Banner","açıldı")
            }

            override fun onAdClosed() {
                Log.e("Banner","kapandı")
            }
        }
    }
}