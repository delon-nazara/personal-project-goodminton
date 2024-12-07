package com.example.goodminton.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.goodminton.data.model.GameModel
import com.example.goodminton.data.source.matchData
import com.example.goodminton.ui.component.TopBar

@Composable
fun MatchScreen(
    gameData: GameModel,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                titleText = gameData.name,
                titleStyle = MaterialTheme.typography.titleLarge,
                canNavigateBack = true,
                navigateBack = { navigateBack() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ElevatedCard(
                onClick = {},
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 4.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    TimData(
                        player1 = matchData.timA[0],
                        player2 = matchData.timA[1],
                        score = matchData.scoreTimA.toString(),
                        isVictory = false
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "VS",
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                    TimData(
                        player1 = matchData.timB[0],
                        player2 = matchData.timB[1],
                        score = matchData.scoreTimB.toString(),
                        isVictory = true
                    )
                }
            }
        }
    }
}

@Composable
fun TimData(
    player1: String,
    player2: String,
    score: String,
    isVictory: Boolean,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = player1,
            style = MaterialTheme.typography.titleMedium,
            color = if (isVictory) {
                MaterialTheme.colorScheme.error
            } else {
                Color.Unspecified
            }
        )
        Text(
            text = player2,
            style = MaterialTheme.typography.titleMedium,
            color = if (isVictory) {
                MaterialTheme.colorScheme.error
            } else {
                Color.Unspecified
            }
        )
        Text(
            text = score,
            style = MaterialTheme.typography.headlineMedium,
            color = if (isVictory) {
                MaterialTheme.colorScheme.error
            } else {
                Color.Unspecified
            },
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}