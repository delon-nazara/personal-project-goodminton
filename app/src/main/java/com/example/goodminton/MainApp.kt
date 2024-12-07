package com.example.goodminton

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.goodminton.data.source.gameCardList
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
                    onCancel = { showDialog = false },
                    onConfirm = { name, location ->
                        databaseViewModel.addNewGameToDatabase(
                            name = name,
                            location = location,
                            onSuccess = { showDialog = false },
                            onFailure = {
                                showDialog = false
                                showToast(context, context.getString(R.string.agd_failure))
                            }
                        )
                    }
                )
            }
        }
    }
}