package day03

import java.io.File

const val INPUT = "src/main/resources/day03/input.txt"

fun main() {
    println(countRucksackPriorities(File(INPUT)))

    println(countGroupRucksackPriorities(File(INPUT)))
}

fun countRucksackPriorities(file: File): Int {
    val lines = file.readLines()
    var total = 0

    lines.forEach {
        val middle = it.length / 2
        val part1 = it.substring(0, middle)
        val part2 = it.substring(middle)

        val duplicate = findCommonCharacter(part1, part2)

        total += calculatePriority(duplicate)
    }

    return total
}

fun countGroupRucksackPriorities(file: File): Int {
    val lines = file.readLines()
    val group: MutableList<String> = ArrayList()
    var total = 0

    lines.forEach {
        group.add(it)

        if (group.size == 3) {
            val duplicate = findCommonCharacter3Strings(group[0], group[1], group[2])
            total += calculatePriority(duplicate)

            group.clear()
        }
    }

    return total
}

fun findCommonCharacter(first: String, second: String): Char {
    for (ch1 in first.toCharArray()) {
        for (ch2 in second.toCharArray()) {
            if (ch1 == ch2) {
                return ch1
            }
        }
    }

    return '0'
}

fun findCommonCharacter3Strings(first: String, second: String, third: String): Char {
    for (ch1 in first.toCharArray()) {
        for (ch2 in second.toCharArray()) {
            for (ch3 in third.toCharArray()) {
                if (ch1 == ch2 && ch2 == ch3) {
                    return ch1
                }
            }
        }
    }

    return '0'
}

fun calculatePriority(char: Char): Int {
    return if (Character.isLowerCase(char)) {
        char.code - 96
    } else {
        char.code - 65 + 27
    }
}