package com.example.pro2.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.pro2.database.DatabaseInstance
import com.example.pro2.database.TaskDataSource
import com.example.pro2.models.Task
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SingleTaskViewModel(
    val taskDataSource: TaskDataSource = DatabaseInstance.taskDatabase,
) : ViewModel() {
    private val _task = MutableLiveData(Task())
    val task: LiveData<Task>
        get() = _task

//    fun getTask(id:Long){
//        viewModelScope.launch {
//            Log.d("Bhosda","task Cad :? $id ${task}")
//            taskDataSource.getSingleTask(id).collect{
//                _task.postValue(it)
//            }
//        }
//    }

}
