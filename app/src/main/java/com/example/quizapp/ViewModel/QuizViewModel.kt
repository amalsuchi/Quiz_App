package com.example.quizapp.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.Domain.use_case.GetQuestion

import com.example.quizapp.Presentation.QuizState
import com.example.quizapp.Resource

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(private val usecase: GetQuestion):ViewModel() {
    private val _state = mutableStateOf(QuizState())
    val state: State<QuizState> = _state

    val catagory = mutableStateOf("")
    fun SelectCatagory(new:String){
        catagory.value = new
    }
    val diff = mutableStateOf("")
    fun SelectDiff(new:String){
        diff.value = new
    }
    val limit = mutableStateOf(0)
    fun Selectlimit(new:Int){
        println("Selectlimit called with $new")
        limit.value = new
    }
    val Totalanswerdques = mutableStateOf(0)





    //set the data for the state which contains the data to be shown on screen
     fun fetchQuestions(catagory: String,limit:Int,difficulty:String){
        println("fetchQuestions called with category=$catagory, limit=$limit, difficulty=$difficulty")
        usecase(catagory, limit, difficulty).onEach { result->
            when(result){
                is Resource.Success ->{
                    _state.value = QuizState(List = result.data ?: emptyList())
                }
                is Resource.Error ->{
                    _state.value = QuizState(error = result.message ?: "an error occured")
                }
                is Resource.Loading ->{
                    _state.value = QuizState(loading = true)
                }
            }
        }.launchIn(viewModelScope)//because flow are asynchronus
    }

    fun selectCorrectAnswer() {
        // You can update your state here to indicate that the correct answer was selected
        // For example, you might want to increase a score counter
        _state.value = _state.value.copy(score = _state.value.score + 1)
    }
    fun incrementCurrentIndex() {
        // Check if currentIndex is less than the size of the list to avoid IndexOutOfBoundsException
        if (_state.value.currentIndex < _state.value.List.size - 1) {
            _state.value = _state.value.copy(currentIndex = _state.value.currentIndex + 1)
        }
    }


}