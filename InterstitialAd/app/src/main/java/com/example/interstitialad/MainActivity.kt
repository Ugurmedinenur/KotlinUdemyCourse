package com.example.interstitialad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this){}

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        ButtonShow.setOnClickListener {
            if(mInterstitialAd.isLoaded){
                mInterstitialAd.show()
            }else{
                Log.e("add", "yüklenmedi")
            }
        }

        mInterstitialAd.adListener = object : AdListener(){
            override fun onAdLoaded() {
                Log.e("Interstitial","Yüklendi")
            }

            override fun onAdFailedToLoad(p0: LoadAdError?) {
                Log.e("onAdFailedToLoad","çalıştı")
            }

            override fun onAdOpened() {
                Log.e("onAdOpened","çalıştı")
            }

            override fun onAdClosed() {
                Log.e("onAdClosed","çalıştı")
                mInterstitialAd.loadAd(AdRequest.Builder().build())

            }
        }

    }
}