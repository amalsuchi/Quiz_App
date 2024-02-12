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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.quizapp.ViewModel.QuizViewModel
import com.example.quizapp.ui.theme.backgroundBlue
import com.example.quizapp.ui.theme.darkBlue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun limitScreen(navController: NavController,viewModel:QuizViewModel){
    Column(modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center) {
        val numbers = (1..20).toList()
        Text(text = "Choose the Number of Questions", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(8.dp))
        LazyColumn(modifier = Modifier.fillMaxSize().background(backgroundBlue)){
            items(numbers){
                    num ->
                Row(modifier= Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(darkBlue)
                    .clickable {
                        viewModel.Selectlimit(num)
                        CoroutineScope(Dispatchers.Main).launch {
                            delay(1000L) // Wait for 100 milliseconds
                            navController.navigate("diff")
                        }
                    }){
                    Text(text = "$num",modifier = Modifier.padding(16.dp), fontSize = 16.sp, color = Color.White)
                }
            }
        }
    }


}