package com.example.myroomfloria.advance

import androidx.room.Embedded
import androidx.room.Relation
import java.security.acl.Owner

data class OwnerWithPups(
    @Embedded val owner: Owner4,
    @Relation(
        parentColumn = "ownerId",
        entity = Dog4::class,
        entityColumn = "dogOwnerId"
    )
    val dogs: List<Pup>
)