package com.android.architecture

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * create by caiyx in 2021/5/17
 */
class MainViewModel : ViewModel() {

    var text = MutableLiveData<String>()
    var color = MutableLiveData<Int>()

    init {
        text.value = "aaa"
        color.value = Color.parseColor("#ff00ff")
    }

    fun onChangeText() {
        text.value = "${text.value}a"
    }

    fun onChangeColor() {
        val value = color.value
        if (value == Color.parseColor("#ff00ff")) {
            color.value = Color.parseColor("#ff0000")
        } else {
            color.value = Color.parseColor("#ff00ff")
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}