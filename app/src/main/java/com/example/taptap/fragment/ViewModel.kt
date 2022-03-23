package com.example.taptap.fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taptap.model.HighScore

class ViewModel(application: Application) : AndroidViewModel(application) {


    private var _highScoreList = MutableLiveData<ArrayList<HighScore>>()        //backing field (private)
    val highScoreList: LiveData<ArrayList<HighScore>> get() = _highScoreList    //backing property (public, read only)
}