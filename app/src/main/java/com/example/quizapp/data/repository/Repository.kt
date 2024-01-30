package com.example.quizapp.data.repository

import com.example.quizapp.Resource
import com.example.quizapp.data.models.QuizModel

interface Repository {
    suspend fun fetchAllQuestion(catagory: String,limit:Int,difficulty:String):List<QuizModel>
}