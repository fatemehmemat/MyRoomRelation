package com.example.myroomfloria.oneToOneRelations

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dog1AndOwner1Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDog(dog: Dog1)



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOwner(owner: Owner1)


    @Query("SELECT * FROM Owner1")
    suspend fun getDogsAndOwners():List<Dog1AndOwner1>
}