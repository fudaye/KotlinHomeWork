package com.example.core

import android.app.Application
import android.content.Context

class BaseApplication : Application() {
    companion object {
        lateinit var currentApplication: Context//自动生成setter and  getter
            private set//不能被修改

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this
    }


}