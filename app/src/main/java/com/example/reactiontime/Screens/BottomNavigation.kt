package com.example.reactiontime.Screens

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

import com.example.reactiontime.data.BottomNavItem

@Composable
fun BottomNavigationBar() {
    val bottomNavItems = listOf(
        BottomNavItem.Games,
        BottomNavItem.Stats,
        BottomNavItem.Profile,
        BottomNavItem.Settings
    )

    var selectedItem by remember { mutableStateOf<BottomNavItem>(BottomNavItem.Games) } // Start with "Games" selected

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant, // Customize the background color here
    ) {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = selectedItem == item,
                onClick = {
                    selectedItem = item

                },
                icon = {
                    Icon(
                        imageVector = if (selectedItem == item) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title, fontSize = 9.sp) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Blue, // Customize selected icon color
                    unselectedIconColor = Color.Black, // Customize unselected icon color
                    selectedTextColor = Color.Blue, // Customize selected text color
                    unselectedTextColor = Color.Black // Customize unselected text color
                )
            )
        }
    }
}
@Preview
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}
