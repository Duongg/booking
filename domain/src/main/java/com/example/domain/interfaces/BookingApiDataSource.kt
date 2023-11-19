package com.example.domain.interfaces

import com.example.domain.entity.LocationEntity

interface BookingApiDataSource {
    suspend fun getLocation(
        location: String,
    ): Result<LocationEntity>
}