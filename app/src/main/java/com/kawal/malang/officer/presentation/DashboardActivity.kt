package com.kawal.malang.officer.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.kawal.malang.officer.R
import com.kawal.malang.officer.core.service.SendLocationService
import com.kawal.malang.officer.core.service.prototype.LocationService
import com.kawal.malang.officer.core.service.prototype.LocationService.Companion.STARTFOREGROUND_ACTION
import com.kawal.malang.officer.core.util.AppPreference
import com.kawal.malang.officer.databinding.ActivityDashboardBinding
import com.kawal.malang.officer.databinding.ActivityOfficerBinding
import com.microsoft.appcenter.distribute.Distribute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var bindingOfficer: ActivityOfficerBinding
    private lateinit var preference: AppPreference
    private lateinit var locService: SendLocationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(
            this, android.R.color.transparent)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        bindingOfficer = ActivityOfficerBinding.inflate(layoutInflater)


        preference = AppPreference(this)
        locService = SendLocationService()
        if(preference.isOfficer()){
            setContentView(bindingOfficer.root)
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.fragmentContainerViewOfficer) as NavHostFragment
            val navController = navHostFragment.navController
            bindingOfficer.bottomNavbar.itemIconTintList = null
            bindingOfficer.bottomNavbar.setupWithNavController(navController)
            checkLocationService()
        }else{
            setContentView(binding.root)
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val navController = navHostFragment.navController
            binding.bottomNavbar.itemIconTintList = null
            binding.bottomNavbar.setupWithNavController(navController)
            checkLocationService()
        }
    }

    override fun onResume() {
        super.onResume()
        Distribute.checkForUpdate()
        window.statusBarColor = ContextCompat.getColor(
            this, android.R.color.transparent)
    }

    private fun checkLocationService() {
        if (!locService.isRunning() && preference.getPatrolStatus()) {
//            val serviceIntent = Intent(this, SendLocationService::class.java)
//            startService(serviceIntent)
            startPatrol()
        }
    }


    fun startPatrol(){
        val mServiceIntent = Intent(this, LocationService::class.java)
        mServiceIntent.putExtra("AUTH",preference.getAuth())
        mServiceIntent.action = STARTFOREGROUND_ACTION;
        startService(mServiceIntent)
    }
    fun stopPatrol(){
        val mServiceIntent = Intent(this, LocationService::class.java)
        mServiceIntent.action = LocationService.STOPFOREGROUND_ACTION;
        startService(mServiceIntent)
    }
}