package com.kawal.malang.officer.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.presentation.auth.login.LoginActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.microsoft.appcenter.distribute.Distribute

class MainActivity : AppCompatActivity() {
    lateinit var appPreference: AppPreference
    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        appPreference = AppPreference(this)
        AppCenter.start(
            application, "853dedba-2f8f-447b-8e2c-e230a799670c",
            Analytics::class.java, Crashes::class.java, Distribute::class.java
        )

        if (appPreference.getAuth() == "") {
            val mainIntent = Intent(this, LoginActivity::class.java)
            startActivity(mainIntent)
            overridePendingTransition(0, 0)
            finish()
        } else {
            val mainIntent = Intent(this, DashboardActivity::class.java)
            startActivity(mainIntent)
            overridePendingTransition(0, 0)
            finish()
        }
    }
}