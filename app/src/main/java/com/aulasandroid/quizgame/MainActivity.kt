package com.aulasandroid.quizgame


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aulasandroid.quizgame.QuizFormScreen.QuizFormScreen
import com.aulasandroid.quizgame.QuizHomeScreen.QuizHomeScreen
import com.aulasandroid.quizgame.QuizResultScreen.QuizResultScreen
import com.aulasandroid.quizgame.ui.theme.QuizGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            ) + fadeOut(animationSpec = tween(1000))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            )
                        }
                    ) {
                        composable(route = "home") {
                            QuizHomeScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController
                            )
                        }

                        composable(
                            route = "form/{nome}",
                            arguments = listOf(
                                navArgument(name = "nome"){
                                    type = NavType.StringType
                                }
                            )
                        ){
                            val nome = it.arguments?.getString("nome")

                            QuizFormScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                nome = nome!!,
                                viewModel = viewModel()
                            )

                        }

                        composable(
                            route = "result/{nome}/{acertos}",
                            arguments = listOf(
                                navArgument(name = "nome"){
                                    type = NavType.StringType
                                },
                                navArgument(name = "acertos"){
                                    type = NavType.IntType
                                }
                            )
                            ){
                            val nome = it.arguments?.getString("nome")
                            val acertos = it.arguments?.getInt("acertos")
                            QuizResultScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                nome = nome!!,
                                acertos = acertos!!
                            )
                        }
                    }

                }
            }
        }
    }
}