package com.example.a40hadithnawawi.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.a40hadithnawawi.data.local.entities.Sound
import kotlinx.coroutines.flow.Flow
@Dao

interface SoundDao {


    @Query("SELECT * FROM sound_hadith")
    fun getAllSounds(): Flow<List<Sound>>

    @Query("SELECT * FROM sound_hadith WHERE id_sound = :id")
    suspend fun getSoundById(id: Int): Sound

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSound(sound: Sound)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSounds(sounds: List<Sound>)

    @Query("DELETE FROM sound_hadith WHERE id_sound = :id")
    suspend fun deleteSound(id: Int)



    @Query("DELETE FROM sound_hadith")
    suspend fun deleteAllSounds()
}