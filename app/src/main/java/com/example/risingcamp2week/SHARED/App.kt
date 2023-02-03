package com.example.risingcamp2week.SHARED

import android.app.Application

class App : Application() {

    companion object {
        lateinit var prefs : MySharedPreferences
    }
    
    // 메인 액티비티 onCreate 보다 선행하여 pref 를 선언하기 위함
    override fun onCreate() {
        prefs = MySharedPreferences(applicationContext)
        super.onCreate()
    }
}