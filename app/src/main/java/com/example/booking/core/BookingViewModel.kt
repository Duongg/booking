package com.example.booking.core

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BookingViewModel<STATE: BookingState>(
    defaultState: STATE
): ViewModel() {

    val viewState: STATE get() = _viewState.value
    private val _viewState = mutableStateOf(defaultState)

    abstract val _viewStateCopy: STATE

    protected fun <T> launch(
        dispatcher: CoroutineDispatcher = Dispatchers.Main,
        block: suspend () -> T,
    ): Job{
        return viewModelScope.launch(dispatcher){
            block()
        }
    }
}