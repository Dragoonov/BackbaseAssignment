package com.moonlightbutterfly.core.models

import java.io.Serializable

data class City(
    val id: Long,
    val countryCode: String,
    val cityName: String,
    val coordinates: Coordinates,
) : Serializable