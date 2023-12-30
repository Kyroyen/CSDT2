package com.example.pro2

import android.app.Application
import com.example.pro2.database.DatabaseInstance

class TaskApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        DatabaseInstance.getAppContext(this)
    }
}