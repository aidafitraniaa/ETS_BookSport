package com.example.booksport.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.booksport.ui.screens.BookingScreen
import com.example.booksport.ui.screens.ConfirmationScreen
import com.example.booksport.ui.screens.HomeScreen
import com.example.booksport.ui.screens.VenueListScreen

object Routes {
    const val HOME = "home"
    const val VENUE_LIST = "venue_list"
    const val BOOKING = "booking"
    const val CONFIRMATION = "confirmation/{userName}/{selectedSport}/{selectedDate}/{selectedTime}"
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(navController = navController)
        }
        composable(Routes.VENUE_LIST) {
            VenueListScreen(navController = navController)
        }
        composable(Routes.BOOKING) {
            BookingScreen(navController = navController)
        }
        composable(
            route = Routes.CONFIRMATION,
            arguments = listOf(
                navArgument("userName") { defaultValue = "N/A" },
                navArgument("selectedSport") { defaultValue = "N/A" },
                navArgument("selectedDate") { defaultValue = "N/A" },
                navArgument("selectedTime") { defaultValue = "N/A" }
            )
        ) {
            ConfirmationScreen(navController = navController, backStackEntry = it)
        }
    }
}

