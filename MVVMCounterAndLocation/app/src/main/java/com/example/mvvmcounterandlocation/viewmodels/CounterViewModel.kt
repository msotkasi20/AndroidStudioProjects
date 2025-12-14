package com.example.mvvmcounterandlocation.viewmodels

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    private val _count = mutableIntStateOf(0)

    val count: String
        get() = _count.intValue.toString()

    fun increment() {
        _count.intValue++
    }
}