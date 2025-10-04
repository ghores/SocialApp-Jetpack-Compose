package com.example.socialapp.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.socialapp.ui.component.UserCircleProfile


@Composable
fun ProfileScreen(navController: NavHostController) {
    Box(Modifier.fillMaxSize()) {
        Column(Modifier
            .fillMaxSize()) {
            Column(Modifier.fillMaxWidth().padding(16.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    UserCircleProfile(
                        "https://holosen.net/api/file/835DE147-27DE-47C2-8F5E-8B6814FC9988",
                        "Hossein",
                        80.dp,
                        BorderStroke(2.dp, Color.Gray)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        ProfileStat("Posts", "30")
                        ProfileStat("Followers", "100K")
                        ProfileStat("Following", "345")
                    }
                }

                Spacer(Modifier.height(8.dp))

                NameAndBio()

                Spacer(Modifier.height(8.dp))

                Button(onClick = {}, Modifier.fillMaxWidth()) {
                    Text("Edit Profile")
                }

                Spacer(Modifier.height(8.dp))

            }
            ExploreScreen(navController)
        }
    }
}

@Composable
fun NameAndBio() {
    Column {
        Text("Hossein Badrnezhad", fontWeight = FontWeight.Bold)
        Text("Web and Mobile Developer 🧑‍💻")
    }
}

@Composable
fun ProfileStat(label: String, count: String) {
    Column {
        Text(count, fontWeight = FontWeight.Bold)
        Text(label)
    }
}