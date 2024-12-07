package com.example.goodminton.util

import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Locale

fun showToast(
    context: Context,
    message: String
) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun convertToDate(
    timestamp: Long
): String {
    val formatter = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("id", "ID"))
    return formatter.format(timestamp)
}

fun convertToHour(
    timestamp: Long
): String {
    val formatter = SimpleDateFormat("HH:mm", Locale("id", "ID"))
    return formatter.format(timestamp)
}

fun convertToMinute(
    timestamp: Long
): String {
    val formatter = SimpleDateFormat("mm:ss", Locale("id", "ID"))
    return formatter.format(timestamp)
}