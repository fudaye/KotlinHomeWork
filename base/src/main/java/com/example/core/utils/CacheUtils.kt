package com.example.core.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.core.BaseApplication
import com.example.core.R

class CacheUtils {
    companion object {
        @SuppressLint("StaticFieldLeak")
        var SP: SharedPreferences = BaseApplication.currentApplication
                .getSharedPreferences(BaseApplication.currentApplication.getString(R.string.app_name), Context.MODE_PRIVATE)
        fun save(key: String, value: String) {
            SP.edit().putString(key, value).apply()
        }

        fun get(key: String): String? {
            return SP.getString(key, null)
        }
    }
}