package com.kawal.malang.officer.presentation

import android.app.Activity
import android.app.Application
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import dagger.hilt.android.HiltAndroidApp
import java.lang.Exception





@HiltAndroidApp
class OfficerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(
                activity: Activity,
                savedInstanceState: Bundle?
            ) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//                    activity.window.setDecorFitsSystemWindows(false)
                    try{
                        activity.window.insetsController?.hide(WindowInsets.Type.statusBars())
                    }catch (e:Exception){
                        val winParams: WindowManager.LayoutParams = activity.window.getAttributes()
                        winParams.flags =
                            winParams.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS.inv()
                        activity.window.setAttributes(winParams)
                        activity.window.getDecorView()
                            .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
                    }

                } else {
//                    activity.window.setFlags(
//                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//                    )
//                    activity.window.setFlags(
//                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                    )


                    val winParams: WindowManager.LayoutParams = activity.window.getAttributes()
                    winParams.flags =
                        winParams.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS.inv()
                    activity.window.setAttributes(winParams)
                    activity.window.getDecorView()
                        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
                }

            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

            }

            override fun onActivityDestroyed(activity: Activity) {

            }
        })
    }
}