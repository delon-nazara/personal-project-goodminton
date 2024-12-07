package com.example.goodminton.viewmodel

import androidx.lifecycle.ViewModel
import com.example.goodminton.data.model.GameCardModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

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

    fun addNewGameToDatabase(
        name: String,
        location: String,
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ) {
        gameRef
            .add(
                GameCardModel(
                    name = name,
                    location = location,
                    timestamp = System.currentTimeMillis()
                )
            )
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailure() }
    }

}