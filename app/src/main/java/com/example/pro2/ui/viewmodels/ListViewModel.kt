package com.example.pro2.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.pro2.database.DatabaseInstance
import com.example.pro2.database.TaskDao
import com.example.pro2.database.TaskDataSource
import com.example.pro2.database.TaskDatabase
import com.example.pro2.models.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class TaskViewModel(
    val taskDataSource: TaskDataSource = DatabaseInstance.taskDatabase
) : ViewModel() {
    private val _state = MutableStateFlow(TaskViewState())
    val state : StateFlow<TaskViewState>
        get() = _state

    val taskList = taskDataSource.selectAll

    init {
        viewModelScope.launch {
            taskList.collect{
                _state.value = TaskViewState(it)
            }
        }
    }

    fun insertTask(task:Task) = viewModelScope.launch {
        taskDataSource.addTask(task)
    }
}

data class TaskViewState(
    val taskList: List<Task> = emptyList()
)