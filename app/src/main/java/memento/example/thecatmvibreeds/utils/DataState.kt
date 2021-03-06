package memento.example.thecatmvibreeds.utils

import memento.example.thecatmvibreeds.model.Cat
import java.lang.Exception

sealed class DataState {
    object Idle:DataState()
    data class Success(val cats:List<Cat>):DataState()
    data class Error(val exception: Exception):DataState()
    object Loading:DataState()
}