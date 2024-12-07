package com.example.goodminton.data.model

data class MatchModel(
    val timA: List<String> = emptyList(),
    val timB: List<String> = emptyList(),
    val scoreTimA: Int = 0,
    val scoreTimB: Int = 0,
    val matchDuration: Long = 0
)
