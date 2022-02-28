package com.example.dogsapplication.data.api

import com.example.dogsapplication.data.model.DogModelItem
import retrofit2.Response
import retrofit2.http.GET

interface DogApi {
    @GET("945366962796773376")
    suspend fun getDogs(): Response<List<DogModelItem>>
}