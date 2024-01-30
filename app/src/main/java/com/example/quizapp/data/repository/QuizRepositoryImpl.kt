package com.example.quizapp.data.repository


import com.example.quizapp.Resource
import com.example.quizapp.data.api.QuizApi
import com.example.quizapp.data.models.QuizModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(private val quizApi: QuizApi):Repository  {
   // val resouce = Resource<ArrayList<QuizModel>,Boolean,Exception>()

    /*
        override suspend fun fetchAllQuestion(): Resource<ArrayList<QuizModel>, Boolean, Exception> {
            return getAllQuestion(api = quizApi, resource = resouce)
        }

     */
    override suspend fun fetchAllQuestion(
        catagory: String,
        limit: Int,
        difficulty: String
    ): List<QuizModel> {
        return quizApi.getQuiz(catagory, limit, difficulty)
    }

}