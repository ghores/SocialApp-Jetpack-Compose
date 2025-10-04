package com.example.socialapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun AddScreen(navController: NavHostController) {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            CameraPreview()
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            GalleryGrid(navController)
        }
    }
}

@Composable
fun GalleryGrid(navController: NavHostController) {
    ExploreScreen(navController)
}

@Composable
fun CameraPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text("Camera Preview", color = Color.White)
    }
}