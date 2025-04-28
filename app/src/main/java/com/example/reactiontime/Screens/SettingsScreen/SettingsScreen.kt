package com.example.reactiontime.Screens.SettingsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController

@Composable
fun SettingsScreen(navController: NavController){
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Profile Screen")
        Button(onClick = {
            navController.navigate("reaction_game")
        }) {
            Text("Reactiojn game ")
        }
    }
}
