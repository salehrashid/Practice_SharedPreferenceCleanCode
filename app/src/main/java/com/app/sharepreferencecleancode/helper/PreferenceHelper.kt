package com.app.sharepreferencecleancode.helper

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(ctx: Context) {

    private val PREF_NAME = "mypref"
    private val sharedPreferences: SharedPreferences
    val editor: SharedPreferences.Editor

    init {
        sharedPreferences = ctx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun put(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun put(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String): Boolean{
        return sharedPreferences.getBoolean(key, false)
    }

    fun clearPref(){
        editor.clear().apply()
    }
}