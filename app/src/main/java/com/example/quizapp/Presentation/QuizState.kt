package com.example.quizapp.Presentation

import com.example.quizapp.data.models.QuizModel

data class QuizState(
    val List :List<QuizModel> = emptyList(),
    val loading :Boolean =false,
    val error:String = "",
    val currentIndex: Int = 0,
    val score:Int = 0,
)
