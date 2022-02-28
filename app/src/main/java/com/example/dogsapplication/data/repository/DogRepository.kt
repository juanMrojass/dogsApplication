package com.example.dogsapplication.data.repository

import com.example.dogsapplication.data.db.dao.DogDao
import com.example.dogsapplication.data.model.DogModelItem
import com.example.dogsapplication.data.network.DogService
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val dogService: DogService,
    private val dogDao: DogDao
) {

    suspend operator fun invoke(): List<DogModelItem> {
        return if (dogDao.getAllDogs().isNotEmpty()) {
            //Get Data from DB
            dogDao.getAllDogs()
        } else {
            //Update DB from api data
            dogDao.insertAllDogs(dogService.getDogs())
            dogService.getDogs()
        }
    }


}