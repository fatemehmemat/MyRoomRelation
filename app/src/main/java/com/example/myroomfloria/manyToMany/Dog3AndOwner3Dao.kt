package com.example.myroomfloria.manyToMany

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.myroomfloria.oneToMany.Owner2
import com.example.myroomfloria.oneToMany.Owner2WithDogs2

@Dao
interface Dog3AndOwner3Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDog(dog: Dog3)



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOwner(owner: Owner3)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOwnerDogCrossRef(crossRef: DogOwnerCrossRef)

    @Transaction
    @Query("SELECT * FROM Owner3")
    suspend fun get(): List<Owner3WithDogs3>
}