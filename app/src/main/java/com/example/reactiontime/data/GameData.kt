package com.example.reactiontime.data

import android.media.Image
import androidx.compose.ui.graphics.painter.Painter


data class Game(
    val title: String,
    val description: String,
    val image: Int,
    val route: String
)