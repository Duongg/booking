package com.example.data.api.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenHeaderInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
         request = request.newBuilder()
            .addHeader("X-RapidAPI-Key", "38afb06e9amsh741daf9adf66928p1fd772jsn1e3294d3f283")
            .addHeader("X-RapidAPI-Host", "apidojo-booking-v1.p.rapidapi.com")
             .build()

        return chain.proceed(request)
    }
}