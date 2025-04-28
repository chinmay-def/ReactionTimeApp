package com.example.reactiontime.navigation


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reactiontime.Screens.ProfileScreen.ProfileScreen
import com.example.reactiontime.Screens.SettingsScreen.SettingsScreen
import com.example.reactiontime.Screens.StatsScreen.StatsScreen
import com.example.reactiontime.data.BottomNavItem


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
               GameNavGraph()
            }
            composable(BottomNavItem.Stats.route) {
                StatsScreen()
            }
            composable(BottomNavItem.Profile.route) {
                ProfileScreen()
            }
            composable(BottomNavItem.Settings.route) {
                SettingsScreen(navController)
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicCenterAlignedTopAppBar(title: String) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant // Softer background color
        )
    )
}
