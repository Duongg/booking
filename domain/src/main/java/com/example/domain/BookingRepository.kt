package com.example.domain

import com.example.domain.entity.LocationEntity
import com.example.domain.interfaces.BookingApiDataSource
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class BookingRepository @Inject constructor(
    private val bookingApiDataSource: BookingApiDataSource,
    dispatcher: CoroutineDispatcher
): CoroutineAware(dispatcher) {

    suspend fun getLocation(
        location: String
    ): Result<LocationEntity> = async {
        bookingApiDataSource.getLocation(location)
    }
}