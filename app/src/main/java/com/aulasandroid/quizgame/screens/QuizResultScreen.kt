package com.aulasandroid.quizgame.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuizResultScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(0.dp, 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        QuizImagem(Modifier.size(80.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(40.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Green
                )
            ) {
                Text(
                    text = "Bom trabalho!",
                    modifier = Modifier
                        .padding(60.dp, 10.dp)
                )
            }

            Text("Você acertou 1 de 3 perguntas")
        }

        Button(
            onClick = {}
        ) {
            Text(
                text = "JOGAR NOVAMENTE"
            )
        }
    }

}