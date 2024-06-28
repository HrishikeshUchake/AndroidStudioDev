package com.example.countermvvm

data class CounterModel(var count: Int)

class counterRepository{
    private var _counter = CounterModel(0)
    fun getCounter() = _counter
    fun increment(){
        _counter.count++
    }
    fun decrement(){
        _counter.count--
    }
}