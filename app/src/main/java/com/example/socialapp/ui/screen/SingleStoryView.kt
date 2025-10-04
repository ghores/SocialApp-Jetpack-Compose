package com.example.socialapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.socialapp.R
import com.example.socialapp.data.MockDataRepository
import com.example.socialapp.ui.component.Loading

@Composable
fun SingleStoryView(id: Int, navController: NavHostController) {
    val story = MockDataRepository.getStoryById(id)
    if (story == null) {
        navController.popBackStack()
        return
    }
    var loading by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AsyncImage(
            model = story.storyImage,
            contentDescription = story.username,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize(),
            error = painterResource(R.drawable.close),
            onLoading = {
                loading = true
            },
            onSuccess = {
                loading = false
            },
            onError = {
                loading = false
            }
        )
        if (loading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Loading()
            }
        }
    }
}