package com.example.rewardedad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mRewardedAd: RewardedAd
    private lateinit var loadListener: RewardedAdLoadCallback
    private lateinit var workingListener: RewardedAdCallback
    private final var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this){}

        loadAd()
        listenAd()

        buttonShow.setOnClickListener {
            if(mRewardedAd.isLoaded){
                mRewardedAd.show(this@MainActivity,workingListener)
            }else{
                Log.e("loadAdListener","reklam yüklenmedi")

            }
        }

    }
    fun loadAd(){
        mRewardedAd = RewardedAd(this, "ca-app-pub-3940256099942544/5224354917")

        loadListener = object : RewardedAdLoadCallback(){
            override fun onRewardedAdLoaded() {
                Log.e("loadAdListener","onRewardedAdLoaded")

            }

            override fun onRewardedAdFailedToLoad(p0: LoadAdError?) {
                Log.e("loadAdListener","onRewardedAdFailedToLoad")
            }
        }
        mRewardedAd.loadAd(AdRequest.Builder().build(), loadListener)
    }
    fun listenAd(){

        workingListener = object : RewardedAdCallback(){
            override fun onUserEarnedReward(p0: RewardItem) {
                Log.e("workingListener","onUserEarnedReward")
            }

            override fun onRewardedAdOpened() {
                Log.e("workingListener","onRewardedAdOpened")
            }

            override fun onRewardedAdClosed() {
                Log.e("workingListener","onRewardedAdClosed")
                loadAd()
            }

        }

    }

}