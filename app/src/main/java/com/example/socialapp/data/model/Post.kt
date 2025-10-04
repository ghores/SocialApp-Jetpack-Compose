package com.example.socialapp.data.model

import java.io.Serializable

data class Post(
    val id: Int,
    val username: String,
    val userProfile: String,
    val image: String,
    val caption: String
) : Serializable
