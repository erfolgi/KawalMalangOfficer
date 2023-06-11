package com.kawal.malang.officer.core.util

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.kawal.malang.officer.R
import com.kawal.malang.officer.data.model.auth.LoginData
import com.kawal.malang.officer.data.model.briefing.BriefingData
import com.google.gson.Gson

class AppPreference (val context: Context) {
    private var prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun setAuth(input: String) {
        val editor = this.prefs.edit()
        val key = context.resources.getString(R.string.auth)
        editor.putString(key, "Bearer $input")
        editor.apply()
    }
    fun getAuth(): String {
        val key = context.resources.getString(R.string.auth)
        return prefs.getString(key, "").toString()
    }

    fun deleteAuth() {
        val editor = this.prefs.edit()
        val key = context.resources.getString(R.string.auth)
        editor.putString(key, "")
        editor.apply()
    }

    fun setRole(loginData: LoginData) {
        val editor = this.prefs.edit()
        val key = context.resources.getString(R.string.role)
        for (role in loginData.roles ?: arrayListOf()) {
           if (role.title == "Mobil") {
               editor.putString(key, "car")
               break
           } else {
               editor.putString(key, "officer")
               break
           }
        }
        editor.apply()
    }

    fun getRole(): String {
        val key = context.resources.getString(R.string.role)
        return prefs.getString(key, "") ?: ""
    }

    fun isOfficer():Boolean{
        return getRole()=="officer"
    }

    fun setPatrolStatus(status: Boolean) {
        val editor = this.prefs.edit()
        val key = context.resources.getString(R.string.is_patrol)
        editor.putBoolean(key, status)
        editor.apply()
    }

    fun getPatrolStatus(): Boolean {
        val key = context.resources.getString(R.string.is_patrol)
        return prefs.getBoolean(key, false)
    }

    fun setFcmToken(token: String) {
        val editor = this.prefs.edit()
        val key = context.resources.getString(R.string.fcm)
        editor.putString(key, token)
        editor.apply()
    }

    fun getFcmToken(): String {
        val key = context.resources.getString(R.string.fcm)
        return prefs.getString(key, "") ?: ""
    }

    //----------------BRIEFING--------------//
    fun setStoredBriefing(input: BriefingData) {
        val editornama = this.prefs.edit()
        val keynama = context.resources.getString(R.string.stored_briefing)
        val gson = Gson()
        editornama.putString(keynama, gson.toJson(input))
        editornama.apply()
    }
    fun getStoredBriefing(): BriefingData {
        val key = context.resources.getString(R.string.stored_briefing)
        val gson = Gson()
        val json : String = prefs.getString(key, gson.toJson(BriefingData())).toString()
        val data = gson.fromJson(json,BriefingData ::class.java)
        destroyStoredSurat()
        return data
    }
    private fun  destroyStoredSurat() {
        val editornama = this.prefs.edit()
        val keynama = context.resources.getString(R.string.stored_briefing)
        editornama.putString(keynama, null)
        editornama.apply()
    }
}