package com.aulasandroid.quizgame.QuizResultScreen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.quizgame.components.QuizImagem

@Composable
fun QuizResultScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    nome: String = "",
    acertos: Int = 0
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
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
                ),
                border = BorderStroke(1.dp,Color.Black)
            ) {
                Text(
                    text = "Bom trabalho $nome!",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(60.dp, 10.dp)
                )
            }

            Text(
                text = "Você acertou $acertos de 3 perguntas",
                fontSize = 20.sp,
                color = Color.Black
                )
        }

        Button(
            onClick = {
                navController.navigate("form/$nome")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow
            ),
            border = BorderStroke(1.dp,Color.Black)
        ) {
            Text(
                text = "JOGAR NOVAMENTE",
                color = Color.Black,
                fontSize = 20.sp
            )
        }
    }
}