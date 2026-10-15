package com.aulasandroid.quizgame.QuizHomeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.quizgame.components.QuizImagem

@Composable
fun QuizHomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    var nome by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(50.dp),
        verticalArrangement = Arrangement.spacedBy(
            60.dp,
            Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        QuizImagem(Modifier.size(100.dp))

        Text(
            text = "QUIZATRON 3000",
            fontSize = 35.sp,
            color = Color.Black
        )

        OutlinedTextField(
            value = nome,
            onValueChange = {nome = it},
            shape = RoundedCornerShape(20.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            ),
            placeholder = {
                Text(
                text = "Digite o seu nome: ",
                color = Color.Black
                )
            },
            label = {
                Text(
                    text = "Qual o seu nome?",
                    color = Color.Black
                )
            }
        )

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            ),
            border = BorderStroke(1.dp, Color.Black),
            onClick = {
                navController.navigate("form/$nome")
            }
        ) {
            Text(
                text = "COMEÇAR!",
                color = Color.Black
            )
        }

    }
}