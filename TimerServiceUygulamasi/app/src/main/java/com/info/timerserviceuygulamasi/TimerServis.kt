package com.info.timerserviceuygulamasi

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.widget.Toast

class TimerServis : Service() {

    private lateinit  var handler:Handler

    private val thread = object : Runnable{

        override fun run() {
            Toast.makeText(this@TimerServis,"Servis Çalışmaya Devam Ediyor",Toast.LENGTH_SHORT).show()

            this@TimerServis.handler.postDelayed(this,5000)
        }

    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        handler = Handler()

        handler.postDelayed(thread,5000)

        Toast.makeText(this,"Servis Çalışmaya Başladı",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {

        handler.removeCallbacks(thread)

        Toast.makeText(this,"Servis Durdu",Toast.LENGTH_SHORT).show()

    }
}