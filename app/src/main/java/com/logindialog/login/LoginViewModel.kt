package com.logindialog.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {


    val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> get() = _status

    fun login(mobile: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            if (mobile == "1111" && password == "1111") {
                delay(3000)
                _status.postValue(true)
            } else {
                delay(3000)
                _status.postValue(false)
            }
        }
    }
}