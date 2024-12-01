package com.example.a40hadithnawawi.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity(
    tableName = "sound_hadith",
    foreignKeys = [
        ForeignKey(
            entity = Hadith::class,
            parentColumns = ["id_hadith"],
            childColumns = ["id_hadith"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Sound::class,
            parentColumns = ["id"],
            childColumns = ["id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SoundHadith(
    @PrimaryKey(autoGenerate = true) val id_sound: Int = 0,
    val id_hadith: Int,
    val id: Int
)
