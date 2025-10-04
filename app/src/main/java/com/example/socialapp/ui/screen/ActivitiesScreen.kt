package com.example.socialapp.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.socialapp.R
import com.example.socialapp.data.MockDataRepository
import com.example.socialapp.data.model.ActivityItem
import com.example.socialapp.data.model.enums.ActivityType
import com.example.socialapp.ui.component.UserCircleProfile

@Composable
fun ActivitiesScreen(navController: NavHostController) {
    val activities = List(30) { MockDataRepository.getRandomActivity() }
    LazyColumn(
        Modifier.fillMaxSize()
    ) {
        items(activities) { item ->
            ActivityRow(item)
            Spacer(Modifier.height(6.dp))
        }
    }
}

@Composable
fun ActivityRow(item: ActivityItem) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        UserCircleProfile(
            item.userProfile,
            item.username,
            50.dp,
            BorderStroke(1.dp, Color.DarkGray)
        )
        Spacer(Modifier.width(2.dp))
        Column {
            Row {
                Text(item.username, fontWeight = FontWeight.Bold)
                Spacer(Modifier.width(4.dp))
                Text(
                    when (item.type) {
                        ActivityType.Like -> "liked your post"
                        ActivityType.Comment -> "commented on your post"
                        ActivityType.Follow -> "started following you"
                    }
                )
            }
            Text(item.time + " ago", fontSize = 11.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        if (item.type == ActivityType.Follow) {
            Button(onClick = {}) {
                Text("Follow Back", fontSize = 9.sp)
            }
        } else {
            AsyncImage(
                model = item.postThumbnail,
                contentDescription = item.username,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(4.dp)),
                placeholder = painterResource(R.drawable.ic_loading),
                error = painterResource(R.drawable.close)
            )
        }
    }
}