package com.aulasandroid.quizgame.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.aulasandroid.quizgame.QuizFormScreen.QuizFormScreenViewModel

@Composable
fun BotaoAlternativa(
    alternativaEscolhida: String,
    alternativaCerta: String,
    viewModel: QuizFormScreenViewModel
) {
    val alternativaSelecionada by
    viewModel.alternativaSelecionada.observeAsState(null)

    val respostaCorreta by
    viewModel.respostaCorreta.observeAsState(null)

    val buttonColor = when {
        alternativaSelecionada != alternativaEscolhida ->
            Color.Transparent

        respostaCorreta == true ->
            Color.Green

        respostaCorreta == false ->
            Color.Red

        else -> Color.Transparent
    }

    OutlinedButton(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        ),
        onClick = {
            viewModel.verificarResposta(
                alternativaEscolhida = alternativaEscolhida,
                alternativaCerta = alternativaCerta
            )
        }
    ) {
        Text(
            text = alternativaEscolhida,
            textAlign = TextAlign.Left,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth()
        )
    }
}