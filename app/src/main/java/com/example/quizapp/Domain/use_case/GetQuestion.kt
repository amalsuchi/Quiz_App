package com.example.quizapp.Domain.use_case

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.quizapp.Resource
import com.example.quizapp.data.models.QuizModel
import com.example.quizapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetQuestion @Inject constructor(
    private val repository: Repository
){
    operator fun invoke(catagory: String,limit:Int,difficulty:String): Flow<Resource<List<QuizModel>>> = flow {
        try {
            emit(Resource.Loading<List<QuizModel>>())
            val questions = repository.fetchAllQuestion(catagory, limit, difficulty)
            emit(Resource.Success<List<QuizModel>>(questions))
        } catch(e: HttpException) {
            emit(Resource.Error<List<QuizModel>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<QuizModel>>("Couldn't reach server. Check your internet connection."))
        }

    }
}
