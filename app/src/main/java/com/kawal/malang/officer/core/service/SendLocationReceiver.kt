package com.kawal.malang.officer.core.service

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.kawal.malang.officer.BuildConfig
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.core.util.AppUtil
import com.kawal.malang.officer.data.api.ApiService
import com.kawal.malang.officer.data.model.patrol.history.LocationHistoryData
import com.kawal.malang.officer.presentation.MainActivity
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class SendLocationService: Service() {

    private val serviceJob = Job()
    private val serviceScope = CoroutineScope(Dispatchers.Main + serviceJob)
    private var lat: Double? = 0.0
    private var lng: Double? = 0.0
    private var isRunning = false

    override fun onBind(p0: Intent?): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showNotification()
        requestLocation()
        isRunning = true
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        val nManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nManager.cancel(5)
        serviceJob.cancel()
        isRunning = false
        Log.d("SendLocationService", "Service is destroyed")
    }

    fun isRunning(): Boolean = isRunning

    @SuppressLint("UnspecifiedImmutableFlag")
    private fun showNotification() {
        val intent = Intent(this@SendLocationService, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this@SendLocationService, 100,
            intent, PendingIntent.FLAG_CANCEL_CURRENT)
        val builder = NotificationCompat.Builder(this@SendLocationService, "CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_notification_tray)
            .setContentTitle("Status Patroli")
            .setContentText("Mobil sedang berpatroli")
            .setContentIntent(pendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "CHANNEL_ID",
                "Notifikasi Layanan",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "Patrol notification used for officer while patrolling"
            channel.enableVibration(true)
            channel.enableLights(true)
            channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            val manager = ContextCompat.getSystemService(this@SendLocationService, NotificationManager::class.java)
            manager?.createNotificationChannel(channel)
        }

        val notificationManager = NotificationManagerCompat.from(this@SendLocationService)
        builder.setOngoing(true)
        notificationManager.notify(5, builder.build())
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    private fun showSwipedNotification(data: LocationHistoryData) {
        val intent = Intent(this@SendLocationService, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this@SendLocationService, 100,
            intent, PendingIntent.FLAG_CANCEL_CURRENT)
        val builder = NotificationCompat.Builder(this@SendLocationService, "CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_notification_tray)
            .setContentTitle("Status Patroli")
            .setContentText("Lat: ${data.latitude}, Lng: ${data.longitude}")
            .setContentIntent(pendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "CHANNEL_ID",
                "Notifikasi Layanan",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "Notifikasi untuk Layanan"
            channel.enableVibration(true)
            channel.enableLights(true)
            channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            val manager = ContextCompat.getSystemService(this@SendLocationService, NotificationManager::class.java)
            manager?.createNotificationChannel(channel)
        }

        val notificationManager = NotificationManagerCompat.from(this@SendLocationService)
        notificationManager.notify(1000, builder.build())
    }

    private fun requestLocation() {
        val body = hashMapOf<String, String>()
        serviceScope.launch {
            while (true) {
                AppUtil.getLastLocation(this@SendLocationService, { latitude, longitude ->
                    lat = latitude
                    lng = longitude
                    body["latitude"] = "$lat"
                    body["longitude"] = "$lng"
                    serviceScope.launch {
                        val client = provideRetrofit().create(ApiService::class.java)
                        val a = client.recordCarPosition(AppPreference(this@SendLocationService).getAuth(), body)
                        a.body()?.data?.let { showSwipedNotification(it) }
                    }
                }, {  }
                )
                delay(5000)
                Log.d("SendLocationService", "Service is running")
            }
        }
    }

    private fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
    }
}