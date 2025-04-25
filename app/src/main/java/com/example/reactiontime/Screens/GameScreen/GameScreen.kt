package com.example.reactiontime.Screens.GameScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.reactiontime.R
import com.example.reactiontime.data.Game
import kotlin.collections.forEach
@Composable
fun GameScreen() {
    val games = remember {
        listOf(
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

@Composable
fun GameList(games: List<Game>,modifier: Modifier) {
    Column(modifier = Modifier.padding(8.dp)) {
        games.forEach { game ->
            GameCard(
                game = game,
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameCard(game: Game) {
    ElevatedCard(
        onClick = {
            // here we will navigate to game screen
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(game.image),
                contentDescription = game.title,
                modifier = Modifier
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = game.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = game.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}