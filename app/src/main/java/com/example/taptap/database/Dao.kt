package com.example.taptap.database

import androidx.room.*

/** Defines the methods for accessing the DB aka
 * provides the methods that the rest of the app uses to interact with data in the high_score_db table.*/
@Dao
interface HighScoreDao {

    @Query("SELECT * FROM high_scores_db")
    suspend fun getAll(): List<HighScoreDB>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertHighScore (highScoreDB: HighScoreDB)

    @Query("delete from high_scores_db")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteHighScore (highScoreDB: HighScoreDB)
}