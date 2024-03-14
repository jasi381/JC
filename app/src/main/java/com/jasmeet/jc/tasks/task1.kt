package com.jasmeet.jc.tasks

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


/**
 * Task 1 was to add a text to the screen
 */
@Composable
fun Task1() {
    Text(
        text = "Hello World !",

    )
}

@Preview
@Composable
private fun Task1Preview() {

    Task1()
}