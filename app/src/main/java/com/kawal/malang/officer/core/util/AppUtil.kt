package com.kawal.malang.officer.core.util

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Looper
import android.provider.Settings
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.kawal.malang.officer.R
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import com.kawal.malang.officer.core.util.Util.capitalizeWords
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object AppUtil {

    var STATUS_BARU ="baru"
    var STATUS_DITANGANI ="ditangani"
    var STATUS_SELESAI ="selesai"
    var STATUS_DITOLAK ="ditolak"
    var STATUS = arrayListOf<String>(STATUS_BARU,STATUS_DITANGANI,STATUS_SELESAI,STATUS_DITOLAK)

    fun TextView.setStatus(context: Context, status:String?) = run {
        when(status?.lowercase()){
            STATUS_BARU->{
                this.background.setTint(ContextCompat.getColor(context, R.color.secondary_blue_surface))
                this.setTextColor(ContextCompat.getColor(context, R.color.secondary_blue_main))
            }
//            STATUS_PROSES->{
//                background.setTint(ContextCompat.getColor(context, R.color.secondary_orange_surface))
//                setTextColor(ContextCompat.getColor(context, R.color.secondary_orange_main))
//            }
            STATUS_DITANGANI->{
                this.background.setTint(ContextCompat.getColor(context, R.color.secondary_orange_surface))
                this.setTextColor(ContextCompat.getColor(context, R.color.secondary_orange_main))
            }
            STATUS_SELESAI->{
                this.background.setTint(ContextCompat.getColor(context, R.color.secondary_green_surface))
                this.setTextColor(ContextCompat.getColor(context, R.color.secondary_green_main))
            }
            STATUS_DITOLAK->{
                this.background.setTint(ContextCompat.getColor(context, R.color.primary_surface))
                this.setTextColor(ContextCompat.getColor(context, R.color.primary_main))
            }

            else-> {
                this.background.setTint(ContextCompat.getColor(context, R.color.grey4))
            }
        }
        this.text=status?.capitalizeWords()
    }

    fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return true
            }
            return if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                true
            } else capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
        }
        return false
    }

    fun errorMessage(errorBody: String?): String? {
        return try {
            val errBody = JSONObject(errorBody ?: "Undefined")
            errBody.getString("message")
        } catch (e: JSONException) {
            e.printStackTrace()
            "Something went wrong"
        }
    }

    fun convertDateTime(dateTime: String?): String? {
        /**
         * Available parse format:
         * yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
         * yyyy-MM-dd HH:mm:ss
         * Fill another format here
         * ============================================
         * Available returned format:
         * EEEE, d MMMM yyyy
         * d MMMM yyyy
         * Fill another returned format here
         */
        @SuppressLint("SimpleDateFormat") val sdf =
            SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return try {
            val dt = sdf.parse(dateTime)
            sdf.timeZone = TimeZone.getDefault()
            @SuppressLint("SimpleDateFormat") val formatDate = SimpleDateFormat("EEEE, d MMMM yyyy")
            val a = formatDate.format(dt)
            @SuppressLint("SimpleDateFormat") val formatTime = SimpleDateFormat("HH:mm")
            val b = formatTime.format(dt)
            "$a $b"
        } catch (e: ParseException) {
            e.printStackTrace()
            "Undefined Date"
        }
    }

    fun convertToTime(dateTime: String?): String {
        @SuppressLint("SimpleDateFormat") val sdf =
            SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return try {
            val dt = sdf.parse(dateTime)
            sdf.timeZone = TimeZone.getDefault()
            @SuppressLint("SimpleDateFormat") val formatDate = SimpleDateFormat("HH:mm")
            val a = formatDate.format(dt)
            a
        } catch (e: ParseException) {
            e.printStackTrace()
            "Undefined Date"
        }
    }

    private fun checkLocationPermission(context: Context): Boolean {
        return (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED)
    }

    fun requestPermissions(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity, arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ), 100
        )
    }

    fun getLastLocation(context: Context, loc: ((Double, Double) -> Unit), askPermission: (() -> Unit)) {
        if (checkLocationPermission(context)) {
            if (isLocationEnabled(context)) {
                requestNewLocationData(context, loc)
            } else {
                Toast.makeText(
                    context, "Turn on your location",
                    Toast.LENGTH_LONG
                ).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                context.startActivity(intent)
            }
        } else {
            askPermission()
        }
    }

    private fun isLocationEnabled(context: Context): Boolean {
        val locationManager: LocationManager? = context.getSystemService(Context.LOCATION_SERVICE)
                as LocationManager?
        return (locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER)!! ||
            locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
    }

    @SuppressLint("MissingPermission")
    fun requestNewLocationData(context: Context, loc: ((Double, Double) -> Unit)) {
        val mLocationRequest = LocationRequest.create()
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
            .setInterval(5)
            .setFastestInterval(0)
            .setNumUpdates(1)
        val fused = LocationServices.getFusedLocationProviderClient(context)
        val mLocationCallback: LocationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                val mLastLocation = locationResult.lastLocation
                loc(mLastLocation.latitude, mLastLocation.longitude)
            }
        }
        Looper.myLooper()
            ?.let { fused.requestLocationUpdates(mLocationRequest, mLocationCallback, it) }
    }

    fun reportStatus(): ArrayList<String> = arrayListOf("Baru", "Proses", "Selesai", "Ditolak")

    fun loading(context: Context): Dialog {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_layout)
        return dialog
    }

    fun snackBar(activity: Activity, message: String, isError: Boolean = true) {
        val parentLayout = activity.findViewById<View>(android.R.id.content)
        Snackbar.make(parentLayout, message, Snackbar.LENGTH_LONG)
            .setBackgroundTint(ContextCompat.getColor(activity, if (isError) R.color.red_base
            else R.color.black))
            .show()
    }

    fun snackBarAction(activity: Activity, message: String, action: String, listener: ((View) -> Unit)) {
        val parentLayout = activity.findViewById<View>(android.R.id.content)
        Snackbar.make(parentLayout, message, Snackbar.LENGTH_LONG)
            .setBackgroundTint(ContextCompat.getColor(activity, R.color.red_base))
            .setAction(action, listener)
            .show()
    }

    fun reverseGeocode(lat: Double, lng: Double, context: Context): String {
        val geocoder = Geocoder(context)
        val address: String
        try {
            val addressList = geocoder.getFromLocation(lat, lng, 5)
            address = addressList?.get(0)?.getAddressLine(0) ?: ""
        } catch (e: IOException) {
            e.printStackTrace()
            return "Undefined"
        }
        return address
    }
}