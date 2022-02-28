package com.example.dogsapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dogsapplication.data.db.dao.DogDao
import com.example.dogsapplication.data.model.DogModelItem

@Database(entities = [DogModelItem::class], version = 1)
abstract class DogDb : RoomDatabase(){
     abstract fun getDogDao(): DogDao
}