package com.aulasandroid.quizgame.QuizFormScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.quizgame.components.CardFormulario
import com.aulasandroid.quizgame.components.CardPergunta
import com.aulasandroid.quizgame.components.QuizImagem

@Composable
fun QuizFormScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    nome: String = "",
    viewModel: QuizFormScreenViewModel
){
    val contadorPerguntas by viewModel.contadorPerguntas.observeAsState(1)

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
            text = "Boa sorte $nome!",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Black
        )

        QuizImagem(Modifier.size(50.dp))

        CardPergunta(
            numPergunta = if (contadorPerguntas > 3)  "3" else "$contadorPerguntas"
        )

        when(contadorPerguntas){
            1 ->
                CardFormulario(
                    pergunta = "Qual a capital da Franca?",
                    alternativa1 = "Londres",
                    alternativa2 = "Berlim",
                    alternativa3 = "Paris",
                    alternativa4 = "Madri",
                    alternativaCerta = "Paris",
                    viewModel = viewModel
                )

            2 ->
                CardFormulario(
                    pergunta = "Qual planeta é conhecido como planeta vermelho?",
                    alternativa1 = "Vênus",
                    alternativa2 = "Marte",
                    alternativa3 = "Jupiter",
                    alternativa4 = "Saturno",
                    alternativaCerta = "marte",
                    viewModel = viewModel
                )

            3 ->
                CardFormulario(
                    pergunta = "Qual a capital da Austrália?",
                    alternativa1 = "Camberra",
                    alternativa2 = "Berlim",
                    alternativa3 = "Moscou",
                    alternativa4 = "Madri",
                    alternativaCerta = "Camberra",
                    viewModel = viewModel
                )

            else ->
                navController.navigate("result/$nome/${viewModel.contadorAcertos.value}")
        }
    }
}