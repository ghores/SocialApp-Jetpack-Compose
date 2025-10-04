package com.example.socialapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.socialapp.ui.component.BottomNavigationBar
import com.example.socialapp.ui.component.TopNavBar
import com.example.socialapp.ui.utils.Screen

@Composable
fun SocialDesignApp() {
    val navController = rememberNavController()
    val isFullScreen = checkForFullScreen(navController)
    Scaffold(
        topBar = { if (!isFullScreen) TopNavBar() },
        modifier = Modifier.fillMaxSize(),
        bottomBar = { if (!isFullScreen) BottomNavigationBar(navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavHost(navController, startDestination = Screen.Home.route) {
                composable(Screen.Home.route) { HomeScreen(navController) }
                composable(Screen.Explore.route) { ExploreScreen(navController) }
                composable(Screen.Add.route) { AddScreen(navController) }
                composable(Screen.Activities.route) { ActivitiesScreen(navController) }
                composable(Screen.Profile.route) { ProfileScreen(navController) }
                composable(
                    "story/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.IntType })
                ) {
                    val id = it.arguments?.getInt("id") ?: 0
                    SingleStoryView(id, navController)
                }
            }
        }
    }
}

@Composable
fun checkForFullScreen(navController: NavHostController): Boolean {
    val fullScreenRoutes = listOf("story", "login", "splash")
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: "home"

    return fullScreenRoutes.any {
        currentRoute.startsWith(it)
    }
}