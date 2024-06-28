package com.example.countermvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _counter = mutableStateOf(0)
    val count: MutableState<Int> = _counter
    fun increment(){
        _counter.value++
    }
    fun decrement(){
        _counter.value--
    }
}