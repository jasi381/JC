package com.jasmeet.jc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jasmeet.jc.item.HomeItem
import com.jasmeet.jc.navigation.MainNavHost
import com.jasmeet.jc.ui.theme.JCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCTheme {
                val navHost = rememberNavController()
                MainNavHost(nav = navHost)

            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {

    val homeItems = listOf(

        HomeItem(title = "Task1", onItemClick = { navController.navigate("task1") }),
        HomeItem(title = "Task2", onItemClick = { navController.navigate("task2") }),
        HomeItem(title = "Task3", onItemClick = { navController.navigate("task3") }),
        HomeItem(title = "Task4", onItemClick = { navController.navigate("task4") }),
        HomeItem(title = "Task5", onItemClick = { navController.navigate("task5") }),
        HomeItem(title = "Task6", onItemClick = { navController.navigate("task6") }),
        HomeItem(title = "Task7", onItemClick = { navController.navigate("task7") }),
        HomeItem(title = "Task8", onItemClick = { navController.navigate("task8") }),
        HomeItem(title = "Task9", onItemClick = { navController.navigate("task9") }),
    )


    LazyColumn(
        Modifier.fillMaxSize()
    ) {

        items(homeItems) {
            Text(
                text = it.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        it.onItemClick.invoke()
                    }
                    .padding(vertical = 6.dp))
            HorizontalDivider()
        }

    }

}
