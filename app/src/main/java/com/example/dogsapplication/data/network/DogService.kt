package com.example.dogsapplication.data.network

import com.example.dogsapplication.data.api.DogApi
import com.example.dogsapplication.data.model.DogModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogService @Inject constructor(private val api: DogApi){

    suspend fun getDogs(): List<DogModelItem> =
        withContext(Dispatchers.IO){
            try {
                val response = api.getDogs()
                response.body() ?: emptyList()
            }catch (e: Exception){
                emptyList()
            }
        }
}