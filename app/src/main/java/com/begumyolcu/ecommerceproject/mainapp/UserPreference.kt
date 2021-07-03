package com.begumyolcu.ecommerceproject.mainapp

import android.content.Context
import android.content.SharedPreferences

class UserPreference private constructor(context: Context) {
    private val sharedPreferences: SharedPreferences?

    fun saveData(key: String?, value: String?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putString(key, value)
        prefsEditor.commit()
    }

    fun getData(key: String?): String? {
        return if (sharedPreferences != null) {
            sharedPreferences.getString(key, "")
        } else ""
    }

    companion object {
        private var userPreference: UserPreference? = null
        fun getInstance(context: Context): UserPreference? {
            if (userPreference == null) {
                userPreference = UserPreference(context)
            }
            return userPreference
        }
    }

    init {
        sharedPreferences =
            context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
    }
}