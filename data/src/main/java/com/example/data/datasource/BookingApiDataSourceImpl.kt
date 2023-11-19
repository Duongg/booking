package com.example.data.datasource

import com.example.data.api.BookingApi
import com.example.data.api.mapper.toEntity
import com.example.domain.entity.LocationEntity
import com.example.domain.interfaces.BookingApiDataSource
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookingApiDataSourceImpl @Inject constructor(
    private val bookingApi: BookingApi,
    dispatcher: CoroutineDispatcher
):RetrofitDataSource(coroutineDispatcher = dispatcher), BookingApiDataSource {
    override suspend fun getLocation(location: String): Result<LocationEntity> {
       return apiCall {
           bookingApi.getLocation(location)
       }.map { it.toEntity() }
    }
}