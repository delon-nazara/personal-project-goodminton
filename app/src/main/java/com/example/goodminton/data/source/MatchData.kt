package com.example.goodminton.data.source

import com.example.goodminton.data.model.MatchModel

val matchData = MatchModel(
    timA = listOf("Delon", "Noled"),
    timB = listOf("Nazara", "Arazan"),
    scoreTimA = 8,
    scoreTimB = 11,
    matchDuration = (3 * 60 + 14) * 1000
)