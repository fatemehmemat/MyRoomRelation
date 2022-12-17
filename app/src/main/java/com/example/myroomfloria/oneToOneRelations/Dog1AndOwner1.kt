package com.example.myroomfloria.oneToOneRelations

import androidx.room.Embedded
import androidx.room.Relation

data class Dog1AndOwner1(
    @Embedded val owner: Owner1,
    @Relation(
        parentColumn = "ownerId",
        entityColumn = "dogOwnerId"
    )
    val dog: Dog1
)