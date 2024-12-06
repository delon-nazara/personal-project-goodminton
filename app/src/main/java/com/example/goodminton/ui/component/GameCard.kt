package com.example.goodminton.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goodminton.data.model.GameCardModel
import com.example.goodminton.util.timestampToDate
import com.example.goodminton.util.timestampToTime

@Composable
fun GameCard(gameCard: GameCardModel) {
    ElevatedCard(
        onClick = {},
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = timestampToDate(gameCard.timestamp),
                    fontStyle = FontStyle.Italic,

                )
                Text(
                    text = timestampToTime(gameCard.timestamp),
                    fontStyle = FontStyle.Italic,

                )
            }
            HorizontalDivider()
            Text(
                text = gameCard.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = gameCard.location,
                modifier = Modifier.padding(0.dp),
            )
        }
    }
}
