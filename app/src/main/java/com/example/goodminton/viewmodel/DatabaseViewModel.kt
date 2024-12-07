package com.example.goodminton.viewmodel

import androidx.lifecycle.ViewModel
import com.example.goodminton.data.model.GameModel
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DatabaseViewModel : ViewModel() {

    /**
     *  Database structure (firestore)
     *  /game (collection)
     *      /gameId (document)
     *          /name (string)
     *          /location (string)
     *          /timestamp(number)
     */

    private val database = Firebase.firestore
    private val gameRef = database.collection("game")

    private val _gameState = MutableStateFlow<List<GameModel>?>(null)
    val gameState: StateFlow<List<GameModel>?> = _gameState.asStateFlow()

    private val _errorNameState = MutableStateFlow<String?>(null)
    val errorNameState: StateFlow<String?> = _errorNameState.asStateFlow()

    private val _errorLocationState = MutableStateFlow<String?>(null)
    val errorLocationState: StateFlow<String?> = _errorLocationState.asStateFlow()

    fun createGameData(
        name: String,
        location: String,
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ) {
        if (name.isEmpty()) {
            _errorNameState.update { "Name cannot be empty" }
        } else if (location.isEmpty()) {
            _errorNameState.update { null }
            _errorLocationState.update { "Location cannot be empty" }
        } else {
            clearErrorState()
            gameRef
                .add(
                    GameModel(
                        name = name,
                        location = location,
                        timestamp = System.currentTimeMillis()
                    )
                )
                .addOnSuccessListener { onSuccess() }
                .addOnFailureListener { onFailure() }
        }
    }

    fun readGameData(
        onFailure: () -> Unit
    ) {
        gameRef
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { documents ->
                _gameState.update {
                    documents.mapNotNull { document ->
                        document.toObject(GameModel::class.java)
                    }
                }
            }
            .addOnFailureListener { onFailure() }
    }

    fun clearErrorState() {
        _errorNameState.update { null }
        _errorLocationState.update { null }
    }

}