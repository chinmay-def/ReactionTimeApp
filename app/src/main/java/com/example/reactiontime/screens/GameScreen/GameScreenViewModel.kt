package com.example.reactiontime.screens.GameScreen

import androidx.lifecycle.ViewModel
import com.example.reactiontime.R
import com.example.reactiontime.data.Game
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GamesScreenViewModel : ViewModel() {
    private val _games = MutableStateFlow<List<Game>>(emptyList())
    val games = _games.asStateFlow()
    init {
        _games.value = listOf(
            Game(
                title = "Reaction Time",
                description = "Test your reaction speed!",
                image = R.drawable.ic_launcher_background,
                route = "reaction_time"
            ),
            Game(
                title = "Number Memory",
                description = "Remember the sequence of numbers.",
                image = R.drawable.ic_launcher_background,
                route = "number_memory"
            ),
            Game(
                title = "Aim Trainer",
                description = "Improve your mouse accuracy.",
                image = R.drawable.ic_launcher_background,
                route = "aim_trainer"
            ),
            Game(
                title = "Visual Memory",
                description = "Test your visual recall.",
                image = R.drawable.ic_launcher_background,
                route = "visual_memory"
            ),
            Game(
                title = "Chimp Test",
                description = "Test your short-term memory",
                image = R.drawable.ic_launcher_background,
                route = "chimp_test"
            ),
        )
    }
}