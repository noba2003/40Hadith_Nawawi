package com.example.a40hadithnawawi.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "sound")
data class Sound(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val Sheikh_name: String,
    val url: String
)
