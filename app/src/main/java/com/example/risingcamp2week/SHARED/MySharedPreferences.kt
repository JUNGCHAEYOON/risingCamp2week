package com.example.risingcamp2week.SHARED

import android.content.Context
import android.content.SharedPreferences
import com.example.risingcamp2week.MAIN.HomeItem

class MySharedPreferences(context: Context) {

    private val prefsFilename = "prefs"
//    private val prefsKeyEdt = "myEditText"
    private val prefs: SharedPreferences = context.getSharedPreferences(prefsFilename, 0)

//    var myEditText: String?
//        get() = prefs.getString(prefsKeyEdt, "")
//        set(value) = prefs.edit().putString(prefsKeyEdt, value).apply()

    var title : String?
        get() = prefs.getString("title", "")
        set(value) = prefs.edit().putString("title", value).apply()

    var price : String?
        get() = prefs.getString("price", "")
        set(value) = prefs.edit().putString("price", value).apply()

    var info : String?
        get() = prefs.getString("info", "")
        set(value) = prefs.edit().putString("info", value).apply()

}