package com.example.socialapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.socialapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar() {
    TopAppBar(
        title = {
            Image(
                painterResource(R.drawable.social),
                contentDescription = "Social Design",
                modifier = Modifier.width(100.dp)
            )
        },
        navigationIcon = {}, actions = {}
    )
}