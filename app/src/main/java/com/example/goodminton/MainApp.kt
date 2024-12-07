package com.example.goodminton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.goodminton.data.source.gameCardList
import com.example.goodminton.ui.component.AddGameDialog
import com.example.goodminton.ui.component.FloatingActionButton
import com.example.goodminton.ui.component.GameCard
import com.example.goodminton.ui.component.TopBar

@Preview
@Composable
fun MainApp() {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LazyColumn {
                items(gameCardList) { gameCard ->
                    GameCard(gameCard)
                }
            }
            if (showDialog) {
                AddGameDialog(
                    onDismissRequest = { showDialog = false }
                )
            }
        }
    }
}