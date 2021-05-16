package com.example.broadcastreceiverapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ChargeLevel : BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Şarjınız bitmek üzere",Toast.LENGTH_SHORT).show()
    }
}