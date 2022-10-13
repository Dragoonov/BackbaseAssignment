package com.moonlightbutterfly.core.data

class CitiesRepository(private val citiesDataSource: CitiesDataSource) {

    fun getCities() = citiesDataSource.getCities()
}