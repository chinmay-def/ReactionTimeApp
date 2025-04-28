package com.example.reactiontime.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reactiontime.Screens.GameScreen.GameScreen
import com.example.reactiontime.Screens.GameScreen.Games.ReactionScreen.ReactionTimeScreen
import com.example.reactiontime.data.BottomNavItem

@Composable
fun GameNavGraph() {
    val gameNavController = rememberNavController()
    NavHost(
        navController = gameNavController,
        startDestination = BottomNavItem.Games.route
    ) {
        composable(BottomNavItem.Games.route) {
            GameScreen(gameNavController)

        }
        composable(GameListScreen.ReactionGame.route) {
            ReactionTimeScreen()
        }
    }
}