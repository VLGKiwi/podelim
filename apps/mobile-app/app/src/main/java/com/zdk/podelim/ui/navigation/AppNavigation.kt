package com.zdk.podelim.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zdk.podelim.ui.screens.eventList.EventListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.EventListScreen.route
    ) {
        composable(route = Screen.EventListScreen.route) {
            EventListScreen(onEventClick = { eventId ->
                navController.navigate(Screen.EventDetailScreen.createRoute(eventId = eventId))
            })
        }

        composable(
            route = Screen.EventDetailScreen.route,
            arguments = listOf(navArgument("eventId") {
                type =
                    NavType.StringType
            })
        ) { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId")


        }

    }
}

sealed class Screen(val route: String) {
    object EventListScreen : Screen("event_list_screen")
    object EventDetailScreen : Screen("event_detail_screen/{eventId}") {
        fun createRoute(eventId: String) = "event_detail_screen/$eventId"
    }
}