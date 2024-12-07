package com.example.goodminton.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.goodminton.R

@Preview
@Composable
fun AddGameDialog(
    errorName: String? = null,
    errorLocation: String? = null,
    onCancelClicked: () -> Unit = {},
    onConfirmClicked: (String, String) -> Unit = { _, _ -> }
) {
    var gameName by remember { mutableStateOf("") }
    var gameLocation by remember { mutableStateOf("") }

    Dialog(
        onDismissRequest = { onCancelClicked() },
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = stringResource(R.string.agd_title),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
                TextInput(
                    value = gameName,
                    errorMessage = errorName,
                    leadingIcon = Icons.Filled.Edit,
                    label = R.string.agd_name,
                    onValueChange = { gameName = it }
                )
                TextInput(
                    value = gameLocation,
                    errorMessage = errorLocation,
                    leadingIcon = Icons.Filled.LocationOn,
                    label = R.string.agd_location,
                    onValueChange = { gameLocation = it }
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    ActionButton(
                        onButtonClicked = { onCancelClicked() },
                        text = R.string.agd_cancel
                    )
                    ActionButton(
                        onButtonClicked = { onConfirmClicked(gameName, gameLocation) },
                        text = R.string.agd_confirm
                    )
                }
            }
        }
    }
}

@Composable
fun TextInput(
    value: String,
    errorMessage: String?,
    leadingIcon: ImageVector,
    label: Int,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        textStyle = MaterialTheme.typography.bodyMedium,
        isError = errorMessage != null,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null
            )
        },
        label = {
            Text(
                text = stringResource(label),
                style = MaterialTheme.typography.labelLarge
            )
        },
        supportingText = {
            if (errorMessage != null) {
                Text(
                    text = errorMessage
                )
            }
        },
    )
}

@Composable
fun ActionButton(
    onButtonClicked: () -> Unit,
    text: Int
) {
    TextButton(
        contentPadding = PaddingValues(horizontal = 10.dp),
        onClick = { onButtonClicked() },
        modifier = Modifier.height(30.dp)
    ) {
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.labelLarge
        )
    }
}