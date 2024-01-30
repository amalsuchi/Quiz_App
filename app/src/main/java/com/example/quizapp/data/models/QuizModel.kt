package com.example.quizapp.data.models

data class QuizModel( val category: String,
                      val id: String,
                      val correctAnswer: String,
                      val incorrectAnswers: ArrayList<String>,
                      val question:String,
                      val tags: ArrayList<String>,
                      val type: String,
                      val difficulty: String,
                      val regions: ArrayList<Int>,
                      val isNiche: Boolean)
data class QuestionText(
    val text: String
)
