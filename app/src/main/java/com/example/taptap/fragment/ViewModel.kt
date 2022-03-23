package com.example.taptap.fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.taptap.database.asDBModel
import com.example.taptap.database.asDomainModel
import com.example.taptap.database.getDB
import com.example.taptap.model.HighScore
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDB(application)

    private var _highScore = MutableLiveData<HighScore>()       //backing field (private)
    val highScore: LiveData<HighScore> get() = _highScore       //backing property (public, read only)

    private var _highScoreList = MutableLiveData<ArrayList<HighScore>>()        //backing field (private)
    val highScoreList: LiveData<ArrayList<HighScore>> get() = _highScoreList    //backing property (public, read only)

    /** Public methods */

            /** DB */
            fun getHighScores() {
                viewModelScope.launch {
                    getHighScoresFromDB()
                }
            }

            fun insertHighScore(currentScore: HighScore) {
                viewModelScope.launch {
                    insertHighScoreInDB(currentScore)
                }
            }

            fun deleteQuote (highScore: HighScore) {
                viewModelScope.launch {
                    deleteHighScoreFromDB(highScore)
                }
            }

    /** Private methods */

            /** DB */
            private suspend fun getHighScoresFromDB() {
                val highScoresFromDB = database.highScoreDao.getAll().asDomainModel()
                _highScoreList.value = ArrayList(highScoresFromDB)
            }

            private suspend fun insertHighScoreInDB(highScore: HighScore) {
                database.highScoreDao.insertHighScore(highScore.asDBModel())
            }

            private suspend fun deleteHighScoreFromDB(highScore: HighScore) {
                database.highScoreDao.deleteHighScore(highScore.asDBModel())
            }




}