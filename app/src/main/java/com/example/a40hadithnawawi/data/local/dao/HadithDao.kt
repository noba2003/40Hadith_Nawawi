package com.example.a40hadithnawawi.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.a40hadithnawawi.data.local.entities.Hadith
import com.example.a40hadithnawawi.data.local.entities.HadithWithSound
import kotlinx.coroutines.flow.Flow
@Dao

interface HadithDao {
    @Query("SELECT * FROM hadith")
    suspend fun getAllHadith(): Flow<List<Hadith>>
    @Query("SELECT * FROM hadith WHERE id_hadith = :id")
    suspend fun getHadithById(id: Int): Flow<Hadith>
    @Query("SELECT * FROM hadith WHERE text_hadith LIKE '%' || :query || '%'")
    suspend fun searchHadith(query: String): Flow<List<Hadith>>
    @Query("SELECT * FROM hadith WHERE NarratorFK = :narratorId")
    suspend fun getHadithByNarrator(narratorId: Int): Flow<List<Hadith>>

    @Query("""
    SELECT h.* 
    FROM hadith h 
    INNER JOIN explanation_hadith e ON h.id_hadith = e.id_hadithFK 
    WHERE e.id_hadithFK = :explanation
""")
    suspend fun searchHadithByExplanation(explanation: Int): Flow<List<Hadith>>

    @Query("""
    SELECT h.*, s.id_sound
    FROM hadith h
    INNER JOIN sound_hadith s ON h.id_hadith = s.id_hadith
    WHERE h.id_hadith = :hadithId
""")
    suspend fun getHadithWithSound(hadithId: Int): Flow<HadithWithSound>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHadith(hadith: Hadith)
    @Query("DELETE FROM hadith WHERE id_hadith = :id")
    suspend fun deleteHadith(id: Int)
    @Query("UPDATE hadith SET text_hadith = :text WHERE id_hadith = :id")
    suspend fun updateHadith(id: Int, text: String)
    @Query("DELETE FROM hadith")
    suspend fun deleteAllHadith()
}