package com.jasmeet.jc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jasmeet.jc.HomeScreen
import com.jasmeet.jc.tasks.Task1
import com.jasmeet.jc.tasks.Task2
import com.jasmeet.jc.tasks.Task3
import com.jasmeet.jc.tasks.Task4
import com.jasmeet.jc.tasks.Task5
import com.jasmeet.jc.tasks.Task6

@Composable
fun MainNavHost(nav: NavHostController) {

    NavHost(navController = nav, startDestination = "home" ){

        composable("home"){
            HomeScreen(navController = nav)
        }
        composable("task1"){
            Task1()
        }
        composable("task2"){
            Task2()
        }
        composable("task3"){
            Task3()
        }
        composable("task4"){
            Task4()
        }
        composable("task5"){
            Task5()
        }
        composable("task6"){
            Task6()
        }
    }
}