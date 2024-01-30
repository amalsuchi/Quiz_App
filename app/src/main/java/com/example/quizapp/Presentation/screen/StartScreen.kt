package com.example.quizapp.Presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizapp.ViewModel.QuizViewModel

@Composable
fun StartScreen(navController: NavController,viewModel: QuizViewModel){
    val state = viewModel.state.value
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "High Score ${state.score.toString()}",modifier = Modifier.padding(20.dp), fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        Button(onClick = {navController.navigate("catagory")  }) {
            viewModel.Totalanswerdques.value = 0
            Text(text = "Play", modifier = Modifier.padding(20.dp), fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        }
    }
}