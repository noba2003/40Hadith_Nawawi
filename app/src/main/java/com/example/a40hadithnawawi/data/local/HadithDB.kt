package com.example.a40hadithnawawi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a40hadithnawawi.data.local.dao.ExplanationHadithDao
import com.example.a40hadithnawawi.data.local.dao.HadithDao
import com.example.a40hadithnawawi.data.local.dao.NarratorDao
import com.example.a40hadithnawawi.data.local.dao.SoundDao
import com.example.a40hadithnawawi.data.local.dao.SoundHadithDao
import com.example.a40hadithnawawi.data.local.entities.ExplanationHadith
import com.example.a40hadithnawawi.data.local.entities.Hadith
import com.example.a40hadithnawawi.data.local.entities.Narrator
import com.example.a40hadithnawawi.data.local.entities.Sound
import com.example.a40hadithnawawi.data.local.entities.SoundHadith

@Database(entities = [Hadith::class,
    ExplanationHadith::class,Narrator::class,
    Sound::class,
    SoundHadith::class], version = 1,exportSchema = true)
abstract class HadithDB : RoomDatabase() {
    abstract fun hadithDao(): HadithDao
    abstract fun explanationHadithDao(): ExplanationHadithDao
    abstract fun narratorDao(): NarratorDao
    abstract fun soundDao(): SoundDao
    abstract fun soundHadithDao(): SoundHadithDao
    companion object {
        const val DATABASE_NAME = "hadith_db"
    }

}


