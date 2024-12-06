package com.example.goodminton.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.goodminton.R

@Composable
fun FloatingActionButton() {
    ExtendedFloatingActionButton(
        onClick = {},
        icon = { Icon(Icons.Filled.Add, null) },
        text = { Text(stringResource(R.string.fab_text)) }
    )
}