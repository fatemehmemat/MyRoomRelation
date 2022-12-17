package com.example.myroomfloria.oneToOneRelations

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Owner1(@PrimaryKey val ownerId: Long, val name: String)