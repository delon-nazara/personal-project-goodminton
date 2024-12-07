package com.example.goodminton

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.goodminton.data.model.GameModel
import com.example.goodminton.data.source.Route
import com.example.goodminton.ui.screen.GameScreen
import com.example.goodminton.ui.screen.LeaderboardScreen
import com.example.goodminton.ui.screen.MatchScreen
import com.example.goodminton.util.showToast
import com.example.goodminton.viewmodel.DatabaseViewModel

@Preview
@Composable
fun MainApp(
    context: Context = LocalContext.current
) {
    val databaseViewModel: DatabaseViewModel = viewModel()
    var gameDataChoosen by remember { mutableStateOf(GameModel()) }

    LaunchedEffect(Unit) {
        databaseViewModel.readGameData(
            onFailure = { showToast(context, "Failed to read game data") }
        )
    }

    val navController: NavHostController = rememberNavController()
    val startDestination = Route.GAME_SCREEN.name

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Route.GAME_SCREEN.name) {
            GameScreen(
                databaseViewModel = databaseViewModel,
                onGameCardClicked = { gameData ->
                    gameDataChoosen = gameData
                    navController.navigate(Route.MATCH_SCREEN.name)
                }
            )
        }

        composable(Route.MATCH_SCREEN.name) {
            MatchScreen(
                gameData = gameDataChoosen,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Route.LEADERBOARD_SCREEN.name) {
            LeaderboardScreen()
        }
    }

}