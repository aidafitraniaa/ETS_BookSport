package com.example.booksport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.booksport.navigation.NavGraph
import com.example.booksport.ui.theme.BookSportTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookSportTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
