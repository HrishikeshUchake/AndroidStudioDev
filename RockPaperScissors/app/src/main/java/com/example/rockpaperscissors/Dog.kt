package com.example.rockpaperscissors

class Dog (val name : String){

    fun bark(name: String){
        println("$name says woof woof")
    }
    init {
        bark(name)
    }

}