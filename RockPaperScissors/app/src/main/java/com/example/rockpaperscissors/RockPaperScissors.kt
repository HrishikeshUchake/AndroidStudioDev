package com.example.rockpaperscissors

fun main(){

    var computerChoice = ""
    var playerChoice = ""
    println("Rock, Paper or Scissors? Enter your choice!")
    playerChoice = readln()
    val randomNumber = (1..3).random()

    when (randomNumber){
        1 -> {
            computerChoice = "Rock"
        }
        2 -> {
            computerChoice = "Paper"
        }
        3 -> {
            computerChoice = "Scissors"
        }
    }

    println("Computer chose: " + computerChoice)

    val winner = when{
        playerChoice == computerChoice -> "tie"
        playerChoice == "Rock" && computerChoice == "Scissors" -> "Player(you)"
        playerChoice == "Paper" && computerChoice == "Rock" -> "Player(you)"
        playerChoice == "Scissors" && computerChoice == "Paper" -> "Player(you)"
        else -> "Computer"
    }

    if(winner == "tie"){
        println("tie")
    }
    else {
        println("The winner is " + winner)
    }
}