package com.example.taptap.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/** Defines the database configuration and serves as the app's main access point to the persisted data.*/

/** DB holder class*/
@Database(entities = [HighScoreDB::class], version = 1, exportSchema = false)
abstract class HighScoreRoomDatabase : RoomDatabase() {
    abstract val highScoreDao: HighScoreDao
}
/** Create an instance of the RoomDB*/

private lateinit var INSTANCE: HighScoreRoomDatabase

fun getDB(context: Context): HighScoreRoomDatabase {
    synchronized(RoomDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room
                .databaseBuilder(context.applicationContext, HighScoreRoomDatabase::class.java, "high_scores")
                .build()
        }
    }
    return INSTANCE
}