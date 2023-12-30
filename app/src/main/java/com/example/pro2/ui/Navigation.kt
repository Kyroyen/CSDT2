package com.example.pro2.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.pro2.ui.views.AddTaskScreen
import com.example.pro2.ui.views.HomeScreen

sealed class Screen(val route : String){
    object MainScreen :Screen("main_screen")
    object AddScreen : Screen("add_screen")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            HomeScreen(
                makeNew = {
                    Log.d("Bhosda","Nikala")
                    navController.navigate(Screen.AddScreen.route)
                }
            )
        }

        composable(route = Screen.AddScreen.route){
            AddTaskScreen(
                goBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}