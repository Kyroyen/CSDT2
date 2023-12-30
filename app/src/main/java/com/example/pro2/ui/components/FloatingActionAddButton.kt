package com.example.pro2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pro2.R

@Composable
fun FloatingActionAddButton(
    addNewNav : () -> Unit = {},
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .clickable {
                addNewNav()
            }
    ) {
        Text(
            modifier = Modifier.padding(20.dp,12.dp),
            text = stringResource(id = R.string.new_task),
            fontFamily = FontFamily.Serif,
            fontSize = 12.sp,
        )
    }
}

//@Preview
//@Composable
//fun PreviewFloatingActionAddButton(){
//    FloatingActionAddButton()
//}