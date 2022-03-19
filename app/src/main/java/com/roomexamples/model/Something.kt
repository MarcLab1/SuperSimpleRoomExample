package com.roomexamples.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Something(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0, val name: String = "Fake", val isGood: Boolean = true )
