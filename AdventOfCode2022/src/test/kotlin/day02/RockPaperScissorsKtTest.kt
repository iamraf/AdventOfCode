package day02

import org.testng.Assert.assertEquals
import org.testng.annotations.Test
import java.io.File

internal class RockPaperScissorsKtTest {

    private val input = "src/test/resources/day02/input.txt"

    @Test
    fun testCountFirstStrategy() {
        assertEquals(countFirstStrategy(File(input)), 15)
    }

    @Test
    fun testCountSecondStrategy() {
        assertEquals(countSecondStrategy(File(input)), 12)
    }
}