package com.enestigli.diyetkolikcase.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.annotation.InspectableProperty
import com.enestigli.diyetkolikcase.util.Constants.PREF_NAME

class SharedPrefHelper(context: Context) {


    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    }


    private val editor = sharedPreferences.edit()

    fun setStringToShared(value: String) {
        try {
            editor.apply{
                putString("isSaved", value)?.apply()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getStringFromShared(): String? {
        return try {
            sharedPreferences.getString("isSaved", "def")
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

}

