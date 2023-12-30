package com.example.pro2.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pro2.models.Task
import com.example.pro2.ui.components.TopBar
import com.example.pro2.ui.viewmodels.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    goBack: ()->Unit,
    taskViewModel: TaskViewModel = viewModel(),
) {
    val state by taskViewModel.state.collectAsState()
    var newTask by remember {
        mutableStateOf(Task())
    }
    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                taskViewModel.insertTask(newTask)
                goBack()
            }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(0.9f),
                value = newTask.name,
                onValueChange = {newTask = newTask.copy(name = it)},
                label = { Text("Title") }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(0.9f),
                value = newTask.content,
                onValueChange = {newTask = newTask.copy(content = it)},
                label = { Text("Content") }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(0.9f),
                value = newTask.time,
                onValueChange = {newTask = newTask.copy(time = it)},
                label = { Text("Time") }
            )
        }
    }
}

//@Preview
//@Composable
//fun Preview(){
//    AddTaskScreen()
//}

