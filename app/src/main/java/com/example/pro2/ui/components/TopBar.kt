package com.example.pro2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pro2.R

@Preview
@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .padding(14.dp,9.dp)
            .fillMaxWidth()
            .height(40.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_menu_icon), contentDescription = null)
        Row(
            modifier = Modifier
                .wrapContentSize()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search_icon),
                contentDescription = null
            )
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Icon(painter = painterResource(id = R.drawable.ic_bell_icon), contentDescription = null)
        }
    }
}
