package com.example.myroomfloria.advance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.myroomfloria.manyToMany.Dog3
import com.example.myroomfloria.manyToMany.DogOwnerCrossRef
import com.example.myroomfloria.manyToMany.Owner3
import com.example.myroomfloria.manyToMany.Owner3WithDogs3


@Dao
interface Dog4AndPupsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDog(dog: Dog4)



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOwner(owner: Owner4)



    @Transaction
    @Query("SELECT * FROM Owner4")
    suspend fun get(): List<OwnerWithPups>

    @Transaction
    @Query("SELECT * FROM Owner4")
    suspend fun getOwner(): List<OwnerWithDogs>
}