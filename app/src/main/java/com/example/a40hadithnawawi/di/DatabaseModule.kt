package com.example.a40hadithnawawi.di

import android.content.Context
import androidx.room.Room
import com.example.a40hadithnawawi.data.local.HadithDB
import com.example.a40hadithnawawi.data.local.dao.ExplanationHadithDao
import com.example.a40hadithnawawi.data.local.dao.HadithDao
import com.example.a40hadithnawawi.data.local.dao.NarratorDao
import com.example.a40hadithnawawi.data.local.dao.SoundDao
import com.example.a40hadithnawawi.data.local.dao.SoundHadithDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): HadithDB {
        return Room.databaseBuilder(
            context,
            HadithDB::class.java,
            "Hadith"
        ).build()
    }
    @Provides
    fun provideHadithDao(database: HadithDB): HadithDao {
        return database.hadithDao()
    }

    @Provides
    fun provideNarratorDao(database: HadithDB): NarratorDao {
        return database.narratorDao()
    }
    @Provides
    fun provideExplanationHadithDao(database: HadithDB): ExplanationHadithDao {
        return database.explanationHadithDao()
    }
    @Provides
    fun provideSoundDao(database: HadithDB): SoundDao {
        return database.soundDao()
    }

    @Provides
    fun provideSoundHadithDao(database: HadithDB): SoundHadithDao {
        return database.soundHadithDao()
    }






}