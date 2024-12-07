package com.example.goodminton.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.goodminton.data.model.GameModel
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
                titleStyle = MaterialTheme.typography.titleMedium,
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

        }
    }
}