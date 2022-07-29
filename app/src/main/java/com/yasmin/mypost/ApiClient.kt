package com.yasmin.mypost

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(GsonConverterFactory.create()).build()

    fun <T> BuildApiClient(apiInterface: Class<T>): T{
        return retrofit.create(apiInterface)
    }
}