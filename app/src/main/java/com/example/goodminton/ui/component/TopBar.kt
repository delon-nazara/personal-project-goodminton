package com.example.goodminton.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    titleText: String,
    titleStyle: TextStyle,
    canNavigateBack: Boolean,
    navigateBack: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = titleText,
                style = titleStyle
            )
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(
                    onClick = { navigateBack() }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = if (canNavigateBack) {
                Color.Unspecified
            } else {
                MaterialTheme.colorScheme.primaryContainer
            },
            titleContentColor = if (canNavigateBack) {
                Color.Unspecified
            } else {
                MaterialTheme.colorScheme.primary
            }
        )
    )
}