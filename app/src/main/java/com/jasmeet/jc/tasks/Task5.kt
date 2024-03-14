package com.jasmeet.jc.tasks

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 * Approach 1 use lazyColumn
 *
 * Approach 2 use  forEachIndexed
 */

@Composable
fun Task5() {

    val context = LocalContext.current
    val showApproach1 = remember {
        mutableStateOf(true)
    }
    val showApproach2 = remember {
        mutableStateOf(false)
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Approach 1",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    showApproach1.value = true
                    showApproach2.value = false
                }
                .padding(vertical = 6.dp)
        )
        HorizontalDivider()
        Text(
            text = "Approach 2",

            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    showApproach1.value = false
                    showApproach2.value = true
                }
                .padding(vertical = 6.dp))


        Spacer(modifier = Modifier.height(15.dp))

        AnimatedVisibility(visible = showApproach1.value) {
            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(text = "Approach 1")
                }

                items(100){
                    Text(
                        text = "${it+1}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                showToast(context, it.toString())
                            }
                            .padding(vertical = 8.dp),
                        textAlign = TextAlign.Center
                    )
                }

            }
        }

        AnimatedVisibility(visible = showApproach2.value) {

            Column {
                Text("Approach 2")
                (1..100).forEachIndexed { index, _ ->
                    Text(
                        text = "${index + 1}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                showToast(context, index.toString())
                            }
                            .padding(vertical = 8.dp)
                    )
                }
            }
        }


    }




}

@Preview
@Composable
private fun Task5Preview() {
    Task5()
}