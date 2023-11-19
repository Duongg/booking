package com.example.booking.ui.home

import android.util.Log
import com.example.booking.core.BookingViewModel
import com.example.domain.BookingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bookingRepository: BookingRepository,
): BookingViewModel<HomeViewState>(
    HomeViewState()
) {
    override val _viewStateCopy: HomeViewState = viewState.copy()

    fun onUiEvent(uiEvent: HomeViewUiEvent){
        when(uiEvent){
            is HomeViewUiEvent.ScreenLoaded -> handleGetLocation()
        }
    }

    private fun handleGetLocation() = launch {
        getLocation()
    }

    suspend fun getLocation(){
        bookingRepository.getLocation("Ha noi")
            .onSuccess {
                Log.d("---TAG----","Location Success")
            }.onFailure {
                Log.d("---TAG----","Location Failed")
            }
    }

}