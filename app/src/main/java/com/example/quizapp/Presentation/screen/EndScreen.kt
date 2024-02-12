package com.example.quizapp.Presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizapp.ViewModel.QuizViewModel
import com.example.quizapp.ui.theme.backgroundBlue

@Composable
fun EndScreen(navController: NavController,viewModel: QuizViewModel){

    val state = viewModel.state.value
    Column(
        modifier = Modifier.fillMaxSize().background(backgroundBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Score ${state.score.toString()}",
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
        Button(
            onClick = { navController.navigate("start") },
            modifier = Modifier.padding(24.dp)
        ) {
            Text(text = "Home", fontSize = 16.sp, modifier = Modifier.padding(16.dp))
        }
    }
}