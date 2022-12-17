package com.example.myroomfloria.advance

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Owner4(@PrimaryKey val ownerId: Long, val name: String)