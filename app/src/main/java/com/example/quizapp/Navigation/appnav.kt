package com.example.quizapp.Navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.Presentation.screen.CatagoryScreen
import com.example.quizapp.Presentation.screen.DiffQuesScreen
import com.example.quizapp.Presentation.screen.EndScreen
import com.example.quizapp.Presentation.screen.StartScreen
import com.example.quizapp.Presentation.screen.limitScreen
import com.example.quizapp.Presentation.screen.listScreen
import com.example.quizapp.ViewModel.QuizViewModel

@Composable
fun appnav(){
    val navController = rememberNavController()
    val viewModel : QuizViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = "Start" ){
        composable(route = "start"){
            StartScreen(navController = navController,viewModel)
        }
        composable(route = "catagory"){
            CatagoryScreen(navController = navController,viewModel)
        }
        composable(route = "diff"){
            DiffQuesScreen(navController = navController,viewModel)
        }
        composable(route = "limit"){
            limitScreen(navController = navController,viewModel)
        }
        composable(route = "list"){
            listScreen(navController = navController,viewModel)
        }
        composable(route = "end"){
            EndScreen(navController = navController,viewModel)
        }
    }

}