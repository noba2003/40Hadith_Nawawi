package com.example.a40hadithnawawi.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.a40hadithnawawi.data.local.entities.Narrator
import kotlinx.coroutines.flow.Flow
@Dao

interface NarratorDao {
    @Query("SELECT * FROM narrator")
    suspend fun getAllNarrators():Flow<List<Narrator>>
    @Query("SELECT * FROM narrator WHERE id_narrator = :id")
    suspend fun getNarratorById(id: Int): Flow<Narrator>
    @Query("SELECT * FROM narrator WHERE name_narrator LIKE '%' || :query || '%'")
    suspend fun getNarratorByQuery(query: String): Flow<List<Narrator>>

    @Query("DELETE FROM narrator WHERE id_narrator = :id")
    suspend fun deleteNarrator(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNarrator(narrator: Narrator)

    @Query("DELETE FROM narrator")
    suspend fun deleteAllNarrators()

    @Query("UPDATE narrator SET name_narrator = :name WHERE id_narrator = :id")
    suspend fun updateNarrator(id: Int, name: String)




}