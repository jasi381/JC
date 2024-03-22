package com.jasmeet.jc.tasks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun Task8() {

    val context = LocalContext.current

    val mutableList = remember{mutableStateListOf(1, 2, 3, 4, 5)}

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val lastElement = mutableList.last()
                    mutableList += lastElement + 1
                },
                containerColor = Color.Blue,
                contentColor = Color.White,
                shape = CircleShape
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(38.dp) )
            }
        },
    ) {paddingValues ->
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(mutableList.toList()){

                Text(
                    text = "$it",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            showToast(context, it.toString())

                        }
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                )
                HorizontalDivider()
            }


        }
    }

}