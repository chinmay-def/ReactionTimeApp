package com.example.reactiontime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.reactiontime.Screens.MainScreen
import com.example.reactiontime.ui.theme.ReactionTimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReactionTimeTheme {
                MainScreen()
            }
        }
    }
}

