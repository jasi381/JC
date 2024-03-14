package com.jasmeet.jc.tasks

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task6() {

    val bmi = rememberSaveable {
        mutableFloatStateOf(0f)
    }

    val height = rememberSaveable {
        mutableStateOf("")

    }
    val weight = rememberSaveable {
        mutableStateOf("")

    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "BMI Calculator")
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
        }
    ) {paddingValues ->
        Column(
            Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(paddingValues)
        ) {



            OutlinedTextField(
                value = weight.value,
                onValueChange = {
                    weight.value = it
                },
                modifier = Modifier
                    .padding(
                        horizontal = 15.dp,
                        vertical = 10.dp
                    )
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xff999999),
                    unfocusedIndicatorColor = Color(0xffd9d9d9),
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = Color(0xff999999),
                    selectionColors = TextSelectionColors(
                        handleColor = Color(0xff999999),
                        backgroundColor = Color(0xffd9d9d9),
                    )
                ),
                textStyle = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 15.sp,
                    fontWeight = FontWeight(600),
                    color = Color.Black.copy(alpha = 0.5f),
                ),
                label = {
                    Text(
                        text = "Weight",
                        style = TextStyle(
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 15.sp,
                            fontWeight = FontWeight(300),
                            color = Color(0xff666666),
                        )
                    )
                },
                maxLines = 1,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next,
                    autoCorrect = false,
                    capitalization = KeyboardCapitalization.None
                ),
                suffix = {
                    Text(text = "kg", color = Color.Black)
                }
            )

            OutlinedTextField(
                value = height.value,
                onValueChange = {
                    height.value = it
                },
                modifier = Modifier
                    .padding(
                        horizontal = 15.dp,
                        vertical = 10.dp
                    )
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xff999999),
                    unfocusedIndicatorColor = Color(0xffd9d9d9),
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = Color(0xff999999),
                    selectionColors = TextSelectionColors(
                        handleColor = Color(0xff999999),
                        backgroundColor = Color(0xffd9d9d9),
                    )
                ),
                textStyle = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 15.sp,
                    fontWeight = FontWeight(600),
                    color = Color.Black.copy(alpha = 0.5f),
                ),
                label = {
                    Text(
                        text = "Height",
                        style = TextStyle(
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 15.sp,
                            fontWeight = FontWeight(300),
                            color = Color(0xff666666),
                        )
                    )
                },
                maxLines = 1,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done,
                    autoCorrect = false,
                    capitalization = KeyboardCapitalization.None
                ),
                suffix = {
                    Text(text = "cm", color = Color.Black)
                },
                keyboardActions =  KeyboardActions(
                    onDone = {
                        bmi.floatValue = (weight.value.toFloat() / ((height.value.toFloat() / 100) * (height.value.toFloat() / 100)))
                    }
                )
            )

            Button(
                onClick = {
                    bmi.floatValue = (weight.value.toFloat() / ((height.value.toFloat() / 100) * (height.value.toFloat() / 100)))
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp),
                enabled = weight.value.isNotEmpty() && height.value.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White,
                    disabledContainerColor = Color.LightGray,
                    disabledContentColor = Color.White
                )
            ) {
                Text(text = "Calculate",modifier= Modifier.padding(horizontal = 10.dp, vertical = 2.dp))
            }

            if (bmi.floatValue > 0)
                Surface(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .align(Alignment.CenterHorizontally),
                    border = BorderStroke(1.dp,Color.Black),
                    color = Color.White,
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(
                        text = "Your BMI is: ${ bmi.floatValue.toString().substring(0, 4)}",
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                        color = Color.Black
                    )
                }


        }

    }

}

@Preview
@Composable
private fun Task6Preview() {
    Task6()
}