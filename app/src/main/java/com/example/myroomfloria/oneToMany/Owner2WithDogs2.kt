package com.example.myroomfloria.oneToMany

import androidx.room.Embedded
import androidx.room.Relation
import java.security.acl.Owner

data class Owner2WithDogs2(
    @Embedded val owner: Owner2,
    @Relation(
        parentColumn = "ownerId",
        entityColumn = "dogOwnerId"
    )
    val dogs: List<Dog2>
)