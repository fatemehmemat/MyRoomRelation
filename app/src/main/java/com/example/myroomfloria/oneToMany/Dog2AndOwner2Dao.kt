package com.example.myroomfloria.oneToMany

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface Dog2AndOwner2Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDog(dog: Dog2)



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOwner(owner: Owner2)


    @Transaction
    @Query("SELECT * FROM Owner2")
    suspend fun get(): List<Owner2WithDogs2>
}