package com.example.pro2.database

import android.content.Context

object DatabaseInstance {
    lateinit var database: TaskDatabase
        private set

    val taskDatabase by lazy {
        TaskDataSource(database.getTaskDao())
    }

    fun getAppContext(context : Context){
        database = TaskDatabase.getDatabase(context)
    }
}