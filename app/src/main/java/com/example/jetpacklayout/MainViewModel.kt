package com.example.jetpacklayout

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val textFieldValue = MutableLiveData("")

    fun onTxtChange(value: String){
        textFieldValue.value = value
    }
}