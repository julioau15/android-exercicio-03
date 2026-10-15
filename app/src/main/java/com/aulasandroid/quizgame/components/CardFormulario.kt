package com.aulasandroid.quizgame.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aulasandroid.quizgame.QuizFormScreen.QuizFormScreenViewModel

@Composable
fun CardFormulario (
    pergunta: String,
    alternativa1: String,
    alternativa2: String,
    alternativa3: String,
    alternativa4: String,
    alternativaCerta: String,
    viewModel: QuizFormScreenViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = pergunta,
                color = Color.Black
            )

            BotaoAlternativa(
                alternativaEscolhida =  alternativa1,
                alternativaCerta = alternativaCerta,
                viewModel
            )

            BotaoAlternativa(
                alternativaEscolhida =  alternativa2,
                alternativaCerta = alternativaCerta,
                viewModel
            )

            BotaoAlternativa(
                alternativaEscolhida =  alternativa3,
                alternativaCerta = alternativaCerta,
                viewModel
            )


            BotaoAlternativa(
                alternativaEscolhida =  alternativa4,
                alternativaCerta = alternativaCerta,
                viewModel
            )

        }
    }
}