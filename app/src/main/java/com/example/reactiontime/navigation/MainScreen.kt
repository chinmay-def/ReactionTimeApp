package com.example.reactiontime.navigation


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reactiontime.screens.ProfileScreen.ProfileScreen
import com.example.reactiontime.screens.SettingsScreen.SettingsScreen
import com.example.reactiontime.screens.StatsScreen.StatsScreen
import com.example.reactiontime.data.BottomNavItem
import com.example.reactiontime.navigation.composable.BasicCenterAlignedTopAppBar
import com.example.reactiontime.navigation.composable.BottomNavigationBar
import com.example.reactiontime.screens.GameScreen.GameScreen
import com.example.reactiontime.screens.GameScreen.Games.ReactionScreen.ReactionTimeScreen


sealed class GameListScreen(val route: String) {
        object ReactionGame: GameListScreen("reaction_game")
        object NumberMemory: GameListScreen("number_memory")
        object AimTrainer: GameListScreen("aim_trainer")
        object VisualMemory: GameListScreen("visual_memory")
        object ChimpTest: GameListScreen("chimp_test")
}
@Composable
fun MainScreenWithNavigation() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            BasicCenterAlignedTopAppBar("Cognitive Race")
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Games.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Games.route) {
                GameScreen(navController)
            }
            composable(BottomNavItem.Stats.route) {
                StatsScreen()
            }
            composable(BottomNavItem.Profile.route) {
                ProfileScreen()
            }
            composable(BottomNavItem.Settings.route) {
                SettingsScreen()
            }
            composable(GameListScreen.ReactionGame.route) {
                ReactionTimeScreen()
            }

        }
    }
}

