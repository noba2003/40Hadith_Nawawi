package com.example.a40hadithnawawi.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Hadith")
data class Hadith(
    @PrimaryKey(autoGenerate = true) val id_hadith: Int = 0,
    val text_hadith: String,
    val sound: String?,
    val NarratorFK: Int
)