package com.jasmeet.jc.tasks

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

/**
 * Task 2 is to center align the text in a Column
 *
 *  Set the vertical arrangement to Center along with the horizontal alignment to CenterHorizontally
 *  and add a button login to the column and show a toast on button click
 */

@Composable
fun Task2() {

    val context = LocalContext.current // This will give the context of the current screen and in jetpack compose it is used get context


    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,  // This will set the items int the center vertically
        horizontalAlignment = Alignment.CenterHorizontally // This will set the items int the center horizontally
    ) {
        Text(text = "Hello World")
        Button(
            onClick = { showToast(context) }
        ) {
            Text(text = "Login")

        }
    }
}


fun showToast(context: Context,text :String? = null){
    Toast.makeText(context, "Login Clicked", Toast.LENGTH_SHORT).show()
}

@Preview
@Composable
private fun Task2Preview() {
    Task2()
}

