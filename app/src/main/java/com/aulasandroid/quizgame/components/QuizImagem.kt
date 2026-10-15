package com.aulasandroid.quizgame.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.aulasandroid.quizgame.R

@Composable
fun QuizImagem (modifier: Modifier){
    Image(
        painterResource(R.drawable.quiz),
        contentDescription = "logo quiz",
        modifier = modifier
    )
}