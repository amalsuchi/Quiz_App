package com.example.quizapp.DI

import com.example.quizapp.data.api.QuizApi
import com.example.quizapp.data.repository.QuizRepositoryImpl
import com.example.quizapp.data.repository.Repository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object quizModule {
    @Provides
    @Singleton

    fun providesapi():QuizApi{

        return Retrofit.Builder()
            .baseUrl("https://the-trivia-api.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providesRepository( api: QuizApi):Repository{
        return QuizRepositoryImpl(api)
    }

}