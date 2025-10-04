package com.example.socialapp.ui.utils

import com.example.socialapp.R

sealed class Screen(var route: String, var icon: Int, var title: String) {
    data object Home : Screen("home", R.drawable.ic_home, "Home")
    data object Explore : Screen("explore", R.drawable.ic_explore, "Explore")
    data object Add : Screen("add", R.drawable.ic_add, "Add")
    data object Activities : Screen("activities", R.drawable.ic_like, "Activities")
    data object Profile : Screen("profile", R.drawable.ic_user, "Profile")
}