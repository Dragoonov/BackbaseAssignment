package com.moonlightbutterfly.backbaseassignment.data.searchalgorithms

import com.moonlightbutterfly.core.models.City
import com.moonlightbutterfly.core.models.Coordinates
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class BinarySearchAlgorithmTest {
    private val algorithm = BinarySearchAlgorithm()

    private val testCollection = listOf(
        City(0,"", "Lask", Coordinates(.0,.0)),
        City(0,"", "slh", Coordinates(.0,.0)),
        City(0,"", "aadsfk", Coordinates(.0,.0)),
        City(0,"", "gsrtk", Coordinates(.0,.0)),
        City(0,"", "lkjf", Coordinates(.0,.0)),
        City(0,"", "zkjas", Coordinates(.0,.0)),
        City(0,"", "ewq", Coordinates(.0,.0)),
        City(0,"", "hjg", Coordinates(.0,.0)),
        City(0,"", "lef", Coordinates(.0,.0)),
        City(0,"", "af", Coordinates(.0,.0)),
        City(0,"", "234 kh", Coordinates(.0,.0)),
        City(0,"", "kkkk", Coordinates(.0,.0)),
    )

    @Before
    fun setup() {
        algorithm.loadCollection(testCollection) { city1, city2 ->
            city1.cityName.compareTo(city2.cityName, true)
        }
    }

    @Test
    fun `should return empty list on invalid results`() {
        // GIVEN WHEN
        var results = algorithm.filterCollection("[")
        // THEN
        assertEquals(0, results.size)

        // GIVEN WHEN
        results = algorithm.filterCollection("  ")
        // THEN
        assertEquals(0, results.size)

        // GIVEN WHEN
        results = algorithm.filterCollection("/<>")
        // THEN
        assertEquals(0, results.size)
    }

    @Test
    fun `should return filtered list on valid results`() {
        // GIVEN WHEN
        var results = algorithm.filterCollection("a")
        // THEN
        assertEquals(2, results.size)
        assertEquals("aadsfk", results[0].cityName)

        // GIVEN WHEN
        results = algorithm.filterCollection("l")
        // THEN
        assertEquals(3, results.size)
        assertEquals("Lask", results[0].cityName)

        // GIVEN WHEN
        results = algorithm.filterCollection("h")
        // THEN
        assertEquals(1, results.size)
        assertEquals("hjg", results[0].cityName)
    }
}