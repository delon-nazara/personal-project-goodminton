package com.example.goodminton

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.goodminton.ui.component.AddGameDialog
import com.example.goodminton.ui.component.FloatingActionButton
import com.example.goodminton.ui.component.GameCard
import com.example.goodminton.ui.component.TopBar
import com.example.goodminton.util.showToast
import com.example.goodminton.viewmodel.DatabaseViewModel

@Preview
@Composable
fun MainApp(
    context: Context = LocalContext.current
) {
    val databaseViewModel: DatabaseViewModel = viewModel()
    val gameState by databaseViewModel.gameState.collectAsState()
    val errorNameState by databaseViewModel.errorNameState.collectAsState()
    val errorLocationState by databaseViewModel.errorLocationState.collectAsState()

    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        databaseViewModel.readGameData(
            onFailure = { showToast(context, "Failed to read game data") }
        )
    }

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
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (gameState != null) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp)
                ) {
                    itemsIndexed(gameState!!) { index, item ->
                        if (index == 0 || index == gameState!!.lastIndex) {
                            Spacer(
                                modifier = Modifier.height(10.dp)
                            )
                        }
                        GameCard(item)
                    }
                }
            }
            if (showDialog) {
                AddGameDialog(
                    errorName = errorNameState,
                    errorLocation = errorLocationState,
                    onCancel = {
                        showDialog = false
                        databaseViewModel.clearErrorState()
                    },
                    onConfirm = { name, location ->
                        databaseViewModel.createGameData(
                            name = name,
                            location = location,
                            onSuccess = {
                                showDialog = false
                                databaseViewModel.readGameData(
                                    onFailure = { showToast(context, "Failed to read game data") }
                                )
                            },
                            onFailure = { showToast(context, "Failed to add new game") }
                        )
                    }
                )
            }
        }
    }
}