package com.example.a40hadithnawawi.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.a40hadithnawawi.data.local.entities.HadithWithSound
import com.example.a40hadithnawawi.data.local.entities.SoundHadith
import kotlinx.coroutines.flow.Flow

@Dao
interface SoundHadithDao {
    @Query("SELECT * FROM sound_hadith")
    fun getAllSounds(): Flow<List<SoundHadith>>
    @Query("SELECT * FROM sound_hadith WHERE id_sound = :id")
    suspend fun getSoundById(id: Int): SoundHadith
    @Query("DELETE FROM sound_hadith WHERE id_sound = :id")
    suspend fun deleteSound(id: Int)
    @Query("DELETE FROM sound_hadith")
    suspend fun deleteAllSounds()
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSound(sound: SoundHadith)


    @Query("SELECT h.*, s.Sheikh_name, s.url FROM sound_hadith sh " +
            "INNER JOIN hadith h ON sh.id_hadith = h.id_hadith " +
            "INNER JOIN sound s ON sh.id = s.id " +
            "WHERE h.id_hadith = :hadithId")
    suspend fun getHadithWithSound(hadithId: Int): Flow<HadithWithSound>


}