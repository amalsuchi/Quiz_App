package com.example.quizapp.Presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.quizapp.ViewModel.QuizViewModel


@Composable
fun DiffQuesScreen( navController: NavController,viewModel: QuizViewModel){
    
    val difficulty = listOf("easy", "medium", "hard")
    Column(modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center) {
        Text(text = "Choose the Difficulty", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(8.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(difficulty){
                    diff ->
                Row(modifier= Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.LightGray)
                    .clickable { viewModel.SelectDiff(diff) ;navController.navigate("list")}, horizontalArrangement = Arrangement.Center){

                    Text(text = diff, fontSize = 16.sp, modifier = Modifier.padding(16.dp) )
                }
            }
        }

    }
}