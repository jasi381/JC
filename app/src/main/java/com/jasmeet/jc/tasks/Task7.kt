package com.jasmeet.jc.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Task7() {

    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextFieldComponent(
            modifier = Modifier.padding( horizontal = 15.dp, vertical = 10.dp).fillMaxWidth(),
            value = email.value ,
            onValueChange ={
                email.value = it
            } ,
            hint = "Email"
        )

        TextFieldComponent(
            modifier = Modifier.padding( horizontal = 15.dp, vertical = 10.dp).fillMaxWidth(),
            value = password.value ,
            onValueChange ={
                password.value = it
            } ,
            hint = "Password",
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }
            ),

            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
        )

        Button(
            onClick = {
                keyboardController?.hide()
                focusManager.clearFocus()
            },
            modifier = Modifier
                .padding(
                    horizontal = 15.dp,
                    vertical = 10.dp
                )
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            enabled = email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty(),
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color(0xffd9d9d9),
                disabledContentColor = Color(0xff999999),
            )
        ) {
            Text(
                text = "Login",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 5.dp),

                )
        }



    }

}

@Composable
fun TextFieldComponent(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint : String,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardType: KeyboardType = KeyboardType.Email,

    ) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        modifier = modifier,
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
        placeholder = {
            Text(
                text = hint,
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
        keyboardActions = keyboardActions,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction,
            autoCorrect = false,
            capitalization = KeyboardCapitalization.None
        ),
    )
}