package day01

import java.io.File

const val INPUT = "src/main/resources/day01/input.txt"

fun main() {
    println(countMostCalories(File(INPUT)))

    println(countTop3MostCalories(File(INPUT)))
}

fun countMostCalories(file: File): Int {
    val lines = file.readLines()
    var current = 0
    var max = 0

    lines.forEachIndexed { index, s ->
        if (s.isEmpty() || index == lines.size - 1) {
            if (current > max) {
                max = current
            }

            current = 0
        } else {
            current += s.toInt()
        }
    }

    return max
}

fun countTop3MostCalories(file: File): Int {
    val lines = file.readLines()
    val elfs: MutableList<Int> = ArrayList()
    var current = 0

    lines.forEachIndexed { index, s ->
        if (s.isEmpty() || index == lines.size - 1) {
            elfs.add(current)
            current = 0
        } else {
            current += s.toInt()
        }
    }

    return elfs.stream()
        .sorted(Comparator.reverseOrder())
        .limit(3)
        .reduce(0, Integer::sum)
}