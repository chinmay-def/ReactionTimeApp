package com.example.reactiontime.Screens.GameScreen.Games.ReactionScreen

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reactiontime.data.GameState
import com.example.reactiontime.data.ReactionState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.random.Random

class ReactionTimeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ReactionState(GameState.Idle))
    val uiState = _uiState

    private var gameJob : Job?= null

    //Start Game
    fun startGame() {
        gameJob?.cancel()
        gameJob = viewModelScope.launch {
            _uiState.update {
                it.copy(
                    gameState = GameState.Waiting,
                    backgroundColor = Color(0xFFFF5722),
                    message = "Waiting for the green Color"
                )
            }
            delay(Random.Default.nextLong(1000, 3000))
            _uiState.update {
                it.copy(
                    gameState = GameState.Ready,
                    backgroundColor = Color(0xFF4CAF50),
                    message = "Click",
                    startTime = System.currentTimeMillis()
                )
            }
        }
    }

    //OnScreen Tap
    fun onScreenTap() {
        when (_uiState.value.gameState) {
            GameState.Idle -> {

            }
            GameState.Waiting ->{
                gameJob?.cancel()
                _uiState.update {
                it.copy(
                    gameState = GameState.TooSoon,
                    backgroundColor = Color.Companion.Blue,
                    message = "Too Soon"
                )
            }}

            GameState.Ready -> _uiState.update {
                val reactionTime = System.currentTimeMillis() - it.startTime!!
                it.copy(
                    gameState = GameState.Result,
                    backgroundColor = Color(0xFF2196F3),
                    reactionTime = reactionTime,
                    message = "Your Reaction Time is $reactionTime ms"
                )
            }

            GameState.TooSoon ->

            {
                startGame()
            }


            GameState.Result -> _uiState.update {
                it.copy(
                    gameState = GameState.Idle,
                    backgroundColor = Color.Companion.Gray,
                    message = "Start the Game"
                )
            }
        }
    }
}