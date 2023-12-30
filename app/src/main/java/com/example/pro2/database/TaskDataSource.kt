package com.example.pro2.database

import com.example.pro2.database.DatabaseInstance.taskDatabase
import com.example.pro2.models.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class TaskDataSource(private val taskDao: TaskDao ) {
    val selectAll = taskDao.getAllTasks()

    suspend fun addTask(task: Task){
        Dispatchers.IO.apply{
            taskDao.insertTask(task)
        }
    }
}