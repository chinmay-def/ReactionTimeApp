package com.example.reactiontime.Screens.GameScreen.ReactionScreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.reactiontime.R
import com.example.reactiontime.Screens.GameScreen.ReactionScreen.ReactionTimeViewModel
import com.example.reactiontime.data.GameState
import com.example.reactiontime.data.ReactionState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReactionTimeScreen(viewModel: ReactionTimeViewModel) {
    val uiState: ReactionState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Reaction Time Challenge",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant // Softer color
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background // Use Material theme background
    ) { innerPadding ->
        ReactionTimeScreenContent(
            modifier = Modifier.padding(innerPadding),
            uiState = uiState,
            onScreenTap = { viewModel.onScreenTap() },
            onStartTap = { viewModel.startGame() },
        )
    }
}

@Composable
fun ReactionTimeScreenContent(
    uiState: ReactionState,
    onScreenTap: () -> Unit,
    onStartTap: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.f1_background), // Load from drawable
            contentDescription = "F1 Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.5f // Adjust alpha as needed (0f - 1f)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            // Main Circle
            Box(
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape)
                    .background(uiState.backgroundColor)
                    .clickable(enabled = uiState.backgroundColor != Color.Gray || uiState.message == "Tap to Start") {
                        if (uiState.backgroundColor != Color.Gray) {
                            onScreenTap()
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                // Main Message (Inside the Circle)
                Text(
                    text = when (uiState.gameState) {
                        GameState.Result -> "" // We will show it outside of circle
                        GameState.Waiting -> "Wait"
                        GameState.Ready -> "Tap!"
                        GameState.TooSoon -> "Too Soon"
                        GameState.Idle -> "Tap to Start"
                    },
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            }

            // Reaction Time (or "Tap to Play Again")
            if (uiState.gameState == GameState.Result) {
                Text(
                    text = "Your Reaction Time:",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "${uiState.reactionTime} ms",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                )
            } else {
                Spacer(modifier = Modifier.height(0.dp)) // To maintain spacing
            }

            // Start Button
            if (uiState.gameState == GameState.Idle) {
                Button(onClick = { onStartTap() },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Start", fontSize = 20.sp, color = Color.White)
                }
            }
        }
    }
}