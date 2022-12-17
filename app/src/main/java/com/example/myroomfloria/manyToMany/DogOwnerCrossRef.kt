package com.example.myroomfloria.manyToMany

import androidx.room.Entity

@Entity(primaryKeys = ["dogId", "ownerId"])
data class DogOwnerCrossRef(
    val dogId: Long,
    val ownerId: Long
)