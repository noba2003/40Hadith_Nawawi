package com.example.a40hadithnawawi.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Narrator")
data class Narrator(
    @PrimaryKey(autoGenerate = true) val id_narrator: Int = 0,
    val name_narrator: String,
    val Description: String
)