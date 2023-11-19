package com.example.data.api.mapper

import com.example.data.api.dto.response.LocationResponse
import com.example.domain.entity.LocationEntity

fun LocationResponse.toEntity() = LocationEntity(
    cityName = cityName,
    country = country
)