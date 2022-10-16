package com.moonlightbutterfly.backbaseassignment.data.searchalgorithms

import com.moonlightbutterfly.core.models.City
import javax.inject.Inject

class DummySearchAlgorithm @Inject constructor(): SearchAlgorithm {

    private lateinit var collection: List<City>

    override fun loadCollection(list: List<City>, comparator: Comparator<City>) {
        collection = list.sortedWith(comparator)
    }

    override fun getCollection(): List<City> {
        return collection.toList()
    }

    override fun filterCollection(
        query: String
    ): List<City> {
        return collection.filter {
            it.cityName.startsWith(query, true)
        }
    }
}