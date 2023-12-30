package com.example.pro2.ui.views

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pro2.models.Task
import com.example.pro2.ui.components.FloatingActionAddButton
import com.example.pro2.ui.components.TaskCard
import com.example.pro2.ui.components.TopBar
import com.example.pro2.ui.viewmodels.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    makeNew: () -> Unit = {},
    editTask: (Long) -> Unit = {},
) {
    val viewModel = viewModel(TaskViewModel::class.java)
    val state by viewModel.state.collectAsState()
    Scaffold(
        topBar = {
            TopBar()
        },
        floatingActionButton = { FloatingActionAddButton(
            addNewNav = makeNew
        )},
        floatingActionButtonPosition = FabPosition.Center
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues),
        ) {
            items(state.taskList.size) {
                TaskCard(task = state.taskList[it])
            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewHomeScreen(){
//    HomeScreen()
//}