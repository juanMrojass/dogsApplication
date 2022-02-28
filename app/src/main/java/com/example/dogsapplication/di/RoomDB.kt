package com.example.dogsapplication.di

import android.content.Context
import androidx.room.Room
import com.example.dogsapplication.data.db.DogDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDB {
    private const val DOG_DATABASE= "dog_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, DogDb::class.java, DOG_DATABASE).build()

    @Singleton
    @Provides
    fun providesDogDao(db: DogDb) = db.getDogDao()
}