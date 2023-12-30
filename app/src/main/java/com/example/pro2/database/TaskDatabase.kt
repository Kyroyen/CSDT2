package com.example.pro2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pro2.models.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun getTaskDao(): TaskDao
    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null
        fun getDatabase(context: Context): TaskDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "task_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}