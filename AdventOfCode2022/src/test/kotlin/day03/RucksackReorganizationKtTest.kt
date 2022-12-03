package day03

import org.testng.Assert.assertEquals
import org.testng.annotations.Test
import java.io.File

internal class RucksackReorganizationKtTest {

    private val input = "src/test/resources/day03/input.txt"

    @Test
    fun testCountRucksackPriorities() {
        assertEquals(countRucksackPriorities(File(input)), 157)
    }

    @Test
    fun testCountGroupRucksackPriorities() {
        assertEquals(countGroupRucksackPriorities(File(input)), 70)
    }
}