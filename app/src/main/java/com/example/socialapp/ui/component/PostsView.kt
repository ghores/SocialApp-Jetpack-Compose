package com.example.socialapp.ui.component

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.socialapp.R
import com.example.socialapp.data.MockDataRepository
import com.example.socialapp.data.model.Post
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PostsView() {
    LazyColumn {
        items(15) {
            val post by rememberSaveable { mutableStateOf(MockDataRepository.getRandomPost()) }
            PostItem(post)
        }
    }
}

@Composable
fun PostItem(post: Post) {
    var liked by rememberSaveable { mutableStateOf(false) }
    Column {
        PostAuthor(post)
        PostImage(post, liked) { liked = !liked }
        PostActions(liked) { liked = !liked }
        PostCaption(post)
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun PostAuthor(post: Post) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        UserCircleProfile(
            post.userProfile,
            post.username,
            50.dp,
            BorderStroke(1.dp, Color.DarkGray)
        )
        Spacer(Modifier.width(2.dp))
        Column {
            Text(post.username)
            Text("3 Minutes ago", fontSize = 11.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(painterResource(R.drawable.ic_more), contentDescription = "more")
        }
    }
}

@Composable
fun PostImage(post: Post, liked: Boolean, onLikeChanged: () -> Unit) {
    val scope = rememberCoroutineScope()
    var loading by remember { mutableStateOf(false) }
    var animatingLike by remember { mutableStateOf(false) }
    val likeSize by animateDpAsState(
        targetValue = if (animatingLike) 100.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(240.dp)
    ) {
        AsyncImage(
            model = post.image,
            contentDescription = post.username,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            onLikeChanged()
                            animatingLike = true
                            scope.launch {
                                delay(1000)
                                animatingLike = false
                            }
                        }
                    )
                },
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
        Icon(
            painterResource(R.drawable.ic_like_fill),
            contentDescription = "Like",
            modifier = Modifier
                .align(Alignment.Center)
                .size(if (liked) likeSize else 0.dp),
            tint = Color.White
        )
    }
}

@Composable
fun PostActions(liked: Boolean, onLikeChanged: () -> Unit) {
    var saved by rememberSaveable { mutableStateOf(false) }
    Row {
        IconButton(onClick = { onLikeChanged() }) {
            Icon(
                painterResource(
                    if (liked) R.drawable.ic_like_fill else R.drawable.ic_like
                ),
                contentDescription = "Like",
                tint = if (liked) Color.Red else Color.Black
            )
        }
        IconButton(onClick = {}) {
            Icon(
                painterResource(R.drawable.ic_comment),
                contentDescription = "Comment",
            )
        }
        IconButton(onClick = {}) {
            Icon(
                painterResource(R.drawable.ic_share),
                contentDescription = "Share",
            )
        }
        Spacer(Modifier.weight(1f))
        IconButton(onClick = { saved = !saved }) {
            Icon(
                painterResource(
                    if (saved) R.drawable.ic_save_fill else R.drawable.ic_save
                ),
                contentDescription = "Save"
            )
        }
    }
}

@Composable
fun PostCaption(post: Post) {
    Column(Modifier.padding(16.dp, 4.dp)) {
        Text(post.username, fontWeight = FontWeight.Bold)
        Text(post.caption, fontSize = 12.sp)
    }
}
