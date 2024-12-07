package com.example.goodminton.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goodminton.data.model.GameModel
import com.example.goodminton.util.timestampToDate
import com.example.goodminton.util.timestampToTime

@Composable
fun GameCard(
    gameData: GameModel
) {
    ElevatedCard(
        onClick = {},
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = timestampToDate(gameData.timestamp),
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = timestampToTime(gameData.timestamp),
                    style = MaterialTheme.typography.labelMedium
                )
            }
            HorizontalDivider(
                modifier = Modifier.padding(top = 6.dp)
            )
            Text(
                text = gameData.name,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 8.dp, bottom = 2.dp)
            )
            Text(
                text = gameData.location,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
