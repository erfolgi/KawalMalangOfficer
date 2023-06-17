package com.kawal.malang.officer.core.service.prototype

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import android.os.HandlerThread
import java.util.*


class LocationService : Service() {
    var counter = 0
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    private val TAG = "LocationServiceX"

    private val SECOND = TAG+"TimeOfLocationServiceS"
    private val MINUTE = TAG+"TimeOfLocationServiceM"
    private val HOUR = TAG+"TimeOfLocationServiceH"
    var id =0;
    var auth=""
    var presenter=LocationPresenter()

    var client: FusedLocationProviderClient? = null

    companion object{
        var STARTFOREGROUND_ACTION= "com.kawal.malang.officer.core.service.start"
        var STOPFOREGROUND_ACTION= "com.kawal.malang.officer.core.service.stop"
    }
    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) createNotificationChanel() else startForeground(
            1,
            Notification()
        )
        Log.d("${TAG}"," Creatingg...")
        client = LocationServices.getFusedLocationProviderClient(this)
        requestLocationUpdates()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChanel() {
        val NOTIFICATION_CHANNEL_ID = "com.getlocationbackground"
        val channelName = "Background Service"
        val chan = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            channelName,
            NotificationManager.IMPORTANCE_NONE
        )
        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val manager =
            (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
        manager.createNotificationChannel(chan)
        val notificationBuilder =
            NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
        val notification: Notification = notificationBuilder.setOngoing(true)
            .setContentTitle("Status Petugas")
            .setContentText("Petugas sedang menangani Panic")
            .setPriority(NotificationManager.IMPORTANCE_MIN)
            .setSmallIcon(com.kawal.malang.officer.R.mipmap.ic_notification_grey)
            .setCategory(Notification.CATEGORY_SERVICE)
            .build()
        startForeground(2, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        if (intent?.action.equals(STARTFOREGROUND_ACTION)) {
            startTimer()
           // id = intent?.getIntExtra("EXTRA_PANIC_ID",0) ?:0
            auth= intent?.getStringExtra("AUTH").toString()
            Log.d("${TAG}","Starting Command...")
        }else if(intent?.action.equals(STOPFOREGROUND_ACTION)){
            Log.d("${TAG}","Service Stopped...")
            stopForeground(true);
            stopSelfResult(startId);
            timer?.cancel();
            timer?.purge();
            client?.removeLocationUpdates(mLocationCallback)
        }
        return START_STICKY
    }

    private var timer: Timer? = null
    private var timerTask: TimerTask? = null
    fun startTimer() {
        timer = Timer()

        timerTask = object : TimerTask() {
            override fun run() {
                var count = counter++
                if (latitude != 0.0 && longitude != 0.0) {
                    if(count%60==0){
                        Log.d(
                            MINUTE,"Service has been started for ${count/60} minutes"
                        )
                    }
                    if (count%3600==0){
                            Log.d(
                                HOUR,"Service has been started for ${count/360} hours"
                            )
                    }

                    Log.d(
                        SECOND,"Service has been started for ${count} seconds"
                    )
                }
            }
        }
        timer!!.schedule(
            timerTask,
            0,
            1000
        ) //1 * 60 * 1000 1 minute
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun requestLocationUpdates() {
        val request = LocationRequest.create().apply {
            interval = 5000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        val permission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        val handlerThread = HandlerThread("handlerthread")
        handlerThread.start()
        if (permission == PackageManager.PERMISSION_GRANTED) { // Request location updates and when an update is
            // received, store the location in Firebase
            client?.requestLocationUpdates(request, mLocationCallback,handlerThread.looper)
        }
    }

    var mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            val location: Location = locationResult.lastLocation
            if (location != null) {
                latitude = location.latitude
                longitude = location.longitude
                Log.d( TAG,"Location Service: location update $location")

                presenter.postUpdateLokasi(auth,latitude,longitude)
            }
        }
    }
}