package com.example.myroomfloria.oneToOneRelations

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dog1(
    @PrimaryKey val dogId: Long,
    val dogOwnerId: Long,
    val name: String,
    val cuteness: Int,
    val barkVolume: Int,
    val breed: String
)