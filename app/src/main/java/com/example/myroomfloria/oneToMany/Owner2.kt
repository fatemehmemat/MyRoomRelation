package com.example.myroomfloria.oneToMany

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Owner2(@PrimaryKey val ownerId: Long, val name: String)