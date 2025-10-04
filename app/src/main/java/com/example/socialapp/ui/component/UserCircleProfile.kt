package com.example.socialapp.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.socialapp.R

@Composable
fun UserCircleProfile(
    profileImage: String,
    username: String,
    size: Dp,
    borderStroke: BorderStroke
) {
    Card(
        shape = CircleShape,
        border = borderStroke,
        modifier = Modifier.padding(6.dp)
    ) {
        Box(
            Modifier.size(size),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = profileImage,
                contentDescription = username,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize(),
                placeholder = painterResource(R.drawable.ic_loading),
                error = painterResource(R.drawable.close)
            )
        }
    }
}