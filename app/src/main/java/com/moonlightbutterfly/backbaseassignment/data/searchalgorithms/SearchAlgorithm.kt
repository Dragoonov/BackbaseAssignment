package com.moonlightbutterfly.backbaseassignment.data.searchalgorithms

import com.moonlightbutterfly.core.models.City

interface SearchAlgorithm {
    fun loadCollection(list: List<City>, comparator: Comparator<City>)
    fun getCollection(): List<City>
    fun filterCollection(query: String): List<City>
}