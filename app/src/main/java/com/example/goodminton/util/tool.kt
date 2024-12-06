package com.example.goodminton.util

import java.text.SimpleDateFormat
import java.util.Locale

fun timestampToDate(timestamp: Long): String {
    val formatter = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("id", "ID"))
    return formatter.format(timestamp)
}

fun timestampToTime(timestamp: Long): String {
    val formatter = SimpleDateFormat("HH:mm", Locale("id", "ID"))
    return formatter.format(timestamp)
}