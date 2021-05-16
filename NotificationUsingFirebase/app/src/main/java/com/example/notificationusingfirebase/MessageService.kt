package com.example.notificationusingfirebase

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessageService : FirebaseMessagingService() {

    override fun onMessageReceived(rm: RemoteMessage) {
        super.onMessageReceived(rm)

        val title = rm.notification?.title
        val content = rm.notification?.body
        if (title != null) {
            Log.e("Başlık",title)
        }
        if (content != null) {
            Log.e("İçerik",content)
        }

        createNotification(title, content)
    }

    fun createNotification(title: String?, content:String?){

        val builder : NotificationCompat.Builder

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(this, MainActivity::class.java)

        val gettingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val canalId = "kanalId"
            val canalName = "kanalAd"
            val canalDescription = "Kanal Tanıtım"
            val canalPriority = NotificationManager.IMPORTANCE_HIGH

            var canal : NotificationChannel?= notificationManager.getNotificationChannel(canalId)

            if(canal == null){
                canal = NotificationChannel(canalId,canalName,canalPriority)
                canal.description = canalDescription

                notificationManager.createNotificationChannel(canal)
            }

            builder = NotificationCompat.Builder(this,canalId)

            builder.setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.resim)
                .setContentIntent(gettingIntent)
                .setAutoCancel(true)
                .priority = Notification.PRIORITY_HIGH

        }else{

            builder = NotificationCompat.Builder(this)

            builder.setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.resim)
                .setContentIntent(gettingIntent)
                .setAutoCancel(true)
                .priority = Notification.PRIORITY_HIGH
        }

        notificationManager.notify(1,builder.build())


    }
}