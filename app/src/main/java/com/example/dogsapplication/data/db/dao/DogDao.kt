package com.example.dogsapplication.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dogsapplication.data.model.DogModelItem

@Dao
interface DogDao {
    @Query("SELECT * FROM dog_table")
    suspend fun getAllDogs():List<DogModelItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDogs(dogs: List<DogModelItem>)

    @Query("DELETE FROM dog_table")
    suspend fun deleteAllDogs()
}