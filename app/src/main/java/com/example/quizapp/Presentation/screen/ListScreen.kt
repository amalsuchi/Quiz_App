package com.example.quizapp.Presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.quizapp.ViewModel.QuizViewModel
import com.example.quizapp.ui.theme.backgroundBlue
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun listScreen(navController: NavController,viewModel: QuizViewModel){
    
    var answerindication:Boolean = false

    LaunchedEffect(Unit){
        val limit = viewModel.limit.value
        val catagory = viewModel.catagory.value
        val diff = viewModel.diff.value

        viewModel.fetchQuestions(catagory,limit,diff)
    }


    val state = viewModel.state.value

    if(state.loading){
        Column(modifier = Modifier
            .fillMaxSize()
            .background(backgroundBlue),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            CircularProgressIndicator()
        }
    }else if(!state.List.isEmpty()){
        
        Column(modifier = Modifier
            .fillMaxSize()
            .background(backgroundBlue)) {
            val currentQuestion = state.List[state.currentIndex]
            Row(modifier = Modifier
                .padding(10.dp)
                .background(Color.LightGray)){
                Text(text = "Score",modifier = Modifier.padding(6.dp), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = state.score.toString(),modifier = Modifier.padding(6.dp), fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Text(text = currentQuestion.question, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold,modifier = Modifier.padding(16.dp))
            currentQuestion.incorrectAnswers.add(0,currentQuestion.correctAnswer)
            currentQuestion.incorrectAnswers.shuffle()
            val options = currentQuestion.incorrectAnswers.toSet()
            val answer = currentQuestion.correctAnswer



            options.forEachIndexed { index, answers ->
                Button(onClick = {
                    if (answers == answer) {
                        answerindication = true
                        viewModel.selectCorrectAnswer()
                        viewModel.incrementCurrentIndex()
                        viewModel.Totalanswerdques.value += 1


                    } else {
                        answerindication = false
                    }
                }, modifier = Modifier.padding(8.dp)) {
                    Text(text = answers,modifier = Modifier.padding(16.dp))
                }
            }
            if(answerindication == false){
                Text(text = "ANSWER IS WRONG")
            }

            if (viewModel.Totalanswerdques.value >= state.List.size) {

                navController.navigate("end")

            }
        }



    } else{
        Text(text = state.error)
    }

}


@Preview
@Composable
fun mypreview(){

}