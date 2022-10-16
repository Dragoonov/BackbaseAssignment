package com.moonlightbutterfly.core.data

class CitiesRepository(private val citiesDataSource: CitiesDataSource) {
    fun getCities(page: Int, pageSize: Int, query: String?) =
        citiesDataSource.getCities(page, pageSize, query)
}