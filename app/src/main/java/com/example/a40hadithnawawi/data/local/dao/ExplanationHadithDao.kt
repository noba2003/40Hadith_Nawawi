package com.example.a40hadithnawawi.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.a40hadithnawawi.data.local.entities.ExplanationHadith
import kotlinx.coroutines.flow.Flow

@Dao
interface ExplanationHadithDao {
    @Query("SELECT * FROM explanation_hadith")
    fun getAllExplanations(): Flow<List<ExplanationHadith>>
    @Query("SELECT * FROM explanation_hadith WHERE id_explanation_hadith = :id")
    suspend fun getExplanationById(id: Int): Flow<ExplanationHadith>
    @Query("SELECT * FROM explanation_hadith WHERE book_name LIKE '%' || :query || '%'")
    suspend fun getExplanationByQuery(query: String): Flow<List<ExplanationHadith>>
    @Query("DELETE FROM explanation_hadith WHERE id_explanation_hadith = :id")
    suspend fun deleteExplanation(id: Int)
    @Query("UPDATE explanation_hadith SET book_name = :name WHERE id_explanation_hadith = :id")
    suspend fun updateExplanation(id: Int, name: String)
    @Query("DELETE FROM explanation_hadith")
    suspend fun deleteAllExplanations()
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExplanation(explanation: ExplanationHadith)
}