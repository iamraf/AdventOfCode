package day01

import org.testng.Assert.assertEquals
import org.testng.annotations.Test
import java.io.File

internal class CalorieCountingKtTest {

    private val input = "src/test/resources/day01/input.txt"

    @Test
    fun testCountMostCalories() {
        assertEquals(countMostCalories(File(input)), 24000)
    }

    @Test
    fun testCountTop3MostCalories() {
        assertEquals(countTop3MostCalories(File(input)), 45000)
    }
}