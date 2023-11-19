package com.example.booking.ui.home

sealed interface HomeViewUiEvent{
    class ScreenLoaded() : HomeViewUiEvent
}
