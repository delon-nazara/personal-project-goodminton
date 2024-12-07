package com.example.goodminton.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.goodminton.R

@Composable
fun FloatingActionButton(
    onButtonClicked: () -> Unit
) {
    ExtendedFloatingActionButton(
        onClick = { onButtonClicked() },
        icon = {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null
            )
        },
        text = {
            Text(
                text = stringResource(R.string.gs_fab_text),
                style = MaterialTheme.typography.labelLarge
            )
        }
    )
}