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
import com.example.goodminton.data.model.GameModel
import com.example.goodminton.util.timestampToDate
import com.example.goodminton.util.timestampToTime

@Composable
fun GameCard(
    gameData: GameModel
) {
    ElevatedCard(
        onClick = {},
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
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
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = timestampToTime(gameData.timestamp),
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic
                )
            }
            HorizontalDivider()
            Text(
                text = gameData.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp, bottom = 2.dp)
            )
            Text(
                text = gameData.location,
                fontSize = 14.sp
            )
        }
    }
}
