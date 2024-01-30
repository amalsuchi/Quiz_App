package com.example.quizapp.data.api

import com.example.quizapp.data.models.Questions
import com.example.quizapp.data.models.QuizModel
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizApi {
    @GET("api/questions")
    suspend fun getQuiz(
        @Query("categories") catagory:String,
        @Query("limit") limit: Int,
        @Query("difficulty")difficulty:String
    ):List<QuizModel>
}

//https://the-trivia-api.com/api/questions?categories=food_and_drink&limit=20&difficulty=easy