package com.example.myroomfloria.manyToMany

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Owner3(@PrimaryKey val ownerId: Long, val name: String)