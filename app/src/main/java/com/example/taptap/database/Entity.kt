package com.example.taptap.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taptap.model.HighScore

/** Defines the schema of the database, aka the fields of every entity in the DB
 * Each instance of HighScoreDB represents a row in a high scores table in the app's database.*/
@Entity(tableName = "high_scores_db")
data class HighScoreDB (
    @PrimaryKey (autoGenerate = true)
    val score: Int,
    val name: String

    )

/** Map Database High Scores to domain entities = convert HighScoreDB objects into domain objects.*/
fun List<HighScoreDB>.asDomainModel(): List<HighScore> {
    return map {
        HighScore(
            name = it.name,
            score = it.score
        )
    }
}

/** Convert domain object to DB object*/
fun HighScore.asDBModel(): HighScoreDB {
    return HighScoreDB(score, name)
}