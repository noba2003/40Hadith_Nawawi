package com.example.a40hadithnawawi.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "explanation_hadith",
    foreignKeys = [ForeignKey(
        entity = Hadith::class,
        parentColumns = ["id_hadith"],
        childColumns = ["id_hadithFK"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ExplanationHadith(
    @PrimaryKey(autoGenerate = true) val id_explanation_hadith: Int = 0,
    val book_name: String,
    val explanation: String,
    val id_hadithFK: Int
)
