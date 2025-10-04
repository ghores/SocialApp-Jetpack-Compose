package com.example.socialapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.socialapp.ui.screen.SocialDesignApp
import com.example.socialapp.ui.theme.SocialAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SocialAppTheme {
                SocialDesignApp()
            }
        }
    }
}