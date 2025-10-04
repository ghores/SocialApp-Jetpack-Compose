package com.example.socialapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.socialapp.ui.component.PostsView
import com.example.socialapp.ui.component.StoriesRow

@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        StoriesRow(navController)
        Spacer(Modifier.height(7.dp))
        HorizontalDivider(color = Color.Gray, modifier = Modifier.padding(horizontal = 8.dp))
        Spacer(Modifier.height(7.dp))
        PostsView()
    }
}