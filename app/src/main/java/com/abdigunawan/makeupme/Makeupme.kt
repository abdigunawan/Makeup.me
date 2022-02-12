package com.abdigunawan.makeupme

import android.content.SharedPreferences
import androidx.multidex.MultiDexApplication
import androidx.preference.PreferenceManager
import com.abdigunawan.makeupme.network.HttpClient

class Makeupme : MultiDexApplication() {

    companion object {
        lateinit var instance : Makeupme

        fun getApp(): Makeupme {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun getPreferences() : SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(this)
    }

    fun setToken(token: String?) {
        getPreferences().edit().putString("PREFERENCES_TOKEN", token).apply()
        HttpClient.getInstance().buildRetrofitClient(token)
    }

    fun getToken():String? {
        return getPreferences().getString("PREFERENCES_TOKEN", null)
    }

    fun setUser(user: String?) {
        getPreferences().edit().putString("PREFERENCES_USER", user).apply()
//        HttpClient.getInstance().buildRetrofitClient(user)
    }

    fun getUser():String? {
        return getPreferences().getString("PREFERENCES_USER", null)
    }


}