package com.example.reactiontime.Screens


import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight




//@Composable
//fun MainScreen(){
//    Scaffold (topBar = {
//       BasicCenterAlignedTopAppBar("Cognitive Race")
//    },
//        bottomBar = {BottomNavigationBar()}
//    ){
//        innerPadding->
//
//
//    }
//}

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
