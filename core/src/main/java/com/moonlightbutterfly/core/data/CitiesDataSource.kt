package com.moonlightbutterfly.core.data

import com.moonlightbutterfly.core.models.City

interface CitiesDataSource {
    fun getCities(): List<City>
}