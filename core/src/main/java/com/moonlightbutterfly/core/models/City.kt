package com.moonlightbutterfly.core.models

data class City(
    val id: Long,
    val countryCode: String,
    val cityName: String,
    val coordinates: Coordinates
)