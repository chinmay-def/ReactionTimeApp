package com.example.reactiontime.data

import androidx.compose.ui.graphics.Color

enum class GameState{
    Idle,
    Waiting,
    Ready,
    TooSoon,
    Result
}

data class ReactionState(
    val gameState: GameState,
    val backgroundColor : Color = Color.Gray,
    val reactionTime :Long? = null,
    val message: String="",
    val startTime :Long? = null
)