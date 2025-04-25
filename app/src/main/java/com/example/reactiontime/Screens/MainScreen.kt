package com.example.reactiontime.Screens


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
import com.example.reactiontime.Screens.GameScreen.GameScreen
import com.example.reactiontime.Screens.ProfileScreen.ProfileScreen
import com.example.reactiontime.Screens.SettingsScreen.SettingsScreen
import com.example.reactiontime.Screens.StatsScreen.StatsScreen
import com.example.reactiontime.data.BottomNavItem


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
                GameScreen()
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
