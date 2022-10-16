package com.moonlightbutterfly.backbaseassignment.data.searchalgorithms

import com.moonlightbutterfly.core.models.City
import javax.inject.Inject

class FastSearchAlgorithm @Inject constructor() : SearchAlgorithm {

    private lateinit var collection: Array<City>
    private lateinit var comparator: Comparator<City>
    private val queryMap: MutableMap<String, List<City>> = mutableMapOf()

    override fun loadCollection(list: List<City>, comparator: Comparator<City>) {
        collection = list.sortedWith(comparator).toTypedArray()
        this.comparator = comparator
    }

    override fun getCollection(): List<City> {
        return collection.toList()
    }

    override fun filterCollection(query: String): List<City> {
        return queryMap.getOrPut(query.lowercase()) {
            val firstIndex = findFirstMatchingIndex(query)
            if (firstIndex < 0) {
                return emptyList()
            }
            val lastIndex = findLastMatchingIndex(query)
            collection.sliceArray(IntRange(firstIndex, lastIndex)).toList()
        }
    }

    private fun findFirstMatchingIndex(query: String): Int {
        var firstIndex = -1
        var tempCollection = collection.copyOf()
        if (tempCollection[0].cityName.startsWith(query, true)) {
            return 0
        }
        var middleIndex = tempCollection.size / 2
        var middleItem = tempCollection[middleIndex]
        var offset = 0
        while (firstIndex < 0 && tempCollection.size >= 2) {
            val comparison = query.compareTo(middleItem.cityName, true)
            if (comparison > 0) {
                if (collection[middleIndex + 1 + offset].cityName.startsWith(query, true)) {
                    firstIndex = middleIndex + 1 + offset
                } else {
                    tempCollection = tempCollection.sliceArray(IntRange(middleIndex,
                        tempCollection.size - 1))
                    offset += middleIndex
                    middleIndex = tempCollection.size / 2
                    middleItem = tempCollection[middleIndex]
                }
            } else {
                tempCollection = tempCollection.sliceArray(IntRange(0, middleIndex - 1))
                middleIndex = tempCollection.size / 2
                middleItem = tempCollection[middleIndex]
            }
        }
        return firstIndex
    }

    private fun findLastMatchingIndex(query: String): Int {
        var lastIndex = -1
        var tempCollection = collection.copyOf()
        if (tempCollection[tempCollection.size-1].cityName.startsWith(query, true)) {
            return collection.size-1
        }
        var middleIndex = tempCollection.size / 2
        var middleItem = tempCollection[middleIndex]
        var offset = 0
        while (lastIndex < 0 && tempCollection.size >= 2) {
            val comparison = query.compareTo(middleItem.cityName, true)
            if (comparison > 0 || tempCollection[middleIndex].cityName.startsWith(query, true)) {
                tempCollection = tempCollection.sliceArray(IntRange(middleIndex,
                    tempCollection.size - 1))
                offset += middleIndex
                middleIndex = tempCollection.size / 2
                middleItem = tempCollection[middleIndex]
            } else {
                if (collection[middleIndex - 1 + offset].cityName.startsWith(query, true)) {
                    lastIndex = middleIndex - 1 + offset
                } else {
                    tempCollection = tempCollection.sliceArray(IntRange(0, middleIndex - 1))
                    middleIndex = tempCollection.size / 2
                    middleItem = tempCollection[middleIndex]
                }
            }
        }
        return lastIndex
    }
}