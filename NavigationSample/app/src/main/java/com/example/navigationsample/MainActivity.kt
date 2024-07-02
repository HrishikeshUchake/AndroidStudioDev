package com.example.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first_screen") {
        composable("first_screen"){
            FirstScreen{name, age ->
                navController.navigate("second_screen/$name/$age")
            }
        }
        composable("second_screen/{name}/{age}"){
            val name = it.arguments?.getString("name") ?: "No name"
            val age = it.arguments?.getInt("age") ?: 0
            SecondScreen(name, age) {
                navController.navigate("first_screen")
            }
       }
    }
}

