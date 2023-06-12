package com.kawal.malang.officer.core.service

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.util.Log
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.NotificationHelper
import com.kawal.malang.officer.presentation.report.detail.DetailReportActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.json.JSONObject

class MyFirebaseMessagingService : FirebaseMessagingService() {

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d("Payload", "${remoteMessage.data}")
        val intent = Intent(applicationContext, DetailReportActivity::class.java)
        val json = JSONObject(remoteMessage.data["data"] ?: "Empty")
        intent.putExtra(DetailReportActivity.ID, json.getString("id").toInt())
        val pendingIntent = PendingIntent.getActivity(applicationContext, 100,
            intent, PendingIntent.FLAG_IMMUTABLE)
        NotificationHelper().displayNotificationWithSound(applicationContext, remoteMessage, pendingIntent)

    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        val pref = AppPreference(applicationContext)
        pref.setFcmToken(token)
    }
}