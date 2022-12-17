package com.example.myroomfloria.manyToMany

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import java.security.acl.Owner

data class Owner3WithDogs3(
    @Embedded val owner: Owner3,
    @Relation(
        parentColumn = "ownerId",
        entityColumn = "dogId",
        associateBy = Junction(DogOwnerCrossRef::class)
    )
    val dogs: List<Dog3>
)