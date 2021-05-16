package com.example.usingadmobexp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.ads.*
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private var puan = 10

    private lateinit var interstitial : InterstitialAd

    private lateinit var rewardedAd: RewardedAd
    private lateinit var loadListener : RewardedAdLoadCallback
    private lateinit var workingListener : RewardedAdCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        textViewPuan.text = "Toplam Puan : $puan"

        buttonPuanKazan.visibility = View.INVISIBLE

        MobileAds.initialize(this){}

        bannerLoad()
        intestitialLoad()
        rewardedLoad()

        buttonNextLevel.setOnClickListener {
            if(puan >= 30){
                if(interstitial.isLoaded){
                    interstitial.show()

                }
            }
            else{
                Toast.makeText(applicationContext
                    ,"Sonraki bölüm için 30 puan gereklidir."
                    ,Toast.LENGTH_LONG)
                    .show()

                buttonPuanKazan.visibility = View.VISIBLE
            }
            interstitial.adListener = object : AdListener(){
                override fun onAdClosed() {
                    startActivity(Intent(this@GameActivity,SecondLevelActivity :: class.java))
                    finish()
                }
            }

        }
        buttonPuanKazan.setOnClickListener {
            if(rewardedAd.isLoaded){
                rewardedAd.show(this@GameActivity,workingListener)
            }
        }
        workingListener = object : RewardedAdCallback() {
            override fun onUserEarnedReward(p0: RewardItem) {
                puan = puan+20
                textViewPuan.text = "Toplam Puan : $puan"
                buttonPuanKazan.visibility = View.INVISIBLE
            }

        }

    }

    fun bannerLoad(){
        banner.loadAd(AdRequest.Builder().build())
    }
    fun intestitialLoad(){
        interstitial = InterstitialAd(this)
        interstitial.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        interstitial.loadAd(AdRequest.Builder().build())
    }

    fun rewardedLoad(){
        rewardedAd = RewardedAd(this,"ca-app-pub-3940256099942544/5224354917")
        loadListener = object : RewardedAdLoadCallback(){
            override fun onRewardedAdLoaded() {
                Log.e("loadListener","onRewardedAdLoaded")
            }

            override fun onRewardedAdFailedToLoad(p0: LoadAdError?) {
                Log.e("loadListener","onRewardedAdFailedToLoad")
            }
        }
        rewardedAd.loadAd(AdRequest.Builder().build(),loadListener)
    }
}