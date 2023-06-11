package com.kawal.malang.officer.core.util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentResolver
import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.kawal.malang.officer.R
import com.google.firebase.messaging.RemoteMessage


class NotificationHelper {

    fun displayNotificationWithSound(context: Context, remoteMessage: RemoteMessage, intent: PendingIntent) {
        val CHANNEL_ID="TYPE_01"

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as (NotificationManager)
        val soundUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://${context.packageName}/${R.raw.sirine}")
        val audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_ALARM)
            .build()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                CHANNEL_ID,
                "Panic Notification",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "Notifikasi yang ditampilkan jika ada kegiatan Panic Button"
            channel.enableVibration(true)
            channel.enableLights(true)
            channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            channel.setSound(soundUri, audioAttributes)

            notificationManager.createNotificationChannel(channel)
            val manager = ContextCompat.getSystemService(context, NotificationManager::class.java)
            manager?.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification_tray)
            .setContentTitle(remoteMessage.data["title"])
            .setContentText(remoteMessage.data["body"])
            .setContentIntent(intent)
            .setSound(soundUri)
            .setWhen(System.currentTimeMillis())

        val media = MediaPlayer.create(context, R.raw.sirine)
        media.isLooping = true
        media.start()
        notificationManager.notify(1, builder.build())
    }

    fun displayNotification(id: Int, context: Context, remoteMessage: RemoteMessage, intent: PendingIntent) {
        val CHANNEL_ID="TYPE_LAYANAN"
        val defaultSoundUri =
            RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification_tray)
            .setContentTitle(remoteMessage.data["title"])
            .setContentText(remoteMessage.data["body"])
            .setContentIntent(intent)
            .setSound(defaultSoundUri)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Notifikasi Layanan",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "Notifikasi untuk Layanan"
            channel.enableVibration(true)
            channel.enableLights(true)
            channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            val manager = ContextCompat.getSystemService(context, NotificationManager::class.java)
            manager?.createNotificationChannel(channel)
        }

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(id, builder.build())
    }

}