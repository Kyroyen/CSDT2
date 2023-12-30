package com.example.pro2.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pro2.models.Task
import com.example.pro2.ui.viewmodels.SingleTaskViewModel
import com.example.pro2.ui.viewmodels.TaskViewModel

@Composable
fun TaskCard(
    task:Task,
    navigateNext : () -> Unit = {}
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ){

        Card(
            modifier = Modifier
                .wrapContentSize()
                .fillMaxWidth(0.7f)
                .padding(8.dp),
            colors = CardDefaults.cardColors(
                    if (task.done.not()) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.secondary
                    }
                ),
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(10.dp, 10.dp, 10.dp, 0.dp),
                    text = task.name,
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontSize = 20.sp,
                )
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(10.dp),
                    text = task.content,
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontSize = 12.sp,
                )
            }
        }
        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(20.dp),
            text = task.time,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.inversePrimary
        )
    }
}

//@Preview
//@Composable
//fun PreviewTaskCard(){
//    TaskCard(task = Task(21,"Nigger","Yo my nigga", "10:56 pm", true))
//}