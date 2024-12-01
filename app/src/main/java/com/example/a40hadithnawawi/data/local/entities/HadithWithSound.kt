package com.example.a40hadithnawawi.data.local.entities

import androidx.room.Embedded

data class HadithWithSound(@Embedded val hadith: Hadith,
                           @Embedded val sound: Sound)
