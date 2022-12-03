package day02

import java.io.File

const val INPUT = "src/main/resources/day02/input.txt"

fun main() {
    println(countFirstStrategy(File(INPUT)))

    println(countSecondStrategy(File(INPUT)))
}

fun countFirstStrategy(file: File): Int {
    val lines = file.readLines()
    var score = 0

    lines.forEach {
        val moves = it.split(" ")
        val player1 = moves[0].toCharArray()[0]
        val player2 = moves[1].toCharArray()[0]

        score += calculateScore(player1, player2)
    }

    return score
}

fun countSecondStrategy(file: File): Int {
    val lines = file.readLines()
    var score = 0

    lines.forEach {
        val moves = it.split(" ")
        val player1 = moves[0].toCharArray()[0]
        var player2 = moves[1].toCharArray()[0]

        when (player1) {
            'A' -> {
                when (player2) {
                    'X' -> player2 = 'Z'
                    'Y' -> player2 = 'X'
                    'Z' -> player2 = 'Y'
                }
            }

            'C' -> {
                when (player2) {
                    'X' -> player2 = 'Y'
                    'Y' -> player2 = 'Z'
                    'Z' -> player2 = 'X'
                }
            }
        }

        score += calculateScore(player1, player2)
    }

    return score
}

fun calculateScore(player1: Char, player2: Char): Int {
    var score = 0

    when (player2) {
        'X' -> score += 1
        'Y' -> score += 2
        'Z' -> score += 3
    }

    if ((player1 == 'A' && player2 == 'X') || (player1 == 'B' && player2 == 'Y') || (player1 == 'C' && player2 == 'Z')) {
        score += 3
    }

    if ((player1 == 'C' && player2 == 'X') || (player1 == 'B' && player2 == 'Z') || (player1 == 'A' && player2 == 'Y')) {
        score += 6
    }

    return score
}