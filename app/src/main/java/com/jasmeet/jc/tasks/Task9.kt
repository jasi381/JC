package com.jasmeet.jc.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Task9() {

    val switchState = rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(
                if (switchState.value) Modifier.background(Color.White) else Modifier.background(
                    Color.Black
                )
            ),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ){

        Switch(
            checked = switchState.value,
            onCheckedChange ={
                switchState.value = it
            },
            thumbContent = {
                if (switchState.value){
                    Icon(
                        imageVector = Icons.Outlined.LightMode,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize)
//                            /.size(SwitchDefaults.IconSize)
                    )
                }else{
                    Icon(imageVector = Icons.Outlined.DarkMode, contentDescription = null,modifier = Modifier.size(SwitchDefaults.IconSize))
                }
            }
        )
    }
}