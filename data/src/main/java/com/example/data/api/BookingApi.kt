package com.example.data.api

import com.example.data.api.dto.response.LocationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookingApi {
    @GET("locations/auto-complete")
    suspend fun getLocation(@Query("text") location: String, @Query("languagecode") languageCode: String = "en-us"): Response<LocationResponse>
}