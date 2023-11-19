package com.example.booking.ui.home

import com.example.booking.core.BookingState

data class HomeViewState(override var requestInProgress: Boolean = false): BookingState()