package com.aulasandroid.quizgame.Session

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SessionViewModel: ViewModel() {
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    fun onUserNameChange (newUserName: String){
        _userName.value = newUserName
    }
}