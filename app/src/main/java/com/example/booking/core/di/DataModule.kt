package com.example.booking.core.di

import com.example.data.datasource.BookingApiDataSourceImpl
import com.example.domain.interfaces.BookingApiDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceBindingModule {

    @Binds
    abstract fun bindBookingDataSource(bookingApiDataSource: BookingApiDataSourceImpl): BookingApiDataSource
}