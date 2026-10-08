package com.aulasandroid.quizgame.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuizFormScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(172, 115, 191, 255))
            .padding(50.dp),
        verticalArrangement = Arrangement.spacedBy(
            20.dp,
            Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Boa sorte Julio!",
            fontSize = 20.sp
        )

        QuizImagem(Modifier.size(50.dp))

        CardPergunta("1")

        CardFormulario(
            pergunta = "Qual a capital da Franca?"
        )

    }
}

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
            modifier = Modifier
                .padding(20.dp, 10.dp)
        )
    }
}

@Composable
fun CardFormulario (pergunta: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Column(
            Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = pergunta
            )

            BotaoAlternativa("Londres")
            BotaoAlternativa("Londres")
            BotaoAlternativa("Londres")
            BotaoAlternativa("Londres")

        }
    }
}

@Composable
fun BotaoAlternativa(alternativa: String){
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {
            
        }
    ) {
        Text(
            text = alternativa,
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )
    }
}