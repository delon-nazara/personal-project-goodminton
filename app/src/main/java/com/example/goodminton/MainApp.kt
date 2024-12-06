package com.example.goodminton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.goodminton.ui.component.FloatingActionButton
import com.example.goodminton.ui.component.TopBar

@Preview
@Composable
fun MainApp() {
    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = { FloatingActionButton() }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {

        }
    }
}