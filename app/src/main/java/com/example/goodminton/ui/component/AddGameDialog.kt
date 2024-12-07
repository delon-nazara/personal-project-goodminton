package com.example.goodminton.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.goodminton.R

@Preview
@Composable
fun AddGameDialog(
    onDismissRequest: () -> Unit = {}
) {
    var gameName by remember { mutableStateOf("") }
    var gameLocation by remember { mutableStateOf("") }

    Dialog(
        onDismissRequest = { onDismissRequest() },
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = stringResource(R.string.agd_title),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                TextInput(
                    value = gameName,
                    onValueChange = { gameName = it },
                    label = R.string.agd_name
                )
                TextInput(
                    value = gameLocation,
                    onValueChange = { gameLocation = it },
                    label = R.string.agd_location
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    ActionButton(
                        onDismissRequest = onDismissRequest,
                        text = R.string.cancel
                    )
                    ActionButton(
                        onDismissRequest = onDismissRequest,
                        text = R.string.confirm
                    )
                }
            }
        }
    }
}

@Composable
fun TextInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: Int
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(
                text = stringResource(label)
            )
        },
        singleLine = true
    )
}

@Composable
fun ActionButton(
    onDismissRequest: () -> Unit,
    text: Int
) {
    TextButton(
        contentPadding = PaddingValues(horizontal = 10.dp),
        onClick = { onDismissRequest() },
        modifier = Modifier.height(30.dp)
    ) {
        Text(
            text = stringResource(text)
        )
    }
}