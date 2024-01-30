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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.quizapp.ViewModel.QuizViewModel

@Composable
fun CatagoryScreen(navController: NavController,viewModel: QuizViewModel){

    val categories = listOf(
        "Music" to "music",
        "Sport And Leisure" to "sport_and_leisure",
        "Film And TV" to "film_and_tv",
        "Arts And Literature" to "arts_and_literature",
        "History" to "history",
        "Society And Culture" to "society_and_culture",
        "Science" to "science",
        "Geography" to "geography",
        "Food And Drink" to "food_and_drink",
        "General Knowledge" to "general_knowledge")

    Column(modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center) {
        Text(text = "Choose the Catagory", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(8.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(categories){
                category ->
                Row(modifier= Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.LightGray)
                    .clickable { viewModel.SelectCatagory(category.second);navController.navigate("limit") },
                    horizontalArrangement = Arrangement.Center){

                    Text(text = category.first, fontSize = 16.sp, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}