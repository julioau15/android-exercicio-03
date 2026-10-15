package com.aulasandroid.quizgame.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardPergunta (numPergunta: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Green
        ),
        border = BorderStroke(1.dp,Color.Black)

    ) {
        Text(
            text = "Pergunta $numPergunta de 3",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(20.dp, 10.dp)
        )
    }
}